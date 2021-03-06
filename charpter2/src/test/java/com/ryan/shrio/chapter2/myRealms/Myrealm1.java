package com.ryan.shrio.chapter2.myRealms;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * Created by ryan on 2018/2/28.
 */
public class Myrealm1 implements Realm{
    public String getName() {
        return "Myrealm1";
    }

    public boolean supports(AuthenticationToken authenticationToken) {
        return authenticationToken instanceof UsernamePasswordToken;
    }

    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String usernmae =(String) authenticationToken.getPrincipal();
        String password =new String((char[])authenticationToken.getCredentials());
        if (!"ryan".equals(usernmae)) {
            throw new UnknownAccountException();
        }
        if (!"123".equals(password)) {
            throw new IncorrectCredentialsException();
        }

        return new SimpleAuthenticationInfo(usernmae,password,getName());
    }
}
