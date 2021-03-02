package autocomplete;

import java.util.Collections;
import java.util.Comparator;

import edu.princeton.cs.algs4.StdOut;

/**
 * In this class we binary search a sorted array that contains more than one key
 * equal to the search key, the client may want to know the index of either the
 * first or the last such key then this class implements the following API's.
 * 
 * @author Jason Wayne Carter and Jazmine Mehri Lavasani
 *
 */
public class BinarySearchDeluxe {

	/**
	 * Return the index of the first key in a[] that equals the search key, or
	 * -1 if no such key.
	 * 
	 * @param a
	 * @param key
	 * @param comparator
	 * @return
	 */

	public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator) {

		if (a == null || key == null || comparator == null) {
			throw new java.lang.NullPointerException("Cannot be Null");
		}

		// Binary Search Algorithm of Princeton.
		int low = 0;
		int high = a.length - 1;
		if (comparator.compare(a[low], key) == 0) {
			return 0;
		}

		while (low <= high) {
			int medium = low + (high - low) / 2;

			if (comparator.compare(key, a[medium]) < 0) {
				high = medium - 1;

			} else if (comparator.compare(key, a[medium]) > 0) {
				low = medium + 1;

			} else if (comparator.compare(a[medium - 1], a[medium]) == 0) {
				high = medium - 1;

			} else {
				return medium;

			}
		}

		return -1;
	}

	/**
	 * Return the index of the last key in a[] that equals the search key, or -1
	 * if no such key.
	 * 
	 * @param a
	 * @param key
	 * @param comparator
	 * @return
	 */

	public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator) {

		if (a == null || key == null || comparator == null) {
			throw new java.lang.NullPointerException("Cannot be Null");
		}

		int low = 0;
		int high = a.length - 1;

		if (comparator.compare(a[high], key) == 0) {
			return high;
		}

		while (low <= high) {
			int medium = low + (high - low) / 2;

			if (comparator.compare(key, a[medium]) > 0) {
				low = medium + 1;

			} else if (comparator.compare(key, a[medium]) < 0) {
				high = medium - 1;

			} else if (comparator.compare(a[medium + 1], a[medium]) == 0) {
				low = medium + 1;

			} else {
				return medium;

			}
		}

		return -1;

	}

}