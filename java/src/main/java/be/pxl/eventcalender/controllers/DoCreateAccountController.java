package be.pxl.eventcalender.controllers;

import be.pxl.eventcalender.interfaces.EventService;
import be.pxl.eventcalender.models.UserAccount;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Maurits on 1-7-2017.
 */
@WebServlet("/doCreateAccount")
public class DoCreateAccountController extends HttpServlet {

    private EventService service = new EventService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userName = req.getParameter("username");
        String password = req.getParameter("password");
        String errorMessage = null;
        boolean creationFailed;

        UserAccount user = new UserAccount();
        user.setUserName(userName);
        user.setPassword(password);

        if (userName == null || password == null || userName == "" || password == "") {
            creationFailed = true;
            errorMessage = "Failed to create account.";
            req.getSession().setAttribute("accountError", errorMessage);
            req.setAttribute("creationFailed", creationFailed);
            req.getRequestDispatcher("/WEB-INF/views/createAccount.jsp").forward(req, resp);
        } else {
            creationFailed = false;
            req.setAttribute("creationFailed", creationFailed);
            service.insertUser(user);
            req.getRequestDispatcher("/WEB-INF/views/accountCreatedSuccess.jsp").forward(req, resp);
        }
    }

}
