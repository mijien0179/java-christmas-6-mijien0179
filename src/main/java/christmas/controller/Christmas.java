package christmas.controller;

import christmas.input.Input;
import christmas.model.Order;
import christmas.view.View;
import java.util.List;

public class Christmas {
    int day;
    List<Order> order;

    public void run() {
        View.helloWorld();
        Tool.restartWhenException(() -> day = Input.reservedDay());
        Tool.restartWhenException(() -> order = Input.order());

        View.benefitPreviewHelloWorld(day);
        View.orderedList(order);

    }

}