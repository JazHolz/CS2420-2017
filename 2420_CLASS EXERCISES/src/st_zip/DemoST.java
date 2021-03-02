package st_zip;

import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class DemoST {

	public static void main(String[] args) {
		
		ST<Integer, City> st = ZipToCity.cityToZip();
		for(Integer key: st.keys()){
			StdOut.printf("%d .. %s%n", key, st.get(key));
		}
		
		//Gen 5 number zip if avalible print print one above and one below
		
		int n = StdRandom.uniform(10000, 100000);
		if(st.contains(n)){
			
			StdOut.printf("Greatest zip that is equal to or larger than the key %d: %d%n", n, st.floor(n));
			StdOut.println();
			StdOut.printf("Smallest zip that is equal to or smaller than the key", n, st.ceiling(n));
			StdOut.println();
			StdOut.printf("Smallest zip ", n, st.min(), st.max());
			
		}
		
		StdOut.println();
		
		StdOut.println("DONE");
	}

}
