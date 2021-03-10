package com.chocan.Accounts;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberTest {


    @Test
    void getName() {
        Member a = new Member("name", 123, "street", "city", "state", 12345);
        assertEquals("name", a.getName());
    }

    @Test
    void setName() {
        Member a = new Member("name", 123, "street", "city", "state", 12345);
        a.setName("bob");
        assertEquals("bob", a.getName());
    }

    @Test
    void getNumber() {
        Member a = new Member("name", 123, "street", "city", "state", 12345);
        assertEquals(123, a.getNumber());
    }

    @Test
    void setNumber() {
        Member a = new Member("name", 123, "street", "city", "state", 12345);
        a.setNumber(321);
        assertEquals(321, a.getNumber());
    }

    @Test
    void getAddress() {
        Member a = new Member("name", 123, "street", "city", "state", 12345);
        assertEquals("street", a.getAddress());
    }

    @Test
    void setAddress() {
        Member a = new Member("name", 123, "street", "city", "state", 12345);
        a.setAddress("maple street");
        assertEquals("maple street", a.getAddress());
    }

    @Test
    void getCity() {
        Member a = new Member("name", 123, "street", "city", "state", 12345);
        assertEquals("city", a.getCity());
    }

    @Test
    void setCity() {
        Member a = new Member("name", 123, "street", "city", "state", 12345);
        a.setCity("salem");
        assertEquals("salem", a.getCity());
    }

    @Test
    void getState() {
        Member a = new Member("name", 123, "street", "city", "state", 12345);
        assertEquals("state", a.getState());
    }

    @Test
    void setState() {
        Member a = new Member("name", 123, "street", "city", "state", 12345);
        a.setState("OR");
        assertEquals("OR", a.getState());
    }

    @Test
    void getZip() {
        Member a = new Member("name", 123, "street", "city", "state", 12345);
        assertEquals(12345, a.getZip());
    }

    @Test
    void setZip() {
        Member a = new Member("name", 123, "street", "city", "state", 12345);
        a.setZip(54321);
        assertEquals(54321, a.getZip());
    }
}