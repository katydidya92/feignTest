package dev.be.feign.feign.client;

import dev.be.feign.feign.common.dto.BaseRequestInfo;
import dev.be.feign.feign.common.dto.BaseResponseInfo;
import dev.be.feign.feign.config.DemoFeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(
        // 어떤 이름을 사용할지
        name = "demo-client",
        // 요청을 보내고자하는 url
        url = "${feign.url.prefix}",
        // 어떤 config를 적용할지
        configuration = DemoFeignConfig.class
)
public interface DemoFeignClient {

    // http://localhost:8080/target_server/get과 동일
    @GetMapping("/get")
    ResponseEntity<BaseResponseInfo> callGet(
            @RequestHeader("CustomHeaderName") String customHeader,
            @RequestParam("name") String name,
            @RequestParam("age") Long age
    );

    @PostMapping("/post")
    ResponseEntity<BaseResponseInfo> callPost(
            @RequestHeader("CustomHeaderName") String customHeader,
            @RequestBody BaseRequestInfo baseRequestInfo
    );

    @GetMapping("/error")
    ResponseEntity<BaseResponseInfo> callError();

}
