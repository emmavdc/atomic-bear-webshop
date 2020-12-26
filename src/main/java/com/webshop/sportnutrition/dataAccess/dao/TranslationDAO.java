package com.webshop.sportnutrition.dataAccess.dao;

import com.webshop.sportnutrition.dataAccess.entity.TranslationEntity;
import com.webshop.sportnutrition.dataAccess.repository.TranslationRepository;
import com.webshop.sportnutrition.dataAccess.util.ProviderConverter;
import com.webshop.sportnutrition.model.Category;
import com.webshop.sportnutrition.model.Language;
import com.webshop.sportnutrition.model.Translation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TranslationDAO implements TranslationDataAccess {

    public TranslationRepository translationRepository;
    public ProviderConverter providerConverter;

    @Autowired
    public TranslationDAO(TranslationRepository translationRepository, ProviderConverter providerConverter) {
        this.translationRepository = translationRepository;
        this.providerConverter = providerConverter;
    }

    @Override
    public ArrayList<Translation> getAll() {
        return convertListFromDBToArrayList(translationRepository.findAll());
    }

    @Override
    public Translation getByCategoryAndLanguage(Category category, Language language) {
        return providerConverter.translationEntityToTranslationModel(translationRepository.findByCategoryAndLanguage(
                providerConverter.categoryModelToCategoryEntity(category),
                providerConverter.languageModelToLanguageEntity(language)));
    }

    public ArrayList<Translation> convertListFromDBToArrayList(List<TranslationEntity> listFromDB) {
        ArrayList<Translation> translations = new ArrayList<>();
        for (TranslationEntity entity : listFromDB) {
            Translation translation = providerConverter.translationEntityToTranslationModel(entity);
            translations.add(translation);
        }
        return translations;
    }
}
