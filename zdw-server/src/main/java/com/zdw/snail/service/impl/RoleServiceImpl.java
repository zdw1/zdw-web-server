package com.zdw.snail.service.impl;

import com.zdw.snail.dao.RoleDao;
import com.zdw.snail.model.RoleEntity;
import com.zdw.snail.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public List<RoleEntity> rolesList(int pageSize, int start) {
        return roleDao.rolesList(pageSize, start);
    }

    @Override
    public Integer rolesSize(int pageSize, int start) {
        return roleDao.rolesSize(pageSize, start);
    }

    @Override
    public void insertRole(RoleEntity roleEntity) {
        roleEntity.setRole("ROLE_" + roleEntity.getName().toUpperCase());
        roleDao.insertRole(roleEntity);
    }

    @Override
    public void updateRole(RoleEntity roleEntity) {
        roleDao.updateRole(roleEntity);
    }

    @Override
    public void deleteRoles(List<String> groupId) {
        roleDao.deleteRoles(groupId);
    }

    @Override
    public List<RoleEntity> allRoles() {
        return roleDao.allRoles();
    }
}
