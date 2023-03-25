package com.mycompany.app;


public class ForumServiceCLI implements ForumService {

    @Override
    public void addTopic(String user, String topic) {
        System.out.println(String.format("User %s added topic: %s", user, topic));
    }

    @Override
    public void addComment(String user, String topic, String comment) {
        System.out.println(String.format("User %s added comment '%s' to topic '%s'", user, comment, topic));
    }

    @Override
    public void likeTopic(String user, String topic, String topicUser) {
        System.out.println(String.format("User %s liked topic '%s' by user %s", user, topic, topicUser));
    }

    @Override
    public void likeComment(String user, String topic, String comment, String commentUser) {
        System.out.println(String.format("User %s liked comment '%s' by user %s on topic '%s'", user, comment, commentUser, topic));
    }

}
