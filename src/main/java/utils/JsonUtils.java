package utils;

import constants.FrameworkConstants;
import constants.enums.ConfigProperties;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class JsonUtils {
    private static Map<String, String> CONFIGMAP;
    private JsonUtils(){
    }

    static{
        try {
            CONFIGMAP = new ObjectMapper().readValue(new File(FrameworkConstants.getJsonConfigFilePath()),
                    new TypeReference<HashMap<String, String>>() {
                    });
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static String get(ConfigProperties key) throws Exception {
        if (Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))) {
            throw new Exception("Property name " + key + " is not found. Please check Config.json");
        }
        return CONFIGMAP.get(key.name().toLowerCase());
    }


}
