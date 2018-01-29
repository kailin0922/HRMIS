package com.xkl.controller;

import com.sun.org.apache.regexp.internal.RE;
import com.xkl.model.*;
import com.xkl.service.ManageService;
import com.xkl.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by xkl on 2018/1/25.
 */
@Controller
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private ManageService manageService;
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
           Resume resume=userService.getResume(user1);
           if(resume==null){
               session.setAttribute("resumeState",0);
           }else {
               session.setAttribute("resumeState",1);
           }
           session.setAttribute("resume",resume);
           response.getWriter().print("ok");
       }else {
           response.getWriter().print("sorry");
       }
    }
    @RequestMapping(value ="/jobInfo",method = RequestMethod.GET)
    //这里与管理员发布的招聘信息配对
    public String jobInfo(HttpSession session) throws Exception{
        List<Recruitment> recruitments=manageService.allRecruitmentInfo();
        List<Department> departments=manageService.allDepartmentInfo();
        session.setAttribute("recruitments",recruitments);
        session.setAttribute("departments",departments);
        return "userJobInfo";
    }
    @RequestMapping(value ="/toApplyRecord",method = RequestMethod.GET)
    public String  toApplyRecord(HttpSession session) throws Exception{
        User user= (User) session.getAttribute("user");
        List<ApplyRecruitment> applyRecruitments=userService.allApplyRecords(user);
        session.setAttribute("applyrecords",applyRecruitments);
        List<Recruitment> recruitments=manageService.allRecruitmentInfo();
        List<Department> departments=manageService.allDepartmentInfo();
        session.setAttribute("recruitments",recruitments);
        session.setAttribute("departments",departments);
        return "applyrecord";
    }

    @RequestMapping(value = "/toResume",method = RequestMethod.GET)
    public String toResume() throws Exception{
        return "resume";
    }
    @RequestMapping(value = "/createResume",method = RequestMethod.POST)
    public String createResume(Resume resume, HttpSession session) throws Exception{
        boolean b=userService.addResume(resume);
        session.setAttribute("resume",resume);
        session.setAttribute("resumeState",1);
        return "resume";
        }
    @RequestMapping(value = "/updateResume",method = RequestMethod.POST)
    public String updateResume(Resume resume, HttpSession session) throws Exception{
        boolean b=userService.updateResume(resume);
        session.setAttribute("resume",resume);
        return "resume";
    }
    @RequestMapping(value = "/applyRecru",method = RequestMethod.POST)
    public String applyRecru(HttpServletRequest request,HttpSession session) throws Exception{
        Resume resume= (Resume) session.getAttribute("resume");
        int id= Integer.parseInt(request.getParameter("recruid"));
        ApplyRecruitment applyRecruitment=new ApplyRecruitment();
        applyRecruitment.setState(0);
        applyRecruitment.setUid(resume.getUid());
        applyRecruitment.setRecruid(id);
        boolean b=userService.addApplyrecruitment(applyRecruitment);
        return "userJobInfo";
    }
}
