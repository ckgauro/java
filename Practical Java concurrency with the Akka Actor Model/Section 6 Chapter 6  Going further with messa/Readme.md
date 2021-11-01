20. Creating a custom message type
 
```java
import akka.actor.typed.ActorRef;
import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.AbstractBehavior;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.Behaviors;
import akka.actor.typed.javadsl.Receive;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Random;

public class WorkerBehavior extends AbstractBehavior<WorkerBehavior.Command> {
    private BigInteger prime;

    public static class Command implements Serializable {
        private static final long serialVersionId = 1L;
        private String message;
        private ActorRef<String> sender;

        public Command(String message, ActorRef<String> sender) {
            this.message = message;
            this.sender = sender;
        }

        public String getMessage() {
            return message;
        }

        public ActorRef<String> getSender() {
            return sender;
        }


    }

    public WorkerBehavior(ActorContext<Command> context) {
        super(context);
    }

    public static Behavior<Command> create() {
        return Behaviors.setup(WorkerBehavior::new);
    }

    @Override
    public Receive<Command> createReceive() {
        return newReceiveBuilder()
                .onAnyMessage(command -> {
                    if (command.getMessage().equals("start")) {
                        BigInteger bigInteger = new BigInteger(2000, new Random());
                        System.out.println(bigInteger.nextProbablePrime());
                    }
                    return this;
                })

                .build();
    }


}


 ```
 our child actors are printing out the prime number that they have calculated to the console, but we'd really like them to send this number back to the parent manager actor so that the manager can store it in the sorted set. So how do we get the worker to send the result back to the parent? Well there are a couple of issues here that we need to overcome. Right now, the parent, the manager, can only receive messages of type string, but really we want to send the manager a big integer. So we'll need to allow the parent, the manager, to be able to accept different data types in the messages, both strings and big integers. 
  
 The second issue is that the child, the worker, needs to know where to send the message to. It needs some way to reference the parent manager actor. The solution to both of these issues is actually to go a bit further with the message data types. So let's start with the worker. Right now, the worker can only accept a string, which is the word start. But the worker also needs to know which actor to send the results its going to calculate back to. So rather than sending a simple string to the actor, it will be good if we could send both the string and a reference to the sending actor. We can do this if we have a custom data type for our worker's messages. Now messages that actors can send and receive can be any Java class that is serializable. So we can create a custom message type simply by creating a serializable class. So the idea is that our manager actor is not going to send a string to the worker, but it's going to create a custom class which will contain two fields. The string and a reference to itself to the manager class. When the worker actor receives this message, it can do the work and then it can use that reference to send the result back to the person who sent it the instruction. Now the class that we're going to create to define this message type could be created anywhere in our project, but general good practise with Akka is to make this a subclass of the  behavior type that we are working with and to call this the command. So the recipient of these messages is going to be the worker. This will therefore be known as the worker command class. It might seem a bit strange at first because it will be the manager that's going to create these messages, but we define them within the class of the recipient of those messages. So we're going to create the worker's command class. So let's go back into our IDE and we'll have a go at doing this. So in our worker class, and I'm going to put this in right at the top before the constructor, we're going to create a new class here which will be a public class, which we're going to call command. Now we said that all the messages have to be serializable. Actually, if you're working on a single machine, you don't need to implement the serializable interface, but it's good practise to do so and if we ever move this to work on a cluster, which is something we will be talking about in a later course, then it absolutely must be serializable. So I think the first thing we should do is implement serializable, the interface. Okay, now this class then, we said, is going to contain two fields, let's make those private class level fields. So there's going to be a string which we'll call message, and there's going to be a reference to the class that is sending this message, so that's going to be an object of type actor ref, that's the reference to an actor. Now we know that actor ref is a generic type, and it's the manager that's going to be sending these messages, and right now a manager is expecting messages back of type string. So the manager is going to be an actor ref of type string, and we could call this something like manager actor I suppose, I think I'm going to call it sender. So we've got two private class level variables. Now one of the other things we've also said is that messages should be immutable. So what I think we'll do is create a constructor that allows us to set these two values, and we'll create getter methods, but we won't create setters. And then that way, that will make these hopefully immutable. So let's create the constructor, I think I'm going to get the IDE to do that for me, so I'm going to click on generate and constructor. And I want both of the two parameters, both the message and the sender to be set within the constructor. And we'll also create some get methods as well, again, I'm going to get the IDE to do this for me. So we'll just create getters for both of these, I'm not creating setters. So that's a very standard Java class, nothing very exciting, the only thing I guess to point out then is that it's a subclass of worker  behavior and it implements the serializable interface. There is one more thing we need to do though, which is that because we're going to be creating instances of this class from outside of worker  behavior, it's actually the manager that's going to be creating these messages to send it to the worker  behavior. We must make this a static class. If we don't do that, we won't be able to instantiate commands, just because it's a subclass of another class type. And just to complete this class, if I was using the Eclipse IDE, I know I'd get a warning at this point to tell me that we're implementing the serializable interface but we haven't provided any value for SerialVersionUID. I'm going to do that just to make sure that this is complete and works correctly, I don't like to leave warnings even though I don't see those in IntelliJ. So I'm just going to create a final private static final long, and then it's a paramter called SerialVersionUID, and I'll set that equal to one. And because it's a long, I'll put the letter L in at the end there. Okay, so I think that completes the message type that our manager can use to send messages to the worker. And now we'll be telling the worker not just to start but also where to send the results back to when it's calculated them.
 -----------------
 21. Applying the custom message type to a behavior

 ```java
 import akka.actor.typed.ActorRef;
import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.AbstractBehavior;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.Behaviors;
import akka.actor.typed.javadsl.Receive;

import java.io.Serializable;
import java.util.stream.IntStream;

public class ManagerBehavior extends AbstractBehavior<String> {
  // public interface Command extends Serializable { }

  public ManagerBehavior(ActorContext<String> context) {
    super(context);
  }

  public static Behavior<String> create() {
    return Behaviors.setup(ManagerBehavior::new);
  }

  @Override
  public Receive<String> createReceive() {
    return newReceiveBuilder()
        .onMessageEquals("start", () -> {
          IntStream.rangeClosed(0, 19).forEach(i -> {
            ActorRef<WorkerBehavior.Command> worker = getContext().spawn(WorkerBehavior.create(), "worker" + i);
            worker.tell(new WorkerBehavior.Command("start", getContext().getSelf()));
          });
          return this;
        })
        .build();
  }


}

```

Main
```java
import akka.actor.typed.ActorSystem;

public class Main {
  //  public static void main(String[] args) {
//    ActorSystem<String> actorSystem = ActorSystem.create(FirstSimpleBehavior.create(),"FirstActorSystem");
//    actorSystem.tell("say hello");
//    actorSystem.tell("who are you");
//    actorSystem.tell("create a child");
//    actorSystem.tell("This is the second message.");
//  }

  public static void main(String[] args) {

    ActorSystem<String> bigPrimes=ActorSystem.create(ManagerBehavior.create(),"BigPrimes");
    bigPrimes.tell("start");
  }
}
```

 
 So having created this message type then, the next step is going to be to adjust our worker to accept messages of this type. Right now our worker expects to receive strings, so we'll make some changes here to say the worker is, instead of strings, now going to be receiving these commands. So at the class definition here we're saying our worker  behavior is extending the AbstractBehavior but the message type is this command object, which we need to specify as being WorkerBehavior.Command Okay now having done that, we'll find that this code won't compile so we'll go and fix those compilation errors. The first of these is the constructor. So we've got the constructor here, and we expect to receive an ActorContext of type String. Well that's now going to be an ActorContext of type Command and when we call our create method, we're no longer going to be returning an object that implements Behaviour String, it's now Behaviour Command and now those two are compiling so that's great. Our message handler is no longer returning a Receive of String, it's a Receive of Command. And the final thing then is this onMessageEquals part. Well we could use onMessageEquals when we were dealing with a simple object type like a String. But now we've got a more complex object and we need to inspect one of the properties. We need to look at the message within our command to find out if that message is the word "start". So we can no longer do onMessageEquals, I think what we should do is switch this instead to use onAnyMessage. Let's create that as a new entry first and then we'll remove this one once we've created the replacement. So we're going to call onAnyMessage and the syntax for this is that we take a parameter to specify the message and then we implement some kind of lander, and of course in the lander we need to return this. Okay, that's compiling. Now because I have called one of the properties of my message "message", I'm actually going to change the parameter name here to command. So the idea is we're receiving a command, one of the object types we specified at the top, and then we can inspect that to see what to do. Well what we want to do then here is find out what the value of the message string is within our command object. So it's something like if command.getMessage is equal to the word "start", so we'll do a .equals start then we want to run some code, and the code we want to run for now is this code here. So let's copy and paste this up into our new section up here and then we can remove the previous onMessageEquals. So I hope that makes sense. Our new message handler is receiving our more complex message type, it's looking at the property of the message string, and if that equals "start", then it's calculating the big integer number. And right now, it's just printing that out to the console. We'll see how to return that number to the manager in the next video, but before I get to that point, I want to be able to run this code just to make sure we're leaving it in a sensible place on this video. So we'll go to the manager, where we're currently sending the worker a string, and instead what we'll do is choose this to use that new worker  behavior command. So our worker is no longer going to be an ActorRef of type String, it's now an ActorRef of type WorkerBehavior.Command and then to tell that worker a new command, we need to actually instantiate one of these command objects. So the message is going to be, I'll just take out the word "start" here, it's going to be a new WorkerBehavior.Command and of course the constructor takes the two values as the parameters. So the first is the string message, that's the word "start". And the second needs to be an ActorRef, a pointer to the manager. Well, we can get that from that context object, I think we saw that a few moments ago in one of the earlier videos. We'll call getContext and then there's a method in here called getSelf which gets an ActorRef a reference to the current actor. So what we should've now implemented is the worker can accept messages that look like this that contain two different parameters. The manager can create this message containing these two different parameters, but right now all the worker is doing is printing out to the console still, their results. But what we've done should be runnable so let's run it and check that it is still working. So we'll go to the main method, I've not got it running from before of course, don't forget to stop the application after each run. And we'll run this now. And great, that is still working, so that's a good place to leave this video. In the next one we'll see how to now send the message back from the worker to the manager.
 
-----------------
 22. Using interfaces to support multiple message types
 

-----------------
 23. Understanding message delivery guarantees
