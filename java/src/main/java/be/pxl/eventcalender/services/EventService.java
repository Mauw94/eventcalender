package be.pxl.eventcalender.services;

import be.pxl.eventcalender.dao.DAOUtil;
import be.pxl.eventcalender.models.EventBean;
import be.pxl.eventcalender.models.UserAccount;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EventService {

    public UserAccount findUser(String userName, String password) {
        UserAccount user = new UserAccount();
        try {
            user = DAOUtil.findUser(userName, password);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return user;
    }

    public boolean insertUser(UserAccount user) {
        boolean updated = false;
        try {
            updated = DAOUtil.insertUser(user);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return updated;
    }

    public void updateEvent(EventBean event, int id) {
        try {
            DAOUtil.updateEvent(event, id);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<EventBean> getAllEvents()
    {
        List<EventBean> eventList = new ArrayList<>();
        try {
            eventList = DAOUtil.getAllEvents();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return eventList;
    }

    public EventBean getEventById(int id) {
        EventBean event = new EventBean();
        try {
            event = DAOUtil.getEventById(id);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return event;
    }

    public boolean addEventItem(EventBean event) {
        boolean added = false;
        try {
            added = DAOUtil.addEventItem(event);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return added;
    }
}
