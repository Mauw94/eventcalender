package be.pxl.eventcalender.services;

import be.pxl.eventcalender.dao.DAOUtil;
import be.pxl.eventcalender.models.AgendaItem;
import be.pxl.eventcalender.models.Task;
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

    public void updateEvent(AgendaItem event, int id) {
        try {
            DAOUtil.updateEvent(event, id);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<AgendaItem> getAllEvents()
    {
        List<AgendaItem> eventList = new ArrayList<>();
        try {
            eventList = DAOUtil.getAllEvents();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return eventList;
    }

    public List<Task> getAllTasks() {
        List<Task> taskList = new ArrayList<>();
        try {
            taskList = DAOUtil.getAllTasks();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return taskList;
    }

    public AgendaItem getEventById(int id) {
        AgendaItem event = new AgendaItem();
        try {
            event = DAOUtil.getEventById(id);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return event;
    }

    public void addEventItem(AgendaItem event) {
        try {
            DAOUtil.addEventItem(event);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void deleteEvent(int id) {
        try {
            DAOUtil.deleteEvent(id);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String getEventActualDate(int id) {
        String date = "";
        try {
            date =DAOUtil.getEventActualDate(id);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return date;
    }
}
