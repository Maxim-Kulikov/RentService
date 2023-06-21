package com.example.rentservice.mapper.user;

import com.example.rentservice.dto.user.ExtraUserDataResp;
import com.example.rentservice.model.ExtraUserData;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ExtraUserDataMapper {
    ExtraUserDataResp toExtraUserDataResponse(ExtraUserData extraUserData);

    ExtraUserData toExtraUserData(ExtraUserDataResp extraUserDataResp);

    List<ExtraUserDataResp> toExtraUserDataResponseList(List<ExtraUserData> extraUserData);


}
