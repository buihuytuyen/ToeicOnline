package vn.myclass.core.persistence.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "listenguideline")
public class ListenGuideLineEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer listenGuideLineId;

    @Column(name = "title")
    private String title;

    @Column(name = "image")
    private String image;
    @Column(name = "context")
    private String context;
    @Column(name = "createddate")
    private Timestamp createdDate;
    @Column(name = "modifieddate")
    private Timestamp modifiedDate;

    @OneToMany(mappedBy = "listenGuideLineEntity",fetch = FetchType.LAZY)
    private List<CommentEntity> commentEntityList;

    public List<CommentEntity> getCommentEntityList() {
        return commentEntityList;
    }

    public void setCommentEntityList(List<CommentEntity> commentEntityList) {
        this.commentEntityList = commentEntityList;
    }

    public Integer getListenGuidelineId() {
        return listenGuideLineId;
    }

    public void setListenGuidelineId(Integer listenGuidelineId) {
        this.listenGuideLineId = listenGuidelineId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Timestamp getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Timestamp modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}
