public class Farmer {
    private int seeds, carrots;
    private double money;

    public Farmer(double given_moneys, int given_seeds, int given_carrots) {
        money = given_moneys;
        seeds = given_seeds;
        carrots = given_carrots;
    }

    double getMoney() {
        return money;
    }

    void buy_seeds(double seed_purchase_price, int farm_size) {
        while (money >= seed_purchase_price && seeds < farm_size) {
            money -= seed_purchase_price;
            seeds += 1;
        }
    }

    boolean plant_seed() {
        if (seeds > 0) {
            seeds -= 1;
            return true;
        } else {
            return false;
        }
    }

    void harvest_carrot() {
        carrots += 1;
    }

    void sell_carrots(double carrot_sale_price) {
        money += carrot_sale_price * carrots;
        carrots = 0;
    }

    public void show_off() {
        System.out.println("Hello I am Farmer!");
        System.out.println("money: " + money);
        System.out.println("seeds: " + seeds);
        System.out.println("carrots: " + carrots);
    }
}
