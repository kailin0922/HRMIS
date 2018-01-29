package com.xkl.controller;

import com.xkl.model.Resume;
import com.xkl.model.User;
import com.xkl.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        return "userLogin";
    }
    @RequestMapping(value = "/aUserView",method = RequestMethod.GET)
    public String toaUserView(){
        return "aUserView";
    }
    @RequestMapping(value = "/regUser",method = RequestMethod.POST)
    public String regUser(User user, HttpSession session) throws Exception{
        User user1=userService.checkName(user);
        if(user1!=null){
           return "regUserError" ;
        }
        boolean b=userService.addUser(user);
        session.setAttribute("user",user);
        return "userLogin";
    }
    @RequestMapping(value = "/logUser",method = RequestMethod.POST)
    public @ResponseBody void logUser(HttpServletRequest request, HttpSession session, HttpServletResponse response) throws Exception{
        String name=request.getParameter("logname");
        String pass=request.getParameter("logpass");
        User user=new User();
        user.setName(name);
        user.setPass(pass);
        User user1=userService.getUser(user);
        session.setAttribute("user",user1);
       if(user1!=null){
           response.getWriter().print("ok");
       }else {
           response.getWriter().print("sorry");
       }
    }
    @RequestMapping(value = "/jobInfo",method = RequestMethod.GET)
    //这里与管理员发布的招聘信息配对
    public String jobInfo(HttpSession session) throws Exception{
        session.setAttribute("judge","user");
        return "userJobInfo";
    }
    @RequestMapping(value = "/toResume",method = RequestMethod.GET)
    public String toResume(HttpSession session) throws Exception{
        User user= (User) session.getAttribute("user");
        Resume resume=userService.getResume(user);
        session.setAttribute("resume",resume);
        return "resume";
    }
}
