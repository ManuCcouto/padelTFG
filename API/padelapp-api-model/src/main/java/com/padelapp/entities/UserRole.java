package com.padelapp.entities;

import java.util.ArrayList;
import java.util.List;

public enum UserRole {
    USER("ROLE_USER"),
    ADMIN("ROLE_ADMIN"),
    MONITOR("ROLE_MONITOR"),
    MEMBER("ROLE_MEMBER");

    private final String roleName;

    UserRole(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }
    public static List<String> getAllRoleNames(List<UserRole> userRoles) {
        List<String> roleNames = new ArrayList<>();
        for (UserRole role : userRoles) {
            roleNames.add(role.getRoleName());
        }
        return roleNames;
    }
}
