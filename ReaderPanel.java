import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 * this class contains the information about the TitleLabel, AuthorLabel and 
 * the text of the book
 * @author Rich B
 *
 */
public class ReaderPanel extends JPanel
{
	//FIELD
	private JPanel infoPanel; //this contains the TitleLabel and AuthorLabel
	private JLabel TitleLabel;
	private JLabel AuthorLabel;
	private JLabel Space;
	private JTextArea bookTextArea; //this contains the text of the books
	private JScrollPane bookTextScrollPane; //this contains the bookTextArea
	
	//CONSTRUCTER
	/**
	 * this Constructor contains the makes the jpanels that make the ReaderPanel
	 * @param bookButton
	 */
	public ReaderPanel()
	{
		setLayout(new BorderLayout(10, 10));
		
		infoPanel = new JPanel();
		TitleLabel = new JLabel("TitleLabel");
		AuthorLabel = new JLabel("AuthorLabel");
		Space = new JLabel("           ");
		bookTextArea = new JTextArea();
		bookTextScrollPane = new JScrollPane(bookTextArea);
		
		bookTextScrollPane.setBackground(Color.WHITE);
		bookTextScrollPane.setBorder(BorderFactory.createTitledBorder("Content"));
		bookTextScrollPane.setVerticalScrollBarPolicy
				(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		bookTextScrollPane.setHorizontalScrollBarPolicy
				(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		infoPanel.setBorder(BorderFactory.createTitledBorder("Information"));
		infoPanel.add(TitleLabel);
		infoPanel.add(Space);
		infoPanel.add(AuthorLabel);
		
		add(infoPanel, BorderLayout.NORTH);
		add(bookTextScrollPane, BorderLayout.CENTER);
	}
	
	//METHODS
	/**
	 * this method updates the Title and author and text when the book button is press
	 * @param book
	 */
	public void loadBook(Book book)
	{
		TitleLabel.setText("Title: " + book.getTitle());
		AuthorLabel.setText("By: " + book.getAuthor());
		bookTextArea.setText(book.getText());
		revalidate();
	}
}