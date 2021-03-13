package com.chocan.TestFiles;

import com.chocan.Accounts.Provider;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProviderTest {

    @Test
    void getName() {
        Provider a = new Provider("name", 123, "street", "city", "state", 12345,10,20);
        assertEquals("name", a.getName());
    }

    @Test
    void setName() {
        Provider a = new Provider("name", 123, "street", "city", "state", 12345,10,20);
        a.setName("bob");
        assertEquals("bob", a.getName());
    }

    @Test
    void getNumber() {
        Provider a = new Provider("name", 123, "street", "city", "state", 12345,10,20);
        assertEquals(123, a.getNumber());
    }

    @Test
    void setNumber() {
        Provider a = new Provider("name", 123, "street", "city", "state", 12345,10,20);
        a.setNumber(321);
        assertEquals(321, a.getNumber());
    }

    @Test
    void getAddress() {
        Provider a = new Provider("name", 123, "street", "city", "state", 12345,10,20);
        assertEquals("street", a.getAddress());
    }

    @Test
    void setAddress() {
        Provider a = new Provider("name", 123, "street", "city", "state", 12345,10,20);
        a.setAddress("maple street");
        assertEquals("maple street", a.getAddress());
    }

    @Test
    void getCity() {
        Provider a = new Provider("name", 123, "street", "city", "state", 12345,10,20);
        assertEquals("city", a.getCity());
    }

    @Test
    void setCity() {
        Provider a = new Provider("name", 123, "street", "city", "state", 12345,10,20);
        a.setCity("salem");
        assertEquals("salem", a.getCity());
    }

    @Test
    void getState() {
        Provider a = new Provider("name", 123, "street", "city", "state", 12345,10,20);
        assertEquals("state", a.getState());
    }

    @Test
    void setState() {
        Provider a = new Provider("name", 123, "street", "city", "state", 12345,10,20);
        a.setState("OR");
        assertEquals("OR", a.getState());
    }

    @Test
    void getZip() {
        Provider a = new Provider("name", 123, "street", "city", "state", 12345,10,20);
        assertEquals(12345, a.getZip());
    }

    @Test
    void setZip() {
        Provider a = new Provider("name", 123, "street", "city", "state", 12345,10,20);
        a.setZip(54321);
        assertEquals(54321, a.getZip());
    }

    @Test
    void getWeekFee() {
        Provider a = new Provider("name", 123, "street", "city", "state", 12345,10,20);
        assertEquals(20, a.getWeekFee());
    }

    @Test
    void setWeekFee() {
        Provider a = new Provider("name", 123, "street", "city", "state", 12345,10,20);
        a.setWeekFee(222);
        assertEquals(222, a.getWeekFee());
    }

    @Test
    void getConsultations() {
        Provider a = new Provider("name", 123, "street", "city", "state", 12345,10,20);
        assertEquals(10, a.getConsultations());
    }

    @Test
    void setConsultations() {
        Provider a = new Provider("name", 123, "street", "city", "state", 12345,10,20);
        a.setConsultations(111);
        assertEquals(111, a.getConsultations());
    }
}