package com.akshay.projects.lovable.service.impl;

import com.akshay.projects.lovable.DTO.project.FileContentResponse;
import com.akshay.projects.lovable.DTO.project.FileNode;
import com.akshay.projects.lovable.service.FileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileServiceimpl implements FileService {

    @Override
    public List<FileNode> getFileTree(Long projectId, Long userId){
        return null;
    }

    @Override
    public FileContentResponse getFileContent(Long projectId, String path, Long userId){
        return null;
    }

}
