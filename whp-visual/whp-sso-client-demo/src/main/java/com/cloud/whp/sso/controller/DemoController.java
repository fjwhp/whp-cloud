
package com.cloud.whp.sso.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author whp
 * @date 2018-12-20
 * demo controller
 */
@RestController
public class DemoController {
    @GetMapping("/user")
    public Authentication user(Authentication authentication) {
        return authentication;
    }
}
