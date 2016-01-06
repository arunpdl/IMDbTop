/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.imdbtop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author aruun
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        String link="http://www.imdb.com/chart/top?ref_=nv_mv_250_6";
        String line="";
        URL url=new URL(link);
        URLConnection conn=url.openConnection();
        BufferedReader reader=new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder builder=new StringBuilder();
        while((line=reader.readLine())!=null) {
        builder.append(line);
        }
        reader.close();
        
        
        //String regex="<td class=\"titleColumn\">\n\\s+(.*?)\n\\s+<a href=(.*?)\\s+title=\"(.*?)\" >(.*?)</a>";//\\n\\s+<span class=\"secondaryInfo\">(.*?)</span>\\n\\s+</td>\\n\\s+<td class=\"ratingColumn imdbRating\">\\n\\s+<strong title=\"(.*?)\">";
        String regex="<td class=\"titleColumn\">(.*?)<a href=\"(.*?)\"title=\"(.*?)\" >(.*?)</a>"; //<td class=\"ratingColumn imdbRating\"><strong title=\"(.*?)\"></strong></td>";
        //String regex2="<td class=\"ratingColumn imdbRating\"><strong title=\"(.*?)\"></strong></td>";
        Pattern pattern=Pattern.compile(regex);
        //Pattern pattern2=Pattern.compile(regex2);
        //System.out.println("Name:                    Ratings:");
        Matcher matcher=pattern.matcher(builder.toString());
        //Matcher matcher2=pattern2.matcher(builder.toString());
        /* =
        while(matcher.find() && matcher2.find()) {
            System.out.println(matcher.group(1).trim()+matcher.group(4).trim());
            System.out.println(matcher2.group(1));
        }
                */
        while(matcher.find()){
        System.out.println(matcher.group(1).trim()+matcher.group(4).trim());
        //System.out.println(matcher.group(1).trim()+matcher.group(4).trim()+matcher.group(5).trim());
        //System.out.println(matcher.group(6).trim());
        System.out.println("--------------------------------------------------------------------------");
        //System.out.println(matcher2.group(1));
        }
        }
    }
    

