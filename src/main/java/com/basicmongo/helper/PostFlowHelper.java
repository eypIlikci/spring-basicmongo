package com.basicmongo.helper;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

@Component
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS,value = "session")
public class PostFlowHelper {
    private String authorId;
    private String publisherId;

    public String getAuthorId() {
        return authorId;
    }
    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }
    public String getPublisherId() {
        return publisherId;
    }
    public void setPublisherId(String publisherId) {
        this.publisherId = publisherId;
    }
}
