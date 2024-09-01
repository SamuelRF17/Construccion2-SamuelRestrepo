package app;

import app.config.MYSQLConnection;
import app.controller.AdminController;

public class Club_construccion2 {

    public static void main(String[] args) {
        AdminController menu = new AdminController();
        MYSQLConnection connection = new MYSQLConnection();
        try {
            connection.getConnection();
            menu.session();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
