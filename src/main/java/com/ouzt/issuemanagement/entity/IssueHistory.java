package com.ouzt.issuemanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="issue_history")
@Data //getter setter oluşturur.
@NoArgsConstructor  //boş constructer oluşturur
@AllArgsConstructor //dolu cons
@ToString //toString metdou oluşturur.
public class IssueHistory extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JoinColumn(name="issue_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Issue issue;

    @JoinColumn(name="assignee_user_id")
    @ManyToOne(optional = true , fetch = FetchType.LAZY)
    private User assignee;

    @Column(name="issue_status")
    @Enumerated(EnumType.STRING)
    private IssueStatus issueStatus;

    @Column(name="details",length = 4000)
    private String details;
}
