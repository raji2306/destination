package com.example.demo.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@Autowired
	private FruitService service;
	
	private static final String LIST="redirect:/listfruits";
	@RequestMapping("/")
	public String home() {
		return "index.jsp";
	}
	
	@RequestMapping("/admin")
	public String adminPage() {
		return "adminlogin.jsp";
	}
	
	@RequestMapping("/login")
	public String view(@ModelAttribute("username") String username,@ModelAttribute("password") String password) {
		if((username.equals("admin")) && (password.equals("123"))) {
			return LIST;
		}else {
			return "redirect:/admin";
		}
	}
	
	@RequestMapping("/listfruits")
	public String getAll(Model m) {
		List<Fruit> lists=service.getAllFruit();
		m.addAttribute("fruitlist", lists);
		return "fruitview.jsp";
	}
	
	@RequestMapping("/deletebyid/{id}")
	public ModelAndView delete(@PathVariable("id") int id) {
		service.deleteFruit(id);
		return new ModelAndView(LIST);
	}
	
	@RequestMapping("/addnew")
	public String addnewrow() {
		return "addform.jsp";
	}
	
	@PostMapping(value="/save")
	public ModelAndView saveFruit(@ModelAttribute FruitDto fruit) {
		Fruit f=fruit.toEntity();
		service.saveOrUpdate(f);
		return new ModelAndView(LIST);
	}
}
