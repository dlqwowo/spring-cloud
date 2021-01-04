package com.power.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: PowerQun
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    private String message;
    private T data;
    private int code;

    public CommonResult(Integer code,String message){
        this.message = message;
        this.code = code;
        this.data = null;
    }
}
