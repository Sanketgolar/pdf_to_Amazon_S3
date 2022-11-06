package com.netcracker.pdfapp.Models;

import javax.persistence.Entity;

import javax.persistence.Id;

@Entity
public class filedb{
    @Id
    private String id;
    private String fileurl;

    public filedb(){}

    public filedb(String fileurl, String id) {
        //super();
        this.id = id;
        this.fileurl = fileurl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFileurl() {
        return fileurl;
    }

    public void setFileurl(String fileurl) {
        this.fileurl = fileurl;
    }
}
