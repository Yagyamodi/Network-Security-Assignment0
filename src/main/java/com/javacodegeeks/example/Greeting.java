package com.javacodegeeks.example;

public class Greeting {

    private String content;
    private String encryptedContent;
    private String contentReply;
    private String encryptContentReply;

    public String getEncryptedContent() {
        return encryptedContent;
    }

    public void setEncryptedContent(String encryptedContent) {
        this.encryptedContent = encryptedContent;
    }


    public String getContentReply() {
        return contentReply;
    }

    public void setContentReply(String contentReply) {
        this.contentReply = contentReply;
    }

    public String getEncryptContentReply() {
        return encryptContentReply;
    }

    public void setEncryptContentReply(String encryptContentReply) {
        this.encryptContentReply = encryptContentReply;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}