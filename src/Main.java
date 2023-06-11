public class Main {
    public static void main(String[] args) {
        Farmer farmer = new Farmer(10, 0, 0);
        Market market = new Market();
        Farm farm = new Farm(10, 12);

        int days = 0;
        while (farmer.getMoney() < 1000000 && farm.getPestCount() < farm.getArea()) {
            System.out.println("\nTHIS IS THE " + days + " DAY\n");

            //Market block
            market.setSeedPurchasePrice(SetRandomSeedPurchasePrice.setRandomSeedPurchasePrice(2, 1));

            market.setCarrotSalePrice(SetRandomCarrotSalePrice.setRandomCarrotSalePrice(5, 3));

            market.setCarrotSalePrice(SetRandomCarrotSalePrice.setRandomCarrotSalePrice(5, 3));
            market.show_off();
            System.out.println();

            //Farm block
            farm.show_off();
            System.out.println();

            farm.setRandomSunExposure(6, 0);
            farm.setRandomHumidity(6, 0);

            for (int i = 0; i < farm.getWidth(); i++) {
                for (int j = 0; j < farm.getHeight(); j++) {
                    farm.fields.get(i).get(j).addPointsOrLvs(farm.getSunExposure() * farm.getHumidity());
                }
            }

            farm.spawnRandomPest();


            //Farmer block
            FarmerRoutine(farmer, farm, market);


            //Utility
            days++;
        }
    }

    private static void FarmerRoutine(Farmer farmer, Farm farm, Market market) {

        farmer.sellCarrots(market.getCarrotSalePrice());
        farmer.buySeeds(market.getSeedPurchasePrice(), farm.getWidth() * farm.getHeight());

        farmer.show_off();

        for (int i = 0; i < farm.getWidth(); i++) {
            for (int j = 0; j < farm.getHeight(); j++) {
                if (farm.fields.get(i).get(j).getLvlAsInt() == 0) {
                    if (farmer.plantSeed()) {
                        farm.plant_seed(i, j);
                    }
                } else if (farm.fields.get(i).get(j).getLvlAsInt() == 5) {
                    farm.harvest_carrot(i, j);
                    farmer.harvestCarrot();
                }
            }
        }


        farmer.handlePests(farm);

        farmer.rethinkStrategy(farm.getPestCount());

    }
}
