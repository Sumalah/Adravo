package com.adravo.meeting.model.value;

import lombok.Value;

import javax.validation.constraints.NotBlank;

@Value
public class MeetingTitle {

    @NotBlank(message = "Meeting title cannot be empty")
    String meetingTitle;
}
