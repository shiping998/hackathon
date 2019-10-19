package com.cmb.XiaoCHelper.model;

import lombok.Data;

@Data
public class Rtn {
    private String rtn_cod = "200";//返回码
    private String rtn_msg = "OK";//返回消息
    private Object result;//返回结果
}
