package com.adravo.meeting.result;

import lombok.Value;

@Value
public class MeetingResult {

    private final boolean valid;
    private final MeetingFailureReason failureReason;

    public static MeetingResult valid() {
        return new MeetingResult(true, null);
    }

}

