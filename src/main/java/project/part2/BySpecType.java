package project.part2;

public class BySpecType implements GeneralSpec {

	private String homeType;

	public BySpecType(String homeType) {
		this.homeType = homeType;
	}

	public String getHomeType() {
		return homeType;
	}
	
	public boolean isSpecMatched(FinderApp finderApp, int i) {
		return (finderApp.homesList.get(i).getType().toString()).equalsIgnoreCase(homeType);
	}
}
