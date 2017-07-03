package be.pxl.eventcalender.controllers;

import be.pxl.eventcalender.models.EventBean;
import be.pxl.eventcalender.services.EventService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Maurits on 3-7-2017.
 */
@WebServlet("/doAdd")
public class DoAddController extends HttpServlet {

    private EventService service = new EventService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String subject = req.getParameter("subject");
        String description = req.getParameter("description");
        String date = req.getParameter("date");
        String time = req.getParameter("time");
        String note = req.getParameter("note");
        EventBean event = new EventBean();

        event.setSubject(subject);
        event.setDescription(description);
        event.setNote(note);
        event.setDate(date);
        event.setTime(time);

        service.addEventItem(event);
        resp.sendRedirect("events");

    }
}
