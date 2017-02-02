package org.ulv.rssreader;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;

public class RSSFeedParser {

	private final URL url;
	
	public RSSFeedParser(String feedUrl) {
		try {
			this.url = new URL(feedUrl);
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Feed readFeed() {
		Feed feed = null;
		try {
			boolean isFeedHeader = true;
			
			XMLInputFactory inputFactory = XMLInputFactory.newInstance();
			InputStream in = read();
			XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
			
			while(eventReader.hasNext()) {
				XMLEvent event = eventReader.nextEvent();
				if (event.isStartElement()) {
					event.asStartElement().getName().getLocalPart();
				}
			}
		} catch (XMLStreamException e) {
			throw new RuntimeException(e);
		}
		return feed;
	}
	
	private InputStream read() {
		try {
			return url.openStream();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
