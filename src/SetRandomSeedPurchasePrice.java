import java.util.Random;

public class SetRandomSeedPurchasePrice {
    public static double setRandomSeedPurchasePrice(double max, double min) {
        double mean = (max + min) / 2; //srednia
        double stdDev = (max - min) / 4; //odchylenie standardowe / 2
        if (stdDev < 0) stdDev *= (-1);

        double rand = new Random().nextGaussian(mean, stdDev);

        if (rand > max) rand = max;
        if (rand < min) rand = min;

        rand = (double) ((int) (rand * 100)) / 100; //skrocenie ceny do 2 miejsc po przecinku
        return rand;
    }

}
