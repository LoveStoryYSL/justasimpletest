package com.xtu.liuli.model;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.xtu.liuli.util.PasswordUtil;
@Entity
@Table(name="t_user")
public class User
{
	private String name;
	private String nick;
	private String password;
	private String salt;
	@Id
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString()
	{
		return "Name:"+name+"    Nick:"+nick+"    Password:"+password+"    salt:"+salt;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	
	public void encrypePassword()
	{
		password=PasswordUtil.getMd5String(password);
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public void addSalt()
	{
		this.setSalt(PasswordUtil.getSalt());
	}
}
