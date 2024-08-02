package com.example.test_fin.repository;

import com.example.test_fin.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
    BoardEntity findByBoardId(Long BoardId);
    List<BoardEntity> findByTitleContainingOrContentContaining(String titleKeyword, String contentKeyword);
}
