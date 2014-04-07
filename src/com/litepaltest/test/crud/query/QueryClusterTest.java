package com.litepaltest.test.crud.query;

import java.util.List;

import org.litepal.crud.DataSupport;

import com.litepaltest.model.Book;
import com.litepaltest.test.LitePalTestCase;

public class QueryClusterTest extends LitePalTestCase {

	public void testSelect() {
		List<Book> expectedBooks = getBooks(null, null, null, null, null, null, null);
		List<Book> books = DataSupport.select("bookname", "price").find(Book.class);
		assertEquals(expectedBooks.size(), books.size());
		for (int i = 0; i < books.size(); i++) {
			Book book = books.get(i);
			assertTrue(book.isSaved());
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
		List<Book> books = DataSupport.where("bookname = ?", "Android First Line").find(Book.class);
		for (Book book : books) {
			assertTrue(book.isSaved());
			assertEquals("Android First Line", book.getBookName());
			assertEquals(450, book.getPages());
			assertEquals(49.99, book.getPrice());
			assertEquals(false, book.isPublished());
			assertEquals('A', book.getLevel());
			assertEquals(10.5f, book.getArea());
		}
		List<Book> expectedBooks = getBooks(null, "bookname like ?",
				new String[] { "Android%Line" }, null, null, null, null);
		List<Book> realBooks = DataSupport.where("bookname like ?", "Android%Line")
				.find(Book.class);
		assertEquals(expectedBooks.size(), realBooks.size());
	}

	public void testOrder() {
		List<Book> books = DataSupport.order("ID").find(Book.class);
		Book lastBook = null;
		for (int i = 0; i < books.size(); i++) {
			Book book = books.get(i);
			assertTrue(book.isSaved());
			if (lastBook != null) {
				assertTrue(book.getId() > lastBook.getId());
			}
			lastBook = book;
		}
		List<Book> inverseBooks = DataSupport.order("ID desc").find(Book.class);
		Book inverselastBook = null;
		for (int i = 0; i < inverseBooks.size(); i++) {
			Book book = inverseBooks.get(i);
			assertTrue(book.isSaved());
			if (inverselastBook != null) {
				assertTrue(book.getId() < inverselastBook.getId());
			}
			inverselastBook = book;
		}
	}

	public void testLimit() {
		List<Book> bookList = DataSupport.limit(1).find(Book.class);
		assertEquals(1, bookList.size());
		Book book = bookList.get(0);
		assertTrue(book.isSaved());
		Book firstBook = DataSupport.findFirst(Book.class);
		assertTrue(firstBook.isSaved());
		assertEquals(firstBook.getBookName(), book.getBookName());
		assertEquals(firstBook.getPages(), book.getPages());
		assertEquals(firstBook.isPublished(), book.isPublished());
		assertEquals(firstBook.getArea(), book.getArea());
		assertEquals(firstBook.getPrice(), book.getPrice());
		assertEquals(firstBook.getIsbn(), book.getIsbn());
		assertEquals(firstBook.getLevel(), book.getLevel());
		assertEquals(firstBook.getId(), book.getId());
		bookList = DataSupport.order("id desc").limit(1).find(Book.class);
		assertEquals(1, bookList.size());
		book = bookList.get(0);
		assertTrue(book.isSaved());
		Book lastBook = DataSupport.findLast(Book.class);
		assertTrue(lastBook.isSaved());
		assertEquals(lastBook.getBookName(), book.getBookName());
		assertEquals(lastBook.getPages(), book.getPages());
		assertEquals(lastBook.isPublished(), book.isPublished());
		assertEquals(lastBook.getArea(), book.getArea());
		assertEquals(lastBook.getPrice(), book.getPrice());
		assertEquals(lastBook.getIsbn(), book.getIsbn());
		assertEquals(lastBook.getLevel(), book.getLevel());
		assertEquals(lastBook.getId(), book.getId());
	}

	public void testOffset() {
		List<Book> list = DataSupport.offset(1).find(Book.class);
		assertEquals(0, list.size());
		List<Book> bookList = DataSupport.limit(1).offset(1).find(Book.class);
		assertEquals(1, bookList.size());
		Book book = bookList.get(0);
		assertTrue(book.isSaved());
		List<Book> expectedBooks = getBooks(null, null, null, null, null, null, null);
		Book expectedBook = expectedBooks.get(1);
		assertEquals(expectedBook.getBookName(), book.getBookName());
		assertEquals(expectedBook.getPages(), book.getPages());
		assertEquals(expectedBook.isPublished(), book.isPublished());
		assertEquals(expectedBook.getArea(), book.getArea());
		assertEquals(expectedBook.getPrice(), book.getPrice());
		assertEquals(expectedBook.getIsbn(), book.getIsbn());
		assertEquals(expectedBook.getLevel(), book.getLevel());
		assertEquals(expectedBook.getId(), book.getId());
	}

	public void testCluster() {
		List<Book> books = DataSupport.select("pages", "isPublished").where("price = ?", "40.99")
				.order("id desc").limit(2).find(Book.class);
		for (Book book : books) {
			assertTrue(book.isSaved());
			assertNull(book.getBookName());
			assertEquals(434, book.getPages());
			assertEquals(true, book.isPublished());
			assertEquals(0f, book.getArea());
			assertEquals(0.0, book.getPrice());
			assertEquals(0, book.getIsbn());
			assertEquals(0, book.getLevel());
		}
		assertTrue(books.get(0).getId() > books.get(1).getId());
	}

}
