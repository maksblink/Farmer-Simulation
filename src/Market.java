import java.util.Random;

public class Market {
    private double CarrotSalePrice, SeedPurchasePrice;

    public void setRandomCarrotSalePrice(int max, int min) {
        Random rand = new Random();
        CarrotSalePrice = rand.nextInt((max - min) + 1) + min;
    }

    public void setRandomSeedPurchasePrice(int max, int min) {
        Random rand = new Random();
        SeedPurchasePrice = rand.nextInt((max - min) + 1) + min;
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
