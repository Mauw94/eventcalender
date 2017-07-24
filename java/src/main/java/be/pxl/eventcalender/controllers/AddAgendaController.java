package be.pxl.eventcalender.controllers;

import be.pxl.eventcalender.Util.ServletUtil;
import be.pxl.eventcalender.models.AgendaItem;
import be.pxl.eventcalender.services.EventService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/events")
public class AddAgendaController extends HttpServlet {

    private EventService service = new EventService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (ServletUtil.checkIfUserIsLoggedIn(req)) {
            String userName = ServletUtil.getUserNameInCookie(req);
            List<AgendaItem> eventList = service.getAllEvents();
            System.out.println(eventList);
            req.setAttribute("userName", userName);
            req.setAttribute("eventList", eventList);
            req.getRequestDispatcher("/WEB-INF/views/agendaPage.jsp").forward(req, resp);
        } else {
            String errorMessage = "Login to have further access.";
            req.getSession().setAttribute("errorMessage", errorMessage);
            req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
        }
    }
}
