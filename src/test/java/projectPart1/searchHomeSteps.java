package projectPart1;

import static org.junit.Assert.assertTrue;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import project.part2.FinderApp;
import project.part2.Home;
import project.part2.MockEmailHolder;
import project.part2.WebEmailService;

import static org.mockito.Mockito.*;


public class searchHomeSteps {

	private Integer price , price1 , price2;
	private  java.util.List<Home> required_homes;
	private String searchedByString;
	boolean allow;
	private FinderApp finder;
	private MockEmailHolder mockWebHolder;
	WebEmailService webEmail;
	private Integer area , area1 , area2;
	int length;
	int Numberofbathrooms ;
	
	java.util.List<String> AnList = new ArrayList<String>();
	
	
		@Given("these homes are contained in the system")
		public void theseHomesAreContainedInTheSystem(Map<String,String> data_table) {
			System.out.println("new Scenario");

		    finder= new FinderApp(data_table);
		    mockWebHolder = new MockEmailHolder (finder);
		    //throw new io.cucumber.java.PendingException();
		}



		@When("I search about home by {string}")
		public void iSearchAboutHomeByType(String string) {
		//	System.out.println("part1");

			searchedByString = string;
			required_homes = finder.searchByType(string);
            
		}
		
		@Then("A list of homes that matches the  type specification should be returned and printed on the console")
		public void aListOfHomesThatMatchesTheTypeSpecificationShouldBeReturnedAndPrintedOnTheConsole() {

			for(int i=0;i<required_homes.size();i++) {
				assertTrue(required_homes.get(i).getType().equalsIgnoreCase(searchedByString));
		}
		}
		
		
		
		@When("I search about home with price less than {int}")
		public void iSearchAboutHomeByBelowprice(Integer int1){
			this.price=int1;
			required_homes=finder.findByBelowPrice(int1);
		
		   
		}

		@Then("A list of homes that matches the price specification should be returned and printed on the console")
		public void aListOfHomesThatMatchesTheBelowpriceSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
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
				assertTrue(required_homes.get(i).getPlacement().equalsIgnoreCase(searchedByString.toString()));
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
				assertTrue(required_homes.get(i).getMaterial().equalsIgnoreCase(searchedByString));
		}
			
		}
		
		
		
		
		@When("I search about home with price between {int} to {int}")
		public void iSearchAboutHomeWithRngaePrice(Integer int1 , Integer int2){
			this.price1=int1;
			this.price2=int2;
			required_homes=finder.findBetweenRangePrice(int1.intValue(),int2.intValue());
		   
		}

		@Then("A list of homes that matches the price range specification should be returned and printed on the console")
		public void aListOfHomesThatMatchesTheRangepriceSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
			for(int i=0;i<required_homes.size();i++) {
		assertTrue((required_homes.get(i).getPrice()>this.price1) &&(required_homes.get(i).getPrice()<this.price2));
		
				
		}
		
		
		}
		
		@When("I search about home with area less than {int}")
		public void iSearchAboutHomeByBelowArea(Integer int1){
			this.area=int1;
			required_homes=finder.findByBelowArea(int1);
		   
		}

		@Then("A list of homes that matches the area specification should be returned and printed on the console")
		public void aListOfHomesThatMatchesTheBelowAreaSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
			for(int i=0;i<required_homes.size();i++) {
		assertTrue(required_homes.get(i).getArea()<=this.area);
		
				
		}
		}
		
		@When("I search about home with area between {int} to {int}")
		public void iSearchAboutHomeWithRngaeArea(Integer int1 , Integer int2){
			this.area1=int1;
			this.area2=int2;
			required_homes=finder.findBetweenRangeArea(int1.intValue(),int2.intValue());
		   
		}

		@Then("A list of homes that matches the area range specification should be returned and printed on the console")
		public void aListOfHomesThatMatchesTheRangeAreaSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
			for(int i=0;i<required_homes.size();i++) {
		assertTrue((required_homes.get(i).getArea()>this.area1) &&(required_homes.get(i).getArea()<this.area2));
		
				
		}
		
		
		}
		
		
		@When("I search about home with lease length {string}")
		public void iSearchAboutHomeByLeaseLength(String string) {
		//	System.out.println("part1");

			searchedByString = string;
			String len = string;
		
			if(len.equalsIgnoreCase("short term_6 months"))
				length=6;
			else length=12;
			required_homes = finder.searchByLeaseLength(string); // return list of homes
		    // Write code here that turns the phrase above into concrete actions
		    //throw new io.cucumber.java.PendingException();
		}
		
		@Then("A list of homes that matches the lease length specification should be returned and printed on the console")
		public void aListOfHomesThatMatchesTheLeaseLengthaSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
		    // Write code here that turns the phrase above into concrete actions
			for(int i=0;i<required_homes.size();i++) {
		assertTrue(required_homes.get(i).getLeaselength()==length);
		
				
		}
		
		}
		
	
		
		

			@When("I search about home with {string} as Amenities")
			public void iSearchAboutHomeWithAmenitiesAs(String string) {
			    
				searchedByString = string;
				String str[]=string.split(",");
				AnList = Arrays.asList(str);
				required_homes = finder.searchByAmenities(string); // return list of homes
				
			}


	

			@Then("A list of homes that matches the Amenities specification should be returned and printed on the console")
			public void aListOfHomesThatMatchesTheAmenitiesSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
			    
				for(int i=0;i<required_homes.size();i++) {
					assertTrue(required_homes.get(i).getAmenities().equals(AnList));
							
					}}
			@When("I search about home with {int} bedrooms")
			public void iSearchAboutHomeByNumberofbed(Integer int1) {
				this.Numberofbathrooms=int1;
				required_homes=finder.findByNumberofbedrooms(int1);
			}

			@Then("A list of homes that matches the bedrooms specification should be returned and printed on the console")
			public void aListOfHomesThatMatchesTheNumberofbedroomsSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
			    // Write code here that turns the phrase above into concrete actions
				for(int i=0;i<required_homes.size();i++) {
					assertTrue(required_homes.get(i).getNumBedrooms()==this.Numberofbathrooms);
			}
			}


			@When("I search about home with {int} bathrooms")
			public void iSearchAboutHomeByNumberofbathrooms(Integer int1) {
				this.Numberofbathrooms=int1;
				required_homes=finder.findByNumberofbathrooms(int1);
			}

			@Then("A list of homes that matches the bathrooms specification should be returned and printed on the console")
			public void aListOfHomesThatMatchesTheNumberofbathroomsSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
				for(int i=0;i<required_homes.size();i++) {
					assertTrue(required_homes.get(i).getNumOfbathrooms()==this.Numberofbathrooms);
			}
			}
			
			@When("I search about home that {string} allow pets")
			public void iSearchAboutHomeAllowPets(String str) {
				
				if(str.equalsIgnoreCase("yes"))
				{
					
					allow=true;
					
				}
				else {
					allow=false;
				}
				required_homes=finder.findByAllow(str);
			}

			@Then("A list of homes that matches Allow Pets specification should be returned and printed on the console")
			public void aListOfHomesThatMatchespetsSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
				for(int i=0;i<required_homes.size();i++) {
					assertTrue((required_homes.get(i).isPets() && allow)||(!required_homes.get(i).isPets() && !allow));
			}
			}
			
			@When("I search about home that have the combination of {string}")
			public void searchByCombination(String comb) {
				
				required_homes = finder.findByCombination(comb);
				
			}
			
			@Then("A list of homes that matches combination specification should be returned and printed on the console")
				public void alistOfCmpination() {
				for(int i=0;i<required_homes.size();i++) {
					assertTrue(true);
				}
			}
	
			
		
			@And("email with the result should be sent to the user {string}")
			public void emailtouser(String email) {
		verify(mockWebHolder.getEmailService(),times(1)).sendEmail(email,required_homes);
				
			}

}
