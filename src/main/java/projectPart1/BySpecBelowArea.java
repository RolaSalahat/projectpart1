package projectPart1;

public class BySpecBelowArea implements GeneralSpec {

	private Integer area;

	public BySpecBelowArea(Integer area) {
		this.area = area;
	}

	public Integer getArea() {
		return area;
	}

	public boolean isSpecMatched(FinderApp finderApp, int i) {
		return finderApp.homesList.get(i).getArea()<getArea().intValue();
	}

}
