# 接口文档

## 目录：





## 未登录

~~~
{
    "code": 401,
    "success": false,
    "message": "未登录",
    "data": null
}
~~~



## 登陆：

请求URL:

~~~
localhost:8624/goushushenpixitong/login?id=xxx & password=xxx
~~~

示例：

~~~
localhost:8624/goushushenpixitong/login?id=1001&password=hello123456
~~~

请求方式：

* POST

参数类型：

~~~
|参数		 |是否必选 |类型     |说明
|id		  |Y       |string   |用户id
|password |Y	   |string   |密码
~~~

返回示例：

~~~
{
    "code": 200,
    "success": true,
    "message": "请求成功",
    "data": null
}
~~~



## 没有权限

~~~
{
    "code": 403,
    "success": false,
    "message": "没有通过权限验证！",
    "data": null
}
~~~





## 各表的增删改查：

### 增：

请求URL:

~~~
localhost:8624/goushushenpixitong/需要操作的表
~~~

示例：

~~~
localhost:8624/goushushenpixitong/level?name=test01&remarks=null
~~~

请求方式：

* POST

参数类型：

~~~
|参数		 |是否必选 |类型     |说明
表中除主键外的所有属性
~~~

返回示例：

~~~
{
    "code": 200,
    "success": true,
    "message": "请求成功",
    "data": null
}
~~~







### 查：

* **查询所有数据**：

  

请求URL:

~~~
localhost:8624/goushushenpixitong/要操作的表名
~~~

示例：

~~~
localhost:8624/goushushenpixitong/level?name=test01&remarks=null
~~~

请求方式：

* POST

参数类型：

~~~
|参数		 	|是否必选 |类型     |说明
除主键外的操作表的属性
~~~

返回示例：

~~~
{
    "code": 200,
    "success": true,
    "message": "请求成功",
    "data": null
}
~~~

* 查询单条数据：

  

请求URL:

~~~
localhost:8624/goushushenpixitong/book?id=xxx 
~~~

示例：

~~~
localhost:8624/goushushenpixitong/book?id=20180706
~~~

请求方式：

* GET

参数类型：

~~~
|参数		 |是否必选 |类型     |说明
|id		  |Y       |String   |id
~~~

返回示例：

~~~
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
        "remarks": ""
    }
}
~~~

### 改：

请求URL:

~~~
localhost:8624/goushushenpixitong/操作的表
~~~

示例：

~~~
localhost:8624/goushushenpixitong/level?id=9&name=test01&remarks=?
~~~

请求方式：

* PUT

参数类型：

~~~
|参数		 |是否必选 |类型     |说明
操作表的全部属性 
主键不能为空 如id
~~~

返回示例：

~~~
    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    }
主键为空：
    {
        "code": 10000,
        "success": false,
        "message": "id不能为空",
        "data": null
    }

~~~

### 删：

请求URL:

~~~
localhost:8624/goushushenpixitong/操作的表
~~~

示例：

~~~
localhost:8624/goushushenpixitong/level?id=9
~~~

请求方式：

* DELETE

参数类型：

~~~
|参数		 |是否必选 |类型     |说明
|id		  |Y       |string   |id
~~~

返回示例：

~~~
成功：
    {
        "code": 200,
        "success": true,
        "message": "请求成功",
        "data": null
    }
失败:
    {
        "code": 10000,
        "success": false,
        "message": "请求失败",
        "data": null
    }
~~~



## 导入excel：

请求URL:

~~~
localhost:8624/goushushenpixitong/excel/schedule
~~~

示例：

~~~
localhost:8624/goushushenpixitong/excel/schedule
~~~

请求方式：

* POST

参数类型：

~~~
|参数		 |是否必选 |类型     |说明
上传excel文件
~~~

返回示例：

~~~
成功

{
    "code": 200,
    "success": true,
    "message": "请求成功",
    "data": null
}


若数据库不存在某位老师  所有数据不保存   返回：

{
    "code": 10000,
    "success": false,
    "message": "不存在李四，请检查或联系管理员",
    "data": null
}
~~~

## 

