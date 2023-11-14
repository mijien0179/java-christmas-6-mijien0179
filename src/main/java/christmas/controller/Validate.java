package christmas.controller;

public class Validate {
    public static void isIntegerNumeric(String str){
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
}
