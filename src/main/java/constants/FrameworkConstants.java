package constants;

public final class FrameworkConstants {
    private static final String RESOURCESPATH = System.getProperty("user.dir")+ "\\src\\test\\resources";
    private static final String DATAFOLDER = System.getProperty("user.dir")+ "\\src\\test\\java\\data\\";
    private static final String CONFIGFILEPATH = RESOURCESPATH+"\\config\\config.properties";
    private static final String JSONPATH = RESOURCESPATH+"src/test/java/data/MobilePlanes.json";

    private static final int IMPLICIT_WAIT = 30;
    private static final int FLUENT_WAIT = 30;
    private static final int EXPLICITWAIT = 30;
    public static String getConfigFilPath(){
        return CONFIGFILEPATH;
    }
    public static String getJsonConfigFilePath(){
        return JSONPATH;
    }
    public static int getExplicitWait(){
        return EXPLICITWAIT;
    }
    public static int getFluentWait(){
        return FLUENT_WAIT;
    }
    public static int getImplicitWait(){
        return IMPLICIT_WAIT;
    }


    public static String getDataFilePath(String fileName){
        return DATAFOLDER + fileName;
    }
}
