package com.mongodb.userDetailsMongo.dto;

import com.mongodb.userDetailsMongo.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class userdto {

    @Autowired
    User user;

}
