package com.litepaltest.test.crud.save;

import junit.framework.Assert;

import com.litepaltest.model.Cellphone;
import com.litepaltest.test.LitePalTestCase;

public class SaveTest extends LitePalTestCase {

	public void testSave() {
		Cellphone cell = new Cellphone();
		cell.setBrand("iPhone");
		cell.setPrice(4998.01f);
		cell.setInStock('Y');
		Assert.assertTrue(cell.save());
		Assert.assertTrue(isDataExists(getTableName(cell), cell.getId()));
	}

}
