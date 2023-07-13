package br.com.steamdash.config;

import io.smallrye.config.ConfigMapping;

@ConfigMapping(prefix = "config")
public interface ConfigProperties {

    String apiKeySteam();
}
