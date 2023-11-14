package christmas.controller;

import christmas.input.Input;
import christmas.view.View;

public class Christmas {
    int day;

    public void run() {
        View.helloWorld();
        Tool.looper(
                (Void v) -> {
                    day = Input.reservedDay();
                    return null;
                }
        );
        View.benefitPreviewHelloWorld(day);

    }

}