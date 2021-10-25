14. Expanding the receiveBuilder
chapter 5

FirstSimpleBehavior 
```java
 public Receive<String> createReceive() {
        return newReceiveBuilder()
                .onMessageEquals("say hello" , () -> {
                    System.out.println("Hello");
                    return this;
                })
                .onMessageEquals("who are you" , () -> {
                    System.out.println("My path is " + getContext().getSelf().path());
                    return this;
                })              
                .onAnyMessage(message -> {
                    System.out.println("I received the message : " + message);
                    return this;
                })

                .build();
    }
```    

```java
import akka.actor.typed.ActorSystem;

public class Main {
    public static void main(String[] args) {
       ActorSystem<String> actorSystem = ActorSystem.create(FirstSimpleBehavior.create(),"FirstActorSystem");
       actorSystem.tell("say hello");
       actorSystem.tell("who are you");
       actorSystem.tell("create a child");
       actorSystem.tell("This is the second message.");
    }

}

```
Hello again, in the last chapter

we created our first actor,

and we sent that actor a message.

The actor did something with that message.

It printed it out to the console.

Now, if we want to implement the big primes example

in Aker, we're going to need more than one actor.

And we'll want the actors to be able to do some real work

to calculate the big prime numbers.

Creating a new actor from an existing actor

is quite easy to do, but there are a couple of small things

we will need to know about before we can start coding

that up, and the first of these is

to learn a bit more about this new receive builder function

that we used in our behaviour class.

In this function, so far we've used

the on any message method to match any kind of message.

It actually didn't matter what the string was

we sent to this actor even on a null string

it meant that this print line code would have run.

If I put a dot in here after our new receive builder

we'll see that there are some alternatives that we can use.

The most general is the on message method.

This let's us define a specific class type

to match against and we will come to that version,

we'll look at that a little later on.

For now, we're going to be interested

in the other option, which is onMessageEquals.

Because we're working on a set of behaviours

that responds to string messages

it makes sense to say if the string

is the phrase create a child, for example,

then we want to run one piece of code.

But if it's print to the console we do something else.

So we can use the on message equals method

to create a chain of instructions

and Aker will execute the first matching entry in this chain

So if, for example, we do something

like onMessageEquals and in quotes "create a child."

(typing)

and then there'll be some kind of lambda to go in here.

I'm just going to put in an empty lambda for the moment,

just to signify that we need to put something in here.

Well, if we sent a message that says,

"create a child," then this lambda would get executed.

Any other kind of message would mean

that this lambda gets executed

because Aker will match against

the first of these methods that matches

that is able to process the message.

If we put these the other way around,

If we said onAnyMessage, and then onMessageEquals

well, this second version would never get to run

because onAnyMessage will always match any kind of message.

But we can create these chains

so we could say if the message is "create a child" do this

if the message is, say, "print your name"

(typing)

we'll do something else and then,

maybe, have this catch all at the bottom

to say we'll do that with any other kind of message.

So let's see this working.

I think we'll start with a message that says "say hello."

(typing)

And if the actor receives a message like this

what we'll want to do is print out to the console.

So let's put in here something like

a system out print line "hello," something nice and simple.

And we always have to return something from our lambdas

and, for now, we're always just going to return this.

Again, I mentioned this before

but we will look at this return type a little later on.

So every time this actor receives a message

if the message is the string "say hello"

we're going to print out the word hello to the console.

We could also do something like,

"who are you" as the message,

(typing)

and actually let's use this as an opportunity

to find out the path of the actor.

So, in here, what we'll do is a system out print line

and the way that we find out the path

is I'm not going to explain this construct,

we'll just use it for the moment, so follow along with me.

We'll put in a system out print line

of "My path is" and then we're gonna add on the end of here.

We start by calling a method called getContext

and then a method on that called getSelf,

and then a method on that called path.

Again, I will explain that a little later on.

We just want to see what the path is of the actor

so we can understand roughly what that's going to look like.

Again, we'll need to return something

so we'll return this from that lambda

and then, we'll have that catch all message at the end

that says I received the message and prints it out.

So let's try and test this so we can see

these different messages being matched and working

So, in our main method, we'll start

by sending the message that says "say hello"

(typing)

Then we'll send in another message

that says who are you, and we need to make sure

we get the case of this right because,

obviously, we're matching strings here

so string equals is going to be used

two strings will only be equal, if the cases are the same

so get that exactly right as well

And then, we'll leave in "This is the second message."

I know it's the third message now,

but that should make the third of those matchers be executed

the third lambda in the chain.


------------------
15. Creating child actors

<img ChildActors>

```java
 public Receive<String> createReceive() {
        return newReceiveBuilder()
                .onMessageEquals("say hello" , () -> {
                    System.out.println("Hello");
                    return this;
                })
                .onMessageEquals("who are you" , () -> {
                    System.out.println("My path is " + getContext().getSelf().path());
                    return this;
                })
                .onMessageEquals("create a child", ()-> {
                    ActorRef<String> secondActor = getContext().spawn(FirstSimpleBehavior.create(), "secondActor");
                    secondActor.tell("who are you");
                    return this;
                })
                .onAnyMessage(message -> {
                    System.out.println("I received the message : " + message);
                    return this;
                })

                .build();
    }
```    

```java
public class Main {
    public static void main(String[] args) {
       ActorSystem<String> actorSystem = ActorSystem.create(FirstSimpleBehavior.create(),"FirstActorSystem");
       actorSystem.tell("say hello");
       actorSystem.tell("who are you");
       actorSystem.tell("create a child");
       actorSystem.tell("This is the second message.");
    }

   
}
```

So we're ready now to create a child actor.

The idea is that we're going to tell

the first actor that we create,

which is actually going to become

the manager in our example.

If you remember in the Big Primes example,

the manager's going to have a number of employees,

and the employees are going to be calculating

the Big Primes.

So we're going to tell the manager a message.

Let's create this now actually.

Let's do an actorsystem.tell, and for now

we'll make the message the string, create a child.

Meaning I want you to go and create another actor,

a child actor.

And then in the manager, when we can match

on that particular message, so let's put in

our message equals, and the string, create a child,

well what we're going to do is execute some kind

of lambda, and in the lambda, we'll want to actually

create a new actor.

Now for now, because we've only defined

one behaviour class, which is this first simple behaviour,

what we'll do is we'll create a new actor

that has this first simple behaviour.

So we'll end up with two actors in our system

that have the same behaviour.

Don't worry if that sounds a bit confusing.

In a few minutes we'll switch this all to increment

the Big Primes example and will then make sense,

I promise, but for now I just want to see

how we go and create an actor from another actor.

Now we saw that to create the very first actor,

we needed to use the actorSystem.create,

this static helper method.

Well once an actor exists, if you'll recall,

to instantiate the actor, we needed to pass into

it's constructor, an instance of this object

which is an actor context.

The actor context object has a method on it,

which allows us to create another actor.

It's called the spawn method, and we get access

to this actor context, by calling a method

on our abstract class, called get context.

Actually we've called that already here.

We'll come back and look at the other things

we can do with get context quite soon,

but the idea then that in this lambda,

when we want to create a new actor, we can call

get context, and that has a method called spawn,

and spawn allows us to create a new actor.

The spawn method actually takes the same parameters,

as the actorSystem.create method.

There are two parameters, the first is an instance

of the behaviour and the second is a name.

So the instance of the behaviour is going to be a new

first simple behaviour.

Well we're going to create that by calling

the create method, the static method that we set up before,

so that's going to be FirstSimpleBehavior.create,

and then we need to give it a name.

I think we'll call this one second actor.

Now when we used actorSystem.create, what got returned

was an instance of actor system.

This time, what will get returned is an instance

of an object of type actor ref.

So it's going to be a actor ref, and it's a generic type,

the type is string.

Let's give it a name, second actor.

And we'll just import actor ref, so when this line compiles,

make sure you pick the one from akka actor type,

not just akka actor.

And I'm just going to return this, at this point,

so that our code is compiling.

But let's just say a couple of things

about what we have done here.

We started with our first actor,

which we called actor system.

That has a name, a path, a message queue,

and we created by generating an instance

of our behaviour class.

Our first actor is actually creating a child actor,

by calling the spawn method.

So the child actor, which we in this instance,

called second actor, also has a name, a path,

a message queue, and a behaviour.

Now what's important to understand at this point,

is that these two actors are completely separate.

They will have their own state.

In order to generate the second actor, we needed to create

a new instance of our behaviour object,

so although they share the same behaviour,

meaning they're generated from the same underlying

behaviour class, the instance of the behaviour class,

that each of these actors have, will be different

so in the state stored in this class, won't be seen

by this actor, and that's what makes this system

completely threat safe.

Although these actors share the same behaviour,

they'll do the same sorts of things if they receive

a message, any internal state of the actor,

will be unique to that actor.

So we've generated this second actor,

and this is the first time we've seen actor ref object type.

Well this is just simply a reference to an actor

and actually actor ref is the main object type

we work with when we are dealing with actors.

Actor ref is actually an interface.

If you recall, when we created the first actor,

and object of type actor system, I said this was

a special type of actor.

It actually implements the actor ref interface,

and it's this interface that gives us the tell method.

Actor system has everything in actor ref,

and a few more things that allows us to control akka

which we'll see a bit later on.

But we can think of actor system as just being

an instance of an actor ref and so is our second actor.

So both of these have the tell method.

I can check that, I can do here, SecondActor.tell,

and we can indeed pass that second actor a message.

So in fact let's do that.

Let's send a message to the second actor

that says "Who are you?".

So before we run this, let's go and check

what we think should happen.

In the main method, we're going to say to our first actor,

say hello, and that's going to print out the word hello

to the console.

We're going to say who are you, and that's going to

print out the actor's path.

Then we're going to say create a child,

and what should happen is that a new actor

is going to be generated, and our first actor

is going to send our second actor a message

that says who are you, and the second actor

should print out it's path to the console,

and then finally we'll get that this is the second message

that should be dealt with by that first actor again.

Let's run this and see that that is indeed what happens.

I haven't actually stopped my application running

from the last time, so I'll do that first,

and then we will run it again.

Great, so we can see hello, the path of the first actor,

the path of the second actor, and then this,

I received the message, this is the second message.

In the next video, we'll talk about what these paths

really mean.


------------------

16. Actor paths


So having created two actors,

we can see we have two different paths.

These paths are really URLs.

The first part akka:// is the data type, or the

URL type, that akka is going to use.

We next have first actor system, this is actually the name

that we gave to the entry point actor, or the first actor

in our system.

And in fact every the actor sits under first actor system,

or what ever name we provide here.

By default the very first actor that we create,

has a name of user.

So this first actor, the one we called actor system,

really is the user actor, that's its name, within the

path of akka://FirstActorSystem.

This is normally referred to as the user guardian.

And so every actor system will always start

with the user guardian.

That's a path of akka://TheSystemName/User.

Any actors created by the user guardian,

will have a path that starts with the current actor,

that's that user guardian actor, then a forward slash,

and then the child actors name.

So the structure of our actor paths, or actor URLs,

is a hierarchy, allowing us to navigate to the

actor, via it's parents.

If you recall we mentioned earlier in the course,

that the path is a bit like the equivalent of finding

the employee in the company.

In a real life scenario we might know that James,

sits at the third desk in row two,

and that's how we would locate him.

Well in our scenario we would locate the actor James,

by saying he's an actor that's

been created by the manager, or the user guardian.

So we expect the path to James to be akka://

what ever our system name is called,

forward slash user, forward slash James.

And if James had another actor that he had created,

maybe an actor called Sally,

that would be forward slash James,

forward slash Sally, and so on.

Now actually doing this, finding an actor

from it's path, turns out to be

quite a complex operation,

it's beyond the scope of this course,

and it's something we rarely need to do.

We don't normally need to find actors from their paths,

but understanding actor paths is useful

for understanding the way that actors

exists hierarchically, in actor.

And there's something else that I can

now talk about which makes sense because we know

about actor paths.

And that is whenever we create an actor,

and that included naming our actor system

actually, we have to give actors names that

will be valid within a URL that

looks something like this.

So actor names can't contain spaces for example,

in fact they have to be made up of, upper and

lower case letters, numbers, dashes, or underscores,

those are the only characters you can use in an actor name.

------------------


17. Starting the big prime example


```java
public class WorkerBehavior extends AbstractBehavior<String> {

    private WorkerBehavior(ActorContext<String> context) {
        super(context);
    }

    public static Behavior<String> create() {
        return Behaviors.setup(WorkerBehavior::new);
    }

    @Override
    public Receive<String> createReceive() {
        return newReceiveBuilder()
                .onMessageEquals("start" , () -> {
                    BigInteger bigInteger = new BigInteger(2000, new Random());
                    System.out.println(bigInteger.nextProbablePrime());
                    return this;
                })
                .build();
    }
}

```



Okay, well I think we know enough now

to start building the big primes example.

I'm going to use this project to do that,

I want to leave this code in

in case you want to refer to it

in the closing workspace for this chapter,

so what I think I'm going to do is comment out

this existing main method and we'll create a brand new one,

and then we'll ignore the FirstSimpleBehavior

and we'll start creating our special behaviours

for our primes application.

So before we start writing the code,

let's remind ourselves

what we're going to try and create here.

We're going to have the manager of our project,

or the user guardian, the entry-point into our system,

and that's going to contain the list

of big primes once they are generated.

The manager is going to create a number of child actors,

I think we're going to call these workers,

and each worker will receive a message that says,

please give me a big prime number,

and it will send back to a manager,

the message containing the big prime number.

So let's start having a go at trying to implement this,

and I think we'll start

by looking at the behaviour for the worker actor.

So we'll create a new class first of all,

which we'll call WorkerBehavior.

Now behaviour classes always extend AbstractBehavior.

AbstractBehavior is a generic class type,

and we need to say what is the message type

that a worker is going to receive.

The workers are going to receive a message that says,

please give me a prime number.

Well, this might as well be a string,

we could make it something else, we might do that later on,

but for now we'll say workers

expect to receive a String message.

Okay, so to make this class compile,

there are two things we'll need to do,

we need to provide the constructor

and we need to override the message handler,

so let's get the ID to create these for us.

So we'll do the message handler first of all,

that's the method called createRecieve,

and we'll do the constructor.

Now as this the second time we're doing this again,

I'll go through it quite slowly,

we'll start with the constructor, what we need to do

is make that private, and we instead

create a public static method

that's going to generate an instance

of this WorkerBehavior for us,

so that's going to be a public static method,

the return type is an instance of Behaviour

and it's a generic type, the generic type is String.

So the idea here is although we've called our object

WorkerBehavior, what we're really returning

is something that is a behaviour of a string

we've rermplemented by extending

the abstract behaviour class.

So we'll import Behaviour, make sure we get the one

from akka.actor.typed,

and then we'll call this method create,

it doesn't take any parameters, but in here,

we're going to instantiate WorkerBehavior

with that static helper method.

That was Behaviors.setup,

and then all we need to put in here

is a call to the constructor

in the format of the class name WorkerBehavior::new.

We'll put a semicolon at the end there,

and we'll just import Behaviours,

make sure you pick the one from javadsl,

and that is our constructor dealt with.

So now for the receive builder,

so I always start by doing return a newReceiveBuilder,

that's the name of the message that we are calling

that comes from abstract class that we're extending,

we're always going to want to call build at the end of that,

and then we can put our different message handlers

in the middle here.

Now, we're going to be sending a message to the worker

that says, please create a prime number for me.

That message could be any string we like,

I think we'll keep things simple

and let's just expect to receive a string

with the word start.

So I think we can do here onMessageEquals, the word start,

then we're going to do some processing,

so here is where the lambda is going to go.

So at the end of the lambda,

we're always going to return this,

which means that this code should now compile,

and that means we're ready to do

some kind of processing in here.

Well for now, let's calculate and print out

one of these big probable primes.

So this is code that we wrote a lot earlier on,

we can just repeat that here,

we'll want to generate a new big integer

which we'll call BigInteger, and we're going to do that

by calling a new BigInteger,

passing in the parameters of 2000 and a new Random object.

We'll just need to import Random,

and then having got that,

we should be able to do BigInteger.nextPrbablePrime.

Actually I'd like to print that out to the console

so we'll map that in a System.out print line.

Okay, so our worker processing for now is complete.

It's going to receive a message called start,

and when it gets that message,

it's going to calculate a big integer

and print it out to the console.

And just before I leave this video,

I've made a slight mistake,

this isn't quite compiling

because I've forgotten to include

the return keyword in our create method,

so now at least that code's compiling.


------------------


18. Exercise 1 - creating actors

-   Create a ManagerBehavior Class
-   Receive String messages
-   Expect a message called "start"
-   Spawn 20 instances of **WorkerBehavior"
-   Send each instance a message "start"
-   Create the main method to instantiate the system and send the "start" message.



So what we're going to do is create

a new manager behaviour class.

This class should expect to receive

messages of type string,

and will write a message handler

that expect to receive a message

with a string called start.

When it receives this start message,

what it's going to do is spawn 20 instances

of the worker behaviour, that's create 20 actors,

each with their own worker behaviour,

and then send each of those 20 actors

a message with the word "start".

When you've done that, when you've created

the manager behaviour class,

then have a go at creating the main method

to instantiate the system and send the start message

to the manager behaviour.

So I hope that's clear.

Do pause the video and give this a go.

If you get stuck, there's going to be

a walk-through on the next video,

or you can look up the code in the closing workspace

for this chapter, where the complete application

up until this point will be there.

If you get that working and you don't

want to watch the next video, that's absolutely fine.

We'll be carrying on, working through this project,

building it up in the next chapter.



------------------


19. Exercise 1 - walktrhrough

```java
public class ManagerBehavior extends AbstractBehavior<String> {

    private ManagerBehavior(ActorContext<String> context) {
        super(context);
    }

    public static Behavior<String> create() {
        return Behaviors.setup(ManagerBehavior::new);
    }

    @Override
    public Receive<String> createReceive() {
        return newReceiveBuilder()
                .onMessageEquals("start" , () -> {
                    for (int i = 0; i < 20; i++) {
                        ActorRef<String> worker = getContext().spawn(WorkerBehavior.create(), "worker"+i);
                        worker.tell("start");
                    }
                    return this;
                })
                .build();
    }
}

```

```java

public class Main {
//    public static void main(String[] args) {
//       ActorSystem<String> actorSystem = ActorSystem.create(FirstSimpleBehavior.create(),"FirstActorSystem");
//       actorSystem.tell("say hello");
//       actorSystem.tell("who are you");
//       actorSystem.tell("create a child");
//       actorSystem.tell("This is the second message.");
//    }

    public static void main(String[] args) {
        ActorSystem<String> bigPrimes = ActorSystem.create(ManagerBehavior.create(), "BigPrimes");
        bigPrimes.tell("start");
    }
}
```

So I hope you have had a go at this.

I will now do the walkthrough.

So going to create the manager behaviour.

So that's going to be a new class.

We'll call it manager behaviour

(keyboard sound)

and it's going to extend abstract behaviour.

And we said that the manager behaviour

is also going to expect to receive string messages.

Okay, let's create the constructor

and the message handler

and we make the constructor private

and create our static helper method

to create or instantiate the manager behaviours.

So that would be a public static.

It's going to return a behaviour of type string,

which we'll call create and we want to return.

And that is behaviors.set up.

And it's manager behavior::new.

So let's just import behaviour and behaviours.

and that's compiling,

so that takes care of the constructor part.

Now we want to deal with the message handler.

So we always start with

returning a new receive builder

and we'll want to call build on the end.

And then when the message equals the word start,

we're going to do some processing.

So let's have an odd message equals start

and the second parameter is our Lambda.

So in here we'll just to get

the scope power, first of all,

let's end with a return this,

what we want to do then is create 20 child actors

and send each of them a message.

So let's create a loop so that

we can do something 20 times.

So we'll have a full loop I think

the int I equals zero I is less

than 20 I plus plus.

And then within the loop

we should be able to do.

Well, to generate a new actor.

We're going to do get context.spawn

and the actor is going to be this time an instance

of our worker behaviour.

So we can call workerbehavior.create

the static method in the worker behaviour class

that instantiates a work behaviour

and we need to give this a unique name.

So let's call it worker

and then we'll add onto the end

the number from our loop.

So that should create workers zero,

worker one, worker two and so on.

We want to store the reference

to this so we can send us a message.

So let's store the result of that

as an instance of an actor F.

It's an actor F We have to take strings

and we'll call this worker, I think.

Let's import actor F.

And then we should be able to do worker.tell.

and send it the message start.

So I think that's going to take care of

the message handler for our manager.

When we send the manager a message with starting,

it's going to create 20 workers

and send each of them the message start.

So let's go and create the main methods

that we can test this.

So we're going to be creating an actor system

and it's an actor system that's going to expect

to receive strings.

That's what our entry point to the user guardian,

the kind of message that our manager

is going to receive.

We'll call this big primes, I think.

And to generate that, we'll use that

actor system.create static helper method.

So it's actor system.create

This takes two parameters.

The first is an instance of the behaviour.

For our entry point actor,

what that's going to be our manager behaviour

and to create an instance of it,

we're going to call the create method.

We need to give it a name.

I think this time we'll just go for big primes.

So that would have generated

the manager the entry point,

now what we need to do is to send

a message to that manager,

which is the word start.

So we do that with big climbs.tell,

the word start and I think we are ready to run this,

so let's do it and see what the results look like.

Going to make the console window a bit bigger.

Great, well that's working.

We can see the different numbers coming through

and it's clearly multi-threaded

because we can see that it's pretty fast.

We're getting a lot of numbers there very quickly.

It can't be calculating one of those at a time.

Now to complete this project,

we will need the child worker actors to send this data,

the number that they have calculated

back to the parents manager actor,

and we'll learn how to do that

in the next chapter.

But I hope you've got that working.

If you did well done.