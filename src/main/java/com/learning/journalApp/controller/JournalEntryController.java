//package com.learning.journalApp.controller;
//
//import com.learning.journalApp.entity.JournalEntry;
//import io.swagger.v3.oas.annotations.tags.Tag;
//import org.bson.types.ObjectId;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/_journal")
//@Tag(name = "Journal Entry Old APIs", description = "Please use Journal Entry APIs, deprecated endpoints")
//public class JournalEntryController {
//
//    private Map<ObjectId, JournalEntry> journalEntries = new HashMap<>();
//
//    @GetMapping
//    public List<JournalEntry> getAll(){
//        return new ArrayList<>(journalEntries.values());
//    }
//
//    @PostMapping
//    public boolean createEntry(@RequestBody JournalEntry myEntry){
//        journalEntries.put(myEntry.getId(), myEntry);
//        return true;
//    }
//
//    @GetMapping("/id/{myId}")
//    public JournalEntry getJournalEntryById(@PathVariable Long myId){
//        return journalEntries.get(myId);
//    }
//
//    @DeleteMapping("/id/{myId}")
//    public boolean deleteJournalEntryById(@PathVariable Long myId){
//        journalEntries.remove(myId);
//        return true;
//    }
//
//    @PutMapping("/id/{myId}")
//    public JournalEntry updateJournalEntryById(@PathVariable ObjectId myId,@RequestBody JournalEntry journalEntry){
//        return journalEntries.put(myId, journalEntry);
//    }
//
//}
