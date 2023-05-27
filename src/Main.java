
public class Main {
    public static void main(String[] args) {
        Farmer farmer = new Farmer(100, 0, 0);
        Market market = new Market();
        Farm farm = new Farm(5, 5);

        {
            //Market blocks
            {
                market.setRandomSeedPurchasePrice(2, 2);
                market.setRandomCarrotSalePrice(5, 5);
                market.show_off();
                System.out.println("\n");
            }
            //Farmer block
            {
                farmer.sell_carrots(market.getCarrotSalePrice());
                farmer.buy_seeds(market.getSeedPurchasePrice());

                farmer.show_off();
                System.out.println("\n");
            }
            //Farm block
            {
                farm.setRandomSunExposure(10, 10);
                farm.setRandomHumidity(10, 10);
                farm.show_off();
                System.out.println("\n");
            }
        }


    }
}
