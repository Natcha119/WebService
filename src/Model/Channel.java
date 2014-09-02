package Model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

/*
 * Deal with Channel of RSS
 * @author Natcha Chidchob 5510546026
 */
public class Channel {
	/**Title of channel*/
	private String title;
	/**Link of channel*/
	private String link;
	/**Description of channel*/
	private String description;
	@XmlElement(name="item")
	/**Items in channel*/
	private ArrayList<Item> items;
	
	/*
	 * get title of channel
	 * @return channel's title
	 */
	public String getTitle() {
		return title;
	}
	
	/*
	 * Set title name
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/*
	 * get link of channel
	 * @return channel's link
	 */
	public String getLink() {
		return link;
	}
	
	/*
	 * Set link of channel
	 * @param link
	 */
	public void setLink(String link) {
		this.link = link;
	}
	
	/*
	 * get description of channel
	 * @return channel's description
	 */
	public String getDescription() {
		return description;
	}
	
	/*
	 * Set description
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/*
	 * get items of channel
	 * @return channel's items
	 */
	public ArrayList<Item> getItems(){
		return items;
		
	}
	
}
