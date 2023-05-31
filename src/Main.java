import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Farmer farmer = new Farmer(10, 0, 0);
        Market market = new Market();
        Farm farm = new Farm(10, 12);

        int days = 0;
        while (farmer.getMoney() < 1000000 && farm.getPestCount() < farm.getArea()) {
            System.out.println("\nTHIS IS THE " + days + " DAY\n");

            //Market block
            market.setRandomSeedPurchasePrice(2, 1);
            market.setRandomCarrotSalePrice(5, 3);
            market.show_off();
            System.out.println();

            //Farm block
            farm.show_off();
            System.out.println();

            farm.setRandomSunExposure(6, 0);
            farm.setRandomHumidity(6, 0);

            for (int i = 0; i < farm.getWidth(); i++) {
                for (int j = 0; j < farm.getHeight(); j++) {
                    farm.fields[i][j].addPointsOrLvs(farm.getSunExposure() * farm.getHumidity());
                }
            }

            farm.spawnRandomPest();


            //Farmer block
            farmer.sell_carrots(market.getCarrotSalePrice());
            farmer.buy_seeds(market.getSeedPurchasePrice(), farm.getWidth() * farm.getHeight());

            farmer.show_off();
            System.out.println();

            for (int i = 0; i < farm.getWidth(); i++) {
                for (int j = 0; j < farm.getHeight(); j++) {
                    if (farm.fields[i][j].getLvl() == 0) {
                        if (farmer.plant_seed()) {
                            farm.plant_seed(i, j);
                        }
                    } else if (farm.fields[i][j].getLvl() == 5) {
                        farm.harvest_carrot(i, j);
                        farmer.harvest_carrot();
                    }
                }
            }

            if(farm.getPestCount() > farmer.getPestTolerance()){
                farmer.HandlePests(farmer.getMoney()/2, farm);
                farm.show_off();
            }

            //Utility
            days++;
        }
    }
}
