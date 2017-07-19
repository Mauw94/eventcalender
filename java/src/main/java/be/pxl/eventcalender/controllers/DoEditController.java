package be.pxl.eventcalender.controllers;

import be.pxl.eventcalender.Util.ServletUtil;
import be.pxl.eventcalender.models.AgendaItem;
import be.pxl.eventcalender.models.UserAccount;
import be.pxl.eventcalender.services.EventService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/doEdit")
public class DoEditController extends HttpServlet {

    private EventService service = new EventService();

    // TODO get the date field filled in on edit page (take actualdate, convert to date ob)

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String errorMessage;

        if (ServletUtil.checkIfUserIsLoggedIn(req)) {
            String subject = req.getParameter("subject");
            String description = req.getParameter("description");
            String note = req.getParameter("note");
            String d = req.getParameter("date");
            if (d.length() >= 10) {
                String date = ServletUtil.convertDateToDayMonthYearFull(d);
                String time = req.getParameter("time");
                int id = Integer.parseInt(req.getParameter("id"));

                AgendaItem event = new AgendaItem();

                event.setDate(date);
                event.setDescription(description);
                event.setSubject(subject);
                event.setTime(time);
                event.setNote(note);
                event.setId(id);
                event.setActualDate(d);

                service.updateEvent(event, id);
                req.setAttribute("event", event);
                req.getRequestDispatcher("/WEB-INF/views/edited.jsp").forward(req, resp);
            } else {
                errorMessage = "Fill in the date.";
                req.getSession().setAttribute("errprEdit", errorMessage);
                req.getRequestDispatcher("/WEB-INF/views/editAgendaItem.jsp").forward(req, resp);
            }

        } else {
            errorMessage = "Login to have further access.";
            req.getSession().setAttribute("errorMessage", errorMessage);
            req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // nothing here
    }
}
