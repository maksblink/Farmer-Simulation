public class StratCarrotsFirst implements Strategy{

    final int defaultPestTolerance = 15;


    @Override
    public void stratBuySeeds(Farmer farmer, double seedPurchasePrice, int farm_size) {
        double moneyToUse = 2*(farmer.getMoney()/3);
        double usedMoney = 0;
        int seedBought = 0;

        while (moneyToUse > usedMoney && farmer.getSeeds() < farm_size) {
            usedMoney += seedPurchasePrice;
            seedBought ++;
        }

        farmer.subtractMoney(this, usedMoney);
        farmer.addSeeds(this, seedBought);
    }

    @Override
    public boolean stratPlantSeeds(Farmer farmer) {
        if (farmer.getSeeds() > 0) {
            farmer.subtractSeeds(this, 1);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void stratHarvestCarrots(Farmer farmer) {
        farmer.addCarrots(this, 1);
    }

    @Override
    public void stratHandlePests(Farmer farmer, Farm farm) {
        if(farm.getPestCount() > defaultPestTolerance){
            double usedMoney = farmer.getMoney()/3;
            int amountToRemove = (int)(usedMoney/farmer.getPestControlPrice());
            int removed;
            removed = farm.RemovePests(amountToRemove);

            farmer.subtractMoney(this, removed*farmer.getPestControlPrice());
        }
    }
}
