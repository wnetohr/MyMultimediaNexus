package com.washington.neto.MyMultimediaNexus.repository;

import com.washington.neto.MyMultimediaNexus.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
}