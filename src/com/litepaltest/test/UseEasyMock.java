package com.litepaltest.test;

import java.sql.ResultSet;

import junit.framework.Assert;

import org.easymock.EasyMock;
import org.easymock.IMocksControl;

import android.database.Cursor;

public class UseEasyMock extends LitePalTestCase {

	public void testInterfaceUsing() {
		try {
			IMocksControl control = EasyMock.createControl();
			ResultSet resultSet = control.createMock(ResultSet.class);
			resultSet.next();
			EasyMock.expectLastCall().andReturn(true).times(2);
			EasyMock.expectLastCall().andReturn(false);
			resultSet.getString(1);
			EasyMock.expectLastCall().andReturn("iPhone");
			EasyMock.expectLastCall().andReturn("SamSung");
			resultSet.getDouble(2);
			EasyMock.expectLastCall().andReturn(5299.03);
			EasyMock.expectLastCall().andReturn(3055.12);
			control.replay();
			int i = 0;
			while (resultSet.next()) {
				if (i == 0) {
					Assert.assertEquals("iPhone", resultSet.getString(1));
					Assert.assertEquals(5299.03, resultSet.getDouble(2));
				} else if (i == 1) {
					Assert.assertEquals("SamSung", resultSet.getString(1));
					Assert.assertEquals(3055.12, resultSet.getDouble(2));
				}
				i++;
			}
			control.verify();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testClassUsing() {
		IMocksControl control = EasyMock.createControl();
		Cursor cursor = control.createMock(Cursor.class);
		cursor.moveToFirst();
		EasyMock.expectLastCall().andReturn(true);
		cursor.getString(1);
		EasyMock.expectLastCall().andReturn("iPhone");
		cursor.getDouble(2);
		EasyMock.expectLastCall().andReturn(5299.03);
		control.replay();
		if (cursor.moveToFirst()) {
			Assert.assertEquals("iPhone", cursor.getString(1));
			Assert.assertEquals(5299.03, cursor.getDouble(2));
		}
		control.verify();
	}

}
