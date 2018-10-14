package com.inkafarma.personsapi.util;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "spring.application")
public class Properties {
    private Map<String, String> deathProbability = new HashMap<String, String>();

    private List<String> range = new ArrayList<>();

    private Map<String, String> averageLifeHope = new HashMap<String, String>();
}
