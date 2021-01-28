import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.project.system.Completition;
import ru.project.system.DB.Book;
import ru.project.system.DB.Status;

import java.util.ArrayList;

public class BookTest {

    private int sizeBefore;

    @Before
    @SuppressWarnings("all")
    public void setUpDB() {
        Completition completition = new Completition();
    }

    @Before
    public void sizeDB() {
        sizeBefore = Book.getBookDataBase().size();
    }

    @Test
    public void takeBookTest() {
        Book.takeBook(0, "tom");
        ArrayList<Book> bookList = Book.getBookDataBase();
        Assert.assertEquals("tom", bookList.get(0).getReader());
        Assert.assertEquals(Status.WAIT_ISSUE, bookList.get(0).getStatus());
    }

    @Test
    public void returnBook() {
        Book.returnBook(0);
        ArrayList<Book> bookList = Book.getBookDataBase();
        Assert.assertEquals(Status.WAIT_REFUND, bookList.get(0).getStatus());
    }

    @Test
    public void giveBook() {
        Book.giveBook(0);
        ArrayList<Book> bookList = Book.getBookDataBase();
        Assert.assertEquals(Status.TAKEN, bookList.get(0).getStatus());
    }

    @Test
    public void acceptBook() {
        Book.acceptBook(0);
        ArrayList<Book> bookList = Book.getBookDataBase();
        Assert.assertEquals(Status.STOCK, bookList.get(0).getStatus());
    }

    @Test
    public void checkSizeDB(){
       int sizeAfter = Book.getBookDataBase().size();
        Assert.assertEquals(sizeBefore, sizeAfter);
    }
}
