package com.mongodb.userDetailsMongo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Persistent;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "User_Cred")
public class User {

    @Persistent
    public static final String GENERATE_SEQUENCE="sequence";

    @Id
    private int uid;
    private String uname;
    private String upassword;
    private String uemail;
    private List<Accounts> uaccounts;
    private Address uaddress;
    private List<product> uproducts;

    @CreatedDate
    private LocalDateTime createdOn= LocalDateTime.now();

    @LastModifiedDate
    private LocalDateTime updateOn=LocalDateTime.now();

}
