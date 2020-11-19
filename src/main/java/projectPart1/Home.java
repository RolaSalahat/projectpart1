package projectPart1;

public class Home {
	
	
	private int id , price ,area , no_of_bedrooms,no_of_bathrooms , lease_length;
	private boolean pets;
	private String type;
	private java.util.List<String>  amenities;
	
	private String placement;
	private String material;
	String[] AmenitiesArray ;
	
	public Home(int id,String type) {
		this.id=id;
		this.type=type;
	}
	public Home(int id,String type,String material,String placement,boolean pets,java.util.List<String> amenities_List,int price,int area,int bedrooms,int bathrooms,int leaselength) 
		{ this.id=id;
		this.placement=placement;
		this.material=material;
		this.area=area;
		this.price=price;
		this.no_of_bedrooms=bedrooms;
		this.no_of_bathrooms=bathrooms;
		this.pets=pets;
		this.type=type;
		this.lease_length=leaselength;
		this.amenities=amenities_List;
		
		int size =amenities.size();
		 AmenitiesArray= new String[size];

		for(int i=0;i<size;i++) {
			AmenitiesArray[i]=amenities.get(i);
		}
			
		}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
	
		return "[Home ID = "+id+" Placement = "+placement+
				" Material = "+material+" Area = "+area+" price = "+price+
				" bedrooms= "+no_of_bedrooms+" bathrooms= "+no_of_bathrooms+
				" pets allowed  = "+pets+" type = "+type+
				" leaselength = "+lease_length+" amenties = "+amenities.toString()+"]"
				;
	}
	
	
	
	public int getId() {
		return id;
	}

	public int getNo_of_bedrooms() {
		return no_of_bedrooms;
	}

	public int getLease_length() {
		return lease_length;
	}

	public int getNo_of_bathrooms() {
		return no_of_bathrooms;
	}
	

	public int getArea() {
		return area;
	}

	public boolean isPets() {
		return pets;
	}


	public String getPlacement() {
		return placement.toString();
	}


	public String getMaterial() {
		return material.toString();
	}

	public String getType() {
		return type;
	}

	public java.util.List<String> getAmenities() {
		return amenities;
	}


	public int getPrice() {
		return price;
	}


	public String[] getAmenitiesArray() {
		
		return AmenitiesArray;
		
	}

}
