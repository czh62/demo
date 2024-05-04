package com.example.demo.service;

import com.example.demo.domain.menu.Menu;
import com.example.demo.domain.response.Response;

import java.util.List;

public interface MenuService {
    Response<List<Menu>> getMenuList();
}
