package com.sg.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sg.Repository.IPORepositoryI;
import com.sg.entity.IPODetailEntity;

@Service
public class IPOServiceImpl implements IPOServiceI {
	@Autowired
	private IPORepositoryI iPOrepo ;
	
	@Override
	public List<IPODetailEntity> getAllIpo() {
		// TODO Auto-generated method stub
		return iPOrepo.findAll();
	}

	@Override
	public void addIpo(IPODetailEntity ipoentity) {
		// TODO Auto-generated method stub
		
		iPOrepo.save(ipoentity);
	}

	

}
