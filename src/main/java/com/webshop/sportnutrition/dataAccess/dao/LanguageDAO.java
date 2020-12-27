package com.webshop.sportnutrition.dataAccess.dao;

import com.webshop.sportnutrition.dataAccess.entity.LanguageEntity;
import com.webshop.sportnutrition.dataAccess.repository.LanguageRepository;
import com.webshop.sportnutrition.dataAccess.util.ProviderConverter;
import com.webshop.sportnutrition.model.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class LanguageDAO implements LanguageDataAccess {

    public LanguageRepository languageRepository;
    public ProviderConverter providerConverter;

    @Autowired
    public LanguageDAO(LanguageRepository languageRepository, ProviderConverter providerConverter) {
        this.languageRepository = languageRepository;
        this.providerConverter = providerConverter;
    }

    @Override
    public ArrayList<Language> getAll() {
        return convertListFromDBToArrayList(languageRepository.findAll());
    }

    public ArrayList<Language> convertListFromDBToArrayList(List<LanguageEntity> listFromDB) {
        ArrayList<Language> languages = new ArrayList<>();
        for (LanguageEntity entity : listFromDB) {
            Language language = providerConverter.languageEntityToLanguageModel(entity);
            languages.add(language);
        }
        return languages;
    }
}
