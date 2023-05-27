
public class Main {
    public static void main(String[] args) {
        Farmer farmer = new Farmer(2, 0, 1);
        Market market = new Market();

        {
            //Market block
            {
                market.setRandomSeedPurchasePrice(2, 1);
                market.setRandomCarrotSalePrice(5, 3);
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
        }


    }
}