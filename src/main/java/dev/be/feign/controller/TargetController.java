package dev.be.feign.controller;

import dev.be.feign.feign.common.dto.BaseResponseInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/target_server")
@RestController
public class TargetController {

    @GetMapping("/get")
    public BaseResponseInfo callGet(
            @RequestHeader("CustomHeaderName") String header,
            @RequestParam("name") String name,
            @RequestParam("age") Long age
    ) {
        return BaseResponseInfo.builder()
                .header(header)
                .name(name)
                .age(age)
                .build();
    }

    @PostMapping("/post")
    public BaseResponseInfo callPost(
            @RequestHeader("CustomHeaderName") String header,
            @RequestBody BaseResponseInfo body
    ) {
        return BaseResponseInfo.builder()
                .header(header)
                .name(body.getName())
                .age(body.getAge())
                .build();
    }

    @GetMapping("/error")
    public ResponseEntity<BaseResponseInfo> callErrorDecoder() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
