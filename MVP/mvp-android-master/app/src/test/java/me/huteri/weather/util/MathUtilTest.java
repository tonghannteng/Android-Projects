package me.huteri.weather.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MathUtilTest {

    @Test
    public void testGetNoDecimal() throws Exception {
        Float number = Float.valueOf("2.123123");
        assertEquals("2", MathUtil.getNoDecimal(number));

    }
}
