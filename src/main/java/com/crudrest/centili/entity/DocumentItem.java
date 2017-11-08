package com.crudrest.centili.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class DocumentItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_document_item")
    private int idDocumentItem;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    @JoinColumn(name = "document_id_document", referencedColumnName = "id_document")
    @ManyToOne
    @JsonBackReference
    @NotNull(message = "documentIdDocument can not be empty")
    private Document documentIdDocument;

    public DocumentItem() {
    }

    public DocumentItem(String name, Double price, Document documentIdDocument) {
        this.name = name;
        this.price = price;
        this.documentIdDocument = documentIdDocument;
    }

    @Override
    public String toString() {
        return "DocumentItem{" +
                "idDocumentItem=" + idDocumentItem +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", documentIdDocument=" + documentIdDocument +
                '}';
    }

    public int getIdDocumentItem() {
        return idDocumentItem;
    }

    public void setIdDocumentItem(int idDocumentItem) {
        this.idDocumentItem = idDocumentItem;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Document getDocumentIdDocument() {
        return documentIdDocument;
    }

    public void setDocumentIdDocument(Document documentIdDocument) {
        this.documentIdDocument = documentIdDocument;
    }

}
