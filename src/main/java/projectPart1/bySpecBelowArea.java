package projectPart1;

public class bySpecBelowArea {

	private Integer area;

	public bySpecBelowArea(Integer area) {
		this.area = area;
		// TODO Auto-generated constructor stub
	}

	public Integer getArea() {
		return area;
	}

	boolean isSpecMatched(finderApp finderApp, int i) {
		return finderApp.homesList.get(i).getArea()<getArea().intValue();
	}

}
