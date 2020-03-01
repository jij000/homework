package com.miu.greetingservice.domian;

import lombok.Getter;

@Getter
public class Greeting {
    private String content;

    public Greeting(String content) {
        this.content = content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}