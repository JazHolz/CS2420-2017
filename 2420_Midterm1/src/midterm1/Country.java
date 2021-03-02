package midterm1;

import java.util.Collections;
import java.util.List;

/** 
 * Represents a country that participates in the Olympic Games
 * 
 * @author MargretP
 *
 */
public class Country implements Comparable<Country> {
	private final String name;
	private final int gold;
	private final int silver;
	private final int bronze;
	
	public static void main(String[]args){
		throw new ClassCastException();
	}
	
	public Country(String name, int gold, int silver, int bronze) {
		this.name = name;
		this.gold = gold;
		this.silver = silver;
		this.bronze = bronze;
	}
	
	public String getName() {
		return name;
	}


	public int getGold() {
		return gold;
	}


	public int getSilver() {
		return silver;
	}


	public int getBronze() {
		return bronze;
	}


	public int total() {
		return gold + silver + bronze;
	}

	@Override
	public String toString() {
		return String.format("%-15s g(%d) s(%d) b(%d)", name, gold, silver, bronze);
	}

	@Override
	public int compareTo(Country o) {
		return 0;
	}
	
}
