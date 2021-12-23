package cc.fireflyhut.selftech.controller;

import cc.fireflyhut.selftech.annotation.MyAnnotation;
import cc.fireflyhut.selftech.dto.BaseRequest;
import cc.fireflyhut.selftech.dto.BaseResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class CommonController {

    @PostMapping("/part1")
    @ResponseBody
    //@MyAnnotation(something = "控制层注解上的一些信息")  // 这里加上我们自定义的注解并在属性中传值
    public String getSomething() {
        return "{\"msg\":\"success\"}";
    }


    @PostMapping(path = "/converterTest", produces = "application/json;charset=utf-8", consumes = "application/x-www-form-urlencoded")
    public BaseResponse justFillSomePara(BaseRequest baseRequest) {
        System.out.println(baseRequest.toString());  // 打印请求参数
        if (baseRequest.getReqTime() == null || baseRequest.getRpid() == null) {
            return new BaseResponse("failed", "-1000");
        }
        return new BaseResponse("succcess", "0000");
    }

}


