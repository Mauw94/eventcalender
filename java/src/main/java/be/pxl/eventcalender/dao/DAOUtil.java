package be.pxl.eventcalender.dao;

import be.pxl.eventcalender.models.EventBean;
import be.pxl.eventcalender.models.UserAccount;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Maurits on 29-6-2017.
 */
public class DAOUtil {

    public static UserAccount findUser(String userName, String password) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (Connection con = MySQLConnUtils.getMySQLConnection()) {
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setString(1, userName);
                stmt.setString(2, password);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    UserAccount user = new UserAccount();
                    user.setUserName(rs.getString(1));
                    user.setPassword(rs.getString(2));
                    return user;
                } else {
                    return null;
                }
            }
        }
    }

    public static boolean insertUser(UserAccount user) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO users(username, password) VALUES(?,?)";
        boolean updated;
        try (Connection con = MySQLConnUtils.getMySQLConnection()) {
            try (PreparedStatement statement = con.prepareStatement(sql)) {
                System.out.println(user.getUserName() + " " +user.getPassword());
                statement.setString(1, user.getUserName());
                statement.setString(2, user.getPassword());
                updated = statement.execute();
                con.close();
                return updated;
            }
        }
    }

    public static void updateEvent(EventBean event, int id) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE event_table SET SUBJECT = ?, DESCRIPTION = ?, NOTE = ?, DATE = ?, TIME = ? WHERE ID = ?";
        try (Connection con = MySQLConnUtils.getMySQLConnection()) {
            try (PreparedStatement statement = con.prepareStatement(sql)) {
                statement.setString(1, event.getSubject());
                statement.setString(2, event.getDescription());
                statement.setString(3, event.getNote());
                statement.setString(4, event.getDate());
                statement.setString(5, event.getTime());
                statement.setInt(6, id);
                statement.executeUpdate();
                statement.close();
                con.close();
            }
        }
    }

    public static boolean addEventItem(EventBean event) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO event_table(SUBJECT, DESCRIPTION, NOTE, TIME, DATE) VALUES(?,?,?,?,?)";
        boolean added;
        try (Connection con = MySQLConnUtils.getMySQLConnection()) {
            try (PreparedStatement statement = con.prepareStatement(sql)) {
                statement.setString(1, event.getSubject());
                statement.setString(2, event.getDescription());
                statement.setString(3, event.getNote());
                statement.setString(4, event.getTime());
                statement.setString(5, event.getDate());
                added = statement.execute();
                con.close();
                return added;
            }
        }
    }

    public static List<EventBean> getAllEvents() throws SQLException, ClassNotFoundException {
        List<EventBean> eventBeanList = new ArrayList<>();
        String sql = "SELECT * FROM event_table";
        try (Connection con = MySQLConnUtils.getMySQLConnection()) {
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt(1);
                    String subject = rs.getString(2);
                    String descr = rs.getString(3);
                    String note = rs.getString(4);
                    String time = rs.getString(5);
                    String date = rs.getString(6);
                    EventBean event = new EventBean();

                    event.setId(id);
                    event.setSubject(subject);
                    event.setDescription(descr);
                    event.setNote(note);
                    event.setDate(date);
                    event.setTime(time);

                    eventBeanList.add(event);
                }
                return eventBeanList;
            }
        }
    }

    public static EventBean getEventById(int id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM event_table WHERE ID = ?";
        try (Connection con = MySQLConnUtils.getMySQLConnection()) {
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    EventBean event = new EventBean();
                    int eventId = rs.getInt(1);
                    String subject = rs.getString(2);
                    String description = rs.getString(3);
                    String note = rs.getString(4);
                    String time = rs.getString(5);
                    String date = rs.getString(6);

                    event.setId(eventId);
                    event.setSubject(subject);
                    event.setDescription(description);
                    event.setDate(date);
                    event.setNote(note);
                    event.setTime(time);
                    return event;
                } else {
                    return null;
                }
            }
        }
    }

}
