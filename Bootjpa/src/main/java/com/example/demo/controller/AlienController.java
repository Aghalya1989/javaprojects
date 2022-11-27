package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.AlienRepo;
import com.example.demo.model.Alien;

@RestController
public class AlienController {
	@Autowired
	AlienRepo repo;
	
	@RequestMapping("/")
	public String home()
	{
		
		return "home.jsp";
	}

	/*
	 * @RequestMapping("/addAlien") public String addAlien(Alien alien) {
	 * repo.save(alien); return "home.jsp"; }
	 */
	
	@PostMapping(path= "/Alien",consumes= {"application/json"})
	public Alien addAlien(@RequestBody Alien alien)
	{
		repo.save(alien);
		return alien;
	}
	
	@RequestMapping("/getAlien")
	public ModelAndView getAlien(@RequestParam int aid)
	{
		ModelAndView mv = new ModelAndView("showAlien.jsp");
		Alien alien= repo.findById(aid).orElse(new Alien());
		System.out.println("**********"+repo.findByAidGreaterThan(aid));
		System.out.println("**********"+repo.findByTechSorted("Java"));
		mv.addObject(alien);
		return mv;
	}
	
	//@RequestMapping(path="/aliens", produces= {"application/xml"}) if u need to restrict json format
	@RequestMapping(path="/aliens")
	@ResponseBody 
	//returns string in the repsonse
	//when using crud reposotry findall returns Iterable so we need to covert to string
	//when using jpa repositroy it returns list (json format)
	public List<Alien> getAliens()
	{
		
		//return repo.findAll().toString();
		return repo.findAll();
		
		
	}
	
	@RequestMapping("/alien/{aid}")
	@ResponseBody //returns string in the repsonse
	public Optional<Alien> getAlienbyID(@PathVariable("aid") int aid)
	{
		
		//return repo.findById(aid).toString();
		return repo.findById(aid);
		
		
	}
	
	@RequestMapping("/deleteAlien")
	public ModelAndView deleteAlien(@RequestParam int aid)
	{
		ModelAndView mv = new ModelAndView("home.jsp");
		repo.deleteById(aid);
		return mv;
	}
	

	@DeleteMapping("/deleteAlienbyId/{aid}")
	public String deleteAlienbyId(@PathVariable int aid)
	{
		
		repo.deleteById(aid);
		return "deleted";
		
	}
	
	@PutMapping(path= "/alien")
	public Alien saveOrUpdateAlien(@RequestBody Alien alien)
	{
		repo.save(alien);
		return alien;
	}
}
