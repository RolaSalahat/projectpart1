package projectPart1;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import projectPart1.Home;
import projectPart1.WebEmailService;
import projectPart1.belowSpecPrice;
import projectPart1.bySpecPlacment;

public class finderApp {
	List<Home> homesList=new ArrayList<Home>();
	private List<Home> required_homes;
	private  WebEmailService emailService;
	//private List<String> amen_List=new ArrayList<String>();
	private Home home;
	Integer price;

	String amenities_array [];
	
	//public finderApp() {
		

//}
	public finderApp(Map<String,String> data_table) {
		int area;
		int no_of_bedrooms;
		int no_of_bathrooms;
		int lease_length;
		int id = 0;
		String homeType;
		String material ;
		String placement ;
		String keys_array [];
		String values_array [];
		
		
		boolean petsAvailable;
		
		Iterator<Entry<String, String>> data=data_table.entrySet().iterator();
          while(data.hasNext()) {
			id++;
		 List<String> amenities_List=new ArrayList<String>();
			Entry<String,String> nextdata=data.next();
			keys_array=nextdata.getKey().split("_"); // for keys in background
			amenities_array=keys_array[4].split(",");
			
			values_array=nextdata.getValue().split("_"); // for values
			for(int i=0;i<amenities_array.length;i++) {
				amenities_List.add(amenities_array[i]);
				
			                                            }
			
			try {
			homeType=keys_array[0];
			material =keys_array[1];
			placement = keys_array[2];
			if(keys_array[3].equalsIgnoreCase("YES")) {
			 petsAvailable = true;
			}
			else {
				petsAvailable=false;
			}
			
			price = Integer.parseInt(values_array[0]);
			area = Integer.parseInt(values_array[1]);
			no_of_bedrooms = Integer.parseInt(values_array[2]);
			no_of_bathrooms= Integer.parseInt(values_array[3]);
			lease_length= Integer.parseInt(values_array[4]);
			home = new Home (id,homeType ,material,placement,petsAvailable,amenities_List, price , area, no_of_bedrooms, no_of_bathrooms ,lease_length);
			homesList.add(home);
			
			}
			catch(Exception e) {
				System.out.println("exption");
			}
			
			
			
			
			
          } //while end
	} //constructer end
	
	
	public void setEmailService(WebEmailService emailService) {
		this.emailService = emailService;

		System.out.println("-----------------setEmailService");

	}
	
	
	public List<Home> searchByType(String homeType) {
		System.out.println("List of homes that have a Type of " +homeType);
		bySpecType spec = new bySpecType(homeType);
		required_homes=new ArrayList<Home>();
		for(int i=0;i<homesList.size();i++) {
			//Home homeOb = homesList.get(i);
			//String t = homeOb.getType();
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


	

	
	
	public List<Home> findByBelowPrice(Integer priceIn) {
		System.out.println("List of homes that cost below \""+Integer.toString(priceIn)+"\" per month:");
 belowSpecPrice spec = new  belowSpecPrice(priceIn);
		required_homes=new ArrayList<Home>();
		for(int i=0;i<homesList.size();i++) {
			if( spec.isSpecMatched(this, i)) {
				required_homes.add(homesList.get(i));
				System.out.println(Integer.toString(required_homes.size())+"-"+" "+homesList.get(i));
			}
		}
		
		sendingEmail();

		return this.required_homes;
	}


	public List<Home> findHomeByPlacement(String placmentString) {
		System.out.println("List of homes that is in " +placmentString);

		bySpecPlacment spec = new 	bySpecPlacment (placmentString);
		required_homes=new ArrayList<Home>();
		for(int i=0;i<homesList.size();i++) {
			if(spec.isSpecMatched(this, i)) {
				required_homes.add(homesList.get(i));
				System.out.println(Integer.toString(required_homes.size())+"-"+" "+homesList.get(i));

			}
		}

		// TODO Auto-generated method stub
		sendingEmail();

		return this.required_homes;

	}

	

	public List<Home> findHomeByMaterial(String MaterialString) {
		System.out.println("List of homes that its material is " +MaterialString);

		bySpecMaterial spec = new bySpecMaterial(MaterialString) ;
		
		required_homes=new ArrayList<Home>();
		for(int i=0;i<homesList.size();i++) {
			if(spec.isSpecMatched(this, i)) {
				required_homes.add(homesList.get(i));
				System.out.println(Integer.toString(required_homes.size())+"-"+" "+homesList.get(i));
			}

		}
		sendingEmail();

		return this.required_homes;}


	public List<Home> FindBetweenRangePrice(Integer price1, Integer price2) {
		System.out.println("List of homes that cost between\""+Integer.toString(price1)+" to "+Integer.toString(price2)+"\" per month:");

		betweenSpecRangePrice spec = new betweenSpecRangePrice(price1,price2); 
		required_homes=new ArrayList<Home>();

		for(int i=0;i<homesList.size();i++) {
		if(spec.isSpecMatched(this, i)) {
			required_homes.add(homesList.get(i));
			System.out.println(Integer.toString(required_homes.size())+"-"+" "+homesList.get(i));
		}
		}
		// TODO Auto-generated method stub
		sendingEmail();

		return this.required_homes;
	}


	public List<Home> findByBelowArea(Integer area) {
		System.out.println("List of homes that its area below "+Integer.toString(area)+ ":");

		bySpecBelowArea spec = new bySpecBelowArea (area);
		
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


	public List<Home> FindBetweenRangeArea(Integer area1, Integer area2) {
		System.out.println("List of homes that have area between "+Integer.toString(area1)+" to "+Integer.toString(area2));

		betweenSpecRangeArea spec = new betweenSpecRangeArea(area1, area2);
		
		
		required_homes=new ArrayList<Home>();
		for(int i=0;i<homesList.size();i++) {
		if(spec.isSpecMatched(this, i)) {
			required_homes.add(homesList.get(i));
			System.out.println(Integer.toString(required_homes.size())+"-"+" "+homesList.get(i));
		}
		}
		// TODO Auto-generated method stub
		sendingEmail();

		return this.required_homes;
	}


	public List<Home> searchByLeaseLength(String string) {
		// TODO Auto-generated method stub
		System.out.println("List of homes that its lease length is " +string);

		String len = string;
		int length;
		if(len.equalsIgnoreCase("short term_6 months"))
			length=6;
		else length=12;
		
		bySpecLeaseLength spec = new bySpecLeaseLength(length);
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


	public List<Home> searchByAmenities(String string) {
		String str[]=string.split(",");
		
		//List<String> AnList = new ArrayList<String>();
		//AnList = Arrays.asList(str);
		System.out.println("List of homes that have "+string+ "as Amenities is:" );
		
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

	public List<Home> FindByNumberofbathrooms(Integer Numberofbathrooms) {
		System.out.println("List of homes that has Numberofbathrooms of  \""+Integer.toString(Numberofbathrooms)+"\" ");
bySpecBedRathroom spec = new bySpecBedRathroom (Numberofbathrooms);
		
		
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


	public List<Home> FindByNumberofbedrooms(Integer Numberofbedrooms) {
		System.out.println("List of homes that has Numberofbedrooms of  \""+Integer.toString(Numberofbedrooms)+"\" ");

		BySpecBedrooms spec = new BySpecBedrooms(Numberofbedrooms);
		
		required_homes=new ArrayList<Home>();
		for(int i=0;i<homesList.size();i++) {
			if(spec.isSpecMatched(this, i)) {
				required_homes.add(homesList.get(i));
				System.out.println(Integer.toString(required_homes.size())+"-"+" "+homesList.get(i));
			}
		}
		sendingEmail();

		return this.required_homes;	}


	public List<Home> FindByallow(String str) {
		boolean allow = false;
		if(str.equalsIgnoreCase("yes"))
		{
			
			allow=true;
			
		}
		
		System.out.println("List of homes that has pets premisstion as  \""+str+"\" ");
ByAllowBits spec = new ByAllowBits(allow);
		
		
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


	
	
	
	
	
}

