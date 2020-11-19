package projectPart1;

public class bySpecType {

	private String homeType;

	public bySpecType(String homeType) {
		this.homeType = homeType;
		// TODO Auto-generated constructor stub
	}

	public String getHomeType() {
		return homeType;
	}
	
	boolean isSpecMatched(finderApp finderApp, int i) {
		return (finderApp.homesList.get(i).getType().toString()).equalsIgnoreCase(getHomeType());
	}
}
