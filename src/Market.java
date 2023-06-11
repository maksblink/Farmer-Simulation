import java.util.Random;

public class Market {
    private double CarrotSalePrice, SeedPurchasePrice;

    public void setCarrotSalePrice(double price) {
        CarrotSalePrice = price;
    }

    public void setSeedPurchasePrice(double price) {
        SeedPurchasePrice = price;
    }

    public double getCarrotSalePrice() {
        return CarrotSalePrice;
    }

    public double getSeedPurchasePrice() {
        return SeedPurchasePrice;
    }

    public void show_off() {
        System.out.println("Hello I am Market!");
        System.out.println("CarrotSalePrice: " + CarrotSalePrice);
        System.out.println("SeedPurchasePrice: " + SeedPurchasePrice);
    }
}
