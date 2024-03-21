package com.ubo.schoolregistrybackend.enums;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public enum RoleType {

    ADMIN(1,
            Set.of(
                    PermissionType.ADMIN_READ,
                    PermissionType.ADMIN_UPDATE,
                    PermissionType.ADMIN_DELETE,
                    PermissionType.ADMIN_CREATE,
                    PermissionType.USER_READ
            )
    ),
    // Represents a user role with user-related permissions.
    USER(2,
            Set.of(
                  PermissionType.USER_READ
            )
    );
    // Represents a pharmacy role with pharmacy-related permissions.
    // Stores the associated permissions for a role.
    private final Set<PermissionType> permissions;
    private final int value;

    public Set<PermissionType> getPermissions() {
        return permissions;
    }

    public int getValue() {
        return value;
    }



    RoleType(int value, Set<PermissionType> permissions) {
        this.value = value;
        this.permissions = permissions;
    }

    public List<SimpleGrantedAuthority> getAuthorities() {
        var authorities = getPermissions()
                .stream()
                .map(permissionType -> new SimpleGrantedAuthority(permissionType.getPermission()))
                .collect(Collectors.toList());

        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }
}
