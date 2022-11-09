package DAO;

import Model.Cart;
import Model.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class DAO_2Test{
    DAO_2 dao= new DAO_2();
    @Test
    public void changePassword() {
        dao.changePassword("1234","sa");
        System.out.println("updated");
    }
    @Test
    public void viewProfile() {
        User user=dao.viewProfile("sa");
        System.out.println(user);
    }

    @Test
    public void updateProfile() {
    }
}