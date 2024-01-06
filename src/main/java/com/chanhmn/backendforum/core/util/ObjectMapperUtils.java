package com.chanhmn.backendforum.core.util;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ObjectMapperUtils {
    public static final ObjectMapper objectMapper = new ObjectMapper();

    private ObjectMapperUtils() {
    }

    public static <D, T> D stringToDTO(final String entity, Class<D> outClass) {
        try {
            return objectMapper.readValue(entity, outClass);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <D, T> D stringToTypeReference(final String entitys, TypeReference<D> typeReference) {
        try {
            return objectMapper.readValue(entitys, typeReference);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String dtoToString(final Object dto) {
        try {
            return objectMapper.writeValueAsString(dto);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
