package autocomplete;

import java.util.Arrays;
import java.util.Comparator;
import edu.princeton.cs.algs4.StdOut;

/**
 * This class writes an immutable data type Term java that represents an
 * Autocomplete term: a string query and an associated real-valued weight. It
 * implements the following API's, which also compares terms by three different
 * orders like lexicographic order by query string (the natural order), in
 * descending order by weight (an alternate order), and lexicographic order by
 * query string but using only the first r characters (a family of alternate
 * orderings). The last order may seem a bit odd, but you will use it in Part 3
 * to find all terms that start with a given prefix (of length r).
 * 
 * @author Jason Wayne Carter and Jazmine Mehri Lavasani
 *
 */
public class Term implements Comparable<Term> {

	private String query;
	private double weight;

	/**
	 * Initialize a term with the given query string and weight.
	 * 
	 * @param query
	 * @param weight
	 */
	public Term(String query, double weight) {
		if (query == null) {
			throw new java.lang.NullPointerException();
		}
		if (weight < 0) {
			throw new java.lang.IllegalArgumentException();
		}
		this.query = query;
		this.weight = weight;

	}

	/**
	 * Compares the terms in descending order by weight.
	 * 
	 * @return
	 */

	public static Comparator<Term> byReverseWeightOrder() {
		return new ComparatorReverseWeight();

	}

	// Compares the first and other weights in descending order.
	private static class ComparatorReverseWeight implements Comparator<Term> {
		public int compare(Term first, Term other) {

			if (first.weight > other.weight) {
				return -1;
			}

			if (first.weight == other.weight) {
				return 0;
			}
			return 1;
		}

	}

	/**
	 * Compare the terms in lexicographic order but using only the first r
	 * characters of each query.
	 * 
	 * @param r
	 * @return
	 */
	public static Comparator<Term> byPrefixOrder(int r) {
		if (r < 0) {
			throw new java.lang.IllegalArgumentException();
		}
		return new ComparatorPrefix(r);
	}

	// Compares the terms in lexicographic order but only using the first r
	// characters
	private static class ComparatorPrefix implements Comparator<Term> {
		private int r;

		public ComparatorPrefix(int r) {
			this.r = r;
		}

		@Override
		public int compare(Term o1, Term o2) {
			String s1;
			String s2;

			if (o1.query.length() < r) {
				s1 = o1.query;
			} else {
				s1 = o1.query.substring(0, r);
			}
			if (o2.query.length() < r) {
				s2 = o2.query;
			} else {
				s2 = o2.query.substring(0, r);
			}

			return s1.compareToIgnoreCase(s2);

		}

	}

	/**
	 * Compare the terms in lexicographic order by query.
	 */

	public int compareTo(Term that) {
		return this.query.compareTo(that.query);
	}

	/**
	 * Return a string representation of the term in the following format: the
	 * weight, followed by a tab, followed by the query.
	 */

	public String toString() {
		return weight + "\t" + query;

	}

}