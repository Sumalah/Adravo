package com.adravo.meeting.model.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MeetingInfoDTO {
    private Long ownerId;
    private String title;
    private String description;
    private LocalDateTime votingDeadline;
}
