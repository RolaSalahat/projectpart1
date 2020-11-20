package projectPart1;

public class BySpecBathroom implements GeneralSpec {

	private Integer numberofbathrooms;

	public BySpecBathroom(Integer numberofbathrooms) {
		this.numberofbathrooms = numberofbathrooms;
	}

	public Integer getNumberofbathrooms() {
		return numberofbathrooms;
	}

	public boolean isSpecMatched(FinderApp finderApp, int i) {
		return finderApp.homesList.get(i).getNumOfbathrooms()==getNumberofbathrooms().intValue();
	}

}
