package projectPart1;

public class BySpecCombination implements GeneralSpec {
	private String[] specList;
	private boolean isMatched;
	private Home home;
	FinderApp finder ;
   int index ;


	public BySpecCombination(String[] specList2) {
		specList= specList2;
	}
	
	
	
	private void combineSpec(GeneralSpec spec) {
		if(!spec.isSpecMatched(finder,index)) {
			this.isMatched=false;
		}
	}
	

	private boolean isSpec(int num) {
		
		return (specList.length>num&&!specList[num].equals("-"));
	}
	
	
	public boolean isSpecMatched(FinderApp finderApp, int i) 
	{
		this.index=i;
     finder =finderApp	;
      isMatched=true;
		
      if(isSpec(0)) {
  		GeneralSpec spec=new BySpecPlacment(specList[0]);
  		combineSpec(spec);
  	}
		
    
  	if(isSpec(1)) {
  		GeneralSpec spec=new BelowSpecPrice(Integer.parseInt(specList[1]));
  		combineSpec(spec);
  	}
      
  	
    if(isSpec(2)) {
  		GeneralSpec spec=new BySpecType(specList[2]);
  		combineSpec(spec);
  	}
    
  	if(isSpec(3)) {
  		GeneralSpec spec=new BySpecMaterial(specList[3]);
  		combineSpec(spec);
  	}
  	
  	if(isSpec(4)) {
		GeneralSpec spec=new BySpecBelowArea(Integer.parseInt(specList[4]));
		combineSpec(spec);
	}
  	if(isSpec(5)) {
  		GeneralSpec spec=new BySpecLeaseLength(Integer.parseInt(specList[5]));
  		combineSpec(spec);
  	}
  	
  	
  	if(isSpec(6)) {
  		GeneralSpec spec=new BySpecBedrooms(Integer.parseInt(specList[6]));
  		combineSpec(spec);
  	}
  	if(isSpec(7)) {
  		GeneralSpec spec=new BySpecBathroom(Integer.parseInt(specList[7]));
  		combineSpec(spec);
  	}
  	
  	
  	if(isSpec(8)) {
  		boolean allow=false;
  		if(specList[8].equalsIgnoreCase("yes"))
  			allow=true;
  		GeneralSpec spec=new ByAllowBits(allow);
  		combineSpec(spec);
  	}
  	
      
  	if(isSpec(9)&&isSpec(10)) {
		GeneralSpec spec=new BetweenSpecRangePrice(Integer.parseInt(specList[9]),Integer.parseInt(specList[10]));
		combineSpec(spec);
	}
	if(isSpec(11)&&isSpec(12)) {
		GeneralSpec spec=new BetweenSpecRangeArea(Integer.parseInt(specList[11]),Integer.parseInt(specList[12]));
		combineSpec(spec);
	}
	
	/*if(isSpec(13)) {
		GeneralSpec spec=new bySpecAmenities(specList[13]);
		combineSpec(spec);
	}*/
	return isMatched;
      
     
		
		
	}
	
	

}
