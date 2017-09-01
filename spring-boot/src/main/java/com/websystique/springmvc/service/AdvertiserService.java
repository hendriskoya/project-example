package com.websystique.springmvc.service;

import java.util.List;

import com.websystique.springmvc.model.Advertiser;



public interface AdvertiserService {
	
	Advertiser findById(long id);
	
	Advertiser findByName(String name);
	
	void saveAdvertiser(Advertiser advertiser);
	
	void updateAdvertiser(Advertiser advertiser);
	
	void deleteAdvertiserById(long id);

	List<Advertiser> findAllAdvertisers(); 
	
	void deleteAllAdvertisers();
	
	public boolean isAdvertiserExist(Advertiser advertiser);
	
}
