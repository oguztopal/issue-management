package com.ouzt.issuemanagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="uname" , length = 100, unique = true)
    private String username;

    @Column(name="pwd" , length = 200)
    private String password;

    @Column(name="name_surname",length = 100)
    private String nameSurname;

    @Column(name="email")
    private String email;

    @JoinColumn(name="assignee_user_id")
    @OneToMany(fetch = FetchType.LAZY)
    private List<Issue> issues;


}
