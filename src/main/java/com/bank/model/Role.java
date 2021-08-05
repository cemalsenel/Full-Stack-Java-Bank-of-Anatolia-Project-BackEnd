package com.bank.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="")
public class Role {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long roleId;
    private String name;


    @OneToMany(mappedBy="role", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    private Set<UserRole> userRoles = new HashSet<UserRole>();
}
