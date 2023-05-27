
public class Main {
    public static void main(String[] args) {
        Farmer farmer = new Farmer(100, 0, 0);
        Market market = new Market();

        market.setRandomSeedPurchasePrice();
        market.setRandomCarrotSalePrice();
        farmer.show_off();


        farmer.buy_seeds(market.getSeedPurchasePrice());
        farmer.show_off();

    }
}