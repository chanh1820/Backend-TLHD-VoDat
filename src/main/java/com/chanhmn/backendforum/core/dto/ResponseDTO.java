package com.chanhmn.backendforum.core.dto;

import com.chanhmn.backendforum.core.constant.DBConstant;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class ResponseDTO <Data> implements Serializable {

    private Integer statusCode = DBConstant.STATUS_CODE_SUCCESS;

    private String message = "Success";

    private Data data;

}
