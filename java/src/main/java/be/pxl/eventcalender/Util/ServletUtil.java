package be.pxl.eventcalender.Util;

import be.pxl.eventcalender.models.UserAccount;
import be.pxl.eventcalender.services.EventService;

import javax.servlet.http.*;
import java.rmi.server.ServerCloneException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Maurits on 29-6-2017.
 */
public class ServletUtil {

    private static final String ATT_NAME_USER_NAME = "ATTRIBUTE_FOR_STORE_USER_IN_COOKIE";
    private static String[] months = {"januari", "februari", "maart", "april", "mei", "juni", "juli", "augustus", "september", "oktober",
            "november", "december"};
    private static EventService service = new EventService();

    // Store logined user
    public static void storeLogedinUser(HttpSession session, UserAccount logedinUser) {
        session.setAttribute("logedinUser", logedinUser);
    }

    // Remove logedin user
    public static void logoutUser(HttpSession session) {
        session.removeAttribute("logedinUser");
    }

    // Get the user information stored in the session
    public static UserAccount getLogedinUser(HttpSession session) {
        return (UserAccount) (session.getAttribute("logedinUser"));
    }

    // Store user info in Cookie
    public static void storeUserCookie(HttpServletResponse response, UserAccount user) {
        if (response != null && user != null) {
            System.out.println("Store user cookie");
            Cookie cookieUserName = new Cookie(ATT_NAME_USER_NAME, user.getUserName());

            cookieUserName.setMaxAge(24 * 60 * 60);
            response.addCookie(cookieUserName);
        } else {
            System.out.println("False login information.");
        }
    }

    // Get username saved from Cookie
    public static String getUserNameInCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (ATT_NAME_USER_NAME.equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    // Check if a user is logged in to proceed
    public static boolean checkIfUserIsLoggedIn(HttpServletRequest request)
    {
        UserAccount user = ServletUtil.getLogedinUser(request.getSession());
        return user != null;
    }

    /*
        converts a date to name of the day + day number + name of the month + year
        example: 2017-07-11 TO dinsdag, 07 juli 2017
     */
    public static String convertDateToDayMonthYearFull(String date) {

        // get the day
        String day = date.substring(8, 10);

        // get the month
        String month = date.substring(6, 7);

        // change to int for use in array
        int monthNm = Integer.parseInt(month);

        // get the current year
        int year = Calendar.getInstance().get(Calendar.YEAR);

        // create date string
        String newDate = day + "/" + month + "/" + year;

        // create new date object with newDate and get the name of the day + name of the month
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dt1 = null;
        try {
            dt1 = dateFormat.parse(newDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        DateFormat dayNameFormat = new SimpleDateFormat("EEEE");
        String dayName = dayNameFormat.format(dt1);

        return dayName + ", " + day + " " + months[monthNm - 1] + " " + year;
    }
}
