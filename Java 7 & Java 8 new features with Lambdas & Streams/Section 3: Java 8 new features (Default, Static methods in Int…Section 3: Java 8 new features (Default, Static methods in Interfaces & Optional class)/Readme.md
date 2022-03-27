### 26. Java 8 new features & enhancements content.md



### 27. Introduction to Java 8.md

Hello and welcome back.

In the previous section, we discussed a lot about Java, C7 and its new features now in this section.

Let's try to focus on Java, A.S.A. and its future that got introduced.

If we can observe the milestone dates that I were showing here, it almost took three years for the

Java development team to release the next version from Java C seven to Java eight.

So that shows how complex this changes.

And Java team spent lot of effort in brainstorming the new features based upon the market trends competition

from other languages.

So they did a lot of brainstorming analysis.

Due to that, they realized very significant changes in the Java Sea.

It was, if you can ask me, we can always look at Java like two flavors.

One is before Java eight and the other one is from Java.

As a developer, my thinking will completely change from Java eight, because the kind of advancements

are features that Java eight is going to provide is phenomenal and it is going to compete with other

competitive languages like Python and Ruby with its new features integrate.

Most of the projects are using Java ET.

That is the reason if you go to any inter, you are.

If you tried to start any new project from scratch, everyone will recommend you at least to start with

that Java eight version.

And also this version is going to change the way that how you think about Java, like before Java eight.

If someone asked you, can I write static methods or concrete methods inside interface, you may laugh

at them, saying that interfaces are meant to be how only abstract methods and you should not write

any business for them.

But from Java eight, there has been some changes inside it to allow static and default and concrete

methods inside interfaces.

So this is one of the simple example that we can take to tell anyone the amount of changes happen between

Java seven and Java eight.

And since there are many features, God introducing Java, definitely developers should put a lot of

effort and there is a lot of learning needed to understand all this new features.

But this section is going to help you to understand all these new features with a great understanding,

along with the practical exercises.

And you may ask, like, what is the need to bring all these new features that are going to change significantly

the way that we write in Java?

The reason is if you don't bring all these new features, the kind of competition the Java community

is going to face from all other competitive back in languages like Python, Jubi is very significant.

And and due to the same reason Java has to evolve along with the market demands.

Otherwise it is going to become languages like COBOL, where they vanished away due to the latest market

trends and another need why we should upgrade to Java APIs.

If you take any of the latest frameworks or latest version of frameworks, especially springboard from

Version two, along with the latest versions of G.P.A. Hibernate and Spring, they are leveraging the

features of Java eight, especially Lambda programming, functional interfaces, default, metastatic

methods.

So all these features that are going to leverage.

So without upgrading Yucel from Java seven to Java eight, it is impossible to use the latest versions

of frameworks like Spring Springboard.

So with all this, it is obvious that Java eight is the most critical version that got released ever

in Java history.

But due to that reason, we are going to put significant amount of time discussing each and every feature

that got introduced along with the coding exercise that I am going to walk through with this.

I'm very excited to take you on to the next lectures where we discuss all the new features of Java eight.

So please be patient and follow me.

And if you have any questions, try to do the coding exercises that I am showing in these videos.

And if you still have any questions, you can always reach out to me through Q&A.

Thank you.

And see you in the next lecture by.



### 28. Default Methods in Interfaces.md
In this video, let's try to discuss about the default methods in interfaces.

So from Java eight, we can write a method which has some business logic inside it and we call them

as default methods.

The reason is interface will provide you the the default, the business logic, and it's up to you as

an implementation class to either override that logic or use the default behavior that is provided by

interfaces.

So that is clear.

Now let's talk about why we need default methods in interfaces.

Why Java community break that rule that we are maintaining from the initial version where we have a

timbrell of not writing any concrete methods inside interfaces.

The main reason is when Java team decided to provide a lot of new features based upon latest market

trends and the competition from other languages, especially to support functional programming lambda

programming.

So they have to update a lot of existing collection frameworks.

And obviously we know existing collection framework has a lot of interfaces.

Abstract classes, if you take map is an interface Lister's and interface.

So in order to achieve these new features, they ended up patching the existing interfaces, as you

know, before Java eight.

If I write an abstract method inside interface, definitely whatever classes implementing my interface

has to override those methods and provide a logic inside them.

The same continuous in Java eight also.

So think for a second we are not introducing default methods.

So in this scenario, if Java team updated all the interfaces available inside Data-Collection Framework

or any other API, and if they release the same to the market for developer community, you can imagine

what is the amount of effort that each project and each organization has to put.

If I just introduce a new method inside Lyster map and you can imagine the amount of work, all the

developers, all the projects that are implementing this list and map interfaces is going to be humongous.

And everyone will start blaming Java team because when you are giving a new version and new features,

definitely there has to be a backward compatibility, but not at the cost of forcing the developer community

to change all of their existing logic.

So due to that reason, they came up with a concept called default methods, like instead of introducing

abstract methods inside interfaces and abstract classes, I will provide you a default implementation

from my site.

It's up to you whether you want to use the default behavior or you want to go right.

That so such matters that we are going to write inside interfaces.

We call them default methods.

So these default methods, main purpose is to provide backward compatibility.

So even though you write any number of default methods in interfaces without making any changes, you

can easily upgrade to Java 1.0 because there are no new abstract methods are introduced that are just

default methods and you are implementation class will continue to use the default behavior powered by

the Java.

So default methods are also known as different.

Their methods are virtual extinction methods, which is making sense, like they act as the defenders

are virtual extinction, where someone draw the logic and you're virtually extending them in the case

where you don't want to override and provide your own logic.

And just like any other regular interface methods that you write, like abstract methods by default,

even if you are mentioning or if you are not mentioning default method are also implicitly public.

You can't write a default method with the private because that violates the purpose of default methods

and compiler will throw an error.

Unlike regular interface methods, default methods can be declared with default, the keyword inside

the method signature.

And once we put that keyword, your Java compiler will allow you to write some business logic inside.

It will see how we are going to write default methods and interfaces in a few minutes.

So this is a sample default method that you can think inside an interface.

So right now I have an interface called Automatic Operation, and inside that I can write the default

method.

The main requirement to write the default method is to use the default key word in the method signature.

And once you put that keyword, you can write your own business logic like I was doing here.

So by default, all the.

Methods available inside interfaces are available to the implementation classes, also, suppose if

I have a class which is extending an interface and that interface has two default methods, without

I doing anything, I have access to them.

It's up to me if I want to directly execute them using the default behavior or I can write my own implementation

by or writing them on ones already, I can use them inside my code.

And since Object Class is the superclass for all the classes inside Java, you can't override the methods

present inside the object class as default methods inside an interface.

The reason is object class has many methods like clone equals.

So all these methods you should not override and provide a default behavior because that will affect

the way Java works.

So due to that reason, you're not allowed to override the object class method as the default method

inside an interface.

If you do that, the compiler will throw error as soon as you do it.

And of course, inside a class, if you want to write a method with the business logic, you can write

a letter using private or public.

There are no restrictions.

But if you want to use the default keyword and write a default method inside a class that is not allowed

inside the classes because these default methods purpose is only for inside interfaces, inside classes,

we always have other ways to implement our own business logic using private and public concrete methods.

One of the most typical use case of default methods in interface is it will allow you to incrementally

provide additional features are enhancements to give and type without breaking down the implementation

classes.

Like think of a scenario where I have an vehicle interface so I have a can interface.

This vehicle interface is implemented by all the automobile companies like Honda, Tesla, BMW already.

So inside this vehicle interface today, I can provide like my vehicle should work in an autopilot mode

and for that I can provide it before the implementation.

If my AALST implementation classes like Honda or Tesla, if they want to use this new feature inside

their vehicles, then obviously they have two options.

One is they can take the default behavior that I am providing in vehicle interface or they can override

my default behavior and build their own logic.

So this way behavior is provided and it's up to the user to use it or not.

But if I don't have default and if I make it as an abstract method, then obviously all the classes

which is implemented vehicle interface will be forced to implement that.

But with the help of default method, that's not the case.

You can incrementally provide additional futures and whoever is implementing your interface can take

them whenever they are convenient in implementing them.

Otherwise they can live with the default behavior or ignore it so that even the current code will continue

to work.

So here we have some confusion scenario, which is a good scenario that we need to spend some couple

of minutes.

Think of a scenario where you have an interface and interface B, they both have a default method with

the same method.

So there is no issue here.

So different interfaces can have different methods with the same method name.

But the problem is as soon as a class started implementing a B, then your class have an ambiguity call.

Which method default behavior I have to consider inside my class.

So there is an ambiguity.

This problem, we call it as a diamond problem also to solve these kind of scenarios.

You have a couple of ways.

One is either go with the implementation provided by either from year B interface.

Ah, you can write your own custom implementation, but in these two scenarios, you should definitely

go write the method with the same method name.

So as a developer first to clear that ambiguity, definitely inside my class I have to override the

method with the same method name once I created it.

And it's up to me whether I want to use my own business logic where I can write my own business logic,

or I can use any of the interfaces behavior provided either from me or B insert scenarios.

You should use the code like the Dart Super Dart M1.

So is is the.

Interface not super means we are calling the parent and dot M1 is the method.

So this way you can clear the ambiguity in these kind of scenarios.

So definitely this is a very good indication that someone can ask you are you may get into these kind

of problems inside of a project and we see many times a class can implement multiple interfaces.

So in those scenarios, this is going to helpful.

That's way I would recommend you to understand this and try to do some practice on this scenario.

Next, quickly discuss about what's the difference between an interface with the default method and

an abstract class.

We all know, like we have abstract classes even before javaid.

So abstract class is a combination of abstract methods and a concrete method.

So it is like almost like interface with the default methods.

So even from Jowett, interface can have concrete methods using default keyword and it can also abstract

method.

But what's the difference between them?

So there is a very thin line between them.

You have to be very careful.

Understand this.

This can be a very good discussion in interviews or inside project solution.

First thing inside abstract classes, you can write constructors and you can also how state and behavior

associated with the abstract class when it says state and behavior.

You can have instance variables inside our asset classes.

It has interfaces.

Constructor is not a lower instance.

Variable state and behavior is not allowed.

And if you look at the second point, it was clearly mentioned there is no chance for creating instance

variables inside interfaces, whereas inside abstract classes you can create instance variables and

inside interfaces.

Static and instant blocks are not allowed, whereas inside abstract classes, static and instant Whitlock's

are allowed.

If your interface has only one abstract method, you can use that interface for lambda expressions.

We will discuss this in detail when we are dealing with the lambda expressions don't work for.

No, you just remember saying that if your interface has only one abstract method, you can use that

interface for lambda expressions.

But at any cost, regardless of whatever methods abstract class has, you can't never easy to write

lambda expressions and atlast inside interfaces, you can't override object class method, whereas inside

abstract class you can override object class methods.

So with this, we have spent enough time discussing about default methods inside interfaces that are

introducing our aid.

The next lecture.

Let's try to spend a few minutes on understanding by doing a coding exercise.

Thank you.

And see you in the next lecture by.




### 29. Default Methods in Interfaces.md
So now we have a clear understanding on what be methods inside interfaces, let's try to understand

even more by doing a coding exercise related to it for the same.

I just came to a and I have opened an interface called Rakel.

As you can see, there is an interface called vehicle, which has to abstract matter, which will give

the current dispute using speed.

And the other abstract method is to apply brakes.

And there is also a class that implements this vehicle.

Since those two are abstract methods, definitely my class has to provide some implementation after

overriding them.

So due to that reason, you can see here, these two methods are already there and there is a business

logic associated to them and this vehicle might be present from the decades inside the system.

And since that gets built and apply, brake is a basic functionality for any vehicle to implement.

We made it as an abstract matter.

So now all of a sudden, there are a lot of advancements happening in the market.

And due to that reason, this vehicle interface decided to introduce a new functionality called autopilot.

So autopilot means driving without a driver.

But the problem with this approach is as soon as vehicle interface decided to introduce a new feature

with autopilot in the form of abstract matter, my Hornback class, which is implementing it, will

get an compiler error and my Honda company may not be ready.

They don't have enough infrastructure or technology to implement this autopilot immediately.

Definitely, there'll be a lot of pushback will come from the all the classes implementing vehicle and

this vehicle interface ended up removing this new feature instead of that.

Now, if you follow the default method approach, instead of declaring abstract method, I can provide

a method with the default implementation.

So as you can see, the method has to be public.

Even if you don't mention it, it will be implicitly public, followed by default.

So default is an important key word which will make this method as default method.

If you remove this, obviously you will get an error saying that inside interface abstract methods with

the body is not alone.

So due to that reason, you have to use this default keyword at any cost.

And now I have provided some default behavior to my autopilot.

Post this, I'm going to say.

And then communication to all my subclasses are companies which are implementing vehicle interface,

saying that we want to compete with others in the market.

Due to that reason, we are upgrading our interface with the new feature called Autopilot, and it provides

some default behavior.

You have some default intelligence mechanism that will make your car as autopilot car.

And when I say this communication, all my sub companies are subclasses which are implementing my vehicle

like Honda Classic.

They have two options.

One is they can ignore this autopilot method and they can continue the same way right now.

And their business is not going to affect in any way because that's a default method that other approaches

they can use this default behavior without putting any other investment.

But in the case where they want to go right.

The default behavior and they want to have their own intelligence mechanism, they are free to override

it and provide their own logic.

So this way you are providing backward compatibility and at the same time you can roll off your new

features are new changes in an incremental manner without affecting all the subclasses.

So now from this subclass, you can see Toyota is implementing it's not throwing any completion issues.

Now, I can simply call that a third, saying that Honda ordered autopilot without any issues.

So in this scenario, I'm just calling the default behavior.

But if you want, you can also override that matter.

As for your business logic requirement, I am mentioning on the autopilot.

So this way, using default methods, Java people decided to roll out the new features by providing

backward compatibility and at the same time they are competing with other languages in the market.

So I'm hoping you got a clear understanding on this.

So in future, if anyone asks, you can interface has concrete.

Methods, which has a business logic, the answer is yes, true default method, so this can be a very

good introduction.

If your project is using one point, they are upgrading to one point eight.

I think this is the one of the important feature that you have to be aware.

Otherwise you will end up scratching your head.

Why interface is having concrete methods, why business logic is written inside interface methods.

So due to that reason, I would request you to please make a note of it varying interfaces.

Also, we can write business logic using different methods.

Thank you.

And see you in the next lecture by.




### 30. Static Methods in Interfaces.md

In the previous lecture, we discussed about default methods that we can write inside interfaces in

this lecture, let's try to discuss one more new feature that got introduced in Java eight, especially

in terms of interfaces, just like how we can write default methods with a concrete business logic,

we can also write static methods, yine interfaces.

Yes, you heard me.

We can also write static methods and interfaces, just like how we do in, say, classes.

You may joke with me like you're making interface look as good as seem like class.

But yeah, I think the way right now we are going is we can almost think like an interface can be the

same as class, just that interface can how abstract methods.

But we clearly understand what's the reason of introducing default matter.

Let's try to understand what's the purpose of introducing static methods are allowing static methods

inside interface.

So before I answer that, let's try to discuss why we write any static method inside a class.

We mostly write a static method inside a class to provide some utility business logic or utility functionality.

Why do we need to the functionality, the business logic?

Because we have other private or public methods which has business logic inside them.

And I want to separate the common business logic that can be used by multiple methods inside my class

into a static utility method.

So that's the main purpose on why we write utility methods, a static method inside a class.

Now the same applies for interface.

Also seems you're allowing to write business logic inside interfaces using default method.

Definitely when you are providing like seven to eight different method inside an interface, there might

be a chance they have some common business logic that needs to be put it in a common place.

So for the same purpose, interfaces are also allowed to write static methods to define any utility

functionality.

It's as simple as that since static methods don't belong to a particular object.

So usually inside a class, if I want to call a static method, I can use the class name DOT static

method.

Similarly, whenever you want to call a static method inside an interface, definitely you should use

interface name dot static method and defining a static method within an interface is very similar to

defining one in a class.

There is no difference at all.

And one more important thing that you have to understand is suppose I have written a static method inside

an interface and there is one class which is implementing my interface.

So in this scenario, my static methods are not available to the implementation class to override them

or to use them using the class name.

So if they want to use, they can always use by using a interface name, not static method.

But as I say, there is no real concept inside a static method because those are specific to interface.

Static methods in interfaces make it possible to group all related utility methods without having to

create an artificial utility classes that are simply placeholders of static methods.

I know this statement looks very complicated, but let me clarify you.

So usually we maintain all our interfaces by grouping based upon functionality.

Like I have an interface with vehicle, I have an interface with mobile.

Ah, I have an interface with person.

So there are many ways how we group our interfaces based upon our functionality.

But when coming to utility classes all these days, we ended up maintaining those utility methods are

static methods inside separate utility class.

Like as a person I have a person interface in order to have any utility logic related to person.

All these days I ended up creating a separate class called Person Utility, and inside that I write

all my utility classes.

But now, since the static methods are allowed inside interface itself, I'm free from creating other

unwanted utility classes.

Instead, I can directly write those methods inside my interface itself of the statement clears to you.

And since interface static methods by default not available to the implementation class, there is no

overriding concept applicable if there is a special requirement where you need to have same static method.

Just like you have in the interface inside your class, also, you are free to create the same method

with the same method name, same method signature, but it will not be treated as a war.

Right.

So in this scenario, you have two separate methods inside.

One is inside interface and the other one is not class.

So this slide will clear all of your doubts, if you have any for a second, just look at it.

We have an interface called here, and it has a method called say hello.

So it just prints.

Hi.

This is a static method inside interface.

Now we have a class B which is implementing here, and it can also have a private static method with

the same name called Say Hello.

And this is perfectly fine because it's in static methods are not available for implementing class to

read them.

So there is no overriding concept here.

The Jaivin will treat it as those two are two different methods.

One is inside interfaces and the other one is in that class.

Maybe now comes to the tricky part.

So you create an object of B, you created it and there are multiple ways you can call say hello.

Static Minturn.

One is by using the object itself, you can call, say hello, insert B class, or if you don't want

to create an object, you can directly call with the help of class name.

But if you want to use the static method present inside the interface, definitely you have to call

it using the interface name.

So.

So the output from this idot say hello and B dot say hello will be definitely different because the

business logic here is different.

This is making clear to you, but will again discuss this in the practical section.

And the last important one that I want to highlight here is we have main method inside class.

Main method is a static method and this is the starting point to execute any business logic in standalone

applications.

You may ask.

It's in static methods are allowed inside interface.

Can I write their main method inside the interface and execute the program?

And the answer is perfectly.

Yes, you can write the main method inside interface and you can execute your program without creating

a class.

So that's a major difference compared to Java seven and Java eight.

So this is the most important tricky question that someone can ask you to test your knowledge on Java

eight or Java.

So in any case, you are in any project discussions.

If someone asks you, can you execute the interface and printout hello world using main method, the

answer is yes, because now interfaces can have static methods from Java eight.

So there is no difference between class with the main method and interface with the main method.

So with this, I'm hoping you're clear about static methods and interfaces in the next lecture.

Let's try to do one coding exercise around it to make it even more clear.

Thank you.

And see you in the next lecture by.



### 31. Static Methods in Interfaces.md
Now, in this lecture, let's try to do some Hands-On underwriting static method inside interfaces.

As you can see, I came to Rakel interface and have written a static method called Say Hello.

So this method will just print.

Hi, this is your favorite car.

As you can see here, there is a static keyword that we have to use along with public next and going

to the implementation class called Honda, which implements vehicle you can see here I again have a

static method with the same name inside the class itself of type private.

And this will print.

Hi, this is your favorite Horlacher.

And if you can observe the main method here, the say hello method present inside the class has to be

called using horndog Dart said hello.

So this line will bring this output, whereas the say hello present inside the vehicle interface has

to be called using the vehicle interface itself.

So there is a clear difference between this.

Say hello and this hello method.

The output is different, the business logic is different and there is no real concept applicable in

static methods.

So let me try to execute this program and you can see this is coming from the interface and this statement

is coming from this class itself.

Next, let's try to discuss about the tricky situation where I have an interface called Static Maned.

And inside that I just created a new static matrix in static methods are allowed from Java eight.

And the method name is me.

So now if I execute this, you can see I get an output running from the static method inside interface.

So I'm assuming this is making clear to you like inside interface.

Also, we can write a main method and execute the programming, the standalone applications.

So this is one of the trickiest and major difference that you can find from Java seven and Java eight.

Thank you.

And see you in the next election by.




### 32. Optional to deal with Nulls.md
Now, in this lecture, let's try to discuss another exciting feature that got introduced in Java eight,

which is optional to deal with.

So from Java eight, we have a new class called Optional that will help you to deal with the null pointer.

Exceptions are null references.

So before jumping onto in detail about this feature on a fun fact, if I ask a question to all the developers

in the world to raise their hand, if they have seen null pointer exception in their call, definitely

I think they will not be any developer who did not raise their hand if someone didn't raise their hand.

That means they never write the code seriously in any of the real time projects.

So that's how common the null pointer exception.

So there are many developers who has nightmares due to this null pointer exceptions.

And in one of the survey it came out null pointer.

Exception is the most common exception and the famous exception that gets thrown inside the code.

And as you know, we as developers community spend a very good amount of time in fixing or taking care

of our code so that there are no exceptions are being thrown from your code.

And it's a very painful and tedious job.

And you ended up writing a lot of emotional checks and balances.

One of the sample code that you can see on the left hand side, if you can see there is a user that

comes to this method and inside the user there is an object Colorada and inside the other object there

will be an item, an object and using item object.

I can find the name of the item.

If you can see here on the left hand side code, the developer has not taken any step to handle the

null point.

This left hand side method control pointer exception if you use original or order is null, are items

null.

So there are a great chance that this method on the left hand side can throw in Alpine exception.

So to overcome that, if I give the same method to any new developer, he will convert this method to

whatever we're seeing.

On the right hand side.

You can see here the developer put null checks at each layer where in null is possible, like my user

object may be null or my order can be null.

Armi item object can be null.

So he ended up putting all checks in all the places where an object can be null if at any place, if

there is a real value comes instead of throwing null pointer exception, this court will return the

value not available to the caller who whoever is calling this matter.

But as you can see, this is a very painful process and developer has to put a lot of effort to handle

this kind of code.

So to save you from these kind of scenarios, we have an new class called optional introducing Java

eight.

So let's try to understand more about it.

So optional is going to help you in multiple ways, but don't think that this optional will fix all

your null point options.

So this is not meant for that.

You may still get nonpoint prescriptions, but this optional will help you in dealing with those null

pointer exceptions effectively.

What I mean is if you are getting a null value from the database, this option is not going to help

you in any way because the issue is in the data itself.

But this optional will help you to handle the null pointer kind of issues in a graceful manner and a

peaceful manner.

One of the major purpose of this optional that we can think is suppose I as a developer, spend 10 years

inside a project and I have a clear understanding which object can be null and which object cannot be

null inside my project.

But this knowledge I have gained through my experience inside this project or 10 years.

But at one day, if I leave the project and some other developer comes, then whatever knowledge that

we gained, we can provide that to the new developer because that will take a lot of time.

Instead of that, if I use this optional inside the methods that I am writing as an experienced developer.

So in future, if some other developer comes whenever he sees this optional inside a method signature

that developer can understand, this method may or may not return a nominal value.

That means the developer can expect that this method can return a null value also.

That's why my senior developer used optional.

But if there is a method where my senior developer didn't use the optional, which indicates you can

always expect a value from this method in return.

So that's the main purpose of optional, which will help you in writing better space so that other developers

can understand whether this method will give you a null value or not as a return.

But if I use optional it always guaranteed to my developer, you may or may not get a nominal value.

That means be ready for both scenarios where you get a real value or nominal value like you can see

here.

Optional is a class that got introduced in Java eight inside the package, Avodart, Italy.

And there is a generic with a value t that means any object you can wrap inside optional like string

person, object, employee object, any object that you can drop inside it.

And you can see here I have an object called order if I use optional and wrap other inside it.

So there are two possibilities for the outcome.

One is I immediately send the order object to the user or there might be a scenario, an empty value

can be sent which is empty, optional.

So when the value is present, your optional class fraps it, if there is no value is present and empty,

optional will be returned by using optional, not empty method.

So we will discuss more about this in the next slides and the coding exercise.

But for now, think like when someone is returning optional but empty, I have more chances to work

on it to decide whether it has values or not easily without having felt blocks inside my code.

Let's talk about it more in detail.

You may wonder what the difference between a null value and optional, but empty.

So the bodarky same semantically.

But in practice the difference is huge.

So if someone is trying to access and null reference of an object, they will immediately get an all

point reception, whereas optional, not empty is a valid, workable object of type optional that can

be invoked and used in many ways.

We'll discuss about how to invoke that on top of optional, not empty, but for now have an understanding

that there is a clear difference between an object and optional.

But empty null object will definitely throw an alpine option, whereas optional, not empty, has various

utility methods to decide and proceed on to the next steps without the help of if undealt blocks.

And as I was saying, it's very important to understand the intention of.

The optional class is not to replace every single null reference, so Java community is not asking you

to go ahead and replace Oliver if blocks else blocks where you are checking null values with this option,

because that's going to be a huge effort for any project.

Instead, its purpose is to motivate people to design their new EPA's new code more comprehensively

so that reading the signature of a method you can tell whether to expect a value or not to the future

developer's going to join your project.

Again, these are the different ways how we can create an optional outside object.

The very first line you can see optional but empty will create an empty optional.

So if I try to print this or Prag, it will just print optional empty because it doesn't have anything.

We can also see the same inside the coding exercise.

The next way of creating a optional object using a product object is by using the other method.

So insert optional.

There is an off method which you can pass the actual object and this method will wrap your actual object

into optional.

But please make sure your product is null.

In this scenario, you will get an alpine collection immediately.

We should use of method to create an object from a given object only if you are sure of that given object

with a nominal value.

But if you are not sure whether a given object is null or not null, then you can go ahead and use the

Afnan.

So that's a primary difference between off and often the label.

So avil traditional pointer exception if your personal value, whereas Afnan label will not throw any

exception.

Instead, if the object is null, it will return an empty optional object.

If the object is not null, it will return by wrapping that entire object into an optional.

So don't worry, we will discuss about this again in the chording exercise.

Even if it is not clear now it is going to clear you in the coding exercise.

Advantage of optional is there is no need of null checks.

You don't have to put Infeld's blocks.

I'll show you that.

How in the coding exercise and no more null point exceptions at runtime if you use optional because

optional has various methods to check the content of the object and act accordingly.

And as I was saying, if you use optional inside your you are giving a better information to other developers

whether your method is going to always return a value or not, which means we can develop clean and

neat apps.

And obviously the last one is we can avoid boilerplate code where we have to write a lot of if conditions

inside your code to do the analytics.

And these are the important methods provided.

INSIGHT Optional in Java eight will be going to discuss each and every method inside coding exercise

on a high level.

Let me tell you what the purpose of this method is optional, but empty will return an empty, optional

instance.

That means there is no object, is there?

But it's not equal to null.

Filter is a matter.

If value is present based upon the matching criteria that you are sending, it will return an optional

representation of that return object.

Otherwise it is going to return an empty one again.

Don't worry about what is predicate here.

So Predicate is a functional interface that we are going to discuss in the coming lectures.

Forno just think Predicate is a boolean check that will happen to check whether my given content has

the object.

Matching my filtering criteria is present again is a pretty method to tell whether a given optional

object has a value or not.

So this is just like as good as doing a check using if if present is a method which will be invoked

as specified a given logic.

If a value is present, otherwise nothing will happen and get will return the value wrapper by the optional

if present.

Otherwise it will be true and no such element exception.

That's fine.

Make sure whenever you try to access get you how to handle or think of the scenarios where if there

is no value then no such element exception.

Instead, you can also use these present if present.

Next, we also have map method to map method.

We'll try to map a given value to the corresponding different value.

Like four have an object which has a string inside it for use a map method.

I can write a logic using map.

Matter, if the content is present, go ahead and convert into an uppercase from lowercase, and that's

where we can use map again, map filter methods are coming from lambda expressions and streams will

discuss about more in the coming lectures.

And the last three are most useful methods.

So just like if present, where if the value is present, then only the current logic will be executed.

The negative of it is oriels.

So when we use our else method, it will return the value if present, otherwise returns the given default

value or else that is a different matter compared to ORIELS.

The only difference is in a really, really hard code, the default value, whereas orell to get you

will write your own method to give it the real value.

Ahlstrom is a method where if the value is present, it will return the value.

Otherwise it will throw an exception, as you say, to the user.

These are all utility methods available.

Insert optional.

I know it might not be clear for few of you, but let's try to discuss them in detail.

Encoding X-rays and things will be clear to you.

Thank you.

And see you in the next lecture by.




### 33. Optional to deal with Nulls.md
In this lecture, let's try to do some coding exercise related to optional to clear our understanding

further regarding this new class, the court introducing Java 1.0 to handle the null pointer exceptions.

So for the same, I just came to an optional example that Java inside my project.

Before we jump onto the code inside this class.

Let me show you the optional class that is present in Java that you can see.

This has been introducing Java one point eight, and this is a generic representation to indicate that

this option can hold any type of object right from string to any potch objects that you have inside

your project.

And it has various methods to help you dealing with Reynolds.

And null pointer exceptions like to get the value used to present exemptive present.

So all these things that we already discussed in the previous lecture, let's try to do some coding

exercise on the same.

So I have a main method and inside this I'm calling retaliate.

But before that, let's try to see what is there before Java.

It wasn't so before Jouyet.

You can see here just for representation purposes, I have created a string empty string of size systemd

and all of a sudden I'm trying to access 15 decks and trying to convert to lowercase.

So definitely here I get the null pointer exception.

The reason is this fifth index will be null because I never populated this array.

And I get another point reception at this point of.

So this is how we used to deal before Java.

There is no option if how to fix an except exception here, obviously how to introduce effects which

will increase the boilerplate code inside my method.

But I'm not invoking this insert my main method because I get null pointer exception.

I just kept it for your representation purposes.

Now let's go to the Java eight with Java ATM.

So I kept a breakpoint here.

Let me run this class and debug more so that I can show you line by line in the back.

More so first line, I'm creating an array of lanterne and in particular fifth index and populating

with some value.

And as I said before, MTIs, a matter which will give you an empty optional representation of a given

object.

So here, since we kept the string inside the Generex, that means this optional can hold string object

type.

And since I'm creating optional, not empty, if I printed Algate optional, not empty only because

this optional does not have anything and this is how it will be represented to indicate that optional

does not have any value.

So if you have to create a new object, you can always use optional but empty and wrap it inside optional

so that you have some at least initial object declared next.

As you can see, we can use of method also.

So since I am very sure that at the 5th index I have a value, I'm using half.

So whenever I use of followed by object, my value will hold that object.

And as soon as I call value target, I will get the whatever value present at that index, which is

easy.

But let me clear the console now, since I'm not sure whether at the 4th index I have an value or not.

That's why I'm using of Nullable instead of half.

So if I exclude this, obviously, since I don't have value there, this null value will hold empty

representation of it.

And next I'm using if present, that means if the value is present, bring the value.

Otherwise, we also have a method or else that means if there is a value, go and print oriels, print

the default value that I am providing.

So here in this scenario, if I print, there's nothing happened because this code will be executer

only if it is present.

And don't get confused with this double column because this is a new feature again coming in Java eight

call method reference.

I'll be discussing about this in the coming lectures for now.

Just think like if the value is present, it is going to print whatever value is present.

Since it's not present, nothing is happened next, since it does not have any value, that fear or

else got executer.

So orals will get executed if the given object does not have any value and it is an empty object.

That's why it is printing the default value that we are given, which is no value next time trying to

create again one more optional representation of.

String with the value easybeats, so that's why I very sure there is no chance here I'm using off a

next line, I created an empty string using empty.

As I was saying before, map is a method to convert our given data to whatever format that we want.

So in this scenario, I want to take the non-empty string, which is easy.

And on top of this, which is coming from the optional class, I'm calling map method and to this map

method, I'm just saying convert the content of this optional to uppercase.

And since I know that content is string, I use this again here method reference.

So don't get worry about it for now.

Just things like this code will execute and convert the given string to uppercase.

So that's the purpose of map.

So as soon as I execute this, you can see how easy bytes got converted to uppercase.

Next, empty string.

So empty string does not have any value.

So let's try to see what happens if we try to convert that.

Ideally, you might be expecting another pointer exception, but you can see here it didn't throw that

null point and instead says the given optional is empty.

So I will not go ahead and run.

Any logic to this map has internally that check to return the empty value.

Next, there is also a dislike map.

We also have flatman the purpose of flat map mattress to flatten the multiple layers of optional.

Like you can see here, I'm calling optional of two times, which means I will get optional in two layers,

like Frosty's in a layer and there is an outer layer.

Also, if you try to operate on this using mapmaker, you will still get the two layers with the content

converted to uppercase.

Whereas if I use the flat map method, it will flood the content into a single layer.

Like you can see, the two layers of optional is flat to one layer of optional.

So that's the purpose of Flat Matmata.

We also have this method inside streams where we will discuss more about it because that again, creating

a country with the name India and there is one more country with the variable empty country and creating

and since I am using option that empty, this empty country will have no value, whereas this country

will have value India since I am passing the initialised value to the ATM.

So let's try to understand the purpose of Frater method available inside optional.

So using filter.

I'm saying if the given optional object has content which equals two small letters of India, go ahead

and print, otherwise it is going to bring the empty value.

Similarly, the next line, since the condition is going to satisfy, will print whatever value present

inside the given object and the class, since the empty country does not have any values.

Even if I call filter on top of it, it will not draw any Nalpas interaction.

Instead, it will return me optional, not empty.

That's the purpose of filter method.

Next, we can move on to the method is present so each person will return a boolean.

Just like if you want to do all style of checking, you can use its present.

So since the country has some value, its present will return.

True due to that entered into this block and printing this value value available.

So there is a difference between its present and if present.

So your present is just will return only boolean where the value is present or not, if present will

execute a given matter if the value is present.

So if the value is present, I'm saying to execute this lambda code again, this is a lambda core.

We will discuss what is lambda expression and lambda code in the coming vigário forno.

Just understand if present really execute the given logic if the value is present since the country

has the value inside it.

So what is is going to do is it will take the value present inside the country and it is going to happen

to this statement.

So let's try to see.

You can see for the given statement it appended the value that I provided, whereas the empty country,

since the value is not present and it's only optional but empty, it will not execute this method because

if present will stop that from executing due to lack of value.

Due to that reason, you don't have anything output printed.

And at last we have another method called.

Or else so or else what it will do is if the given option object does not have value, it will print

what our default value that you are providing.

Since country has some value inside it, it will not bring the default value.

Instead, it will print the whatever value present.

And if you check the empty country, since it does not have any value inside it, it is going to print

the default value that I provided, which is no country debt available.

And next, all we have is or else get or that is similar to Adel's.

But the only difference is instead of you giving a default value, you can provide a lambda expression

to you saying that there is no value.

Execute this lamda method and return the value from it seems empty.

Country does not have value.

So my idols get will invoke this lambda expression here and this lambda expression is retaining a value

called no country that are available to due to that it is printing.

But again, instead of calling, you can write your own business logic.

Inside this lambda method, Lambda Expression will talk more about lambda expressions in the coming

videos, but not just try to understand what the purpose of these methods and atlast are.

Altro here.

I'm saying if the given optional object does not have value inside, go ahead and throw this exception.

But if it has object inside it don't throw an exception.

So that threatens empty country is an optional object without any value.

I'll get an exception which is no such element.

Exception to this way optional is providing you various utility methods to handle null references are

null object inside your code.

According to me, the most powerful methods are if present or else or else get and or else throw you.

Also how all different methods to create an empty optional are to create an optional object from a given

object using off and of nullable.

And you also have utility methods to do perform some operations on the values of an object using map,

filter and flat map.

So the options are more compared to our traditional null checks that we used to do before jobby.

So with this, I'm assuming you are very clear about optional and its purpose.

I would encourage you to look at this program one more time, try to debug the code, try to understand

it, and if you're not clear, try to make some changes to this program and try to debunk the core.

If you still have questions, you can post me in the Q&A section.

Thank you.

And see you in the next lecture by.



### Quiz 3: Java 8 new features & enhancements quiz