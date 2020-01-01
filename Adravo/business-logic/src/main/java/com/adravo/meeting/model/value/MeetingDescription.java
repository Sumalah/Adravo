package com.adravo.meeting.model.value;

import lombok.Value;

@Value
public class MeetingDescription {

    public static MeetingDescription EMPTY = new MeetingDescription("");

    private String meetingDescription;
}
