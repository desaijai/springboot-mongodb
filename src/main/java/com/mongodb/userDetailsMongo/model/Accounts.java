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
@Document(collection = "accounts")
public class Accounts {

    @Persistent
    public static final String ACCOUNT_SEQUENCE="accounts_seq";

    @Id
    private int aid;
    private String aname;

}
