package projectPart1;

public class betweenSpecRangeArea {

	private Integer area1;
	private Integer area2;

	public betweenSpecRangeArea(Integer area1, Integer area2) {
		this.area1 = area1;
		this.area2 = area2;
		// TODO Auto-generated constructor stub
	}

	public Integer getArea1() {
		return area1;
	}

	public Integer getArea2() {
		return area2;
	}

	boolean isSpecMatched(finderApp finderApp, int i) {
		return (finderApp.homesList.get(i).getArea()>getArea1().intValue())&&(finderApp.homesList.get(i).getArea()<getArea2().intValue());
	}

}
