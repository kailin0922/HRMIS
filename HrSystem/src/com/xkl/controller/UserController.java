package com.xkl.controller;

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
import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    @RequestMapping(value = "/userToEmployeeInfo",method = RequestMethod.GET)
    public String  userToEmployeeInfo(HttpSession session) throws Exception{;
        User user= (User) session.getAttribute("user");
        Resume resume=userService.getResume(user);
        Employee employee=new Employee();
        employee.setResumeId(resume.getId());
        Employee employee1=userService.searchEmployeeByResumeId(employee);
        session.setAttribute("employee",employee1);
        return "userToEmployee";
    }

    @RequestMapping(value = "/agreeInterView",method = RequestMethod.GET)
    public String  agreeInterView(ApplyRecruitment applyRecruitment,HttpSession session) throws Exception{
       applyRecruitment.setUserstate(2);
       applyRecruitment.setState(4);
       boolean b=manageService.updateApplyRecruuitment(applyRecruitment);
        User user= (User) session.getAttribute("user");
        List<ApplyRecruitment> applyRecruitments=userService.allApplyRecords(user);
        session.setAttribute("applyrecords",applyRecruitments);
        List<Recruitment> recruitments=manageService.allRecruitmentInfo();
        List<Department> departments=manageService.allDepartmentInfo();
        session.setAttribute("recruitments",recruitments);
        session.setAttribute("departments",departments);

        /*把该招聘信息填入职位表,同时生成员工表*/
        ApplyRecruitment applyRecruitment1=userService.searchApplyRecruitmentById(applyRecruitment);
        Employee employee=new Employee();
        Position position=new Position();
        Recruitment recruitment=new Recruitment();
        recruitment.setId(applyRecruitment1.getRecruid());
        /*找到该招聘职位信息*/
        Recruitment recruitment1=userService.searchRecruitmentById(recruitment);

        position.setName(recruitment1.getName());
        position.setDeptid(recruitment1.getDeptid());
        position.setBasicsalary(recruitment1.getSalary());
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String createtime=simpleDateFormat.format(date);
        position.setCreatetime(createtime);
        Position position1=manageService.searchPosition(position);
        if(position1!=null){
             /*   已经有该职位，直接添加员工*/
            Resume resume=new Resume();
            resume.setUid(user.getId());
            Resume resume1=manageService.searchResumeByUid(resume);
            employee.setName(resume1.getName());
            employee.setPass("000");/*初始密码000*/
            employee.setAge(resume1.getAge());
            employee.setSex(resume1.getSex());
            employee.setTel(resume1.getTel());
            employee.setAddress(resume1.getAddress());
            employee.setDepartmentId(recruitment1.getDeptid());
            employee.setPositionId(position1.getId());
            employee.setResumeId(resume1.getId());
            employee.setState(1);/*(默认在职)*/
            employee.setBasicsalary(position1.getBasicsalary());
            employee.setWorkstarttime("上班");
            employee.setWorkendtime("下班");

            /*判定该用户是否已经有工作，即员工表中有没有次员工，通过简历Id  resumeId判断*/
            Employee employee2=manageService.searchEmployeeByResumeId(employee);
            if(employee2!=null){
                applyRecruitment.setState(5);
                session.setAttribute("employee",employee2);
                manageService.updateApplyRecruuitment(applyRecruitment);
                return "interViewError";
            }else{
                boolean b1=manageService.addEmployee(employee);
                Employee employee1=manageService.getEmployee(employee);
                session.setAttribute("employee",employee1);
                return "applyrecord";
            }
        }
        /*m没有该职位，先添加职位，判定员工有没有工作，在添加员工*/
            boolean b1=manageService.addPosition(position);//添加职位
            Resume resume=new Resume();
            resume.setUid(user.getId());
            Resume resume1=manageService.searchResumeByUid(resume);
            employee.setName(resume1.getName());
            employee.setPass("000");/*初始密码000*/
            employee.setAge(resume1.getAge());
            employee.setSex(resume1.getSex());
            employee.setTel(resume1.getTel());
            employee.setAddress(resume1.getAddress());
            employee.setDepartmentId(recruitment1.getDeptid());
            employee.setPositionId(position1.getId());
            employee.setResumeId(resume1.getId());
            employee.setState(1);/*(默认在职)*/
            employee.setBasicsalary(position1.getBasicsalary());
            employee.setWorkstarttime("上班");
            employee.setWorkendtime("下班");
             Employee employee2=manageService.searchEmployeeByResumeId(employee);
        if(employee2!=null){
            applyRecruitment.setState(5);
            manageService.updateApplyRecruuitment(applyRecruitment);
            session.setAttribute("employee",employee2);
            return "interViewError";
        }else {
            boolean b2=manageService.addEmployee(employee);
            Employee employee1=manageService.getEmployee(employee);
            session.setAttribute("employee",employee1);
            return "applyrecord";
        }

    }
    @RequestMapping(value = "/refuseInterView",method = RequestMethod.GET)
    public String  refuseInterView(ApplyRecruitment applyRecruitment,HttpSession session) throws Exception{
        applyRecruitment.setUserstate(1);
        applyRecruitment.setState(5);
        boolean b=manageService.updateApplyRecruuitment(applyRecruitment);

        User user= (User) session.getAttribute("user");
        List<ApplyRecruitment> applyRecruitments=userService.allApplyRecords(user);
        session.setAttribute("applyrecords",applyRecruitments);
        List<Recruitment> recruitments=manageService.allRecruitmentInfo();
        List<Department> departments=manageService.allDepartmentInfo();
        session.setAttribute("recruitments",recruitments);
        session.setAttribute("departments",departments);

        return"applyrecord";
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
        applyRecruitment.setUserstate(0);
        /*在service判断该职位是否已经申请过*/
        boolean b=userService.addApplyrecruitment(applyRecruitment);
        if(b==true){
            return "userJobInfo";
        }
        return "applyerror";
    }
}
