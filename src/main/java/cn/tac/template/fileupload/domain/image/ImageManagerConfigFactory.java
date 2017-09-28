package cn.tac.template.fileupload.domain.image;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tac
 * @since 28/09/2017
 */
public class ImageManagerConfigFactory {
    private static Map<String, ImageManagerConfig> configs = new HashMap<>();

    public static void put(String key, ImageManagerConfig value){
        configs.put(key, value);
    }

    public static ImageManagerConfig get(String key){
        if(configs.containsKey(key)){
            return configs.get(key);
        }
        //todo::
        throw new RuntimeException();
    }
}
