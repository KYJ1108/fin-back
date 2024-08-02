package com.example.test_fin.dto.response;

import com.example.test_fin.common.ResponseCode;
import com.example.test_fin.common.ResponseMessage;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
public class PostBoardResponseDto extends ResponseDto{
    private PostBoardResponseDto(){
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
    }

    public static ResponseEntity<PostBoardResponseDto> success(){
        PostBoardResponseDto responseBody = new PostBoardResponseDto();
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

}
