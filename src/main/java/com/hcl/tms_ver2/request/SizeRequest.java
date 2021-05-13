package com.hcl.tms_ver2.request;

import lombok.Data;


@Data
public class SizeRequest {
    private  int id;

    private String name;

    private String shortDesc;

    private String createdDate;
}
