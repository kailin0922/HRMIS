package com.xkl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by xkl on 2018/1/30.
 */
@Controller
public class EmployeeController {
    @RequestMapping(value = "/toEmployeeView",method = RequestMethod.GET)
    public String toEmployeeView() throws Exception{
        return "employeeLogin";
    }
}
