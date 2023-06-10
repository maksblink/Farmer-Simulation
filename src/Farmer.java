public class Farmer {
    static Strategy defaultStrat = new CarrotsFirstStrat();
    private int seeds, carrots;
    private double money, pestControlPrice = 10;
    //TODO: pestControlPrice do marketu

    private Strategy strategy = defaultStrat;


    public Farmer(double given_moneys, int given_seeds, int given_carrots) {
        money = given_moneys;
        seeds = given_seeds;
        carrots = given_carrots;
    }

    public Farmer(double given_moneys, int given_seeds, int given_carrots, double given_pestControlPrice) {
        money = given_moneys;
        seeds = given_seeds;
        carrots = given_carrots;
        pestControlPrice = given_pestControlPrice;
    }


    double getMoney() {return money;}
    public int getSeeds() {return seeds;}
    public int getCarrots() {return carrots;}
    public Strategy getStrategy() {return strategy;}


    public void show_off() {
        System.out.println("Hello I am Farmer!");
        System.out.println("money: " + money);
        System.out.println("seeds: " + seeds);
        System.out.println("carrots: " + carrots);
    }

    /*public int getPestTolerance(){
        return pestTolerance;
    }*/




    void buySeeds(double seed_purchase_price, int farm_size) {
        strategy.BuySeeds();
        /*while (money >= seed_purchase_price && seeds < farm_size) {
            money -= seed_purchase_price;
            seeds += 1;
        }*/
    }

    boolean plant_seed() {
        if (seeds > 0) {
            seeds -= 1;
            return true;
        } else {
            return false;
        }
    }

    void harvestCarrot() {
        carrots += 1;
    }

    void sellCarrots(double carrot_sale_price) {
        money += carrot_sale_price * carrots;
        carrots = 0;
    }

    public void handlePests(double usedmoney, Farm farm){
        int amountToRemove = (int)(usedmoney/pestControlPrice);
        int removed;
        removed = farm.RemovePests(amountToRemove);
        money -= removed*pestControlPrice;
    }

}
