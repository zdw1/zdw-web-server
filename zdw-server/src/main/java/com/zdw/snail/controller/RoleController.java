package com.zdw.snail.controller;

import com.zdw.snail.model.PageResult;
import com.zdw.snail.model.RoleEntity;
import com.zdw.snail.service.RoleService;
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
public class RoleController {

    @Resource
    private RoleService roleService;

    /**
     * 获取role表数据
     *
     * @param pageSize
     * @param page
     * @return
     */
    @GetMapping("/roles")
    public PageResult rolesList(String loginName, int pageSize, int page) {
        PageResult pageResult = new PageResult();
        pageResult.setData(roleService.rolesList(pageSize, page * pageSize));
        pageResult.setTotalCount(roleService.rolesSize(pageSize, page * pageSize));
        return pageResult;
    }

    /**
     * 新建角色信息
     *
     * @param roleEntity
     * @return
     */
    @PostMapping("/roles/role")
    public RoleEntity insertRole(@RequestBody RoleEntity roleEntity) {
        roleService.insertRole(roleEntity);
        return roleEntity;
    }

    /**
     * 更新角色信息
     *
     * @param roleEntity
     * @param id
     * @return
     */
    @PutMapping("/roles/{id}")
    public RoleEntity updateRole(@RequestBody RoleEntity roleEntity, @PathVariable int id) {
        if (roleEntity.getId() == id) {
            roleService.updateRole(roleEntity);
        }
        return roleEntity;
    }

    /**
     * 删除角色信息
     *
     * @param groupId
     * @return
     */
    @DeleteMapping("/roles")
    public List<String> deleteRoles(@RequestBody List<String> groupId) {
        roleService.deleteRoles(groupId);
        return groupId;
    }

    /**
     * 得到角色全部数据
     * @return
     */
    @GetMapping("/roles/all")
    public List<RoleEntity> allRoles(){
        return roleService.allRoles();
    }

}
