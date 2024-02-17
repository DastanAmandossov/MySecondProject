package servlet;

import DBManager.DBManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Tasks;

import java.io.IOException;

@WebServlet(value = "/UpdateTask")

public class UpdateServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String taskId = req.getParameter("taskId");
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        String deadline = req.getParameter("deadline");
        String status = req.getParameter("status");
        System.out.println(taskId);
        System.out.println(name);
        System.out.println(description);
        System.out.println(deadline);
        System.out.println(status);

        Tasks task = DBManager.getTask(Long.parseLong(taskId));


            task.setName(name);
            task.setDescription(description);
            task.setDeadlineDate(deadline);
            task.setStatus(Boolean.parseBoolean(status));
            task.setId(Long.parseLong(taskId));
            DBManager.updateTask(task);

        resp.sendRedirect("/tasks");
    }
}
