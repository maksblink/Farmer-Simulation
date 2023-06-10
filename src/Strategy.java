public interface Strategy {

    void stratBuySeeds(Farmer farmer, double seed_purchase_price, int farm_size);

    boolean stratPlantSeeds();

    void stratHarvestCarrots();

    void stratellCarrots(double carrot_sale_price);

    void stratHandlePests(Farmer farmer, double usedmoney, Farm farm);
}
