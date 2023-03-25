package com.mycompany.app;

import java.util.Scanner;

public class Forum {
    private Scanner scanner;
    private ForumService forumService;

    public Forum(ForumService forumService) {
        scanner = new Scanner(System.in);
        this.forumService = forumService;

    }

    public void runCLI() {
        boolean running = true;

        while (running) {
            System.out.println("1. Add topic");
            System.out.println("2. Add comment");
            System.out.println("3. Like topic");
            System.out.println("4. Like comment");
            System.out.println("0. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("User: ");
                    String user1 = scanner.next();
                    System.out.print("Topic: ");
                    String topic1 = scanner.next();
                    this.forumService.addTopic(user1, topic1);
                    break;

                case 2:
                    System.out.print("User: ");
                    String user2 = scanner.next();
                    System.out.print("Topic: ");
                    String topic2 = scanner.next();
                    System.out.print("Comment: ");
                    String comment2 = scanner.next();
                    this.forumService.addComment(user2, topic2, comment2);
                    break;

                case 3:
                    System.out.print("User: ");
                    String user3 = scanner.next();
                    System.out.print("Topic: ");
                    String topic3 = scanner.next();
                    System.out.print("Topic User: ");
                    String topicUser3 = scanner.next();
                    this.forumService.likeTopic(user3, topic3, topicUser3);
                    break;

                case 4:
                    System.out.print("User: ");
                    String user4 = scanner.next();
                    System.out.print("Topic: ");
                    String topic4 = scanner.next();
                    System.out.print("Comment: ");
                    String comment4 = scanner.next();
                    System.out.print("Comment User: ");
                    String commentUser4 = scanner.next();
                    this.forumService.likeComment(user4, topic4, comment4, commentUser4);
                    break;

                case 0:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
