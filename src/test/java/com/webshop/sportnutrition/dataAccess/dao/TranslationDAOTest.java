package com.webshop.sportnutrition.dataAccess.dao;

import com.webshop.sportnutrition.dataAccess.dao.TranslationDAO;
import com.webshop.sportnutrition.dataAccess.entity.CategoryEntity;
import com.webshop.sportnutrition.dataAccess.entity.LanguageEntity;
import com.webshop.sportnutrition.dataAccess.entity.TranslationEntity;
import com.webshop.sportnutrition.dataAccess.repository.TranslationRepository;
import com.webshop.sportnutrition.dataAccess.util.ProviderConverter;
import com.webshop.sportnutrition.model.Language;
import com.webshop.sportnutrition.model.Translation;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class TranslationDAOTest {

    private TranslationDAO translationDAO;

    @Mock
    private TranslationRepository translationRepository;
    @Mock
    private ProviderConverter providerConverter;

    @Test
    public void getAll() {

        // Arrange
        translationDAO = new TranslationDAO(translationRepository, new ProviderConverter());

        String expectedFrTranslation = "Protéines";
        String expectedEnTranslation = "Proteins";

        when(translationRepository.findAll()).thenReturn(getMockedTranslationEntities());

        // Act
        ArrayList<Translation> translations = translationDAO.getAll();
        Optional<Translation> frTranslation = translations.stream().filter(t -> t.getTranslationID() == 1).findFirst();
        Optional<Translation> enTranslation = translations.stream().filter(t -> t.getTranslationID() == 2).findFirst();


        // Assert
        assertEquals(2, translations.size());
        assertEquals(expectedFrTranslation , frTranslation.isPresent() ? frTranslation.get().getLabel() : "");
        assertEquals(expectedEnTranslation, enTranslation.isPresent() ? enTranslation.get().getLabel() : "");

    }

    @Test
    public void getCategoryByLanguageFr() {

        // Arrange
        translationDAO = new TranslationDAO(translationRepository, providerConverter);
        LanguageEntity languageEntityFr = new LanguageEntity();
        languageEntityFr.setLanguageID(1);

        Language languageFr = new Language();
        languageFr.setLanguageID(1);

        when(providerConverter.languageModelToLanguageEntity(languageFr)).thenReturn(languageEntityFr);
        when(providerConverter.translationEntityToTranslationModel(any())).thenCallRealMethod();
        when(translationRepository.findByLanguage(languageEntityFr)).thenReturn(getMockedTranslationEntitiesFr());

        String expectedFrTranslation1 = "Protéines";
        String expectedFrTranslation2 = "Développement musculaire";

        // Act
        ArrayList<Translation> translationsFr = translationDAO.getCategoryByLanguage(languageFr);
        Optional<Translation> translationFr1 = translationsFr.stream().filter(t -> t.getTranslationID() == 1).findFirst();
        Optional<Translation> translationFr2 = translationsFr.stream().filter(t -> t.getTranslationID() == 2).findFirst();

        // Assert
        assertEquals(2, translationsFr.size());

        assertEquals(expectedFrTranslation1, translationFr1.isPresent() ?translationFr1.get().getLabel() : "");
        assertEquals(expectedFrTranslation2, translationFr2.isPresent() ?translationFr2.get().getLabel() : "");

    }

    @Test
    public void getCategoryByLanguageEn() {

        // Arrange
        translationDAO = new TranslationDAO(translationRepository, providerConverter);
        LanguageEntity languageEntityEn = new LanguageEntity();
        languageEntityEn.setLanguageID(2);

        Language languageEn = new Language();
        languageEn.setLanguageID(2);

        when(providerConverter.languageModelToLanguageEntity(languageEn)).thenReturn(languageEntityEn);
        when(providerConverter.translationEntityToTranslationModel(any())).thenCallRealMethod();
        when(translationRepository.findByLanguage(languageEntityEn)).thenReturn(getMockedTranslationEntitiesEn());

        String expectedEnTranslation1 = "Proteins";
        String expectedEnTranslation2 = "Muscle development";


        // Act
        ArrayList<Translation> translationsEn = translationDAO.getCategoryByLanguage(languageEn);
        Optional<Translation> translationEn1 = translationsEn.stream().filter(t -> t.getTranslationID() == 1).findFirst();
        Optional<Translation> translationEn2 = translationsEn.stream().filter(t -> t.getTranslationID() == 2).findFirst();


        // Assert
        assertEquals(2, translationsEn.size());
        assertEquals(expectedEnTranslation1, translationEn1.isPresent() ? translationEn1.get().getLabel() : "");
        assertEquals(expectedEnTranslation2, translationEn2.isPresent() ? translationEn2.get().getLabel() : "");

    }

    private ArrayList<TranslationEntity> getMockedTranslationEntities() {
        ArrayList<TranslationEntity> mockedKeyEntities = new ArrayList<>();
        TranslationEntity translationEntityFr = new TranslationEntity();
        translationEntityFr.setTranslationID(1);
        translationEntityFr.setCategory(new CategoryEntity());
        translationEntityFr.getCategory().setCategoryID(1);
        translationEntityFr.setLabel("Protéines");
        translationEntityFr.setLanguage(new LanguageEntity());
        translationEntityFr.getLanguage().setLanguageID(1);
        mockedKeyEntities.add(translationEntityFr);

        TranslationEntity translationEntityEn = new TranslationEntity();
        translationEntityEn.setTranslationID(2);
        translationEntityEn.setCategory(new CategoryEntity());
        translationEntityEn.getCategory().setCategoryID(1);
        translationEntityEn.setLabel("Proteins");
        translationEntityEn.setLanguage(new LanguageEntity());
        translationEntityEn.getLanguage().setLanguageID(2);
        mockedKeyEntities.add(translationEntityEn);
        return mockedKeyEntities;
    }

    private ArrayList<TranslationEntity> getMockedTranslationEntitiesEn() {
        ArrayList<TranslationEntity> mockedKeyEntities = new ArrayList<>();
        TranslationEntity translationEntityEn = new TranslationEntity();
        translationEntityEn.setTranslationID(1);
        translationEntityEn.setCategory(new CategoryEntity());
        translationEntityEn.getCategory().setCategoryID(1);
        translationEntityEn.setLabel("Proteins");
        translationEntityEn.setLanguage(new LanguageEntity());
        translationEntityEn.getLanguage().setLanguageID(2);
        mockedKeyEntities.add(translationEntityEn);

        TranslationEntity translationEntityEn2 = new TranslationEntity();
        translationEntityEn2.setTranslationID(2);
        translationEntityEn2.setCategory(new CategoryEntity());
        translationEntityEn2.getCategory().setCategoryID(2);
        translationEntityEn2.setLabel("Muscle development");
        translationEntityEn2.setLanguage(new LanguageEntity());
        translationEntityEn2.getLanguage().setLanguageID(2);
        mockedKeyEntities.add(translationEntityEn2);
        return mockedKeyEntities;
    }

    private ArrayList<TranslationEntity> getMockedTranslationEntitiesFr() {
        ArrayList<TranslationEntity> mockedKeyEntities = new ArrayList<>();
        TranslationEntity translationEntityFr = new TranslationEntity();
        translationEntityFr.setTranslationID(1);
        translationEntityFr.setCategory(new CategoryEntity());
        translationEntityFr.getCategory().setCategoryID(1);
        translationEntityFr.setLabel("Protéines");
        translationEntityFr.setLanguage(new LanguageEntity());
        translationEntityFr.getLanguage().setLanguageID(1);
        mockedKeyEntities.add(translationEntityFr);

        TranslationEntity translationEntityFr2 = new TranslationEntity();
        translationEntityFr2.setTranslationID(2);
        translationEntityFr2.setCategory(new CategoryEntity());
        translationEntityFr2.getCategory().setCategoryID(2);
        translationEntityFr2.setLabel("Développement musculaire");
        translationEntityFr2.setLanguage(new LanguageEntity());
        translationEntityFr2.getLanguage().setLanguageID(1);
        mockedKeyEntities.add(translationEntityFr2);
        return mockedKeyEntities;
    }

}