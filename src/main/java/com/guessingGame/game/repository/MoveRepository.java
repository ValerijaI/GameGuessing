package com.guessingGame.game.repository;

import com.guessingGame.game.entity.MoveEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoveRepository extends JpaRepository<MoveEntity, Integer> {
}
