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
import ua.shykun.jba.entity.Schedule;
import ua.shykun.jba.entity.Teacher;
import ua.shykun.jba.entity.User;
import ua.shykun.jba.service.GroupService;
import ua.shykun.jba.service.PairService;
import ua.shykun.jba.service.ScheduleService;
import ua.shykun.jba.service.UserService;

@Controller
public class ScheduleController {
	
	@Autowired
	private PairService pairService;
	
	private ScheduleService scheduleService = new ScheduleService();
	
	@RequestMapping("/schedule")
	public String users(Model model) {
		model.addAttribute("schedule", new ScheduleService());
		model.addAttribute("pairs", pairService.findAll());
		model.addAttribute("days", 5);
		model.addAttribute("days", 3);
		return "schedule";
	}
	
	
}
