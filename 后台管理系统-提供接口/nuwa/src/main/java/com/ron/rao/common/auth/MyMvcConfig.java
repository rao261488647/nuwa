package com.ron.rao.common.auth;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * srping mvc 相关启动配置参数
 * <p>Title:com.ron.paradise.core.auth.MyMvcConfig</p>
 * <p>Description:</p>
 * <p>Company:沫兰遗夏的后花园</p>
 * @author 沫兰遗夏
 * @date 2018年2月11日 下午4:05:37
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
	@Value("${file.staticAccessPath}")
	private String staticAccessPath;
	@Value("${file.uploadFolder}")
	private String uploadFolder;
//	@Override
//	public void addResourceHandlers(
//	ResourceHandlerRegistry registry) {
//			registry.addResourceHandler("/resources/**")
//			.addResourceLocations("/resources/")
//			.setCachePeriod(3_155_6926);
//	}
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
		registry.addResourceHandler(staticAccessPath).addResourceLocations("file:" + uploadFolder);
	}
}
