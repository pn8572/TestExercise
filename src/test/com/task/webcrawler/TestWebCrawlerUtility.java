package test.com.task.webcrawler;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.task.webcrawler.WebCrawlerUtility;

/**
 * @author prasanth.pillai
 *
 */
public class TestWebCrawlerUtility {
	
	final static Logger logger = Logger.getLogger(TestWebCrawlerUtility.class);
	WebCrawlerUtility utilObj = new WebCrawlerUtility();
	String url = "http://wiprodigital.com";

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.task.webcrawler.WebCrawlerUtility#getURLs(java.lang.String[])}.
	 */
	@Test
	public final void testGetURLs() {
		//fail("Not yet implemented"); // TODO
		
		try {
			assertTrue ("Success",true == WebCrawlerUtility.getURLs(url));
			logger.info("Successfully Tested WebCrawlerUtility");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("WebCrawlerUtility Testing Failed");
		}
	}

}
