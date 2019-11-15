$(function () {
    var url = "http://localhost:8624/goushushenpixitong/institute";
    // 学院列表
    var institutes;

    //列表
    $.get(url + "/list",
        {currentPage: 1, pageSize: 5},
        function (json) {
            institutes = json.data;

            for (var i = institutes.length - 1; i >= 0; i--) {
                var id = institutes[i].id;
                var name = institutes[i].name;
                var remarks = institutes[i].remarks;

                $(".List table tbody").append(
                    "<tr>" +
                    "<td>" + id + "</td>" +
                    "<td>" + name + "</td>" +
                    "<td>" + remarks + "</td>" +
                    +"<td></td>" +
                    "</tr>"
                );
            }
        });

    //添加或修改
    $("#amInstitute").click(function () {
        var id = $("input[name='id']").val();
        var name = $("input[name='name']").val();
        var remarks = $("input[name='remarks']").val();

        var isAdd = new Boolean(true);

        for (var i = institutes.length - 1; i >= 0; i--) {
            if (institutes[i].id == id) {
                isAdd = false;
                break;
            }
        }

        if (isAdd) {
            $.post(url,
                {id: id, name: name, remarks: remarks},
                function (json) {
                    if (json.code == 200) {
                        alert("添加成功");
                        window.location.href = "InstituteController.html";
                    }
                })
        } else {
            $.ajax({
                type: 'PUT',
                url: url,
                data: {id: id, name: name, remarks: remarks},
                complete: function (json) {
                    console.log(json.responseJSON);
                    if (json.responseJSON.code == 200) {
                        alert("修改成功");
                        window.location.href = "InstituteController.html";
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
                $("input[name='name']").val(institute.name);
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
                    window.location.href = "InstituteController.html";
                }
            }
        });

    });

});