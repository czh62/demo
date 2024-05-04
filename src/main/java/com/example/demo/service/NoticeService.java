package com.example.demo.service;

import com.example.demo.domain.noticeAndAnnouncement.NoticeAndAnnouncement;
import com.example.demo.domain.response.Response;

import java.util.List;

public interface NoticeService {
    Response<List<NoticeAndAnnouncement>> getNoticeList();
}
