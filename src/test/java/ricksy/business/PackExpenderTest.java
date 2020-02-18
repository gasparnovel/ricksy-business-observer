package ricksy.business;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Before;

public class PackExpenderTest {

    private PackExpender expender = null;

    @Before
    public void setupExpender() {
        expender = new PackExpender(100, 50.0);
        assertNotNull("Expender creado", expender);
    }

    @Test 
    public void constructortest() {  
        assertNotNull("Expender creado", expender);      
        assertEquals(100, expender.stock());
    }

    @Test
    public void dispatchTestOK() {
        CreditCard card = new CreditCard("Abradolf Lincler", "4916119711304546");
        expender.dispatch(card);
        assertEquals(99, expender.stock());
    }

    @Test
    public void dispatchTestNoStock() {
        CreditCard card = new CreditCard("Abradolf Lincler", "4916119711304546");
        expender = new PackExpender(0, 50.0);
        expender.dispatch(card);
        assertEquals(0, expender.stock());
    }

    @Test
    public void dispatchTestNoCredit() {
        CreditCard card = new CreditCard("Abradolf Lincler", "4916119711304546");
        expender = new PackExpender(100, 4000);
        expender.dispatch(card);
        assertEquals(100, expender.stock());
    }
}