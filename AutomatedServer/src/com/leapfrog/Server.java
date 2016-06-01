/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog;

import com.leapfrog.DAO.ClientDAO;
import com.leapfrog.DAO.Impl.ClientDAOImpl;
import com.leapfrog.Handler.ClientHandler;
import com.leapfrog.Handler.RequestHandler;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BkoNod
 */
public class Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
           
            ServerSocket server=new ServerSocket(9000);
            ClientDAO clientDao=new ClientDAOImpl();
           
            while(true)
            {
              
              Socket socket=server.accept();
              ClientHandler clientHandler=new ClientHandler(socket,clientDao);
              clientHandler.start();
            
            }
            
            
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
