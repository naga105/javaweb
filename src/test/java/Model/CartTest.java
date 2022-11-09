package Model;

import org.junit.Test;

import static org.junit.Assert.*;

public class CartTest {
    @Test
    public void name()throws Exception {
        int actual= Cart.getIdd();
        assertEquals(Cart.idd,3);
    }
}