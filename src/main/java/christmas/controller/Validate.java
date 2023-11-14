package christmas.controller;

import christmas.model.Menu;
import christmas.model.Order;
import java.util.List;

public class Validate {
    public static void isIntegerNumeric(String str) {
        Tool.string2Integer(str);
    }

    public static void rangeOfDecember(int number) {
        if (number < 1) {
            throw new IllegalArgumentException("날짜는 1일 미만일 수 없습니다");
        }
        if (31 < number) {
            throw new IllegalArgumentException("날짜는 31일 초과일 수 없습니다.");
        }
    }

    public static void menuName(String name) {
        try {
            Menu.valueOf(name);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(name + " 존재하지 않는 메뉴명입니다");
        }
    }

    public static void uniqueMenuOrder(List<Order> order, Order menu) {
        var menuName = menu.getMenu()
                .name();
        for (Order item : order) {
            var diffMenuName = item.getMenu()
                    .name();
            if (diffMenuName.equals(menuName)) {
                throw new IllegalArgumentException("메뉴는 중복으로 주문할 수 없습니다.");
            }
        }
    }

    public static void menuCount(int count){
        if(count < 1){
            throw new IllegalArgumentException("메뉴별 개수는 1개 이상이어야 합니다.");
        }
    }

    public static void menuAndCountFormat(String str){
        if(!str.contains("-")){
            throw new IllegalArgumentException("주문시 메뉴-주문수 형식을 지켜주세요.");
        }
    }

}
