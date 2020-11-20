package projectPart1;

public class BySpecLeaseLength implements GeneralSpec{

	private int length;

	public BySpecLeaseLength(int length) {
		this.length = length;
	}

	public int getLength() {
		return length;
	}

	public boolean isSpecMatched(FinderApp finderApp, int i) {
		return finderApp.homesList.get(i).getLeaselength()==getLength();
	}

}
