package Controller;

import View.RssView;


/*
 * The main class.
 * @author Natcha Chidchob 5510546026
 */
public class Main {
	/**The Reader*/
	private Reader reader;
	/**UI section*/
	private static RssView view;
	
	public static void main(String[] args){
		view = new RssView();
		view.run();
	}
}
