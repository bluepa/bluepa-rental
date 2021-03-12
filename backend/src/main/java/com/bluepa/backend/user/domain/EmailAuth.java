package com.bluepa.backend.user.domain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EmailAuth {

    private final String email;
    private final int code;
    private final boolean isChecked;
}
