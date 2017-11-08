package com.crudrest.centili.services;

import com.crudrest.centili.entity.Document;
import com.crudrest.centili.repository.CentiliDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CentiliDocumentService {

    @Autowired
    CentiliDocumentRepository centiliDocumentRepository;

    public List<Document> giveMe(){
        List<Document> list = new ArrayList<>();
        list = centiliDocumentRepository.findAll();
        return list;
    }


    public Document saveDocument(Document d){
        return centiliDocumentRepository.save(d);
    }
}
