package com.example.test_fin.dto.response;


import com.example.test_fin.common.ResponseCode;
import com.example.test_fin.common.ResponseMessage;
import com.example.test_fin.entity.BoardEntity;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Getter
public class GetAllBoardResponseDto extends ResponseDto {

    private List<BoardEntity> boards;

    public GetAllBoardResponseDto(List<BoardEntity> boards){
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.boards = boards;
    }

    public static ResponseEntity<GetAllBoardResponseDto> success(List<BoardEntity> boards){
        GetAllBoardResponseDto responseBody = new GetAllBoardResponseDto(boards);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

}
