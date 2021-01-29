import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import ru.project.system.PO;

@DisplayName("НОД двух целых чисел")
public class POTest {

    PO po = new PO();

    @Test
    @DisplayName("Проверка работоспособности")
    public void workingTest(){
        po.NOD(10,10);
    }

    @Test
    @DisplayName("НОД 15 и 20")
    public void NOD_15_20(){
        int a = po.NOD(15,20);
        assertEquals(5, a);
    }

    @Test
    @DisplayName("НОД 20 и 15")
    public void NOD_20_15(){
        int a = po.NOD(20,15);
        assertEquals(5,a);
    }

    @Test
    @DisplayName("НОД 0 и 100")
    public void NOD_0_100(){
        int a = po.NOD(100,0);
        assertEquals(100,a);
    }

    @Test
    @DisplayName("НОД -12 и 30")
    public void NOD_min12_30(){
        int a = po.NOD(-12,30);
        assertEquals(6,a);
    }

    @Test
    @DisplayName("НОД 12 и 0b10101 (21)")
    public void NOD_12_0b10101(){
        int a = po.NOD(12,0b10101);
        assertEquals(3,a);
    }

    @Test
    @DisplayName("НОД 523525230 и 3150")
    public void NOD_523525230_3150(){
        int a = po.NOD(3150,523525230);
        assertEquals(90,a);
    }
}
