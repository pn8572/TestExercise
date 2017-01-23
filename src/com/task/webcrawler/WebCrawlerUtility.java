package com.task.webcrawler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author prasanth.pillai
 * @version 1.0
 *
 */
public class WebCrawlerUtility 
{

	public static void main(String[] args) throws Exception
	{
	    String urls[] = new String[1000];
	    String url = "http://wiprodigital.com";
	    int i=0,j=0,tmp=0,total=0, MAX = 1000;
	    int start=0, end=0;
	    String webpage = Web.getWeb(url);
	    end = webpage.indexOf("<body");
	    
	    for (i=total;i<MAX; i++, total++)
	    {
	        start = webpage.indexOf("http://", end);
	        if(start == -1)
	        {
	            start = 0;
	            end = 0;
	            try
	            {
	            	webpage = Web.getWeb(urls[j++]);
	            }
	            catch(Exception e)
	            {
	                System.out.println("******************");
	                System.out.println(urls[j-1]);
	                System.out.println("Exception caught \n"+e);
	            }

	            /*logic to fetch urls out of body of webpage only */
	            end = webpage.indexOf("<body");
	            if (end == -1)
	            {
	               end = start = 0;
	               continue;
	            }       
	        }
	        end = webpage.indexOf("\"", start);
	        tmp = webpage.indexOf("'", start);
	        if (tmp < end && tmp != -1) 
	        {
	            end = tmp;
	        }
	        
	        if ( start>0 && end>0 )
	        {
	        	url = webpage.substring(start, end);
	        	urls[i] = url;
	        }
	    } 
	    
	    Set<String> test = new HashSet<String>(Arrays.asList(urls));
	    for (String s:test)
	    	System.out.println(s);
	    
	    System.out.println("Total URLS accessed are " + test.size());
	 }
}



	/*
	 * 	This class contains a static function which will fetch the webpage
	 *	of the given url and return as a string 
	 */
	class Web
	{
	    public static String getWeb(String address)throws Exception
	    {
	    	String webpage = "";
	        String inputLine = "";
	        URL url = new URL(address);
	        BufferedReader in = new BufferedReader(
	        new InputStreamReader(url.openStream()));
	        while ((inputLine = in.readLine()) != null)
	        webpage += inputLine;
	        in.close();
	        
	        return webpage;
	    }

}
