package be.pxl.eventcalender.controllers;

import be.pxl.eventcalender.Util.ServletUtil;
import be.pxl.eventcalender.models.Task;
import be.pxl.eventcalender.models.UserAccount;
import be.pxl.eventcalender.services.EventService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/task")
public class TaskController extends HttpServlet{

    private EventService service = new EventService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String errorMessage;
        List<Task> taskList;
        if (ServletUtil.checkIfUserIsLoggedIn(req)) {
            taskList = service.getAllTasks();
            String message = "Nothing to show here yet.";
            req.setAttribute("message", message);
            req.setAttribute("taskList", taskList);
            req.getRequestDispatcher("/WEB-INF/views/taskOverview.jsp").forward(req, resp);
        } else {
            errorMessage = "Login to have further access.";
            req.getSession().setAttribute("errorMessage", errorMessage);
            resp.sendRedirect("login");
        }
    }
}
