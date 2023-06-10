public interface Strategy {

    int getPestTolerance();

    void stratBuySeeds(Farmer farmer, double seedPurchasePrice, int farm_size);

    boolean stratPlantSeeds(Farmer farmer);

    void stratHarvestCarrots(Farmer farmer);

    void stratHandlePests(Farmer farmer, Farm farm);
}
