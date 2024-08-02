package com.example.test_fin.dto.response;

import com.example.test_fin.common.ResponseCode;
import com.example.test_fin.common.ResponseMessage;
import com.example.test_fin.entity.BoardEntity;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
@Getter
public class GetBoardResponseDto extends ResponseDto{
    private BoardEntity board;

    public GetBoardResponseDto(BoardEntity board){
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.board = board;
    }

    public static ResponseEntity<GetBoardResponseDto> success(BoardEntity noticeEntity){
        GetBoardResponseDto responseBody = new GetBoardResponseDto(noticeEntity);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }


    public static ResponseEntity<ResponseDto> notExistNotice(){
        ResponseDto responseBody = new ResponseDto(ResponseCode.NOT_EXISTED_NOTICE,ResponseMessage.NOT_EXISTED_BOARD);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
    }
}
