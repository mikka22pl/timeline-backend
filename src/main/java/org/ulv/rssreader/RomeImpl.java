package org.ulv.rssreader;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import com.sun.syndication.feed.synd.SyndEntryImpl;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

public class RomeImpl {

	/*public static void main(String[] args) {
		try {
			URL url = new URL("http://feeds.abcnews.com/abcnews/internationalheadlines");
			
			SyndFeedInput input = new SyndFeedInput();
			SyndFeed feed = input.build(new XmlReader(url));
			
			@SuppressWarnings("unchecked")
			List<SyndEntryImpl> list = feed.getEntries();
			
			for (SyndEntryImpl entry : list) {
				System.out.println("entry " + entry.getTitle());
			}
			
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		} catch (IOException | FeedException e) {
			throw new RuntimeException(e);
		}
	}*/
}
