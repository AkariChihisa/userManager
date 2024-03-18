package com.ch.ch6_6.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ch.ch6_6.entity.MyUser;
import com.ch.ch6_6.service.MyUserService;
@Controller
public class MyUserController {
	@Autowired
	private MyUserService myUserService;	
	
	@GetMapping("/")
    public String list(Model model) {
		List<MyUser> list=myUserService.findAll();
        model.addAttribute("users", list);
        return "user/userList";
    }
	
	//添加用户
	@GetMapping("/toAdd")
    public String toAdd(Model model) {
		model.addAttribute("userbean", new MyUser());
        return "user/userAdd";
    }

	@PostMapping("/addUser")//@RequestMapping("/findUserById")
	public String saveUser(@ModelAttribute("userbean") MyUser userbean) {
		 int i=myUserService.saveUser(userbean);
		 if(i>=1)
		 return "redirect:/";
		 else			 
		 return "error";
	}

	//删除用户
	@GetMapping("/deleteUser")
	public String deleteUser(Integer id) {
		int i=myUserService.deleteUser(id);
		if(i>=1)
		return "redirect:/";
	    else
		return "error";

	}
		
	//修改user数据
    @GetMapping("/toEdit")
    public String toEdit(Model model, Integer id) {
    	MyUser user = myUserService.findUserById(id);
        model.addAttribute("userbean", user);
        return "user/userEdit";
    }

    @PostMapping("/editUser")
    public String edit(@ModelAttribute("userbean") MyUser  userbean) {
    	int i=myUserService.updateUser(userbean);
    	if(i>=1)
    	return "redirect:/";
    	else			 
        return "error";
    }
    
    //查询所有用户    
	@GetMapping("/findAll")
	public String findAll(Model model){
		List<MyUser> list=myUserService.findAll();
		model.addAttribute("users", list);
		return "user/userList";
	}
	
   //查询编号为id的用户
	@PostMapping("/findUserById")
	public String findUserById(Model model,Integer id) {
		MyUser user= myUserService.findUserById(id);
		model.addAttribute("userdisplay",user);
		return "user/userDisplay";
	}
	
	
	
	
	
	
}
