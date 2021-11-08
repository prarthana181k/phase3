package com.sg.Services;

import java.util.List;

import com.sg.entity.SectorEntity;

public interface SectorServiceI {
	   public List<SectorEntity> getAllSectors();  
	   public SectorEntity getSector(Integer id);   
	   public SectorEntity addSector(SectorEntity sector) ;
	   public String deleteSector(Integer id);
	   public SectorEntity editSector(SectorEntity sector);	   

}
