package project.part2;

public class BySpecPlacment implements GeneralSpec{

	private String placmentString;

	public BySpecPlacment(String placmentString) {
		this.placmentString = placmentString;
	}

	public String getPlacmentString() {
		return placmentString;
	}

	
	public boolean isSpecMatched(FinderApp finderApp, int i) {
		return finderApp.homesList.get(i).getPlacement().equalsIgnoreCase(getPlacmentString());
	}

}
