package be.pxl.eventcalender.controllers;

import be.pxl.eventcalender.Util.ServletUtil;
import be.pxl.eventcalender.models.UserAccount;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/agendaAdd")
public class AddController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (ServletUtil.checkIfUserIsLoggedIn(req)) {
            req.getRequestDispatcher("/WEB-INF/views/agendaCreate.jsp").forward(req, resp);
        } else {
            String errorMessage = "Login to have further access.";
            req.getSession().setAttribute("errorMessage", errorMessage);
            resp.sendRedirect("login");
        }
    }
}
