package project.part2;

public class Home {
	
	
	private int id , price ,area , noOfBedrooms,noOfBathrooms , leaseLen;
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
	public Home(int id,String type,String material,String placement,boolean pets,java.util.List<String> amenitiesList,int price,int area,int bedrooms,int bathrooms,int leaselength) 
		{ this.id=id;
		this.placement=placement;
		this.material=material;
		this.area=area;
		this.price=price;
		this.noOfBedrooms=bedrooms;
		this.noOfBathrooms=bathrooms;
		this.pets=pets;
		this.type=type;
		this.leaseLen=leaselength;
		this.amenities=amenitiesList;
		
		int size =amenities.size();
		 AmenitiesArray= new String[size];

		for(int i=0;i<size;i++) {
			AmenitiesArray[i]=amenities.get(i);
		}
			
		}
	
	
	@Override
	public String toString() {
	
		return "[Home ID = "+id+" Placement = "+placement+
				" Material = "+material+" Area = "+area+" price = "+price+
				" bedrooms= "+noOfBedrooms+" bathrooms= "+noOfBathrooms+
				" pets allowed  = "+pets+" type = "+type+
				" leaselength = "+leaseLen+" amenties = "+amenities.toString()+"]"
				;
	}
	
	
	
	public int getId() {
		return id;
	}

	public int getNumBedrooms() {
		return noOfBedrooms;
	}

	public int getLeaselength() {
		return leaseLen;
	}

	public int getNumOfbathrooms() {
		return noOfBathrooms;
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
