package com.xtu.liuli.controller;



import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;

import com.xtu.liuli.dto.UserDTO;
import com.xtu.liuli.model.User;
import com.xtu.liuli.util.PasswordUtil;

@Controller("userController")
public class UserController 
{
	MultipartResolver mr=null;
	
	@RequestMapping("user/regist")
	public String userRegist( @RequestParam("name")String name, @RequestParam("password")String password,String nick)//名字相同时可以省略
	{
		System.out.println(name);
		System.out.println(nick);
		System.out.println(password);
		return "failed";
	}
	@RequestMapping("user/page")
	public String userPage(@RequestParam(defaultValue="0",value="pageSize") int pageSize,@RequestParam(defaultValue="0",value="pageNum")int pageNum)
	{
		System.out.println(pageSize+"   "+pageNum);
		return "failed";
	}
	@RequestMapping("user/test")
	public String userTest(UserDTO dto)
	{
		User[] user=dto.getUser();
		for(User u : user)
			System.out.println(u);
		return "failed";
	}
	@RequestMapping(value="demo12")
	@ResponseBody
	public User demo12()
	{
		User user=new User();
		user.setName("中文");
		user.setNick("乱码");
		user.setPassword("12345678");
		user.addSalt();
		user.encrypePassword();
		return user;
	}
	@RequestMapping("upload")
	public String upload(MultipartFile file) throws IOException
	{
		System.out.println("************"+file.getOriginalFilename()+"************");
		String fileName=file.getOriginalFilename();
		String suffix=fileName.substring(fileName.lastIndexOf(".")); 
		String uuid=UUID.randomUUID().toString();
		FileUtils.copyInputStreamToFile(file.getInputStream(), new File("E:/files/"+uuid+suffix));
		return "failed";
	}
	@RequestMapping("login")
	public String login(String username,String password,HttpServletRequest request)
	{
		if(username.equals("admin")&&password.equals("root"))
		{
			User user=new User();
			user.setName(username);
			user.setNick("");
			user.setPassword(password);
			user.setSalt(PasswordUtil.getSalt());
			user.encrypePassword();
			request.getSession().setAttribute("user",user);
			System.out.println("登录成功");
			return "forward:/WEB-INF/main/main.jsp";
		}
		else
		{
			System.out.println("登录失败");
			request.setAttribute("errorMessage","用户名或密码错误");
			return "login";
		}
	}
	
}
