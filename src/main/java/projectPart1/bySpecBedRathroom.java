package projectPart1;

public class bySpecBedRathroom {

	private Integer numberofbathrooms;

	public bySpecBedRathroom(Integer numberofbathrooms) {
		this.numberofbathrooms = numberofbathrooms;
		// TODO Auto-generated constructor stub
	}

	public Integer getNumberofbathrooms() {
		return numberofbathrooms;
	}

	boolean isSpecMatched(finderApp finderApp, int i) {
		return finderApp.homesList.get(i).getNo_of_bathrooms()==getNumberofbathrooms().intValue();
	}

}
