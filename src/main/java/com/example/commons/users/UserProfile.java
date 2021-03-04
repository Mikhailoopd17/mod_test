package com.example.commons.users;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(
        ignoreUnknown = true
)
@NoArgsConstructor
public class UserProfile {
    @JsonProperty("user_id")
    private Long userId;
    private String login;
    private Integer role;
}
