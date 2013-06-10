package com.litepaltest.test.crud.query;

import java.util.List;

import org.litepal.crud.DataSupport;

import android.test.AndroidTestCase;

import com.litepaltest.model.Book;

public class QueryBasicTest extends AndroidTestCase {

	public void testFind() {
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

	public void testFindMul() {
		short isbn1 = 30017;
		Book book1 = new Book();
		book1.setArea(1.5f);
		book1.setBookName("Android Second Line");
		book1.setIsbn(isbn1);
		book1.setLevel('B');
		book1.setPages(434);
		book1.setPrice(40.99);
		book1.setPublished(true);
		book1.save();
		short isbn2 = 30014;
		Book book2 = new Book();
		book2.setArea(8.8f);
		book2.setBookName("Android Third Line");
		book2.setIsbn(isbn2);
		book2.setLevel('C');
		book2.setPages(411);
		book2.setPrice(35.99);
		book2.setPublished(false);
		book2.save();
		DataSupport.findMul(Book.class, new long[]{});
		List<Book> bookList = DataSupport.findMul(Book.class, book1.getId(), book2.getId());
		assertEquals(2, bookList.size());
		for (Book book : bookList) {
			if (book.getId() == book1.getId()) {
				assertEquals(1.5f, book.getArea());
				assertEquals("Android Second Line", book.getBookName());
				assertEquals(isbn1, book.getIsbn());
				assertEquals('B', book.getLevel());
				assertEquals(434, book.getPages());
				assertEquals(40.99, book.getPrice());
				assertTrue(book.isPublished());
				continue;
			} else if (book.getId() == book2.getId()) {
				assertEquals(8.8f, book.getArea());
				assertEquals("Android Third Line", book.getBookName());
				assertEquals(isbn2, book.getIsbn());
				assertEquals('C', book.getLevel());
				assertEquals(411, book.getPages());
				assertEquals(35.99, book.getPrice());
				assertFalse(book.isPublished());
				continue;
			}
			fail();
		}
	}

}
