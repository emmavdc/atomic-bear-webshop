package com.webshop.sportnutrition.dataAccess.repository;

import com.webshop.sportnutrition.dataAccess.entity.CategoryEntity;
import com.webshop.sportnutrition.dataAccess.entity.LanguageEntity;
import com.webshop.sportnutrition.dataAccess.entity.TranslationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface TranslationRepository extends JpaRepository<TranslationEntity, Integer> {

    ArrayList<TranslationEntity> findByLanguage(LanguageEntity language);
}
