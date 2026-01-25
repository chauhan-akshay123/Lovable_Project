package com.akshay.projects.lovable.DTO.member;

import com.akshay.projects.lovable.enums.ProjectRole;

public record UpdateMemberRoleRequest(
        ProjectRole role
) {
}
