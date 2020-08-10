# zulip-java-rest
A thin and easy to use Java library to access the [Zulip API](https://zulipchat.com/api/).
This library covers every API call of the Zulip REST API except for real-time events. It is aimed at being as simple as possible.
# How to use
## Setup and usage

### JAR
Simply build this project with `mvn package` and you can use the .jar in your classpath.

### Maven
Just add the following dependency to your pom.xml.

```xml
<dependency>
  <groupId>io.taliox</groupId>
  <artifactId>zulip-java-rest</artifactId>
  <version>1.0.0</version>
</dependency>
```
### Where do I get the API key for authentication?
You can either use a bot or a user account to communicate with the API. To find out the needed token or how to create a bot please see the official [Zulip documentation](https://zulipchat.com/api/api-keys).

### At first Create the ZulipRestExecutor to communicate with the Zulip API
The core of this library is the `ZulipRestExecutor` it is responsible for performing HTTP calls.

```java
ZulipRestExecutor executor  = new ZulipRestExecutor("user@zulip.com", "apikey","https://zulip.example.com/");
```

To change credentials after instantiating the ZulipRestExecutor it is recommended to create a new object for the moment.

### How to use the ZulipRestExecutor?
To perform an API call you should use the `executeCall(ZulipRestAPICall call)` method of the newly created object.
All API calls are packed inside the library as instantiatable objects which can be executed by the `ZulipRestExecutor`.
The naming convention of all call objects is like the following: `HTTP request method + object of action`.

So for instance if we want to send a message to someone on our Zulip server we need to create a `PostMessage` object to pass it into our executeCall method.

```java
PostMessage postMessage = new PostMessage("anotheruser@zulip.com", "hello world");
String response = executor.executeCall(postMessage)
```

executeCall always returns the answer from the Zulip server for instance whether the call was successful or not.
After receiving the answer you can process it. Successful GET calls are often JSON encoded.

All API calls can be performed after this principle.

## Some examples

### Get all users
```java
GetAllUsers getAllUser = new GetAllUsers();
String response = executor.executeCall(getAllUser);
```

### Get own profile
```java
GetProfile getProfile = new GetProfile();
String response = executor.executeCall(getProfile);
```

### Get all streams
```java
GetAllStreams getAllStreams = new GetAllStreams();
String response = executor.executeCall(getAllStreams);
```		

### Send a message to a single person
```java
PostMessage postMessage = new PostMessage("anotheruser@zulip.com", "hello world");
String response = executor.executeCall(postMessage);
```

### Send a message to a stream
```java
PostMessage postMessage = new PostMessage("streamname", "topicname", "hello world");
String response = executor.executeCall(postMessage);
```

### Create a new user (requieres admin)
```java
PostCreateUser createUser = new PostCreateUser("newuser@zulip.com", "password", "the_new_longname","the_new_shortname");
String response = executor.executeCall(createUser);
```

### Create a new stream
```java
PostCreateStream createStream = new PostCreateStream("[{\"description\":\"This is a new stream\",\"name\":\"A new Stream\"}]");	
createStream.setInvite_only(true);
createStream.setAnnounce(true);
```

After instantiating the object to be executed you always can set optional parameters.
In this case for example whether the newly created stream is supposed be invite only.
This works the same for all objects.

### Delete a message
```java
DeleteMessage deleteMessage = new DeleteMessage("54");
String response = executor.executeCall(deleteMessage);
```

### Patch a message
```java
PatchMessage patchMessage = new PatchMessage("13");
patchMessage.setContent("I edited this");
patchMessage.setType(UpdateMessageTypes.change_later);
String response = executor.executeCall(patchMessage);
```

Please always refer to the [official Zulip API documentation](https://zulipchat.com/api/) in case you are not sure what structure the parameters of an call object need to be.
A full list of API calls, return types and parameters to perform calls can be found over there.

## Contributing
Thanks for your interest! Do not hesitate to open an issue if you have a question, feedback or found something that is not working like it should.

Pull requests for improvements of the library or it's documentation are also highly appreciated.

## Licenses
This library and its content is released under the [MIT License](https://choosealicense.com/licenses/mit/).

## Disclaimer
The whole Zulip product and it's API can be found [here](https://github.com/zulip).
The documentation which was used here and is used inside of this project is heavily inspired by the official [Zulip site](https://zulipchat.com/api/) and the official [Zulip repositories](https://github.com/zulip).
