package com.websystique.springmvc.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.model.Advertiser;

@Service("advertiserService")
@Transactional
public class AdvertiserServiceImpl implements AdvertiserService {
	
	private static final AtomicLong counter = new AtomicLong();
	
	private static List<Advertiser> advertisers;
	
	static{
		advertisers= populateDummyAdvertisers();
	}

	public List<Advertiser> findAllAdvertisers() {
		return advertisers;
	}
	
	public Advertiser findById(long id) {
		for(Advertiser user : advertisers){
			if(user.getId() == id){
				return user;
			}
		}
		return null;
	}
	
	public Advertiser findByName(String name) {
		for(Advertiser user : advertisers){
			if(user.getName().equalsIgnoreCase(name)){
				return user;
			}
		}
		return null;
	}
	
	public void saveAdvertiser(Advertiser user) {
		user.setId(counter.incrementAndGet());
		advertisers.add(user);
	}

	public void updateAdvertiser(Advertiser user) {
		int index = advertisers.indexOf(user);
		advertisers.set(index, user);
	}

	public void deleteAdvertiserById(long id) {
		
		for (Iterator<Advertiser> iterator = advertisers.iterator(); iterator.hasNext(); ) {
		    Advertiser user = iterator.next();
		    if (user.getId() == id) {
		        iterator.remove();
		    }
		}
	}

	public boolean isAdvertiserExist(Advertiser user) {
		return findByName(user.getName())!=null;
	}
	
	public void deleteAllAdvertisers(){
		advertisers.clear();
	}

	private static List<Advertiser> populateDummyAdvertisers(){
		List<Advertiser> advertisers = new ArrayList<Advertiser>();
		advertisers.add(new Advertiser(counter.incrementAndGet(),"Sam", "sam@abc.com"));
		advertisers.add(new Advertiser(counter.incrementAndGet(),"Tomy", "tomy@abc.com"));
		advertisers.add(new Advertiser(counter.incrementAndGet(),"Kelly", "kelly@abc.com"));
		return advertisers;
	}

}
