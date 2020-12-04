package com.zdw.snail.security;

import com.zdw.snail.dao.RoleDao;
import com.zdw.snail.dao.UserDao;
import com.zdw.snail.model.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

@Component
public class MyUserDetailsService implements UserDetailsService {

    Logger log = LoggerFactory.getLogger(MyUserDetailsService.class);

    @Autowired
    UserDao userDao;

    @Autowired
    RoleDao roleDao;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserEntity userEntity = userDao.getUserEntityByLoginName(userName);
        if(userEntity == null){
            throw new UsernameNotFoundException("用户名："+ userName + "不存在！");
        }
        String password = userEntity.getPassword();
        log.info(password);

        Collection<SimpleGrantedAuthority> collection = new HashSet<SimpleGrantedAuthority>();
        Iterator<String> iterator = roleDao.getRolesByUserId(userEntity.getId()).iterator();
        while (iterator.hasNext()){
            collection.add(new SimpleGrantedAuthority(iterator.next()));
        }
        return new User(userName, password ,collection);
    }
}
