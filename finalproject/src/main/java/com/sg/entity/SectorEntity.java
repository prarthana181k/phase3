package com.sg.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="sector")
public class SectorEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private int sectorid;
	
	@Column(name="sector_name")
	private String sector_name;

	@Column
	private String Brief;

	@OneToMany(mappedBy="sector",targetEntity=CompanyEntity.class )
	 @JsonManagedReference
	 @JsonIgnore  
	 private List<CompanyEntity> company;

	public int getSectorid() {
		return sectorid;
	}





	public void setSectorid(int sectorid) {
		this.sectorid = sectorid;
	}





	public String getSector_name() {
		return sector_name;
	}





	public void setSector_name(String sector_name) {
		this.sector_name = sector_name;
	}





	public String getBrief() {
		return Brief;
	}





	public void setBrief(String brief) {
		Brief = brief;
	}





	public List<CompanyEntity> getCompany() {
		return company;
	}





	public void setCompany(List<CompanyEntity> company) {
		this.company = company;
	}





	public SectorEntity() {
		super();
		// TODO Auto-generated constructor stub
	}





	public SectorEntity(int sectorid, String sector_name, String brief, List<CompanyEntity> company) {
		super();
		this.sectorid = sectorid;
		this.sector_name = sector_name;
		Brief = brief;
		this.company = company;
	}
	
	
}
