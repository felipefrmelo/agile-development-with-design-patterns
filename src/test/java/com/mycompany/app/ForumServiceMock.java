package com.mycompany.app;

import java.util.ArrayList;
import java.util.List;

public class ForumServiceMock implements ForumService {

    private List<String> methodsCalled = new ArrayList<>();
    private boolean shouldThrowException;

    public List<String> getMethodsCalled() {
        return methodsCalled;
    }

    @Override
    public void addTopic(String user, String topic) {
        methodsCalled.add("addTopic");
        if (shouldThrowException) {
            throw new RuntimeException("Exception");
        }

    }

    @Override
    public void addComment(String user, String topic, String comment) {
        methodsCalled.add("addComment");

        if (shouldThrowException) {
            throw new RuntimeException("Exception");
        }
    }

    @Override
    public void likeTopic(String user, String topic, String topicUser) {
        methodsCalled.add("likeTopic");

        if (shouldThrowException) {
            throw new RuntimeException("Exception");
        }
    }

    @Override
    public void likeComment(String user, String topic, String comment, String commentUser) {
        methodsCalled.add("likeComment");

        if (shouldThrowException) {
            throw new RuntimeException("Exception");
        }
    }

    public void setShouldThrowException(boolean b) {
        shouldThrowException = b;
    }

}
