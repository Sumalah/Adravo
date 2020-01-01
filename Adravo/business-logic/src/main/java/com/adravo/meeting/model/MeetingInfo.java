package com.adravo.meeting.model;

import com.adravo.meeting.model.value.MeetingDescription;
import com.adravo.meeting.model.value.MeetingTitle;
import lombok.Value;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Value
class MeetingInfo {

    @NotNull
    private MeetingTitle title;
    private MeetingDescription description;
    private LocalDateTime votingDeadline;
}
