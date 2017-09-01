package com.websystique.springmvc.controller;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.websystique.springmvc.model.Advertiser;
import com.websystique.springmvc.service.AdvertiserService;
 
@RestController
public class AdvertiserRestController {
 
    @Autowired
    AdvertiserService advertiserService;  //Service which will do all data retrieval/manipulation work
 
    
    //-------------------Retrieve All Users--------------------------------------------------------
     
    @RequestMapping(value = "/api/advertiser/", method = RequestMethod.GET)
    public ResponseEntity<List<Advertiser>> listAllAdvertisers() {
        List<Advertiser> advertisers = advertiserService.findAllAdvertisers();
        if(advertisers.isEmpty()){
            return new ResponseEntity<List<Advertiser>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Advertiser>>(advertisers, HttpStatus.OK);
    }
 
 
    
    //-------------------Retrieve Single Advertiser--------------------------------------------------------
     
    @RequestMapping(value = "/api/advertiser/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Advertiser> getAdvertiser(@PathVariable("id") long id) {
        System.out.println("Fetching Advertiser with id " + id);
        Advertiser advertiser = advertiserService.findById(id);
        if (advertiser == null) {
            System.out.println("Advertiser with id " + id + " not found");
            return new ResponseEntity<Advertiser>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Advertiser>(advertiser, HttpStatus.OK);
    }
 
     
     
    //-------------------Create a Advertiser--------------------------------------------------------
     
    @RequestMapping(value = "/api/advertiser/", method = RequestMethod.POST)
    public ResponseEntity<Void> createAdvertiser(@RequestBody Advertiser advertiser,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Advertiser " + advertiser.getName());
 
        if (advertiserService.isAdvertiserExist(advertiser)) {
            System.out.println("A Advertiser with name " + advertiser.getName() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
 
        advertiserService.saveAdvertiser(advertiser);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(advertiser.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
 
    
     
    //------------------- Update a Advertiser --------------------------------------------------------
     
    @RequestMapping(value = "/api/advertiser/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Advertiser> updateAdvertiser(@PathVariable("id") long id, @RequestBody Advertiser user) {
        System.out.println("Updating Advertiser " + id);
         
        Advertiser currentAdvertiser = advertiserService.findById(id);
         
        if (currentAdvertiser==null) {
            System.out.println("Advertiser with id " + id + " not found");
            return new ResponseEntity<Advertiser>(HttpStatus.NOT_FOUND);
        }
 
        currentAdvertiser.setName(user.getName());
        currentAdvertiser.setEmail(user.getEmail());
         
        advertiserService.updateAdvertiser(currentAdvertiser);
        return new ResponseEntity<Advertiser>(currentAdvertiser, HttpStatus.OK);
    }
 
    
    
    //------------------- Delete a User --------------------------------------------------------
     
    @RequestMapping(value = "/api/advertiser/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Advertiser> deleteAdvertiser(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting Advertiser with id " + id);
 
        Advertiser user = advertiserService.findById(id);
        if (user == null) {
            System.out.println("Unable to delete. Advertiser with id " + id + " not found");
            return new ResponseEntity<Advertiser>(HttpStatus.NOT_FOUND);
        }
 
        advertiserService.deleteAdvertiserById(id);
        return new ResponseEntity<Advertiser>(HttpStatus.NO_CONTENT);
    }
 
     
    
    //------------------- Delete All Users --------------------------------------------------------
     
    /*@RequestMapping(value = "/user/", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteAllUsers() {
        System.out.println("Deleting All Users");
 
        userService.deleteAllUsers();
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }*/
 
}