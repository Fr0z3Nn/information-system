import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import ru.project.system.Completition;
import ru.project.system.DB.Book;
import ru.project.system.DB.Status;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class BookTest {

    private int sizeBefore;
    private ArrayList<Book> bookList = Book.getBookDataBase();

    @BeforeAll
    @SuppressWarnings("all")
    public void setUpDB() {
        Completition completition = new Completition();
        bookList = Book.getBookDataBase();
    }

    @BeforeAll
    public void sizeDB() {
        sizeBefore = Book.getBookDataBase().size();
    }

    @Test
    public void takeBookTest() {
        Book.takeBook(0, "tom");
        assertEquals("tom", bookList.get(0).getReader());
        assertEquals(Status.WAIT_ISSUE, bookList.get(0).getStatus());
    }

    @Test
    public void returnBook() {
        Book.returnBook(0);
        assertEquals(Status.WAIT_REFUND, bookList.get(0).getStatus());
    }

    @Test
    public void giveBook() {
        Book.giveBook(0);
        assertEquals(Status.TAKEN, bookList.get(0).getStatus());
    }

    @Test
    public void acceptBook() {
        Book.acceptBook(0);
        assertEquals(Status.STOCK, bookList.get(0).getStatus());
    }

    @Test
    public void checkSizeDB(){
       int sizeAfter = Book.getBookDataBase().size();
        assertEquals(sizeBefore, sizeAfter);
    }
}
