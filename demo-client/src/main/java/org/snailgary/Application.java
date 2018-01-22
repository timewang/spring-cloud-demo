/**
 *
 */
package org.snailgary;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.sleuth.SpanName;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangzhongfu on 2017/12/15.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@RestController
@Configuration
public class Application {

    //@Bean

    private static Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    private UserClient userClient;

    @SpanName("calculateTax")
    @GetMapping("default")
    public User defaultUser() {
        this.logger.info("调用服务获取用户信息");
        return this.userClient.getUserById(2L);
    }


}
