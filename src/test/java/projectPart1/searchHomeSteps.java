package projectPart1;

import static org.junit.Assert.assertTrue;

import java.awt.List;
import java.util.Map;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class searchHomeSteps {
	private Integer price , price1 , price2;
	private  java.util.List<Home> required_homes;
	private String searchedByString;
	private String homeType;
	private int num=1;
	private finderApp finder;
	
		@Given("these homes are contained in the system")
		public void theseHomesAreContainedInTheSystem(Map<String,String> data_table) {
			System.out.println("new Scenario");

		    finder =new finderApp(data_table);
		    //throw new io.cucumber.java.PendingException();
		}



		@When("I search about home by {string}")
		public void iSearchAboutHomeByType(String string) {
		//	System.out.println("part1");

			searchedByString = string;
			required_homes = finder.searchByType(string); // return list of homes
		    // Write code here that turns the phrase above into concrete actions
		    //throw new io.cucumber.java.PendingException();
		}
		
		@Then("A list of homes that matches the  type specification should be returned and printed on the console")
		public void aListOfHomesThatMatchesTheTypeSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
		//System.out.println("part1");

			for(int i=0;i<required_homes.size();i++) {
				assertTrue(required_homes.get(i).getType().equalsIgnoreCase(searchedByString));

		    // Write code here that turns the phrase above into concrete actions
		   // throw new io.cucumber.java.PendingException();
		}
		}
		
		@When("I search about home with price less than {int}")
		public void iSearchAboutHomeByBelowprice(Integer int1){
		    // Write code here that turns the phrase above into concrete actions
			this.price=int1;
			required_homes=finder.FindByBelowPrice(int1);
		   
		}

		@Then("A list of homes that matches the price specification should be returned and printed on the console")
		public void aListOfHomesThatMatchesTheBelowpriceSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
		    // Write code here that turns the phrase above into concrete actions
			for(int i=0;i<required_homes.size();i++) {
		assertTrue(required_homes.get(i).getPrice()<=this.price);
		
				
		}
		}
		
		@When("I search about home by {string} as a placment")
		public void iSearchAboutHomeByPlacment(String string) {
			searchedByString = string;
			if(string.equalsIgnoreCase("CITY")||string.equalsIgnoreCase("VILLAGE")) {
				required_homes=finder.findHomeByPlacement(string); //finds and prints
			}

		}
		
		@Then("A list of homes that matches the placement specification should be returned and printed on the console")
		public void aListOfHomesThatMatchesThePlacementSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
			for(int i=0;i<required_homes.size();i++) {
				assertTrue(required_homes.get(i).getType().equalsIgnoreCase(searchedByString.toString()));
		}
			
		}
		
		
		
		@When("I search about home by {string} material")
		public void iSearchAboutHomeByMaterial(String string) {
			searchedByString = string;
			if(string.equalsIgnoreCase("WOOD")||string.equalsIgnoreCase("STONE")||string.equalsIgnoreCase("BRIKE")) {
				required_homes=finder.findHomeByMaterial(string); //finds and prints
			}

		}
		
		
		@Then("A list of homes that matches the material specification should be returned and printed on the console")
		public void aListOfHomesThatMatchesTheMaterialSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
			for(int i=0;i<required_homes.size();i++) {
				assertTrue(required_homes.get(i).getType().equalsIgnoreCase(searchedByString));
		}
			
		}
		
		
		
		
		@When("I search about home with price between {int} to {int}")
		public void iSearchAboutHomeWithRngaePrice(Integer int1 , Integer int2){
		    // Write code here that turns the phrase above into concrete actions
			this.price1=int1;
			this.price2=int2;
			required_homes=finder.FindBetweenRangePrice(int1.intValue(),int2.intValue());
		   
		}

		@Then("A list of homes that matches the price range specification should be returned and printed on the console")
		public void aListOfHomesThatMatchesTheRangepriceSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
		    // Write code here that turns the phrase above into concrete actions
			for(int i=0;i<required_homes.size();i++) {
		assertTrue((required_homes.get(i).getPrice()>this.price1) &&(required_homes.get(i).getPrice()<this.price2));
		
				
		}
		
		
		}
		
		
		
		
		
		

}
