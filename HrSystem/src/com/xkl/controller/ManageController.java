package com.xkl.controller;

import com.xkl.model.*;
import com.xkl.service.ManageService;
import com.xkl.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by xkl on 2018/1/27.
 */@Controller
public class ManageController {
     @Resource
     private ManageService manageService;
     @Resource
     private UserService userService;
     @RequestMapping(value = "toManageView")
    public String toManageView() throws Exception{
         return "manageLogin";
     }
    @RequestMapping(value = "/refuseApply",method = RequestMethod.GET)
    public String refuseApply(HttpServletRequest request,HttpSession session) throws Exception{
        int id= Integer.parseInt(request.getParameter("id"));
        ApplyRecruitment applyRecruitment=new ApplyRecruitment();
        applyRecruitment.setId(id);
        applyRecruitment.setState(2);
        boolean b=manageService.updateApplyRecruuitment(applyRecruitment);

         return "manageLogin";
    }

    @RequestMapping(value = "manageLogin",method = RequestMethod.POST)
    public String manageLogin(HttpServletRequest request, HttpSession session) throws Exception{
        String name=request.getParameter("manageName");
        String pass=request.getParameter("managePass");
        if(name.equals("a")&&pass.equals("123")){
            return "aManageView";
        }
        return "manageLogin";
    }
    @RequestMapping(value = "toManageJobInfo")
    public String publishJobInfo(HttpSession session) throws Exception{
        List<Recruitment> recruitments=manageService.allRecruitmentInfo();
        List<Department> departments=manageService.allDepartmentInfo();
        session.setAttribute("recruitments",recruitments);
        session.setAttribute("departments",departments);
         return "manageJobInfo";
    }
    @RequestMapping(value = "/manageLookResume",method = RequestMethod.GET)
    public String toLookResume(HttpServletRequest request,HttpSession session) throws Exception{
        int uid= Integer.parseInt(request.getParameter("uid"));
        int id=Integer.parseInt(request.getParameter("id"));
        session.setAttribute("applyreruitmentid",id);
        ApplyRecruitment applyRecruitment=new ApplyRecruitment();
        applyRecruitment.setId(id);
        applyRecruitment.setState(1);
        boolean b=manageService.updateApplyRecruuitment(applyRecruitment);
        User user=new User();
        user.setId(uid);
        Resume resume=userService.getResume(user);
        session.setAttribute("resume",resume);
        return "manageLookResume";
    }
    @RequestMapping(value = "toApplyInfo")
    public String toApplyInfo(HttpSession session) throws Exception{
        /*把state状态改为1*/
        List<ApplyRecruitment> allApplyRecords=manageService.allApplyRecords();
        session.setAttribute("allApplyRecords",allApplyRecords);
        List<User> users=manageService.allUsers();
        session.setAttribute("users",users);
        List<Recruitment> recruitments=manageService.allRecruitmentInfo();
        List<Department> departments=manageService.allDepartmentInfo();
        session.setAttribute("recruitments",recruitments);
        session.setAttribute("departments",departments);
        return "applyInfo";
    }
    @RequestMapping(value = "/addRecru")
    public String addRecru(HttpServletRequest request,HttpSession session) throws Exception{

        String name=request.getParameter("name");
        int deptid=Integer.parseInt(request.getParameter("deptid"));
        int peoplenumber=Integer.parseInt(request.getParameter("peoplenumber"));
        String requirement=request.getParameter("requirement");
        Double salary=Double.parseDouble(request.getParameter("salary"));
        String workspace=request.getParameter("workplace");
      /*  Date date =new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time=simpleDateFormat.format(date);
        position.setCreatetime(time);*/

        /*添加简历表recruitment*/
        Recruitment recruitment=new Recruitment();
        recruitment.setName(name);
        recruitment.setDeptid(deptid);
        recruitment.setPeoplenumber(peoplenumber);
        recruitment.setRequirement(requirement);
        recruitment.setSalary(salary);
        recruitment.setWorkplace(workspace);
        boolean b1=manageService.addRecruitment(recruitment);

        List<Recruitment> recruitments=manageService.allRecruitmentInfo();
        session.setAttribute("recruitments",recruitments);
        return "manageJobInfo";
    }
    @RequestMapping(value = "/deleteRecru")
    public String deleteRecru(HttpServletRequest request,HttpSession session) throws Exception{
        int recruid=Integer.parseInt(request.getParameter("recruid"));
        Recruitment recruitment=new Recruitment();
        recruitment.setId(recruid);
        boolean b1=manageService.deleteRecruitment(recruitment);


        /*这里删除招聘信息，若已经有申请（applyrecruitment）,需要向申请人发送信息*/




        List<Recruitment> recruitments=manageService.allRecruitmentInfo();
        session.setAttribute("recruitments",recruitments);
        return "manageJobInfo";
    }
}
