package ua.shykun.jba.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "app_group")
public class Group {
	
	
	@Id
	@GeneratedValue
	private Integer id;
	

	private String name;
	private int year;
	private int studentsNum;

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getStudentsNum() {
		return studentsNum;
	}
	public void setStudentsNum(int studentsNum) {
		this.studentsNum = studentsNum;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
