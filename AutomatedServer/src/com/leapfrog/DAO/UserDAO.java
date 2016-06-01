/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.DAO;

import com.leapfrog.Entity.Users;
import java.util.List;

/**
 *
 * @author BkoNod
 */
public interface UserDAO{ 
        void addUsers(Users user); 
        List<Users> getAll();
        Users getUser(String username,String password);
}
