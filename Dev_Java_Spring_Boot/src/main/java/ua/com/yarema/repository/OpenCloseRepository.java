package ua.com.yarema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.yarema.entity.OpenClose;

public interface OpenCloseRepository extends JpaRepository<OpenClose, Integer> {

}
