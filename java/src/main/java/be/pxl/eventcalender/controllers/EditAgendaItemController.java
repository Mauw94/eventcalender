package be.pxl.eventcalender.controllers;

import be.pxl.eventcalender.models.AgendaItem;
import be.pxl.eventcalender.services.EventService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/edit")
public class EditAgendaItemController extends HttpServlet {

    private EventService service = new EventService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        AgendaItem event = service.getEventById(id);
        req.setAttribute("event", event);
        req.getRequestDispatcher("/WEB-INF/views/editAgendaItem.jsp").forward(req ,resp);
    }
}
