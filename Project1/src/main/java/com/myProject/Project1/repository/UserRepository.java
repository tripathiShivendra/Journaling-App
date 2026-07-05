package com.myProject.Project1.repository;

import com.myProject.Project1.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends MongoRepository<User, ObjectId> {
    User findByUserName(String userName);
    User deleteByUserName(String userName);
}
