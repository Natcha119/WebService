package View;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.xml.bind.JAXBException;

import Controller.Reader;
import Model.Item;

/*
 * Build GUI
 * @author Natcha Chidchob 5510546026 
 */
public class RssView extends JFrame{
	/**Label of URL*/
	private JLabel label; 
	/**Field to input URL*/
	private JTextField textField;
	/**OK button*/
	private JButton button;
	/**Panel contain field and button*/
	private JPanel panelTop;
	/**URL name*/
	private String url;
	
	/**Panel of title and description of channel*/
	private JPanel panelMiddle;
	/**Channel title*/
	private JLabel title;
	/**Channel description*/
	private JLabel channelDes;
	
	/**List of item in current channel*/
	private JList list;
	/**Scroll of List*/
	private JScrollPane scrollList;
	/**Show detial of item you select*/
	private JTextArea showText;
	/**Scroll of TextArea*/
	private JScrollPane scrollArea;
	/**Contain List and textArea*/
	private JPanel panelBottom;
	/**Have panelMiddle and Bottom*/
	private JPanel panelCenter;
	/**The reader*/
	private Reader reader;
	/**Items we get*/
	private Item[] items;
	
	/**Panel of see more detail botton*/
	private JPanel panellast;
	/**Button to link*/
	private JButton goLink; 
	/**Link to go*/
	private String link;
		
	/*
	 * Initialize view 
	 */
	public RssView() {
		super("RSS Reader");
		initcomponent();
	}
	
	/*
	 * Build component of view
	 */
	private void initcomponent(){
		createTop();
		createMiddle();
		createBottom();
		createLast();
	}
	
	/*
	 * Build panel in top and its element
	 */
	private void createTop(){
		panelTop = new JPanel();
		label = new JLabel("URL link");
		textField = new JTextField(50);
		textField.setColumns(45);
		textField.setEditable(true);
		button = new JButton(" OK ");
		button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				url = textField.getText();
				if(url != null){
					try {
						reader = new Reader(url);
					} catch (MalformedURLException e) {
						e.printStackTrace();
					} catch (JAXBException e) {
					e.printStackTrace();
					}
					list.setListData(getItems());
					title.setText(reader.getChannelName());
					channelDes.setText(reader.getChannelDes());
				}
				else{
					textField.setText("Please enter URL!!!!!");
				}
			}
			
		});
		panelTop.add(label);
		panelTop.add(textField);	
		panelTop.add(button);
		add(panelTop,BorderLayout.NORTH);
	} 	
	
	/*
	 * Build panel in middle and its element
	 */
	private void createMiddle(){
		panelMiddle = new JPanel();
		panelMiddle.setLayout(new BoxLayout(panelMiddle, BoxLayout.Y_AXIS));
		title = new JLabel("Title goes here");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setAlignmentX(CENTER_ALIGNMENT);
		title.setFont(new Font("Serif", Font.BOLD,20));
		channelDes = new JLabel("Description...");
		channelDes.setHorizontalAlignment(SwingConstants.CENTER);
		panelMiddle.add(title);
		panelMiddle.add(channelDes);
		
		panelCenter = new JPanel();
		panelCenter.setLayout(new BoxLayout(panelCenter, BoxLayout.Y_AXIS));
		panelCenter.add(panelMiddle);
	}
	
	/*
	 * Build panel in bottom and its element
	 */
	private void createBottom() {
		panelBottom = new JPanel();
		createList();
		createTextArea();
		panelBottom.add(scrollList);
		panelBottom.add(scrollArea);
		panelCenter.add(panelBottom);
		add(panelCenter);
	}
	
	/*
	 * Build the Area to show item description
	 */
	private void createTextArea() {
		showText = new JTextArea();
		scrollArea = new JScrollPane(showText);
	    scrollArea.setPreferredSize(new Dimension(350, 330));
	    scrollArea.setVisible(true);
		showText.setLineWrap(true);
		showText.setWrapStyleWord(true);
		showText.setPreferredSize(new Dimension(350, 330));
		showText.setEditable(false);
	}

	/*
	 * Build list to show item and let user choose.
	 */
	private void createList(){
		list = new JList();
		list.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				Item item = (Item) (list.getSelectedValue());
				showText.setText(item.getTitle()+"\n\n\n");
				showText.append(item.getDescription());
				link = item.getLink();
			}
			
		});
        scrollList = new JScrollPane(list);
        scrollList.setPreferredSize(new Dimension(350, 330));
        scrollList.setVisible(true);
	}
	
	/*
	 * Build panel in bottom and its element
	 */
	private void createLast() {
		panellast = new JPanel();
		goLink = new JButton("View Full");
		goLink.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Desktop.isDesktopSupported()) {
					Desktop desktop = Desktop.getDesktop();
					try {
						desktop.browse(new URI(link));
					} catch (IOException e1) {
						e1.printStackTrace();
					} catch (URISyntaxException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		panellast.add(goLink);
		add(panellast,BorderLayout.SOUTH);
	}
	
	/*
	 * Give URL 
	 */
	public String getURL(){
		return url;
	}
	
	/*
	 * Let application show
	 */
	public void run(){
		pack();
		setVisible(true);
		setSize(800, 500);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/*
	 * Give all items in channel
	 */
	private Item[] getItems(){
		ArrayList<Item> arr = reader.getItems();
		items = new Item[arr.size()];
		arr.toArray(items);
		return items;
	}
	
}
