/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.DAO;

import com.leapfrog.Entity.Client;
import java.net.Socket;

import java.util.List;

/**
 *
 * @author BkoNod
 */
public interface ClientDAO {
   public void addUser(Client c);
   List<Client> getALL();
   Client getBySocket(Socket socket);
   Client getByUserName(String username);
   
}
