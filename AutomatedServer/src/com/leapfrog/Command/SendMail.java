/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.Command;

import com.leapfrog.Entity.Client;
import java.io.IOException;
import java.io.PrintStream;
import java.net.PasswordAuthentication;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author BkoNod
 */
public class SendMail extends Command {

    @Override
    public void execute(Client client, String[] param) {
       PrintStream ps = null;
       String msg="";
       String title="";
       int valid=0;
        try {

            ps = new PrintStream(client.getSocket().getOutputStream());
            if(param.length<=2)
            {
             ps.println("You must specify title and message too e.g email;;abc@gmail.com;;title;;message");
             valid=valid+1;
              
            }
            else if(param.length==3)
            {
               msg=param[2];
              
            }
            else if(param.length==4)
            {
                title=param[2];
                msg=param[3];
            }
            
            if(valid==0)
            {
            final String username="automatedservermail@gmail.com";
            final String password="123456789P";
            Properties props=new Properties();
            props.put("mail.smtp.auth","true");
            props.put("mail.smtp.starttls.enable","true");
            props.put("mail.smtp.host","smtp.gmail.com");
            props.put("mail.smtp.auth","true");
            props.put("mail.smtp.port","587");
            Session session = Session.getInstance(props, new javax.mail.Authenticator() {
                protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                    return new javax.mail.PasswordAuthentication(username, password);
                }
            });
            try {
                
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("automatedservermail@gmail.com"));
                message.setRecipients(Message.RecipientType.TO,
                        InternetAddress.parse(param[1]));
                message.setSubject(title);
                message.setText(msg);
                
                Transport.send(message);
                ps.println("message send successfully :) ");
                System.out.println("Done");
                
            } catch (Exception e) {
                ps.println(e.getMessage());
                System.out.println(e);
            }
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }  
        
        
        
    }
    
}
