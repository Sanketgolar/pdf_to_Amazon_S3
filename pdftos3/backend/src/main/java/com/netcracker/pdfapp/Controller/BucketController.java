package com.netcracker.pdfapp.Controller;


import com.netcracker.pdfapp.Dao.pdfappdao;
import com.netcracker.pdfapp.Models.filedb;
import com.netcracker.pdfapp.Services.AmazonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/storage/")
public class BucketController {

    private AmazonClient amazonClient;

    @Autowired
    pdfappdao mydb;

    @Autowired
    BucketController(AmazonClient amazonClient) {
        this.amazonClient = amazonClient;
    }

    @PostMapping("/uploadFile")
    public String uploadFile(@RequestPart(value = "file") MultipartFile file) {
        return this.amazonClient.uploadFile(file);
    }

    @GetMapping("/filedb")
    public List<filedb> getFiles()
    {
       return  mydb.findAll();
    }

}
