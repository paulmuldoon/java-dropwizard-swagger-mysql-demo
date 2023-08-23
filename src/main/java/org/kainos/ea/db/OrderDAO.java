package org.kainos.ea.db;

import org.kainos.ea.cli.Order;
import org.kainos.ea.cli.OrderRequest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {
        public Order getOrderById(int id) throws SQLException {

                Connection c = DatabaseConnector.getConnection();
                Statement st = c.createStatement();

                ResultSet rs = st.executeQuery("SELECT OrderID, CustomerID, OrderDate FROM `Order`");

                while (rs.next()) {
                    Order order = new Order (
                            rs.getInt("OrderID"),
                            rs.getInt("CustomerID"),
                            rs.getDate("OrderDate")
                    );

                    return order;

                }

                return null;

        }

        public Order updateOrder(int id, OrderRequest order) throws SQLException {

            Connection c = DatabaseConnector.getConnection();

            String updateStatement = "UPDATE Order SET OrderDate WHERE OrderID = ?";

            PreparedStatement st = c.prepareStatement(updateStatement);

            st.setDate(1, order.getOrderdate());
            st.setInt(2, order.getCustomerid());
            st.setInt(4, id);

            st.executeUpdate();


        }
    }
