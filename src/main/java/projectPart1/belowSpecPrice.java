package projectPart1;

public class belowSpecPrice {

	private Integer priceIn;

	public belowSpecPrice(Integer priceIn) {
		this.priceIn = priceIn;
		// TODO Auto-generated constructor stub
	}

	public Integer getPriceIn() {
		return priceIn;
	}

	boolean isSpecMatched(finderApp finderApp, int i) {
		return finderApp.homesList.get(i).getPrice()< getPriceIn().intValue();
	}


}
