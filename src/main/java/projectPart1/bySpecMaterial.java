package projectPart1;

public class bySpecMaterial {

	private String materialString;

	public bySpecMaterial(String materialString) {
		this.materialString = materialString;
		// TODO Auto-generated constructor stub
	}

	public String getMaterialString() {
		return materialString;
	}
	
	

	boolean isSpecMatched(finderApp finderApp, int i) {
		return finderApp.homesList.get(i).getMaterial().equalsIgnoreCase(getMaterialString());
	}
}
