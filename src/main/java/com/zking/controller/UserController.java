package com.zking.controller;

import com.zking.model.User;
import com.zking.service.IUserService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;


    @RequestMapping("userList")
    @RequiresRoles("管理员")
    public String list(HttpSession session){
        //查询用户信息
        List<User> users = userService.list();
        session.setAttribute("users",users);
        return "userList";
    }

    @RequestMapping("addUser")
//    @RequiresRoles("书本新增")
    public String addUser(User user){
        int n = userService.insert(user);
        return null;
    }


}
