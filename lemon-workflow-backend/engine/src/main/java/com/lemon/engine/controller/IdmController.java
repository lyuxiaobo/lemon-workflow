package com.lemon.engine.controller;

import com.lemon.commons.entities.CommonResult;
import com.lemon.engine.vo.LoginVO;
import lombok.extern.slf4j.Slf4j;
import org.flowable.engine.IdentityService;
import org.flowable.idm.api.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author LyuBo
 * @create 2020/9/4 16:08
 */
@Slf4j
@RestController
@CrossOrigin
public class IdmController {

    @Resource
    private IdentityService identityService;

    /**
     * 登录
     * @param name
     * @param password
     * @return
     */
    @PostMapping("login")
    public CommonResult login(String name, String password) {
        User user = identityService.createUserQuery().userFirstName(name).singleResult();
        if (user == null) {
            return new CommonResult(500, "没有此用户", null);
        } else {
            boolean isCorrect = identityService.checkPassword(user.getId(), password);
            LoginVO loginVO = new LoginVO();
            loginVO.setDisplayName(user.getDisplayName());
            //密码是正确的
            if (isCorrect) {
                //查询到此用户，返回userId
                loginVO.setUserId(user.getId());
                loginVO.setUserName(user.getFirstName());
                return new CommonResult(200, "成功", loginVO);
            } else {
                // 密码不正确
                return new CommonResult(500, "密码不正确", null);
            }
        }
    }

}
