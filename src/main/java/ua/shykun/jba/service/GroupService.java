package ua.shykun.jba.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.shykun.jba.entity.Group;
import ua.shykun.jba.entity.Lesson;
import ua.shykun.jba.entity.User;
import ua.shykun.jba.repository.GroupRepository;
import ua.shykun.jba.repository.UserRepository;


@Service
public class GroupService {
	@Autowired
	private GroupRepository groupRepository;
	
	public List<Group> findAll() {
		return groupRepository.findAll();
	}

	public void save(Group group) {
		groupRepository.save(group);
	}

	public void delete(int id) {
		groupRepository.delete(id);
	}
	
	
	public List<String> getNames() {
		List<Group> groups = groupRepository.findAll();
		List<String> groupsNames = new ArrayList<String>();
		for (int i = 0; i < groups.size(); i++) {
			Group currGroup = groups.get(i);
			groupsNames.add(currGroup.getName());
		}
		return groupsNames;
	}
}
