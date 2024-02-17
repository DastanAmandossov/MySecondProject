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

@WebServlet(value = "/details")
public class DetailsTaskServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long taskId = Long.parseLong(req.getParameter("id"));
        Tasks task = DBManager.getTask(taskId);
        req.setAttribute("task",task);
        req.getRequestDispatcher("details.jsp").forward(req,resp);
    }
}
