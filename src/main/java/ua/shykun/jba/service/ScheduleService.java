package ua.shykun.jba.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.shykun.jba.entity.Pair;
import ua.shykun.jba.repository.PairRepository;

public class ScheduleService {

    private Pair[] pairs;
    private Pair[][] schedule;
    private int amOfDays;
    private int amOfLesPerDay;

    
    public ScheduleService() {
    }

    public Pair[] getPairs() {
        return pairs;
    }

    public Pair[][] getSchedule() {
        return schedule;
    }

    public int getAmOfDays() {
        return amOfDays;
    }

    public int getAmOfLesPerDay() {
        return amOfLesPerDay;
    }

    public void setPairs(Pair[] pairs) {
        this.pairs = pairs;
    }

    public void setSchedule(Pair[][] schedule) {
        this.schedule = schedule;
    }

    public void setAmOfDays(int amOfDays) {
        this.amOfDays = amOfDays;
    }

    public void setAmOfLesPerDay(int amOfLesPerDay) {
        this.amOfLesPerDay = amOfLesPerDay;
    }

 

    private Pair[] getPairsForGroup(int groupId) {
        ArrayList<Pair> groupPairs;
        groupPairs = new ArrayList<Pair>();
        for (Pair pair : pairs) {
            if (pair.getGroupId() == groupId) {
                groupPairs.add(pair);
            }
        }
        Pair[] grP = new Pair[groupPairs.size()];
        for (int i = 0; i < groupPairs.size(); i++) {
            grP[i] = groupPairs.get(i);
        }
        return grP;
    }

    private List<Integer> getGroups() {
    	List<Integer> groups = new ArrayList<Integer>();
    	for (Pair pair: pairs) {
    		int group = pair.getGroupId();
    		if (!groups.contains(group)) {
    			groups.add(group);
    		}
    	}
    	return  groups;
    }
    
    public void createRandomSchedule() {
        List<Integer> groups = getGroups();
    	int length = groups.size();
        schedule = new Pair[length][amOfDays * amOfLesPerDay];
        Random rand = new Random();

        for (int i = 0; i < length; i++) {
            Pair[] groupPairs = getPairsForGroup(groups.get(i));
            int[] positionToAdd = new int[groupPairs.length];
            ArrayList<Integer> rands = new ArrayList<Integer>();
            for (int m = 0; m < amOfDays * amOfLesPerDay; m++) {
                rands.add(m);
            }

            for (int k = 0; k < positionToAdd.length; k++) {
                positionToAdd[k] = rands.remove(rand.nextInt(rands.size()));
            }
            for (int j = 0; j < groupPairs.length; j++) {
                schedule[i][positionToAdd[j]] = groupPairs[j];
            }
        }

    }
    
	public int getAmountOfCollisions() {
		int res = 0;
		for (int i = 0; i < schedule[0].length; i++) {
			for (int j = 0; j < schedule.length; j++) {
				for (int k = j + 1; k < schedule.length; k++) {

					if (schedule[j][i] != null && schedule[k][i] != null) {
						if (schedule[j][i].getTeacherId() == schedule[k][i]
								.getTeacherId()) {
							res++;
						}
					}
				}
			}
		}
		return res;
	}

	public void createBestSchedule() {
		int step = 0;
		do {
			if (step >= 1000000) {
				schedule = null;
				return;
			}
			createRandomSchedule();
			step++;
		} while (getAmountOfCollisions() != 0);
	}
	
	
	
    public ScheduleService createSchedule() {
    	//List<Pair> allPairsList = pairService.findAll();
    	
    	
    	Pair[] allPairs = new Pair[25];
//    	for (int i = 0; i < allPairsList.size(); i++) {
//    		allPairs[i] = allPairsList.get(i);
//    	}
      for (int i = 0; i < allPairs.length; i++) {
          allPairs[i] = new Pair();
          allPairs[i].setGroupId(i % 5);
          allPairs[i].setGroupName("Test" + (i % 5));
          //System.out.print(i % 5 + " ");
          allPairs[i].setHours(i);
          allPairs[i].setId(i);
          allPairs[i].setLessonId(i);
          allPairs[i].setLessonName("Test" + i);
          allPairs[i].setTeacherId(i % 2);
          allPairs[i].setTeacherName("Test" + i);
      }
    	
    	ScheduleService s = new ScheduleService();
    	s.setAmOfDays(5);
    	s.setAmOfLesPerDay(3);
    	s.setPairs(allPairs);
    	s.createBestSchedule();
//    	List<Pair> schedList = new ArrayList<Pair>();
//    	Pair[][] schedule = s.getSchedule();
//    	for (int i = 0; i < schedule[0].length; i++) {
//          for (int j = 0; j < schedule.length; j++) {
//              if (schedule[j][i] != null) {
//                  schedList.add(schedule[j][i]);
//              } else {
//            	  schedList.add(null);
//              }
//          }
//    	}
    	//return schedList;
    	return s;
    	
    }

}
