package ro.myClass.controller;

import org.junit.jupiter.api.Test;
import ro.myClass.models.OrderDetail;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ControllerOrderDetailTest {
    @Test
    public void sizeTest(){
        ControllerOrderDetail controllerOrderDetail = new ControllerOrderDetail();
        int size = controllerOrderDetail.size();
        OrderDetail orderDetail1 = new OrderDetail(3,231,41,2);
        controllerOrderDetail.addOrderDetail(orderDetail1);
        assertEquals(size+1,controllerOrderDetail.size());
    }
    @Test
    public void addTest(){
        ControllerOrderDetail controllerOrderDetail = new ControllerOrderDetail();
        OrderDetail orderDetail = new OrderDetail(1,261,41,5);
        int size = controllerOrderDetail.size();
        controllerOrderDetail.addOrderDetail(orderDetail);
       assertEquals(size+1,controllerOrderDetail.size());
    }
    @Test
    public void removeTest(){
         ControllerOrderDetail controllerOrderDetail = new ControllerOrderDetail();
         OrderDetail orderDetail = new OrderDetail(controllerOrderDetail.generateOrderDetailID(),100,102,2);
         controllerOrderDetail.addOrderDetail(orderDetail);
         int size = controllerOrderDetail.size();
         controllerOrderDetail.removeOrderDetail(100,102);
         assertEquals(size-1,controllerOrderDetail.size());
    }
    @Test
    public void save(){
        ControllerOrderDetail controllerOrderDetail = new ControllerOrderDetail();
        OrderDetail orderDetail1 = new OrderDetail(2,231,41,2);
        int size = controllerOrderDetail.size();
        controllerOrderDetail.addOrderDetail(orderDetail1);
        controllerOrderDetail.save();
        assertEquals(size+1,controllerOrderDetail.size());
    }

    @Test
    public void showText(){
        ControllerOrderDetail controllerOrderDetail = new ControllerOrderDetail();
        String text = controllerOrderDetail.showOrderDetails();
        assertEquals(text,controllerOrderDetail.showOrderDetails());

    }
    @Test
    public void toSaveTest(){
        ControllerOrderDetail controllerOrderDetail = new ControllerOrderDetail();
        System.out.println(controllerOrderDetail.toString());
    }

    @Test
    public void returnOrderbyProductIDTest(){
        ControllerOrderDetail controllerOrderDetail = new ControllerOrderDetail();
        OrderDetail order = new OrderDetail(100,102,4,2);
        controllerOrderDetail.addOrderDetail(order);
        controllerOrderDetail.save();
        controllerOrderDetail.load();
        OrderDetail orders = controllerOrderDetail.returnOrderbyProductID(102,4);
        assertEquals(orders,controllerOrderDetail.returnOrderbyProductID(102,4));

        System.out.println(controllerOrderDetail.returnOrderbyProductID(102,4));


    }

    @Test
    public void generateOrderId(){
        ControllerOrderDetail controllerOrderDetail = new ControllerOrderDetail();
        OrderDetail orderDetail = new OrderDetail(controllerOrderDetail.generateOrderDetailID(),11,1,1);
        controllerOrderDetail.orderDetails.add(orderDetail);
        assertEquals(controllerOrderDetail.generateOrderDetailID()-1,orderDetail.getOrderId());
    }

    @Test
    public void showTest(){
        ControllerOrderDetail controllerOrderDetail = new ControllerOrderDetail();
        OrderDetail orderDetail = new OrderDetail(controllerOrderDetail.generateOrderDetailID(),11,1,1);
        controllerOrderDetail.orderDetails.add(orderDetail);
        String text = controllerOrderDetail.showOrder(orderDetail.getOrderId());
        assertEquals(text,controllerOrderDetail.showOrder(orderDetail.getOrderId()));
    }
    @Test
    public void returnOrderDetailsTest(){
        ControllerOrderDetail controllerOrderDetail = new ControllerOrderDetail();
        OrderDetail orderDetail = new OrderDetail(controllerOrderDetail.generateOrderDetailID(),11,1,1);
        controllerOrderDetail.orderDetails.add(orderDetail);
        ArrayList<OrderDetail> aList = controllerOrderDetail.returnOrderDetails(orderDetail.getOrderId());
        assertEquals(aList,controllerOrderDetail.returnOrderDetails(orderDetail.getOrderId()));
    }

    @Test
    public void returnOrderByProductID(){
        ControllerOrderDetail controllerOrderDetail = new ControllerOrderDetail();
        OrderDetail orderDetail = new OrderDetail(controllerOrderDetail.generateOrderDetailID(),11,1,1);
        controllerOrderDetail.orderDetails.add(orderDetail);
        OrderDetail newOrder = controllerOrderDetail.returnOrderbyProductID(orderDetail.getOrderId(),orderDetail.getProductId());
        assertEquals(newOrder,orderDetail);
        assertEquals(null,controllerOrderDetail.returnOrderbyProductID(2319,31));
    }



}
