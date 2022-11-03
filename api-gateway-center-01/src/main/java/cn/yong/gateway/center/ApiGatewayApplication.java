package cn.yong.gateway.center;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

/**
 * @author Allen
 * @desc 网关注册中心启动服务
 * @date 2022/11/3
 */
@SpringBootApplication
@Configuration
public class ApiGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }
}
