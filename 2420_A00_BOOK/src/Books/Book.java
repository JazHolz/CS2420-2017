package Books;

/**
 * ..This is a Book Program it's suppose to file through 
 * book names and place them in order, reverse the order 
 * and name the total about of books. 
 * @author Jazmine Lavasani
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Book implements Comparable<Book> {
	
	/**
	 * This is where I created the Title, Author, and Year
	 */
	
	private String title;
	private String author;
	private int year;

	/**
	 * This is the set up for the title, author and year
	 * 
	 * @param title
	 * @param author
	 * @param year
	 */
	
	public Book(String title, String author, int year) {
		this.title = title;
		this.author = author;
		this.year = year;
	}
	
	/**
	 * This is the Get method for the title names
	 * @return
	 */
	
	public String getTitle() {
		return title;
	}
	
	/**
	 * This is the Get method for the authors
	 * @return
	 */
	
	public String getAuthor() {
		return author;
	}
	
	/**
	 * This is the Get method for the different years
	 * @return
	 */
	
	public int getYear() {
		return year;
	}
	
	/**
	 * This is the toString method that aligns the title, author, and year
	 * to be printed out in this pattern
	 *  title + " By " + author + " (" + year + ")"
	 * @return 
	 */
	
	@Override
	public String toString() {
		return title + " By " + author + " (" + year + ")";
	}

	/**
	 * This getList method reads in the data from the csv file 'book.csv' 
	 * If a line doesn’t follow the pattern set 'title, author, year' 
	 * then a message should appear if it doesn't read in right then an error stream
	 * @param f
	 * @return
	 */ 
	
	public static List<Book> getList(String f) {
		List<Book> books = new ArrayList<>();
		int bookNum = 0;
		File file = new File(f);

		Scanner input;
		try {
			input = new Scanner(file);

			while (input.hasNext()) {
				String[] parts = input.nextLine().split(",");
				if (parts.length == 3) {
					Book bK = new Book(parts[0], parts[1], Integer.parseInt(parts[2]));
					books.add(bK);
					bookNum++;
				} else {
					System.out.println("Problem reading: " + 
				Arrays.toString(parts).replace("[", "").replace("]", ""));
				}
			}
			input.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Number of Books: " + bookNum);
		return books;

	}

	/**
	 * Compareto method auto-generated to allow the books to be Compared
	 * It will compare one title to the other. 
	 */
	@Override
	public int compareTo(Book other) {
		return this.getTitle().compareTo(other.getTitle());
	}
}
