package be.pxl.eventcalender.services;

import be.pxl.eventcalender.dao.DAOUtil;
import be.pxl.eventcalender.models.EventBean;
import be.pxl.eventcalender.models.UserAccount;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public boolean insertUser(UserAccount user) {
        boolean updated = false;
        try {
            updated = DAOUtil.insertUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return updated;
    }

    public List<EventBean> getAllEvents()
    {
        List<EventBean> eventList = new ArrayList<>();
        try {
            eventList = DAOUtil.getAllEvents();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
        }
        return eventList;
    }

}
