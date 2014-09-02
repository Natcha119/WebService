package Model;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
/*
 * About RSS and element
 * @author Natcha Chidchob 5510546026
 */
public class Rss {
	/**Channel of this RSS*/
	private Channel channel;

	/*
	 * Give current channel
	 * @return channel
	 */
	public Channel getCh() {
		return channel;
	}

	/*
	 * Set the Channel
	 * @param ch
	 */
	public void setCh(Channel ch) {
		this.channel = ch;
	}

}
