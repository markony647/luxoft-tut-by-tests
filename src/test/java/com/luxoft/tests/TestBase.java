package com.luxoft.tests;

import com.luxoft.app.Application;
import org.junit.After;
import org.junit.Before;

public class TestBase {

    public Application app;

    @Before
    public void setUp() {
        app = new Application();
    }

    @After
    public void tearDown() {
        app.quit();
    }
}
