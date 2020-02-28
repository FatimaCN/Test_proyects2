package domain;

public class PlantRequest {
	 

    private String cName;
	private String sName;
	private String family;

	    
    //Setters and getters
	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}
	
    public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	@Override
	public String toString() {
		return "PlantaEntity [cName=" + cName + ", sName=" + sName + ", family=" + family + "]";
	}
	    	
}
