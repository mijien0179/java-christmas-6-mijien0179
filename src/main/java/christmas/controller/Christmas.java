package christmas.controller;

import camp.nextstep.edu.missionutils.Console;
import christmas.input.Input;
import christmas.model.Order;
import christmas.view.View;
import java.util.List;

public class Christmas {
    int day;
    List<Order> order;

    public void run() {
        View.helloWorld();
        if(!Tool.exceptionRun(() -> day = Input.reservedDay())){
            return;
        }
        if(!Tool.exceptionRun(() -> order = Input.order())){
            return;
        }

//        Tool.restartWhenException(() -> day = Input.reservedDay());
//        Tool.restartWhenException(() -> order = Input.order());
        Console.close();

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