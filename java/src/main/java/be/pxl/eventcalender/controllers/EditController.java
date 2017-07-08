package be.pxl.eventcalender.controllers;

import be.pxl.eventcalender.models.EventBean;
import be.pxl.eventcalender.services.EventService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Mauwi on 7-7-2017.
 */
@WebServlet("/edit")
public class EditController extends HttpServlet {

    private EventService service = new EventService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        EventBean event = service.getEventById(id);
        req.setAttribute("event", event);
        req.getRequestDispatcher("/WEB-INF/views/editItem.jsp").forward(req ,resp);
    }
}
