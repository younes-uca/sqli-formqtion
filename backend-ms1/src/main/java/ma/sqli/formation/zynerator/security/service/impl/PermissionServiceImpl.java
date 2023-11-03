package ma.sqli.formation.zynerator.security.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import  ma.sqli.formation.zynerator.security.bean.Permission;
import ma.sqli.formation.zynerator.security.dao.PermissionDao;
import ma.sqli.formation.zynerator.security.service.facade.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionDao permissionDao;

    @Override
    public Permission save(Permission permission) {
        Permission perm = permissionDao.findByName(permission.getName());
        return perm == null ? permissionDao.save(permission) : perm;
    }
}
