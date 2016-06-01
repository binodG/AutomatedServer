/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.Command;

import com.leapfrog.Entity.Client;
import com.leapfrog.Handler.FileHelper;
import com.leapfrog.utility.UrlHelper;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

/**
 *
 * @author BkoNod
 */
public class SearchJobNepal extends Command {

    @Override
    public void execute(Client client, String[] param) {
        PrintStream ps = null;
        try {
            String keyword = "";
            String filename = "";
            ps = new PrintStream(client.getSocket().getOutputStream());
            try {
                if (param.length >= 4) {
                    filename = param[3];
                    keyword = param[2];

                } else if (param.length >= 3) {
                    keyword = param[2];

                } else {
                    keyword = "";
                }

                String link = "http://www.jobsnepal.com/simple-job-search";
                String data = UrlHelper.JNpost(link, keyword);
                List<String> list = UrlHelper.JNPatternM(data);
                String[] urldata;
                for (String line : list) {

                    urldata = line.split(",");
                    String pageData = UrlHelper.pageGraber(urldata[urldata.length - 1]);
                    List<String> pagelist = UrlHelper.JNPagePatternM(pageData);
                    if (!filename.equalsIgnoreCase("")) {
                        FileHelper.writer(filename, pagelist);
                    }
                    System.out.println("==========================================");

                    ps.println("================================================");

                    for (String Datas : pagelist) {

                        ps.println(Datas);

                        System.out.println(Datas);

                    }
                    ps.println("================================================");

                    System.out.println("==========================================");
                }

            } catch (IOException ex) {

            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    /*public static void main(String[] args) {
        SearchJobNepal obj=new SearchJobNepal();
        String[] param={"search","jobnepal","java","c:\\"};
        obj.execute(param);
    }*/
}
