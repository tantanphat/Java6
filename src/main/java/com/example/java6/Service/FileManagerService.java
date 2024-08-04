package com.example.java6.Service;

import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.List;

public interface FileManagerService {
    List<String> saveFileImgAccount(String folder, MultipartFile[] files);

    void deleteFile(String folder, String name);

    byte[] getFile(String folder, String name);

    List<String> getFolder(String folder);
}
