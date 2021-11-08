package com.sg.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sg.entity.IPODetailEntity;
@Service
public interface IPOServiceI {
	 List<IPODetailEntity> getAllIpo();
	 void addIpo(IPODetailEntity ipoentity);
}
