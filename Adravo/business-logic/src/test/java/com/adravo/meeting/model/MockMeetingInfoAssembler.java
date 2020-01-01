package com.adravo.meeting.model;

import com.adravo.meeting.model.value.MeetingDescription;
import com.adravo.meeting.model.value.MeetingTitle;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
public abstract class MockMeetingInfoAssembler {

    private MeetingTitle title;
    private MeetingDescription description;
    private LocalDateTime votingDeadline;

    public MockMeetingInfoAssembler withTitle(String title) {
        this.title = new MeetingTitle(title);
        return this;
    }

    public MockMeetingInfoAssembler withDescription(String description) {
        this.description = new MeetingDescription(description);
        return this;
    }

    public MockMeetingInfoAssembler withVotingDeadline(String votingDeadline) {
        this.votingDeadline = parse(votingDeadline);
        return this;
    }

    public MeetingInfo createMeetingInfo() {
        return new MeetingInfo(getTitle(), getDescription(), getVotingDeadline());
    }

    public abstract void create();

    private LocalDateTime parse(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(date, formatter);
    }
}
