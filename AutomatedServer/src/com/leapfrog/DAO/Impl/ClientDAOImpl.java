/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.DAO.Impl;

import com.leapfrog.DAO.ClientDAO;
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
public class ClientDAOImpl implements ClientDAO {
List<Client> clientList=new ArrayList<>();
    @Override
    public List<Client> getALL() {
     return clientList;
    }

    @Override
    public Client getBySocket(Socket socket) {
        for(Client client:clientList)
        {
          if(client.getSocket().equals(socket))
          {
            return client;
          }
              
        }
        return null;
    }

    @Override
    public Client getByUserName(String username) {
            for(Client client:clientList)
        {
          if(client.getUsername().equals(username))
          {
            return client;
          }
              
        }
        return null;
    }

    @Override
    public void addUser(Client c) {
      clientList.add(c);
    }
    
    
    
   

    
}
