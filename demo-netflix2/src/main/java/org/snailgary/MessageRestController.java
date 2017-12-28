/**
 *
 */
package org.snailgary;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangzhongfu on 2017/12/15.
 */
@RefreshScope
@RestController
public class MessageRestController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${message:Hello default}")
    private String message;

    @Value("${server.port}")
    private String port;

    @RequestMapping("/message")
    String getMessage() {

        return this.message;
    }

    @GetMapping("user/{userId}")
    public User getUserById(@PathVariable Long userId) {
        this.logger.info("调用服务 1 *****************************************" + port);
        User user = new User();
        user.setId(userId);
        user.setUsername("test");
        user.setEmail("test@qq.com");
        return user;
    }
}
