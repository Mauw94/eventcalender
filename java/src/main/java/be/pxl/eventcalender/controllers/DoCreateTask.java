package be.pxl.eventcalender.controllers;

import be.pxl.eventcalender.Util.ServletUtil;
import be.pxl.eventcalender.models.Task;
import be.pxl.eventcalender.services.EventService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/taskCreate")
public class DoCreateTask extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (ServletUtil.checkIfUserIsLoggedIn(req)) {

            EventService service = new EventService();

            String subject = req.getParameter("subject");
            String description = req.getParameter("description");
            int estimated = Integer.parseInt(req.getParameter("estimated"));
            int duration = Integer.parseInt(req.getParameter("duration"));
            boolean status = Boolean.parseBoolean(req.getParameter("finished"));
            Task task = new Task();

            task.setSubject(subject);
            task.setDescription(description);
            task.setDuration(duration);
            task.setEstimated(estimated);
            task.setFinished(status);

            service.AddTask(task);
            resp.sendRedirect("task");
        } else {
            String errorMessage = "Login to have further access.";
            req.getSession().setAttribute("errorMessage", errorMessage);
            resp.sendRedirect("login");
        }
    }
}
