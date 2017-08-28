package ua.com.yarema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.yarema.entity.Table;

public interface TableRepository extends JpaRepository<Table, Integer> {

}
