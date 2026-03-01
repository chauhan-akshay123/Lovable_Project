package com.akshay.projects.lovable.mapper;

import com.akshay.projects.lovable.DTO.member.MemberResponse;
import com.akshay.projects.lovable.entity.ProjectMember;
import com.akshay.projects.lovable.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProjectMemberMapper {

    @Mapping(target = "userId", source = "id")
    @Mapping(target = "projectRole", constant = "OWNER")
    MemberResponse toProjectMemberResponse(User owner);

    MemberResponse toProjectMemberResponseFromMember(ProjectMember projectMember);
}
