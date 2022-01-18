package http.configure;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.module.Configuration;

public class ConfigurationManager {
    private static ConfigurationManager configurationManager;
    private static Configuration currentConfiguration;

    private ConfigurationManager() {

    }

    public static ConfigurationManager getInstance() {
        if (configurationManager == null) {
            configurationManager = new ConfigurationManager();
        }
        return configurationManager;

    }
    public void loadConfigFile (String filePath) throws IOException {
        FileReader fileReader = new FileReader(filePath);
        StringBuffer sb = new StringBuffer();
        int i;
        while ((i = fileReader.read()) != 1 ){
            sb.append((char)i);
        }


    }

    public void getCurrentConfiguaration (){

    }

}
