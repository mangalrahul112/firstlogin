package com.caps.dao;

import com.caps.dto.Student;

public interface StudentsInfoDAO
{
	public boolean createProfile(Student s);
	public Student searchByID(int regno);
	public boolean deleteProfile(int regno,String Password);
	public boolean updatePassword(int regno,String oldpw,String newpw);

}
