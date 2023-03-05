package searchengine.services;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.HashMap;

@Configuration
@ConfigurationProperties(prefix = "config")
@Getter
@Setter
public class ConfigService {

    private String userAgent;
    private String referrer;
    private String webInterfacePath;
    private ArrayList<HashMap<String, String>> sites;
    private String url;
    private String username;
    private String password;
}
