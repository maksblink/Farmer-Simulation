public class PestsFirstStrat implements Strategy {
    private int defaultPestTolerance = 3;


    @Override
    public void stratBuySeeds(Farmer farmer, double seed_purchase_price, int farm_size) {
        while (farmer.getMoney() >= seed_purchase_price && farmer.getSeeds() < farm_size) {
            money -= seed_purchase_price;
            seeds += 1;
        }
    }

    @Override
    public boolean stratPlantSeeds() {
        if (seeds > 0) {
            seeds -= 1;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void stratHarvestCarrots() {
        carrots += 1;
    }

    @Override
    public void stratSellCarrots(double carrot_sale_price) {
        money += carrot_sale_price * carrots;
        carrots = 0;
    }

    @Override
    public void stratHandlePests(Farmer farmer, double usedmoney, Farm farm,) {
        int amountToRemove = (int)(usedmoney/pestControlPrice);
        int removed;
        removed = farm.RemovePests(amountToRemove);
        money -= removed*pestControlPrice;
    }
}
