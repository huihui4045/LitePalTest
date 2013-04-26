package com.litepaltest.test.crud.query;

import org.litepal.crud.DataSupport;

import android.test.AndroidTestCase;

import com.litepaltest.model.Teacher;

public class QueryByIdTest extends AndroidTestCase {

	public void testQuery() {
		Teacher t = new Teacher();
		t.setAge(25);
		t.setSex(true);
		t.setTeachYears(3);
		t.setTeacherName("Jimmy");
		t.save();
		DataSupport.find(Teacher.class, t.getId());
	}

}
