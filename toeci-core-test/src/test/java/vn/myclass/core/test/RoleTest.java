package vn.myclass.core.test;

import org.testng.annotations.Test;
import vn.myclass.core.dao.RoleDao;
import vn.myclass.core.daoimpl.RoleDaoImpl;
import vn.myclass.core.persistence.entity.RoleEntity;

import java.util.List;

public class RoleTest {
    @Test
    public void checkFindAll(){
        RoleDao roleDao = new RoleDaoImpl();
        List<RoleEntity> list = roleDao.findAll();
    }

    @Test
    public void checkUpdateRole(){
        RoleDao roleDao = new RoleDaoImpl();
        RoleEntity entity = new RoleEntity();
        entity.setRoleId(2);
        entity.setName("USER");
        roleDao.update(entity);
    }
}
