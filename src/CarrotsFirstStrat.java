public class CarrotsFirstStrat implements Strategy{

    private int pestTolerance = 20;
    @Override
    public void stratBuySeeds(Farmer farmer, double seed_purchase_price, int farm_size) {

    }

    @Override
    public boolean stratPlantSeeds() {
        return false;
    }

    @Override
    public void stratHarvestCarrots() {

    }

    @Override
    public void stratSellCarrots(double carrot_sale_price) {

    }

    @Override
    public void stratHandlePests(Farmer farmer, double usedmoney, Farm farm) {

    }
}
