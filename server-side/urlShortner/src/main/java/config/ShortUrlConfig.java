package config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
//this is the configuration for the parameters of key generation.
@ConfigurationProperties(prefix = "short-url")
@Getter
@Setter
public class ShortUrlConfig {
    private String allowedCharacters;
    private int keyLength;
}
