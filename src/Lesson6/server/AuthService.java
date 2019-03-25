package Lesson6.server;

import java.sql.*;
import java.util.List;

class AuthService {

    // Объект, в котором будет храниться соединение с БД
    private static Connection connection;
    // Statement используется для того, чтобы выполнить sql-запрос
    private static Statement stmt;

    static void connect() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
            //Выполняем подключение к базе данных, "jdbc:sqlite:userDB.db" - адрес подключения
            connection = DriverManager.getConnection("jdbc:sqlite:userDB.db");
            stmt = connection.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    static String getNickByLoginAndPass(String login, String pass) throws SQLException {
        String sql = String.format("SELECT nickname FROM main where " +
                "login = '%s' and password = '%s'", login, pass);
        // В resultSet будет храниться результат нашего запроса,
        // который выполняется командой statement.executeQuery()
        ResultSet rs = stmt.executeQuery(sql);

        if (rs.next()) {
            return rs.getString(1);
        }
        return null;
    }

    /*
    // --------Заполнение таблицы--------
	public static void WriteDB() throws SQLException
	{statmt.execute("INSERT INTO 'users' ('name', 'phone') VALUES ('Masha', 456123); ");}
    */

    static void saveBlacklist(String idNick, List<String> blacklist) throws SQLException {
        for (String ignoreNick : blacklist) {
            String sql = String.format("INSERT INTO 'blacklist" + idNick + "' ('ignoreNick') VALUES('" + ignoreNick + "');");
            stmt.execute(sql);
        }
    }

    static void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
