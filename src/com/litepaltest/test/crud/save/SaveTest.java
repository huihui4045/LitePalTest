package com.litepaltest.test.crud.save;

import junit.framework.Assert;

import com.litepaltest.model.Cellphone;
import com.litepaltest.model.Classroom;
import com.litepaltest.model.IdCard;
import com.litepaltest.model.Student;
import com.litepaltest.model.Teacher;
import com.litepaltest.test.LitePalTestCase;

public class SaveTest extends LitePalTestCase {

	public void testSave() {
		Cellphone cell = new Cellphone();
		cell.setBrand("iPhone");
		cell.setPrice(4998.01);
		cell.setInStock('Y');
		Assert.assertTrue(cell.save());
		Assert.assertTrue(isDataExists(getTableName(cell), cell.getId()));
	}
	
	public void testSaveAfterDelete() {
		Cellphone cell = new Cellphone();
		cell.setBrand("iPhone");
		cell.setPrice(4998.01);
		cell.setInStock('Y');
		Assert.assertTrue(cell.save());
		Assert.assertTrue(isDataExists(getTableName(cell), cell.getId()));
		assertTrue(cell.delete() > 0);
		assertTrue(cell.save());
		Assert.assertTrue(isDataExists(getTableName(cell), cell.getId()));
		Student stu = new Student();
		stu.setName("Jimmy");
		IdCard idcard = new IdCard();
		idcard.setAddress("Washington");
		idcard.setNumber("123456");
		idcard.setStudent(stu);
		stu.setIdcard(idcard);
		stu.save();
		idcard.save();
		Assert.assertTrue(isDataExists(getTableName(stu), stu.getId()));
		Assert.assertTrue(isDataExists(getTableName(idcard), idcard.getId()));
		stu.delete();
		Assert.assertFalse(isDataExists(getTableName(stu), stu.getId()));
		Assert.assertFalse(isDataExists(getTableName(idcard), idcard.getId()));
		stu.save();
		idcard.save();
		Assert.assertTrue(isDataExists(getTableName(stu), stu.getId()));
		Assert.assertTrue(isDataExists(getTableName(idcard), idcard.getId()));
		Student danny = new Student();
		danny.setName("Danny");
		danny.setAge(14);
		Teacher cam = new Teacher();
		cam.setTeacherName("Cam");
		cam.setAge(33);
		cam.setSex(true);
		cam.setTeachYears(5);
		Teacher jack = new Teacher();
		jack.setTeacherName("Jack");
		jack.setAge(36);
		jack.setSex(false);
		jack.setTeachYears(11);
		danny.getTeachers().add(jack);
		danny.getTeachers().add(cam);
		cam.getStudents().add(danny);
		jack.getStudents().add(danny);
		danny.save();
		cam.save();
		jack.save();
		Assert.assertTrue(isDataExists(getTableName(danny), danny.getId()));
		Assert.assertTrue(isDataExists(getTableName(cam), cam.getId()));
		Assert.assertTrue(isDataExists(getTableName(jack), jack.getId()));
		danny.delete();
		Assert.assertFalse(isDataExists(getTableName(danny), danny.getId()));
		Assert.assertTrue(isDataExists(getTableName(cam), cam.getId()));
		Assert.assertTrue(isDataExists(getTableName(jack), jack.getId()));
		danny.save();
		Assert.assertTrue(isDataExists(getTableName(danny), danny.getId()));
		assertEquals(danny.getTeachers().size(), 2);
		Classroom c = new Classroom();
		c.setName("test classroom");
		Student s = new Student();
		s.setName("Tom");
		s.setClassroom(c);
		Student s2 = new Student();
		s2.setName("Tom");
		s2.setClassroom(c);
		assertTrue(c.save());
		assertTrue(s.save());
		assertTrue(s2.save());
		Assert.assertTrue(isDataExists(getTableName(c), c.get_id()));
		Assert.assertTrue(isDataExists(getTableName(s), s.getId()));
		Assert.assertTrue(isDataExists(getTableName(s), s2.getId()));
		c.delete();
		Assert.assertFalse(isDataExists(getTableName(c), c.get_id()));
		Assert.assertFalse(isDataExists(getTableName(s), s.getId()));
		Assert.assertFalse(isDataExists(getTableName(s), s2.getId()));
		c.save();
		s.save();
		s2.save();
		Assert.assertTrue(isDataExists(getTableName(c), c.get_id()));
		Assert.assertTrue(isDataExists(getTableName(s), s.getId()));
		Assert.assertTrue(isDataExists(getTableName(s), s2.getId()));
	}

}
