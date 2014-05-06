package com.litepaltest.test.crud.query;

import org.litepal.crud.DataSupport;

import com.litepaltest.model.Classroom;
import com.litepaltest.model.IdCard;
import com.litepaltest.model.Student;
import com.litepaltest.model.Teacher;

import android.test.AndroidTestCase;

public class QueryEagerTest extends AndroidTestCase {

	private Classroom classroom;

	private Student student1;

	private Student student2;

	private Teacher teacher1;

	private IdCard idcard1;

	private IdCard idcard2;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		classroom = new Classroom();
		classroom.setName("Classroom 11");
		idcard1 = new IdCard();
		idcard1.setNumber("320311");
		idcard2 = new IdCard();
		idcard2.setNumber("320322");
		student1 = new Student();
		student1.setName("Student 1");
		student1.setClassroom(classroom);
		student1.setIdcard(idcard1);
		student2 = new Student();
		student2.setName("Student 2");
		student2.setClassroom(classroom);
		teacher1 = new Teacher();
		teacher1.setTeacherName("Teacher 1");
		teacher1.setIdCard(idcard2);
		classroom.save();
		student1.save();
		student2.save();
		idcard1.save();
		idcard2.save();
		teacher1.save();
	}

	public void testFind() {
//		Student s1 = DataSupport.find(Student.class, student1.getId(), true);
//		Classroom c = s1.getClassroom();
//		IdCard ic1 = s1.getIdcard();
//		assertNotNull(c);
//		assertNotNull(ic1);
//		assertEquals(classroom.get_id(), c.get_id());
//		assertEquals("Classroom 11", c.getName());
//		assertEquals(idcard1.getId(), ic1.getId());
//		assertEquals("320322", ic1.getNumber());
//		s1 = DataSupport.find(Student.class, student1.getId());
//		c = s1.getClassroom();
//		assertNull(c);
	}

}
