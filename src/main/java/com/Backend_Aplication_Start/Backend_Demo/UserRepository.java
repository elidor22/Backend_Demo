package com.Backend_Aplication_Start.Backend_Demo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}