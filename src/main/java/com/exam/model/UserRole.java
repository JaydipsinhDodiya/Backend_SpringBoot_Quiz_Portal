package com.exam.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userRoleId;

    //Many To One User
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    //Many To One Role
    @ManyToOne
    private Role role;


}
