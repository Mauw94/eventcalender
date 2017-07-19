package be.pxl.eventcalender.dao;

import be.pxl.eventcalender.models.AgendaItem;
import be.pxl.eventcalender.models.Task;
import be.pxl.eventcalender.models.UserAccount;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
                    user.setId(rs.getInt(1));
                    user.setUserName(rs.getString(2));
                    user.setPassword(rs.getString(3));
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
                System.out.println(user.getUserName() + " " + user.getPassword());
                statement.setString(1, user.getUserName());
                statement.setString(2, user.getPassword());
                updated = statement.execute();
                con.close();
                return updated;
            }
        }
    }

    public static void updateEvent(AgendaItem event, int id) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE event_table SET SUBJECT = ?, DESCRIPTION = ?, NOTE = ?, DATE = ?, TIME = ?, ACTUALDATE = ? WHERE ID = ?";
        try (Connection con = MySQLConnUtils.getMySQLConnection()) {
            try (PreparedStatement statement = con.prepareStatement(sql)) {
                statement.setString(1, event.getSubject());
                statement.setString(2, event.getDescription());
                statement.setString(3, event.getNote());
                statement.setString(4, event.getDate());
                statement.setString(5, event.getTime());
                statement.setString(6, event.getActualDate());
                statement.setInt(7, id);
                statement.executeUpdate();
                statement.close();
                con.close();
            }
        }
    }

    public static void addEventItem(AgendaItem event) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO event_table(SUBJECT, DESCRIPTION, NOTE, TIME, DATE, ACTUALDATE) VALUES(?,?,?,?,?, ?)";
        try (Connection con = MySQLConnUtils.getMySQLConnection()) {
            try (PreparedStatement statement = con.prepareStatement(sql)) {
                statement.setString(1, event.getSubject());
                statement.setString(2, event.getDescription());
                statement.setString(3, event.getNote());
                statement.setString(4, event.getTime());
                statement.setString(5, event.getDate());
                statement.setString(6, event.getActualDate());
                statement.execute();
                con.close();
            }
        }
    }

    public static List<AgendaItem> getAllEvents() throws SQLException, ClassNotFoundException {
        List<AgendaItem> agendaItemList = new ArrayList<>();
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
                    String actualDate = rs.getString(7);
                    AgendaItem event = new AgendaItem();

                    event.setId(id);
                    event.setSubject(subject);
                    event.setDescription(descr);
                    event.setNote(note);
                    event.setDate(date);
                    event.setActualDate(actualDate);
                    event.setTime(time);

                    agendaItemList.add(event);
                }
                return agendaItemList;
            }
        }
    }

    public static List<Task> getAllTasks() throws SQLException, ClassNotFoundException {
        List<Task> taskList = new ArrayList<>();
        String sql = "SELECT * FROM tasks";
        try (Connection con = MySQLConnUtils.getMySQLConnection()) {
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt(1);
                    String subject = rs.getString(2);
                    String descr = rs.getString(3);
                    int duration = rs.getInt(4);
                    int estimated = rs.getInt(5);
                    boolean finshed = rs.getBoolean(6);

                    Task task = new Task();

                    task.setId(id);
                    task.setSubject(subject);
                    task.setDescription(descr);
                    task.setDuration(duration);
                    task.setEstimated(estimated);
                    task.setFinished(finshed);

                    taskList.add(task);
                }
                return taskList;
            }
        }
    }

    public static void deleteEvent(int id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM event_table WHERE ID = ?";
        try (Connection con = MySQLConnUtils.getMySQLConnection()) {
            try (PreparedStatement statement = con.prepareStatement(sql)) {
                statement.setInt(1, id);
                statement.execute();
                con.close();
            }
        }
    }

    public static AgendaItem getEventById(int id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM event_table WHERE ID = ?";
        try (Connection con = MySQLConnUtils.getMySQLConnection()) {
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    AgendaItem event = new AgendaItem();
                    int eventId = rs.getInt(1);
                    String subject = rs.getString(2);
                    String description = rs.getString(3);
                    String note = rs.getString(4);
                    String time = rs.getString(5);
                    String date = rs.getString(6);
                    String actualDate = rs.getString(7);

                    event.setId(eventId);
                    event.setSubject(subject);
                    event.setDescription(description);
                    event.setDate(date);
                    event.setActualDate(actualDate);
                    event.setNote(note);
                    event.setTime(time);
                    return event;
                } else {
                    return null;
                }
            }
        }
    }

    public static String getEventActualDate(int id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT ACTUALDATE FROM event_table WHERE id = ?";
        try (Connection con = MySQLConnUtils.getMySQLConnection()) {
            try (PreparedStatement statement = con.prepareStatement(sql)) {
                statement.setInt(1, id);
                ResultSet rs = statement.executeQuery();
                if (rs.next()) {
                    return rs.getString(1);
                } else {
                    return null;
                }
            }
        }
    }

}
