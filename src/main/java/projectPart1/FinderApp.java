package projectPart1;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class FinderApp {
	List<Home> homesList=new ArrayList<Home>();
	private List<Home> required_homes;
	private  WebEmailService emailService;
	private Home home;
	Integer price;
	final static Logger logger =Logger.getLogger(FinderApp.class);
	String amenitiesArray [];
	
	public FinderApp(Map<String,String> dataaTable) {
		int area;
		int numOfBedrooms;
		int numOfBathrooms;
		int leasLength;
		int id = 0;
		String homeType;
		String material ;
		String placement ;
		String [] keyArray ;
		String [] valuesArray ;
		//final static Logger logger = Logger.getLogger(FinderApp.class);
		
		boolean petsAvailable;
		
		Iterator<Entry<String, String>> data=dataaTable.entrySet().iterator();
          while(data.hasNext()) {
			id++;
		 List<String> amenities_List=new ArrayList<String>();
			Entry<String,String> nextdata=data.next();
			keyArray=nextdata.getKey().split("_"); // for keys in background
			amenitiesArray=keyArray[4].split(",");
			
			valuesArray=nextdata.getValue().split("_"); // for values
			for(int i=0;i<amenitiesArray.length;i++) {
				amenities_List.add(amenitiesArray[i]);
				
			                                            }
			
			try {
			homeType=keyArray[0];
			material =keyArray[1];
			placement = keyArray[2];
			if(keyArray[3].equalsIgnoreCase("YES")) {
			 petsAvailable = true;
			}
			else {
				petsAvailable=false;
			}
			
			price = Integer.parseInt(valuesArray[0]);
			area = Integer.parseInt(valuesArray[1]);
			numOfBedrooms = Integer.parseInt(valuesArray[2]);
			numOfBathrooms= Integer.parseInt(valuesArray[3]);
			leasLength= Integer.parseInt(valuesArray[4]);
			home = new Home (id,homeType ,material,placement,petsAvailable,amenities_List, price , area, numOfBedrooms, numOfBathrooms ,leasLength);
			homesList.add(home);
			
			}
			catch(Exception e) {
				logger.log(Level.INFO, "exption");
			}
			
		
			
          } 
	} 
	
	
	public void setEmailService(WebEmailService emailService) {
		this.emailService = emailService;
	}
	
	
	public List<Home> searchByType(String homeType) {
		System.out.println("List of homes that have a Type of " +homeType);
		
		GeneralSpec spec = new BySpecType(homeType);
		return bySpec(spec);
	}


	
	public List<Home> findByBelowPrice(Integer priceIn) {
		System.out.println("List of homes that cost below \""+Integer.toString(priceIn)+"\" per month:");
 GeneralSpec spec = new  BelowSpecPrice(priceIn);
		return bySpec(spec);
	}


	public List<Home> findHomeByPlacement(String placmentString) {
		System.out.println("List of homes that is in " +placmentString);

		GeneralSpec spec = new 	BySpecPlacment (placmentString);
		return bySpec(spec);

	}

	

	public List<Home> findHomeByMaterial(String materialString) {
		System.out.println("List of homes that its material is " +materialString);

		GeneralSpec spec = new BySpecMaterial(materialString) ;
		
		return bySpec(spec);}


	public List<Home> findBetweenRangePrice(Integer price1, Integer price2) {
		System.out.println("List of homes that cost between\""+Integer.toString(price1)+" to "+Integer.toString(price2)+"\" per month:");

		GeneralSpec spec = new BetweenSpecRangePrice(price1,price2); 
		return bySpec(spec);
	}


	public List<Home> findByBelowArea(Integer area) {
		System.out.println("List of homes that its area below "+Integer.toString(area)+ ":");

		GeneralSpec spec = new BySpecBelowArea (area);
		
		return bySpec(spec);
	}


	public List<Home> findBetweenRangeArea(Integer area1, Integer area2) {
		System.out.println("List of homes that have area between "+Integer.toString(area1)+" to "+Integer.toString(area2));

		GeneralSpec spec = new BetweenSpecRangeArea(area1, area2);
		
		
		return bySpec(spec);
	}


	public List<Home> searchByLeaseLength(String string) {
		System.out.println("List of homes that its lease length is " +string);

		String len = string;
		int length;
		if(len.equalsIgnoreCase("short term_6 months"))
			length=6;
		else length=12;
		
		GeneralSpec spec = new BySpecLeaseLength(length);
		return bySpec(spec);
	}


	public List<Home> searchByAmenities(String amString) {
		
		String str[]=amString.split(",");
		
		System.out.println("List of homes that have "+amString+ "as Amenities is:" );
		
	    bySpecAmenities spec = new bySpecAmenities();
		required_homes=new ArrayList<Home>();
		for(int i=0;i<homesList.size();i++) {
			String am[] = homesList.get(i).getAmenitiesArray();
			if(str.length== homesList.get(i).getAmenitiesArray().length)
				
			{for(int k=0; k<str.length ;k++) {
			    if(str[k].equalsIgnoreCase(am[k])){
				     required_homes.add(homesList.get(i));
			}          }

		     System.out.println(Integer.toString(required_homes.size())+"-"+" "+homesList.get(i));}

		}
		
		sendingEmail();

		return this.required_homes;
	}

	public List<Home> findByNumberofbathrooms(Integer numberofbathrooms) {
		System.out.println("List of homes that has Numberofbathrooms of  \""+Integer.toString(numberofbathrooms)+"\" ");
		 GeneralSpec spec = new BySpecBathroom (numberofbathrooms);
		
		
		return bySpec(spec);
}


	public List<Home> findByNumberofbedrooms(Integer numberofbedrooms) {
		System.out.println("List of homes that has Numberofbedrooms of  \""+Integer.toString(numberofbedrooms)+"\" ");

		GeneralSpec spec = new BySpecBedrooms(numberofbedrooms);
		
		return bySpec(spec);	}


	public List<Home> findByAllow(String str) {
		boolean allow = false;
		if(str.equalsIgnoreCase("yes"))
		{
			
			allow=true;
			
		}
		
		System.out.println("List of homes that has pets premisstion as  \""+str+"\" ");
		
		
		GeneralSpec spec = new ByAllowBits(allow);
		
		
		return bySpec(spec);
	}

	public List<Home> findByCombination(String combination ){
		System.out.println("List of homes that has combination as  \""+combination+"\" ");
		
		String []specList =  combination.split(",");
		BySpecCombination spec = new BySpecCombination(specList);
		
			return bySpec(spec);

	}

	private List<Home> bySpec(GeneralSpec spec) {
		required_homes=new ArrayList<Home>();
		for(int i=0;i<homesList.size();i++) {
			if(spec.isSpecMatched(this, i)) {
				required_homes.add(homesList.get(i));
				System.out.println(Integer.toString(required_homes.size())+"-"+" "+homesList.get(i));
			}
		}
		sendingEmail();

		return this.required_homes;
	}


	
	private void sendingEmail() {
		emailService.sendEmail("salahatr9@gmail.com", required_homes);
	}
	
	
	
}

