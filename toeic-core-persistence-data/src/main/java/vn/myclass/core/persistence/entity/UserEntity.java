package vn.myclass.core.persistence.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(name = "name")
    private String name;
    @Column(name = "password")
    private String password;
    @Column(name = "fullname")
    private String fullName;
    @Column(name = "createddate")
    private Timestamp createdDate;

    @OneToMany(mappedBy = "userEntity",fetch = FetchType.LAZY)
    private List<CommentEntity> commentEntityList;

    @ManyToOne
    @JoinColumn(name = "roleid")
    private RoleEntity roleEntity;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullname) {
        this.fullName = fullname;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createddate) {
        this.createdDate = createddate;
    }

    public RoleEntity getRoleEntity() {
        return roleEntity;
    }

    public void setRoleEntity(RoleEntity roleEntity) {
        this.roleEntity = roleEntity;
    }

    public List<CommentEntity> getCommentEntityList() {
        return commentEntityList;
    }

    public void setCommentEntityList(List<CommentEntity> commentEntityList) {
        this.commentEntityList = commentEntityList;
    }
}


