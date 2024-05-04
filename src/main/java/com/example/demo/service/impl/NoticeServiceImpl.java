package com.example.demo.service.impl;

import com.example.demo.domain.noticeAndAnnouncement.NoticeAndAnnouncement;
import com.example.demo.domain.response.Response;
import com.example.demo.service.NoticeService;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.demo.config.SystemConst.NOTICE_AND_ANNOUNCEMENT_LIST;


@Service
public class NoticeServiceImpl implements NoticeService {

    @Override
    public Response<List<NoticeAndAnnouncement>> getNoticeList() {
        return Response.success(NOTICE_AND_ANNOUNCEMENT_LIST);
    }
}
