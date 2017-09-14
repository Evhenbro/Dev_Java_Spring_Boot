package ua.com.yarema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.yarema.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByLogin(String login);
	
}
