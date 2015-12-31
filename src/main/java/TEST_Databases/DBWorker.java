package TEST_Databases;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;
import java.util.ArrayList;

public class DBWorker {

    private static final String URL = "jdbc:mysql://localhost:2406/new";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    ArrayList<String> maker;
    ArrayList<String> model;
    ArrayList<String> type;

    DBWorker() {
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            maker = new ArrayList();
            model = new ArrayList();
            type = new ArrayList();

            if (!connection.isClosed()) System.out.println("Успешное подключение к БД!");

            ResultSet res = statement.executeQuery("SELECT * FROM product");
            while (res.next()) {
                maker.add(res.getString("maker"));
                model.add(res.getString("model"));
                type.add(res.getString("type"));
            }

            connection.close();
            if (connection.isClosed()) System.out.println("Соединение с БД Закрыто!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Не удалось загрузить класс драйвера!");
        }
    }
}

