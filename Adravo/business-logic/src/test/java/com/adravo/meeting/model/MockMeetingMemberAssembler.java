package com.adravo.meeting.model;

import com.adravo.EmailAddress;
import com.adravo.UserName;
import lombok.Getter;

@Getter
public abstract class MockMeetingMemberAssembler {

    private UserName userName;
    private EmailAddress emailAddress;

    public MockMeetingMemberAssembler withUserName(String userName) {
        this.userName = new UserName(userName);
        return this;
    }

    public MockMeetingMemberAssembler withEmailAddress(String emailAddress) {
        this.emailAddress = new EmailAddress(emailAddress);
        return this;
    }

    public MeetingMember createMeetingMember() {
        return new MeetingMember(getUserName(), getEmailAddress());
    }

    public abstract void create();

}
