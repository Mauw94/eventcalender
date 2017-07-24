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

@WebServlet("/deleteTask")
public class DeleteTaskController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (ServletUtil.checkIfUserIsLoggedIn(req)) {
            EventService service = new EventService();
            int id = Integer.parseInt(req.getParameter("id"));
            Task task = service.getTaskById(id);
            req.setAttribute("task", task);
            req.getRequestDispatcher("/WEB-INF/views/deleteConfirmTask.jsp").forward(req, resp);
        } else {
            String errorMessage = "Login to have further access.";
            req.getSession().setAttribute("errorMessage", errorMessage);
            resp.sendRedirect("login");
        }
    }
}
