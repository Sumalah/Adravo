package com.adravo.meeting;

import com.adravo.meeting.model.Meeting;
import com.adravo.meeting.model.dto.MeetingInfoDTO;
import com.adravo.meeting.model.dto.MeetingMemberDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class MeetingFactory {

    public Meeting createMeeting(MeetingInfoDTO meetingInfoDTO, List<MeetingMemberDTO> meetingMembers) {
        return null;
    }
}
