package utils;

import constants.FrameworkConstants;
import constants.enums.ConfigProperties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public class PropertyUtilis {
    private PropertyUtilis(){
    }
    private static Properties property = new Properties();
    private static final Map<String, String> CONFIGMAP = new HashMap<>();
    static {
        try {
            FileInputStream file = new FileInputStream(FrameworkConstants.getConfigFilPath().trim());
            property.load(file);
            property.entrySet().forEach(entry -> CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue())));
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static String get(ConfigProperties key) throws Exception{
        //If the value of a key is not present property.getProperty(key) or the key is null
        if(Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))){
            throw new Exception(key + " Property is Not found in your file, Please Check config.properties");
        }
        return CONFIGMAP.get(key.name().toLowerCase()); //else return the value
    }
}
