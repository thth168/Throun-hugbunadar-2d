/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hi.d.throbo.Model;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.hi.d.throbo.Database.Database;

/**
 *
 * @author Throstur Almar
 */
public class UsersTest {
    private static Users instance;
    
    public UsersTest() {
    }
    
    @BeforeAll
    public static void setUpClass() throws ClassNotFoundException {
        instance = new Users();
    }
    
    @AfterAll
    public static void tearDownClass() {
        instance = null;
    }

    /**
     * Test of getUser method, of class Users.
     */
    
}
