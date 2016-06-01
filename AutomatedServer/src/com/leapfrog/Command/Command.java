/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.Command;

import com.leapfrog.DAO.ClientDAO;
import com.leapfrog.Entity.Client;
import com.leapfrog.Handler.RequestHandler;
import java.io.PrintStream;

/**
 *
 * @author BkoNod
 */
public abstract class Command {
  
    protected ClientDAO clientHandler;
    public abstract void execute(Client client,String[] param);

   

    public void setClientHandler(ClientDAO clientHandler) {
        this.clientHandler = clientHandler;
    }

    

    
    
    
    
}
