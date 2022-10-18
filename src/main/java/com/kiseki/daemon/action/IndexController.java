package com.kiseki.daemon.action;

import com.kiseki.daemon.result.Result;
import com.kiseki.daemon.result.ResultEnum;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/index")
public class IndexController {

    @PostMapping("/getData")
    public Result getData(@RequestBody Map<String, Object> params) {

        StringBuilder paramsStr = new StringBuilder();
        if (!params.isEmpty()) {
            params.forEach((k,v) -> {
                paramsStr.append("key: ").append(k)
                        .append(", value: ").append(v).append("; ");
            });
        }
        return new Result(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage(), paramsStr.toString());
    }
}
