import java.util.*;

public class Farm {
    private final int width, height;
    public ArrayList<ArrayList<Field>> fields = new ArrayList<>();
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
        fields = new ArrayList<>();

        SetUpFields(fields);
    }

    public Farm(int given_width, int given_height, int given_pestSpawnChance) {
        width = given_width;
        height = given_height;
        fields = new ArrayList<>();
        pestSpawnChance = given_pestSpawnChance;

        SetUpFields(fields);
    }

    private void SetUpFields (ArrayList<ArrayList<Field>> fields){
        for (int i = 0; i < width; i++) {
            ArrayList<Field> row = new ArrayList<>();
            for (int j = 0; j < height; j++) {
                Field field = new Field(CarrotGrowthLevel.EMPTY,0);
                field.setLevel(0);
                row.add(field);
            }
            fields.add(row);
        }
    }

    public int getWidth() {//<---------------
        return width;//<---------------
    }

    public int getHeight() {//<---------------
        return height;//<---------------
    }

    public int getArea(){//<---------------
        return width*height;//<---------------
    }

    int getSunExposure() {
        return SunExposure;
    }

    int getHumidity() {
        return Humidity;
    }


    void plant_seed(int x, int y) {
        fields.get(x).get(y).setLevel(1);
    }

    void harvest_carrot(int x, int y) {
        fields.get(x).get(y).setLevel(0);
    }

    public void show_off_debug() {
        StringBuilder farm_fields = new StringBuilder();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                farm_fields.append(fields.get(i).get(j).getLvl()).append("\t");
            }
            farm_fields.append("\n");
        }

        System.out.println("Hello I am Farm!");
        System.out.println("SunExposure: " + SunExposure);
        System.out.println("Humidity: " + Humidity);
        System.out.println(farm_fields);//<---------------
    }

    public void show_off() {
        StringBuilder farm_fields = new StringBuilder();
        String fieldIcon;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                switch (fields.get(i).get(j).getLvl()){
                    case INFECTED:
                        fieldIcon = "*";
                        break;
                    case EMPTY:
                        fieldIcon = "_";
                        break;
                    case SEED:
                        fieldIcon = ".";
                        break;
                    case SAMPLING:
                        fieldIcon = "v";
                        break;
                    case GROWING:
                        fieldIcon = "Y";
                        break;
                    case IMMATURE:
                        fieldIcon = "n";
                        break;
                    case MATURE:
                        fieldIcon = "ń";
                        break;
                    default:
                        fieldIcon = "\u2370";// znak: '[?]'
                        break;
                }
                farm_fields.append(fieldIcon).append(' ');
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


            if (fields.get(locx).get(locy).getLvlAsInt() > 1
                    || fields.get(locx).get(locy).getLvlAsInt() != -1
                    || fields.get(locx).get(locy).getLvlAsInt() != 5) {
                fields.get(locx).get(locy).setLevel(-1);
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


    //TODO: "public" :/
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
        for (ArrayList<Field> fieldRow : fields) {
            for (Field field : fieldRow){
                if(field.getLvlAsInt() == lvl){
                    return field;
                }
            }
        }
        return null;
    }
}
