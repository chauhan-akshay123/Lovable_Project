package com.akshay.projects.lovable.service;

import com.akshay.projects.lovable.DTO.member.InviteMemberRequest;
import com.akshay.projects.lovable.DTO.member.MemberResponse;
import com.akshay.projects.lovable.DTO.member.UpdateMemberRoleRequest;

import java.util.List;

public interface ProjectMemberService {

    List<MemberResponse> getProjectMembers(Long projectId);

    MemberResponse inviteMember(Long projectId, InviteMemberRequest request);
    MemberResponse updateMemberRole(Long projectId, Long memberId, UpdateMemberRoleRequest request);

    void removeProjectMember(Long projectId, Long memberId);
}
