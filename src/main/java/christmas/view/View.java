package christmas.view;

import christmas.controller.Tool;
import christmas.model.Order;
import java.util.List;

public class View {
    public static void helloWorld() {
        println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public static void reservedDay() {
        println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해주세요!)");
    }

    public static void order() {
        println("주문하실 메뉴를 메뉴와 개수를 알려주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
    }

    public static void benefitPreviewHelloWorld(int day) {
        println(formatString("12월 %d일에 우테코 식당에서 이벤트 혜택 미리 보기!", day));
        println();
    }

    public static void orderedList(List<Order> order) {
        println("<주문 메뉴>");
        for (var menu : order) {
            println(menu.toString());
        }
        println();
    }

    public static void totalPriceBeforeDiscount(int price) {
        println("<할인 전 총주문 금액>");
        println(formatString("%s원", Tool.formattedNumericString(price)));
        println();
    }

    public static void giftMenu(String benefit){
        println("<증정 메뉴>");
        println(benefit);
        println();
    }

    public static void benefitLog(String log){
        println("<혜택 내역>");
        println(log);
        println();
    }

    public static void totalBenefitPrice(int price){
        println("<총혜택 금액>");
        println(String.format("%s원", Tool.formattedNumericString(-price)));
        println();
    }

    public static void totalChargeAfterApplyBenefit(int price){
        println("<할인 후 예상 결제 금액>");
        println(String.format("%s원", Tool.formattedNumericString(price)));
        println();
    }

    public static void eventBadge(String badge){
        println("<12월 이벤트 배지>");
        println(badge);
    }

    public static void error(String str) {
        println(formatString("[ERROR] %s", str));
    }

    private static void print(String str) {
        System.out.print(str);
    }

    private static void println(String str) {
        print(str + System.lineSeparator());
    }

    private static void println() {
        println("");
    }

    private static String formatString(String format, Object... args) {
        return String.format(format, args);
    }

}
