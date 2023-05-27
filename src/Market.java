import java.util.Random;

public class Market {
    private double CarrotSalePrice, SeedPurchasePrice;

    public void setRandomCarrotSalePrice() {
        Random rand = new Random();
        CarrotSalePrice = rand.nextInt((5 - 2) + 1) + 2;
    }

    public void setRandomSeedPurchasePrice() {
        Random rand = new Random();
        SeedPurchasePrice = rand.nextInt((3 - 1) + 1) + 1;
    }

    public double getCarrotSalePrice() {
        return CarrotSalePrice;
    }

    public double getSeedPurchasePrice() {
        return SeedPurchasePrice;
    }


}
