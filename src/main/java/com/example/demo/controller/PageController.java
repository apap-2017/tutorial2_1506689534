package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {

	@RequestMapping("/hello")
	public String index() {
		return "hello";
	}
	
	@RequestMapping("/greeting")
	public String greeting (@RequestParam(value = "name", required = false, defaultValue = "dunia")
	String name, Model model){
		model.addAttribute("name", name);
		return "greeting";
	}
	
	@RequestMapping(value = {"/greeting/","/greeting/{name}"})
	public String greetingPath (@PathVariable Optional<String> name, Model model){
		if (name.isPresent()) {
			model.addAttribute("name", name.get());
		}else {
			model.addAttribute("name", "dengklek");
		}
		return "greeting";
	}
	
	  @RequestMapping("/perkalian")
	    public String perkalian (@RequestParam(value = "angka1", required = false, defaultValue = "0") Integer angka1, @RequestParam(value = "angka2", required = false, defaultValue = "0") Integer angka2, Model model) {
	        model.addAttribute("num1", angka1);
	        model.addAttribute("num2", angka2);
	        Integer hasil = angka1 * angka2;
	        model.addAttribute("hasil", hasil);
	        return "perkalian";
	    }
}
