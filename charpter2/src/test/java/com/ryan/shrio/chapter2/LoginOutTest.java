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
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ryan on 2018/2/28.
 */
public class LoginOutTest {

    @Test
    public void loginTest(){
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shrio.ini");
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

        Assert.assertEquals(true, subject.isAuthenticated()); //断言用户已经登录

        //6、退出
        subject.logout();
    }

    @Test
    public void loginRealm1(){
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shrio-realm.ini");
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

        Assert.assertEquals(true, subject.isAuthenticated()); //断言用户已经登录

        //6、退出
        subject.logout();
    }

    @Test
    public void loginRealm2(){
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shrio-multi-realm.ini");
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

        Assert.assertEquals(true, subject.isAuthenticated()); //断言用户已经登录

        //6、退出
        subject.logout();
    }


    @Test
    public void loginJdbcRealm(){
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shrio-jdbc-realm.ini");
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

        Assert.assertEquals(true, subject.isAuthenticated()); //断言用户已经登录

        //6、退出
        subject.logout();
    }

    @Test
    public void loginTest1(){
        System.out.printf("ssss");
    }

    @After
    public void tearDown() throws Exception {
        ThreadContext.unbindSubject();//退出时请解除绑定Subject到线程 否则对下次测试造成影响
    }
}
