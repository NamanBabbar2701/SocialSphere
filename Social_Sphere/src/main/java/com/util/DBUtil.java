package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    private static Connection connection;

    public static Connection getConnection() {
        return connection;
    }

    static {
        try {
            Class.forName("org.h2.Driver");
            System.out.println("Driver Loaded.");

            connection = DriverManager.
                    getConnection("jdbc:h2:C:/Users/naman/OneDrive/Desktop/SocialSphereDB", "sa", "");
            System.out.println("Established Connection.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
    }

}
