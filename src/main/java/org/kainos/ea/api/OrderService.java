package org.kainos.ea.api;

import org.kainos.ea.cli.Order;
import org.kainos.ea.cli.OrderRequest;
import org.kainos.ea.client.*;
import org.kainos.ea.db.OrderDAO;

import java.sql.SQLException;

public class OrderService {
    private OrderDAO orderDao = new OrderDAO();
    public Order getOrderById(int id) throws FailedToGetOrderException, OrderDoesNotExistException {
        try {
            Order order = orderDao.getOrderById(id);

            if (order == null){
                throw new OrderDoesNotExistException();
            }

            return order;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new FailedToGetOrderException();
        }

    }

    public void updateOrder(int id, OrderRequest order) throws InvalidOrderException, OrderDoesNotExistException, FailedToUpdateOrderException {
        try {
            String validation = OrderValidator.isValidOrder(order);

            if (validation != null) {
                throw new InvalidOrderException();
            }

            Order orderToUpdate = orderDao.getOrderById(id);

            if (orderToUpdate == null) {
                throw new OrderDoesNotExistException();
            }

            orderDao.updateOrder(id, order);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new FailedToUpdateOrderException();
        }
    }

}
