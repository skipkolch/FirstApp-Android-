package com.example.user.homework;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    private String str = "11.11.2018";
    private String[] strSplit = new String[] { "11", "11", "2018"};
    @Test
    public void split_isCorrect() { assertEquals(DayActivity.SplitTest(str), strSplit ); }
}