import java.util.Random;

public class Farm {
    private final int width, height;
    public int[][] fields;

    private int SunExposure, Humidity;

    public void setRandomSunExposure(int max, int min) {
        Random rand = new Random();
        SunExposure = rand.nextInt((max - min) + 1) + min;
    }

    public void setRandomHumidity(int max, int min) {
        Random rand = new Random();
        Humidity = rand.nextInt((max - min) + 1) + min;
    }

    public Farm(int given_width, int given_height) {
        width = given_width;
        height = given_height;
        fields = new int[width][height];

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                fields[i][j] = 0;
            }
        }
    }

    int getWidth() {
        return width;
    }

    int getHeight() {
        return height;
    }

    int getSunExposure() {
        return SunExposure;
    }

    int getHumidity() {
        return Humidity;
    }

    void plant_seed(int x, int y) {
        fields[x][y] = 1;
    }

    void harvest_carrot(int x, int y) {
        fields[x][y] = 0;
    }


    public void show_off() {
        StringBuilder farm_fields = new StringBuilder();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                farm_fields.append(fields[i][j] + "\t");
            }
            farm_fields.append("\n");
        }

        System.out.println("Hello I am Farm!");
        System.out.println("SunExposure: " + SunExposure);
        System.out.println("Humidity: " + Humidity);
        System.out.println(farm_fields);
    }


}
