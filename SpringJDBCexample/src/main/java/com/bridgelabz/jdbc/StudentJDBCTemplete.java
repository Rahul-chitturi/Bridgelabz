package com.bridgelabz.jdbc;


import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;


public class StudentJDBCTemplete  implements StudentDAO
{

	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
 


	public void setDataSource(DataSource dataSource) {
		
		      this.dataSource = dataSource;
		      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public void create(String name, Integer age) {
		 String SQL = "insert into Student (name, age) values (?, ?)";
	      jdbcTemplateObject.update( SQL, name, age);
	      System.out.println("Created Record Name = " + name + " Age = " + age);
	      return;
		
	}

	@Override
	public StudentJDBC getStudent(Integer id) {
		String SQL = "select * from Student where id = ?";
	      StudentJDBC student = jdbcTemplateObject.queryForObject(SQL, 
	         new Object[]{id}, new StudentMapper());
	      return student;
	}

	@Override
	public List<StudentJDBC> listStudents() {
		      String SQL = "select * from Student";
		      List <StudentJDBC> students = jdbcTemplateObject.query(SQL, new StudentMapper());
		      return students;
	}

	@Override
	public void delete(Integer id) {
		 String SQL = "delete from Student where id = ?";
	      jdbcTemplateObject.update(SQL, id);
	      System.out.println("Deleted Record with ID = " + id );
	      return;
	}

	@Override
	public void update(Integer id, Integer age) {
		 String SQL = "update Student set age = ? where id = ?";
	      jdbcTemplateObject.update(SQL, age, id);
	      System.out.println("Updated Record with ID = " + id );
	      return;	
		
	}
	
	public void delete() {
		String SQL = "delete from Student";
		jdbcTemplateObject.update(SQL);
		String Sql = "alter table Student auto_increment = 0 ";
		jdbcTemplateObject.update(Sql);

		return;
	}
 

}
 
