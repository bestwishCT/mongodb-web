package com.myspring;

public class AutoByNameType {
	private Teacher teacher;
	private Child child;
	private String name;

	public void sayWc() {
		teacher.sayJob();
	}

	public void sayWd() {
		child.sayJob();
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Child getChild() {
		return child;
	}

	public void setChild(Child child) {
		this.child = child;
	}
	
}