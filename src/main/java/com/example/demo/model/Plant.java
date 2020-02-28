package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 

@Entity
@Table(name="TBL_PLANTS")
public class Plant{
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
     
    @Column(name="common_name")
    private String cName;
     
    @Column(name="scientific_name")
    private String sName;
     
    @Column(name="family", nullable=false, length=200)
    private String family;

    
  //Setters and getters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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
		return "PlantaEntity [id=" + id + ", cName=" + cName + ", sName=" + sName + ", family=" + family + "]";
	}
     
    
    
 
   
}
