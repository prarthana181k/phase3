package com.sg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sg.Services.SectorServiceI;
import com.sg.entity.SectorEntity;

@RestController
@RequestMapping("/sector")
@CrossOrigin(origins = "http://localhost:3000")
public class SectorController {
	@Autowired  
	SectorServiceI sectorservice;
	  
	  
	  @GetMapping("/all")
		public ResponseEntity<List<SectorEntity>> sectorlist()
		{
			return new ResponseEntity<List<SectorEntity>>(sectorservice.getAllSectors(),HttpStatus.OK);
		}
	  
	  
	  @GetMapping("/{sectorid}")
		public ResponseEntity<SectorEntity> sectorbyId(@PathVariable("sectorid") Integer sectorid)
		{
			return new ResponseEntity<SectorEntity>((SectorEntity) sectorservice.getSector(sectorid),HttpStatus.OK);
	   }

       @PostMapping("/addSector")
       public ResponseEntity<String> addSector(@PathVariable("sectorname")String sectorname, @RequestBody SectorEntity sectorentity)
       {      
       sectorservice.addSector(sectorentity);
       return  new ResponseEntity<String>("Sector is added", HttpStatus.OK); 
       }
       
       
       
       
}