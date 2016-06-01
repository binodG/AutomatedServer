/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.Handler;

import com.leapfrog.Command.Command;
import com.leapfrog.Command.CommandFactory;
import com.leapfrog.DAO.ClientDAO;
import com.leapfrog.DAO.Impl.UserDAOImpl;
import com.leapfrog.DAO.UserDAO;
import com.leapfrog.Entity.Client;
import com.leapfrog.Entity.Users;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 *
 * @author BkoNod
 */
public class ClientHandler extends Thread {

    private Socket clientSocket;
    private PrintStream ps;
    private BufferedReader reader;
    private ClientDAO clientHandler;
   
    public ClientHandler(Socket clientSocket, ClientDAO clientDao) throws IOException {
        this.clientSocket = clientSocket;
        this.clientHandler = clientDao;
       
        ps = new PrintStream(clientSocket.getOutputStream());
        reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    @Override
    public void run() {
        try {
            while (!doLogin()) {
                ps.println("Invalid UserName/Password");
            }
            ps.println("Enter command:");
            String line = "";
            while (true) {
                line=reader.readLine();
                if (line != null) {
                    String[] tokens = line.split(";;");
                   
                    Command cmd = CommandFactory.getInstance(tokens);
                    if (cmd != null) {
                        cmd.setClientHandler(clientHandler);
                        Client client=clientHandler.getBySocket(clientSocket);
                        cmd.execute(client,tokens);
                    }
                    
                }
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public boolean doLogin() throws IOException {
        UserDAO userDAO = new UserDAOImpl();
        while (true) {

            ps.println("Enter USerName/Password");
            ps.println("User Name: ");
            String username = reader.readLine();
            ps.println("Password: ");
            String password = reader.readLine();
            Users user = userDAO.getUser(username, password);

            if (user != null) {
                Client client = new Client(username, clientSocket);
                clientHandler.addUser(client);
                return true;

            }

        }
    }
    
    
    

}
