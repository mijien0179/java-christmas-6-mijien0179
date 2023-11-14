package christmas.controller;

import christmas.input.Input;
import christmas.view.View;
import java.lang.invoke.MethodHandle;
import java.util.function.Consumer;
import java.util.function.Function;

public class Tool {

    public static int string2Integer(String numericString) {
        try {
            return Integer.parseInt(numericString);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("숫자만 입력");
        }
    }

    public static void looper(Function<Void, Void> loop) {
        while (true) {
            try {
                loop.apply(null);
                return;
            } catch (Exception e) {
                View.error(e.getMessage());
            }
        }
    }

}
