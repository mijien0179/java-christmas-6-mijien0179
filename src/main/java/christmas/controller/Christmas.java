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

        Benefit benefit = new Benefit(day, order);

        View.benefitPreviewHelloWorld(day);
        View.orderedList(order);
        View.totalPriceBeforeDiscount(benefit.toTotalPrice());
        View.giftMenu(benefit.toGift());
        View.benefitLog(benefit.toString());
        View.totalBenefitPrice(benefit.toTotalBenefit());
        View.totalChargeAfterApplyBenefit(benefit.toTotalPrice() - benefit.getDiscountPrice());
        View.eventBadge(benefit.toBadge());

    }

}