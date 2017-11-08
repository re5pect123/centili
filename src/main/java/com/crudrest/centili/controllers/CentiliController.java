package com.crudrest.centili.controllers;

import com.crudrest.centili.entity.Document;
import com.crudrest.centili.entity.DocumentItem;
import com.crudrest.centili.repository.CentiliDocumentRepository;
import com.crudrest.centili.services.CentiliDocumentService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CentiliController {

    @Autowired
    CentiliDocumentService centiliDocumentService;

    @Autowired
    CentiliDocumentRepository centiliDocumentRepository;

    @PostMapping(value = "/addName")
    public String addOnlyName(@RequestBody Document document){
        Document d = new Document();
        d.setName(document.getName());
        centiliDocumentRepository.save(d);
        return "OK";
    }

    @PostMapping(value = "/addDocument")
    public String add(@RequestBody Document document){

        List<DocumentItem> documentItemCollection = new ArrayList<>();
        DocumentItem di = null;

        for (int i = 0; i < document.getDocumentItemCollection().size(); i++) {
            di = new DocumentItem();
            di.setName(new ArrayList<>(document.getDocumentItemCollection()).get(i).getName());
            documentItemCollection.add(di);
        }

        Document d = new Document();
        d.setName(document.getName());
        d.setCode(document.getCode());
        d.setIdDocument(document.getIdDocument());
        d.setDocumentItemCollection(documentItemCollection);
        di.setDocumentIdDocument(d);

        for (DocumentItem documentItem : documentItemCollection) {
            documentItem.setDocumentIdDocument(d);
        }

        centiliDocumentService.saveDocument(d);

        return "OK";
    }

    @GetMapping("/getAll")
    @JsonIgnore
    public List<Document> getAll(){
        return centiliDocumentRepository.findAll();
    }

    @PostMapping(value = "/addMe")
    public String addMe(@RequestBody Document requestDocument){

        List <DocumentItem> listDocumentItem = new ArrayList<>();
        DocumentItem documentItem = null;

        for (int i = 0; i < requestDocument.getDocumentItemCollection().size(); i++) {
            documentItem = new DocumentItem();
            documentItem.setName(new ArrayList<>(requestDocument.getDocumentItemCollection()).get(i).getName());
            documentItem.setPrice(new ArrayList<>(requestDocument.getDocumentItemCollection()).get(i).getPrice());

            listDocumentItem.add(documentItem);
        }

        Document document = new Document();
        document.setName(requestDocument.getName());
        document.setCode(requestDocument.getCode());
        document.setIdDocument(requestDocument.getIdDocument());

        document.setDocumentItemCollection(listDocumentItem);

        for (DocumentItem documentItems : listDocumentItem) {
            documentItems.setDocumentIdDocument(document);
        }

        centiliDocumentService.saveDocument(document);

        return "OK";
    }
    @DeleteMapping("/delete")
    public String deleteMe(@RequestBody Document document){
        centiliDocumentRepository.delete(document.getIdDocument());
        return "DELETE";
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable Integer id, @RequestBody Document document){
        Document zaUpdate = centiliDocumentRepository.findOne(id);
        zaUpdate.setName(document.getName());
        centiliDocumentRepository.saveAndFlush(zaUpdate);
    }






}
