/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.Entity;

import java.net.Socket;

/**
 *
 * @author BkoNod
 */
public class Client {
    private String username;
    private Socket socket;

    public Client(String username, Socket socket) {
        this.username = username;
        this.socket = socket;
    }
    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
    
}
