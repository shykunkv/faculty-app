package ua.shykun.jba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.shykun.jba.entity.Lesson;
import ua.shykun.jba.entity.Teacher;
import ua.shykun.jba.service.GroupService;
import ua.shykun.jba.service.TeacherService;
import ua.shykun.jba.service.UserService;

@Controller
public class TeacherController {
	
	@Autowired
	private TeacherService teacherService;
	
	
	@RequestMapping("/teachers")
	public String users(Model model) {
		model.addAttribute("teachers", teacherService.findAll());
		model.addAttribute("newteacher", new Teacher());
		return "teachers";
	}
	
//	
//	@RequestMapping("/add-teacher")
//	public String showAddTeacher(Model model) {
//		model.addAttribute("newteacher", new Teacher());
//		return "add-teacher";
//	}
//	
//	
//	@RequestMapping(value = "/add-teacher", method = RequestMethod.POST)
//	public String saveTeacher(@ModelAttribute("newteacher") Teacher teacher) {
//		teacherService.save(teacher);
//		return "add-teacher";
//	}
	
	@RequestMapping(value = "/teachers", method = RequestMethod.POST)
	public String saveTeacher(@ModelAttribute("newteacher") Teacher teacher) {
		teacherService.save(teacher);
		return "redirect:/teachers.html";
	}
	
	@ModelAttribute("newteacher")
	public Teacher constructTeacher() {
		return new Teacher();
	}
	
	@RequestMapping("/teachers/remove/{id}")
	public String removeTeacher(@PathVariable int id) {
		teacherService.delete(id);
		return "redirect:/teachers.html";
	}
	
}
