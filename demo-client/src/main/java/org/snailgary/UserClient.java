/**
 *
 */
package org.snailgary;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by wangzhongfu on 2017/12/22.
 */
@FeignClient("demo-netflix")
public interface UserClient {

    @GetMapping("/user/{userId}")
    User getUserById(@PathVariable("userId") Long userId);

}
