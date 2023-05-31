import java.util.*;
import java.util.function.Function;

public class Farm {
    private final int width, height;
    public Field[][] fields;

    private int SunExposure, Humidity;
    private int pestSpawnChance = 10, // chance = 1/pestSpawnChance
    pestCount = 0;

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
        fields = new Field[width][height];

        SetUpFields(fields);
    }

    public Farm(int given_width, int given_height, int given_pestSpawnChance) {
        width = given_width;
        height = given_height;
        fields = new Field[width][height];
        pestSpawnChance = given_pestSpawnChance;

        SetUpFields(fields);
    }

    private void SetUpFields (Field[][] fields){
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                fields[i][j] = new Field(0, 0);
                fields[i][j].setLevel(0);
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getArea(){
        return width*height;
    }

    int getSunExposure() {
        return SunExposure;
    }

    int getHumidity() {
        return Humidity;
    }

    void plant_seed(int x, int y) {
        fields[x][y].setLevel(1);
    }

    void harvest_carrot(int x, int y) {
        fields[x][y].setLevel(0);
    }

    public void show_off() {
        StringBuilder farm_fields = new StringBuilder();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                farm_fields.append(fields[i][j].getLvl()).append("\t");
            }
            farm_fields.append("\n");
        }

        System.out.println("Hello I am Farm!");
        System.out.println("SunExposure: " + SunExposure);
        System.out.println("Humidity: " + Humidity);
        System.out.println(farm_fields);
    }

    public void spawnRandomPest(){
        Random chance = new Random();
        if (chance.nextInt(pestSpawnChance) == 0){
            int locx, locy;
            Random rand =new Random();
            locx = rand.nextInt(width);
            locy = rand.nextInt(height);

            if (fields[locx][locy].getLvl() > 1
                    && fields[locx][locy].getLvl() != -1
                    && fields[locx][locy].getLvl() == 5) {
                fields[locx][locy].setLevel(-1);
                pestCount ++;

                //v---debug---v
                //System.out.println("\nSPAWNED!SPAWNED!SPAWNED!SPAWNED!SPAWNED!SPAWNED!SPAWNED!SPAWNED!SPAWNED!SPAWNED!SPAWNED!SPAWNED!SPAWNED!SPAWNED!SPAWNED!SPAWNED!SPAWNED!");
                //^---debug---^
            }
        }
    }

    public int getPestCount(){
        return pestCount;
    }

    public int RemovePests(int amountToRemove){
        int amountLeft = amountToRemove;
        for(int i = 1; i <= amountToRemove; i++){
            Field infectedField = IterateThroughFieldsLevelsInFarm(-1);

            if (infectedField == null){
                break;
            }
            else{
                infectedField.setLevel(0);
                pestCount--;
                amountLeft --;
            }
        }
        int removed = amountToRemove-amountLeft;

        //v---debug---v
        System.out.println("\nRemoved pests: " + removed);
        //^---debug---^

        return removed;
    }

    private Field IterateThroughFieldsLevelsInFarm(int lvl){
        for (Field[] ff : fields) {
            for (Field f : ff){
                if(f.getLvl() == lvl){
                    return f;
                }
            }
        }

        return null;
    }
}
