import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.JButton;

/**
 * this class add more option to the JButton for my use
 * @author Rich B
 *
 */
public class BookButton  extends JButton
{
	//FIELD
	private Book book;
	public String bookLimit;
	
	//CONSTRUCTER
	/**
	 * this Constructor takes a book as a parameter and gets the title 
	 * if the title is to long it makes it shorter
	 */
	public BookButton(Book b)
	{
		this.book = b;
		//this limits the length of the title in the button
		if(book.getTitle().length() > 20) 
		{
			bookLimit = book.getTitle().substring(0, 17) + "...";
		}
		else
		{
			bookLimit = book.getTitle();
		}

		setText(bookLimit);
		this.setToolTipText(book.getTitle());
		this.setMaximumSize(new Dimension(170,25));
	}
	
	//METHODS
	/**
	 * return the book
	 */
	public Book getBook()
	{
		return book;
	}
}