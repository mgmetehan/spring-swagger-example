package com.mgmetehan.springswagger.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Benim User nesnem", description = "Benim User")
public class User {
    @ApiModelProperty(notes = "ID alani")
    private Long id;

    @ApiModelProperty(notes = "Username alani")
    private String username;

    @ApiModelProperty(notes = "Surname alani")
    private String surname;

    @ApiModelProperty(notes = "Password alani")
    private String password;
}
