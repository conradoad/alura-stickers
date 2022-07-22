package br.com.alura.languages.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LanguagesController {

    @Autowired
    private LanguageRepository repository;

    // private List<Language> languages = 
    //     List.of(
    //         new Language("Java", "https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/java/java_256x256.png", 1),
    //         new Language("PHP", "https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/php/php_256x256.png", 2)
    //     );

    // @GetMapping("/")
    // public String processHome() {
    //     return "Home!";
    // }
    
    @GetMapping("/languages")
    public List<Language> getLanguages() {
        List<Language> languages = repository.findAll();
        return languages;
    }

    @PostMapping("/languages")
    public Language registerLanguage(@RequestBody Language language) {
        Language savedLanguage = repository.save(language);
        return savedLanguage;
    }

}