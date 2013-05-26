package com.litepaltest.test.crud.query;

import org.litepal.crud.DataSupport;

import android.test.AndroidTestCase;

import com.litepaltest.model.Book;

public class QueryByIdTest extends AndroidTestCase {

	public void testQuery() {
		short isbn = 30013;
		Book book = new Book();
		book.setArea(10.5f);
		book.setBookName("Android First Line");
		book.setIsbn(isbn);
		book.setLevel('A');
		book.setPages(450);
		book.setPrice(49.99);
		book.setPublished(false);
		book.save();
		Book b = DataSupport.find(Book.class, book.getId());
		assertEquals(10.5f, b.getArea());
		assertEquals("Android First Line", b.getBookName());
		assertEquals(isbn, b.getIsbn());
		assertEquals('A', b.getLevel());
		assertEquals(450, b.getPages());
		assertEquals(49.99, b.getPrice());
		assertFalse(b.isPublished());
	}

}
