# zulip-java-rest
A thin and easy to use Java library to access the [Zulip API](https://zulipchat.com/api/).
This library covers every API call of the Zulip API except for real-time events but is in it's core really simple.
# How to use
## Setup and usage
### Maven
Just add the following dependency to your pom.xml or the JAR of this repository to your projects build path.

```maven
<dependency>
	<groupId>io.taliox</groupId>
	<artifactId>zulip-java-rest</artifactId>
	<version>1.0</version>
</dependency>
```
### Where do I get the API key for authentication?
You can either use a bot or a user account to communicate with the API. To find out the needed token please see the official [Zulip documentation](https://zulipchat.com/api/api-keys).

### At first Create the ZulipRestExecutor to communicate with the Zulip API
The core of this library is the `ZulipRestExecutor` it is responsible for performing HTTP calls.

```java
ZulipRestExecutor  = new ZulipRestExecutor("user@zulip.com", "apikey","https://zulip.example.com/");
```

To change credentials after instantiating the ZulipRestExecutor it is recommended to create a new object for the moment.

### How to use the ZulipRestExecutor?
To perform an API call you should use the `executeCall(ZulipRestAPICall call)` method of the newly created object.
All API calls are packed inside the library as instantiatable objects which be executed by the `ZulipRestExecutor`.
The naming convention of all call objects is like the following: `HTTP request mehtod + object of action`.

So for instance if we want to send a message to someone on our Zulip server we need to create a `PostMessage` object to pass it into our executeCall method.

```java
PostMessage postMessage = new PostMessage("anotheruser@zulip.com", "Hello world");
String response = executor.executeCall(ZulipRestAPICall call)
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
PostMessage postMessage = new PostMessage("anotheruser@zulip.com", "Hello world");
String response = executor.executeCall(postMessage);
```

### Send a message to a stream
```java
PostMessage postMessage = new PostMessage("Streamname", "topicname", "Hello world");
String response = executor.executeCall(postMessage);
```

### Create a new user (requieres admin)
```java
PostCreateUser createUser = new PostCreateUser("newuser@zulip.com", "password", "the_new_longname","the_new_shortname");
String response = executor.executeCall(createUser);
```

### Create a new stream
```java
PostCreateStream createStream = new PostCreateStream("[{\"description\":\"This is new\",\"name\":\"A new Stream\"}]");	
createStream.setInvite_only(true);
createStream.setAnnounce(true);
```
After instantiating the object to be executed you always can set optional parameters.
In this case for example whether the newly created stream is supposed be invite only.
This works the same for all objects.

### Delete a message
```
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

Please always refer to [official Zulip API documentation](https://zulipchat.com/api/) in case you are not sure what structure the parameters of an call object need to be.
A full list of API calls, return types and parameters to perform calls can be found there.

We are working on more examples and tests within the library so you can try it out right of the box.

## Contributing
Thanks for your interest! Do not hesitate to open an issue if you have a question, feedback or found something that`s not supposed to be working like it should.
Pull requests for improvements of the library are also highly appriciated.

## Licenses
This library and its content is released under the [MIT License](https://choosealicense.com/licenses/mit/).

## Disclaimer
The whole Zulip product and it's API can be found [here](https://github.com/zulip).
The documentation which was used here and is used inside of this project is heavily inspired by the official [Zulip site](https://zulipchat.com/api/) and the official [Zulip repositories](https://github.com/zulip).