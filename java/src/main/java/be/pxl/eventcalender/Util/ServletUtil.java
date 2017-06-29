package be.pxl.eventcalender.Util;

import be.pxl.eventcalender.models.UserAccount;

import javax.servlet.http.*;

/**
 * Created by Maurits on 29-6-2017.
 */
public class ServletUtil {

    private static final String ATT_NAME_USER_NAME = "ATTRIBUTE_FOR_STORE_USER_IN_COOKIE";

    // Store logined user
    public static void storeLogedinUser(HttpSession session, UserAccount logedinUser) {
        session.setAttribute("logedinUser", logedinUser);
    }

    // Get the user information stored in the session
    public static UserAccount getLogedinUser(HttpSession session) {
        UserAccount userAccount = (UserAccount) (session.getAttribute("logedinUser"));
        return userAccount;
    }

    // Store user info in Cookie
    public static void storeUserCookie(HttpServletResponse response, UserAccount user) {
        System.out.println("Store user cookie");
        Cookie cookieUserName = new Cookie(ATT_NAME_USER_NAME, user.getUserName());

        cookieUserName.setMaxAge(24*60*60);
        response.addCookie(cookieUserName);
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
}
