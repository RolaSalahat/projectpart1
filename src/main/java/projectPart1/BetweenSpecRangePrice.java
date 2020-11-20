package projectPart1;

public class BetweenSpecRangePrice implements GeneralSpec{

	private Integer price1;
	private Integer price2;

	public BetweenSpecRangePrice(Integer price1, Integer price2) {
		this.price1 = price1;
		this.price2 = price2;
	}

	public boolean isSpecMatched(FinderApp finderApp, int i) {
		return (finderApp.homesList.get(i).getPrice()>price1.intValue())&&(finderApp.homesList.get(i).getPrice()<price2.intValue());
	}

}
