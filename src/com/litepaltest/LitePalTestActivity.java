package com.litepaltest;

import org.litepal.LitePalApplication;
import org.litepal.tablemanager.Connector;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.litepaltest.model.IdCard;
import com.litepaltest.model.Student;
import com.litepaltest.model.Teacher;

public class LitePalTestActivity extends Activity {
	public static final String TAG = "LitePalTestActivity";
	Button button;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		// SharedPreferences prefs =
		// PreferenceManager.getDefaultSharedPreferences(this);
		// SharedPreferences.Editor edit = prefs.edit();
		// edit.putBoolean("aaa", true);
		// edit.commit();
		button = (Button) findViewById(R.id.add);
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Connector.getDatabase();
				// IdCard idcard1 = new IdCard();
				// idcard1.setNumber("320300");
				// Classroom c1 = new Classroom();
				// c1.setName("Art room");
				// Student s1 = new Student();
				// s1.setName("Tommy");
				// s1.setAge(14);
				// s1.setClassroom(c1);
				// Student s2 = new Student();
				// s2.setName("Jude");
				// s2.setAge(13);
				// s2.setClassroom(c1);
				// Set<Student> ss = new HashSet<Student>();
				// ss.add(s1);
				// ss.add(s2);
				// c1.setStudentCollection(ss);
				// s1.save();
				// s2.save();
				// c1.save();
				// s1.setClassroom(c1);
				// s2.setClassroom(c1);
				// Teacher teacher = new Teacher();
				// teacher.setSex(true);
				// teacher.setAge(24);
				// teacher.setTeacherName("John");
				// teacher.setTeachYears(1);
				// Teacher teacher2 = new Teacher();
				// teacher2.setSex(false);
				// teacher2.setAge(30);
				// teacher2.setTeacherName("Tina");
				// teacher2.setTeachYears(8);
				// IdCard idCard = new IdCard();
				// idCard.setNumber("320311");
				// idCard.setAddress("martin road");
				// idCard.setTeacher(teacher);
				// IdCard idCard2 = new IdCard();
				// idCard2.setNumber("999777");
				// idCard2.setAddress("nanjing road");
				// idCard2.setTeacher(teacher2);
				// teacher.setIdCard(idCard);
				// teacher2.setIdCard(idCard2);
				// idCard.save();
				// idCard2.save();
				// teacher.save();
				// teacher2.save();
				// s1.setTeacher(teacher);
				// s2.setTeacher(teacher);
				// teacher.save();
				// s1.save();
				// s2.save();
				// teacher.getStudents().add(s1);
				// teacher.getStudents().add(s2);
				// c1.save();
				// c1.printBaseObjId();
				// s1.printBaseObjId();
				// s2.printBaseObjId();
				// LogUtil.d("LitePalTestActivity", "s1.getClassroom is " +
				// s1.getClassroom());
				// LogUtil.d("LitePalTestActivity", "s2.getClassroom is " +
				// s2.getClassroom());
				// teacher.save();

				// Student danny = new Student();
				// danny.setName("Danny");
				// danny.setAge(14);
				// Student mick = new Student();
				// mick.setName("Mick");
				// mick.setAge(13);
				// Teacher cam = new Teacher();
				// cam.setTeacherName("Cam");
				// cam.setAge(33);
				// cam.setSex(true);
				// cam.setTeachYears(5);
				// Teacher jack = new Teacher();
				// jack.setTeacherName("Jack");
				// jack.setAge(36);
				// jack.setSex(false);
				// jack.setTeachYears(11);
				//
				// danny.getTeachers().add(jack);
				// danny.getTeachers().add(cam);
				//
				// mick.getTeachers().add(jack);
				// mick.getTeachers().add(cam);
				//
				// cam.getStudents().add(danny);
				// cam.getStudents().add(mick);
				//
				// jack.getStudents().add(danny);
				// jack.getStudents().add(mick);
				//
				// danny.save();
				// mick.save();
				// cam.save();
				// jack.save();
				// LogUtil.d(TAG,
				// "self class is " + cam + " associated models are " +
				// cam.getStudents());
				// LogUtil.d(TAG,
				// "self class is " + jack + " associated models are " +
				// jack.getStudents());
				// Classroom c = new Classroom();
				// c.setName("Computer room");
				// Classroom c2 = new Classroom();
				// c2.setName("Music room");
				// Student s = new Student();
				// s.setName("Tony");
				// s.setAge(23);
				// s.setClassroom(c);
				// c.save();
				// c2.save();
				// s.save();
				// c.getStudentCollection().clear();
				// c.save();
				// // c2.getStudentCollection().add(s);
				// c2.save();
				Toast.makeText(LitePalApplication.getContext(), "Add success", Toast.LENGTH_SHORT)
						.show();
			}
		});
	}
}