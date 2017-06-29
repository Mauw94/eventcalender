package be.pxl.eventcalender.dao;

import be.pxl.eventcalender.models.EventBean;
import be.pxl.eventcalender.models.UserAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    public List<EventBean> getAllEvents() throws SQLException {
        return null;
    }

}
