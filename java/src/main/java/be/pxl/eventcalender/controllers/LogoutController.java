package be.pxl.eventcalender.controllers;

import be.pxl.eventcalender.Util.ServletUtil;
import be.pxl.eventcalender.models.UserAccount;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Maurits on 2-7-2017.
 */
@WebServlet("/logout")
public class LogoutController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserAccount user = ServletUtil.getLogedinUser(req.getSession());
        if (user != null) {
            ServletUtil.logoutUser(req.getSession());
            req.getSession().invalidate();
            System.out.println("User logged off.");
            req.getRequestDispatcher("/WEB-INF/views/logout.jsp").forward(req, resp);
        } else {
            String errorMessage = "No user to logout.";
            req.getSession().setAttribute("errorMessage", errorMessage);
            req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
        }
    }
}
