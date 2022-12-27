package dev.be.feign.feign.common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseRequestInfo {
    private String name;
    private Long age;
}

// @JsonInclude(JsonInclude.Include.NON_NULL)
// {
//  "name" : null 을 방지한다.
// }

