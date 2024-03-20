package com.ubo.schoolregistrybackend.enums;

public enum PermissionType {

    ADMIN_READ("admin:read"),
    ADMIN_UPDATE("admin:update"),
    ADMIN_CREATE("admin:create"),
    ADMIN_DELETE("admin:delete"),
    USER_READ("user:read");

    // Stores the permission string associated with a permission.
    private final String permission;

    PermissionType(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
