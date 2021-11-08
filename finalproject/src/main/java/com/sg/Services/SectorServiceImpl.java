package com.sg.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sg.Repository.SectorRepositoryI;
import com.sg.entity.SectorEntity;

@Service
public class SectorServiceImpl implements SectorServiceI  {
    private SectorRepositoryI sectorRepository;
    
    public List<SectorEntity> getAllSectors()
    {
        return (List<SectorEntity>) sectorRepository.findAll();
    }
    
    public SectorEntity getSector(Integer id)
    {
        Optional<SectorEntity> sector=sectorRepository.findById(id);
        return sector.isPresent() ? sector.get() : null;
    }
    
    public SectorEntity addSector(SectorEntity sector)
    {
    	SectorEntity newSector=sectorRepository.save(sector);
        return newSector;
    }
    
    public String deleteSector(Integer id){
        sectorRepository.deleteById(id);
        return "Sector Deleted";
    }
    
    public SectorEntity editSector(SectorEntity sector){

    	SectorEntity savedSector=sectorRepository.save(sector);
        return savedSector;

    }
}