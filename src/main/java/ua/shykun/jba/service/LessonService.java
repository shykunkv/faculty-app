package ua.shykun.jba.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.shykun.jba.entity.Group;
import ua.shykun.jba.entity.Lesson;
import ua.shykun.jba.entity.User;
import ua.shykun.jba.repository.GroupRepository;
import ua.shykun.jba.repository.LessonRepository;
import ua.shykun.jba.repository.UserRepository;


@Service
public class LessonService {
	@Autowired
	private LessonRepository lessonRepository;
	
	public List<Lesson> findAll() {
		return lessonRepository.findAll();
	}
	
	public List<String> getNames() {
		List<Lesson> lessons = lessonRepository.findAll();
		List<String> lessonNames = new ArrayList<String>();
		for (int i = 0; i < lessons.size(); i++) {
			Lesson currLesson = lessons.get(i);
			lessonNames.add(currLesson.getName());
		}
		return lessonNames;
	}
	
	
	public void save(Lesson lesson) {
		lessonRepository.save(lesson);
	}


	public void delete(int id) {
		lessonRepository.delete(id);
		
	}
}
