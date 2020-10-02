package projectPart1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class finderApp {
	private List<Home> homesList=new ArrayList<Home>();
	private List<Home> required_homes;
	private Home home;
	Integer price;

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
		String amenities_array [];
		
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

	
	
	
	
}
