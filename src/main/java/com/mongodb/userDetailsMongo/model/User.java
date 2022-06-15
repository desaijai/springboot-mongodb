package com.mongodb.userDetailsMongo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Persistent;
import org.springframework.data.mongodb.core.mapping.Document;

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

}
