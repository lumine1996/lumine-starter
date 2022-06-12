package com.lumine.starter.base;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 基础控制器
 *
 * @author CGM
 */
@RestController
public class BaseController {
    @GetMapping("/")
    public Result root() {
        // 用于确认后端存活
        return Result.ok("Lumine is shining!");
    }
}
