package christmas.model;

public class Order {
    Menu menu;
    int count;

    Order(Menu menu, int count) {
        this.menu = menu;
        this.count = count;
    }

    public void inc() {
        inc(1);
    }

    public void inc(int step) {
        count += step;
    }


}
