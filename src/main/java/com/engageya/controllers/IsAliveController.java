package com.engageya.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by DANIEL on 1/10/2017
 */
@Controller
public class IsAliveController {
    /**
     * @todo, danielw - add schema validation (call userDaoFacade.findOne()
     * and return true).
     */
    @RequestMapping("/isAlive")
    @ResponseBody
    public String isAlive() {
        return "true";
    }
}
