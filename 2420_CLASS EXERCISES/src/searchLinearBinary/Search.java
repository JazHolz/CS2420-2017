package searchLinearBinary;

public class Search {
	/**
	 * Searches for the specified key in array numbers
	 * using the Linear search algorithm
	 * 
	 * @param numbers
	 * @param key
	 * @return index of key or -1 if the key was not found
	 */
	
	public static int linear(int[] numbers, int key){
		int index = -1;
		
		for ( int i = 0; i < numbers.length; i++){
			if (numbers[i] == key)
				index = -1;
		}
		return index;
	}
	
	/**
	 * Searches for the specified key in array numbers
	 * using the Binary search algorithm
	 * 
	 * @param numbers
	 * @param key
	 * @return
	 */
	
	public static int binary(int[] numbers, int key){
		return 0; //TODO
	}
	
}
