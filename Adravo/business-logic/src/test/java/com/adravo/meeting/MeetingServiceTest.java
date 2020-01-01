package com.adravo.meeting;

import com.adravo.meeting.model.MeetingInfo;
import com.adravo.meeting.model.MeetingMember;
import com.adravo.meeting.model.MockMeetingInfoAssembler;
import com.adravo.meeting.model.MockMeetingMemberAssembler;
import com.adravo.meeting.result.MeetingResult;
import com.adravo.time.CurrentDateService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class MeetingServiceTest {

    private MeetingResult result;
    private List<MeetingMember> meetingMembers;
    private MeetingInfo meetingInfo;

    @Mock
    private CurrentDateService currentDateService;
    @InjectMocks
    private MeetingService instance;

    @BeforeEach
    public void setUp() {
        meetingMembers = new ArrayList<>();
    }

    @Test
    public void testOnCreateMeeting() {
        //given
        currentDate("2019-01-01 10:00:00");
        meetingInfo()
                .withTitle("Foo Bar Title")
                .withDescription("Foo Bar Description")
                .withVotingDeadline("2019-01-03 10:00:00")
                .create();
        meetingMember().withUserName("Adam").withEmailAddress("adam@gmail.com").create();
        meetingMember().withUserName("Jasiek").withEmailAddress("jasiek@gmail.com").create();

        //when
        createMeeting();

        //then
        assertResult(MeetingResult.valid());
    }

    @Test
    public void testOnCreateMeeting2() {
        //given
        currentDate("2019-01-01 10:00:00");
        meetingInfo()
                .withDescription("Foo Bar Description")
                .withVotingDeadline("2019-01-03 10:00:00")
                .create();
        meetingMember().withUserName("Adam").withEmailAddress("adam@gmail.com").create();
        meetingMember().withUserName("Jasiek").withEmailAddress("jasiek@gmail.com").create();

        //when
        createMeeting();

        //then
        assertResult(MeetingResult.valid());
    }

    private void assertResult(MeetingResult expectedMeetingResult) {
        assertEquals(expectedMeetingResult, result);
    }

    private void createMeeting() {
        result = instance.createMeeting(meetingInfo, meetingMembers);
    }

    private void currentDate(String date) {
//        when(currentDateService.getCurrentDateTime()).thenReturn(parse(date));
    }

    private LocalDateTime parse(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(date, formatter);
    }

    private MockMeetingMemberAssemblerImpl meetingMember() {
        return new MockMeetingMemberAssemblerImpl();
    }

    private MockMeetingInfoAssemblerImpl meetingInfo() {
        return new MockMeetingInfoAssemblerImpl();
    }

    private class MockMeetingInfoAssemblerImpl extends MockMeetingInfoAssembler {

        @Override
        public void create() {
            meetingInfo = createMeetingInfo();
        }
    }

    private class MockMeetingMemberAssemblerImpl extends MockMeetingMemberAssembler {

        @Override
        public void create() {
            meetingMembers.add(createMeetingMember());
        }
    }
}