package com.Backend_Aplication_Start.Backend_Demo.User_Controlling_Scripts;


import org.springframework.data.jpa.repository.JpaRepository;

interface EmployeeRepository extends JpaRepository<User, Long> {

}
