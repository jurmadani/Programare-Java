import org.example.PerecheNumere;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestePerecheNumere {
    @Test
    void test1_fibonacci() {
        PerecheNumere p=new PerecheNumere(1,1);
        assertEquals(true, p.checkIfNumbersAreFibonacciGroup());
    }
    @Test
    void test2_cmmdc() {
        PerecheNumere p=new PerecheNumere(10,15);
        assertTrue(p.cmmdc()==5);
    }
    @Test
    void test3_cifrePare() {
        PerecheNumere c=new PerecheNumere(15,20);
        assertFalse(c.nrCifrelorPareEgala());
    }
}
