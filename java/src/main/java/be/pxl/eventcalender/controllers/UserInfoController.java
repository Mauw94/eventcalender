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

@WebServlet("/userInfo")
public class UserInfoController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String errorMessage;
        if (ServletUtil.checkIfUserIsLoggedIn(req)) {
            UserAccount user = ServletUtil.getLogedinUser(req.getSession());
            req.setAttribute("userInfo", user);
            req.getRequestDispatcher("/WEB-INF/views/loggedIn.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("login");
            errorMessage = "False login information, please re-enter.";
            req.getSession().setAttribute("errorMessage", errorMessage);

        }
    }
}
