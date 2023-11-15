package christmas.controller;

import christmas.model.Menu;
import christmas.model.MenuType;
import christmas.model.Order;
import java.util.List;

public class Validate {
    public static void isIntegerNumeric(String str) {
        Tool.string2Integer(str);
    }

    public static void rangeOfDecember(int number) {
        if (number < 1 || 31 < number) {
            // NOTE: REQUIRED TEXT
            throw new IllegalArgumentException(ValidationString.INVALID_DAY.toString());
        }
    }

    public static void menuName(String name) {
        try {
            Menu.valueOf(name);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ValidationString.INVALID_ORDER.toString());
        }
    }

    public static void uniqueMenuOrder(List<Order> order, Order menu) {
        var menuName = menu.getMenu()
                .name();
        for (Order item : order) {
            var diffMenuName = item.getMenu()
                    .name();
            if (diffMenuName.equals(menuName)) {
                throw new IllegalArgumentException(ValidationString.INVALID_ORDER.toString());
            }
        }
    }

    public static void menuCount(int count){
        if(count < 1){
            throw new IllegalArgumentException(ValidationString.INVALID_ORDER.toString());
        }
    }

    public static void menuAndCountFormat(String str){
        if(!str.contains("-")){
            throw new IllegalArgumentException(ValidationString.INVALID_ORDER.toString());
        }
    }

    public static void totalCountOfMenu(List<Order> order){
        final int MAXIMUM_MENU_COUNT = 20;
        int count = 0;
        for(var menu: order){
            count += menu.getCount();
        }
        if(MAXIMUM_MENU_COUNT < count){
            throw new IllegalArgumentException(ValidationString.INVALID_ORDER_MAXIMUM_COUNT.toString());
        }
    }

    public static void drinkOrderOnly(List<Order> order){
        boolean isDrinkOnly = true;
        for(var menu:order){
            var type = menu.getMenu()
                    .getDishType();
            if(type != MenuType.DRINK){
                isDrinkOnly = false;
                break;
            }
        }

        if(isDrinkOnly){
            throw new IllegalArgumentException(ValidationString.INVALID_ORDER_ONLY_DRINK.toString());
        }
    }

}
