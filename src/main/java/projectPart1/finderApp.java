package projectPart1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class finderApp {
	private List<Home> homesList=new ArrayList<Home>();
	private List<Home> required_homes;
	
	private List<String> amen_List=new ArrayList<String>();
	private Home home;
	Integer price;

	String amenities_array [];
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
				System.out.println("Oh!!");
			}
			
			
			
			
			
          } //while end
	} //constructer end
	
	public List<Home> searchByType(String homeType) {
		required_homes=new ArrayList<Home>();
		System.out.println("List of homes that have a Type of " +homeType);
		for(int i=0;i<homesList.size();i++) {
			Home homeOb = homesList.get(i);
			String t = homeOb.getType();
			if((t.toString()).equalsIgnoreCase(homeType)) {
				required_homes.add(homeOb);
				System.out.println(Integer.toString(required_homes.size())+"-"+" "+homesList.get(i));
			}
		}
		return this.required_homes;
	}

	public List<Home> FindByBelowPrice(Integer int1) {
		required_homes=new ArrayList<Home>();
		System.out.println("List of homes that cost below \""+Integer.toString(int1)+"\" per month:");
		for(int i=0;i<homesList.size();i++) {
			if(homesList.get(i).getPrice()<int1.intValue()) {
				required_homes.add(homesList.get(i));
				System.out.println(Integer.toString(required_homes.size())+"-"+" "+homesList.get(i));
			}
		}
		return this.required_homes;
	}

	public List<Home> findHomeByPlacement(String placmentString) {
		required_homes=new ArrayList<Home>();
		System.out.println("List of homes that is in " +placmentString);
		for(int i=0;i<homesList.size();i++) {
			if(homesList.get(i).getPlacement().equalsIgnoreCase(placmentString)) {
				required_homes.add(homesList.get(i));
				System.out.println(Integer.toString(required_homes.size())+"-"+" "+homesList.get(i));

			}
		}

		// TODO Auto-generated method stub
		return this.required_homes;

	}

	public List<Home> findHomeByMaterial(String MaterialString) {
		required_homes=new ArrayList<Home>();
		System.out.println("List of homes that its material is " +MaterialString);
		for(int i=0;i<homesList.size();i++) {
			if(homesList.get(i).getMaterial().equalsIgnoreCase(MaterialString)) {
				required_homes.add(homesList.get(i));
				System.out.println(Integer.toString(required_homes.size())+"-"+" "+homesList.get(i));
			}

		}
		return this.required_homes;}

	
	public List<Home> FindBetweenRangePrice(Integer int1, Integer int2) {
		required_homes=new ArrayList<Home>();
		System.out.println("List of homes that cost between\""+Integer.toString(int1)+" to "+Integer.toString(int2)+"\" per month:");
		for(int i=0;i<homesList.size();i++) {
		if((homesList.get(i).getPrice()>int1.intValue())&&(homesList.get(i).getPrice()<int2.intValue())) {
			required_homes.add(homesList.get(i));
			System.out.println(Integer.toString(required_homes.size())+"-"+" "+homesList.get(i));
		}
		}
		// TODO Auto-generated method stub
		return this.required_homes;
	}

	public List<Home> FindByBelowArea(Integer int1) {
		// TODO Auto-generated method stub
		required_homes=new ArrayList<Home>();
		System.out.println("List of homes that its area below "+Integer.toString(int1)+ ":");
		for(int i=0;i<homesList.size();i++) {
			if(homesList.get(i).getArea()<int1.intValue()) {
				required_homes.add(homesList.get(i));
				System.out.println(Integer.toString(required_homes.size())+"-"+" "+homesList.get(i));
			}
		}
		return this.required_homes;
	}

	public List<Home> FindBetweenRangeArea(Integer int1, Integer int2) {
		// TODO Auto-generated method stub
		required_homes=new ArrayList<Home>();
		System.out.println("List of homes that have area between "+Integer.toString(int1)+" to "+Integer.toString(int2));
		for(int i=0;i<homesList.size();i++) {
		if((homesList.get(i).getArea()>int1.intValue())&&(homesList.get(i).getArea()<int2.intValue())) {
			required_homes.add(homesList.get(i));
			System.out.println(Integer.toString(required_homes.size())+"-"+" "+homesList.get(i));
		}
		}
		// TODO Auto-generated method stub
		return this.required_homes;
	}

	public List<Home> searchByLeaseLength(String string) {
		// TODO Auto-generated method stub
		String len = string;
		int length;
		if(len.equalsIgnoreCase("short term_6 months"))
			length=6;
		else length=12;
		required_homes=new ArrayList<Home>();
		System.out.println("List of homes that its lease length is " +string);
		for(int i=0;i<homesList.size();i++) {
			if(homesList.get(i).getLease_length()==length) {
				required_homes.add(homesList.get(i));
				System.out.println(Integer.toString(required_homes.size())+"-"+" "+homesList.get(i));
			}

		}
		return this.required_homes;
	}

	public List<Home> searchByAmenities(String string) {
		// TODO Auto-generated method stub
		required_homes=new ArrayList<Home>();
		String str[]=string.split(",");
		
		//List<String> AnList = new ArrayList<String>();
		//AnList = Arrays.asList(str);
		System.out.println("List of homes that have "+string+ "as Amenities is:" );
		for(int i=0;i<homesList.size();i++) {
			String am[] = homesList.get(i).getAmenitiesArray();
			if(str.length== homesList.get(i).getAmenitiesArray().length)
			{for(int k=0; k<str.length ;k++) {
			    if(str[k].equalsIgnoreCase(am[k])){
				     required_homes.add(homesList.get(i));
			}          }

		     System.out.println(Integer.toString(required_homes.size())+"-"+" "+homesList.get(i));}

		}
		
		
		return this.required_homes;
	}

	public List<Home> FindByNumberofbathrooms(Integer Numberofbathrooms) {
		required_homes=new ArrayList<Home>();
	System.out.println("List of homes that has Numberofbathrooms of  \""+Integer.toString(Numberofbathrooms)+"\" ");
	for(int i=0;i<homesList.size();i++) {
		if(homesList.get(i).getNo_of_bathrooms()==Numberofbathrooms.intValue()) {
			required_homes.add(homesList.get(i));
			System.out.println(Integer.toString(required_homes.size())+"-"+" "+homesList.get(i));
		}
	}
	return this.required_homes;
}

	public List<Home> FindByNumberofbedrooms(Integer Numberofbedrooms) {
		// TODO Auto-generated method stub
		required_homes=new ArrayList<Home>();
		System.out.println("List of homes that has Numberofbedrooms of  \""+Integer.toString(Numberofbedrooms)+"\" ");
		for(int i=0;i<homesList.size();i++) {
			if(homesList.get(i).getNo_of_bedrooms()==Numberofbedrooms.intValue()) {
				required_homes.add(homesList.get(i));
				System.out.println(Integer.toString(required_homes.size())+"-"+" "+homesList.get(i));
			}
		}
		return this.required_homes;	}

	public List<Home> FindByallow(String str) {
		boolean allow;
		if(str.equalsIgnoreCase("yes"))
		{
			
			allow=true;
			
		}
		else {
			allow=false;
		}
		
		required_homes=new ArrayList<Home>();
		System.out.println("List of homes that has pets premisstion as  \""+str+"\" ");
		for(int i=0;i<homesList.size();i++) {
			if((homesList.get(i).isPets() && allow)||(!homesList.get(i).isPets() && !allow)) {
				required_homes.add(homesList.get(i));
				System.out.println(Integer.toString(required_homes.size())+"-"+" "+homesList.get(i));
			}
		}
		return this.required_homes;
	}

	
	
	
	
}
