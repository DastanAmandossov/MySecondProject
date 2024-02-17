package servlet;
import DBManager.DBManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Tasks;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/tasks")
public class TaskServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Tasks> tasks = DBManager.getAllTasks();
        req.setAttribute("AtrTasks", tasks);
        req.getRequestDispatcher("task.jsp").forward(req,resp);
    }
}
