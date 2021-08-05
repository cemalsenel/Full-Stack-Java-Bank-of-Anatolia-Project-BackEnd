package com.bank.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="user_role")
@Getter
@Setter
@NoArgsConstructor
public class UserRole {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long userId;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="user_id")
    private User user;


    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn
    private Role role;

    public UserRole(User user, Role role){
        this.user = user;
        this.role = role;
    }
}
