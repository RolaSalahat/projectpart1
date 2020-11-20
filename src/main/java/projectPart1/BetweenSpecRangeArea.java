package projectPart1;

public class BetweenSpecRangeArea implements GeneralSpec {

	private Integer area1;
	private Integer area2;

	public BetweenSpecRangeArea(Integer area1, Integer area2) {
		this.area1 = area1;
		this.area2 = area2;
	}

	public boolean isSpecMatched(FinderApp finderApp, int i) {
		return (finderApp.homesList.get(i).getArea()>area1.intValue())&&(finderApp.homesList.get(i).getArea()<area2.intValue());
	}

}
