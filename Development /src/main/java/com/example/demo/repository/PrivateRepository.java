package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.PrivateEntity;

@Repository
public interface PrivateRepository extends JpaRepository<PrivateEntity, Integer> {
	List<PrivateEntity> findAllByOrderByIdAsc();
//	List<PrivateEntity> getOne();
}