package com.seleniumexpress.dao;

import com.seleniumexpress.api.Student;

public interface StudentDAO {
	void insert(Student student);
    boolean deleteRecordByRollNo(int RollNo);
    int deleteRecordByStudentNameAndStudentAddress(String studentName, String studentAddress);
    void cleanUp();
}


