package com.bridgelabz.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.RowMapper;

public class StudentMapper implements RowMapper<StudentJDBC> {

	@Override
	public StudentJDBC mapRow(ResultSet rs, int rowNum) throws SQLException {
		ApplicationContext context = new ClassPathXmlApplicationContext("Bean.xml");
		 StudentJDBC student =  (StudentJDBC) context.getBean("StudentJDBC");
	      student.setId(rs.getInt("id"));
	      student.setName(rs.getString("name"));
	      student.setAge(rs.getInt("age"));
	      
	      return student;
	
	}

}
