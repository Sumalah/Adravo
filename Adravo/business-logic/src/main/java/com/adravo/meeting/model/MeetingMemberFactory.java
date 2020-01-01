package com.adravo.meeting.model;

import com.adravo.EmailAddress;
import com.adravo.UserName;

public class MeetingMemberFactory {

    public static MeetingMember createDTO(UserName userName, EmailAddress emailAddress) {
        return new MeetingMember(userName, emailAddress);
    }
}
