package christmas.model;

public class Order {
    Menu menu;
    int count;

    public Order(Menu menu, int count) {
        this.menu = menu;
        this.count = count;
    }

    public Order(String menu, int count) {
        this(Menu.valueOf(menu), count);
    }

    public void inc() {
        inc(1);
    }

    public void inc(int step) {
        count += step;
    }

    public String toString() {
        return String.format("%s %d개", menu, count);
    }

    public Menu getMenu() {
        return this.menu;
    }
}
