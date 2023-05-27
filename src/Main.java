
public class Main {

    public static void main(String[] args) {
        Farmer farmer = new Farmer(100, 0, 0);
        Market market = new Market();
        Farm farm = new Farm(3, 3);

        {
            //Market block
            {
                market.setRandomSeedPurchasePrice(2, 1);
                market.setRandomCarrotSalePrice(5, 3);
//                market.show_off();
//                System.out.println("\n");
            }
            //Farm block
            {
                farmer.show_off();
                System.out.println("\n");

                farm.setRandomSunExposure(10, 10);
                farm.setRandomHumidity(10, 10);
                farm.show_off();
                System.out.println("\n");
            }
            //Farmer block
            {
                farmer.sell_carrots(market.getCarrotSalePrice());
                farmer.buy_seeds(market.getSeedPurchasePrice());

                farmer.show_off();
                System.out.println("\n");

                for (int i = 0; i < farm.getWidth(); i++) {
                    for (int j = 0; j < farm.getHeight(); j++) {
                        if (farm.fields[i][j] == 0) {
                            if (farmer.plant_seed()) {
                                farm.plant_seed(i, j);
                            }
                        } else if (farm.fields[i][j] == 5) {
                            farm.harvest_carrot(i, j);
                            farmer.harvest_carrot();
                        }
                    }
                }


                farmer.show_off();
                System.out.println("\n");
                farm.show_off();
            }
        }


    }
}
