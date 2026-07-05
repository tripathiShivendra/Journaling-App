package com.myProject.Project1.repository;

import com.myProject.Project1.entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public interface JournalEntryRepository extends MongoRepository<JournalEntry, ObjectId> {

}
