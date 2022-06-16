package com.mongodb.userDetailsMongo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Persistent;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "product")
public class product {

    @Persistent
    public static final String PRODUCTKEY_GENERATE="productkey";

    @Id
    private int pid;
    private String pro_name;
    private int pro_qty;
    private double pro_price;
}
