package com.lemon.commons.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author LyuBo
 * @create 2020-07-11 12:18
 */
@Data
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String msg;
    private T data;
    public CommonResult(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    public CommonResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public static CommonResult success(Object data) {
        return new CommonResult(200, "成功", data);
    }
    public static CommonResult fail(Object data) {
        return new CommonResult(500, "失败", data);
    }
}
