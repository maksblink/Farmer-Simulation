public class Field {
    private CarrotGrowthLevel lvl;
    private int points;
    private final static int maxPoints = 100, maxLvl = CarrotGrowthLevel.MATURE.ordinal()-1;


    public Field(CarrotGrowthLevel givenLvl, int points) {
        this.lvl = givenLvl;
        this.points = points;
    }

    public CarrotGrowthLevel getLvl() {
        return lvl;
    }
    public int getLvlAsInt() {
        return lvl.ordinal()-1;
    }

    public int getPoints() {
        return points;
    }

    public void addPointsOrLvs(int given_points) {
        if (points >= maxPoints) {
            levelUp();
        } else if (lvl.ordinal() > CarrotGrowthLevel.EMPTY.ordinal()) {
            points += given_points;
        }
    }

    private void levelUp() {
        if (this.getLvlAsInt() < maxLvl) {
            lvl = CarrotGrowthLevel.values()[lvl.ordinal() + 1];
            points = 0;
        }
    }

    public void setLevel(int level) {
        lvl = CarrotGrowthLevel.values()[level+1];
    }

    public void show_off() {
        System.out.println("Hello I am Field!");
        System.out.println("Lvl: " + lvl);
        System.out.println("Points: " + points);
    }
}
