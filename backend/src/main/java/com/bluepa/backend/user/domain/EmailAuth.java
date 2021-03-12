package com.bluepa.backend.user.domain;

import lombok.Getter;

@Getter
public class EmailAuth {

    private final String email;
    private final int code;
    private boolean isChecked;
    private final String delimiter = ",";

    public EmailAuth(String email, int code) {
        this.email = email;
        this.code = code;
        this.isChecked = false;
    }

    public EmailAuth(String serialized) {
        String[] strings = serialized.split(delimiter);
        this.email = strings[0];
        this.code = Integer.parseInt(strings[1]);
        this.isChecked = Boolean.parseBoolean(strings[2]);
    }

    public boolean isDifferentCode(int code) {
        return this.code != code;
    }

    public void check() {
        this.isChecked = true;
    }

    @Override
    public String toString() {
        return email + delimiter + code + delimiter + isChecked;
    }
}
