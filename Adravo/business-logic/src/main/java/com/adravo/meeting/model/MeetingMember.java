package com.adravo.meeting.model;

import com.adravo.EmailAddress;
import com.adravo.UserName;
import lombok.Value;

@Value
class MeetingMember {

    private final UserName userName;
    private final EmailAddress emailAddress;
}
