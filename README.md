# 接口说明 [![Build Status](https://travis-ci.org/cnproxy/ojbk.svg?branch=master)](https://travis-ci.org/cnproxy/ojbk)

* 获取token  
  POST https://sw.tomaer.com/api/token/access  
  请求参数 `{"username":"","password":""}`  
  返回 `{"token": ""}`  

* 我的个人信息  
  GET https://sw.tomaer.com/api/sec/user  
  Headers: Authorization {{token}} `token`为`AccessToken`返回的的结果

* 管理员获取过期列表  
  GET https://sw.tomaer.com/api/sec/expired/ranking  
  Headers: Authorization {{token}} `token`为`AccessToken`返回的的结果  

