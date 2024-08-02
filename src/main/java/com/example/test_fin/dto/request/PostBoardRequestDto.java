package com.example.test_fin.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class PostBoardRequestDto {
//    @GeneratedValue (strategy = GenerationType.IDENTITY)
//    @Id
    @NotBlank
    private String title;
    @NotBlank
    private String content;
}
