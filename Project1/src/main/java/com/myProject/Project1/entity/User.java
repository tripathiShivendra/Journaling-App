package com.myProject.Project1.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.List;

@Document(collection = "Users")
@Data
@NoArgsConstructor//required for deserialization as jackson has to create the objet for this class
public class User {

    @Id
    private ObjectId id;
    @Indexed(unique = true)//creates indexes for usernames for fast operations makes sure any two usernames aren't same and also auto index creation must be on in application properties for it to work
    @NonNull
    private String userName;
    @NonNull
    private String password;
    @DBRef//stores reference to the journal entries of corresponding user
    private List<JournalEntry> journalEntries;
    private List<String> roles;
    private String email;
    private boolean sentimentAnalysis;
}
