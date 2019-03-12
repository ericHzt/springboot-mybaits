package com.example.Configuration;

import com.example.mapper.test1.SysRoleMapper;
import com.example.mapper.test1.SysUserMapper;
import com.example.mapper.test2.SysUserMapper2;
import com.example.model.SysUser;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MyShiroRealm extends AuthorizingRealm{
    private static org.slf4j.Logger logger = LoggerFactory.getLogger(MyShiroRealm.class);


    @Autowired
    SysUserMapper sysUserMapper;
    @Autowired
    SysUserMapper2 sysUserMapper2;
    @Autowired
    SysRoleMapper sysRoleMapper;


    /**
     * 认证信息.(身份验证) : Authentication 是用来验证用户身份
     *
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        logger.info("---------------- 执行 Shiro 凭证认证 ----------------------");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String name = token.getUsername();
        String passWord = String.valueOf(token.getPassword());
        SysUser user = new SysUser();
        user.setUserName(name);
        user.setPassWord(passWord);
        SysUser userList = sysUserMapper.getByUser(user);
        SysUser userList2 = sysUserMapper2.getByUser(user);
        if(userList2!=null)
            System.out.println("===userList2:"+userList2.getUserName());
        if(userList!=null){
            if(userList.getUserEnable()!=1){
                throw new DisabledAccountException();
            }
            SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(userList,userList.getPassWord(),userList.getUserName());
            return authenticationInfo;
        }
        throw new UnknownAccountException();
    }

    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        Object principal = principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        if(principal instanceof SysUser){
            SysUser sysUser = (SysUser)principal;
            List<String> roles = sysRoleMapper.findRoleNameByUserId(sysUser.getId());
            authorizationInfo.addRoles(roles);
            /*authorizationInfo.addRole("SUPERADMINISTATOR");*/

        }
        logger.info("---- 获取到以下权限 ----");
        logger.info(authorizationInfo.getRoles().toString());
        logger.info("---------------- Shiro 权限获取成功 ----------------------");
        return authorizationInfo;
    }
}
