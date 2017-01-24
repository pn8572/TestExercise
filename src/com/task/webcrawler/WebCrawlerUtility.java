package com.task.webcrawler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;

/**
 * 
 * @author prasanth.pillai
 * @version 1.0
 * 
 * The following logic is used for the web crawler.
 * 
 * Step 1: Retrieve a web page from a website (http://wiprodigital.com)
 * Step 2: Collect all the links on that web page
 * Step 3: Collect all the words on that document
 * Step 4: See if the word we're looking for is contained in the list of words, then display it. We can even store to file system or db if required.
 * Step 5: Visit the next link
 *
 */
public class WebCrawlerUtility 
{
	final static Logger logger = Logger.getLogger(WebCrawlerUtility.class);

	public static boolean getURLs(String url) throws Exception
	{
	    //String url = "http://wiprodigital.com";
	    String urls[] = new String[1000];
	    String webpage = PageUtil.getURLContent(url);
	    
	    int i=0,j=0,tmp=0,currentTotal=0, MAX = 1000;
	    int atartIndex=0, endIndex=0;
	    endIndex = webpage.indexOf("<body");
	    
	    for (i=currentTotal;i<MAX; i++, currentTotal++)
	    {
	        atartIndex = webpage.indexOf("http://", endIndex);
	        if(atartIndex == -1)
	        {
	            atartIndex = 0;
	            endIndex = 0;
	            try
	            {
	            	webpage = PageUtil.getURLContent(urls[j++]);
	            }
	            catch(Exception e)
	            {
	            	logger.error("******************");
	            	logger.error(urls[j-1]);
	            	logger.error("Exception caught \n"+e);
	            	return false;
	            }

	            /* logic to fetch urls out of body of web page only */
	            endIndex = webpage.indexOf("<body");
	            if (endIndex == -1)
	            {
	               endIndex = atartIndex = 0;
	               continue;
	            }       
	        }
	        endIndex = webpage.indexOf("\"", atartIndex);
	        tmp = webpage.indexOf("'", atartIndex);
	        if (tmp < endIndex && tmp != -1) 
	        {
	            endIndex = tmp;
	        }
	        
	        if ( atartIndex>0 && endIndex>0 )
	        {
	        	url = webpage.substring(atartIndex, endIndex);
	        	urls[i] = url;
	        }
	    } 
	    /*
	     * Using HashSet to avoid the duplicate urls from the list
	     * 
	     * Here we are just displaying the urls in the initial web page.
	     * This can be stored in file or database to avoid reading the same
	     * link which already being visited.
	     */
	    Set<String> finalSetofURLs = new HashSet<String>(Arrays.asList(urls));
	    
	    for (String urlString:finalSetofURLs)
	    {
	    	logger.info(urlString);
	    }
	    
	    logger.info("Total URLS accessed are " + finalSetofURLs.size());
	    
	    return true;
	 }
}



	/*
	 * 	This class contains a static function which will fetch the web page
	 *	of the given url and return as a string 
	 */
	class PageUtil
	{
	    public static String getURLContent(String address)throws Exception
	    {
	    	StringBuffer webpage= new StringBuffer();
	        String inputLine = "";
	        URL url = new URL(address);
	        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
	        while ((inputLine = in.readLine()) != null)
	        {
	        	//System.out.println("line is ::>"+inputLine);
	        webpage.append(inputLine);
	        }
	        in.close();
	        
	        return webpage.toString();
	    }

}
