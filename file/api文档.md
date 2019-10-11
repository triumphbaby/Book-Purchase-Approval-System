# 接口文档

## 目录：
[1、查询所有学期信息](#1查询所有学期信息)<br/>
[2、查询学期单条记录](#2查询学期单条记录)<br/>
[3、添加学期记录](#3添加学期记录)<br/>
[4、更新学期记录](#4更新学期记录)<br/>
[5、删除学期记录](#5删除学期记录)<br/>
[6、分页获取开课教学单位审核条目](#6分页获取开课教学单位审核条目)<br/>
[7、获取单条审核条目记录](#7获取单条审核条目记录)<br/>
[8、添加开课教学单位审核结果](#8添加开课教学单位审核结果)<br/>
[9、获取科研室审核结果](#9获取科研室审核结果)<br/>*
[10、添加审核条目](#10添加审核条目)<br/>
[11、更新条目信息](#11更新条目信息)<br/>
[12、删除条目信息](#12更新条目信息)<br/>
[13、查询所有课程信息](#13查询所有课程信息)<br/>
[14、查询单条记录](#14查询单条记录)<br/>
[15、添加](#15添加)<br/>
[16、更新](#16更新)<br/>
[17、删除](#17删除)<br/>
[18、查询所有课程用书信息](#18查询所有课程用书信息)<br/>
[19、查询单条记录](#19查询单条记录)<br/>
[20、添加](#20添加)<br/>
[21、更新](#21更新)<br/>
[22、删除](#22删除)<br/>
[23、查询所有书本记录](#23查询所有书本记录)<br/>
[24、查询单条记录](#24查询单条记录)<br/>
[25、添加书本记录](#25添加书本记录)<br/>
[26、更新](#26更新)<br/>
[27、删除](#27删除)<br/>
[28、分页获取教务处审核条目](#28分页获取教务处审核条目)<br/>
[29、获取单条审核条目记录](#29获取单条审核条目记录)<br/>
[30、获取科研室审核结果](#30获取科研室审核结果)<br/>*
[31、添加审核条目](#31添加审核条目)<br/>
[32、添加教务处审核结果](#32添加教务处审核结果)<br/>*
[33、更新条目信息](#33更新条目信息)<br/>
[34、删除条目](#34删除条目)<br/>
[35、分页查询学院列表](#35分页查询学院列表)<br/>
[36、通过编号查询学院](#36通过编号查询学院)<br/>
[37、注册学院](#37注册学院)<br/>
[38、修改学院信息](#38修改学院信息)<br/>
[39、删除学院](#39删除学院)<br/>
[40、分页获取教研室审核条目](#40分页获取教研室审核条目)<br/>
[41、获取单条审核条目记录](#41获取单条审核条目记录)<br/>
[42、获取科研室审核结果](#42获取科研室审核结果)<br/>*
[43、添加审核条目](#43添加审核条目)<br/>
[44、添加教研室审核结果](#44添加教研室审核结果)<br/>*
[45、更新条目信息](#45更新条目信息)<br/>
[46、删除条目](#46删除条目)<br/>
[47、分页查询等级记录](#47注册学院)<br/>
[48、通过id获取单条记录](#48注册学院)<br/>
[49、添加](#49注册学院)<br/>
[50、修改](#50修改)<br/>
[51、删除](#51删除)<br/>
[52、分页查询专业记录](#52分页查询专业记录)<br/>
[53、查询单条专业记录](#53查询单条专业记录)<br/>
[54、添加专业](#54添加专业)<br/>
[55、更新记录](#55更新记录)<br/>
[56、删除专业](#56删除专业)<br/>
[57、查询所有人员的角色信息](#57查询所有人员的角色信息)<br/>
[58、查询某个工号的所有角色信息](#58查询某个工号的所有角色信息)<br/>
[59、添加角色记录](#59添加角色记录)<br/>
[60、更新信息](#60更新信息)<br/>
[61、查询所有人员信息](#61查询所有人员信息)<br/>
[62、查询单条记录](#62查询单条记录)<br/>
[63、添加人员](#63添加人员)<br/>
[64、更新信息](#64更新信息)<br/>
[65、删除人员](#65删除人员)<br/>
>

## 1、查询所有学期信息
     
### 请求URL：
	http://localhost:8624/goushushenpixitong/term/list
	
### 请求方式：
	GET
	
### 参数类型：
	|参数		    |是否必选    |类型    |说明
	|currentPage    |Y          |int     |当前页数
    |pageSize       |Y          |int     |每页显示的总记录数
### 返回示例：

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

## 2、查询学期单条记录

### 请求URL：
	http://localhost:8624/goushushenpixitong/term
	
### 请求方式：
	GET
	
### 参数类型：
	|参数     |是否必选    |类型    |说明
    |id       |Y          |int     |学期ID
### 返回示例：
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

## 3、添加学期记录

### 请求URL：
	http://localhost:8624/goushushenpixitong/term
	
### 请求方式：
	POST
	
### 参数类型：
	|参数     |是否必选  |类型     |说明|
	|id       |Y        |int      |学期ID|
	|name     |Y        |string   |学期名称|
    |remarks  |N        |string   |备注|
### 返回示例：

	{
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    }

## 4、更新学期记录

### 请求URL：
	http://localhost:8624/goushushenpixitong/term
	
### 请求方式：
    PUT

### 参数类型：query
	|参数     |是否必选  |类型     |说明|
	|id       |Y        |int      |学期ID|
	|name     |Y        |string   |学期名称|
    |remarks  |N        |string   |备注|
### 返回示例：
	{
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    }

## 5、删除学期记录
     
### 请求URL：
	http://localhost:8624/goushushenpixitong/term

### 请求方式：
	DELETE	
	
### 参数类型：
	|参数     |是否必选    |类型    |说明
    |id       |Y          |int     |学期ID   
### 返回示例：

    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    }

## 6、分页获取开课教学单位审核条目
     
### 请求URL：
	http://localhost:8624/goushushenpixitong/teachingunit/list
	
### 请求方式：
	GET
	
### 参数类型:
	|参数		    |是否必选    |类型    |说明
	|currentPage    |Y          |int     |当前页数
    |pageSize       |Y          |int     |每页显示的总记录数
### 返回示例：

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

## 7、获取单条审核条目记录
     
### 请求URL：
	http://localhost:8624/goushushenpixitong/teachingunit

### 请求方式：
	GET

### 参数类型:

	|参数     |是否必选   |类型     |说明
	|id       |Y         |int      |ID

### 返回示例：
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
        
## 8、添加开课教学单位审核结果
     
### 请求URL：
	http://localhost:8624/goushushenpixitong/teachingunit

### 请求方式：
	POST

### 参数类型:

	|参数		|是否必选 |类型     |说明
	|id         |Y       |int      |ID
	|content    |Y       |string   |内容
    |remarks    |N       |string    |备注
### 返回示例：

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

#### 返回示例：
	
      


### 10、添加审核条目

#### 请求URL：
	http://localhost:8624/goushushenpixitong/teachingunit

#### 请求方式：
	POST
### 参数类型:
	|参数		|是否必选 |类型     |说明
	|id         |Y       |int      |ID
	|content    |Y       |string   |内容
    |remarks    |N       |string    |备注

#### 返回示例：
    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    }

### 11、更新条目信息
    
#### 请求URL：
    http://localhost:8624/goushushenpixitong/teachingunit
    
#### 请求方式：
    PUT
    
### 参数类型:
    |参数		|是否必选 |类型     |说明
    |id         |Y       |int      |ID
    |content    |Y       |string   |内容
    |remarks    |N       |string    |备注
    
#### 返回示例：
    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    }
### 12、删除条目信息
    
#### 请求URL：
    http://localhost:8624/goushushenpixitong/teachingunit
    
#### 请求方式：
    DELETE
### 参数类型:
    |参数		|是否必选 |类型     |说明
    |id         |Y       |int      |ID
    
#### 返回示例：
    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    }
    
### 13、查询所有课程信息

#### 请求URL：
    http://localhost:8624/goushushenpixitong/course/list
    
#### 请求方式：
    GET
    
### 参数类型:
	|参数		    |是否必选    |类型    |说明
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

#### 请求URL：
    http://localhost:8624/goushushenpixitong/course
    
#### 请求方式：
    GET
### 参数类型:
    |参数		|是否必选  |类型     |说明
    |id         |Y        |int      |ID
    |termId     |Y        |int      |学期ID
#### 返回示例：
    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": {
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
    }
   
### 15、添加

#### 请求URL：
    http://localhost:8624/goushushenpixitong/course
    
#### 请求方式：
    POST
### 参数类型:
    |参数		  |是否必选 |类型      |说明
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

#### 请求URL：
    http://localhost:8624/goushushenpixitong/course
    
#### 请求方式：
    PUT
    
### 参数类型:
    |参数		  |是否必选 |类型      |说明
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

#### 请求URL：
    http://localhost:8624/goushushenpixitong/course
    
#### 请求方式：
    DELETE
    
### 参数类型:
    |参数		|是否必选 |类型     |说明
    |id         |Y       |int      |ID
#### 返回示例：

    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    } 
### 18、查询所有课程用书信息

#### 请求URL：
    http://localhost:8624/goushushenpixitong/subject/list
    
#### 请求方式：
    GET
    
### 参数类型:
	|参数		    |是否必选    |类型    |说明
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

#### 请求URL：
    http://localhost:8624/goushushenpixitong/subject
    
#### 请求方式：
    GET
    
### 参数类型:
    |参数		|是否必选  |类型     |说明
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

#### 请求URL：
    http://localhost:8624/goushushenpixitong/subject
    
#### 请求方式：
    POST
    
### 参数类型:
    |参数		  |是否必选 |类型      |说明
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

#### 请求URL：
    http://localhost:8624/goushushenpixitong/subject
    
#### 请求方式：
    PUT
    
### 参数类型:
     |参数		   |是否必选 |类型      |说明
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

#### 请求URL：
    http://localhost:8624/goushushenpixitong/subject
    
#### 请求方式：
    DELETE
    
### 参数类型:
    |参数		|是否必选 |类型     |说明
    |id         |Y       |int      |ID
    
#### 返回示例：
    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
### 23、查询所有书本记录

#### 请求URL：
    http://localhost:8624/goushushenpixitong/book/list
    
#### 请求方式：
    GET
    
### 参数类型:
 	|参数		    |是否必选    |类型    |说明
 	|currentPage    |Y          |int     |当前页数
    |pageSize       |Y          |int     |每页显示的总记录数
    
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

#### 请求URL：
    http://localhost:8624/goushushenpixitong/book
    
#### 请求方式：
    GET
    
### 参数类型:
    |参数		|是否必选 |类型        |说明
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

#### 请求URL：
    http://localhost:8624/goushushenpixitong/book
    
#### 请求方式：
    POST
    
### 参数类型:
    |参数		  |是否必选  |类型       |说明
    |id           |Y        |string     |图书编号
    |name         |Y        |string     |图书名字
    |author       |Y        |string     |作者
    |publisher    |Y        |string     |出版社
    |publishDate  |N        |string     |出版时间
    |edition      |Y        |int        |版次
    |nation       |N        |string     |所属国家
    |type         |N        |string     |类型
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

#### 请求URL：
    http://localhost:8624/goushushenpixitong/book
    
#### 请求方式：
    PUT
### 参数类型:
    |参数		  |是否必选  |类型       |说明
    |id           |Y        |string     |图书编号
    |name         |Y        |string     |图书名字
    |author       |Y        |string     |作者
    |publisher    |Y        |string     |出版社
    |publishDate  |N        |string     |出版时间
    |edition      |Y        |int        |版次
    |nation       |N        |string     |所属国家
    |type         |N        |string     |类型
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

#### 请求URL：
    http://localhost:8624/goushushenpixitong/book
    
#### 请求方式：
    DELETE
    
### 参数类型:
    |参数		|是否必选 |类型      |说明
    |id         |Y       |string    |图书ID
    
#### 返回示例：
    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    } 
### 28、分页获取教务处审核条目

#### 请求URL：
    http://localhost:8624/goushushenpixitong/deanoffice/list
    
#### 请求方式：
    GET
    
### 参数类型:
 	|参数		    |是否必选    |类型    |说明
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

#### 请求URL：
    http://localhost:8624/goushushenpixitong/deanoffice
    
#### 请求方式：
    GET
    
### 参数类型:
    |参数		|是否必选 |类型        |说明
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

#### 请求URL：
    http://localhost:8624/goushushenpixitong/book
    
#### 请求方式：
    POST
    
### 参数类型:
   
   
   
   
### 31、添加审核条目

#### 请求URL：
    http://localhost:8624/goushushenpixitong/deanoffice
    
#### 请求方式：
    POST
    
### 参数类型:
    |参数		  |是否必选  |类型       |说明
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
    http://localhost:8624/goushushenpixitong/book
    
#### 请求方式：
    PUT
    
### 参数类型:
  
  
  
  
#### 返回示例：
    
    
    
    
    
### 33、更新条目信息

#### 请求URL：
    http://localhost:8624/goushushenpixitong/deanoffice
    
#### 请求方式：
    PUT
    
### 参数类型:
    |参数		  |是否必选  |类型       |说明
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

#### 请求URL：
    http://localhost:8624/goushushenpixitong/deanoffice
    
#### 请求方式：
    DELETE
### 参数类型:
    |参数		|是否必选 |类型      |说明
    |id         |Y       |int       |图书ID
    
#### 返回示例：
    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    } 

### 35、分页查询学院列表

#### 请求URL：
    http://localhost:8624/goushushenpixitong/institute/list
    
#### 请求方式：
    GET
### 参数类型:
	|参数		    |是否必选    |类型    |说明
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
### 35、分页查询学院列表

#### 请求URL：
    http://localhost:8624/goushushenpixitong/institute/list
    
#### 请求方式：
    GET
    
### 参数类型:
	|参数		    |是否必选    |类型    |说明
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

#### 请求URL：
    http://localhost:8624/goushushenpixitong/institute
    
#### 请求方式：
    GET
    
### 参数类型:
    |参数		|是否必选 |类型     |说明
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

#### 请求URL：
    http://localhost:8624/goushushenpixitong/institute
    
#### 请求方式：
    POST
    
### 参数类型:
    |参数		|是否必选 |类型     |说明
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
    
### 38、修改学院信息

#### 请求URL：
    http://localhost:8624/goushushenpixitong/institute
    
#### 请求方式：
    PUT
    
### 参数类型:
    |参数		|是否必选 |类型     |说明
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

#### 请求URL：
    http://localhost:8624/goushushenpixitong/institute
    
#### 请求方式：
    DELETE
### 参数类型:
    |参数		|是否必选 |类型     |说明
    |id         |Y       |string   |ID
    
#### 返回示例：

    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    }

### 40、分页获取教研室审核条目

#### 请求URL：
    http://localhost:8624/goushushenpixitong/laboratory/list
    
#### 请求方式：
    GET
    
### 参数类型:
	|参数		    |是否必选    |类型    |说明
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

#### 请求URL：
    http://localhost:8624/goushushenpixitong/laboratory
    
#### 请求方式：
    GET
    
### 参数类型:
    |参数		|是否必选 |类型     |说明
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

#### 请求URL：
   
    
#### 请求方式：
    GET
### 参数类型:
    |参数		|是否必选 |类型     |说明
    |id         |Y       |string      |ID
    
#### 返回示例：



### 43、添加审核条目

#### 请求URL：
    http://localhost:8624/goushushenpixitong/laboratory
    
#### 请求方式：
    POST
    
### 参数类型:
    |参数		|是否必选 |类型     |说明
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
   
   
#### 请求方式：
    POST
    
### 参数类型:
    |参数		|是否必选 |类型     |说明
    |id         |Y       |string   |ID
    |name       |Y       |string   |内容
    |remarks    |N       |string    |备注
    
#### 返回示例：
    
    
    
    
### 45、更新条目信息

#### 请求URL：
    http://localhost:8624/goushushenpixitong/laboratory
    
#### 请求方式：
    PUT
    
### 参数类型:
    |参数		|是否必选 |类型     |说明
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

#### 请求URL：
    http://localhost:8624/goushushenpixitong/laboratory
    
#### 请求方式：
    DELETE
    
### 参数类型:
    |参数		|是否必选 |类型     |说明
    |id         |Y       |int      |ID 
#### 返回示例：

    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    }
### 47、分页查询等级记录

#### 请求URL：
    http://localhost:8624/goushushenpixitong/level/list
    
#### 请求方式：
    GET
    
### 参数类型:
	|参数		    |是否必选    |类型    |说明
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

#### 请求URL：
    http://localhost:8624/goushushenpixitong/level
    
#### 请求方式：
    GET
    
### 参数类型:
    |参数		|是否必选   |类型      |说明
    |id         |Y         |int   |ID
    
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
    
### 49、添加

#### 请求URL：
    http://localhost:8624/goushushenpixitong/level
    
#### 请求方式：
    POST
    
### 参数类型:
    |参数		  |是否必选 |类型      |说明
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

#### 请求URL：
    http://localhost:8624/goushushenpixitong/level
    
#### 请求方式：
    PUT
    
### 参数类型:
    |参数		  |是否必选 |类型      |说明
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
    
#### 请求URL：
    http://localhost:8624/goushushenpixitong/level
        
#### 请求方式：
    DELETE
    
### 参数类型:
    |参数		|是否必选   |类型     |说明
    |id         |Y         |int      |ID
        
#### 返回示例：
    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    }
### 52、分页查询专业记录

#### 请求URL：
    http://localhost:8624/goushushenpixitong/major/list
    
#### 请求方式：
    GET
    
### 参数类型:
	|参数		    |是否必选    |类型    |说明
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

#### 请求URL：
    http://localhost:8624/goushushenpixitong/major
    
#### 请求方式：
    GET
    
### 参数类型:
    |参数		|是否必选   |类型      |说明
    |id         |Y          |string   |ID
    
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

#### 请求URL：
    http://localhost:8624/goushushenpixitong/major
    
#### 请求方式：
    POST
    
### 参数类型:
    |参数		  |是否必选 |类型      |说明
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

#### 请求URL：
    http://localhost:8624/goushushenpixitong/major
    
#### 请求方式：
    PUT
    
### 参数类型:
    |参数		  |是否必选 |类型      |说明
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
    
#### 请求URL：
    http://localhost:8624/goushushenpixitong/major
        
#### 请求方式：
    DELETE
### 参数类型:
    |参数		|是否必选   |类型     |说明
    |id         |Y         |string   |ID
        
#### 返回示例：
    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    }
### 57、查询所有人员的角色信息

#### 请求URL：
    http://localhost:8624/goushushenpixitong/role/list
    
#### 请求方式：
    GET
    
### 参数类型:
 	|参数		    |是否必选    |类型    |说明
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

#### 请求URL：
    http://localhost:8624/goushushenpixitong/role
    
#### 请求方式：
    GET
    
### 参数类型:
    |参数		  |是否必选 |类型      |说明
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

#### 请求URL：
    http://localhost:8624/goushushenpixitong/role
    
#### 请求方式：
    POST
    
### 参数类型:
    |参数		  |是否必选 |类型      |说明
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
### 60、更新信息

#### 请求URL：
    http://localhost:8624/goushushenpixitong/role
    
#### 请求方式：
    PUT
    
### 参数类型:
     |参数		  |是否必选 |类型      |说明
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
    
    
### 61、查询所有人员信息
    
#### 请求URL：
    http://localhost:8624/goushushenpixitong/staff/list
        
#### 请求方式：
    GET
    
### 参数类型:
	|参数		    |是否必选    |类型    |说明
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
      
### 62、查询单条记录
     
 #### 请求URL：
     http://localhost:8624/goushushenpixitong/major
         
 #### 请求方式：
     GET
     
 ### 参数类型:
     |参数		|是否必选   |类型     |说明
     |id         |Y         |string   |ID
         
#### 返回示例：

    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
         }  
      
### 63、添加人员
    
#### 请求URL：
    http://localhost:8624/goushushenpixitong/staff
        
#### 请求方式：
    POST
    
### 参数类型:
    |参数		  |是否必选   |类型     |说明
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

### 64、更新信息
    
#### 请求URL：
    http://localhost:8624/goushushenpixitong/major
        
#### 请求方式：
    PUT
    
### 参数类型:
    |参数		  |是否必选   |类型     |说明
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
        
### 65、删除人员
    
#### 请求URL：
    http://localhost:8624/goushushenpixitong/major
        
#### 请求方式：
    DELETE
    
### 参数类型:
    |参数		|是否必选   |类型     |说明
    |id         |Y         |string   |ID
        
#### 返回示例：
    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    }
