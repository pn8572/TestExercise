# TestExercise

Download the entire project from https://github.com/pn8572/TestExercise 
to local EclipseIDE. Open the project in Eclipse and check if there are any errors or missing dependency files.
If yes, please correct it by following the steps below.

If there are no errors, then run the TestWebCrawlerUtility as a Junit test case. It should output the result.

Add the following jar files under TestExercise\lib folder
-------------------------------------------------------------

1. apache-logging-log4j.jar
2. junit.jar


apache-logging-log4j.jar is used for logging the details to console and file (if required)
junit.jar is used for Junit testing

To add log4j.properties file
-------------------------------

place the log4j.properties in the folder you prefer. Ihave chose to place it under TestExercise\src\resource folder and add the folder in the classpath in Run configuration.

In Eclipse IDE : Click the WebCrawlerUtility.java and on: Run->Run Configuration -> [classpath tab] -> click on user Entries -> Advanced -> Select Add Folder -> select the location of your log4j.properties file

and then -> OK -> run

Functionality
--------------------------

The following logic is used for the web crawler.
 * 
 * Step 1: Retrieve a web page from a website (http://wiprodigital.com)
 * Step 2: Collect all the links on that web page
 * Step 3: Collect all the words on that document
 * Step 4: See if the word we're looking for is contained in the list of words, then display it. We can even store to file system or db if required.
 * Step 5: Visit the next link
 *
 
What could have done with more time
----------------------------------

1) Storing the details to a text file or a database. This will help to monitor the web
2) I have not considered the situation where if pages are linked back and forth.
i.e if we start at Page 1 and find that it contains links to Page 2 . The program will go to Page 2 & what if Page 2 contains a more links to other pages, and one of those pages links back to Page 1. So, it is like checking same urls again and again. This can be restricted.
3) Added more test scenarios.


