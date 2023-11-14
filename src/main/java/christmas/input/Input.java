package christmas.input;

import camp.nextstep.edu.missionutils.Console;
import christmas.controller.Tool;
import christmas.controller.Validate;
import christmas.model.Order;
import christmas.view.View;
import java.util.ArrayList;
import java.util.List;

public class Input {
    public static int reservedDay() {
        View.reservedDay();
        String input = Console.readLine();
        Validate.isIntegerNumeric(input);
        int value = Tool.string2Integer(input);
        Validate.rangeOfDecember(value);
        return value;
    }

    public static List<Order> order() {
        View.order();
        List<Order> order = new ArrayList<>();
        String input = Console.readLine();
        var menuList = separatingMenu(input);
        for (String menuString : menuList) {
            var menu = makeOrder(menuString);
            Validate.uniqueMenuOrder(order, menu);
            order.add(menu);
        }
        return order;
    }

    private static String[] separatingMenu(String str) {
        final String FIRST_SPLIT_PATTERN = ",";
        return str.split(FIRST_SPLIT_PATTERN);
    }

    private static Order makeOrder(String str) {
        final int INDEX_MENU_NAME = 0;
        final int INDEX_MENU_COUNT = 1;
        Validate.menuAndCountFormat(str);
        var item = separatingMenuAndCount(str);
        var menuName = item[INDEX_MENU_NAME];
        var count = Tool.string2Integer(item[INDEX_MENU_COUNT]);
        Validate.menuName(menuName);
        Validate.menuCount(count);
        return new Order(menuName, count);
    }

    private static String[] separatingMenuAndCount(String menuString) {
        final String SEPARATOR = "-";
        int find = menuString.indexOf(SEPARATOR);
        return new String[]{
                menuString.substring(0, find),
                menuString.substring(find + 1)
        };
    }
}
