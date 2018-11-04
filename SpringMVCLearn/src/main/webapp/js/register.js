function checkName()
{
	var name=document.getElementById("name_input").value.trim();
	if (name=="")
	{
		document.getElementById("name_span").style.display="inline";
		document.getElementById("name_span").innerHTML="用户名为空"
		return false;
	}
	else
	{
		document.getElementById("name_span").style.display="none";
		return true;
	}
}
function checkNick()
{
	var nick=document.getElementById("nick_input").value.trim();
	if (nick=="")
	{
		document.getElementById("nick_span").style.display="inline";
		document.getElementById("nick_span").innerHTML="昵称为空"
		return false;
	}
	else
	{
		document.getElementById("nick_span").style.display="none";
		return true;
	}
}
function checkPass()
{
	var reg=/^[0-9]*$/;
	var pass=document.getElementById("pass_input").value.trim();
	var check=document.getElementById("pass_check").value.trim();
	if(check!=""&&check!=pass)
	{
		document.getElementById("check_span").style.display="inline";
		document.getElementById("check_span").innerHTML="两次输入不相同";
	}
	else
	{
		document.getElementById("check_span").style.display="none";
	}
	if (pass=="")
	{
		document.getElementById("pass_span").style.display="inline";
		document.getElementById("pass_span").innerHTML="密码为空";
		return false;
	}
	else if(pass.length<8)
	{
		document.getElementById("pass_span").style.display="inline";
		document.getElementById("pass_span").innerHTML="密码长度太短";
		return false;
	}
	else if(reg.test(pass)==true)
	{
		document.getElementById("pass_span").style.display="inline";
		document.getElementById("pass_span").innerHTML="密码过于简单";
		return false;
	}
	else
	{
		document.getElementById("pass_span").style.display="none";
		return true;
	}
}
function checkCheck()
{
	var pass=document.getElementById("pass_input").value;
	var check=document.getElementById("pass_check").value;
	if(pass!=check)
	{
		document.getElementById("check_span").style.display="inline";
		document.getElementById("check_span").innerHTML="两次输入不相同";s
		return false;
	}
	else
	{
		document.getElementById("check_span").style.display="none";
		return true;
	}
}

function checkInfo()
{
	var bool=checkName()&&checkPass()&&checkCheck()&&checkNick();
	
	if(bool==true)
		return true;
	else
		return false;
}


