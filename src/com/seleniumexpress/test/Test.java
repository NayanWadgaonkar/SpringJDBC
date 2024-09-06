package com.seleniumexpress.test;

import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.seleniumexpress.dao.StudentDAOImp;
import com.seleniumexpress.service.StudentDAOHelper;

public class Test {

    public static void main(String[] args) {
    	
    	ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    	System.out.println("context loaded...");
    	
    	StudentDAOImp studentDAOImp = context.getBean("studentDAO",StudentDAOImp.class);
    	
    	StudentDAOHelper studentDAOHelper=context.getBean("studentDAOHelper", StudentDAOHelper.class);
    	studentDAOHelper.setUpStudentTable();
    	
    	
      /*Student student = new Student();
        student.setRollNo(2);
        student.setName("neha");
        student.setAddress("pune");
        
        studentDAOImp.insert(student);
        */
        
      /* boolean isDeleted = studentDAOImp.deleteRecordByRollNo(2);
       if(isDeleted) {
    	   System.out.println("roll no 2 data got deleted");
       }*/
       
      // studentDAOImp.deleteRecordByStudentNameAndStudentAddress("Sara","Pune");
    	studentDAOImp.cleanUp();
    }
}