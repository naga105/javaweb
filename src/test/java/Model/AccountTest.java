package Model;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AccountTest {
    @Test
    public void analizeMessage() throws Exception{
        String actual= Account.getTest();
        Assert.assertEquals(Account.test,actual);
    }
}