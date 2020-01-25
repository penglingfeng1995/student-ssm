$(function () {
    let currentPage = 1
    loadData(currentPage)

    function goPage(page) {
        loadData(page)
    }

    function loadData(page) {
        currentPage = page
        let size = 5
        let start = (page - 1) * size
        let params = new URLSearchParams()
        params.append("start",start+"")
        params.append("size",size)
        fetch("/student/student/selectStudent", {
            method: "post",
            body: params
        }).then(res => res.json()).then(msg => {
            let students = msg.data.students
            let $tbody = $("tbody")
            $tbody.html("")
            for (let student of students) {
                let $tr = $(`<tr>
                        <td>${student.studentId}</td>
                        <td>${student.studentName}</td>
                        <td>${student.studentAge}</td>
                        <td><button class="btn btn-sm btn-warning">修改</button>&nbsp;<button class="btn btn-sm btn-danger">删除</button></td>
                    </tr>`)
                $tbody.append($tr)
            }

            //加载分页栏
            let count = msg.data.count
            let pages = Math.floor(count / size)
            if(count % size){
                pages++
            }
            let $pageUl = $("#page-ul")
            $pageUl.html("")
            let $pre = $(`<li class="page-item"><a href="#"  class="page-link">上一页</a></li>`)
            if (currentPage===1){
                $pre.addClass("disabled")
            }else{
                $pre.click(() => {
                    loadData(currentPage - 1)
                })
            }
            $pageUl.append($pre)
            for (let i = 1; i <= pages; i++) {
                let $itemPage = $(`<li class="page-item"><a href="#"  class="page-link">${i}</a></li>`)
                if (currentPage === i) {
                    $itemPage.addClass("active")
                }
                $itemPage.click(() => {
                    loadData(i)
                })
                $pageUl.append($itemPage)
            }
            let $next = $(`<li class="page-item"><a href="#"  class="page-link">下一页</a></li>`)
            if (currentPage===pages){
                $next.addClass("disabled")
            }else {
                $next.click(() => {
                    loadData(currentPage + 1)
                })
            }
            $pageUl.append($next)
        })
    }

    $("#add").click(() => {
        let studentName = $("#studentName").val()
        let studentAge = $("#studentAge").val()
        console.log("add:" + studentName + "," + studentAge)
        let params = new URLSearchParams()
        params.append("studentName", studentName)
        params.append("studentAge", studentAge)
        fetch("/student/student/addStudent", {
            method: "post",
            body: params,
        }).then(res => res.json()).then(msg => {
            console.log(msg)
            $("#add-modal").modal("hide")
            $("#studentName").val("")
            $("#studentAge").val("")
            loadData()
        })
    })

})