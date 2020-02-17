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
[查询所有学期信息](#查询所有学期信息)<br/>
[查询学期单条记录](#查询学期单条记录)<br/>
[添加学期记录](#添加学期记录)<br/>
[更新学期记录](#更新学期记录)<br/>
[删除学期记录](#删除学期记录)<br/>

#### 二、开课教学单位审核
[分页获取开课教学单位审核条目](#分页获取开课教学单位审核条目)<br/>
[获取单条审核条目记录](#获取单条审核条目记录)<br/>
[添加开课教学单位审核结果](#添加开课教学单位审核结果)<br/>
[获取科研室审核结果](#获取科研室审核结果)<br/>
[添加审核条目](#添加审核条目)<br/>
[更新条目信息](#更新条目信息)<br/>
[删除条目信息](#更新条目信息)<br/>

#### 三、课程
[查询所有课程信息](#查询所有课程信息)<br/>
[查询单条记录](#查询单条记录)<br/>
[添加](#添加)<br/>
[更新](#更新)<br/>
[删除](#删除)<br/>

#### 四、课程用书
[查询所有课程用书信息](#查询所有课程用书信息)<br/>
[查询单条记录](#查询单条记录)<br/>
[添加](#添加)<br/>
[更新](#更新)<br/>
[删除](#删除)<br/>

#### 五、书本
[查询所有书本记录](#查询所有书本记录)<br/>
[查询单条记录](#查询单条记录)<br/>
[ 模糊搜索书本](# 模糊搜索书本)<br/>
[添加书本记录](#添加书本记录)<br/>
[更新](#更新)<br/>
[删除](#删除)<br/>

#### 六、教务处审核
[分页获取教务处审核条目](#分页获取教务处审核条目)<br/>
[获取单条审核条目记录](#获取单条审核条目记录)<br/>
[获取科研室审核结果](#获取科研室审核结果)<br/>
[添加审核条目](#添加审核条目)<br/>
[添加教务处审核结果](#添加教务处审核结果)<br/>
[更新条目信息](#更新条目信息)<br/>
[删除条目](#删除条目)<br/>

#### 七、学院
[分页查询学院列表](#分页查询学院列表)<br/>
[通过编号查询学院](#通过编号查询学院)<br/>
[注册学院](#注册学院)<br/>
[修改学院信息](#修改学院信息)<br/>
[删除学院](#删除学院)<br/>
#### 八、教研室审核
[分页获取教研室审核条目](#分页获取教研室审核条目)<br/>
[获取单条审核条目记录](#获取单条审核条目记录)<br/>
[获取科研室审核结果](#获取科研室审核结果)<br/>
[添加审核条目](#添加审核条目)<br/>
[添加教研室审核结果](#添加教研室审核结果)<br/>
[更新条目信息](#更新条目信息)<br/>
[删除条目](#删除条目)<br/>

#### 九、书本等级
[分页查询等级记录](#注册学院)<br/>
[通过id获取单条记录](#注册学院)<br/>
[添加](#注册学院)<br/>
[修改](#修改)<br/>
[删除](#删除)<br/>
#### 十、专业
[分页查询专业记录](#分页查询专业记录)<br/>
[查询单条专业记录](#查询单条专业记录)<br/>
[添加专业](#添加专业)<br/>
[更新记录](#更新记录)<br/>
[删除专业](#删除专业)<br/>

#### 十一、角色
[查询所有角色](#查询所有角色)<br/>
[查询某个角色信息](#查询某个角色信息])<br/>
[添加角色](#添加角色)<br/>
[修改角色信息](#修改角色信息)<br/>
[删除角色](#删除角色)<br/>

[查询所有人员的角色信息](#查询所有人员的角色信息)<br/>
[查询某个工号的所有角色信息](#查询某个工号的所有角色信息)<br/>
[删除某个人员的角色](#删除某个人员的角色)<br/>
[为某个成员添加角色](#为某个成员添加角色)<br/>



#### 十二、权限

[查询所有权限](#查询所有权限)<br/>
[查询某个权限信息](#查询某个权限信息)<br/>
[添加权限](#添加权限)<br/>
[修改权限信息](#修改权限信息)<br/>
[删除权限](#删除权限)<br/>
[查询所有人员的权限信息](#查询所有人员的权限信息)<br/>
[查询某个工号的所有权限信息](#查询某个工号的所有权限信息)<br/>
[为某个角色添加权限](#为某个角色添加权限)<br/>
[删除某个角色的权限](#删除某个角色的权限)<br/>



#### 十二、人员
[查询所有人员信息](#查询所有人员信息)<br/>
[查询单条记录](#查询单条记录)<br/>
[添加人员](#添加人员)<br/>
[更新信息](#更新信息)<br/>
[删除人员](#删除人员)<br/>

#### 十三 、登陆

[登陆](#登陆)<br/>
[退出登陆](#退出登陆)<br/>

#### 十三 、文件 操作
[导出教材征订计划表](#导出教材征订计划表)<br/>
[导入教材征订计划表数据](#导入教材征订计划表数据（添加course）)<br/>
[导出教材征订计划表](#导出教材征订计划表)<br/>
[导入教材征订计划表](#导入教职工信息表数据（添加staff）)<br/>


## 学期

### 查询所有学期信息

**角色：**

~~~
管理员
~~~

**Header：**

~~~
Authorization  :  token (登陆获取的token)
~~~

请求URL：**
~~~
	http://localhost:8624/goushushenpixitong/term/list
~~~
**请求方式：**
~~~
GET
~~~
**参数类型：**
~~~
	|参数			 |是否必选    |类型    |说明
	|currentPage    |N          |int     |当前页数(默认为1)
	|pageSize       |N          |int     |每页显示的总记录数(默认为10)
~~~
**返回示例：**
~~~
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
~~~
### 查询学期单条记录

**角色：**

~~~
管理员
~~~
**Header：**

~~~
Authorization  :  token (登陆获取的token)
~~~
**请求URL：**
~~~
	http://localhost:8624/goushushenpixitong/term
~~~
**请求方式：**
~~~
	GET
~~~
**参数类型：**
~~~
	|参数     |是否必选    |类型    |说明
	|id       |Y          |int     |学期ID
~~~
**返回示例：**
~~~
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
~~~
### 添加学期记录

**角色：**

~~~
管理员
~~~
**Header：**

~~~
Authorization  :  token (登陆获取的token)
~~~
**请求URL：**
~~~
	http://localhost:8624/goushushenpixitong/term
~~~
**请求方式：**
~~~
	POST
~~~
**参数类型：**
~~~
	|参数     |是否必选  |类型     |说明|
	|id       |Y        |int      |学期ID|
	|name     |Y        |string   |学期名称|
	|remarks  |N        |string   |备注|
~~~
**返回示例：**
~~~
	{
	    "code": 200,
	    "success": true,
	    "message": "请求成功",
	    "data": null
	}
~~~
### 更新学期记录

**角色：**

~~~
管理员
~~~
**Header：**

~~~
Authorization  :  token (登陆获取的token)
~~~
**请求URL：**
~~~
	http://localhost:8624/goushushenpixitong/term
~~~
**请求方式：**
~~~
    PUT
~~~
**参数类型：**
~~~
	|参数     |是否必选  |类型     |说明|
	|id       |Y        |int      |学期ID|
	|name     |Y        |string   |学期名称|
	|remarks  |N        |string   |备注|
~~~
**返回示例：**
~~~
	{
	    "code": 200,
	    "success": true,
	    "message": "请求成功",
	    "data": null
	}
~~~
### 删除学期记录

**角色：**

~~~
管理员
~~~
**Header：**

~~~
Authorization  :  token (登陆获取的token)
~~~
**请求URL：**
~~~
	http://localhost:8624/goushushenpixitong/term
~~~
**请求方式：**
~~~
	DELETE	
~~~
**参数类型：**
~~~
	|参数     |是否必选    |类型    |说明
	|id       |Y          |int     |学期ID   
~~~
**返回示例：**
~~~
    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    }
~~~
## 开课教学单位审核

### 分页获取开课教学单位审核条目

**角色：**

~~~
管理员 教研室主任
~~~
**Header：**

~~~
Authorization  :  token (登陆获取的token)
~~~
**请求URL：**
~~~
	http://localhost:8624/goushushenpixitong/teachingunit/list
~~~
**请求方式：**
~~~
	GET
~~~
**参数类型:**
~~~
	|参数	          |是否必选    |类型    |说明
	|currentPage    |N          |int     |当前页数(默认为1)
	|pageSize       |N          |int     |每页显示的总记录数(默认为10)
~~~
**返回示例：**
~~~
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
~~~
### 获取单条审核条目记录

**角色：**

~~~
管理员 教研室主任
~~~
**Header：**

~~~
Authorization  :  token (登陆获取的token)
~~~
**请求URL：**
~~~
	http://localhost:8624/goushushenpixitong/teachingunit
~~~
**请求方式：**
~~~
	GET
~~~
**参数类型:**
~~~
	|参数     |是否必选   |类型     |说明
	|id       |Y         |int      |ID
~~~
**返回示例：**
~~~
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
~~~
### 添加开课教学单位审核结果
**角色：**

~~~
管理员 教研室主任
~~~
**Header：**

~~~
Authorization  :  token (登陆获取的token)
~~~
**请求URL：**
~~~
	http://localhost:8624/goushushenpixitong/teachingunit/opinions
~~~
**请求方式：**

~~~
	POST
~~~
**参数类型:**
~~~
	|参数	       |是否必选 |类型     |说明
	|subjectId  |Y       |int      |ID
	|josnStr  	|Y		 |String   |
	json格式:（开课教学单位结果规定为1个）
	[
	   {
	      "id":1,
	      "opinion":"yes"
	    }
	]
~~~
**返回示例：**
~~~
    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    }
    
    {
        "code": 10000,
        "success": false,
        "message": "开课教学单位结果规定为1个",
        "data": null
	}
~~~
### 获取科研室审核结果

**角色：**

~~~
管理员 教研室主任
~~~
**Header：**

~~~
Authorization  :  token (登陆获取的token)
~~~

**请求URL：**
~~~
	http://localhost:8624/goushushenpixitong/teachingunit/opinions
~~~
**请求方式：**
~~~
	GET
~~~
**参数类型:**
~~~
	|参数	       |是否必选 |类型     |说明
	|subjectId  |Y       |int      |ID
~~~
**返回示例：**
~~~
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
~~~
### 添加审核条目

**角色：**

~~~
管理员 教研室主任
~~~
**Header：**

~~~
Authorization  :  token (登陆获取的token)
~~~
**请求URL：**

~~~
	http://localhost:8624/goushushenpixitong/teachingunit
~~~
**请求方式：**
~~~
	POST
~~~
**参数类型:**
~~~
	|参数       |是否必选 |类型     |说明
	|id         |Y       |int      |ID
	|content    |Y       |string   |内容
	|remarks    |N       |string   |备注
~~~
**返回示例：**
~~~
    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    }
~~~
### 更新条目信息

**角色：**

~~~
管理员 教研室主任
~~~

**Header：**

~~~
Authorization  :  token (登陆获取的token)
~~~

**请求URL：**

```
  http://localhost:8624/goushushenpixitong/teachingunit
```

**请求方式：**

```
PUT
```

**参数类型:**
    

```
|参数	    |是否必选 |类型     |说明
    |id         |Y       |int      |ID
    |content    |Y       |string   |内容
    |remarks    |N       |string   |备注
```

**返回示例：**

```
 {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    }
```



### 删除条目信息

**角色：**

~~~
管理员 
~~~

**Header：**

~~~
Authorization  :  token (登陆获取的token)
~~~

**请求URL：**
    

```
http://localhost:8624/goushushenpixitong/teachingunit
```

**请求方式：**
    

```
DELETE
```

**参数类型:**

```
 	|参数	      |是否必选 |类型     |说明
    |id         |Y       |int      |ID
```

**返回示例：**

```
   {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    }
```



## 课程

### 查询所有课程信息

**角色：**

~~~
管理员 课程负责人 教研室主任
~~~

**Header：**

~~~
Authorization  :  token (登陆获取的token)
~~~

**请求URL：**

```
    http://localhost:8624/goushushenpixitong/course/list
```

**请求方式：**

```
    GET
```

**参数类型:**
	

```
	|参数			 |是否必选    |类型    |说明
	|currentPage    |N          |int     |当前页数(默认为1)
	|pageSize       |N          |int     |每页显示的总记录数(默认为10)
```

**返回示例：**

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

### 根据课程id和学期id查询单条记录

**角色：**

~~~
管理员 课程负责人 教研室主任
~~~

**Header：**

~~~
Authorization  :  token (登陆获取的token)
~~~

**请求URL：**

```
http://localhost:8624/goushushenpixitong/course/idAndTerm
```

**请求方式：**

```
 GET
```

**参数类型:**

```
    |参数	    |是否必选  |类型       |说明
    |id         |Y        |String   |课程ID
    |termId     |Y        |int      |学期ID
```

**返回示例：**

```
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
```

### 查询课程单条记录

**角色：**

~~~
管理员 课程负责人 教研室主任
~~~

**Header：**

~~~
Authorization  :  token (登陆获取的token)
~~~

**请求URL：**

```
localhost:8624/goushushenpixitong/course
```

**请求方式：**

```
 GET
```

**参数类型:**

```
    |参数	    |是否必选  |类型       |说明
    |id         |Y      |String   |课程ID
```

**返回示例：**

```
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
        "remarks": "空"
    }
}
```



### 添加

**角色：**

~~~
管理员 课程负责人 
~~~

**Header：**

~~~
Authorization  :  token (登陆获取的token)
~~~

**请求URL：**

```
   http://localhost:8624/goushushenpixitong/course
```

**请求方式：**

```
    POST
```

**参数类型:**

```
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
```

**返回示例：**
    

```
{
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    } 
```



### 更新

**角色：**

~~~
管理员 课程负责人 
~~~

**Header：**

~~~
Authorization  :  token (登陆获取的token)
~~~

**请求URL：**

```
 http://localhost:8624/goushushenpixitong/course
```

**请求方式：**
    

```
PUT
```

**参数类型:**

```
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
```

**返回示例：**

```
    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    } 
```



### 删除

**角色：**

~~~
管理员
~~~

**Header：**

~~~
Authorization  :  token (登陆获取的token)
~~~

**请求URL：**

```
   http://localhost:8624/goushushenpixitong/course
```

**请求方式：**

```
  DELETE
```

**参数类型:**

```
    |参数	    |是否必选 |类型     |说明
    |id         |Y       |int      |ID
```

**返回示例：**

    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    } 
## 课程用书

### 查询所有的课程用书信息

**角色：**

~~~
管理员 课程负责人 教研室主任
~~~

**请求URL：**

```
    http://localhost:8624/goushushenpixitong/subject/allList
```

**请求方式：**

```
    GET
```

**参数类型:**

```
	|参数		      |是否必选    |类型    |说明
	|currentPage    |N          |int     |当前页数(默认为1)
	|pageSize       |N          |int     |每页显示的总记录数(默认为10)
```

**返回示例：**

```
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
            "remarks": "required",
            "instituteId": "XX1052"
        },
        {
            "id": 2,
            "courseId": "8a632075",
            "termId": 1,
            "bookId": "20191005",
            "remarks": null,
            "instituteId": "HK1011"
        },
        {
            "id": 3,
            "courseId": "2",
            "termId": 1,
            "bookId": "20191005",
            "remarks": "",
            "instituteId": "YS1025"
        }
    ]
}
```





### 通过书名，学期名，课程名模糊查询课程用书

**角色：**

~~~
管理员 课程负责人 教研室主任
~~~

**请求URL：**

```
    http://localhost:8624/goushushenpixitong/subject/fuzzySearch
```

**请求方式：**

```
    GET
```

**参数类型:**

```
	|参数		      |是否必选    |类型    |说明
	|currentPage    |N          |int     |当前页数(默认为1)
	|pageSize       |N          |int     |每页显示的总记录数(默认为10)
	|bookName	    |N		   |String  |书名
	|termName	    |N		   |String  |学期名
	|courseName	    |N		   |String  |课程名
	（三个值都不填或为空 就默认返回所有课程用书（Books））
```

**返回示例：**

```
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
            "type": 1,
            "purpose": 1,
            "levelId": 2,
            "price": 56,
            "renew": true,
            "remarks": null
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
```





### 查询人员所属学院的课程用书信息

**角色：**

~~~
管理员 课程负责人 教研室主任
~~~

**请求URL：**

```
    http://localhost:8624/goushushenpixitong/subject/list
```

**请求方式：**

```
    GET
```

**参数类型:**

```
	|参数		|是否必选    |类型    |说明
	|currentPage    |N          |int     |当前页数(默认为1)
	|pageSize       |N          |int     |每页显示的总记录数(默认为10)
```

**返回示例：**

```
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
            "remarks": "required",
            "instituteId": "XX1052"
        }
    ]
}
```



### 查询单条记录

**角色：**

~~~
管理员 课程负责人 教研室主任
~~~

**Header：**

~~~
Authorization  :  token (登陆获取的token)
~~~

**请求URL：**

```
   http://localhost:8624/goushushenpixitong/subject
```

**请求方式：**

```
  GET
```

**参数类型:**

```
    |参数       |是否必选  |类型     |说明
    |id         |Y        |int      |学期ID
```

**返回示例：**

```
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
```



### 添加

**角色：**

~~~
管理员 课程负责人 
~~~

**Header：**

~~~
Authorization  :  token (登陆获取的token)
~~~

**请求URL：**

```
  http://localhost:8624/goushushenpixitong/subject
```

**请求方式：**

```
  POST
```

**参数类型:**

```
    |参数	        |是否必选 |类型      |说明
    |termId       |Y       |int       |学期编号
    |bookId       |Y       |String    |图书编号
    |courseId     |Y       |String    |课程编号
    |remarks      |N       |String    |备注
    |instituteId  |Y       |String    |学院编号
```

**返回示例：**

    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    }
    课程不存在：
    {
        "code": 10000,
        "success": false,
        "message": "当前课程不存在",
        "data": null
    }
    学期不存在：
    {
        "code": 10000,
        "success": false,
        "message": "当前学期不存在",
        "data": null
    }
    图书不存在：
    {
        "code": 10000,
        "success": false,
        "message": "当前图书不存在",
        "data": null
    }
    学院不存在：
    {
        "code": 10000,
        "success": false,
        "message": "当前学院不存在",
        "data": null
    }

### 更新

**角色：**

~~~
管理员 课程负责人 
~~~

**Header：**

~~~
Authorization  :  token (登陆获取的token)
~~~

**请求URL：**

```
  http://localhost:8624/goushushenpixitong/subject
```

**请求方式：**

```
 PUT
```

**参数类型:**

```
     |参数	       |是否必选 |类型      |说明
     |id           |Y       |int       |id
     |termId       |Y       |int       |学期编号
     |bookId       |Y       |String    |图书编号
     |courseId     |Y       |String    |课程编号
     |remarks      |N       |String    |备注
```

**返回示例：**

```
    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    } 
```



### 删除

**角色：**

~~~
管理员 
~~~

**Header：**

~~~
Authorization  :  token (登陆获取的token)
~~~

**请求URL：**

```
    http://localhost:8624/goushushenpixitong/subject
```

**请求方式：**

```
 DELETE
```

**参数类型:**

```
    |参数	    |是否必选 |类型     |说明
    |id         |Y       |int      |ID
```

**返回示例：**

```
    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
     }
```



## 书本

### 查询所有书本记录

**角色：**

~~~
管理员 课程负责人 教研室主任
~~~

**Header：**

~~~
Authorization  :  token (登陆获取的token)
~~~

**请求URL：**

```
 http://localhost:8624/goushushenpixitong/book/list
```

**请求方式：**
    

```
GET
```

**参数类型:**

~~~
|参数	        |是否必选    |类型    |说明
|currentPage    |N         |int     |当前页数(默认为1)
|pageSize       |N         |int     |每页显示的总记录数(默认为10)
~~~

**返回示例：**

```
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
```




### 根据书名模糊搜索书本

**角色：**

~~~
管理员 课程负责人 教研室主任
~~~

**Header：**

~~~
Authorization  :  token (登陆获取的token)
~~~

**请求URL：**

    localhost:8624/goushushenpixitong/book/like

**请求方式：**

    GET

**参数类型:**

    |参数	    |是否必选 |类型        |说明
    |bookName    |N       |string      |模糊搜索条件  空 为搜索全部书本

**返回示例：**

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
                "remarks": ""
            }
        ]
    }

### 





### 查询单条记录

**角色：**

~~~
管理员 课程负责人 教研室主任
~~~

**Header：**

~~~
Authorization  :  token (登陆获取的token)
~~~

**请求URL：**

```
 http://localhost:8624/goushushenpixitong/book
```

**请求方式：**

```
    GET
```

**参数类型:**

```
    |参数	    |是否必选 |类型        |说明
    |id         |Y       |string      |图书ID
```

**返回示例：**

```
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
```



### 添加书本记录

**角色：**

~~~
管理员 课程负责人 
~~~

**Header：**

~~~
Authorization  :  token (登陆获取的token)
~~~

**请求URL：**

```
    http://localhost:8624/goushushenpixitong/book
```

**请求方式：**

```
    POST
```

**参数类型:**

```
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
```

**返回示例：**

```
    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    }
```



### 更新

**角色：**

~~~
管理员 课程负责人 
~~~

**Header：**

~~~
Authorization  :  token (登陆获取的token)
~~~

**请求URL：**

```
    http://localhost:8624/goushushenpixitong/book
```

**请求方式：**

```
    PUT

```

**参数类型:**

```
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
```

**返回示例：**

```
    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    }
```



### 删除

**角色：**

~~~
管理员 
~~~

**Header：**

~~~
Authorization  :  token (登陆获取的token)
~~~

**请求URL：**

```
   http://localhost:8624/goushushenpixitong/book
```

**请求方式：**

```
    DELETE
```

**参数类型:**

```
    |参数       |是否必选 |类型      |说明
    |id         |Y       |string    |图书ID
```

**返回示例：**

```
    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    } 
```

## 教务处审核

### 分页获取教务处审核条目

**角色：**

~~~
管理员 教研室主任
~~~

**Header：**

~~~
Authorization  :  token (登陆获取的token)
~~~

**请求URL：**

```
http://localhost:8624/goushushenpixitong/deanoffice/list
```

**请求方式：**

```
   GET
```

**参数类型:**

~~~
|参数			 |是否必选    |类型    |说明
|currentPage    |N          |int     |当前页数(默认为1)
|pageSize       |N          |int     |每页显示的总记录数(默认为10)
~~~

**返回示例：**

```
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
```



### 获取单条审核条目记录

**角色：**

~~~
管理员 教研室主任
~~~

**Header：**

~~~
Authorization  :  token (登陆获取的token)
~~~

**请求URL：**

```
  http://localhost:8624/goushushenpixitong/deanoffice
```

**请求方式：**

```
  GET
```

**参数类型:**

```
    |参数	    |是否必选 |类型        |说明
    |id         |Y       |int         |ID
```

**返回示例：**

```
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
```



### 获取科研室审核结果

**角色：**

~~~
管理员 教研室主任
~~~

**Header：**

~~~
Authorization  :  token (登陆获取的token)
~~~

**请求URL：**

```
   http://localhost:8624/goushushenpixitong/deanoffice/opinions
```

**请求方式：**

```
 GET
```

**参数类型:**

    |参数	    	|是否必选 |类型        |说明
    |subjectId   |Y       |int         |ID

**返回示例：**

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

   






































### 添加审核条目

**角色：**

~~~
管理员 教研室主任
~~~

**Header：**

~~~
Authorization  :  token (登陆获取的token)
~~~

**请求URL：**

```
http://localhost:8624/goushushenpixitong/deanoffice
```

**请求方式：**

```
 POST
```

**参数类型:**

```
    |参数         |是否必选  |类型       |说明
    |id           |Y        |int        |ID
    |content      |Y        |string     |内容
    |remarks      |N        |string     |备注
```


**返回示例：**

```
    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    }
```



### 添加教务处审核结果

**角色：**

~~~
管理员 教研室主任
~~~

**Header：**

~~~
Authorization  :  token (登陆获取的token)
~~~

**请求URL：**

```
  http://localhost:8624/goushushenpixitong/deanoffice/opinions
```

**请求方式：**

	POST

**参数类型:**

	|参数	       |是否必选 |类型     |说明
	|subjectId  |Y       |int      |ID
	|josnStr  	|Y		 |String   |
	json格式:（教务处审核结果规定为2个）
	[
	   {
	      "id":1,
	      "opinion":"yes"
	    },
	    {
	      "id":2,
	      "opinion":"yes"
	    }
	]

**返回示例：**

    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    }
    
    {
        "code": 10000,
        "success": false,
        "message": "教务处审核结果规定为2个",
        "data": null
    }

​    

### 更新条目信息

**角色**

~~~
管理员  教研室主任
~~~

**Header：**

~~~
Authorization  :  token (登陆获取的token)
~~~

**请求URL：**

```
   http://localhost:8624/goushushenpixitong/deanoffice
```

**请求方式：**

```
PUT
```

**参数类型:**

```
    |参数	      |是否必选  |类型       |说明
    |id           |Y        |int        |图书编号
    |content      |Y        |string     |内容
    |remarks      |N        |string     |备注
```

**返回示例：**

```
    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    }
```



### 删除条目

**角色**

~~~
管理员 
~~~

**Header：**

~~~
Authorization  :  token (登陆获取的token)
~~~

**请求URL：**

```
    http://localhost:8624/goushushenpixitong/deanoffice
```

**请求方式：**

**返回示例：**

```
    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    } 
```



## 学院

### 分页查询学院列表

**角色：**

~~~
管理员 
~~~

**Header：**

~~~
Authorization  :  token (登陆获取的token)
~~~

**请求URL：**

```
    http://localhost:8624/goushushenpixitong/institute/list
```

**请求方式：**

```
  GET
```

**参数类型:**

```
	|参数			 |是否必选    |类型    |说明
	|currentPage    |N          |int     |当前页数(默认为1)
	|pageSize       |N          |int     |每页显示的总记录数(默认为10)
```

**返回示例：**

```
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
```



### 通过编号查询学院

**角色：**

~~~
管理员 
~~~

**Header：**

~~~
Authorization  :  token (登陆获取的token)
~~~

**请求URL：**

```
   http://localhost:8624/goushushenpixitong/institute
```

**请求方式：**

```
 GET
```

**参数类型:**

```
    |参数	    |是否必选 |类型     |说明
    |id         |Y       |string      |ID
```

**返回示例：**

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

### 注册学院

**角色：**

~~~
管理员 
~~~

**Header：**

~~~
Authorization  :  token (登陆获取的token)
~~~

**请求URL：**

```
  http://localhost:8624/goushushenpixitong/institute
```

**请求方式：**

```
   POST
```

**参数类型:**

```
    |参数	    |是否必选 |类型     |说明
    |id         |Y       |string   |ID
    |name       |Y       |string   |内容
    |remarks    |N       |string    |备注
```

**返回示例：**

    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    }

### 修改学院信息：

**角色：**

~~~
管理员 
~~~

**Header：**

~~~
Authorization  :  token (登陆获取的token)
~~~

**请求URL：**

```
 http://localhost:8624/goushushenpixitong/institute
```

**请求方式：**
    

```
PUT
```

**参数类型:**

```
    |参数	    |是否必选 |类型     |说明
    |id         |Y       |string   |ID
    |name       |Y       |string   |内容
    |remarks    |N       |string    |备注
```

**返回示例：**

    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    }

### 删除学院

**角色：**

~~~
管理员 
~~~

**Header：**

~~~
Authorization  :  token (登陆获取的token)
~~~

**请求URL：**

```
    http://localhost:8624/goushushenpixitong/institute
```

**请求方式：**

```
 DELETE
```

**参数类型:**

```
    |参数	    |是否必选 |类型     |说明
    |id         |Y       |string   |ID
```

**返回示例：**

    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    }



## 教研室审核

### 分页获取教研室审核条目

**角色：**

~~~
管理员  教研室主任
~~~

**Header：**

~~~
Authorization  :  token (登陆获取的token)
~~~

**请求URL：**

```
 http://localhost:8624/goushushenpixitong/laboratory/list
```

**请求方式：**

```
 GET
```

**参数类型:**

```
	|参数			  |是否必选    |类型    |说明
	|currentPage    |N          |int     |当前页数(默认为1)
	|pageSize       |N          |int     |每页显示的总记录数(默认为10)
```

**返回示例：**

```
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
```



### 获取单条审核条目记录

**角色：**

~~~
管理员   教研室主任
~~~

**Header：**

~~~
Authorization  :  token (登陆获取的token)
~~~

**请求URL：**

```
  http://localhost:8624/goushushenpixitong/laboratory
```

**请求方式：**

```
    GET
```

**参数类型:**

```
    |参数	    |是否必选 |类型     |说明
    |id         |Y       |int      |ID
```

**返回示例：**

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

### 获取科研室审核结果

**角色：**

~~~
管理员 教研室主任
~~~

**Header：**

~~~
Authorization  :  token (登陆获取的token)
~~~

**请求URL：**

    http://localhost:8624/goushushenpixitong/laboratory/opinions

**请求方式：**

    GET

**参数类型:**

    |参数	    	|是否必选 |类型        |说明
    |subjectId   |Y       |int         |ID

**返回示例：**

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

   






































### 添加审核条目

**角色：**

~~~
管理员   教研室主任
~~~

**Header：**

~~~
Authorization  :  token (登陆获取的token)
~~~

**请求URL：**

```
  http://localhost:8624/goushushenpixitong/laboratory
```

**请求方式：**

```
   POST
```

**参数类型:**

```
    |参数       |是否必选 |类型     |说明
    |id         |Y       |int      |ID
    |content    |Y       |string   |内容
    |remarks    |N       |string   |备注
```

**返回示例：**

```
    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    }
```



### 添加教研室审核结果

**请求URL：**

	http://localhost:8624/goushushenpixitong/laboratory/opinions

**Header：**

~~~
Authorization  :  token (登陆获取的token)
~~~

**请求方式：**

	POST

**参数类型:**

	|参数	       |是否必选 |类型     |说明
	|subjectId  |Y       |int      |ID
	|josnStr  	|Y		 |String   |
	json格式:（教研室审核意见规定为6个）
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

**返回示例：**

    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    }  
    
    {
        "code": 10000,
        "success": false,
        "message": "教研室审核意见规定为6个",
        "data": null
    }

### 更新条目信息

**角色：**

~~~
管理员   教研室主任
~~~

**Header：**

~~~
Authorization  :  token (登陆获取的token)
~~~

**请求URL：**

```
  http://localhost:8624/goushushenpixitong/laboratory
```

**请求方式：**

```
    PUT
```

**参数类型:**

```
    |参数	    |是否必选 |类型     |说明
    |id         |Y       |int      |ID
    |content    |Y       |string   |内容
    |remarks    |N       |string   |备注
```

**返回示例：**

```
    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    }
```



### 删除条目

**角色：**

~~~
管理员   
~~~

**Header：**

~~~
Authorization  :  token (登陆获取的token)
~~~

**请求URL：**

```
 http://localhost:8624/goushushenpixitong/laboratory
```

**请求方式：**

```
    DELETE
```

**参数类型:**

```
    |参数	    |是否必选 |类型     |说明
    |id       |Y       |int      |ID 
```

**返回示例：**

**返回示例：**

    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    }
## 等级

### 分页查询等级记录

**角色：**

~~~
管理员   教研室主任  课程负责人
~~~

**Header：**

~~~
Authorization  :  token (登陆获取的token)
~~~

**请求URL：**

```
  http://localhost:8624/goushushenpixitong/level/list
```

**请求方式：**

```
    GET
```

**参数类型:**

```
	|参数			 |是否必选    |类型    |说明
	|currentPage    |N          |int     |当前页数(默认为1)
	|pageSize       |N          |int     |每页显示的总记录数(默认为10)
```

**返回示例：**

```
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
```



### 通过id获取单条记录

**角色：**

~~~
管理员   教研室主任  课程负责人
~~~

**Header：**

~~~
Authorization  :  token (登陆获取的token)
~~~

**请求URL：**

```
  http://localhost:8624/goushushenpixitong/level
```

**请求方式：**

```
    GET
```

**参数类型:**

```
    |参数  	|是否必选   |类型      |说明
    |id     |Y         |int   |ID
```

**返回示例：**

```
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
```



### 添加等级

**角色：**

~~~
管理员   课程负责人
~~~

**Header：**

~~~
Authorization  :  token (登陆获取的token)
~~~

**请求URL：**

```
    http://localhost:8624/goushushenpixitong/level
```

**请求方式：**

```
    POST
```

**参数类型:**

```
    |参数	      |是否必选 |类型      |说明
    |id           |Y       |int       |ID
    |name         |Y       |string    |内容
    |remarks      |N       |string    |备注
```

**返回示例：**

```
    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    }
```



### 修改

**角色：**

~~~
管理员   课程负责人
~~~

**Header：**

~~~
Authorization  :  token (登陆获取的token)
~~~

**请求URL：**

```
    http://localhost:8624/goushushenpixitong/level
```

**请求方式：**

```
    PUT
```

**参数类型:**

```
    |参数         |是否必选 |类型      |说明
    |id           |Y       |int       |ID
    |name         |Y       |string    |内容
    |remarks      |N       |string    |备注
```

**返回示例：**

```
    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    }
```



### 删除

**角色：**

~~~
管理员  
~~~

**Header：**

~~~
Authorization  :  token (登陆获取的token)
~~~

**请求URL：**

```
   http://localhost:8624/goushushenpixitong/level
```

**请求方式：**

```
    DELETE
```

**参数类型:**

```
    |参数       |是否必选   |类型     |说明
    |id         |Y         |int      |ID
```

**返回示例：**

```
    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    }
```



## 专业

### 分页查询专业记录

**角色：**

~~~
管理员  
~~~

**Header：**

~~~
Authorization  :  token (登陆获取的token)
~~~

**请求URL：**

```
    http://localhost:8624/goushushenpixitong/major/list
```

**请求方式：**

```
    GET
```

**参数类型:**

```
	|参数			  |是否必选    |类型    |说明
	|currentPage    |N          |int     |当前页数(默认为1)
	|pageSize       |N          |int     |每页显示的总记录数(默认为10)
```

**返回示例：**

```
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
```



### 查询单条专业记录

**角色：**

~~~
管理员  
~~~

**Header：**

~~~
Authorization  :  token (登陆获取的token)
~~~

**请求URL：**

```
  http://localhost:8624/goushushenpixitong/major
```

**请求方式：**

```
GET
```

**参数类型:**

```
    |参数	    |是否必选   |类型      |说明
    |id         |Y         |string    |ID
```

**返回示例：**

```
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
```



### 添加专业

**角色：**

~~~
管理员  
~~~

**Header：**

~~~
Authorization  :  token (登陆获取的token)
~~~

**请求URL：**

```
    http://localhost:8624/goushushenpixitong/major
```

**请求方式：**

```
    POST
```

**参数类型:**

```
    |参数         |是否必选 |类型      |说明
    |id           |Y       |string    |ID
    |name         |Y       |string    |内容
    |instituteId  |Y       |string    |学院编号
    |remarks      |N       |string    |备注
```

**返回示例：**

```
    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    }
    学院不存在:
    {
        "code": 10000,
        "success": false,
        "message": "当前学院不存在",
        "data": null
	}
```



### 更新记录

**角色：**

~~~
管理员 
~~~

**Header：**

~~~
Authorization  :  token (登陆获取的token)
~~~

**请求URL：**

```
    http://localhost:8624/goushushenpixitong/major
```

**请求方式：**

```
    PUT
```

**参数类型:**

```
    |参数         |是否必选 |类型      |说明
    |id           |Y       |string    |ID
    |name         |Y       |string    |内容
    |instituteId  |Y       |string    |学院编号
    |remarks      |N       |string    |备注
```

**返回示例：**

```
    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    }
```



### 删除专业

**角色：**

~~~
管理员  
~~~

**Header：**

~~~
Authorization  :  token (登陆获取的token)
~~~

**请求URL：**

```
   http://localhost:8624/goushushenpixitong/major
```

**请求方式：**

```
    DELETE
```

**参数类型:**

```
    |参数       |是否必选   |类型     |说明
    |id         |Y         |string   |ID
```

**返回示例：**

```
    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    }
```





## 角色

### 查询所有角色

**角色：**

~~~
管理员  
~~~

**Header：**

~~~
Authorization  :  token (登陆获取的token)
~~~

**请求URL：**

```
http://localhost:8624/goushushenpixitong/role/list
```

**请求方式：**

```
    GET
```

**参数类型:**

~~~
|参数			|是否必选    |类型    |说明
|currentPage   |N          |int     |当前页数(默认为1)
|pageSize      |N          |int     |每页显示的总记录数(默认为10)
~~~



**返回示例：**

    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": [
            {
                "id": 0,
                "type": "管理员",
                "remarks": null
            },
            {
                "id": 1,
                "type": "教务干事",
                "remarks": null
            },
            {
                "id": 2,
                "type": "课程负责人",
                "remarks": null
            },
            {
                "id": 3,
                "type": "教研室主任",
                "remarks": null
            }
        ]
    }



### 查询某个角色信息

**角色：**

~~~
管理员  
~~~

**Header：**

~~~
Authorization  :  token (登陆获取的token)
~~~

**请求URL：**

```
http://localhost:8624/goushushenpixitong/role
```

**请求方式：**

```
    GET
```

**参数类型:**

~~~
|参数			|是否必选    |类型    |说明
|roleId		  |Y		 |int	  |角色id 
~~~



**返回示例：**

    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": {
            "id": 1,
            "type": "教务干事",
            "remarks": null
        }
    }



### 添加角色

**角色：**

~~~
管理员  
~~~

**Header：**

~~~
Authorization  :  token (登陆获取的token)
~~~

**请求URL：**

```
http://localhost:8624/goushushenpixitong/role
```

**请求方式：**

```
    POST
```

**参数类型:**

~~~
|参数			|是否必选    |类型    |说明
|type		  |Y		 |String  |角色名称
|remarks	  |Y		 |String  |备注
~~~

**返回示例：**

    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    }



### 修改角色信息

**角色：**

~~~
管理员  
~~~

**Header：**

~~~
Authorization  :  token (登陆获取的token)
~~~

**请求URL：**

```
http://localhost:8624/goushushenpixitong/role
```

**请求方式：**

```
    PUT
```

**参数类型:**

~~~
|参数			|是否必选    |类型    |说明
|id			  |Y	     |int	  |要修改的角色id
|type		  |Y		 |String  |角色名称
|remarks	  |Y		 |String  |备注
~~~

**返回示例：**

    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    }




### 删除角色

**角色：**

~~~
管理员  
~~~

**Header：**

~~~
Authorization  :  token (登陆获取的token)
~~~

**请求URL：**

    http://localhost:8624/goushushenpixitong/role

**请求方式：**

    DELETE

**参数类型:**

     |参数	     |是否必选 |类型   |说明
     |roleId        |Y       |int    |要删除的角色ID

**返回示例：**

    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    }

​    







### 查询所有人员的角色信息

**角色：**

~~~
管理员  
~~~

**Header：**

~~~
Authorization  :  token (登陆获取的token)
~~~

**请求URL：**

```
    http://localhost:8624/goushushenpixitong/staff_role/list
```

**请求方式：**

```
    GET
```

**参数类型:**

~~~
|参数			|是否必选    |类型    |说明
|currentPage   |N          |int     |当前页数(默认为1)
|pageSize      |N          |int     |每页显示的总记录数(默认为10)
~~~



**返回示例：**(这里只获取角色 ，权限全为null)

    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": [
            {
                "id": "1003",
                "name": "张三",
                "role": "教务干事",
                "power": null
            },
            {
                "id": "1004",
                "name": "李四",
                "role": "课程负责人",
                "power": null
            },
            {
                "id": "1002",
                "name": "李晓华",
                "role": "教研室主任",
                "power": null
            },
            {
                "id": "1001",
                "name": "陈小明",
                "role": "管理员",
                "power": null
            },
            {
                "id": "1001",
                "name": "陈小明",
                "role": "教研室主任",
                "power": null
            },
            {
                "id": "1002",
                "name": "李晓华",
                "role": "教务干事",
                "power": null
            }
        ]
    }





### 查询某个工号的所有角色信息

**角色：**

~~~
管理员  
~~~

**Header：**

~~~
Authorization  :  token (登陆获取的token)
~~~

**请求URL：**

```
    http://localhost:8624/goushushenpixitong/staff_role
```

**请求方式：**

```
    GET
```

**参数类型:**

```
    |参数	      |是否必选 |类型      |说明
    |staffId    |Y       |string    |员工id
```

**返回示例：**

    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": [
            {
                "id": "1001",
                "name": "陈小明",
                "role": "管理员",
                "power": null
            },
            {
                "id": "1001",
                "name": "陈小明",
                "role": "教研室主任",
                "power": null
            }
        ]
    }

### 为某个成员添加角色

**角色：**

~~~
管理员  
~~~

**Header：**

~~~
Authorization  :  token (登陆获取的token)
~~~

**请求URL：**

```
    http://localhost:8624/goushushenpixitong/staff_role
```

**请求方式：**

```
    POST
```

**参数类型:**

```
    |参数	      |是否必选 |类型      |说明
    |staffId    |Y 		 |String   |员工id
    |roleId	    |Y		 |int 	   |角色id
```

**返回示例：**

    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    }
    角色不存在：
    {
        "code": 10000,
        "success": false,
        "message": "当前角色不存在",
        "data": null
    }
    人员不存在：
    {
        "code": 10000,
        "success": false,
        "message": "当前人员不存在",
        "data": null
    }



### 删除某个人员的角色

**角色：**

~~~
管理员  
~~~

**Header：**

~~~
Authorization  :  token (登陆获取的token)
~~~

**请求URL：**

```
    http://localhost:8624/goushushenpixitong/staff_role
```

**请求方式：**

```
    DELETE
```

**参数类型:**

```
    |参数	     	   |是否必选 |类型      |说明
    |staff_roleId    |Y 		 |String   |staff_role id
```

**返回示例：**

    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    }



## 权限



### 查询所有权限

**角色：**

~~~
管理员  
~~~

**Header：**

~~~
Authorization  :  token (登陆获取的token)
~~~

**请求URL：**

```
http://localhost:8624/goushushenpixitong/power/list
```

**请求方式：**

```
    GET
```

**参数类型:**

~~~
|参数			|是否必选    |类型    |说明
|currentPage   |N          |int     |当前页数(默认为1)
|pageSize      |N          |int     |每页显示的总记录数(默认为10)
~~~



**返回示例：**

    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": [
            {
                "id": 1,
                "powername": "test",
                "remarks": null
            },
            {
                "id": 2,
                "powername": "test2",
                "remarks": null
            }
        ]
    }



### 查询某个权限信息

**角色：**

~~~
管理员  
~~~

**Header：**

~~~
Authorization  :  token (登陆获取的token)
~~~

**请求URL：**

```
http://localhost:8624/goushushenpixitong/power
```

**请求方式：**

```
    GET
```

**参数类型:**

~~~
|参数			    |是否必选    |类型    |说明
|powerId		  |Y		 |int	  |权限id 
~~~



**返回示例：**

    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": {
            "id": 1,
            "powername": "test",
            "remarks": null
        }
    }



### 添加权限

**角色：**

~~~
管理员  
~~~

**Header：**

~~~
Authorization  :  token (登陆获取的token)
~~~

**请求URL：**

```
http://localhost:8624/goushushenpixitong/power
```

**请求方式：**

```
    POST
```

**参数类型:**

~~~
|参数			|是否必选    |类型    |说明
|powerName	  |Y		 |String  |权限名称
|remarks	  |Y		 |String  |备注
~~~

**返回示例：**

    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    }



### 修改权限信息

**角色：**

~~~
管理员  
~~~

**Header：**

~~~
Authorization  :  token (登陆获取的token)
~~~

**请求URL：**

```
http://localhost:8624/goushushenpixitong/power
```

**请求方式：**

```
    PUT
```

**参数类型:**

~~~
|参数			|是否必选    |类型    |说明
|id			  |Y	     |int	  |要修改的角色id
|powerName	  |Y		 |String  |权限名称
|remarks	  |Y		 |String  |备注
~~~

**返回示例：**

    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    }




### 删除权限

**角色：**

~~~
管理员  
~~~

**Header：**

~~~
Authorization  :  token (登陆获取的token)
~~~

**请求URL：**

    http://localhost:8624/goushushenpixitong/power

**请求方式：**

    DELETE

**参数类型:**

     |参数	     |是否必选 |类型   |说明
     |powerId        |Y       |int    |要删除的角色ID

**返回示例：**

    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    }



### 查询所有人员的权限信息

**角色：**

~~~
管理员  
~~~

**Header：**

~~~
Authorization  :  token (登陆获取的token)
~~~

**请求URL：**

```
    http://localhost:8624/goushushenpixitong/role_power/list
```

**请求方式：**

```
    GET
```

**参数类型:**

~~~
|参数			|是否必选    |类型    |说明
|currentPage   |N          |int     |当前页数(默认为1)
|pageSize      |N          |int     |每页显示的总记录数(默认为10)
~~~



**返回示例：**(这里只获取权限 ，角色全为null)

    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": [
            {
                "id": "1003",
                "name": "张三",
                "role": null,
                "power": "test2"
            },
            {
                "id": "1001",
                "name": "陈小明",
                "role": null,
                "power": "test"
            },
            {
                "id": "1001",
                "name": "陈小明",
                "role": null,
                "power": "test2"
            },
            {
                "id": "1002",
                "name": "李晓华",
                "role": null,
                "power": "test2"
            }
        ]
    }





### 查询某个工号的所有权限信息

**角色：**

~~~
管理员  
~~~

**Header：**

~~~
Authorization  :  token (登陆获取的token)
~~~

**请求URL：**

```
    http://localhost:8624/goushushenpixitong/role_power
```

**请求方式：**

```
    GET
```

**参数类型:**

```
    |参数	      |是否必选 |类型      |说明
    |staffId    |Y       |string    |员工id
```

**返回示例：**(这里只获取权限 ，角色全为null)

    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": [
            {
                "id": "1001",
                "name": "陈小明",
                "role": null,
                "power": "test"
            },
            {
                "id": "1001",
                "name": "陈小明",
                "role": null,
                "power": "test2"
            }
        ]
    }

### 为某个角色添加权限

**角色：**

~~~
管理员  
~~~

**Header：**

~~~
Authorization  :  token (登陆获取的token)
~~~

**请求URL：**

```
    http://localhost:8624/goushushenpixitong/role_power
```

**请求方式：**

```
    POST
```

**参数类型:**

```
    |参数	      |是否必选 |类型      |说明
    |roleId	    |Y		 |int 	   |角色id
    |powerId    |Y 		 |String   |权限id
```

**返回示例：**

    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    }
    角色不存在：
    {
        "code": 10000,
        "success": false,
        "message": "当前角色不存在",
        "data": null
    }
    权限不存在:
    {
        "code": 10000,
        "success": false,
        "message": "当前权限不存在",
        "data": null
    }



### 删除某个角色的权限

**角色：**

~~~
管理员  
~~~

**Header：**

~~~
Authorization  :  token (登陆获取的token)
~~~

**请求URL：**

```
    http://localhost:8624/goushushenpixitong/role_power
```

**请求方式：**

```
    DELETE
```

**参数类型:**

```
    |参数	     	   |是否必选    |类型      |说明
    |role_powerId    |Y 		 |String   |role_power id
```

**返回示例：**

    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    }

 
















## 人员

**角色：**

~~~
管理员  
~~~

**请求URL：**

```
    http://localhost:8624/goushushenpixitong/staff/list
```

**请求方式：**

```
    GET
```

**参数类型:**

```
	|参数		 	  |是否必选    |类型    |说明
	|currentPage    |N          |int     |当前页数(默认为1)
	|pageSize       |N          |int     |每页显示的总记录数(默认为10)
```

**返回示例：**

```
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
```





### 查询所有人员信息

**角色：**

~~~
管理员  
~~~

**请求URL：**

```
    http://localhost:8624/goushushenpixitong/staff/list
```

**请求方式：**

```
    GET
```

**参数类型:**

```
	|参数		 	  |是否必选    |类型    |说明
	|currentPage    |N          |int     |当前页数(默认为1)
	|pageSize       |N          |int     |每页显示的总记录数(默认为10)
```

**返回示例：**

```
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
```



### 查询单条记录

**角色：**

~~~
管理员  
~~~

 **Header：**

~~~
Authorization  :  token (登陆获取的token)
~~~

**请求URL：**

```
 http://localhost:8624/goushushenpixitong/major
```

 **请求方式：**

```
     GET
```

 **参数类型:**

```
     |参数	     |是否必选   |类型     |说明
     |id         |Y         |string   |ID
```

**返回示例：**

    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
         }  

### 添加人员

**角色：**

~~~
管理员  
~~~

**Header：**

~~~
Authorization  :  token (登陆获取的token)
~~~

**请求URL：**

```
    http://localhost:8624/goushushenpixitong/staff
```

**请求方式：**

```
    POST
```

**参数类型:**

```
    |参数         |是否必选   |类型     |说明
    |id           |Y         |string   |ID
    |name         |Y         |string   |名字
    |instituteId  |Y         |string   |所属学院ID
    |majorId      |Y         |string   |专业ID
    |pwd          |Y         |string   |密码
    |tel          |Y         |string   |联系电话
    |remarks      |N         |string   |备注信息
```

**返回示例：**

```
    {
         "code": 200,
         "success": true,
         "message": "请求成功",
         "data": null
    }
    专业不存在:
    {
        "code": 10000,
        "success": false,
        "message": "当前专业不存在",
        "data": null
    }
    学院不存在：
    {
        "code": 10000,
        "success": false,
        "message": "当前学院不存在",
        "data": null
    }
```



### 更新信息

**角色：**

~~~
管理员  
~~~

**Header：**

~~~
Authorization  :  token (登陆获取的token)
~~~

**请求URL：**

```
    http://localhost:8624/goushushenpixitong/staff
```

**请求方式：**

```
    PUT
```

**参数类型:**

```
    |参数	      |是否必选   |类型     |说明
    |id           |Y         |string   |ID
    |name         |Y         |string   |名字
    |instituteId  |Y         |string   |所属学院ID
    |majorId      |Y         |string   |专业ID
    |pwd          |Y         |string   |密码
    |tel          |Y         |string   |联系电话
    |remarks      |N         |string   |备注信息
```

**返回示例：**

```
    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
        }
```



## 登陆

### 登陆

**角色：**

~~~
  无
~~~

**Header：**

~~~
无
~~~

**请求URL：**

```
    localhost:8624/goushushenpixitong/login
```

**请求方式：**

```
    POST
```

**参数类型:**

```
    |参数       |是否必选   |类型     |说明
    |id         |Y         |string   |ID
    |password   |Y         |string   |密码
```

**返回示例：**

    登陆成功：
    {
        "code": 200,
        "success": true,
        "message": "登陆成功",
        "data": {
            "token": "login_token_61bc3ff5-0c00-4048-b12e-708c625abc11"
        }
    }
        账号/密码错误：
    {
        "code": 10000,
        "success": false,
        "message": "账号或密码错误",
        "data": null
    }



### 退出登陆

**角色：**

~~~
  无
~~~

**Header：**

~~~
无
~~~

**请求URL：**

    http://localhost:8624/goushushenpixitong/logout

**请求方式：**

    GET

**参数类型:**

    |参数       |是否必选   |类型     |说明
    无

**返回示例：**

    {
        "code": 200,
        "success": true,
        "message": "退出成功",
        "data": null
    }



## 文件操作

### 导出教材征订计划表

**角色：**

~~~
  管理员
~~~

**Header：**

~~~
Authorization  :  token (登陆获取的token)
~~~

**请求URL：**

    http://localhost:8624/goushushenpixitong/excel/schedule

**请求方式：**

    GET

**参数类型:**

    |参数       |是否必选   |类型     |说明
    无

**返回示例：**

    弹出保存文件





### 导入教材征订计划表数据（添加course）

**角色：**

~~~
  管理员   教务干事
~~~

**Header：**

~~~
Authorization  :  token (登陆获取的token)
~~~

**请求URL：**

    http://localhost:8624/goushushenpixitong/excel/schedule

**请求方式：**

    POST

**参数类型:**

    |参数       |是否必选   |类型     |说明
    |file		|Y		  |excel文件|上传的excel文件

**返回示例：**

    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    }



### 导出教职工信息表上传模板

**角色：**

~~~
  管理员
~~~

**Header：**

~~~
Authorization  :  token (登陆获取的token)
~~~

**请求URL：**

    http://localhost:8624/goushushenpixitong/staff/excel

**请求方式：**

    GET

**参数类型:**

    |参数       |是否必选   |类型     |说明
    无

**返回示例：**

    弹出教职工信息表上传模板,保存文件

### 导入教职工信息表数据（添加staff）

**角色：**

~~~
  管理员   
~~~

**Header：**

~~~
Authorization  :  token (登陆获取的token)
~~~

**请求URL：**

    http://localhost:8624/goushushenpixitong/staff/excel

**请求方式：**

    POST

**参数类型:**

    |参数       |是否必选   |类型     |说明
    |file		|Y		  |excel文件|上传的教职工信息表excel文件

**返回示例：**

    上传并解析成功(成功添加员工):
    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    }
    工号已存在：
    {
        "code": 10000,
        "success": false,
        "message": "第3行的工号\"210030204\"已存在",
        "data": null
    }
    员工已存在：
    {
        "code": 10000,
        "success": false,
        "message": "第3行的员工姓名\"张文远\"已存在",
        "data": null
    }
    学院不存在：
    {
        "code": 10000,
        "success": false,
        "message": "第3行的学院\"a学院\"不存在",
        "data": null
    }
    专业不存在：
    {
        "code": 10000,
        "success": false,
        "message": "第3行的学院\"软件工程\"不存在",
        "data": null
    }
    
    出错,解析失败：
    {
        "code": 10000,
        "success": false,
        "message": "解析失败！",
        "data": null
    }



### 导出某个课程用书的审查表

**角色：**

~~~
  管理员
~~~

**Header：**

~~~
Authorization  :  token (登陆获取的token)
~~~

**请求URL：**

    http://localhost:8624/goushushenpixitong/excel/approvalform

**请求方式：**

    GET

**参数类型:**

    |参数       |是否必选   |类型     |说明
    |subjectId	|Y		  |String   |要导出的课程用书的id

**返回示例：**

    弹出保存文件

