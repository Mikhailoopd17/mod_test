package com.example.commons.users;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.json.GsonJsonParser;

import java.util.List;

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
    private RoleType role;

    public RoleType getRole() {
        return role;
    }

    public void setRole(Integer roleId) {
        this.role = RoleType.fromId(roleId);
    }
}