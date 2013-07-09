package com.litepaltest.test.crud.query;

import java.util.List;

import org.litepal.crud.DataSupport;

import com.litepaltest.model.Book;
import com.litepaltest.test.LitePalTestCase;

public class QueryClusterTest extends LitePalTestCase {

	public void testSelect() {
		List<Book> expectedBooks = getBooks();
		List<Book> books = DataSupport.select("bookname").execute(Book.class);
		assertEquals(expectedBooks.size(), books.size());
		for (int i = 0; i < books.size(); i++) {
			Book book = books.get(i);
			assertEquals(expectedBooks.get(i).getBookName(), book.getBookName());
			assertEquals(0, book.getPages());
			
		}
	}

}
