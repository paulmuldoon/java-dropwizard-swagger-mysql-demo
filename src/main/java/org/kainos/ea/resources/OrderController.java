package org.kainos.ea.resources;

import io.swagger.annotations.Api;
import org.kainos.ea.api.OrderService;
import org.kainos.ea.api.ProductService;
import org.kainos.ea.cli.Order;
import org.kainos.ea.cli.OrderRequest;
import org.kainos.ea.cli.ProductRequest;
import org.kainos.ea.client.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Api("Engineering Academy Dropwizard Order API")
@Path("/api")

public class OrderController {
    private final OrderService orderService = new OrderService();

    @GET
    @Path("/orders/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOrderById(@PathParam("id") int id) throws OrderDoesNotExistException {
        try {
            return Response.ok(orderService.getOrderById(id)).build();
        } catch (FailedToGetOrderException e) {
            System.err.println(e.getMessage());
            return Response.serverError().build();
        } catch (OrderDoesNotExistException e) {
            System.err.println(e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

}
