package com.shravan.learn;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProfileTest {

    @Test
    public void testProfile() {
        final String profileId = System.getenv("profileId");
        final String testProperty = System.getenv("testProperty");
        if (profileId.equalsIgnoreCase("1")) {
            assertEquals(testProperty, "value1");
        } else if (profileId.equalsIgnoreCase("2")) {
            assertEquals(testProperty, "value2");
        }
    }
}
