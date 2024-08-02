package com.example.test_fin.entity;

import com.example.test_fin.dto.request.PatchBoardRequestDto;
import com.example.test_fin.dto.request.PostBoardRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity(name="board")
@Table(name="board")
@NoArgsConstructor
@AllArgsConstructor
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;

    private String title;

    private String content;

    public BoardEntity(PostBoardRequestDto dto){
        this.title=dto.getTitle();
        this.content=dto.getContent();
    }
    public void patchBoard(PatchBoardRequestDto dto){
        this.title=dto.getTitle();
        this.content=dto.getContent();
    }
}
