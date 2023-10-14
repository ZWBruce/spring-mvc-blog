package com.example.controller;

import com.example.common.Resp;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/api")
@PropertySource("file.properties")
public class FileController {
  @Value("${file.dir}")
  String dir;

  @PostMapping("/file")
  public Resp<String> uploadFile(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
    if(file.isEmpty()) {
      return new Resp<>(null);
    }
    String filename = file.getOriginalFilename();

    System.out.println("in file upload");

    Path filePath = Paths.get(this.dir).resolve(filename);
    
    
    // TODO 判断目录是否存在

    int index = filename.lastIndexOf('.');
    String name = filename.substring(0, index);

    String suffix = filename.substring(index);

    String finalFilename = filename;

    int i = 1;
    while(Files.exists(filePath)) {
      finalFilename = name + "_" + (i++) + suffix;
      filePath = Paths.get(this.dir).resolve(finalFilename);
    }
    System.out.println("filePath: " + filePath.toString());
    Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

    return new Resp<String>("/static/" + finalFilename);
  }
}
