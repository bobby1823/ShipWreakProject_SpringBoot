package com.spring.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.model.Shipwreck;
import com.spring.repository.ShipwreckRepository;

@RestController
@RequestMapping(value="api/v1/")
public class ShipwrekController {

	@Autowired
	public ShipwreckRepository shipwreckRepo;
	
	@RequestMapping(value="shipwrecks", method=RequestMethod.GET)
	public List<Shipwreck> list() {
		return shipwreckRepo.findAll();
		
	}
	
	@RequestMapping(value="shipwrecks", method = RequestMethod.POST)
	public Shipwreck createShipwreck(@RequestBody Shipwreck wreck) {
		return shipwreckRepo.saveAndFlush(wreck);
	}
	
	@RequestMapping(value="shipwrecks/{id}", method = RequestMethod.GET)
	public Shipwreck getShipwreck(@PathVariable Long id) {
		return shipwreckRepo.findOne(id);
	}
	
	@RequestMapping(value="shipwrecks/{id}", method = RequestMethod.PUT)
	public Shipwreck updateShipwreck(@PathVariable Long id, @RequestBody Shipwreck wreck) {
		Shipwreck shipwreck = shipwreckRepo.findOne(id);
		BeanUtils.copyProperties(wreck, shipwreck);
		return shipwreckRepo.saveAndFlush(shipwreck);
	}
	
	@RequestMapping(value="shipwrecks/{id}", method = RequestMethod.DELETE)
	public Shipwreck deleteShipwreck(@PathVariable Long id) {
		Shipwreck shipwreck = shipwreckRepo.findOne(id);
		shipwreckRepo.delete(id);
		return shipwreck;
	}
	
	
	
}
