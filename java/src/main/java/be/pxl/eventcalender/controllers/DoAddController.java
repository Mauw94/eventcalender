package be.pxl.eventcalender.controllers;

import be.pxl.eventcalender.Util.ServletUtil;
import be.pxl.eventcalender.models.EventBean;
import be.pxl.eventcalender.services.EventService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

@SuppressWarnings("ALL")
@WebServlet("/doAdd")
public class DoAddController extends HttpServlet {

    private EventService service = new EventService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String subject = req.getParameter("subject");
        String description = req.getParameter("description");
        String note = req.getParameter("note");

        // change time
        String t = req.getParameter("time");
        String time = t.substring(0, 5);

        // change date
        String d = req.getParameter("date");
        String date = ServletUtil.convertDateToDayMonthYearFull(d);
        System.out.println(date);

        EventBean event = new EventBean();

        if (description.length() > 0 && description != null && subject.length() > 0 && subject != null) {
            event.setSubject(subject);
            event.setDescription(description);
            event.setNote(note);
            event.setDate(date);
            event.setTime(time);

            service.addEventItem(event);
            resp.sendRedirect("events");
        } else {
            String errorMessage = "Please fill in the required fields";
            req.setAttribute("addError", errorMessage);
            req.getRequestDispatcher("/WEB-INF/views/addItem").forward(req, resp);
        }
    }

}
