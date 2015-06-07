package ua.shykun.jba.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.shykun.jba.entity.Group;
import ua.shykun.jba.entity.Lesson;
import ua.shykun.jba.entity.Role;
import ua.shykun.jba.entity.Teacher;
import ua.shykun.jba.entity.User;
import ua.shykun.jba.repository.GroupRepository;
import ua.shykun.jba.repository.LessonRepository;
import ua.shykun.jba.repository.RoleRepository;
import ua.shykun.jba.repository.ScheduleRepository;
import ua.shykun.jba.repository.TeacherRepository;
import ua.shykun.jba.repository.UserRepository;

@Transactional
@Service
public class InitDbService {
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private LessonRepository lessonRepository;
	
	@Autowired
	private GroupRepository groupRepository;
	
	@Autowired
	private TeacherRepository teacherRepository;
	
	@Autowired
	private ScheduleRepository scheduleRepository;
	
	
	@PostConstruct
	public void init() {
		if (roleRepository.findByName("ROLE_ADMIN") == null) {
			Role roleUser = new Role();
			roleUser.setName("ROLE_USER");
			roleRepository.save(roleUser);

			Role roleAdmin = new Role();
			roleAdmin.setName("ROLE_ADMIN");
			roleRepository.save(roleAdmin);

			User userAdmin = new User();
			userAdmin.setEnabled(true);
			userAdmin.setName("admin");
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			userAdmin.setPassword(encoder.encode("admin"));
			List<Role> roles = new ArrayList<Role>();
			roles.add(roleAdmin);
			roles.add(roleUser);
			userAdmin.setRoles(roles);
			userRepository.save(userAdmin);
			
			
			User user = new User();
			user.setEnabled(true);
			user.setName("user");
			user.setPassword(encoder.encode("user"));
			roles.remove(0);
			user.setRoles(roles);
			userRepository.save(user);
		}
	}
}
