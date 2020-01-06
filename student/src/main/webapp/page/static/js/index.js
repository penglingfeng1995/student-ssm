$(function () {
    $("#studentTable").DataTable({
        ajax:{
            url:"/student/student/selectStudent",
            dataSrc:'data'
        },
        columns:[
            {data:"studentId"},
            {data:"studentName"},
            {data:"studentAge"},
            {data:null,defaultContent:"<button class='btn btn-danger'>删除</button><button class='btn btn-primary'>修改</button>"}
        ]
    })
})