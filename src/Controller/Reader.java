package Controller;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import Model.Item;
import Model.Rss;

/*The Reader to read RSS
 * @author Natcha Chidchob 5510546026
 */
public class Reader {
	private JAXBContext ctx;
	private Unmarshaller unmarshaller;
	/**name of URL*/
	private String urlName;
	private URL url; 
	private Rss rss;
	/**Item from channel*/
	private ArrayList<Item> items;
	
	/*
	 * initialize reader
	 * @param urlName
	 */
	public Reader(String urlName) throws MalformedURLException, JAXBException{
		this.urlName = urlName;
		readURL();
	}
	
	/*
	 * Read RSS from the URL
	 */
	private void readURL() throws JAXBException, MalformedURLException{
		ctx = JAXBContext.newInstance( Rss.class );
		unmarshaller = ctx.createUnmarshaller( );
		url = new URL(urlName);
		Object obj = unmarshaller.unmarshal(url);
		rss = (Rss) obj;
		items = rss.getCh().getItems();
	}
	
	/*
	 * Give items 
	 * @return items
	 */
	public ArrayList<Item> getItems(){
		return items;
	}
	
	/*
	 * Give name of channel
	 * @return channel's title 
	 */
	public String getChannelName(){
		return rss.getCh().getTitle();
	}
	
	/*
	 * Give description of channel
	 * @return the description
	 */
	public String getChannelDes(){
		return rss.getCh().getDescription();
	}
}
