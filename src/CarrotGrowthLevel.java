public enum CarrotGrowthLevel {

    INFECTED, //zainfekowane szkodnikiem (lvl -1)
    EMPTY, //puste (lvl 0)
    SEED, //nasiono (lvl 1)
    SAMPLING, //"sadzonka" (lvl 2)
    GROWING, //"wzrastająca" (lvl 3)
    IMMATURE, //niedojrzała (lvl 4)
    MATURE; //dojrzała (lvl 5)

    public CarrotGrowthLevel lvlUp(CarrotGrowthLevel givenLvl){
        return CarrotGrowthLevel.values()[givenLvl.ordinal() + 1];
    }


    //TODO: xxxxx
    /*
    INFECTED(-1), //zainfekowane szkodnikiem
    EMPTY(0), //puste
    SEED(1), //nasiono
    SAMPLING(2), //"sadzonka"
    GROWING(3), //"wzrastająca"
    IMMATURE(4), //niedojrzała
    MATURE(5); //dojrzała

    private int lvl;

    CarrotGrowthLevel(int defaultLvl){
        lvl = defaultLvl;
    }
     */
}
