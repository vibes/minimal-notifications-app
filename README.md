### Description
This is a minimal push Notifications App that allows for sending push notifications using Firebase.

It can be used for testing how Firebase handles Notifications on the client app

### Specific Requirements for building Locally
#### Local setup
The project is built with the following
- Java 11
- Android Studio Iguana | 2023.2.1 Patch 1
- Gradle 8.4

Running the app
1. Open and run the app through Android Studio
2. You will need the push token to be able to send notifications, in a separate, run `adb logcat | grep MainActivity`
3. Hit the `Log token` button on the screen to copy the token from terminal
4. In postman, make a request to `https://fcm.googleapis.com/v1/projects/fir-pushapp-963f6/messages:send`
5. You can use a payload similar to what's defined [here](https://firebase.google.com/docs/cloud-messaging/migrate-v1)
