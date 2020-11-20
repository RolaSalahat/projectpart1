package project.part2;

public class BySpecMaterial implements GeneralSpec {

	private String materialString;

	public BySpecMaterial(String materialString) {
		this.materialString = materialString;
	}

	public String getMaterialString() {
		return materialString;
	}
	
	

	public boolean isSpecMatched(FinderApp finderApp, int i) {
		return finderApp.homesList.get(i).getMaterial().equalsIgnoreCase(getMaterialString());
	}
}
