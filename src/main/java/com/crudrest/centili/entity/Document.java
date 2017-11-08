package com.crudrest.centili.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;


@Entity
@Table(name = "document")
public class Document implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_document")
    private Integer idDocument;

    @Column(name = "code")
    private String code;

    @Column(name = "date")
    private Date date;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "documentIdDocument")
    @JsonManagedReference
    private Collection<DocumentItem> documentItemCollection;

    public Document() {
    }

    public Document(String code, Date date, String name, Collection<DocumentItem> documentItemCollection) {
        this.code = code;
        this.date = date;
        this.name = name;
        this.documentItemCollection = documentItemCollection;
    }

    @Override
    public String toString() {
        return "Document{" +
                "idDocument=" + idDocument +
                ", code='" + code + '\'' +
                ", date=" + date +
                ", name='" + name + '\'' +
                ", documentItemCollection=" + documentItemCollection +
                '}';
    }

    public Integer getIdDocument() {
        return idDocument;
    }

    public void setIdDocument(Integer idDocument) {
        this.idDocument = idDocument;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Collection<DocumentItem> getDocumentItemCollection() {
        return documentItemCollection;
    }

    public void setDocumentItemCollection(Collection<DocumentItem> documentItemCollection) {
        this.documentItemCollection = documentItemCollection;
    }

}
