package com.zdw.snail.service;

import com.zdw.snail.model.UserEntity;

import java.util.List;

public interface UserService {

    /**
     * 通过登录名得到用户信息
     * @param loginName
     * @return
     */
    public UserEntity getUserEntityByLoginName(String loginName);

    /**
     * 获取user列表
     * @param loginName
     * @param pageSize
     * @param start
     * @return
     */
    public List<UserEntity> usersList(String loginName, int pageSize, int start);

    /**
     * 获取user列表的总量
     * @param loginName
     * @param pageSize
     * @param start
     * @return
     */
    public Integer usersSize(String loginName, int pageSize, int start);

    /**
     * 新建用户信息
     * @param userEntity
     */
    public void insertUser(UserEntity userEntity);

    /**
     * 更新用户信息
     * @param userEntity
     */
    public void updateUser(UserEntity userEntity);

    /**
     * 删除用户信息
     * @param groupId
     */
    public void deleteUsers(List<String> groupId);
}
