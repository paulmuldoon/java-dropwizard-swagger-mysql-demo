package org.kainos.ea.db;

import org.kainos.ea.cli.Product;
import org.kainos.ea.cli.ProductRequest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    public Product getProductByID(int id) throws SQLException {
        //attempt to connect to the database
            Connection c = DatabaseConnector.getConnection();
            Statement st = c.createStatement();

            //sql result set queries the product table
            ResultSet rs = st.executeQuery("SELECT ProductID, Name, Description, Price FROM `Product`");

            while (rs.next()) {
                //loop through the product records in the table
                Product product = new Product (
                        rs.getInt("ProductID"),
                        rs.getString("Name"),
                        rs.getString("Description"),
                        rs.getDouble("Price")
                );

                return product;

            }

            return null;

    }

    public int createProduct(ProductRequest product) throws SQLException {
        Connection c = DatabaseConnector.getConnection();

        String insertStatement = "INSERT INTO Product (Name, Description, Price) VALUES (?,?,?)";

        PreparedStatement st = c.prepareStatement(insertStatement, Statement.RETURN_GENERATED_KEYS);

        st.setString(1, product.getName());
        st.setString(2, product.getDescription());
        st.setDouble(3, product.getPrice());

        st.executeUpdate();

        ResultSet rs = st.getGeneratedKeys();

        if (rs.next()) {
            return rs.getInt(1);
        }

        return -1;


    }

    public void updateProduct(int id, ProductRequest product) throws SQLException {
        Connection c = DatabaseConnector.getConnection();

        String updateStatement = "UPDATE Product SET Name = ?, Description = ?, Price = ? WHERE ProductID = ?";

        PreparedStatement st = c.prepareStatement(updateStatement);

        st.setString(1, product.getName());
        st.setString(2, product.getDescription());
        st.setDouble(3, product.getPrice());
        st.setInt(4, id);

        st.executeUpdate();
    }
}
