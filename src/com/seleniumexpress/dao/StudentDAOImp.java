package com.seleniumexpress.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import com.seleniumexpress.api.Student;

@Repository("studentDAO")
public  class StudentDAOImp implements StudentDAO {
	@Autowired
 private JdbcTemplate jdbcTemplate ;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate)
	{
	this.jdbcTemplate = jdbcTemplate;
    }
	@Override
	public void insert(Student student)
	{
		String sql = "INSERT INTO STUDENT (ROLL_NO, NAME, ADDRESS) VALUES(?, ?, ?)";
		
		Object[]params = {student.getRollNo(), student.getName(), student.getAddress()};
		
		int noOfRowUpdated =jdbcTemplate.update(sql,params);
		
		System.out.println("No of rows inserted : "+noOfRowUpdated);
		
	}
	@Override
	public boolean deleteRecordByRollNo(int RollNo) 
	{
		String sql = "DELETE FROM STUDENT WHERE ROLL_NO=?";
		
		int noOfRowdeleted = jdbcTemplate.update(sql,RollNo);
		
		System.out.println("no of record deleted :  "+noOfRowdeleted);
		
		return noOfRowdeleted == 1;
	}
	@Override
	public int deleteRecordByStudentNameAndStudentAddress(String studentName, String studentAddress) {
		
		String sql = "DELETE FROM STUDENT WHERE NAME = ? OR ADDRESS = ?";
		
		int noOfRowsDeleted = jdbcTemplate.update(sql,studentName,studentAddress);

		System.out.println("no of rows deleted :  "+noOfRowsDeleted);
		
				return noOfRowsDeleted;
				
				
	}
	@Override
	public void cleanUp() {
		String sql ="TRUNCATE TABLE STUDENT";
		
		jdbcTemplate.update(sql);
		
		System.out.println("Table cleaned up..");
	}
	@Override
	public void insert(List<Student> students) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO STUDENT (ROLL_NO, NAME, ADDRESS) VALUES(?, ?, ?)";
		
		ArrayList<Object[]> sqlArgs = new ArrayList<>();
		
		for(Student tempStudent : students) {
			Object[] studentData = {tempStudent.getRollNo(),tempStudent.getName(),tempStudent.getAddress()};
			sqlArgs.add(studentData);
		}
		
		jdbcTemplate.batchUpdate(sql,sqlArgs);
		
		System.out.println("batch update completed !!!");

	}

}
	

