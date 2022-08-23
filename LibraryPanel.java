import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 * this class contains the books list and adds the files
 * this class contains the ActionListener that makes it possible to load things.
 * @author Rich B
 *
 */
public class LibraryPanel extends JPanel
{
	//FIELD
	private Library library = new Library();
	private JScrollPane bookListJScrollPane; //this contains the bookListPanel
	private JPanel bookListPanel; //this JPanel contains the book buttons
	private JPanel loadLibraryPanel; //this JPanel contains the descriptionField and load, to organize things
	private JTextField descriptionField; // this is where the csv file is enter.
	private JButton load; //this is the buttons that takes the file and makes buttons for each book
	private ActionListener al;

	//CONSTRUCTER
	/**
	 * this Constructor contains the makes the jpanels that make the LibraryPanel
	 * @param bookButton
	 */
	public LibraryPanel(ActionListener bookButton) 
	{
		this.al = bookButton;
		load = new JButton("Load");
		bookListPanel = new JPanel();
		loadLibraryPanel = new JPanel();
		descriptionField = new JTextField(15);
		
		setLayout( new BorderLayout(10, 10));
		//sets the book buttons layout to be vertical
		bookListPanel.setLayout(new BoxLayout(bookListPanel, BoxLayout.Y_AXIS)); 
		
		bookListJScrollPane = new JScrollPane(bookListPanel);
		bookListJScrollPane.setBorder(BorderFactory.createTitledBorder("Books List"));
		bookListJScrollPane.setPreferredSize(new Dimension(90,350));
		bookListJScrollPane.setVerticalScrollBarPolicy
				(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		bookListJScrollPane.setHorizontalScrollBarPolicy
				(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		load.addActionListener(new ImportActionListener());
		load.setBackground(Color.WHITE);
		loadLibraryPanel.setBorder(BorderFactory.createTitledBorder("Import Books"));
		loadLibraryPanel.add(descriptionField, BorderLayout.WEST);
		loadLibraryPanel.add(load, BorderLayout.EAST);
		add(loadLibraryPanel, BorderLayout.SOUTH);
		add(bookListJScrollPane, BorderLayout.CENTER);
	}
	
	//METHODS
	/**
	 * this action listener is used by the load button to 
	 * create the buttons for each book file.
	 * @author Rich B
	 *
	 */
	private class ImportActionListener  implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			String t = descriptionField.getText();
			library.loadLibraryFromCSV(t);
			
			/**
			 * It makes a book button for each book
			 */
			for(Book b : library.getBooks())
			{
				BookButton bb = new BookButton(b);
				bb.addActionListener(al);
				bb.setBackground(Color.WHITE);
				bookListPanel.add(bb, BorderLayout.CENTER);
				revalidate();
			}
		}
	}
}