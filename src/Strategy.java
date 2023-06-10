public interface Strategy {

    void stratBuySeeds(Farmer farmer, double seedPurchasePrice, int farm_size);

    boolean stratPlantSeeds(Farmer farmer);

    void stratHarvestCarrots(Farmer farmer);

    //void stratSellCarrots(double carrotSalePrice);

    void stratHandlePests(Farmer farmer, Farm farm);
}
