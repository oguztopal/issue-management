package com.ouzt.issuemanagement.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name="issue")
@Data //getter setter oluşturur.
@NoArgsConstructor  //boş constructer oluşturur
@AllArgsConstructor //dolu cons
@ToString //toString metdou oluşturur.
@EqualsAndHashCode //HashCode
public class Issue extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "description", length = 400)
    private String description;
    @Column(name="details",length = 4000)
    private String details;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="dd-MM-yyyy'T'HH:mm")
    private Date date;
    @Column(name = "issue_status")
    @Enumerated(EnumType.STRING)
    private IssueStatus issueStatus;
    @JoinColumn(name = "assignee_user_id")
    @ManyToOne(optional = true , fetch = FetchType.LAZY) //optional true null kalsada olur demek.
    private User assignee;
}
