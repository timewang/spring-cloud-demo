/**
 *
 */
package org.snailgary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangzhongfu on 2017/12/15.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@RestController
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    private UserClient userClient;

    @GetMapping("default")
    public User defaultUser() {
        return this.userClient.getUserById(2L);
    }


}
