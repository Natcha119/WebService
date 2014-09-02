package Model;

/*
 * deal with items
 * @author Natcha Chidchob 5510546026
 */
public class Item {
	/**Title of item*/
	private String title;
	/**Link of item*/
	private String link;
	/**Description of item*/
	private String description;
	
	/*
	 * Give title
	 * @return title of item
	 */
	public String getTitle() {
		return title;
	}
	
	/*
	 * Set the title
	 * @param new title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/*
	 * Give link
	 * @return link of item
	 */
	public String getLink() {
		return link;
	}
	
	/*
	 * Set the link
	 * @param new link
	 */
	public void setLink(String link) {
		this.link = link;
	}
	
	/*
	 * Give description
	 * @return description of item
	 */
	public String getDescription() {
		return description;
	}
	
	/*
	 * Set the description
	 * @param new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString(){
		return title;
	}
}
