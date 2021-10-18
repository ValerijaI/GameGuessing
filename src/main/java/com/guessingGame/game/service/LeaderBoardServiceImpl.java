package com.guessingGame.game.service;

import com.guessingGame.game.domain.GameResult;
import com.guessingGame.game.entity.GameResultEntity;
import com.guessingGame.game.repository.GameResultRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LeaderBoardServiceImpl implements LeaderBoardService {

    private final GameResultRepository gameResultRepository;
    private final GameResultConverter gameResultConverter;

    @Override
    public GameResult saveGameResult(GameResult gameResultDto) {
        GameResultEntity gameResultEntity = gameResultRepository.save(gameResultConverter.fromGameResultToGameResultEntity(gameResultDto));
        return gameResultConverter.fromGameResultEntityToGameResult(gameResultEntity);
    }

    @Override
    public List<GameResult> findAll() {
        return gameResultRepository.findAll()
                .stream()
                .map(gameResultConverter::fromGameResultEntityToGameResult)
                .collect(Collectors.toList());
    }

    @Override
    public List<GameResult> findAllWithMoreThanXGames(Integer count) {
        return gameResultRepository.findAll()
                .stream()
                .filter(gameResultEntity -> gameResultEntity.getPlayedGames() > count)
                .map(gameResultConverter::fromGameResultEntityToGameResult)
                .collect(Collectors.toList());
    }
}
