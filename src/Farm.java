import java.util.*;

public class Farm {
    private final int width, height;
    public ArrayList<ArrayList<Field>> fields = new ArrayList<>();
    private int SunExposure, Humidity;
    private final int defaultPestSpawnChance = 10;
    private int pestSpawnChance = defaultPestSpawnChance; // chance = 1/pestSpawnChance
    private int pestCount = 0;

    public void setRandomSunExposure(int max, int min) {
        Random rand = new Random();
        SunExposure = rand.nextInt((max - min) + 1) + min;
    }

    public void setRandomHumidity(int max, int min) {
        Random rand = new Random();
        Humidity = rand.nextInt((max - min) + 1) + min;
    }

    public Farm(int givenWidth, int givenHeight) {
        width = givenWidth;
        height = givenHeight;
        fields = new ArrayList<>();

        SetUpFields(fields);
    }

    public Farm(int givenWidth, int givenHeight, int givenPestSpawnChance) {
        width = givenWidth;
        height = givenHeight;
        fields = new ArrayList<>();
        pestSpawnChance = givenPestSpawnChance;

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


    void plantSeed(int x, int y) {
        fields.get(x).get(y).setLevel(1);
    }

    void harvestCarrot(int x, int y) {
        fields.get(x).get(y).setLevel(0);
    }

    public void show_off_debug() {
        StringBuilder farmFields = new StringBuilder();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                farmFields.append(fields.get(i).get(j).getLvl()).append("\t");
            }
            farmFields.append("\n");
        }

        System.out.println("Hello I am Farm!");
        System.out.println("SunExposure: " + SunExposure);
        System.out.println("Humidity: " + Humidity);
        System.out.println(farmFields);//<---------------
    }

    public void show_off() {
        StringBuilder farmFields = new StringBuilder();
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
                farmFields.append(fieldIcon).append(' ');
            }
            farmFields.append("\n");
        }

        System.out.println("Hello I am Farm!");
        System.out.println("SunExposure: " + SunExposure);
        System.out.println("Humidity: " + Humidity);
        System.out.println(farmFields);
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
