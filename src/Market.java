import java.util.Random;

public class Market {
    private double CarrotSalePrice, SeedPurchasePrice;

    public void setRandomCarrotSalePrice(double max, double min) {
        double mean = (double)(max+min)/2; //srednia
        double stdDev = (double)(max-min)/4; //odchylenie standardowe / 2
        if (stdDev < 0) stdDev*=(-1);

        double rand = new Random().nextGaussian(mean, stdDev);

        if (rand > max) rand = max;
        if (rand < min) rand = min;

        rand = (double)((int)(rand*100))/100; //skrocenie ceny do 2 miejsc po przecinku
        CarrotSalePrice = rand;
    }

    public void setRandomSeedPurchasePrice(double max, double min) {
        double mean = (double)(max+min)/2; //srednia
        double stdDev = (double)(max-min)/4; //odchylenie standardowe / 2
        if (stdDev < 0) stdDev*=(-1);

        double rand = new Random().nextGaussian(mean, stdDev);

        if (rand > max) rand = max;
        if (rand < min) rand = min;

        rand = (double)((int)(rand*100))/100; //skrocenie ceny do 2 miejsc po przecinku
        SeedPurchasePrice = rand;
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
