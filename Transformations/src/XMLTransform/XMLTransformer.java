package Transformations.Transformations.src.XMLTransform;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class XMLTransformer {
	
	static final String MOVIE = "movie";
	static final String TITLE = "title";
	static final String RANK = "rank";
	static final String YEAR = "year";
	static Movie m = null;
	
	public List<Movie> readXML(String XMLFile) {
		List<Movie> movies = new ArrayList<Movie>();
		try {
			XMLInputFactory factory = XMLInputFactory.newInstance();
			InputStream in = new FileInputStream(XMLFile);
			XMLEventReader eventReader = factory.createXMLEventReader(in);
			
			while (eventReader.hasNext()) {
				XMLEvent event = eventReader.nextEvent();
				if(event.isStartElement()) {
					StartElement startElement = event.asStartElement();
					if(startElement.getName().getLocalPart() == (MOVIE)) {
						m = new Movie();
						Iterator<Attribute> attributes = startElement.getAttributes();
						while(attributes.hasNext()) {
							Attribute att = attributes.next();
							if(att.getName().toString().equals(TITLE)) {
								m.setTitle(att.getValue());
							}
						}
					}
					if(event.asStartElement().getName().getLocalPart().equals(RANK)) {
						event = eventReader.nextEvent();
						m.setRank(event.asCharacters().getData());
						continue;
					}
					if(event.asStartElement().getName().getLocalPart().equals(YEAR)) {
						event = eventReader.nextEvent();
						m.setYear(event.asCharacters().getData());
						continue;
					}
				}
				if(event.isEndElement()) {
					EndElement endElement = event.asEndElement();
					if(endElement.getName().getLocalPart() == (MOVIE)) {
						movies.add(m);
					}
				}
			}
		}catch (FileNotFoundException e	) {
			e.printStackTrace();
		}catch (XMLStreamException e ) {
			e.printStackTrace();
		}
	return movies;
	}
		
}