package com.example.java6.API;

import com.example.java6.Service.FileManagerService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/api/file")
public class FileAPI {
    private final Path CURRENT_FOLDER = Paths.get(System.getProperty("user.dir")+ "/src/main/resources/static/");

    @Autowired
    private FileManagerService fileService;
    @PostMapping("/save")
    public ResponseEntity<?> upload(@PathParam("file") MultipartFile file){
        try {
            Path staticPath = Paths.get("");
            Path imagePath = staticPath.resolve("account");
            if (file == null || file.isEmpty()) {
                return ResponseEntity.badRequest().body("No file uploaded");
            }
            if (!Files.exists(CURRENT_FOLDER.resolve(imagePath))) {
                Files.createDirectories(CURRENT_FOLDER.resolve(imagePath));
            }
            String filename = file.getOriginalFilename();
            Path filePath = CURRENT_FOLDER.resolve(imagePath).resolve(filename);
            try (OutputStream os = Files.newOutputStream(filePath)) {
                os.write(file.getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok("File uploaded successfully");
    }

    @PostMapping("/saves")
    public ResponseEntity<?> uploads(@RequestParam("files") MultipartFile[] files) {
        if (files == null || files.length == 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No files uploaded");
        }
        List<String> savedFiles = fileService.saveFileImgAccount("files", files);
        return ResponseEntity.status(HttpStatus.OK).body(savedFiles);
    }

    @GetMapping("/get/{folder}")
    public ResponseEntity<?> getFile(@PathVariable("folder") String folder){
        return ResponseEntity.status(HttpStatus.OK).body(fileService.getFolder(folder));
    }


}
