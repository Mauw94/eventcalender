package be.pxl.eventcalender.controllers;

import be.pxl.eventcalender.Util.ServletUtil;
import be.pxl.eventcalender.models.UserAccount;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Maurits on 29-6-2017.
 */
@WebServlet("/userInfo")
public class UserInfoController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        String errorMessage = null;

        // check if a user has logged in
        UserAccount logedinUser = ServletUtil.getLogedinUser(session);

        // if no user was found, return to login page
        if (logedinUser == null) {
            resp.sendRedirect("login");
            errorMessage = "False login information, please re-enter.";
            req.getSession().setAttribute("errorMessage", errorMessage);
        } else {
            // Store user in request attribute
            req.setAttribute("userInfo", logedinUser);

            // forward to home page
            req.getRequestDispatcher("/WEB-INF/views/loggedIn.jsp").forward(req, resp);
        }
    }
}
