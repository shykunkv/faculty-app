package ua.shykun.jba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.shykun.jba.entity.Group;
import ua.shykun.jba.entity.Lesson;
import ua.shykun.jba.entity.Pair;
import ua.shykun.jba.entity.Teacher;
import ua.shykun.jba.entity.User;
import ua.shykun.jba.repository.GroupRepository;
import ua.shykun.jba.repository.LessonRepository;
import ua.shykun.jba.repository.PairRepository;
import ua.shykun.jba.repository.TeacherRepository;
import ua.shykun.jba.repository.UserRepository;


@Service
public class PairService {
	@Autowired
	private PairRepository pairRepository;
	
	@Autowired
	private LessonRepository lessonRepository;
	
	@Autowired
	private GroupRepository groupRepository;
	
	@Autowired
	private TeacherRepository teacherRepository;
	
	public List<Pair> findAll() {
		return pairRepository.findAll();
	}
	
	
	public void save(Pair pair) {
		String lessonName = pair.getLessonName();
		Lesson lesson = lessonRepository.findByName(lessonName);
		pair.setLessonId(lesson.getId());

		String teacherName = pair.getTeacherName();
		Teacher teacher = teacherRepository.findByName(teacherName);
		pair.setTeacherId(teacher.getId());

		String groupName = pair.getGroupName();
		Group group = groupRepository.findByName(groupName);
		pair.setGroupId(group.getId());
		
		pairRepository.save(pair);
	}

	public void delete(int id) {
		pairRepository.delete(id);
	}
	
	
	
}
