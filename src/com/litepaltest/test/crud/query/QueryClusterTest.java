package com.litepaltest.test.crud.query;

import java.util.List;

import org.litepal.crud.DataSupport;

import com.litepaltest.model.Book;
import com.litepaltest.test.LitePalTestCase;

public class QueryClusterTest extends LitePalTestCase {

	public void testSelect() {
		List<Book> expectedBooks = getBooks();
		List<Book> books = DataSupport.select("bookname", "price").execute(Book.class);
		assertEquals(expectedBooks.size(), books.size());
		for (int i = 0; i < books.size(); i++) {
			Book book = books.get(i);
			assertEquals(expectedBooks.get(i).getBookName(), book.getBookName());
			assertEquals(0, book.getPages());
			assertEquals(false, book.isPublished());
			assertEquals(0f, book.getArea());
			assertEquals(expectedBooks.get(i).getPrice(), book.getPrice());
			assertEquals(0, book.getIsbn());
			assertEquals(0, book.getLevel());
			assertEquals(expectedBooks.get(i).getId(), book.getId());
		}
	}

	public void testWhere() {
		List<Book> books = DataSupport.where("bookname = ?", "Android First Line").execute(
				Book.class);
		for (Book book : books) {
			assertEquals("Android First Line", book.getBookName());
			assertEquals(450, book.getPages());
			assertEquals(49.99, book.getPrice());
			assertEquals(false, book.isPublished());
			assertEquals('A', book.getLevel());
			assertEquals(10.5f, book.getArea());
		}
		List<Book> expectedBooks = getBooks();
		List<Book> realBooks = DataSupport.where("bookname like ?", "Android%Line").execute(
				Book.class);
		assertEquals(expectedBooks.size(), realBooks.size());
	}

}
