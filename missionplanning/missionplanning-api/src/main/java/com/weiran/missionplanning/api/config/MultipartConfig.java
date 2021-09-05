package com.weiran.missionplanning.api.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.MultipartConfigElement;
import java.io.File;

/**
 * discription:
 *
 * @author luobin@weiran.com
 * @date 2019/3/25 0025 14:31
 */
@Configuration
public class MultipartConfig {

    @Value("${spring.servlet.multipart.location}")
    private String tempPath;

    /**
     * 修改文件上传临时路径
     */
    @Bean
    MultipartConfigElement multipartConfigElement() {
        String path = tempPath + "_multipartFile";
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }

        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setLocation(file.getAbsolutePath());
        return factory.createMultipartConfig();
    }
}
