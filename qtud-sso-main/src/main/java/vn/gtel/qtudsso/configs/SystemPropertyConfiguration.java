package vn.gtel.qtudsso.configs;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;
@Getter
@ConfigurationProperties("system.configurations")
public class SystemPropertyConfiguration {
    private final String[] uriWhiteList;
    private final CorsProperty cors;

    public SystemPropertyConfiguration(String[] uriWhiteList, CorsProperty cors) {
        this.uriWhiteList = uriWhiteList;
        this.cors = cors;

    }
    public record CorsProperty(List<String> allowedOriginPattern, List<String> allowedHeader, List<String> allowedMethods,
                               boolean allowCredentials, String exposedHeader,
                               String urlBasedPatternCorsConfigurationSource) {
    }

}
