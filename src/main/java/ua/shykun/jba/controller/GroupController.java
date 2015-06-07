package ua.shykun.jba.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.shykun.jba.entity.Group;
import ua.shykun.jba.entity.User;
import ua.shykun.jba.service.GroupService;
import ua.shykun.jba.service.UserService;

@Controller
public class GroupController {
	
	@Autowired
	private GroupService groupService;
	
	@ModelAttribute("newgruop")
	public Group constructGroup() {
		return new Group();
	}
	
	@RequestMapping("/groups")
	public String users(Model model) {
		model.addAttribute("groups", groupService.findAll());
		model.addAttribute("newgroup", new Group());
		return "groups";
	}
	
	@RequestMapping(value = "/groups", method = RequestMethod.POST)
	public String doAddGroup(@ModelAttribute("newgroup") Group group) {
		groupService.save(group);
		return "redirect:/groups.html";
	}
	
	@RequestMapping("/groups/remove/{id}")
	public String removeGroup(@PathVariable int id) {
		groupService.delete(id);
		return "redirect:/groups.html";
	}
	
//	@RequestMapping("/add-group")
//	public String showAddGroup(Model model) {
//		model.addAttribute("newgroup", new Group());
//		return "add-group";
//	}
//	
//	
//	@RequestMapping(value = "/add-group", method = RequestMethod.POST)
//	public String saveGroup(@ModelAttribute("newgroup") Group group) {
//		groupService.save(group);
//		return "add-group";
//	}
}
