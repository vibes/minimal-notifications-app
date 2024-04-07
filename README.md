# Firebase Push Notifications App

This is a lightweight application designed to simplify the process of sending push notifications using Firebase services.

## Purpose

The main objective of this app is to streamline the testing of Firebase's notification handling mechanisms within client applications. It deliberately excludes the use of the Vibes Push SDK, allowing for a more focused examination of notification functionality directly from the client side.

This decision serves a dual purpose. Firstly, it provides developers with a clearer understanding of Firebase's native notification handling. Secondly, it offers a valuable resource for those seeking to explore notification functionalities without the added complexity of external SDKs.

## Specific Requirements for Building Locally

### Local Setup

To build this project locally, ensure you have the following prerequisites:

- Java 11
- Android Studio Iguana | 2023.2.1 Patch 1
- Gradle 8.4

### Running the App

Follow these steps to run the application locally:

1. Open the project in Android Studio and run it.
2. Retrieve the push token necessary for sending notifications by executing `adb logcat | grep MainActivity` in a separate terminal.
3. Copy the token from the terminal and use it in the payload to send to Firebase. More on this in the next step.
4. In Postman, make a POST request to `https://fcm.googleapis.com/v1/projects/fir-pushapp-29fc2/messages:send`.
5. Configure authorization in Postman. When adding the Firebase URL, Postman automatically detects the Firebase application and prompts you to authorize requests. Note that Vibes Email credentials are required to obtain the Auth token for this app.
6. Construct your payload according to the guidelines provided [here](https://firebase.google.com/docs/cloud-messaging/migrate-v1).

Example payload: 
```json
{
   "message":{
      "token":"tokenTJCzShi5HrrMUzZRvM:APA91bHSrqc5XjnleH6Ff1bB-BLXzLfyHkqoqBqpZK0HjFiiIDQ6I6dnWaZS92XvmbgZ0QD8PH6SJTdPXrg",
      "notification":{
         "body":"This is an FCM notification message!",
         "title":"FCM Message"
      },
      "data": {
         "story_id": "story_12345"
      }
   }
}
```
By adhering to these steps, you can seamlessly test and explore Firebase push notifications within your application environment.
