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
        assertEquals(1,new App.Test().test());
    }

    @Test
    void test2(){
        assertEquals(2,new App.Test().test2());
    }

    @Test
    void test3(){
        assertEquals(3,new App.Test().test3());
    }
}
