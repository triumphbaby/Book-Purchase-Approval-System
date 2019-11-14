$(function () {
    var url = "http://localhost:8624/goushushenpixitong/deanoffice";
    var laboratory;// 审核意见条目所有
    var used = []; //使用的审核意见条目

    //列表
    $.get(url + "/list",
        {currentPage: 1, pageSize: 5},
        function (json) {
            laboratory = json.data;

            for (var i = laboratory.length - 1; i >= 0; i--) {
                var id = laboratory[i].id;
                var content = laboratory[i].content;
                var remarks = laboratory[i].remarks;

                $(".List table tbody").append(
                    "<tr>" +
                    "<td>" + id + "</td>" +
                    "<td>" + content + "</td>" +
                    "<td>" + remarks + "</td>" +
                    +"<td></td>" +
                    "</tr>"
                );

            }
        });

    //添加或修改
    $("#amLaboratory").click(function () {
        var id = $("input[name='id']").val();
        var content = $("input[name='content']").val();
        var remarks = $("input[name='remarks']").val();

        var isAdd = new Boolean(true);

        for (var i = laboratory.length - 1; i >= 0; i--) {
            if (laboratory[i].id == id) {
                isAdd = false;
                break;
            }
        }

        if (isAdd) {
            $.post(url,
                {id: id, content: content, remarks: remarks},
                function (json) {
                    if (json.code == 200) {
                        alert("添加成功");
                        window.location.href = "DeanOfficeController.html";
                    }
                })
        } else {
            $.ajax({
                type: 'PUT',
                url: url,
                data: {id: id, content: content, remarks: remarks},
                complete: function (json) {
                    console.log(json.responseJSON);
                    if (json.responseJSON.code == 200) {
                        alert("修改成功");
                        window.location.href = "DeanOfficeController.html";
                    }
                }
            });
        }
    });

    //getOne
    $("#getOne").click(function () {
        var id = $("input[name='fixId']").val();
        console.log(id);

        $.get(url,
            {id: id},
            function (json) {
                console.log(json.data);
                var institute = json.data;

                $("input[name='id']").val(institute.id);
                $("input[name='content']").val(institute.content);
                $("input[name='remarks']").val(institute.remarks);
            });

    });

    //删除
    $("#delete").click(function () {
        var id = $("input[name='deleteId']").val();
        // console.log(id);

        $.ajax({
            type: 'DELETE',
            url: url,
            data: {id: id},
            complete: function (json) {
                console.log(json.responseJSON);
                if (json.responseJSON.code == 200) {
                    alert("删除成功");
                    window.location.href = "DeanOfficeController.html";
                }
            }
        });

    });

    //确定采用哪些审核意见（六条）
    $.get(url + "/list",
        {currentPage: 1, pageSize: 1000},
        function (json) {
            laboratory = json.data;

            for (var i = laboratory.length - 1; i >= 0; i--) {
                var id = laboratory[i].id;
                var content = laboratory[i].content;
                var remarks = laboratory[i].remarks;

                if (remarks == "used") {
                    used.push(laboratory[i]);
                    $(".Delete form table tbody").append(
                        "<tr>" +
                        "<td>" + id + "</td>" +
                        "<td>" + content + "</td>" +
                        "<td><input type=\"radio\" name=\"opinion-" + id + "\" value=\"yes\"/></td>" +
                        "<td><input type=\"radio\" name=\"opinion-" + id + "\" value=\"no\"/></td>" +
                        "</tr>"
                    );
                }
            }
        });
    //结果
    $("#opinions").click(function () {
        var result = [];
        for (var i = 0; i < used.length; i++) {
            // console.log($("input[name='opinion-"+used[i].id+"']:radio:checked").val());
            var temp = {};
            temp.id = used[i].id;
            temp.opinion = $("input[name='opinion-" + used[i].id + "']:radio:checked").val();
            result.push(temp);
        }
        var json = JSON.stringify(result);
        var subjectId = $("input[name='subjectId']").val();

        console.log("json:" + json);
        console.log("subjectId:" + subjectId);
        $.post(url + "/opinions",
            {subjectId: subjectId, jsonString: json},
            function (json) {
                if (json.code == 200) {
                    alert("添加成功");
                    window.location.href = "DeanOfficeController.html";
                }
            })
    });

});