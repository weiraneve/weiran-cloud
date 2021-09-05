package com.weiran.missionplanning.biz.timer;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * discription:
 */
@Data
@Component
@ConfigurationProperties(prefix = "timer")
@EqualsAndHashCode(callSuper = false)
public class TimeConfiguration {
    private String corn1;
    private String corn2;
    private String corn3;
}
