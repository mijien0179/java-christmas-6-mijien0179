package christmas.controller;

import christmas.model.Menu;
import christmas.model.MenuType;
import christmas.model.Order;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Benefit {
    int discountPrice = 0;
    int benefitPrice = 0;
    List<String> benefit = new ArrayList<>();
    boolean presentGift = false;
    int totalPrice;


    public Benefit(int day, List<Order> order) {
        dDayDiscount(day);

        if (!isWeekend(day)) {
            weekDiscount(order);
        }
        if (isWeekend(day)) {
            weekendDiscount(order);
        }

        specialDiscount(day);
        giftEvent(order);
    }

    private boolean isWeekend(int day) {
        final int dayPerWeek = 7;
        final boolean[] week = {
                false,  // 목
                true,   // 금
                true,   // 토
                false,  // 일
                false,  // 월
                false,  // 화
                false   // 수
        };

        return week[day % dayPerWeek];
    }

    private void dDayDiscount(int day) {
        final int CHRISTMAS = 25;

        if (CHRISTMAS < day) {
            return;
        }

        int discount = (24 - CHRISTMAS + day) * 100 + 1000;
        addDiscount("크리스마스 디데이 할인", discount);
    }

    private void calculateTotalPrice(List<Order> order) {
        totalPrice = 0;

        for (var menu : order) {
            var count = menu.getCount();
            var price = menu.getMenu()
                    .getPrice();
            totalPrice += count * price;
        }
    }

    private void giftEvent(List<Order> order) {
        final int DISCOUNT_CRITERIA = 120_000;
        calculateTotalPrice(order);
        if (totalPrice < DISCOUNT_CRITERIA) {
            return;
        }
        presentGift = true;
        addBenefit("증정 이벤트", Menu.샴페인.getPrice());
    }

    private void specialDiscount(int day) {
        final List<Integer> staredDay = Arrays.asList(3, 10, 17, 24, 25, 31);
        final int SPECIAL_DISCOUNT = 1000;
        if (!staredDay.contains(day)) {
            return;
        }
        addDiscount("특별 할인", SPECIAL_DISCOUNT);
    }

    private void weekDiscount(List<Order> order) {
        final var WEEK_DISCOUNT_TARGET = MenuType.DESSERT;
        final var WEEK_DISCOUNT = 2023;
        int discount = 0;

        for (var menu : order) {
            var menuType = menu.getMenu()
                    .getDishType();
            if (menuType == WEEK_DISCOUNT_TARGET) {
                discount += WEEK_DISCOUNT;
            }
        }

        if (0 < discount) {
            addDiscount("평일 할인", discount);
        }
    }

    private void weekendDiscount(List<Order> order) {
        final var WEEKEND_DISCOUNT_TARGET = MenuType.DESSERT;
        final var WEEKEND_DISCOUNT = 2023;
        int discount = 0;

        for (var menu : order) {
            var menuType = menu.getMenu()
                    .getDishType();
            if (menuType == WEEKEND_DISCOUNT_TARGET) {
                discount += WEEKEND_DISCOUNT;
            }
        }

        if (0 < discount) {
            addDiscount("주말 할인", discount);
        }
    }


    private void addDiscount(String label, int discount) {
        discountPrice += discount;
        addBenefitLog(label, discountPrice);
    }

    private void addBenefit(String label, int price) {
        benefitPrice += price;
        addBenefitLog(label, price);
    }

    private void addBenefitLog(String label, int price) {
        benefit.add(String.format("%s: %s원", label, Tool.formattedNumericString(-price)));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (benefit.isEmpty()) {
            return "없음";
        }

        for (var str : benefit) {
            sb.append(str);
            sb.append("\n");
        }

        return sb.toString();
    }

    public String toTotalBenefit() {
        int totalBenefit = totalBenefit();
        return String.format("%s원", Tool.formattedNumericString(-totalBenefit));
    }

    private int totalBenefit() {
        return discountPrice + benefitPrice;
    }

    public String toBadge() {
        final int STAR_BADGE_CRITERIA = 5000;
        final int TREE_BADGE_CRITERIA = 10000;
        final int SANTA_BADGE_CRITERIA = 20000;
        var totalBenefit = totalBenefit();

        if (totalBenefit < STAR_BADGE_CRITERIA) {
            return "없음";
        }

        if (totalBenefit < TREE_BADGE_CRITERIA) {
            return "별";
        }
        if (totalBenefit < SANTA_BADGE_CRITERIA) {
            return "트리";
        }
        return "산타";
    }

}
