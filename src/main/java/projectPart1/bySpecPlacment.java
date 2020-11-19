package projectPart1;

public class bySpecPlacment {

	private String placmentString;

	public bySpecPlacment(String placmentString) {
		this.placmentString = placmentString;
		// TODO Auto-generated constructor stub
	}

	public String getPlacmentString() {
		return placmentString;
	}

	
	boolean isSpecMatched(finderApp finderApp, int i) {
		return finderApp.homesList.get(i).getPlacement().equalsIgnoreCase(getPlacmentString());
	}

}
