package com.example.test_fin.dto.response;

import com.example.test_fin.common.ResponseCode;
import com.example.test_fin.common.ResponseMessage;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
public class PatchBoardResponseDto extends ResponseDto {
    private PatchBoardResponseDto(){super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);}

    public static ResponseEntity<PatchBoardResponseDto> success(){
        PatchBoardResponseDto responseBody = new PatchBoardResponseDto();
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
    public static ResponseEntity<ResponseDto> notExistNotice(){
        ResponseDto responseBody = new ResponseDto(ResponseCode.NOT_EXISTED_NOTICE,ResponseMessage.NOT_EXISTED_BOARD);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
    }

    public static ResponseEntity<? super PatchBoardResponseDto> notExistBoard() {
        ResponseDto responseBody = new ResponseDto(ResponseCode.NOT_EXISTED_NOTICE,ResponseMessage.NOT_EXISTED_BOARD);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
    }
}
