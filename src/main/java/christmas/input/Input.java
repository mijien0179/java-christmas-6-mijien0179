package christmas.input;

import camp.nextstep.edu.missionutils.Console;
import christmas.controller.Tool;
import christmas.controller.Validate;
import christmas.view.View;

public class Input {
    public static int reservedDay() {
        View.reservedDay();
        String input = Console.readLine();
        Validate.isIntegerNumeric(input);
        int value = Tool.string2Integer(input);
        Validate.rangeOfDecember(value);
        return value;
    }

}
