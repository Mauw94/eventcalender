package be.pxl.eventcalender.controllers;

import be.pxl.eventcalender.Util.ServletUtil;
import be.pxl.eventcalender.interfaces.EventService;
import be.pxl.eventcalender.models.UserAccount;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Maurits on 29-6-2017.
 */
@WebServlet("/doLogin")
public class DoLoginController extends HttpServlet {
    private EventService service = new EventService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // get parameters from the view
        // check if password and username are not null
        // check if the user exists in the database
        // create a new useraccount
        // add useracc to session
        // redirect to userinfo to double check user
        // after check in userinfo redirect to homepage

        String password = req.getParameter("password");
        String userName = req.getParameter("username");
        String errorMessage = null;
        UserAccount user;

        /* TODO if user has logged in, you can not log in anymore
         * TODO only log out before u can log in again */

        if (userName != null && password != null && userName.length() > 0 && password.length() > 0) {
            user = service.findUser(userName, password);
            req.getSession().setAttribute("logedinUser", user);
            ServletUtil.storeLogedinUser(req.getSession(), user);
            ServletUtil.storeUserCookie(resp, user);
            resp.sendRedirect("userInfo");
        } else {
            errorMessage = "Please fill in all the fields.";
            req.getSession().setAttribute("errorMessage", errorMessage);
            req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
        }
    }
}
