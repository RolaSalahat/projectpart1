package projectPart1;

public class BySpecBedrooms {

	private Integer numberofbedrooms;

	public BySpecBedrooms(Integer numberofbedrooms) {
		this.numberofbedrooms = numberofbedrooms;
		// TODO Auto-generated constructor stub
	}

	public Integer getNumberofbedrooms() {
		return numberofbedrooms;
	}

	boolean isSpecMatched(finderApp finderApp, int i) {
		return finderApp.homesList.get(i).getNo_of_bedrooms()==getNumberofbedrooms().intValue();
	}

}
