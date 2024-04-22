package com.my.ziapro.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class BoardVO 
{
	private String content;
    private String memberName;
    private int boardId;
    private LocalDate regDate;
    
    @Override
    public String toString() {
        return "BoardVO [content=" + content + ", memberName=" + memberName + ", boardId=" + boardId + ", regDate="
                + regDate + "]";
    }
}