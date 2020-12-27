package com.webshop.sportnutrition.dataAccess.repository;

import com.webshop.sportnutrition.dataAccess.entity.LanguageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LanguageRepository extends JpaRepository<LanguageEntity, Integer> {

}
