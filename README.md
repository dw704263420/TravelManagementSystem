# TravelManagementSystem

#### 介绍
基于开源前端页面，使用SSM框架+mysql搭建后台的一个旅游管理系统项目，是自己巩固后端技术栈的一个学习项目。项目名称有点奇怪，是因为当时似乎环境出了点问题，便基于一个学习过的项目进行二次开发，该名称为学习springMVC框架时所取。
请克隆最新的项目，即SpringMVC,该项目下的子项目springMVC-05-json就是项目主体，部署时请使用该artifacts进行打包部署，详细部署可以看下面

#### 软件架构
软件架构说明

└─WEB-INF

├─classes

│  ├─com

│  │  └─kuang

│  │      ├─controller

│  │      ├─dao

│  │      ├─filter

│  │      ├─pojo

│  │      ├─service

│  │      │  └─impl

│  │      └─utils

│  └─META-INF

└─lib

#### 安装教程

1.  在本地Mysql数据库执行sql文件，sql文件处于springmvc-05-json内
2.  启动mysql和redis，并且保证网络处于联网状态（邮件验证需要网络）
3.  加载pom文件加载项目【父依赖和子依赖都需要加载，建议使用IDEA打开该项目】
4.  进行tomcat配置如下，其中URL地址改成如下http://localhost:8080/springmvc_05_json_war_exploded/
![输入图片说明](https://images.gitee.com/uploads/images/2021/0503/110103_e79ab5ea_7810509.png "屏幕截图.png")
![输入图片说明](https://images.gitee.com/uploads/images/2021/0503/110121_96751b20_7810509.png "屏幕截图.png")
![输入图片说明](https://images.gitee.com/uploads/images/2021/0503/110144_56e40383_7810509.png "屏幕截图.png")
5.  点击启动即可启动该项目

#### 使用说明

1.  因还在学习阶段，该项目或尚存在许多逻辑漏洞，望谅解
2.  因技术水平与时间限制，该项目尚存些许功能未完善，请谅解。
3.  在首页url后追加 admin 即可发生请求进入后台管理页面(http://localhost:8080/springmvc_05_json_war_exploded/admin)，超级管理员可管理所有内容，普通管理员只能管理部分产品和订单内容。
4.  后台超级管理员账号：dw 密码：123  后台普通管理员账号（admin 密码admin）


#### 参与贡献

1.  Fork 本仓库
2.  新建 Feat_xxx 分支
3.  提交代码
4.  新建 Pull Request

