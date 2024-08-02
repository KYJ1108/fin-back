package com.example.test_fin.service.serviceImplement;

import com.example.test_fin.dto.request.PatchBoardRequestDto;
import com.example.test_fin.dto.request.PostBoardRequestDto;
import com.example.test_fin.dto.response.*;
import com.example.test_fin.entity.BoardEntity;
import com.example.test_fin.repository.BoardRepository;
import com.example.test_fin.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class BoardServiceImplement implements BoardService {
    private final BoardRepository boardRepository;

    @Override
    public ResponseEntity<? super GetAllBoardResponseDto> getAllBoard() {
        List<BoardEntity> boards = null;
        try {
            boards = boardRepository.findAll();
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetAllBoardResponseDto.success(boards);
    }

    @Override
    public ResponseEntity<? super GetBoardResponseDto> getBoard(Long BoardId) {
        BoardEntity boardEntity = null;
        try {
            boardEntity = boardRepository.findByBoardId(BoardId);
            if (boardEntity == null) return GetBoardResponseDto.notExistNotice();
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetBoardResponseDto.success(boardEntity);
    }

    @Override
    public ResponseEntity<? super PostBoardResponseDto> postBoard(PostBoardRequestDto dto) {
        try {
            BoardEntity boardEntity = new BoardEntity(dto);
            boardRepository.save(boardEntity);
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return PostBoardResponseDto.success();
    }

    @Override
    public ResponseEntity<? super PatchBoardResponseDto> patchBoard(PatchBoardRequestDto dto, Long BoardId) {
        try {
            BoardEntity boardEntity = boardRepository.findByBoardId(BoardId);
            if (boardEntity == null) return PatchBoardResponseDto.notExistBoard();
            boardEntity.patchBoard(dto);
            boardRepository.save(boardEntity);
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return PatchBoardResponseDto.success();
    }

    @Override
    public ResponseEntity<? super DeleteBoardResponseDto> deleteBoard(Long BoardId) {
        try {
            BoardEntity boardEntity = boardRepository.findByBoardId(BoardId);
            if (boardEntity == null) return DeleteBoardResponseDto.notExistBoard();
            boardRepository.delete(boardEntity);
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return DeleteBoardResponseDto.success();
    }
}
