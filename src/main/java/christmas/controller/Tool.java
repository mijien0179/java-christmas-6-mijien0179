package christmas.controller;

import christmas.view.View;
import java.text.DecimalFormat;

public class Tool {

    public static int string2Integer(String numericString) {
        try {
            return Integer.parseInt(numericString);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("숫자만 입력");
        }
    }

    public static void restartWhenException(Runnable loop) {
        while (true) {
            try {
                loop.run();
                break;
            } catch (Exception e) {
                View.error(e.getMessage());
            }
        }
    }

    public static String formattedNumericString(int number) {
        DecimalFormat df = new DecimalFormat("###,###");
        return df.format(number);
    }

}
