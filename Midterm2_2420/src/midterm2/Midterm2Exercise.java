package midterm2;

import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * This is our second in class Midterms with one Exercise and 4 parts
 * 
 * @author Jazmine Mehri Lavasani
 *
 */
public class Midterm2Exercise {

	public static void main(String[] args) {
		
		// symbol table of type st
		ST<String, Integer> st = new ST<String, Integer>();
		//start of test
		long start = System.currentTimeMillis();
		for (int i = 0; i < 100000; i ++){
			Integer nextObject = new Integer(i);
			st.put(nextObject.toString(), nextObject);	
		}	
		for(int i = 1;i < 11; i++){
			
			Integer base = new Integer(i);
			String key = base.toString();
			Integer val = st.get(key);
			String output = key+"\t\t"+val.toString();
			StdOut.println(output);
		}
		
		
		//end of test
		long end = System.currentTimeMillis();
				
		long totalTime = end-start;
		long totalTimeInSec = totalTime/1000;
		long timeWithDec = (int)(totalTimeInSec*100);
		float timeWithDecLiteral = ((float)(timeWithDec)) / 1000;
		
		StdOut.println("Total time: "+ timeWithDecLiteral);
		
	}

}
