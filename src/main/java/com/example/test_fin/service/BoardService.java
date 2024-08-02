package com.example.test_fin.service;

import com.example.test_fin.dto.request.PatchBoardRequestDto;
import com.example.test_fin.dto.request.PostBoardRequestDto;
import com.example.test_fin.dto.response.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface BoardService {
    ResponseEntity<? super GetAllBoardResponseDto> getAllBoard();
    ResponseEntity<? super GetBoardResponseDto> getBoard(Long BoardId);
    ResponseEntity<? super PostBoardResponseDto> postBoard(PostBoardRequestDto dto);
    ResponseEntity<? super PatchBoardResponseDto> patchBoard(PatchBoardRequestDto dto, Long NoticeId);
    ResponseEntity<? super DeleteBoardResponseDto> deleteBoard(Long BoardId);

}
