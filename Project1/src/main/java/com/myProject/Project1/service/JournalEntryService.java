package com.myProject.Project1.service;

import com.myProject.Project1.entity.JournalEntry;
import com.myProject.Project1.entity.User;
import com.myProject.Project1.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    @Autowired
    private UserService userService;

    public void saveEntry(JournalEntry journalEntry){
        journalEntry.setDate(LocalDateTime.now());
        journalEntryRepository.save(journalEntry);
    }
    @Transactional
    public void saveEntry(JournalEntry journalEntry, User user){
        journalEntry.setDate(LocalDateTime.now());
        JournalEntry saved=journalEntryRepository.save(journalEntry);
        user.getJournalEntries().add(saved);
        userService.saveUser(user);
    }

    public List<JournalEntry> getAll(){
        return journalEntryRepository.findAll();
    }

    public JournalEntry getById(ObjectId myId){
        return journalEntryRepository.findById(myId).orElse(null);
    }

    @Transactional
    public boolean deleteById(ObjectId myId,String userName){
        User user = userService.findByUserName(userName);
        boolean rem = false;
        rem = user.getJournalEntries().removeIf(x->x.getId().equals(myId));
        if(rem){
            userService.saveUser(user);
            journalEntryRepository.deleteById(myId);
        }
        return rem;
    }

}
