package projectPart1;

public class bySpecLeaseLength {

	private int length;

	public bySpecLeaseLength(int length) {
		this.length = length;
		// TODO Auto-generated constructor stub
	}

	public int getLength() {
		return length;
	}

	boolean isSpecMatched(finderApp finderApp, int i) {
		return finderApp.homesList.get(i).getLease_length()==getLength();
	}

}
