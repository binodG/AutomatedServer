/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.Command;

/**
 *
 * @author BkoNod
 */
public class CommandFactory {
    
    public static Command getInstance(String[] param)
        
    {
       if(param[0].equalsIgnoreCase("search") && param[1].equalsIgnoreCase("jobsnepal"))
       {
         return new SearchJobNepal();
       }
       else if(param[0].equalsIgnoreCase("search") && param[1].equalsIgnoreCase("merojob"))
       {
         return new MeroJob();
       }
       else if(param[0].equalsIgnoreCase("mail"))
       {
         return new SendMail();
       }
        
    return null;
    }
    
}
