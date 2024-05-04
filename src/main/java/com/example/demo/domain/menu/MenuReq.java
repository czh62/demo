package com.example.demo.domain.menu;

import com.example.demo.domain.meta.Meta;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MenuReq {
    private String path;
    private String name;
    private String component;
    private Meta meta;
}
