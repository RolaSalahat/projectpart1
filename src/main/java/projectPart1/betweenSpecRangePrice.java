package projectPart1;

public class betweenSpecRangePrice {

	private Integer price1;
	private Integer price2;

	public betweenSpecRangePrice(Integer price1, Integer price2) {
		this.price1 = price1;
		this.price2 = price2;
		// TODO Auto-generated constructor stub
	}

	public Integer getPrice1() {
		return price1;
	}

	public Integer getPrice2() {
		return price2;
	}

	boolean isSpecMatched(finderApp finderApp, int i) {
		return (finderApp.homesList.get(i).getPrice()>getPrice1().intValue())&&(finderApp.homesList.get(i).getPrice()<getPrice2().intValue());
	}

}
