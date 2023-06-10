public class Farmer {
    static Strategy defaultStrat = new StratCarrotsFirst();
    private int seeds, carrots;
    private double money, pestControlPrice = 10;
    //TODO: pestControlPrice do marketu

    private Strategy strategy = defaultStrat;


    public Farmer(double givenMoneys, int givenSeeds, int givenCarrots) {
        money = givenMoneys;
        seeds = givenSeeds;
        carrots = givenCarrots;
    }


    double getMoney() {return money;}
    public int getSeeds() {return seeds;}
    public int getCarrots() {return carrots;}
    public double getPestControlPrice() {return pestControlPrice;}
    public Strategy getStrategy() {return strategy;}

    public void addMoney(Strategy strats, double income){
        if(strats == strategy) money += income;
    }
    public void subtractMoney(Strategy strats, double spending){
        if(strats == strategy)money -= spending;
    }
    public void addSeeds(Strategy strats, int income){
        if(strats == strategy) seeds += income;
    }
    public void subtractSeeds(Strategy strats, int spending){
        if(strats == strategy) seeds -= spending;
    }
    public void addCarrots(Strategy strats, int amount){
        if(strats == strategy) carrots += amount;
    }




    public void show_off() {
        System.out.println("Hello I am Farmer!");
        System.out.println("money: " + money);
        System.out.println("seeds: " + seeds);
        System.out.println("carrots: " + carrots);
    }

    /*public int getPestTolerance(){
        return pestTolerance;
    }*/




    void buySeeds(double seedPurchasePrice, int farmSize) {
        strategy.stratBuySeeds(this, seedPurchasePrice, farmSize);
    }

    boolean plantSeed() {
        return strategy.stratPlantSeeds(this);
    }

    void harvestCarrot() {
        strategy.stratHarvestCarrots(this);
    }

    void sellCarrots(double carrotSalePrice) {
        money += carrotSalePrice * carrots;
        carrots = 0;
    }

    public void handlePests(Farm farm){
        strategy.stratHandlePests(this, farm);

        /*
        int amountToRemove = (int)(usedmoney/pestControlPrice);
        int removed;
        removed = farm.RemovePests(amountToRemove);
        money -= removed*pestControlPrice;
         */
    }

}
