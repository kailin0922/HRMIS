package com.xkl.controller;

import com.xkl.model.ApplyRecruitment;
import com.xkl.model.Department;
import com.xkl.model.Position;
import com.xkl.model.Recruitment;
import com.xkl.service.ManageService;
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
     @RequestMapping(value = "toManageView")
    public String toManageView() throws Exception{
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
    @RequestMapping(value = "toApplyInfo")
    public String toApplyInfo(HttpSession session) throws Exception{
       List<ApplyRecruitment> allApplyRecords=manageService.allApplyRecords();
        session.setAttribute("allApplyRecords",allApplyRecords);
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

        List<Recruitment> recruitments=manageService.allRecruitmentInfo();
        session.setAttribute("recruitments",recruitments);
        return "manageJobInfo";
    }
}
