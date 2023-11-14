package christmas.controller;

import christmas.model.Menu;
import christmas.model.Order;
import java.util.List;

public class Validate {
    public static void isIntegerNumeric(String str) {
        Tool.string2Integer(str);
    }

    public static void rangeOfDecember(int number) {
        if (number < 1 || 31 < number) {
            // NOTE: REQUIRED TEXT
            throw new IllegalArgumentException("유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    public static void menuName(String name) {
        try {
            Menu.valueOf(name);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    public static void uniqueMenuOrder(List<Order> order, Order menu) {
        var menuName = menu.getMenu()
                .name();
        for (Order item : order) {
            var diffMenuName = item.getMenu()
                    .name();
            if (diffMenuName.equals(menuName)) {
                throw new IllegalArgumentException("유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
        }
    }

    public static void menuCount(int count){
        if(count < 1){
            throw new IllegalArgumentException("유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    public static void menuAndCountFormat(String str){
        if(!str.contains("-")){
            throw new IllegalArgumentException("유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

}
