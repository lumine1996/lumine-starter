package com.lumine.starter.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 通用返回对象
 *
 * @author CGM
 */
@Data
@NoArgsConstructor
public class Result {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String code;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object data;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String exceptionMessage;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;

    private boolean success = true;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer total;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<String> trace;

    public Result(Object data) {
        this.data = data;
    }

    public static Result ok(Object data) {
        return new Result(data);
    }
}
