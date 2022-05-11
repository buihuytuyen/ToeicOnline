package vn.myclass.core.persistence.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "role")
public class RoleEntity {
    @Id
    @Column(name = "roleid")
    private Integer roleId;
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "roleEntity", fetch = FetchType.LAZY)
    private List<UserEntity> userEntityList;

    public List<UserEntity> getUserEntityList() {
        return userEntityList;
    }

    public void setUserEntityList(List<UserEntity> userEntityList) {
        this.userEntityList = userEntityList;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roledId) {
        this.roleId = roledId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
