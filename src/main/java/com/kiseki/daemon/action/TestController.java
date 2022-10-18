package com.kiseki.daemon.action;

import com.kiseki.daemon.dto.TestDTO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/test")
@Validated
public class TestController {

    @PostMapping(value = "/getData", produces = "application/json; charset=UTF-8")
    public String getData(@RequestBody Map<String, Object> params) {
        String data = "abcdefg";
        Integer data1 = 6566;
        String data2 = "{\"test\":\"data-test\"}";
        return data2;
    }

    @PostMapping(value = "/test-validation", produces = "application/json; charset=UTF-8")
    public String testValidation(@RequestBody @Validated TestDTO testDTO) {
        return "1";
    }
}
