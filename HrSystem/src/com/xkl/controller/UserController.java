package com.xkl.controller;

import com.xkl.model.User;
import com.xkl.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by xkl on 2018/1/25.
 */
@Controller
public class UserController {
    @Resource
    private UserService userService;
    @RequestMapping(value = "/toUserView",method = RequestMethod.GET)
    public String toUserView(){
        return "aUserView";
    }
    @RequestMapping(value = "/regUser",method = RequestMethod.POST)
    public String regUser(User user, HttpSession session){
        boolean b=userService.addUser(user);
        return "aUserView";
    }
    @RequestMapping(value = "/jobInfo",method = RequestMethod.GET)
    //这里与管理员发布的招聘信息配对
    public String jobInfo(HttpSession session){

        return "jobInfo";
    }
}
