package org.kainos.ea.api;

import org.kainos.ea.cli.Product;
import org.kainos.ea.cli.ProductRequest;
import org.kainos.ea.client.*;
import org.kainos.ea.core.ProductValidator;
import org.kainos.ea.db.ProductDAO;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ProductService {
    private ProductDAO productDao = new ProductDAO();
    public Product getProductByID(int id) throws FailedToGetProductException, ProductDoesNotExistException {
        try {
            Product product = productDao.getProductByID(id);

            if (product == null){
                throw new ProductDoesNotExistException();
            }

            return product;
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToGetProductException();
        }
    }

    private ProductDAO productDAO = new ProductDAO();
    private ProductValidator productValidator = new ProductValidator();

    public int createProduct(ProductRequest product) throws FailedToCreateProductException {
        try {

            int id = productDao.createProduct(product);

            if (id == -1) {
                throw new FailedToCreateProductException();
            }

            return id;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new FailedToCreateProductException();
        }
    }

    public void updateProduct(int id, ProductRequest product) throws InvalidProductException, ProductDoesNotExistException, FailedToUpdateProductException {
        try {
            String validation = productValidator.isValidProduct(product);

            if (validation != null) {
                throw new InvalidProductException();
            }

            Product productToUpdate = productDAO.getProductByID(id);

            if (productToUpdate == null) {
                throw new ProductDoesNotExistException();
            }

            productDao.updateProduct(id, product);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new FailedToUpdateProductException();
        }

    }
}
