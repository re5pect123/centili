package com.crudrest.centili.repository;

import com.crudrest.centili.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CentiliDocumentRepository extends JpaRepository<Document, Integer> {

}
