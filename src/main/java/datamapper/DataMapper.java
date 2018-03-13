package datamapper;

import Orders.Order;
import Users.User;
import java.util.ArrayList;
import dbconnector.DBConnector;
import java.sql.PreparedStatement;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataMapper implements DataMapperInterface {

    private DBConnector dbc = new DBConnector();

    public DataMapper(DataSource ds) {
        dbc.setDataSource(ds);
    }

//    @Override
    public ArrayList<Order> getOrders() {
        ArrayList<Order> orders = new ArrayList();

        try {
            dbc.open();

            String sql = "select * from orders";
            ResultSet resultset = dbc.executeQuery(sql);

            while (resultset.next()) {
                int price = resultset.getInt("price");
                int amount = resultset.getInt("amount");
                String top = resultset.getString("top");
                String bottom = resultset.getString("bottom");

                Order o = new Order(top, bottom, amount, price);

                orders.add(o);
            }

            dbc.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orders;
    }
//    @Override
//    public ArrayList<User> getUsers(String un) {
//        ArrayList<User> users = new ArrayList();
//
//        try {
//            dbc.open();
//
//            String sql = "select * from user where username like '%" + un + "%'";
//            ResultSet resultset = dbc.executeQuery(sql);
//
//            while (resultset.next()) {
//                int userid = resultset.getInt("user.user_id");
//                String username = resultset.getString("username");
//                String userpassword = resultset.getString("password");
//
//                User u = new User(userid, username, userpassword);
//
//                users.add(u);
//            }
//
//            dbc.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return users;
//    }
//    @Override
//    public User getUser(int id) {
//        User u = null;
//
//        try {
//            dbc.open();
//
//            String sql = "select * from user where user_id = " + id;
//            ResultSet resultset = dbc.executeQuery(sql);
//
//            while (resultset.next()) {
//                int userid = resultset.getInt("user_id");
//                String username = resultset.getString("username");
//                String userpassword = resultset.getString("password");
//                u = new User(userid, username, userpassword);
//            }
//
//            dbc.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return u;
//    }
//    @Override
//    public User getUser(String name) {
//        try {
//            dbc.open();
//
//            String sql = "select * from user where username = '" + name + "'";
//            ResultSet resultset = dbc.executeQuery(sql);
//
//            while (resultset.next()) {
//                int userid = resultset.getInt("user.user_id");
//                String username = resultset.getString("username");
//                String userpassword = resultset.getString("password");
//
//                return new User(userid, username, userpassword);
//            }
//
//            dbc.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return null;
//    }
//    @Override
//    public boolean deleteUser(int id) {
//        try {
//            dbc.open();
//
//            String sql = "delete from user where user_id = " + id + ";";
//            dbc.executeUpdate(sql);
//
//            dbc.close();
//
//            return true;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return false;
//    }
//    @Override
//    public boolean updateUser(User u) {
//        try {
//            dbc.open();
//
//            String sql = "update user set "
//                    + "username = '" + u.getUsername() + "', "
//                    + "password = '" + u.getPassword() + "', "
//                    + "where user_id = " + u.getId();
//
//            dbc.executeUpdate(sql);
//
//            dbc.close();
//
//            return true;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return false;
//    }
//
//    @Override
    public boolean createUser(User u) {
        try {
            dbc.open();

            String sql = "insert into users values("
                    + "'" + u.getUsername() + "', "
                    + "'" + u.getPassword() + "')";

            dbc.executeUpdate(sql);

            dbc.close();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    public boolean createOrder(Order o) {
        try {
            dbc.open();

            String sql = "insert into orders values("
                    + "'" + o.getTop() + "', "
                    + "'" + o.getBottom() + "', "
                    + "'"+ o.getAmount() + "', "
                    + "'"+ o.getPrice()+ "')";

            dbc.executeUpdate(sql);

            dbc.close();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public User validateUser(String username, String password) {
        User user = null;

        try {
            dbc.open();

            /*
            String sql = "select * from user where username = '" + username + "' and password = '" + password + "'";
            System.out.println("SQL: " + sql);
            ResultSet resultSet = dbc.executeQuery(sql);
             */
            //PreparedStatement
            String sql = "select * from users where username = ? and password = ?";
            PreparedStatement preparedStatement = dbc.preparedStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                user = new User(username, password);
            }

            dbc.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return user;
    }

    public int priceBottom(String bottom) {
        int price = 0;
        try {
            dbc.open();
            String sql = "select price from bottoms where flavor='" + bottom + "'";
            ResultSet rs = dbc.executeQuery(sql);
            if (rs.next()) {
                price = rs.getInt("price");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return price;
    }

    public int priceTop(String top) {
        int price = 0;
        try {
            dbc.open();
            String sql = "select price from tops where flavor='" + top + "'";
            ResultSet rs = dbc.executeQuery(sql);
            if (rs.next()) {
                price = rs.getInt("price");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return price;
    }
}
