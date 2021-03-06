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

@WebServlet("/agendaDetails")
public class AgendaDetailsController extends HttpServlet {

    private EventService service = new EventService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String errorMessage;
        if (ServletUtil.checkIfUserIsLoggedIn(req)) {
            int id = Integer.parseInt(req.getParameter("id"));
            if (id > 0) {
                AgendaItem event = service.getEventById(id);
                if (event != null) {
                    req.setAttribute("event", event);
                    req.getRequestDispatcher("/WEB-INF/views/agendaDetails.jsp").forward(req, resp);
                } else { // elseif event is null
                    errorMessage = "No event found.";
                    req.getSession().setAttribute("eventError", errorMessage);
                    resp.sendRedirect("events");
                }
            } else {   // elseif id is null
                errorMessage = "No id given.";
                req.getSession().setAttribute("eventError", errorMessage);
                resp.sendRedirect("events");
            }
        } else {
            errorMessage = "Login to have further access.";
            req.getSession().setAttribute("errorMessage", errorMessage);
            resp.sendRedirect("login");
        }
    }
}
