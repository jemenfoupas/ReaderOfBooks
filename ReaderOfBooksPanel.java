import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 * this class contains the LibraryPanel and ReaderPanel
 * @author Rich B
 *
 */
public class ReaderOfBooksPanel extends JPanel
{
	//FIELD
	private LibraryPanel libraryPanel;
	private ReaderPanel readerPanel;

	//CONSTRUCTER
	/**
	 * this constructor contains the LibraryPanel and ReaderPanel
	 */
	public ReaderOfBooksPanel()
	{
		setLayout( new BorderLayout(10, 10));
		
		libraryPanel = new LibraryPanel(new BookButtonListener()); //initialize the libraryPanel and adds the ActionListener
		readerPanel = new ReaderPanel(); //initialize the readerPanel

		Border libraryTitle = BorderFactory.createTitledBorder("Library"); //this give the library a border and Title
		Border readerTitle = BorderFactory.createTitledBorder("Reader"); //this give the reader a border and Title
		
		libraryPanel.setBorder(libraryTitle); //adds a border
		libraryPanel.setBackground(Color.WHITE);
		readerPanel.setBorder(readerTitle); //adds a border
		add(libraryPanel, BorderLayout.WEST);
		add(readerPanel, BorderLayout.CENTER);
	}
	
	//METHODS
	/** 
	 * this ActionListener gets the book information when 
	 * the button in the LibraryPanel is press in
	 * @author Rich B
	 *
	 */
	private class BookButtonListener  implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			BookButton b = (BookButton) e.getSource();
			readerPanel.loadBook(b.getBook());
		}
	}
}