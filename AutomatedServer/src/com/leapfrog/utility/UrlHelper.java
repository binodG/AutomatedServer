/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author BkoNod
 */
public class UrlHelper {
     
    
    public static String JNpost(String link, String keyword) throws IOException {

        URL url = new URL(link);
        HttpURLConnection httpcon = (HttpURLConnection) url.openConnection();
        httpcon.setDoOutput(true);
        OutputStream output = httpcon.getOutputStream();

        byte[] data = ("Keywords="+keyword).getBytes();
        output.write(data);

        StringBuilder content = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(httpcon.getInputStream()));
        String line = "";
        while ((line = reader.readLine()) != null) {
            content.append(line);

        }

        reader.close();
        return content.toString();

    }
    
    public static List<String> JNPatternM(String data) {
        String linkReg = "<a class=\"job-item\" (.*?) href=\"(.*?)\" >\\s(.*?)</a>";
        Pattern pattern = Pattern.compile(linkReg);
        Matcher matcher = pattern.matcher(data);
        List<String> list = new ArrayList<>();
        while (matcher.find()) {
            list.add(matcher.group(3).trim()+","+matcher.group(2));
            
        }
        return list;
        
    }
    
    public static List<String> MJPatternM(String data) {
        String linkReg = "<a href='(.*?)' class=\"thumbnail spacebot\" target=\"_blank\">";
        Pattern pattern = Pattern.compile(linkReg);
        Matcher matcher = pattern.matcher(data);
        List<String> list = new ArrayList<>();
        while (matcher.find()) {
            list.add(matcher.group(1).trim());
            
        }
        return list;
        
    }
    public static String pageGraber(String link) throws IOException {
        URL url = new URL(link);
        URLConnection con = url.openConnection();

        StringBuilder content = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String line = "";

        while ((line = reader.readLine()) != null) {
            content.append(line);
           
        }

        reader.close();
        return content.toString();
    }
public static List<String> JNPagePatternM(String data) {
        
        String linkReg = "<label>(.*?)</label>(.*?)\\s(.*?)<span>(.*?)</span>|<label>(.*?)</label>(.*?)\\s(.*?)<span>\\s(.*?)(.*?)</span>";
        Pattern pattern = Pattern.compile(linkReg);
        Matcher matcher = pattern.matcher(data);
        List<String> list = new ArrayList<>();
        while (matcher.find()) {
           list.add(matcher.group(1).trim()+": "+matcher.group(4).trim());
            
           }

        return list;
        
    }

public static List<String> MJPagePatternM(String data) {
        String linkReg = "<dt>(.*?)</dt>\\s(.*?)<dd>(.*?)</dd>";
        Pattern pattern = Pattern.compile(linkReg);
        Matcher matcher = pattern.matcher(data);
        List<String> list = new ArrayList<>();
        while (matcher.find()) {
             list.add(matcher.group(1)+""+matcher.group(3));
        }
        return list;
        
        
    }

    
    
}
