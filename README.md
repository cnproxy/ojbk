# 接口说明 [![Build Status](https://travis-ci.org/cnproxy/ojbk.svg?branch=master)](https://travis-ci.org/cnproxy/ojbk)

* 用户注册  
  POST https://sw.tomaer.com/api/user/register  
  Body: `{"username":"" ,"password":"" ,"invitationCode":""}`  
  Return: 200  

* 获取token  
  POST https://sw.tomaer.com/api/user/token  
  Body: `{"username":"" ,"password":""}`  
  Return: `{"token": ""}`  

* 获取用户身份  
  GET https://sw.tomaer.com/api/sec/user/identity  
  Headers: Authorization {{token}} `token`为`AccessToken`返回的的结果  
  Return: `{"identity": ["ROLE_ADMIN","ROLE_USER"]}`  
  
* 获取个人信息  
  GET https://sw.tomaer.com/api/sec/user  
  Headers: Authorization {{token}} `token`为`AccessToken`返回的的结果
  
* 获取我的邀请码  
  GET https://sw.tomaer.com/api/sec/user/invitationcodes      
  Headers: Authorization {{token}} `token`为`AccessToken`返回的的结果  
  Return: `[{"id": 1 ,"code": "21b8522a-9832-4713-b5b6-8d9e740c8d8f" ,"used": false}]`  

* 管理员获取过期列表  
  GET https://sw.tomaer.com/api/sec/expired/ranking  
  Headers: Authorization {{token}} `token`为`AccessToken`返回的的结果  

* 管理员给用户发放邀请码  
  POST https://sw.tomaer.com/api/sec/invitationcode/assign  
  Headers: Authorization {{token}} `token`为`AccessToken`返回的的结果  
  Body: `{"userId": 1}`  
  Return: `{"id": 1 ,"code": "21b8522a-9832-4713-b5b6-8d9e740c8d8f" ,"used": false}`
  
* 管理员获取所有邀请码  
  GET https://sw.tomaer.com/api/sec/invitationcodes      
  Headers: Authorization {{token}} `token`为`AccessToken`返回的的结果  
  Return: `[{"id": 1 ,"code": "21b8522a-9832-4713-b5b6-8d9e740c8d8f" ,"used": false}]`  