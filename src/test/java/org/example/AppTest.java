package org.example;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest
{

    @Test
    void test(){
        assertEquals(10,new App.Test().test());
    }

    @Test
    void test2(){
        assertEquals(20,new App.Test().test2());
    }


    @Test
    void test4(){
        assertEquals(40,new App.Test().test2());
    }
    @Test
    void test5(){
        assertEquals(40,new App.Test().test2());
    }
    @Test
    void test6(){
        assertEquals(40,new App.Test().test2());
    }
    @Test
    void test7(){
        assertEquals(40,new App.Test().test2());
    }
    @Test
    void test8(){
        assertEquals(20,new App.Test().test2());
    }


    }
