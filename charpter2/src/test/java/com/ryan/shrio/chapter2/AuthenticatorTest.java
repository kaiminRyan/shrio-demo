package com.ryan.shrio.chapter2;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.apache.shiro.util.ThreadContext;
import org.junit.After;

/**
 * Created by Administrator on 2018/3/1.
 */
public class AuthenticatorTest {





    public void login(String configFilePath){
        Factory<SecurityManager> factory = new IniSecurityManagerFactory(configFilePath);
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken ryan = new UsernamePasswordToken("ryan", "123");
        try {
            //4、登录，即身份验证
            subject.login(ryan);
        } catch (AuthenticationException e) {
            //5、身份验证失败
        }
    }


    @After
    public void tearDown() throws Exception {
        ThreadContext.unbindSubject();//退出时请解除绑定Subject到线程 否则对下次测试造成影响
    }
}
