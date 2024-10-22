package com.learning.journalApp.dto;

import com.learning.journalApp.enums.Sentiment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JournalEntryDTO {

    private String title;
    private String content;
    private Sentiment sentiment;

}
