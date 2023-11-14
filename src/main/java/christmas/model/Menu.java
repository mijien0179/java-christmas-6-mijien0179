package christmas.model;

import static christmas.model.MenuType.*;

import com.sun.tools.javac.Main;

public enum Menu {
    ButtonMushroomSoup(APPETIZER, "양송이수프", 6000),
    Tapas(APPETIZER, "타파스", 5500),
    CeasarSalad(APPETIZER, "시저샐러드", 8000),
    TBoneStake(MAIN, "티본스테이크", 55000),
    BarbecueRib(MAIN, "바비큐립", 54000),
    SeafoodPasta(MAIN, "해산물파스타", 35000),
    ChristmasPasta(MAIN, "크리스마스파스타", 25000),
    ChocolateCake(DESSERT, "초코케이크", 15000),
    IceCream(DESSERT, "아이스크림", 5000),
    ZeroCoke(DRINK, "제로콜라", 3000),
    RedWine(DRINK, "레드와인", 60000),
    Champagne(DRINK, "샴페인", 25000);

    final MenuType dishType;
    final String label;
    final int price;

    Menu(MenuType type, String label, int price) {
        this.dishType = type;
        this.label = label;
        this.price = price;
    }

    public MenuType getDishType() {
        return dishType;
    }

    public int getPrice() {
        return price;
    }
}
