package hs.game.snakeback.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import hs.game.snakeback.Entity.Snake;

public interface SnakeRepository extends JpaRepository<Snake, Long>, QuerydslPredicateExecutor<Snake> {

}
