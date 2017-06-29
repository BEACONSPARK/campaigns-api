package com.engageya.controllers;


import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by DANIEL on 1/23/2017
 */
public class IsAliveControllerTest {

    IsAliveController isAliveController = new IsAliveController();

    @Test
    public void isAlive() throws Exception {
        assertThat(isAliveController.isAlive(), equalTo("true"));
    }

}