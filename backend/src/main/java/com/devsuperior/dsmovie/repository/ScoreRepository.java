package com.devsuperior.dsmovie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.dsmovie.entities.Score;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Long>{

}