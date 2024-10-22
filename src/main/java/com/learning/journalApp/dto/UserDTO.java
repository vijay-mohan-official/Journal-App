package com.learning.journalApp.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    @NotEmpty
    @Schema(description = "This is user's username")
    private String userName;
    @NotEmpty
    @Schema(description = "This is user's password")
    private String password;
    @Schema(description = "This is user's email Id")
    private String email;
    @Schema(description = "This is user's flag for Sentiment Analysis")
    private boolean sentimentAnalysis;

}
