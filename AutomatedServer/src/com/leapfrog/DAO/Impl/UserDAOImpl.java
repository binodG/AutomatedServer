/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.DAO.Impl;

import com.leapfrog.DAO.UserDAO;
import com.leapfrog.Entity.Users;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BkoNod
 */
public class UserDAOImpl implements UserDAO {
List<Users> userList=new ArrayList<>();

    @Override
    public void addUsers(Users user) {
      userList.add(user);
    
    }

    @Override
    public List<Users> getAll() {
       userList.add(new Users(1,"a","a"));
       userList.add(new Users(2,"b","b"));
       userList.add(new Users(3,"c","c"));
       return userList;   
    }

    @Override
    public Users getUser(String username,String password) {
            for(Users user:getAll())
            {
              if(user.getUsername().equals(username) && user.getPassword().equals(password))
                  return user;
            }
            return null;
    }
    
}
