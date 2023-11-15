package christmas.controller;

import christmas.view.View;
import java.text.DecimalFormat;

public class Tool {

    public static int string2Integer(String numericString) {
        return Integer.parseInt(numericString);
    }

    public static void restartWhenException(Runnable loop) {
        while (true) {
            if(exceptionRun(loop)){
                break;
            }
        }
    }

    public static boolean exceptionRun(Runnable loop){
        try{
            loop.run();
            return true;
        }catch(Exception e){
            View.error(e.getMessage());
            return false;
        }
    }

    public static void executeWithExceptionUserMessage(Runnable r, String message){
        try{
            r.run();
        }catch (Exception e){
            throw new IllegalArgumentException(message);
        }
    }

    public static String formattedNumericString(int number) {
        DecimalFormat df = new DecimalFormat("###,###");
        return df.format(number);
    }

}
