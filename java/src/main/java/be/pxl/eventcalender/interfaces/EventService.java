package be.pxl.eventcalender.interfaces;

import be.pxl.eventcalender.dao.DAOUtil;
import be.pxl.eventcalender.models.UserAccount;

import java.sql.SQLException;

/**
 * Created by Maurits on 29-6-2017.
 */
public class EventService {

    public UserAccount findUser(String userName, String password) {
        UserAccount user = new UserAccount();
        try {
            user = DAOUtil.findUser(userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
        }
        return user;
    }
}
