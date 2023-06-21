package com.example.rentservice.service.impl;

import com.example.rentservice.dto.user.ExtraUserDataResp;
import com.example.rentservice.dto.user.ExtraUserDataUpdateReq;
import com.example.rentservice.mapper.user.ExtraUserDataMapper;
import com.example.rentservice.model.ExtraUserData;
import com.example.rentservice.repository.user.ExtraUserDao;
import com.example.rentservice.service.ExtraUserDataService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class ExtraUserDataServiceImpl implements ExtraUserDataService {
    @Autowired
    private final ExtraUserDao extraUserDao;
    @Autowired
    private final ExtraUserDataMapper extraUserDataMapper;

    @Override
    @Transactional
    public List<ExtraUserDataResp> getAll() {
        return extraUserDataMapper.toExtraUserDataResponseList((List<ExtraUserData>) extraUserDao.findAll());
    }

    @Override
    @Transactional
    public ExtraUserDataResp update(ExtraUserDataUpdateReq dto, Long id) {
        ExtraUserData extraUserData = extraUserDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Could not find extra user data by this id!"));
        extraUserData = update(extraUserData, dto);
        return extraUserDataMapper.toExtraUserDataResponse(extraUserData);
    }

    @Override
    @Transactional
    public ExtraUserDataResp get(Long id) {
        return extraUserDataMapper.toExtraUserDataResponse(
                extraUserDao.findById(id)
                        .orElseThrow(() -> new RuntimeException("Could not find extra user data by this id!"))
        );
    }

    private ExtraUserData update(ExtraUserData model, ExtraUserDataUpdateReq dto) {
        return model.changer()
                .phone(dto.getPhone())
                .name(dto.getName())
                .lastname(dto.getLastname())
                .birthdate(dto.getBirthdate())
                .passportNumber(dto.getPassportNumber())
                .drivingLicense(dto.getDrivingLicense())
                .registerDate(dto.getRegisterDate())
                .change();
    }
}
