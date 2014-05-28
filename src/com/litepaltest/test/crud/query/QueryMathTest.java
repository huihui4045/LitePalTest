package com.litepaltest.test.crud.query;

import org.litepal.crud.DataSupport;

import com.litepaltest.model.Student;

import android.database.Cursor;
import android.test.AndroidTestCase;

public class QueryMathTest extends AndroidTestCase {

	public void testCount() {
		int result = DataSupport.count(Student.class);
		int realResult = -100;
		Cursor cursor = DataSupport.findBySQL("select count(1) from student");
		if (cursor.moveToFirst()) {
			realResult = cursor.getInt(0);
		}
		assertEquals(realResult, result);
		result = DataSupport.where("id > ?", "99").count("student");
		cursor = DataSupport.findBySQL("select count(1) from student where id > ?", "99");
		if (cursor.moveToFirst()) {
			realResult = cursor.getInt(0);
		}
		assertEquals(realResult, result);
		try {
			DataSupport.count("nosuchtable");
			fail();
		} catch (Exception e) {
		}
	}

}
