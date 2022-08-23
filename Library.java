import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * this defines what the Library does
 * @author Default User
 *
 */
public class Library implements LibraryInterface
{
	//FIELD
	private  ArrayList<Book> books;
	
	
	//METHODS
	public Library()
	{
		books = new ArrayList<Book>();
	}
	

	@Override
	public void addBook(Book newBook) 
	{
		books.add(newBook);
	}

	@Override
	public void removeBook(int index) 
	{
		if(index >= 0 && index < books.size())
		{
			books.remove(index);
		}
		
	}
	
	public  int getSize()
	{
		return books.size();
		
	}

	public Book getBook(int index) 
	{
		if(index >= 0 && index < books.size()) 
		{
			return  books.get(index);
		}
		else
		{
			return null;
		}
	}	
	
	public String toString()
	{
		String result = "";
		for(Book s: books)
		{
			result += s.toString()+ " \n ";
		}
		return result;
	}

	@Override
	public ArrayList<Book> getBooks() 
	{
		ArrayList<Book> booksReturn = new ArrayList<Book>();
		for(Book b: books)
		{
			booksReturn.add(b);
		}
		return booksReturn;
	}
	
	public void loadLibraryFromCSV(String csvFilename )
	{
		books.clear();
		File name = new File(csvFilename);
		try
		{
			Scanner file = new Scanner(name);
			while(file.hasNext())
			{
				String title = null;
				String author =  null;

				String genre =  null;
				String filepath =  null;
				
				Scanner scan = new Scanner(file.nextLine());
				scan.useDelimiter(",");
				while(scan.hasNextLine())
				{
					title = scan.next();
					author = scan.next();
					genre = scan.next();
					filepath = scan.next();
				}
				
				Book book = new Book( title, author);
				book.setGenre(genre);
				book.setFilename(filepath);
				this.books.add(book);
			}
			System.out.println( "file was opened ");
		}
		
		catch(FileNotFoundException e)
		{
			 System.out.println( "file was not able to be opened ");
		}
	}
}
