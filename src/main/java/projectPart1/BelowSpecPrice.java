package projectPart1;

public class BelowSpecPrice implements GeneralSpec {

	private Integer priceIn;

	public BelowSpecPrice(Integer priceIn) {
		this.priceIn = priceIn;
	}

	public Integer getPriceIn() {
		return priceIn;
	}

	public boolean isSpecMatched(FinderApp finderApp, int i) {
		return finderApp.homesList.get(i).getPrice()< getPriceIn().intValue();
	}


}
