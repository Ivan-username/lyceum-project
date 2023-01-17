package com.example.lyceumapi.repository;

import com.example.lyceumapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

}
