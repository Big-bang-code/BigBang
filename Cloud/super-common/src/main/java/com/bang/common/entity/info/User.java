package com.bang.common.entity.info;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@AllArgsConstructor
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class User {

    private Integer id;
    private String userName;
    private Integer password;

    private String e_mail;

}
