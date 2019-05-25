package com.ouzt.issuemanagement.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="project")
@Data //getter setter oluşturur.
@NoArgsConstructor  //boş constructer oluşturur
@AllArgsConstructor //dolu cons
@ToString //toString metdou oluşturur.
@EqualsAndHashCode //HashCode
public class Project extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="project_code" ,unique = true)
    private String projectCode;
    @Column(name="project_name")
    private String projectName;
    @JoinColumn(name="manager_user_id")
    @ManyToOne(optional = true , fetch = FetchType.LAZY)
    private User manager ;


}
