package com.example.UserMS.Entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class User {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long userID;

    private String userName;
    private Long userPhoneNumber;
    private String userEmail;
    private String password;

}
