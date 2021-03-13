package com.chocan.TestFiles;

import com.chocan.ProductService.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
@SuppressWarnings( "deprecation" )

class ProductTest {

    @Test
    void setCurrentDateAndTime() {
        Date d = new Date(0,0,0,0,0,0);
        Product p = new Product(d,d,123,"joe",321,"bob","3232",999,"test comment");
        //setCurrentDateAndTime()
        Date newD = new Date(1,2,3,1,2,3);
        p.setCurrentDateAndTime(newD);
        assertEquals(1, p.getCurrentDateAndTime().getYear());
        assertEquals(2, p.getCurrentDateAndTime().getMonth());
        assertEquals(3, p.getCurrentDateAndTime().getDate());
        assertEquals(1, p.getCurrentDateAndTime().getHours());
        assertEquals(2, p.getCurrentDateAndTime().getMinutes());
        assertEquals(3, p.getCurrentDateAndTime().getSeconds());

        /*careful about date, it will do conversion for months and days.*/

    }

    @Test
    void getCurrentDateAndTime() {
        Date d = new Date(1,2,3,1,2,3);
        Product p = new Product(d,d,123,"joe",321,"bob","3232",999,"test comment");
        assertEquals(d, p.getCurrentDateAndTime());
    }

    @Test
    void setServiceDate() {
        Date d = new Date(0,0,0);
        Product p = new Product(d,d,123,"joe",321,"bob","3232",999,"test comment");
        Date newD = new Date(1,2,3);
        p.setServiceDate(newD);
        assertEquals(1, p.getServiceDate().getYear());
        assertEquals(2, p.getServiceDate().getMonth());
        assertEquals(3, p.getServiceDate().getDate());


    }

    @Test
    void getServiceDate() {
        Date d = new Date(0,0,0);
        Product p = new Product(d,d,123,"joe",321,"bob","3232",999,"test comment");
        assertEquals(d, p.getServiceDate());
    }


    @Test
    void getProviderNumber() {
        Date d = new Date(0,0,0);
        Product p = new Product(d,d,123,"joe",321,"bob","3232",999,"test comment");
        assertEquals(123,p.getProviderNumber());
    }

    @Test
    void setProviderNumber() {
        Date d = new Date(0,0,0);
        Product p = new Product(d,d,123,"joe",321,"bob","3232",999,"test comment");
        p.setProviderNumber(9999);
        assertEquals(9999, p.getProviderNumber());
    }

    @Test
    void getProviderName() {
        Date d = new Date(0,0,0);
        Product p = new Product(d,d,123,"joe",321,"bob","3232",999,"test comment");
        assertEquals("joe",p.getProviderName());
    }

    @Test
    void setProviderName() {
        Date d = new Date(0,0,0);
        Product p = new Product(d,d,123,"joe",321,"bob","3232",999,"test comment");
        p.setProviderName("eoj");
        assertEquals("eoj",p.getProviderName());
    }

    @Test
    void getMemberNumber() {
        Date d = new Date(0,0,0);
        Product p = new Product(d,d,123,"joe",321,"bob","3232",999,"test comment");
        assertEquals(321,p.getMemberNumber());
    }

    @Test
    void setMemberNumber() {
        Date d = new Date(0,0,0);
        Product p = new Product(d,d,123,"joe",321,"bob","3232",999,"test comment");
        p.setMemberNumber(2129);
        assertEquals(2129,p.getMemberNumber());
    }

    @Test
    void getMemberName() {
        Date d = new Date(0,0,0);
        Product p = new Product(d,d,123,"joe",321,"bob","3232",999,"test comment");
        assertEquals("bob",p.getMemberName());
    }

    @Test
    void setMemberName() {
        Date d = new Date(0,0,0);
        Product p = new Product(d,d,123,"joe",321,"bob","3232",999,"test comment");
        p.setMemberName("racecar");
        assertEquals("racecar",p.getMemberName());
    }

    @Test
    void getServiceCode() {
        Date d = new Date(0,0,0);
        Product p = new Product(d,d,123,"joe",321,"bob","3232",999,"test comment");
        assertEquals("3232",p.getServiceCode());
    }

    @Test
    void setServiceCode() {
        Date d = new Date(0,0,0);
        Product p = new Product(d,d,123,"joe",321,"bob","3232",999,"test comment");
        p.setServiceCode("155555");
        assertEquals("155555",p.getServiceCode());
    }

    @Test
    void getFee() {
        Date d = new Date(0,0,0);
        Product p = new Product(d,d,123,"joe",321,"bob","3232",999,"test comment");
        assertEquals(999,p.getFee());
    }

    @Test
    void setFee() {
        Date d = new Date(0,0,0);
        Product p = new Product(d,d,123,"joe",321,"bob","3232",999,"test comment");
        p.setFee(444);
        assertEquals(444,p.getFee());
    }

    @Test
    void getComments() {
        Date d = new Date(0,0,0);
        Product p = new Product(d,d,123,"joe",321,"bob","3232",999,"test comment");
        assertEquals("test comment",p.getComments());
    }

    @Test
    void setComments() {
        Date d = new Date(0,0,0);
        Product p = new Product(d,d,123,"joe",321,"bob","3232",999,"test comment");
        p.setComments("comment test");
        assertEquals("comment test",p.getComments());
    }

}