package com.crudrest.centili.repository;

import com.crudrest.centili.entity.DocumentItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CentiliDocumentItemRepository extends JpaRepository<DocumentItem, Integer> {
}
