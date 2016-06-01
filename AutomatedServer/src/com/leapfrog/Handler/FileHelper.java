/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.Handler;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author BkoNod
 */
public class FileHelper {
    public static void writer(String filepath,List<String> data) throws IOException
    {
      try{
       BufferedWriter writer=new BufferedWriter(new FileWriter(filepath,true));
       for(String line:data)
       {
       writer.append(line+"\r\n");
       }
       writer.append("===============================================\r\n");
       writer.close();
      }catch(IOException ex)
      {
          System.out.println(ex.getMessage());
      }
      
      
      
}
}