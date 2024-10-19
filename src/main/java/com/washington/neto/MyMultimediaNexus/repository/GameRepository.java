package com.washington.neto.MyMultimediaNexus.repository;

import com.washington.neto.MyMultimediaNexus.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
