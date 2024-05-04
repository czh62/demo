package com.example.demo.domain.meta;

import com.example.demo.domain.enums.IconEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Meta {
    private IconEnum icon;
    private String title;
    private Boolean isFull;
    private Boolean isAffix;
    private Boolean isKeepAlive;
}
