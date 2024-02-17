<%@ page import="model.Tasks" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
            integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
            integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <%@include file="navbar.jsp" %>
    <br>
    <%
        Tasks task = (Tasks) request.getAttribute("task");
    %>
    <form action="/UpdateTask" method="post">
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Наименование :</label>
            <input value="<%=task.getName()%>" name="name" type="text" class="form-control" id="exampleInputEmail1"
                   aria-describedby="emailHelp">
        </div>
        <br>
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Описание :</label>
            <input value="<%=task.getDescription()%>" name="description" type="text" class="form-control"
                   id="exampleInputEmail3" aria-describedby="emailHelp">
        </div>
        <br>
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Крайний срок :</label>
            <input value="<%=task.getDeadlineDate()%>" name="deadline" type="date" class="form-control"
                   id="exampleInputEmail2" aria-describedby="emailHelp">
        </div>
        <br>
        <div>
            <label for="exampleInputEmail1" class="form-label">Выполнено :</label>
            <select class="form-select" aria-label="Default select example" name="status">
                <option value="false">Нет</option>
                <option value="true">Да</option>
            </select>
        </div>
        <div class="modal-footer">
            <input type="hidden" name="taskId" value="<%=task.getId()%>">
            <button class="btn btn-primary">Сохранить</button>
        </div>
    </form>
    <form action="/deleteTask" method="post">
        <div class="modal-footer">
            <input type="hidden" name="taskId" value="<%=task.getId()%>">
            <button class="btn btn-danger">Удалить</button>
        </div>
    </form>
</div>
</body>
</html>
