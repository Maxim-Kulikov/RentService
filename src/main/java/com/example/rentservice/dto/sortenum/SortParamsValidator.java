package com.example.rentservice.dto.sortenum;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

public class SortParamsValidator {
    public static Data throwExceptionIfIncorrectInputOrElseGetData(String sortOrderStr, String sortFieldStr) {
        SortOrder sortOrder = null;
        SortField sortField = null;
        if (sortFieldStr != null && sortOrderStr != null && !sortFieldStr.isBlank() && !sortOrderStr.isBlank()) {
            try {
                sortOrder = SortOrder.valueOf(sortOrderStr);
                sortField = SortField.valueOf(sortFieldStr);
            } catch (IllegalArgumentException e) {
                throw new RuntimeException("Available sort orders: " + Arrays.toString(SortOrder.values())
                        + "\nAvailable sort fields: " + Arrays.toString(SortField.values()));
            }
        }
        return new Data(sortOrder, sortField);
    }

    @AllArgsConstructor
    @Getter
    public static class Data {
        SortOrder sortOrder;
        SortField sortField;
    }
}
