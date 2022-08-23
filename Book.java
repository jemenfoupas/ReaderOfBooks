import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 * @author Default User
 *
 */
public class Book implements BookInterface 
{
	//FIELD
	private String title;
	private String author;
	private String genre;
	private String fileName;
	
	//CONSTRUCTER
	public Book(String title, String author )
	{
		this.title = title;
		this.author = author;
	}
	
	//METHODS
	@Override
	public String getTitle() 
	{
		// TODO Auto-generated method stub
		return title;
	}

	@Override
	public void setTitle(String title) 
	{
		// TODO Auto-generated method stub
		this.title = title;
	}

	@Override
	public String getAuthor() 
	{
		// TODO Auto-generated method stub
		return author;
	}

	@Override
	public void setAuthor(String author)
	{
		// TODO Auto-generated method stub
		this.author = author;
	}
	
	@Override
	public String getGenre() {
		// TODO Auto-generated method stub
		return genre;
	}

	@Override
	public void setGenre(String genre) 
	{
		
		this.genre = genre;
	}

	@Override
	public String getFilename() {
		// TODO Auto-generated method stub
		return fileName;
	}

	@Override
	public void setFilename(String filename) {
		// TODO Auto-generated method stub
		this.fileName = filename;
	}
	
	public String toString()
	{
		
		
		return "Title: " + title + " Author: " + 
				author + " Genre: " + genre + " File Name: "+ fileName;
	}
	
	
	public boolean isValid()
	{
		if(this.title == null || this.author ==null || this.genre == null || this.fileName == null)
			{
				return false;
			}
		else
		{
			File f = new File(this.fileName);
			if(f.exists()&& f.isFile())
			{
				return true;
			}
			else
			{
				return false;
			}
		}
	}
	
	public String getText()
	{
		String resultText = "";
		File name = new File(fileName);
		try
		{
			Scanner file = new Scanner(name);
			while(file.hasNextLine())
			{
				String line = file.nextLine();
				resultText += line +"\n" ;
			}
		}
		
		catch(FileNotFoundException e)
		{
			resultText = "file was not able to be opened ";
		}

		return resultText;
		
	}
}