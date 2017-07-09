package be.pxl.eventcalender.Util;

import be.pxl.eventcalender.models.UserAccount;

import javax.servlet.http.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Maurits on 29-6-2017.
 */
public class ServletUtil {

    private static final String ATT_NAME_USER_NAME = "ATTRIBUTE_FOR_STORE_USER_IN_COOKIE";

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
        UserAccount userAccount = (UserAccount) (session.getAttribute("logedinUser"));
        return userAccount;
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

    // Get username from Cookie
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

    public static String convertDateToDayMonthYearFull(String date) {
        String[] months = {"januari", "februari", "maart", "april", "mei", "juni", "juli", "augustus", "september", "oktober",
                "november", "december"};
        String day = date.substring(8, 10);
        String month = date.substring(6, 7);
        int monthNm = Integer.parseInt(month);
        int year = Calendar.getInstance().get(Calendar.YEAR);
        String newDate = day + "/" + month + "/" + year;

        // get day of the week name
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dt1 = null;
        try {
            dt1 = dateFormat.parse(newDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        DateFormat format2 = new SimpleDateFormat("EEEE");
        String finalDay = format2.format(dt1);
        String finalDate = finalDay + ", " + day + " " + months[monthNm] + " " + year;

        return finalDate;
    }
}
