package com.zdw.snail.service.impl;

import com.zdw.snail.dao.UserDao;
import com.zdw.snail.model.UserEntity;
import com.zdw.snail.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserEntity getUserEntityByLoginName(String loginName) {
        return userDao.getUserEntityByLoginName(loginName);
    }

    @Override
    public List<UserEntity> usersList(String loginName, int pageSize, int start) {
        return userDao.usersList( loginName,  pageSize,  start);
    }

    @Override
    public Integer usersSize(String loginName, int pageSize, int start) {
        return userDao.usersSize(loginName, pageSize, start);
    }

    @Override
    public void insertUser(UserEntity userEntity) {
        userEntity.setPassword("{bcrypt}" + new BCryptPasswordEncoder().encode(userEntity.getPassword()));
        userDao.insertUser(userEntity);
    }

    @Override
    public void updateUser(UserEntity userEntity) {
        userEntity.setPassword("{bcrypt}" + new BCryptPasswordEncoder().encode(userEntity.getPassword()));
        userDao.updateUser(userEntity);
    }

    @Override
    public void deleteUsers(List<String> groupId) {
        userDao.deleteUsers(groupId);
    }


}
