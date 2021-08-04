package com.lemon.engine.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author LyuBo
 * @create 2020/9/5 16:53
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginVO {
    private String userId;
    private String groupName;
    private String userName;
    private String displayName;
}
