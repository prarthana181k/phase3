package com.sg.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sg.Repository.CompanyRepositoryI;
import com.sg.Repository.IPORepositoryI;
import com.sg.Services.IPOServiceI;
import com.sg.entity.CompanyEntity;
import com.sg.entity.IPODetailEntity;
import com.sg.entity.SectorEntity;

@RestController
@RequestMapping("/ipo")
@CrossOrigin(origins = "http://localhost:3000")
public class IPOController {
	@Autowired
	IPOServiceI iposervice;
	
	@Autowired
	IPORepositoryI ipo;
	
	
	@Autowired
	CompanyRepositoryI companyrepository;

	
	@RequestMapping
	public ModelAndView index () {
	    ModelAndView modelAndView = new ModelAndView();
	    modelAndView.setViewName("normal/ipo");
	    return modelAndView;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<IPODetailEntity>> ipolist()
	{ 		
		return new ResponseEntity<List<IPODetailEntity>>(iposervice.getAllIpo(),HttpStatus.OK);
	}
	
    @PostMapping("/addipo")
	public ResponseEntity<String> addIpo(
	@RequestBody IPODetailEntity ipoentity){      
	            
	iposervice.addIpo(ipoentity);
	return  new ResponseEntity<String>("IPO is added of "+ipoentity.getCompany_Name(), HttpStatus.OK); 
	}
    
    @GetMapping("/viewcompany/{page}")
    public String showCompany(@PathVariable("page") Integer page,Model model)
    {
    model.addAttribute("title","View Company");

    Pageable pg = (Pageable) PageRequest.of(page, 4);

    Page<CompanyEntity> companylist = this.companyrepository.findallCompany(pg);
    model.addAttribute("companylist",companylist);
    model.addAttribute("currentpage",page);
    model.addAttribute("totalpages",companylist.getTotalPages());
    return "admin/viewcompany";
    }

    @GetMapping("/company/{companyId}")
    public String showCompanyDetail(@PathVariable("companyId") Integer companyId,Model model){

    System.out.println("CID "+companyId);
    java.util.Optional<CompanyEntity> companydet = this.companyrepository.findById(companyId);
    CompanyEntity companyEntity = companydet.get();
    SectorEntity sector = companyEntity.getSector();
    model.addAttribute("company", companyEntity);
    model.addAttribute("sector",sector);
    return "admin/companydetail";
    }

    @GetMapping("/deletecompany/{companyId}")
    public String deletecompany(@PathVariable("companyId") Integer companyId,HttpSession session){

    System.out.println("CID "+companyId);
    java.util.Optional<CompanyEntity> companydet = this.companyrepository.findById(companyId);
    CompanyEntity companyEntity = companydet.get();
    try {
    companyEntity.setSector(null);
    this.companyrepository.delete(companyEntity);
    session.setAttribute("message", new Message("Contact Deleted Successfully","alert-success", null, null, null, null));
    } catch (Exception e) {
    // TODO: handle exception
    session.setAttribute("message", new Message(" Failed to delete Contact","alert-danger", null, null, e, null));
    }

    return "redirect:/admin/viewcompany/0";
    }

    @PostMapping("/updatecompany/{companyId}")
    public String updatecompany(@PathVariable("companyId") Integer companyId,HttpSession session,Model model)
    {
    model.addAttribute("title","Update Company");
    CompanyEntity companyEntity = this.companyrepository.findById(companyId).get();
    model.addAttribute("company",companyEntity);
    return "admin/updatecompany";

    }
    
	
	
		
		
}