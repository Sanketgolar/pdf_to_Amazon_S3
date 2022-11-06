package com.netcracker.pdfapp.Dao;

import com.netcracker.pdfapp.Models.filedb;
import org.springframework.data.jpa.repository.JpaRepository;

public interface pdfappdao extends JpaRepository<filedb,String> {
}
