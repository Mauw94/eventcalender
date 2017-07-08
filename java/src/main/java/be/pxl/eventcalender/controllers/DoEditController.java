package be.pxl.eventcalender.controllers;

import be.pxl.eventcalender.Util.ServletUtil;
import be.pxl.eventcalender.models.EventBean;
import be.pxl.eventcalender.models.UserAccount;
import be.pxl.eventcalender.services.EventService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/doEdit")
public class DoEditController extends HttpServlet {

    private EventService service = new EventService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserAccount user = ServletUtil.getLogedinUser(req.getSession());
        if (user != null) {
            String subject = req.getParameter("subject");
            String description = req.getParameter("description");
            String note = req.getParameter("note");
            String date = req.getParameter("date");
            String time = req.getParameter("time");
            int id = Integer.parseInt(req.getParameter("id"));

            EventBean event = new EventBean();

            event.setDate(date);
            event.setDescription(description);
            event.setSubject(subject);
            event.setTime(time);
            event.setNote(note);
            event.setId(id);

            service.updateEvent(event, id);
            req.setAttribute("event", event);
            req.getRequestDispatcher("/WEB-INF/views/edited.jsp").forward(req, resp);
        } else {
            String errorMessage = "Login to have further access.";
            req.getSession().setAttribute("errorMessage", errorMessage);
            req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // nothing here
    }
}
