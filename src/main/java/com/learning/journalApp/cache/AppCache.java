package com.learning.journalApp.cache;

import com.learning.journalApp.entity.ConfigJournalApp;
import com.learning.journalApp.repository.ConfigJournalAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AppCache {

    public enum keys{
        WEATHER_API;
    }

    @Autowired
    private ConfigJournalAppRepository configJournalAppRepository;

    public Map<String, String> appCache = new HashMap<>();

    //Right when the AppCache bean is created init() method will be called due to @PostConstruct
    //We are creating an in-memory cache so that to fetch a value from DB that doesn't change for long time and store it
    //We don't actually need to poll DB and hence reducing latency
    @PostConstruct
    public void init(){
        List<ConfigJournalApp> all = configJournalAppRepository.findAll();
        for(ConfigJournalApp configJournalApp : all){
            appCache.put(configJournalApp.getKey(), configJournalApp.getValue());
        }
    }

}
