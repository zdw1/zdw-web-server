package com.zdw.snail.controller;

import com.zdw.snail.model.PageResult;
import com.zdw.snail.model.UserEntity;
import com.zdw.snail.service.UserService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/user/{loginName}")
    public UserEntity getUserEntityByLoginName(@PathVariable String loginName){
        return userService.getUserEntityByLoginName(loginName);
    }

    /**
     * 获取user表数据
     *
     * @param loginName
     * @param pageSize
     * @param page
     * @return
     */
    @GetMapping("/users")
    public PageResult userList(String loginName, int pageSize, int page){
        PageResult pageResult = new PageResult();
        pageResult.setData(userService.usersList(loginName, pageSize, page * pageSize));
        pageResult.setTotalCount(userService.usersSize(loginName,pageSize,page * pageSize));
        return  pageResult;
    }
    /**
     * 新建用户信息
     *
     * @param userEntity
     * @return
     */
    @PostMapping("/users/user")
    public UserEntity insertUser(@RequestBody UserEntity userEntity) {
        userService.insertUser(userEntity);
        return userEntity;
    }

    /**
     * 更新用户信息
     *
     * @param userEntity
     * @param id
     * @return
     */
    @PutMapping("/users/{id}")
    public UserEntity updateUser(@RequestBody UserEntity userEntity, @PathVariable int id) {
        if (userEntity.getId() == id) {
            userService.updateUser(userEntity);
        }
        return userEntity;
    }

    /**
     * 删除用户信息
     *
     * @param groupId
     * @return
     */
    @DeleteMapping("/users")
    public List<String> deleteUsers(@RequestBody List<String> groupId) {
        userService.deleteUsers(groupId);
        return groupId;
    }
}
