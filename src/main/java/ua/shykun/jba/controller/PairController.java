package ua.shykun.jba.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.shykun.jba.entity.Group;
import ua.shykun.jba.entity.Lesson;
import ua.shykun.jba.entity.Pair;
import ua.shykun.jba.entity.User;
import ua.shykun.jba.service.GroupService;
import ua.shykun.jba.service.LessonService;
import ua.shykun.jba.service.PairService;
import ua.shykun.jba.service.TeacherService;
import ua.shykun.jba.service.UserService;

@Controller
public class PairController {
	
	@Autowired
	private PairService pairService;
	
	@Autowired
	private LessonService lessonService;
	
	@Autowired
	private TeacherService teacherService;
	
	@Autowired
	private GroupService groupService;
	
	@ModelAttribute("newpair")
	public Pair constructPair() {
		return new Pair();
	}
	
	@RequestMapping("/pairs")
	public String pairs(Model model) {
		
		
		model.addAttribute("pairs", pairService.findAll());
		model.addAttribute("lessons", lessonService.getNames());
		model.addAttribute("teachers", teacherService.getNames());
		model.addAttribute("groups", groupService.getNames());
		model.addAttribute("newpair", new Pair());
		return "pairs";
	}
	
	@RequestMapping(value = "/pairs", method = RequestMethod.POST)
	public String doAddPair(@ModelAttribute("newpair") Pair pair) {
		//model.addAttribute("groups", groupService.findAll());
		//String name = principal.getName();
		pairService.save(pair);
		return "redirect:/pairs.html";
	}
	
	@RequestMapping("/pairs/remove/{id}")
	public String removePair(@PathVariable int id) {
		pairService.delete(id);
		return "redirect:/pairs.html";
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
