package autocomplete;

import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * This class implements an immutable data type that provides the other class
 * Autocomplete with functionality for a given set of string and weights, using
 * Term and BinarySearchDeluxe. We sorted the terms in lexicographic order, we
 * used binary search to find the set of terms that start with a given prefix
 * and sort the matching terms in descending order by weight.
 * 
 * @author Jason Wayne Carter and Jazmine Mehri Lavasani
 *
 */
public class Autocomplete {

	private Term[] terms;

	/**
	 * Initialize the data structure from the given array of terms.
	 * 
	 * @param terms
	 */

	public Autocomplete(Term[] terms) {
		if (terms == null) {
			throw new java.lang.NullPointerException();
		}
		this.terms = new Term[terms.length];

		for (int i = 0; i < terms.length; i++) {

			this.terms[i] = terms[i];
		}
		Arrays.sort(this.terms);
	}

	/**
	 * Return all terms that start with the given prefix, in descending order of
	 * weight.
	 * 
	 * @param prefix
	 * @return
	 */

	public Term[] allMatches(String prefix) {
		if (prefix == null) {
			throw new java.lang.NullPointerException();
		}

		int firstIndex = BinarySearchDeluxe.firstIndexOf(terms, new Term(prefix, 0),
				Term.byPrefixOrder(prefix.length()));
		if (firstIndex == -1)
			return new Term[0];
		int lastIndex = BinarySearchDeluxe.lastIndexOf(terms, new Term(prefix, 0), Term.byPrefixOrder(prefix.length()));

		Term[] match = Arrays.copyOfRange(terms, firstIndex, lastIndex + 1);
		Arrays.sort(match, Term.byReverseWeightOrder());

		return match;

	}

	/**
	 * Return the number of terms that start with the given prefix.
	 * 
	 * @param prefix
	 * @return
	 */
	public int numberOfMatches(String prefix) {
		if (prefix == null) {
			throw new java.lang.NullPointerException();
		}

		// return .
		return 1 + BinarySearchDeluxe.lastIndexOf(terms, new Term(prefix, 0), Term.byPrefixOrder(prefix.length()))
				- BinarySearchDeluxe.firstIndexOf(terms, new Term(prefix, 0), Term.byPrefixOrder(prefix.length()));

	}

}
