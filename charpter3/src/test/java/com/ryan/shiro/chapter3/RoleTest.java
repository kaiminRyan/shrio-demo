package com.ryan.shiro.chapter3;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by Administrator on 2018/3/1.
 */
public class RoleTest extends BaseTest{
    @Test
    public void testHasRole(){
        login("classpath:shiro-role.ini","zhang","123");
        Assert.assertTrue(subject().hasAllRoles(Arrays.asList("role2","role1")));
        Assert.assertTrue(subject().hasRole("role2"));
        boolean[] result = subject().hasRoles(Arrays.asList("role2", "role1", "role3"));
        Assert.assertEquals(true, result[0]);
        Assert.assertEquals(true, result[1]);
        Assert.assertEquals(true, result[2]);
    }
}
