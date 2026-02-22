package com.akshay.projects.lovable.service.impl;

import com.akshay.projects.lovable.DTO.member.InviteMemberRequest;
import com.akshay.projects.lovable.DTO.member.MemberResponse;
import com.akshay.projects.lovable.DTO.member.UpdateMemberRoleRequest;
import com.akshay.projects.lovable.service.ProjectMemberService;

import java.util.List;

public class ProjectMemberServiceimpl implements ProjectMemberService {

    @Override
    public List<MemberResponse> getProjectMembers(Long projectId, Long userId){
        return null;
    }

    @Override
    public MemberResponse inviteMember(Long projectId, InviteMemberRequest request, Long userId){
        return null;
    }

    @Override
    public MemberResponse updateMemberRole(Long projectId, Long memberId, UpdateMemberRoleRequest request, Long userId){
        return null;
    }

    @Override
    public MemberResponse deleteProjectMember(Long projectId, Long memberId, Long userId){
        return null;
    }
}
