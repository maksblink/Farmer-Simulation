public class Field {
    private int lvl;
    private int points;
    private final static int max_points = 100, max_lvl = 5;

    public Field(int lvl, int points) {
        this.lvl = lvl;
        this.points = points;
    }

    public int getLvl() {
        return lvl;
    }

    public int getPoints() {
        return points;
    }

    public void addPointsOrLvs(int given_points) {
        if (points >= max_points) {
            levelUp();
        } else if (lvl != 0) {
            points += given_points;
        }
    }

    private void levelUp() {
        if (lvl < max_lvl) {
            lvl++;
            points = 0;
        }
    }

    public void setLevel(int level) {
        lvl = level;
    }

    public void show_off() {
        System.out.println("Hello I am Field!");
        System.out.println("Lvl: " + lvl);
        System.out.println("Points: " + points);
    }
}
