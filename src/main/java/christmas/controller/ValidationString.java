package christmas.controller;

public enum ValidationString {
    INVALID_DAY("유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    INVALID_ORDER("유효하지 않은 주문입니다. 다시 입력해 주세요."),
    INVALID_ORDER_ONLY_DRINK("음료만 주문할 수는 없습니다."),
    INVALID_ORDER_MAXIMUM_COUNT("한번에 주문 가능한 음식의 수는 20개를 넘길 수 없습니다.");

    final String message;

    ValidationString(String str){
        this.message = str;
    }

    public String toString(){
        return this.message;
    }
}
