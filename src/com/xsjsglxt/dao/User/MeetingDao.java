package com.xsjsglxt.dao.User;

import com.xsjsglxt.domain.DO.xsjsglxt_meeting;
import com.xsjsglxt.domain.DTO.User.meetingSearchDTO;
import com.xsjsglxt.domain.VO.User.meetingByPageAndSerarchVO;

public interface MeetingDao {
	public String saveMeetingRecords(xsjsglxt_meeting meet);

	public String updateMeetingRecords(xsjsglxt_meeting meet);

	public String deleteMeetingRecords(String[] meeting_ids);

	public xsjsglxt_meeting getMeetingRecordsById(String meeting_id);

	public meetingSearchDTO ListMeetRecordsBySearch(meetingByPageAndSerarchVO meetVO);

	public int getCountMeetRecordsBySearch(meetingByPageAndSerarchVO meetVO);
}