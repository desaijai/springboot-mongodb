package com.mongodb.userDetailsMongo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Persistent;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "address")
public class Address {

    @Persistent
    public static final String ADDRESSKEY_GENERATE="address_key";

    @Id
    private int aid;
    private String cityName;
    private long zipcode;

}
