package com.sg.controller;

import java.security.Principal;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sg.Repository.CompanyRepositoryI;
import com.sg.Repository.UserRepositoryI;
import com.sg.Services.CompanyServiceImpl;
import com.sg.entity.CompanyEntity;
import com.sg.entity.SectorEntity;
import com.sg.entity.UserEntity;



@RestController
@RequestMapping("/admin")
public class CompanyController {

	
	@Autowired
	private CompanyRepositoryI companyrepository;
	
	@Autowired
	private CompanyServiceImpl companyService;
	
	@Autowired
	private UserRepositoryI userrepository;

	
	@ModelAttribute
	public void addCommonData(Model model,Principal principal)
	{
		String userName = principal.getName();
		UserEntity user = this.userrepository.findByUsername(userName);
		model.addAttribute("user", user);
	}
	
	@GetMapping("/addcompany")
	public String openAddCompanyForm(Model model  )
	{
		model.addAttribute("title","Add Company");
		model.addAttribute("company",new CompanyEntity());
		return "admin/addcompany";
	}
	
	@PostMapping("/process-company")
	public String processCompany(@ModelAttribute("company") CompanyEntity company,@RequestParam(value="sectorname") String sectorname,HttpSession session)
	{
		try {
			
			System.out.println(sectorname);
			System.out.println("DATA "+ company);
			this.companyService.createCompany(company, sectorname);
			
			session.setAttribute("message",new Message("Successfully Added Company Details!! ","alert-success", null, null, null, null));
			return "admin/addcompany";
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
			session.setAttribute("message",new Message("Something went wrong, Check the inputs again !! ","alert-danger", null, null, e, null));
			
			return "admin/addcompany";
		}
		
	}
	
	@GetMapping("/viewcompany/{page}")
	public String showCompany(@PathVariable("page") Integer page,Model model)
	{
		model.addAttribute("title","View Company");
		
		Pageable pg = PageRequest.of(page, 4);
		
		Page<CompanyEntity> companylist = this.companyrepository.findallCompany(pg);
		model.addAttribute("companylist",companylist);
		model.addAttribute("currentpage",page);
		model.addAttribute("totalpages",companylist.getTotalPages());
		return "admin/viewcompany";
	}
	
	@GetMapping("/company/{companyId}")
	public String showCompanyDetail(@PathVariable("companyId") Integer companyId,Model model){
		model.addAttribute("title","View Company");
		System.out.println("CID "+companyId);
		Optional<CompanyEntity> companydet = this.companyrepository.findById(companyId);
		CompanyEntity companyEntity = companydet.get();
		SectorEntity sector = companyEntity.getSector();
		model.addAttribute("company", companyEntity);
		model.addAttribute("sector",sector);
		return "admin/companydetail";
	}
	
	@GetMapping("/deletecompany/{companyId}")
	public String deletecompany(@PathVariable("companyId") Integer companyId,HttpSession session){
		
		System.out.println("CID "+companyId);
		Optional<CompanyEntity> companydet = this.companyrepository.findById(companyId);
		CompanyEntity companyEntity = companydet.get();
		try {
			companyEntity.setSector(null);
			this.companyrepository.delete(companyEntity);
			session.setAttribute("message", new Message("Company Deleted Successfully","alert-success", null, null, null, null));
		} catch (Exception e) {
			// TODO: handle exception
			session.setAttribute("message", new Message(" Failed to delete company","alert-danger", null, null, e, null));
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
	
	@PostMapping("/process-updatecompany")
	public String processupdatecompany(@ModelAttribute("company") CompanyEntity company,@RequestParam(value="sectorname") String sectorname,HttpSession session,Model model)
	{
			try {
			
			System.out.println(sectorname);
			System.out.println("DATA "+ company);
			CompanyEntity companyEntity = this.companyrepository.findById(company.getCompanyid()).get();
			CompanyEntity  updatecompany = this.companyService.updatecompany(companyEntity,company,sectorname);
			 
				
			SectorEntity sector = updatecompany.getSector();
			model.addAttribute("company", updatecompany);
			model.addAttribute("sector",sector);
			session.setAttribute("message",new Message("Successfully Updated Company Details!! ","alert-success", null, null, null, null));
			return "admin/companydetail";
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
			session.setAttribute("message",new Message("Something went wrong, Check the inputs again !! ","alert-danger", null, null, e, null));
			return "admin/viewcompany";
		}
		
	}
	
}
