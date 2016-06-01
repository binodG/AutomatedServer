/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.Handler;

import com.leapfrog.Entity.Client;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BkoNod
 */
public class RequestHandler {
    List<Client> clientList = new ArrayList<>();

    public void addClient(Client client) {
        clientList.add(client);

    }

    public List<Client> getAll() {
        return clientList;
    }

    public Client getByUsername(String Username) {
        for (Client c : clientList) {
            if (c.getUsername().equals(Username)) {
                return c;
            }

        }
        return null;

    }

    public Client getBySocket(Socket socket) {
        for (Client c : clientList) {
            if (c.getSocket().equals(socket)) {

                return c;
            }

        }
        return null;

    }

    public void removeUser(Client client) throws IOException {
        for (Client c : clientList) {
            if (c.getSocket().equals(client.getSocket())) {
                clientList.remove(c);
                
               
            }

        }
    }

    public void groupChat(Client client, String message) throws IOException {

        for (Client c : clientList) {
            if (!c.getUsername().equals(client.getUsername())) {
                PrintStream ps = new PrintStream(c.getSocket().getOutputStream());
                ps.println(message);
            }

        }

    }
    
    
    public void privateChat(Client to, String message) throws IOException {

        for (Client c : clientList) {
            if (c.getUsername().equals(to.getUsername())) {
                PrintStream ps = new PrintStream(c.getSocket().getOutputStream());
                ps.println(message);
            }

        }

    }

    
}
