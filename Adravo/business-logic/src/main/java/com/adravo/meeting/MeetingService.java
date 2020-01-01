package com.adravo.meeting;

import com.adravo.meeting.model.Meeting;
import com.adravo.meeting.model.dto.MeetingInfoDTO;
import com.adravo.meeting.model.dto.MeetingMemberDTO;
import com.adravo.meeting.result.MeetingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeetingService {

    private final MeetingFactory meetingFactory;

    @Autowired
    public MeetingService(MeetingFactory meetingFactory) {
        this.meetingFactory = meetingFactory;
    }

    public MeetingResult createMeeting(MeetingInfoDTO meetingInfoDTO, List<MeetingMemberDTO> meetingMembers) {
        Meeting meeting = meetingFactory.createMeeting(meetingInfoDTO, meetingMembers);

        return MeetingResult.valid();
    }

}
