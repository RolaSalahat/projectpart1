package projectPart1;

public class BySpecBedrooms implements GeneralSpec {

	private Integer numberofbedrooms;

	public BySpecBedrooms(Integer numberofbedrooms) {
		this.numberofbedrooms = numberofbedrooms;
	}

	public Integer getNumberofbedrooms() {
		return numberofbedrooms;
	}

	public	boolean isSpecMatched(FinderApp finderApp, int i) {
		return finderApp.homesList.get(i).getNumBedrooms()==getNumberofbedrooms().intValue();
	}

}
