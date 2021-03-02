package Books;

/**
 * ..This is BookApp the test client to Book
 * @author Jazmine Lavasani
 */
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BookApp {

	public static void main(String[] args){
		
		/**
		 * This is where the get list pulls out the text in books.cvs
		 */
		
		List<Book> bK = Book.getList("src/Books/books.csv");
		
		/**
		 * Separator so that it looks nice
		 */
		
		System.out.println();
		
		/**
		 * Printing out my Sorted List, 
		 * Using Collections sort function. 
		 */
		
		System.out.println("Sorted List: ");
		Collections.sort(bK);
		for(Book book: bK){
			System.out.println(book.toString());
		}
		
		/**
		 * THis method reverses the values of Book
		 * Comparator<Book> is used. 
		 */
		
		Comparator<Book> cpar = Collections.reverseOrder();
		Collections.sort(bK, cpar);
		System.out.println();
		
		/**
		 * I reversed the Order of the Book values.
		 * Keeping the same Title, Author, Year set up
		 */
		System.out.println("Reverse Order: ");
		for(Book book: bK){
			System.out.println(book.toString());
		}
	}
}
