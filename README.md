
# Forum Gamification Project
This is a simple forum application with gamification features. The application allows users to add topics and comments to the forum, like topics and comments, and earn achievements based on their activities. The achievements are tracked and stored using an AchievementStorage object.

## Requirements
- Java 8 or higher
-  Maven

## Installation

1. Clone this repository to your local machine
2. Open a terminal or command prompt and navigate to the project directory
3. Run the command **`mvn clean package`** to build the project and create a JAR file
4. Run the command **`java -cp target/gamification-1.0-SNAPSHOT.jar com.mycompany.app.App`** to start the application

## Usage
Upon starting the application, a command-line interface (CLI) will be displayed with the following menu:

```shell-session
1. Add topic
2. Add comment
3. Like topic
4. Like comment
0. Exit
```

To perform an action, enter the corresponding number and follow the prompts. For example, to add a topic, enter "1" and then enter the user's name and the topic text when prompted.

As users perform actions such as adding topics and comments and liking them, they will earn achievements based on their activities. The achievements earned will be displayed in the CLI.

## Architecture
The application is designed using the Observer and Proxy design patterns.

The Observer pattern is used to track and store achievements earned by users. The AchievementStorage object acts as the subject and the AchievementObserver objects act as the observers.

The Proxy pattern is used to add gamification features to the ForumService object. The ForumServiceGamificationProxy object acts as a decorator for the ForumServiceCLI object and provides additional functionality related to gamification, such as tracking achievements.

