package com.von.api.product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    public void systemOUut() {
        Item s = new Item();
        String s3 = s.systemOut();
        System.out.println("-->" + s3);
        String s2 = "Hello";
        Assertions.assertEquals(s.systemOut(), "Hello");
    }
    @Test
    public void add(){
            Item i = new Item();
            int result = i.add(1,2);
        System.out.println(result);
            assertEquals(3, result);
    }
}