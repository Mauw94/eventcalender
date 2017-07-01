package be.pxl.eventcalender.dao;

import be.pxl.eventcalender.models.EventBean;
import be.pxl.eventcalender.models.UserAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
                    Date dateTime = rs.getDate(5);

                    EventBean event = new EventBean();
                    event.setId(id);
                    event.setSubject(subject);
                    event.setDescription(descr);
                    event.setNote(note);
                    event.setDateTime(dateTime);

                    eventBeanList.add(event);
                }
                return eventBeanList;
            }
        }
    }

}
