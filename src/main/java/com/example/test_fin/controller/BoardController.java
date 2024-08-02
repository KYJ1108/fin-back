package com.example.test_fin.controller;

import com.example.test_fin.dto.request.PatchBoardRequestDto;
import com.example.test_fin.dto.request.PostBoardRequestDto;
import com.example.test_fin.dto.response.*;
import com.example.test_fin.service.BoardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/board")
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/list")
    public ResponseEntity<? super GetAllBoardResponseDto> getAllBoard() {
        ResponseEntity<? super GetAllBoardResponseDto> response = boardService.getAllBoard();
        return response;
    }

    @GetMapping("/detail/{boardId}")
    public ResponseEntity<? super GetBoardResponseDto> getBoard(
            @PathVariable("boardId") Long boardId
    ) {
        ResponseEntity<? super GetBoardResponseDto> response = boardService.getBoard(boardId);
        return response;
    }

    @PostMapping("")
    public ResponseEntity<? super PostBoardResponseDto> postBoard(
            @RequestBody @Valid PostBoardRequestDto requestBody
    ) {
        ResponseEntity<? super PostBoardResponseDto> response = boardService.postBoard(requestBody);
        return response;
    }

    @PatchMapping("/modify/{boardId}")
    public ResponseEntity<? super PatchBoardResponseDto> patchBoard(
            @RequestBody @Valid PatchBoardRequestDto requestBody,
            @PathVariable("boardId") Long boardId
    ) {
        ResponseEntity<? super PatchBoardResponseDto> response = boardService.patchBoard(requestBody, boardId);
        return response;
    }

    @DeleteMapping("/delete/{boardId}")
    public ResponseEntity<? super DeleteBoardResponseDto> deleteNotice(
            @PathVariable("boardId") Long boardId
    ){
        ResponseEntity<? super DeleteBoardResponseDto> response = boardService.deleteBoard(boardId);
        return response;
    }

}
