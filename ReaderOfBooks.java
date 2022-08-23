import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JFrame;

/**
 * this is where the JFrame is made, the JPanel made in this class is the ReaderOfBooksPanel
 * @author Rich B
 *
 */
public class ReaderOfBooks
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Ultimate Task Master");
		ReaderOfBooksPanel panel = new ReaderOfBooksPanel();
		
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(panel);
		frame.setSize(new Dimension(900, 700));
		frame.setVisible(true);
	}
}