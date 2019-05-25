package com.ouzt.issuemanagement.entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;


@MappedSuperclass //diğer classlarda extend edilebilir hale geliyor.
@Getter
@Setter
public abstract class BaseEntity implements Serializable {
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "created_by" , length = 100) // lenght veremezsen 255 ayırır
    private String createdBy;
    @Column(name = "update_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateAt;
    @Column(name = "update_by")
    private String updateBy;
    @Column(name = "status")
    private Boolean status;


}
