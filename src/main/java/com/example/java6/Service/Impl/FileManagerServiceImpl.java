package com.example.java6.Service.Impl;

import com.example.java6.Service.FileManagerService;
import jakarta.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileManagerServiceImpl implements FileManagerService {
    @Autowired
    private ResourceLoader resourceLoader;

    private final Path CURRENT_FOLDER = Paths.get(System.getProperty("user.dir")+ "/src/main/resources/static/");

    @Override
    public List<String> saveFileImgAccount(String folder, MultipartFile[] files) {
        List<String> filenames = new ArrayList<>();
        Path staticPath = Paths.get("");
        Path imagePath = staticPath.resolve(folder);

        try {
            if (!Files.exists(CURRENT_FOLDER.resolve(imagePath))) {
                Files.createDirectories(CURRENT_FOLDER.resolve(imagePath));
            }

            for (MultipartFile file : files) {
                String name = System.currentTimeMillis() + file.getOriginalFilename();
                String filename = Integer.toHexString(name.hashCode()) + name.substring(name.lastIndexOf("."));
                Path filePath = CURRENT_FOLDER.resolve(imagePath).resolve(filename);
                System.out.println("File path: " + filePath.toString());

                try (OutputStream os = Files.newOutputStream(filePath)) {
                    os.write(file.getBytes());
                }

                filenames.add(filename);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return filenames;
    }

    @Override
    public void deleteFile(String folder, String filename) {
        Path staticPath = Paths.get("static");
        Path imagePath = staticPath.resolve(folder);
        Path filePath = CURRENT_FOLDER.resolve(imagePath).resolve(filename);

        try {
            if (Files.exists(filePath)) {
                Files.delete(filePath);
                System.out.println("File deleted successfully: " + filePath.toString());
            } else {
                System.out.println("File not found: " + filePath.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error deleting file: " + filePath.toString());
        }
    }

    @Override
    public byte[] getFile(String folder, String name) {
        Path currentFolder = Paths.get("").toAbsolutePath(); // Adjust this according to your setup
        Path staticPath = currentFolder.resolve("static");
        Path imagePath = staticPath.resolve(folder);
        Path filePath = imagePath.resolve(name);

        try {
            System.out.println(filePath);
            return Files.readAllBytes(filePath);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<String> getFolder(String folder) {
        List<String> filenames = new ArrayList<>();
        Path imagePath = CURRENT_FOLDER.resolve(folder);
        File dir = imagePath.toFile();

        if (dir.exists() && dir.isDirectory()) {
            File[] files = dir.listFiles();
            for(File file: files) {
                filenames.add(file.getName());
            }
        }
        return filenames;
    }


}
