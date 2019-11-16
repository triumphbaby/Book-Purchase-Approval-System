# 接口文档

## 权限说明：

本系统有四个角色：管理员，教务干事，课程负责人，教研室主任。

默认管理员拥有全部权限，只有管理员拥有删除权限。



大致权限说明：

* 管理员：
  	全部权利

* 教务干事：
  	只有/schedule 导入excel表的权限

* 课程负责人：
  	课程用书(subject) 书(book)  课程(course)   教材等级(level) 
    	add query update

* 教研室主任：

  ​	导出doc

  ​	教研处(laboratory)  开课教室单位(teaching_unit)  教务处(dean_office)  审批表(approval)
  ​	add query update

  ​	课程用书(subject)  书(book)  教材等级(level) 课程(courese)
  ​    query

**具体看下面目录url**

## 目录：

#### 一、学期
[1、查询所有学期信息](#1查询所有学期信息)<br/>
[2、查询学期单条记录](#2查询学期单条记录)<br/>
[3、添加学期记录](#3添加学期记录)<br/>
[4、更新学期记录](#4更新学期记录)<br/>
[5、删除学期记录](#5删除学期记录)<br/>

#### 二、开课教学单位审核
[6、分页获取开课教学单位审核条目](#6分页获取开课教学单位审核条目)<br/>
[7、获取单条审核条目记录](#7获取单条审核条目记录)<br/>
[8、添加开课教学单位审核结果](#8添加开课教学单位审核结果)<br/>
[9、获取科研室审核结果](#9获取科研室审核结果)<br/>
[10、添加审核条目](#10添加审核条目)<br/>
[11、更新条目信息](#11更新条目信息)<br/>
[12、删除条目信息](#12更新条目信息)<br/>

#### 三、课程
[13、查询所有课程信息](#13查询所有课程信息)<br/>
[14、查询单条记录](#14查询单条记录)<br/>
[15、添加](#15添加)<br/>
[16、更新](#16更新)<br/>
[17、删除](#17删除)<br/>

#### 四、课程用书
[18、查询所有课程用书信息](#18查询所有课程用书信息)<br/>
[19、查询单条记录](#19查询单条记录)<br/>
[20、添加](#20添加)<br/>
[21、更新](#21更新)<br/>
[22、删除](#22删除)<br/>
#### 五、书本
[23、查询所有书本记录](#23查询所有书本记录)<br/>
[24、查询单条记录](#24查询单条记录)<br/>
[25、添加书本记录](#25添加书本记录)<br/>
[26、更新](#26更新)<br/>
[27、删除](#27删除)<br/>
#### 六、教务处审核
[28、分页获取教务处审核条目](#28分页获取教务处审核条目)<br/>
[29、获取单条审核条目记录](#29获取单条审核条目记录)<br/>
[30、获取科研室审核结果](#30获取科研室审核结果)<br/>
[31、添加审核条目](#31添加审核条目)<br/>
[32、添加教务处审核结果](#32添加教务处审核结果)<br/>
[33、更新条目信息](#33更新条目信息)<br/>
[34、删除条目](#34删除条目)<br/>

#### 七、学院
[35、分页查询学院列表](#35分页查询学院列表)<br/>
[36、通过编号查询学院](#36通过编号查询学院)<br/>
[37、注册学院](#37注册学院)<br/>
[38、修改学院信息](#38修改学院信息)<br/>
[39、删除学院](#39删除学院)<br/>
#### 八、教研室审核
[40、分页获取教研室审核条目](#40分页获取教研室审核条目)<br/>
[41、获取单条审核条目记录](#41获取单条审核条目记录)<br/>
[42、获取科研室审核结果](#42获取科研室审核结果)<br/>
[43、添加审核条目](#43添加审核条目)<br/>
[44、添加教研室审核结果](#44添加教研室审核结果)<br/>
[45、更新条目信息](#45更新条目信息)<br/>
[46、删除条目](#46删除条目)<br/>

#### 九、书本等级
[47、分页查询等级记录](#47注册学院)<br/>
[48、通过id获取单条记录](#48注册学院)<br/>
[49、添加](#49注册学院)<br/>
[50、修改](#50修改)<br/>
[51、删除](#51删除)<br/>
#### 十、专业
[52、分页查询专业记录](#52分页查询专业记录)<br/>
[53、查询单条专业记录](#53查询单条专业记录)<br/>
[54、添加专业](#54添加专业)<br/>
[55、更新记录](#55更新记录)<br/>
[56、删除专业](#56删除专业)<br/>

#### 十一、角色
[57、查询所有人员的角色信息](#57查询所有人员的角色信息)<br/>
[58、查询某个工号的所有角色信息](#58查询某个工号的所有角色信息)<br/>
[59、添加角色记录](#59添加角色记录)<br/>
[60、更新信息](#60更新信息)<br/>[61、删除角色](#61删除角色)<br/>

#### 十二、人员
[62、查询所有人员信息](#62查询所有人员信息)<br/>
[63、查询单条记录](#63查询单条记录)<br/>
[64、添加人员](#64添加人员)<br/>
[65、更新信息](#65更新信息)<br/>
[66、删除人员](#66删除人员)<br/>

#### 十三 、登陆

[67、登陆](#67登陆)<br/>

[68、退出登陆](#68退出登陆)<br/>

#### 十三 、文件 操作



[69、导出教材征订计划表l](#69导出教材征订计划表)<br/>

[70、导入教材征订计划表数据](#70导入教材征订计划表数据（添加course）)<br/>

[71、导出教材征订计划表](#71导出教材征订计划表)<br/>

[72、导入教材征订计划表](#72、导入教职工信息表数据（添加staff）)<br/>

### 1、查询所有学期信息

#### 角色：

~~~
管理员
~~~

#### 请求URL：
	http://localhost:8624/goushushenpixitong/term/list

#### 请求方式：
	GET

#### 参数类型：
	|参数		|是否必选    |类型    |说明
	|currentPage    |Y          |int     |当前页数
	|pageSize       |Y          |int     |每页显示的总记录数
#### 返回示例：

	{
	    "code": 200,
	    "success": true,
	    "message": "请求成功",
	    "data": [
	        {
	            "id": 1,
	            "name": "1949-1950第一学期",
	            "remarks": "test"
	        }
	    ]
	}

### 2、查询学期单条记录

#### 角色：

~~~
管理员
~~~

#### 请求URL：
	http://localhost:8624/goushushenpixitong/term

#### 请求方式：
	GET

#### 参数类型：
	|参数     |是否必选    |类型    |说明
	|id       |Y          |int     |学期ID
#### 返回示例：
	{
	    "code": 200,
	    "success": true,
	    "message": "请求成功",
	    "data": {
	        "id": 2,
	        "name": "2015-2016第一学期",
	        "remarks": ""
	    }
	}

### 3、添加学期记录

#### 角色：

~~~
管理员
~~~

#### 请求URL：
	http://localhost:8624/goushushenpixitong/term

#### 请求方式：
	POST

#### 参数类型：
	|参数     |是否必选  |类型     |说明|
	|id       |Y        |int      |学期ID|
	|name     |Y        |string   |学期名称|
	|remarks  |N        |string   |备注|
#### 返回示例：

	{
	    "code": 200,
	    "success": true,
	    "message": "请求成功",
	    "data": null
	}

### 4、更新学期记录

#### 角色：

~~~
管理员
~~~

#### 请求URL：
	http://localhost:8624/goushushenpixitong/term

#### 请求方式：
    PUT

#### 参数类型：query
	|参数     |是否必选  |类型     |说明|
	|id       |Y        |int      |学期ID|
	|name     |Y        |string   |学期名称|
	|remarks  |N        |string   |备注|
#### 返回示例：
	{
	    "code": 200,
	    "success": true,
	    "message": "请求成功",
	    "data": null
	}

### 5、删除学期记录

#### 角色：

~~~
管理员
~~~

#### 请求URL：
	http://localhost:8624/goushushenpixitong/term

#### 请求方式：
	DELETE	

#### 参数类型：
	|参数     |是否必选    |类型    |说明
	|id       |Y          |int     |学期ID   
#### 返回示例：

    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    }

### 6、分页获取开课教学单位审核条目

#### 角色：

~~~
管理员 教研室主任
~~~

#### 请求URL：
	http://localhost:8624/goushushenpixitong/teachingunit/list

#### 请求方式：
	GET

#### 参数类型:
	|参数	        |是否必选    |类型    |说明
	|currentPage    |Y          |int     |当前页数
	|pageSize       |Y          |int     |每页显示的总记录数
#### 返回示例：

    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": [
            {
                "id": 1,
                "content": "网络编程教材",
                "remarks": "麻烦尽快审批，急用"
            },
            {
                "id": 2,
                "content": "C  程序设计教材",
                "remarks": ""
            }
        ]
    }

### 7、获取单条审核条目记录

#### 角色：

~~~
管理员 教研室主任
~~~

#### 请求URL：
	http://localhost:8624/goushushenpixitong/teachingunit

#### 请求方式：
	GET

#### 参数类型:

	|参数     |是否必选   |类型     |说明
	|id       |Y         |int      |ID

#### 返回示例：
    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": {
            "id": 2,
            "content": "C  程序设计教材",
            "remarks": ""
        }
    }

### 8、添加开课教学单位审核结果

#### 请求URL：

	http://localhost:8624/goushushenpixitong/teachingunit/opinions

#### 请求方式：

	POST

#### 参数类型:

	|参数	       |是否必选 |类型     |说明
	|subjectId  |Y       |int      |ID
	|josnStr  	|Y		 |String   |
	json格式:
	[
	   {
	      "id":1,
	      "opinion":"yes"
	    },
	    {
	      "id":2,
	      "opinion":"yes"
	    },
	    {
	      "id":3,
	      "opinion":"yes"
	    }
	]

#### 返回示例：

    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    }

### 9、获取科研室审核结果



#### 请求URL：
	http://localhost:8624/goushushenpixitong/teachingunit/opinions

#### 请求方式：

	GET

#### 参数类型:

	|参数	       |是否必选 |类型     |说明
	|subjectId  |Y       |int      |ID

#### 返回示例：

    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": [
            {
                "id": 1,
                "opinion": "yes"
            },
            {
                "id": 2,
                "opinion": "yes"
            },
            {
                "id": 3,
                "opinion": "yes"
            },
            {
                "id": 4,
                "opinion": "yes"
            }
        ]
    }

### 10、添加审核条目

#### 角色：

~~~
管理员 教研室主任
~~~

#### 请求URL：
	http://localhost:8624/goushushenpixitong/teachingunit

#### 请求方式：
	POST
#### 参数类型:
	|参数       |是否必选 |类型     |说明
	|id         |Y       |int      |ID
	|content    |Y       |string   |内容
	|remarks    |N       |string   |备注

#### 返回示例：
    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    }

### 11、更新条目信息

#### 角色：

~~~
管理员 教研室主任
~~~

#### 请求URL：
    http://localhost:8624/goushushenpixitong/teachingunit

#### 请求方式：
    PUT

#### 参数类型:
    |参数	    |是否必选 |类型     |说明
    |id         |Y       |int      |ID
    |content    |Y       |string   |内容
    |remarks    |N       |string   |备注

#### 返回示例：
    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    }
### 12、删除条目信息

#### 角色：

~~~
管理员 
~~~

#### 请求URL：
    http://localhost:8624/goushushenpixitong/teachingunit

#### 请求方式：
    DELETE
#### 参数类型:
    |参数	    |是否必选 |类型     |说明
    |id         |Y       |int      |ID

#### 返回示例：
    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    }

### 13、查询所有课程信息

#### 角色：

~~~
管理员 课程负责人 教研室主任
~~~

#### 请求URL：
    http://localhost:8624/goushushenpixitong/course/list

#### 请求方式：
    GET

#### 参数类型:
	|参数		|是否必选    |类型    |说明
	|currentPage    |Y          |int     |当前页数
	|pageSize       |Y          |int     |每页显示的总记录数
#### 返回示例：

    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": [
            {
                "id": "1002",
                "termId": 1,
                "name": "游戏智能",
                "period": 48,
                "credit": 3,
                "usableRange": "数字媒体技术_14_1-2",
                "studentNum": 50,
                "teacherNum": 2,
                "principalId": "1001",
                "remarks": ""
            },
            {
                "id": "2",
                "termId": 1,
                "name": "人工智能机器人概论",
                "period": 48,
                "credit": 3,
                "usableRange": "人工智能_14_1-2",
                "studentNum": 48,
                "teacherNum": 1,
                "principalId": "1002",
                "remarks": ""
            }
        ]
    }

### 14、查询单条记录

#### 角色：

~~~
管理员 课程负责人 教研室主任
~~~

#### 请求URL：
    http://localhost:8624/goushushenpixitong/course

#### 请求方式：
    GET
#### 参数类型:
    |参数	    |是否必选  |类型     |说明
    |id         |Y        |int      |ID
    |termId     |Y        |int      |学期ID
#### 返回示例：
    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": {
            "id": "1002",
            "termId": 1,
            "name": "游戏智能",
            "period": 48,
            "credit": 3,
            "usableRange": "数字媒体技术_14_1-2",
            "studentNum": 50,
            "teacherNum": 2,
            "principalId": "1001",
            "remarks": ""
        }
    }

### 15、添加

#### 角色：

~~~
管理员 课程负责人 
~~~

#### 请求URL：
    http://localhost:8624/goushushenpixitong/course

#### 请求方式：
    POST
#### 参数类型:
    |参数	      |是否必选 |类型      |说明
    |id           |Y       |String    |课程编号
    |termId       |Y       |int       |学期编号
    |name         |Y       |String    |课程名称
    |period       |Y       |int       |学时
    |credit       |Y       |int       |学分
    |usableRange  |Y       |String    |使用年级及专业
    |studentNum   |Y       |int       |学生数量
    |teacherNum   |Y       |int       |老师领用量
    |principalId  |Y       |String    |负责人工号
    |remarks      |N       |String    |备注

#### 返回示例：
    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    } 

### 16、更新

#### 角色：

~~~
管理员 课程负责人 
~~~

#### 请求URL：
    http://localhost:8624/goushushenpixitong/course

#### 请求方式：
    PUT

#### 参数类型:
    |参数         |是否必选 |类型      |说明
    |id           |Y       |String    |课程编号
    |termId       |Y       |int       |学期编号
    |name         |Y       |String    |课程名称
    |period       |Y       |int       |学时
    |credit       |Y       |int       |学分
    |usableRange  |Y       |String    |使用年级及专业
    |studentNum   |Y       |int       |学生数量
    |teacherNum   |Y       |int       |老师领用量
    |principalId  |Y       |String    |负责人工号
    |remarks      |N       |String    |备注

#### 返回示例：
    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    } 
### 17、删除

#### 角色：

~~~
管理员
~~~

#### 请求URL：
    http://localhost:8624/goushushenpixitong/course

#### 请求方式：
    DELETE

#### 参数类型:
    |参数	    |是否必选 |类型     |说明
    |id         |Y       |int      |ID
#### 返回示例：

    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    } 
### 18、查询所有课程用书信息

#### 角色：

~~~
管理员 课程负责人 教研室主任
~~~



#### 请求URL：
    http://localhost:8624/goushushenpixitong/subject/list

#### 请求方式：
    GET

#### 参数类型:
	|参数		|是否必选    |类型    |说明
	|currentPage    |Y          |int     |当前页数
	|pageSize       |Y          |int     |每页显示的总记录数

#### 返回示例：
    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": [
            {
                "id": 1,
                "courseId": "2",
                "termId": 1,
                "bookId": "20180706",
                "remarks": "1"
            }
        ]
    }

### 19、查询单条记录

#### 角色：

~~~
管理员 课程负责人 教研室主任
~~~

#### 请求URL：
    http://localhost:8624/goushushenpixitong/subject

#### 请求方式：
    GET

#### 参数类型:
    |参数       |是否必选  |类型     |说明
    |id         |Y        |int      |学期ID
#### 返回示例：
    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": {
            "id": 1,
            "courseId": "2",
            "termId": 1,
            "bookId": "20180706",
            "remarks": "1"
        }
    }

### 20、添加

#### 角色：

~~~
管理员 课程负责人 
~~~

#### 请求URL：
    http://localhost:8624/goushushenpixitong/subject

#### 请求方式：
    POST

### 参数类型:
    |参数	      |是否必选 |类型      |说明
    |id           |Y       |int       |id
    |termId       |Y       |int       |学期编号
    |bookId       |Y       |String    |图书编号
    |courseId     |Y       |String    |课程编号
    |remarks      |N       |String    |备注

#### 返回示例：

    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    } 
### 21、更新

#### 角色：

~~~
管理员 课程负责人 
~~~

#### 请求URL：
    http://localhost:8624/goushushenpixitong/subject

#### 请求方式：
    PUT

### 参数类型:
     |参数	       |是否必选 |类型      |说明
     |id           |Y       |int       |id
     |termId       |Y       |int       |学期编号
     |bookId       |Y       |String    |图书编号
     |courseId     |Y       |String    |课程编号
     |remarks      |N       |String    |备注

#### 返回示例：
    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    } 
### 22、删除

#### 角色：

~~~
管理员 
~~~

#### 请求URL：
    http://localhost:8624/goushushenpixitong/subject

#### 请求方式：
    DELETE

### 参数类型:
    |参数	    |是否必选 |类型     |说明
    |id         |Y       |int      |ID

#### 返回示例：
    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
### 23、查询所有书本记录

#### 角色：

~~~
管理员 课程负责人 教研室主任
~~~

#### 请求URL：
    http://localhost:8624/goushushenpixitong/book/list

#### 请求方式：
    GET

### 参数类型:
 	|参数	        |是否必选    |类型    |说明

~~~
|currentPage    |Y          |int     |当前页数
|pageSize       |Y          |int     |每页显示的总记录数
~~~

#### 返回示例：
    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": [
            {
                "id": "20180706",
                "name": "Python编程入门",
                "author": "叶维忠",
                "publisher": "人民邮电出版社",
                "publishDate": "2014年7月",
                "edition": 2,
                "nation": "中国",
                "type": null,
                "purpose": 1,
                "levelId": 2,
                "price": 56,
                "renew": true,
                "remarks": "教材知识新颖"
            },
            {
                "id": "20191005",
                "name": "计算机算法设计与分析",
                "author": "王晓东",
                "publisher": "电子工业出版社",
                "publishDate": "2012年2月",
                "edition": 4,
                "nation": "中国",
                "type": null,
                "purpose": null,
                "levelId": 2,
                "price": 38,
                "renew": true,
                "remarks": "教材知识新颖"
            }
        ]
    }
### 24、查询单条记录

#### 角色：

~~~
管理员 课程负责人 教研室主任
~~~

#### 请求URL：
    http://localhost:8624/goushushenpixitong/book

#### 请求方式：
    GET

### 参数类型:
    |参数	    |是否必选 |类型        |说明
    |id         |Y       |string      |图书ID

#### 返回示例：
    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": {
            "id": "20180706",
            "name": "Python编程入门",
            "author": "叶维忠",
            "publisher": "人民邮电出版社",
            "publishDate": "2014年7月",
            "edition": 2,
            "nation": "中国",
            "type": null,
            "purpose": 1,
            "levelId": 2,
            "price": 56,
            "renew": true,
            "remarks": "教材知识新颖"
        }
    }
### 25、添加书本记录

#### 角色：

~~~
管理员 课程负责人 
~~~

#### 请求URL：
    http://localhost:8624/goushushenpixitong/book

#### 请求方式：
    POST

### 参数类型:
    |参数         |是否必选  |类型       |说明
    |id           |Y        |string     |图书编号
    |name         |Y        |string     |图书名字
    |author       |Y        |string     |作者
    |publisher    |Y        |string     |出版社
    |publishDate  |N        |string     |出版时间
    |edition      |Y        |int        |版次
    |nation       |N        |string     |所属国家
    |type         |N        |int    |类型
    |purpose      |N        |int        |用途
    |levelId      |Y        |int        |教材等级
    |price        |Y        |int        |价格
    |renew        |Y        |Boolean    |若教材版次更新，是否还需要征求意见
    |remarks      |N        |string      |备注

#### 返回示例：
    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    }
### 26、更新

#### 角色：

~~~
管理员 课程负责人 
~~~

#### 请求URL：
    http://localhost:8624/goushushenpixitong/book

#### 请求方式：
    PUT
### 参数类型:
    |参数	      |是否必选  |类型       |说明
    |id           |Y        |string     |图书编号
    |name         |Y        |string     |图书名字
    |author       |Y        |string     |作者
    |publisher    |Y        |string     |出版社
    |publishDate  |N        |string     |出版时间
    |edition      |Y        |int        |版次
    |nation       |N        |string     |所属国家
    |type         |N        |int        |类型
    |purpose      |N        |int        |用途
    |levelId      |Y        |int        |教材等级
    |price        |Y        |int        |价格
    |renew        |Y        |Boolean    |若教材版次更新，是否还需要征求意见
    |remarks      |N        |string      |备注
#### 返回示例：
    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    }
### 27、删除

#### 角色：

~~~
管理员 
~~~

#### 请求URL：
    http://localhost:8624/goushushenpixitong/book

#### 请求方式：
    DELETE

### 参数类型:
    |参数       |是否必选 |类型      |说明
    |id         |Y       |string    |图书ID

#### 返回示例：
    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    } 
### 28、分页获取教务处审核条目

#### 角色：

~~~
管理员 教研室主任
~~~

#### 请求URL：
    http://localhost:8624/goushushenpixitong/deanoffice/list

#### 请求方式：
    GET

### 参数类型:
 	|参数		|是否必选    |类型    |说明

~~~
|currentPage    |Y          |int     |当前页数
|pageSize       |Y          |int     |每页显示的总记录数
~~~

#### 返回示例：
    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": [
            {
                "id": 1,
                "content": "审核内容",
                "remarks": ""
            },
            {
                "id": 2,
                "content": "计算机网络教材审核",
                "remarks": ""
            }
        ]
    }

### 29、获取单条审核条目记录

#### 角色：

~~~
管理员 教研室主任
~~~

#### 请求URL：
    http://localhost:8624/goushushenpixitong/deanoffice

#### 请求方式：
    GET

### 参数类型:
    |参数	    |是否必选 |类型        |说明
    |id         |Y       |int         |ID

#### 返回示例：
    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": {
            "id": 2,
            "content": "计算机网络教材审核",
            "remarks": ""
        }
    }
### 30、获取科研室审核结果

#### 角色：

~~~
管理员 教研室主任
~~~

#### 请求URL：
    http://localhost:8624/goushushenpixitong/deanoffice/opinions

#### 请求方式：
    GET

### 参数类型:

    |参数	    	|是否必选 |类型        |说明
    |subjectId   |Y       |int         |ID

#### 返回示例：

    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": [
            {
                "id": 1,
                "opinion": "yes"
            },
            {
                "id": 2,
                "opinion": "yes"
            },
            {
                "id": 3,
                "opinion": "yes"
            },
            {
                "id": 4,
                "opinion": "yes"
            }
        ]
    }

   



### 31、添加审核条目

#### 角色：

~~~
管理员 教研室主任
~~~

#### 请求URL：
    http://localhost:8624/goushushenpixitong/deanoffice

#### 请求方式：
    POST

### 参数类型:
    |参数         |是否必选  |类型       |说明
    |id           |Y        |int        |ID
    |content      |Y        |string     |内容
    |remarks      |N        |string     |备注    
#### 返回示例：
    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    }
### 32、添加教务处审核结果

#### 请求URL：
    http://localhost:8624/goushushenpixitong/deanoffice/opinions

#### 请求方式：

	POST

#### 参数类型:

	|参数	       |是否必选 |类型     |说明
	|subjectId  |Y       |int      |ID
	|josnStr  	|Y		 |String   |
	json格式:
	[
	   {
	      "id":1,
	      "opinion":"yes"
	    },
	    {
	      "id":2,
	      "opinion":"yes"
	    },
	    {
	      "id":3,
	      "opinion":"yes"
	    }
	]

#### 返回示例：

    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    }

​    

### 33、更新条目信息

#### 角色

~~~
管理员  教研室主任
~~~

#### 请求URL：
    http://localhost:8624/goushushenpixitong/deanoffice

#### 请求方式：
    PUT

### 参数类型:
    |参数	      |是否必选  |类型       |说明
    |id           |Y        |int        |图书编号
    |content      |Y        |string     |内容
    |remarks      |N        |string     |备注
#### 返回示例：
    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    }
### 34、删除条目

#### 角色

~~~
管理员 
~~~

#### 请求URL：
    http://localhost:8624/goushushenpixitong/deanoffice

#### 请求方式：
    DELETE
### 参数类型:
    |参数	    |是否必选 |类型      |说明
    |id         |Y       |int       |图书ID

#### 返回示例：
    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    } 

### 35、分页查询学院列表

#### 角色：

~~~
管理员 
~~~

#### 请求URL：
    http://localhost:8624/goushushenpixitong/institute/list

#### 请求方式：
    GET
### 参数类型:
	|参数		|是否必选    |类型    |说明
	|currentPage    |Y          |int     |当前页数
	|pageSize       |Y          |int     |每页显示的总记录数

#### 返回示例：
    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": [
            {
                "id": "HK1011",
                "name": "航空学院",
                "remarks": ""
            },
            {
                "id": "JS001",
                "name": "计算机学院",
                "remarks": ""
            },
            {
                "id": "S10211",
                "name": "商学院",
                "remarks": ""
            }
        ]
    }
### 36、通过编号查询学院

#### 角色：

~~~
管理员 
~~~

#### 请求URL：
    http://localhost:8624/goushushenpixitong/institute

#### 请求方式：
    GET

### 参数类型:
    |参数	    |是否必选 |类型     |说明
    |id         |Y       |string      |ID

#### 返回示例：

    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": {
            "id": "YS1025",
            "name": "艺术学院",
            "remarks": ""
        }
    }

### 37、注册学院

#### 角色：

~~~
管理员 
~~~

#### 请求URL：
    http://localhost:8624/goushushenpixitong/institute

#### 请求方式：
    POST

### 参数类型:
    |参数	    |是否必选 |类型     |说明
    |id         |Y       |string   |ID
    |name       |Y       |string   |内容
    |remarks    |N       |string    |备注

#### 返回示例：

    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    }

### 38、修改学院信息：

#### 角色：

~~~
管理员 
~~~

#### 请求URL：
    http://localhost:8624/goushushenpixitong/institute

#### 请求方式：
    PUT

### 参数类型:
    |参数	    |是否必选 |类型     |说明
    |id         |Y       |string   |ID
    |name       |Y       |string   |内容
    |remarks    |N       |string    |备注

#### 返回示例：

    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    }

### 39、删除学院

#### 角色：

~~~
管理员 
~~~

#### 请求URL：
    http://localhost:8624/goushushenpixitong/institute

#### 请求方式：
    DELETE
### 参数类型:
    |参数	    |是否必选 |类型     |说明
    |id         |Y       |string   |ID

#### 返回示例：

    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    }

### 40、分页获取教研室审核条目

#### 角色：

~~~
管理员  教研室主任
~~~

#### 请求URL：
    http://localhost:8624/goushushenpixitong/laboratory/list

#### 请求方式：
    GET

### 参数类型:
	|参数		|是否必选    |类型    |说明
	|currentPage    |Y          |int     |当前页数
	|pageSize       |Y          |int     |每页显示的总记录数

#### 返回示例：
    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": [
            {
                "id": 1,
                "content": "pass",
                "remarks": ""
            },
            {
                "id": 2,
                "content": "pass",
                "remarks": ""
            }
        ]
    }

### 41、获取单条审核条目记录

#### 角色：

~~~
管理员   教研室主任
~~~

#### 请求URL：
    http://localhost:8624/goushushenpixitong/laboratory

#### 请求方式：
    GET

### 参数类型:
    |参数	    |是否必选 |类型     |说明
    |id         |Y       |int      |ID

#### 返回示例：

    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": {
            "id": 2,
            "content": "pass",
            "remarks": ""
        }
    }

### 42、获取科研室审核结果

#### 角色：

~~~
管理员 教研室主任
~~~

#### 请求URL：

    http://localhost:8624/goushushenpixitong/laboratory/opinions

#### 请求方式：

    GET

### 参数类型:

    |参数	    	|是否必选 |类型        |说明
    |subjectId   |Y       |int         |ID

#### 返回示例：

    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": [
            {
                "id": 1,
                "opinion": "yes"
            },
            {
                "id": 2,
                "opinion": "yes"
            },
            {
                "id": 3,
                "opinion": "yes"
            },
            {
                "id": 4,
                "opinion": "yes"
            }
        ]
    }

   



### 43、添加审核条目

#### 角色：

~~~
管理员   教研室主任
~~~

#### 请求URL：
    http://localhost:8624/goushushenpixitong/laboratory

#### 请求方式：
    POST

### 参数类型:
    |参数       |是否必选 |类型     |说明
    |id         |Y       |int      |ID
    |content    |Y       |string   |内容
    |remarks    |N       |string   |备注

#### 返回示例：
    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    }
### 44、添加教研室审核结果

#### 请求URL：

	http://localhost:8624/goushushenpixitong/laboratory/opinions

#### 请求方式：

	POST

#### 参数类型:

	|参数	       |是否必选 |类型     |说明
	|subjectId  |Y       |int      |ID
	|josnStr  	|Y		 |String   |
	json格式:
	[
	   {
	      "id":1,
	      "opinion":"yes"
	    },
	    {
	      "id":2,
	      "opinion":"yes"
	    },
	    {
	      "id":3,
	      "opinion":"yes"
	    }
	]

#### 返回示例：

    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    }  

### 45、更新条目信息

#### 角色：

~~~
管理员   教研室主任
~~~

#### 请求URL：
    http://localhost:8624/goushushenpixitong/laboratory

#### 请求方式：
    PUT

### 参数类型:
    |参数	    |是否必选 |类型     |说明
    |id         |Y       |int      |ID
    |content    |Y       |string   |内容
    |remarks    |N       |string   |备注

#### 返回示例：
    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    }

### 46、删除条目

#### 角色：

~~~
管理员   
~~~

#### 请求URL：
    http://localhost:8624/goushushenpixitong/laboratory

#### 请求方式：
    DELETE

### 参数类型:
    |参数	    |是否必选 |类型     |说明
    |id         |Y       |int      |ID 
#### 返回示例：

    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    }
### 47、分页查询等级记录

#### 角色：

~~~
管理员   教研室主任  课程负责人
~~~

#### 请求URL：
    http://localhost:8624/goushushenpixitong/level/list

#### 请求方式：
    GET

### 参数类型:
	|参数		|是否必选    |类型    |说明
	|currentPage    |Y          |int     |当前页数
	|pageSize       |Y          |int     |每页显示的总记录数
#### 返回示例：
    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": [
            {
                "id": 1,
                "name": "level01",
                "remarks": "test"
            },
            {
                "id": 2,
                "name": "国家级",
                "remarks": "教材知识新颖"
            }
        ]
    }

### 48、通过id获取单条记录

#### 角色：

~~~
管理员   教研室主任  课程负责人
~~~

#### 请求URL：
    http://localhost:8624/goushushenpixitong/level

#### 请求方式：
    GET

### 参数类型:
    |参数  	|是否必选   |类型      |说明
    |id     |Y         |int   |ID

#### 返回示例：
    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": {
            "id": 2,
            "name": "国家级",
            "remarks": "教材知识新颖"
        }
    }

### 49、添加等级

#### 角色：

~~~
管理员   课程负责人
~~~

#### 请求URL：
    http://localhost:8624/goushushenpixitong/level

#### 请求方式：
    POST

### 参数类型:
    |参数	      |是否必选 |类型      |说明
    |id           |Y       |int       |ID
    |name         |Y       |string    |内容
    |remarks      |N       |string    |备注

#### 返回示例：
    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    }

### 50、修改

#### 角色：

~~~
管理员   课程负责人
~~~

#### 请求URL：
    http://localhost:8624/goushushenpixitong/level

#### 请求方式：
    PUT

### 参数类型:
    |参数         |是否必选 |类型      |说明
    |id           |Y       |int       |ID
    |name         |Y       |string    |内容
    |remarks      |N       |string    |备注
#### 返回示例：
    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    }

### 51、删除

#### 角色：

~~~
管理员  
~~~

#### 请求URL：
    http://localhost:8624/goushushenpixitong/level

#### 请求方式：
    DELETE

### 参数类型:
    |参数       |是否必选   |类型     |说明
    |id         |Y         |int      |ID

#### 返回示例：
    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    }
### 52、分页查询专业记录

#### 角色：

~~~
管理员  
~~~

#### 请求URL：
    http://localhost:8624/goushushenpixitong/major/list

#### 请求方式：
    GET

### 参数类型:
	|参数		|是否必选    |类型    |说明
	|currentPage    |Y          |int     |当前页数
	|pageSize       |Y          |int     |每页显示的总记录数
#### 返回示例：
    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": [
            {
                "id": "SD001",
                "name": "电子商务",
                "instituteId": "S10211",
                "remarks": ""
            },
            {
                "id": "XXR001",
                "name": "人工智能",
                "instituteId": "HK1011",
                "remarks": ""
            }
        ]
    }

### 53、查询单条专业记录

#### 角色：

~~~
管理员  
~~~

#### 请求URL：
    http://localhost:8624/goushushenpixitong/major

#### 请求方式：
    GET

### 参数类型:
    |参数	    |是否必选   |类型      |说明
    |id         |Y         |string    |ID

#### 返回示例：
    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": {
            "id": "SD001",
            "name": "电子商务",
            "instituteId": "S10211",
            "remarks": ""
        }
    }

### 54、添加专业

#### 角色：

~~~
管理员  
~~~

#### 请求URL：
    http://localhost:8624/goushushenpixitong/major

#### 请求方式：
    POST

### 参数类型:
    |参数         |是否必选 |类型      |说明
    |id           |Y       |string    |ID
    |name         |Y       |string    |内容
    |instituteId  |Y       |string    |学院编号
    |remarks      |N       |string    |备注

#### 返回示例：
    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    }

### 55、更新记录

#### 角色：

~~~
管理员 
~~~

#### 请求URL：
    http://localhost:8624/goushushenpixitong/major

#### 请求方式：
    PUT

### 参数类型:
    |参数         |是否必选 |类型      |说明
    |id           |Y       |string    |ID
    |name         |Y       |string    |内容
    |instituteId  |Y       |string    |学院编号
    |remarks      |N       |string    |备注
#### 返回示例：
    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    }

### 56、删除专业

#### 角色：

~~~
管理员  
~~~

#### 请求URL：
    http://localhost:8624/goushushenpixitong/major

#### 请求方式：
    DELETE
### 参数类型:
    |参数       |是否必选   |类型     |说明
    |id         |Y         |string   |ID

#### 返回示例：
    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    }
### 57、查询所有人员的角色信息

#### 角色：

~~~
管理员  
~~~

#### 请求URL：
    http://localhost:8624/goushushenpixitong/role/list

#### 请求方式：
    GET

### 参数类型:
 	|参数		|是否必选    |类型    |说明

~~~
|currentPage    |Y          |int     |当前页数
|pageSize       |Y          |int     |每页显示的总记录数
~~~



#### 返回示例：

    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": [
            {
                "id": "1002",
                "type": 3,
                "remarks": ""
            },
            {
                "id": "1001",
                "type": 3,
                "remarks": ""
            }
        ]
    }
### 58、查询某个工号的所有角色信息

#### 角色：

~~~
管理员  
~~~

#### 请求URL：
    http://localhost:8624/goushushenpixitong/role

#### 请求方式：
    GET

### 参数类型:
    |参数	      |是否必选 |类型      |说明
    |id           |Y       |string    |ID
#### 返回示例：

    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": [
            {
                "id": "1002",
                "type": 3,
                "remarks": ""
            }
        ]
    }
### 59、添加角色记录

#### 角色：

~~~
管理员  
~~~

#### 请求URL：
    http://localhost:8624/goushushenpixitong/role

#### 请求方式：
    POST

### 参数类型:
    |参数	      |是否必选 |类型      |说明
    |id           |Y       |string    |ID
    |type         |Y       |int       |角色类型
    |remarks      |N       |string    |备注信息
#### 返回示例：

    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    }
### 60、更新角色信息

#### 角色：

~~~
管理员  
~~~

#### 请求URL：
    http://localhost:8624/goushushenpixitong/role

#### 请求方式：
    PUT

### 参数类型:
     |参数	       |是否必选 |类型      |说明
     |id           |Y       |string    |ID
     |type         |Y       |int       |角色类型
     |remarks      |N       |string    |备注信息
#### 返回示例：
    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    } 

​    

### 61、删除角色

#### 角色：

~~~
管理员  
~~~

#### 请求URL：

    http://localhost:8624/goushushenpixitong/role

#### 请求方式：

    DELETE

### 参数类型:

     |参数	       |是否必选 |类型      |说明
     |id           |Y       |string    |ID

#### 返回示例：

    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    }

​    



### 62、查询所有人员信息

#### 角色：

~~~
管理员  
~~~

#### 请求URL：
    http://localhost:8624/goushushenpixitong/staff/list

#### 请求方式：
    GET

### 参数类型:
	|参数		|是否必选    |类型    |说明
	|currentPage    |Y          |int     |当前页数
	|pageSize       |Y          |int     |每页显示的总记录数

#### 返回示例：
    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": [
            {
                "id": "1001",
                "name": "陈小明",
                "majorId": "XXR001",
                "instituteId": "XX1052",
                "tel": "13232330479",
                "remarks": "",
                "pwd": "hello123456"
            },
            {
                "id": "1002",
                "name": "李晓华",
                "majorId": "XXT001",
                "instituteId": "HK1011",
                "tel": "13232330102",
                "remarks": "",
                "pwd": "hello123456789"
            }
        ]
    }

### 63、查询单条记录

#### 角色：

~~~
管理员  
~~~

 #### 请求URL：
     http://localhost:8624/goushushenpixitong/major

 #### 请求方式：
     GET

 ### 参数类型:
     |参数	     |是否必选   |类型     |说明
     |id         |Y         |string   |ID

#### 返回示例：

    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
         }  

### 64、添加人员

#### 角色：

~~~
管理员  
~~~

#### 请求URL：
    http://localhost:8624/goushushenpixitong/staff

#### 请求方式：
    POST

### 参数类型:
    |参数         |是否必选   |类型     |说明
    |id           |Y         |string   |ID
    |name         |Y         |string   |名字
    |instituteId  |Y         |string   |所属学院ID
    |majorId      |Y         |string   |专业ID
    |pwd          |Y         |string   |密码
    |tel          |Y         |string   |联系电话
    |remarks      |N         |string   |备注信息

#### 返回示例：
    {
         "code": 200,
         "success": true,
         "message": "请求成功",
         "data": null
    }

### 65、更新信息

#### 角色：

~~~
管理员  
~~~

#### 请求URL：
    http://localhost:8624/goushushenpixitong/staff

#### 请求方式：
    PUT

### 参数类型:
    |参数	      |是否必选   |类型     |说明
    |id           |Y         |string   |ID
    |name         |Y         |string   |名字
    |instituteId  |Y         |string   |所属学院ID
    |majorId      |Y         |string   |专业ID
    |pwd          |Y         |string   |密码
    |tel          |Y         |string   |联系电话
    |remarks      |N         |string   |备注信息

#### 返回示例：
    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
        }

### 67、登陆

#### 角色：

~~~
  无
~~~

#### 请求URL：
    localhost:8624/goushushenpixitong/login?id=1001&password=hello123456

#### 请求方式：
    POST

### 参数类型:
    |参数       |是否必选   |类型     |说明
    |id         |Y         |string   |ID
    |password   |Y         |string   |密码

#### 返回示例：
    登陆成功：
    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    }
    
    账号/密码错误：
    {
        "code": 10000,
        "success": false,
        "message": "账号或密码错误",
        "data": null
    }



### 68、退出登陆

#### 角色：

~~~
  无
~~~

#### 请求URL：

    http://localhost:8624/goushushenpixitong/logout

#### 请求方式：

    GET

### 参数类型:

    |参数       |是否必选   |类型     |说明
    无

#### 返回示例：

    {
        "code": 200,
        "success": true,
        "message": "退出成功",
        "data": null
    }

### 





### 69、导出教材征订计划表

#### 角色：

~~~
  管理员
~~~

#### 请求URL：

    http://localhost:8624/goushushenpixitong/excel/schedule

#### 请求方式：

    GET

### 参数类型:

    |参数       |是否必选   |类型     |说明
    无

#### 返回示例：

    弹出保存文件

### 70、导入教材征订计划表数据（添加course）

#### 角色：

~~~
  管理员   教务干事
~~~

#### 请求URL：

    http://localhost:8624/goushushenpixitong/excel/schedule

#### 请求方式：

    POST

### 参数类型:

    |参数       |是否必选   |类型     |说明
    |file		|Y		  |excel文件|上传的excel文件

#### 返回示例：

    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    }





### 71、导出教职工信息表

#### 角色：

~~~
  管理员
~~~

#### 请求URL：

    http://localhost:8624/goushushenpixitong/staff/excel

#### 请求方式：

    GET

### 参数类型:

    |参数       |是否必选   |类型     |说明
    无

#### 返回示例：

    弹出保存文件

### 72、导入教职工信息表数据（添加staff）

#### 角色：

~~~
  管理员   
~~~

#### 请求URL：

    http://localhost:8624/goushushenpixitong/staff/excel

#### 请求方式：

    POST

### 参数类型:

    |参数       |是否必选   |类型     |说明
    |file		|Y		  |excel文件|上传的教职工信息表excel文件

#### 返回示例：

    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    }

