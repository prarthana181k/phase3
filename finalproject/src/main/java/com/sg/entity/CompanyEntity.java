package com.sg.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="company")
public class CompanyEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Companyid;

	@Column(name ="CompanyName")
	private String CompanyName; 

	@Column(name="Turnover")
	private int Turnover;

	@Column(name="CEO")
	private String CEO;

	@Column(name =" BoardofDirector")
	private String Board_of_Directors;


	@Column(name="WriteUp")
	private String Write_Up;

	@OneToMany(mappedBy="company", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<IPODetailEntity> ipos;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonBackReference
	private SectorEntity sector;

	@ManyToMany
	@JoinTable(
			name = "company_stockexchange", 
			joinColumns = @JoinColumn(name = "companyid"), 
			inverseJoinColumns = @JoinColumn(name = "stockexchangeid"))
	List<StockExchangeEntity> StockExchangeList;

	public CompanyEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public CompanyEntity(int companyid, String companyName, int turnover, String cEO, String board_of_Directors,
			String write_Up, List<IPODetailEntity> ipos, SectorEntity sector,
			List<StockExchangeEntity> stockExchangeList) {
		super();
		Companyid = companyid;
		CompanyName = companyName;
		Turnover = turnover;
		CEO = cEO;
		Board_of_Directors = board_of_Directors;
		Write_Up = write_Up;
		this.ipos = ipos;
		this.sector = sector;
		StockExchangeList = stockExchangeList;
	}


	public int getCompanyid() {
		return Companyid;
	}


	public void setCompanyid(int companyid) {
		Companyid = companyid;
	}


	public String getCompanyName() {
		return CompanyName;
	}


	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}


	public int getTurnover() {
		return Turnover;
	}


	public void setTurnover(int turnover) {
		Turnover = turnover;
	}


	public String getCEO() {
		return CEO;
	}


	public void setCEO(String cEO) {
		CEO = cEO;
	}


	public String getBoard_of_Directors() {
		return Board_of_Directors;
	}


	public void setBoard_of_Directors(String board_of_Directors) {
		Board_of_Directors = board_of_Directors;
	}


	public String getWrite_Up() {
		return Write_Up;
	}


	public void setWrite_Up(String write_Up) {
		Write_Up = write_Up;
	}


	public List<IPODetailEntity> getIpos() {
		return ipos;
	}


	public void setIpos(List<IPODetailEntity> ipos) {
		this.ipos = ipos;
	}


	public SectorEntity getSector() {
		return sector;
	}


	public void setSector(SectorEntity sector) {
		this.sector = sector;
	}


	public List<StockExchangeEntity> getStockExchangeList() {
		return StockExchangeList;
	}


	public void setStockExchangeList(List<StockExchangeEntity> stockExchangeList) {
		StockExchangeList = stockExchangeList;
	}


	
	
	}
