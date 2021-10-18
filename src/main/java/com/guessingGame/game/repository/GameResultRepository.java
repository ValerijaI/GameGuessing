package com.guessingGame.game.repository;

import com.guessingGame.game.entity.GameResultEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameResultRepository extends JpaRepository<GameResultEntity, Integer> {
}
