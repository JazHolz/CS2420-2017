package heapSort;

import edu.princeton.cs.algs4.StdRandom;

public class Mail implements Comparable<Mail> {

	private DeliveryType type;
	private String mailCode;

	public Mail(DeliveryType type, String mailCode) {
		this.type = type;
		this.mailCode = mailCode;
	}

	public Mail() {
		this.type = randomType();
		this.mailCode = randomMailCode();
	}

	/**
	 * Creates a String of 5 random capital letters e.g. "AHEKT"
	 * 
	 * @return
	 */
	private String randomMailCode() {
		String mailCode = "";
		int codeLength = 5;

		for (int i = 0; i < codeLength; i++) {
			mailCode += (char) StdRandom.uniform(65, 91);

		}
		return mailCode;
	}

	/**
	 * Selects a DeliveryType at random.
	 * 
	 * @return
	 */
	private DeliveryType randomType() {
		DeliveryType[] types = DeliveryType.values();
		return types[StdRandom.uniform(types.length)];

	}

	@Override
	public String toString() {
		return mailCode + "(" + type + ")";
	}

	@Override
	public int compareTo(Mail other) {
		if (this.type.equals(other.type)) {
			return this.mailCode.compareTo(other.mailCode);
		} else {
			return this.type.compareTo(other.type);
		}
	}

}
