package com.example.rentservice.service;

import com.example.rentservice.dto.user.ExtraUserDataResp;
import com.example.rentservice.dto.user.ExtraUserDataUpdateReq;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ExtraUserDataService {
    List<ExtraUserDataResp> getAll();

    ExtraUserDataResp update(ExtraUserDataUpdateReq dto, Long id);

    ExtraUserDataResp get(Long id);
}
