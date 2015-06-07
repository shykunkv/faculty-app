package ua.shykun.jba.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.shykun.jba.entity.Group;
import ua.shykun.jba.entity.Lesson;
import ua.shykun.jba.entity.Teacher;
import ua.shykun.jba.entity.User;
import ua.shykun.jba.repository.GroupRepository;
import ua.shykun.jba.repository.TeacherRepository;
import ua.shykun.jba.repository.UserRepository;


@Service
public class TeacherService {
	@Autowired
	private TeacherRepository teacherRepository;
	
	public List<Teacher> findAll() {
		return teacherRepository.findAll();
	}
	
	public void save(Teacher teacher) {
		teacherRepository.save(teacher);
	}

	public void delete(int id) {
		teacherRepository.delete(id);
	}
	
	
	public List<String> getNames() {
		List<Teacher> teachers = teacherRepository.findAll();
		List<String> teachersNames = new ArrayList<String>();
		for (int i = 0; i < teachers.size(); i++) {
			Teacher currTeacher = teachers.get(i);
			teachersNames.add(currTeacher.getName());
		}
		return teachersNames;
	}
}
