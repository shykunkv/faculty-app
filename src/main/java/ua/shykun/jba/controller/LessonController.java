package ua.shykun.jba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.shykun.jba.entity.Group;
import ua.shykun.jba.entity.Lesson;
import ua.shykun.jba.service.GroupService;
import ua.shykun.jba.service.LessonService;
import ua.shykun.jba.service.UserService;

@Controller
public class LessonController {
	
	@Autowired
	private LessonService lessonService;
	
	
	@RequestMapping("/lessons")
	public String users(Model model) {
		model.addAttribute("lessons", lessonService.findAll());
		model.addAttribute("newlesson", new Lesson());
		return "lessons";
	}
	
	
//	@RequestMapping("/add-lesson")
//	public String showAddLesson(Model model) {
//		model.addAttribute("newlesson", new Lesson());
//		return "add-lesson";
//	}
//	
//	
//	@RequestMapping(value = "/add-lesson", method = RequestMethod.POST)
//	public String saveLesson(@ModelAttribute("newlesson") Lesson lesson) {
//		lessonService.save(lesson);
//		return "add-lesson";
//	}
	
	@RequestMapping(value = "/lessons", method = RequestMethod.POST)
	public String saveLesson(@ModelAttribute("newlesson") Lesson lesson) {
		lessonService.save(lesson);
		return "redirect:/lessons.html";
	}
	
	@ModelAttribute("newlesson")
	public Lesson constructLesson() {
		return new Lesson();
	}
	
	@RequestMapping("/lessons/remove/{id}")
	public String removeLesson(@PathVariable int id) {
		lessonService.delete(id);
		return "redirect:/lessons.html";
	}
}
