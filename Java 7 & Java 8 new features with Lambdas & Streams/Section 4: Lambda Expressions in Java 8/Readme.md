
### 34. Introduction to Lambda Expressions.md

In this section, let's try to discuss about one of the major feature that got released in Java eight,

which is none other than lambda expression, if you ask me what is a feature that I like the most Intel

Java language and what is a new feature that excites you in the new releases that are happening in Java?

I will definitely always choose Lambda Expression as a most interesting feature that excites me inside

Java.

The reason is Lambda expressions will allow you to write less code and achieve more.

And it is very unfortunate that when I see some of the projects, they are using one point eight.

But the developers are not leveraging lambda expressions inside the code that they are writing.

That's because they don't understand what is lambda expression in detail and how to write the lambda

code.

So with these videos and lectures that I am going to deliver in this cause, I want to help all the

developers to be fully aware about lambda expression so that they can write a better and clean and less

code using lambda expressions.

If you talk about the history of the lambda expression, Intially Java was released in nineteen nineties

as an oops language, which is object oriented language, and this entirely changed the way all the

languages taught during 1990s.

And it was a principal paradigm for software development during that time.

But recently, along with the group's concept, there is also called functional programming has risen

its importance because it is very well suited for concurrent and even driven programming like reactive

programming.

That doesn't mean that oops, programming language is bad.

Instead, the winning strategy is to blend both object oriented and functional programming.

That's what Java people done in Java eight version using lambda expressions.

We all know whenever someone says object oriented programming language, everyone definitely will think

about Java.

That's a basic way on how Java works.

Everything it works using objects.

You create skeletons in terms of classes and you create objects outside them.

You process your business logic and data using the objects entirely.

But the main objective of Lambda expressions that code introduce in Java eight is to bring the functional

programming, features and style into Java without affecting object oriented language.

If you ask me what is a lambda expression?

So lambda expression is a block of code that you can pass around so it can be executed later one site

multiple times.

It is an anonymous function that means the function does not have any name, return type and access

modifies.

I know if you are hearing about this definition very first time, it might be very confusing to you

to understand.

But I am promising you it will be more clear in the next two videos that we are going to discuss.

Furneaux just assume Lambda expression is a method without having any method name and it does not have

unnecessary code that we need to write.

Return type, unwater the access modifiers of the input and output parameters.

All that extra redundant code has been removed using lambda expression.

And one of the great feature of the lambda expression is you can pass your entire business logic as

a behavior to another method are variable so that it can be executed any number of times.

What I mean here is like just like how you pass method parameters, like if you want to pass a data

to a method, you pass them inside input parameters.

Similarly, you can also parse the business logic that you want to be executed using lambda expression.

So that's the main purpose of it.

And at the same time, lambda expression also will reduce the number of lines that you have to write

and it is going to achieve more results with very Lesco.

So this paradigm is called code as data, just like how you pass method parameters, which has data

you can also pass.

Your functionality are called as a method of argument using lambda expressions.

And unfortunately or fortunately, this lambda expressions are already part of the other competitive

language of Java like Python and Jubi and Java community.

Realized it later, very late, but at last they released this lambda style of programming in Java eight

with a bank.

So with the lambda expressions coming to Java again, Java became one of the best language that developers

can delay since it is now providing both functional style of programming and object oriented programming

so that this is just a quick interaction that I want to go.

About lambda expression, don't worry, and I know that you didn't get any information about what is

lambda expression in this video.

Bear with me in the next coming videos.

It is going to be super clear to you.

Thank you.

And see you in the next lecture by.



### 35. Lambda Expressions Deep Dive.md
Now, in this lecture, let's try to understand what alarmed expression and how to write lambda expression

and how they are different from the existing way of how we are writing methods before we jumping onto

the detail.

I just wanted to share one more important feature that caught introducing Javaid, which is tightly

coupled with lambda expression that is a functional interface.

And addition, we will discuss a lot about functional interfaces after lambda expression.

But Furneaux just make a note that functional interfaces are like interfaces which will have only one

abstract matter, which means this interface can have at any cost only one abstract matter.

And if you try to add one more abstract matter, it will become a normal interface.

So to restrict the user and to make the developers aware that this is an functio interface and don't

add any new abstract methods.

Java team introduce this annotation.

Like if I try to add one more abstract method here, I'll get done compilation error saying that invalid

function, interface annotation.

So then my developer immediately understands the function interface and I should not add any more abstract

methods.

So timbrell fervency interfaces, which should have only one abstract method, but at the same time

it can have any number of static and default methods.

If we can recollect from a previous discussion, interfaces can how static can be for all methods from

Java eight.

So since those are not abstract methods and since they have a business logic inside them, even for

functional interface also there is no restriction for them.

We can write any number of static default methods, but the only restrictions should have only one abstract

method inside function interface.

So now you're clear what this French interface.

Let's try to go to Lambda Expression and see how lambda expression are tied to function.

So on the slide, I'm showing some lamda style of programming where we can write methods without having

a name for them and without having access modifiers like public, private and at the same time, we

don't even have to tell what are the input parameters like when you pass.

You don't have to tell NPR interview.

Instead, you just can say it a bit.

So in another way, we can say lambi expressions are just like our methods only, but they are like

anonymous methods without having any name.

And at the same time, they also allow you to perform and write your score without any access modifiers

and without any data types for parameters, both input and output.

And this is Achu using functional interface.

The main purpose of functional interfaces.

Since we are going to write the anonymous method without having any information about method, name

access modifiers or input parameter types, obviously my compiler don't have any idea.

So when we try to execute this method, definitely we can't execute this because it's an anonymous function

around and even the parent company don't know in which way they have to be executed.

So to remove that ambiguity and to make us compile a smart enough Java people introduce functional interface

now in the context where we have a functional interface with having only one method, which is print

hello, it does not accept any input parameters and its access modifier is public and it is written

type one.

So there are multiple information in the definition of the abstract method itself, which is public

wide, and this is the method name and there are no input parameters.

So now if I want to write a lambda metadata lambda expression for this interface, definitely there

are two ways.

One is a one state way of writing that method inside your class.

In that case, definitely your class should implement that interface.

So once I implemented that interface, I can write that method.

And inside that method I can provide the business logic that whatever I want, but either way is using

lambda expression.

Also, you can provide the business logic.

And when I'm trying to provide a business logic inside lambda expression, I don't have to mention this

public void unmetered name.

The reason is this information is already present here.

And since this interface has only one method, there are no other methods inside this, especially abstract

methods.

My compiler does not have any confusion.

The compiler know that I'm trying to provide a lambda expression for this function interface and this

function interface already has a single abstract method which is public wide print.

Hello.

So then I don't have to provide public.

You can remove that then.

I don't have to provide while you can remove that unmetered name also is not needed.

You can remove that next the parameters you have to pass.

Definitely.

That's why we put this parentheses followed by there should be a separator between your input and the

body that you are trying to write, which is this add separate.

So this Arrow's operator is the one which can tell any developer or anyone who is reviewing your code

that this is a lambda expression.

So please do remember whenever you see this arrow separator between parameters and body, definitely

lambda expression after this add or subtract everything else is seem like you will have this calibrations

and you'll also have the business logic, whatever you want.

And you can also see easily the amount of code that got reduced.

Frosties, you you don't have to mention public wird method name.

And also if you have parameters, you don't have to mention the data type.

So we'll come to that in detail.

But for now, just assume we have an interface which has a method without any parameters and no written

statement, and that can be converted to lambda expression in this format.

So we are clear on that.

Now, one more advantage with the lambda expression is if we have only a single statement inside your

method or inside your business logic, then this culebras are also optional to you.

That means this lambda expression is same as the one that you are seeing in the town.

But please make sure whenever you are removing this calibrations, this entire statement has to be in

a single line.

As soon as you have this Aramaki, you should start the whatever business logic statement.

You have a single statement.

So this is the way how we can.

Lambda expressions by avoiding a lot of boilerplate code with less code, we can achieve more.

So now we are clear on theory discussion on how to write the lambda expression or lambda method for

that matter, which does not have any patterns and return to.

Let's try and explore this more in the coding exercise for the same.

I just came to the eclipse.

As you can see here, I have a functional interface and it has only one abstract matter called Mentallo.

And dysfunctioning device already has enough definition about the matter, which is public wide and

it does not have any patterns.

Now you can see here how written a classical lambda examples inside that there is a method white metal

with no parents.

And this is all the logic that I have written inside this method.

One advantage with the lambda experiences, you don't have to implement that function interface in order

to override and provide a logic.

That's one of the great advantages that you have with lambda expression.

So please make a note of it.

So now I am into this wired method with no parents.

You can see first I have to create an object reference of the interface that I have already, which

is why the method with no parents, it's a functional interface and this is the object reference.

Since we can't create an object for an interface, definitely you have to pass what is a behavior that

you want to attach to this functional interface, abstract matter.

And that's where, as we discussed in the slide, since this abstract matter does not have any input

patterns, we just put these brackets and public wide method name is not needed.

And this arrow mark is there to separate and with calibrations I can start my body of the method and

I put this statement inside this method.

So now that the object of this interface, which is method, holds the behavior of whatever I define

and who would want to invoke my functionality, they will just use this object and invoke the single

abstract method that we have, which is Sprinkel.

And one more great advantage.

And it might excite you also in a traditional before Java eight, if we have one interface which you

implemented, you can to provide multiple implementations on multiple logic inside the same method,

like if you want to right inside your class at Max, you can only have one more method and you can define

your own business logic.

But here you can write any number of business logic based upon your different requirements using a single

functional interface, abstract method like you can see here, I just created one more object reference

of that interface.

And now, since this is a single statement, I also removed this extra calibrations and I'm trying to

print so inside the body since we have only a single statement, the calibrates also not needed.

So this is the simplest form of the lambda expression.

And whereas this is you just put calibrations to make it more readable, but both of them result in

the same kind of logic.

And you can see here, I'm trying to print a different statement and here I'm trying to print a different

statement.

That means I can pass my business logic as a behavior and I can execute it any number of times.

So now you can see here the same functional interface.

I have two different behaviors, two different implementations within the same class and same method

and advantages.

Here is when I call method print.

Hello, this will print this statement and this will print this statement.

So to define my business logic, I'm not writing any better.

But in order to do the same in before Java, it definitely this has to be in one method and this has

to be in another method.

And those method has to be called inside this method, which is like a lot of redundant code and boilerplate

cold.

But here inside a method, you can write your own business logic without creating a method using expressions

like we are doing here.

So let me put a breakpoint here and debug the class.

Now, declaration's done.

Now we have a definition for this method and method one objects.

So as soon as I call print hello using method object, whatever business logic I define in the first

lambda expression that will be executed and next, the next logic will be executed.

So this way we can write lambda expressions with the less code, with the help of functional interface.

Now since we are clear about how to write a lambda expression for a simple matter without any patterns

and written type, let's try to explore what are other matter types that we.

And rewrite using lambda expression in the next lecture.

Thank you and see you in that next lecture by.



### 36. Lambda Expressions Deep Dive.md
Now, in this lecture, let's try to understand how to write a regular method which has a single input

parameter and at the same time it has white written type for the same in order to convert a method of

this type into a lambda expression.

Definitely we need a functional interface for the same.

I have written a function interface with the name Y method with the one pattern you can see here.

There isn't a single abstract method which is as m with the name print input.

The purpose of this method is it will take an input and it will try to print it out.

And this interface has only abstract matter.

There's no business logic and now will take this function interface as a base to write lambda programming.

As you know, since this already how method, name, access type and return type.

The main difference between what we discussed in the previous video and this video is this method has

one input parameter and the data type of that.

This input parameter is already defined in this interface with the value string.

That means insert lambda expression.

You again don't have to mention what is your input data type, which will reduce some boilerplate code

inside your program.

Now let's try to go and see how this can be actually inside Lambda Expression so you can see on the

left hand side there is a method which is print input.

It will take input and it will print whatever we have given.

That's a regular business logic that we want to achieve.

And this is a way of writing a method by using our words today where we have to override the method

inside your class by implementing that interface.

But now with lambda expression, you don't have to write public because compiler already know based

upon fancy interface and it has only a single abstract matter.

You do not have to write while you do not how to write method name.

It's going to be anonymous matter.

Now you have to start this bracket and string is not needed.

You don't have to put the string.

When are you writing lambda expression of this method?

The reason is smart enough to identify or.

This method has only one input parameter and this data type is string based upon the definition that

we define in the functional interface.

But again, it's up to you.

This is an optional value, the string.

So if you want, you can keep otherwise if you want, you can remove that also.

But this is the ideal way of writing.

And once I have that, I can start calibrations to write my body of inside my method and write my business

logic.

So this is one way or the other way is like we are discussing when your body has only one statement,

then this calibrations are also optional.

And at the same time, if we have only one method input parameter, even the brackets around this are

also optional.

So what are I highlighted here in yellow color can be removed and this is how it will become.

So you can see here the power of lambda expression, of functional style of programming.

All this core that you are seeing in the left hand side can be Achuar with a single line itself.

We have removed all boilerplate code, especially pleased to remember, like if we have only a single

parameter water brackets you have around, it is optional.

And even if you have a single segment inside our business logic or Method Bardy, you can remove those

calibrations as well.

And this is how it will looks.

And this is the simplest form of lambda expression.

When you have a method which have only a single parameter and single line of business code, let's try

to go to the code and understand more about this method style.

So we have an interface with the name White Matter with one parent.

It has only one single abstract method which will satisfy the conditional function interface.

Now I am going to the same class called lambda examples.

So this time I am going to the method of method with one pattern.

As you can see here, everything is going to be same.

You will create an object reference of that interface.

But since you can't create an object, you have to provide the implementation of that interface using

lambda expression and you don't have to mention any method, name, return type, access type and even

for the input BARAMULLA.

So you don't have to mention like string, but if you want you can mention.

But this is going to be completely optional for that.

This arrow you have to mention to indicate that this is a lambda method or lambda expression and followed

by this calibrates and this statement that you have the other ways since you have only a single line

of business logic, you.

And remove this calibrations also, so that's a matter with the reference method one, or you can also

even further simplify it, because when you have only a single parameter, as we discussed, even these

brackets also are optional.

So I have removed them and insert method to object reference.

You can see this is the most simplest form of lambda expression that you can write in the scenarios

where we have one input pattern to the matter.

And you can see here the beauty of lambda inside a single method.

I have three different behaviors that I'm passing when I'm trying to execute print input.

So as a developer, I want to use print input method.

But based upon my requirement, the behavior can change and behavior I'm trying to pass as an input

to this method, method one and Method two, along with the input parameter.

So now if I keep a breakpoint and run this method, you can see first we created a method, method one

and Method two.

Definitely since this preprint input is going to take a string input, I'm going to print it on the

console and how all that so you can see here, Hallowes printed next easy by is printer, followed by

welcomeness.

It's not only about this out.

You can also make some changes like instead of just printing in this matter, you can say to lower case

in this matter, you can say to uppercase.

So which indicates that I'm trying to parse different different behaviors based upon my requirements.

If I try to execute this and release the breakpoint, you can see the second one, print all easy buttons

lowercase and the third method prints are in uppercase, which is welcome.

I hope this making sense to you in the next lecture will try to explore how to write a lambda representation

of a matter which has more than one input like which has two inputs in its definition.

Thank you and see you in the next lecture.




### 37. Lambda Expressions Deep Dive.md

In this lecture, let's try to discuss about how to write the lambda expression from the methods which

has input parameters more than one.

So your method can have two or three are any number.

The format is going to be the same.

So that's why we are going to discuss a method which has to input parameters for the same.

First, we have to write a functional interface.

The function of its name is White Method with two parents and there is a method called calculate and

print.

So I'll give you two parameters to you.

You calculate based upon the logic that I have given and post that bring those values.

So that's our expectation from this function interface implementation.

We can see here we have a method call out with two input parameters which have indeed come A B and this

is the way we used to write before Lambda expression.

You just read that method and take those input parameters in A and B had them and you print them with

lambda expression.

Definitely.

You don't have to write public void add because this information already present in the functional interface,

which has a single abstract method and into a comma into B even mentioning the data type also is optional.

That's why I highlighted in a local post that you should start your basis, because definitely your

body right now has two statements.

One is adding the two values and catching the output of it.

And the last statement is printing the output.

So this is pretty straightforward.

You can save from not writing them method names.

All that redundant code inside lambda expression.

The same expression can be made it even simplified by removing those data types like I was showing here,

Ekom, A, B and Bozkurt.

Make sure we have this Addas operator followed by calibrations along with the metallurgic that we have.

So this is the way how we should write a lambda expression for matter, which has two parameters, are

more than two parameters.

The key message that I want to convey here is we can write anonymous matter and we can avoid parsing

boilerplate code just because we have a functional interface which has a single abstract method.

That's why our compiler can easily understand.

Okay, there is only a single abstract method.

If a user is creating an object of this interface, then definitely he's going to implement only that

method.

There is no other methods to implement him.

So based upon this understanding, it can infer all other details like method, name, return type,

access type, input parameters, data, type, everything by itself.

And developers are free to write them again and again.

And one more butis.

You don't have to implement the interface in order to write the lambda programming along with you can

pass your method, our business logic as a behavior inside a method any number of times and executed

as per your business requirement.

So now let's try to go to the code and try to see this in the program as well.

So we have a functional interface called White Matter with two parents, and it has only one method

called calculate and print.

And this method is an abstract method now and go to the class lambda examples here.

This time I call the method wird method with two patterns.

I'll keep it breakpoint here.

As you can see here, I am trying to create an object reference of this interface with the name addition

and I'm taking these two input parameters.

I am not return method, name, public void and even I didn't mention in the year come into B also straight

straightaway mentioning it cannot be.

So now you can see here I just return the business logic saying you just take the input, add them and

bring them.

Since this business logic has only one line in need, this calibrates are also optional.

So that's where we can remove them and we can make it even more simpler form.

And one more thing that I want you to observe is here.

It is an addition here which in that behavior to multiplication.

So addition object will perform addition and multiplication, object will perform multiplication.

You can see here the beauty of lambda in a single method.

You can provide any number of behaviors that you want and you pass them those behaviors whenever you

try to invoke the abstract method that you want to execute.

So obviously the method name will be same, but I'm trying to pass a different behavior using this object

references when I call addition that calculate and print.

It will add these two numbers and print, whereas this one will multiply and print the value.

So let's try to debug this program by putting a break point and I'm running.

Let me clear the previous console.

So now I'm just executing line by line.

We have created two lambda expression.

So this will print seven as the output and the next one will print 10 as the output.

So with this, I'm assuming you guys are super clear about this lambda expression, how to write the

existing methods into a lambda expression with the help of functional interface in the next lecture.

Let's try to look at the method which has some return type.

So all these videos that we discussed not have any return type.

We discussed about the methods which have widely.

But let's try to understand how the written statement are written.

Keever also can be avoided inside lambda expressions.

Thank you and see you in the next lecture by.



### 38. Lambda Expressions Deep Dive.md
In this lecture, let's try to discuss about how to write the lambda expression from the methods which

has input parameters more than one.

So your method can have two or three are any number.

The format is going to be the same.

So that's why we are going to discuss a method which has to input parameters for the same.

First, we have to write a functional interface.

The function of its name is White Method with two parents and there is a method called calculate and

print.

So I'll give you two parameters to you.

You calculate based upon the logic that I have given and post that bring those values.

So that's our expectation from this function interface implementation.

We can see here we have a method call out with two input parameters which have indeed come A B and this

is the way we used to write before Lambda expression.

You just read that method and take those input parameters in A and B had them and you print them with

lambda expression.

Definitely.

You don't have to write public void add because this information already present in the functional interface,

which has a single abstract method and into a comma into B even mentioning the data type also is optional.

That's why I highlighted in a local post that you should start your basis, because definitely your

body right now has two statements.

One is adding the two values and catching the output of it.

And the last statement is printing the output.

So this is pretty straightforward.

You can save from not writing them method names.

All that redundant code inside lambda expression.

The same expression can be made it even simplified by removing those data types like I was showing here,

Ekom, A, B and Bozkurt.

Make sure we have this Addas operator followed by calibrations along with the metallurgic that we have.

So this is the way how we should write a lambda expression for matter, which has two parameters, are

more than two parameters.

The key message that I want to convey here is we can write anonymous matter and we can avoid parsing

boilerplate code just because we have a functional interface which has a single abstract method.

That's why our compiler can easily understand.

Okay, there is only a single abstract method.

If a user is creating an object of this interface, then definitely he's going to implement only that

method.

There is no other methods to implement him.

So based upon this understanding, it can infer all other details like method, name, return type,

access type, input parameters, data, type, everything by itself.

And developers are free to write them again and again.

And one more butis.

You don't have to implement the interface in order to write the lambda programming along with you can

pass your method, our business logic as a behavior inside a method any number of times and executed

as per your business requirement.

So now let's try to go to the code and try to see this in the program as well.

So we have a functional interface called White Matter with two parents, and it has only one method

called calculate and print.

And this method is an abstract method now and go to the class lambda examples here.

This time I call the method wird method with two patterns.

I'll keep it breakpoint here.

As you can see here, I am trying to create an object reference of this interface with the name addition

and I'm taking these two input parameters.

I am not return method, name, public void and even I didn't mention in the year come into B also straight

straightaway mentioning it cannot be.

So now you can see here I just return the business logic saying you just take the input, add them and

bring them.

Since this business logic has only one line in need, this calibrates are also optional.

So that's where we can remove them and we can make it even more simpler form.

And one more thing that I want you to observe is here.

It is an addition here which in that behavior to multiplication.

So addition object will perform addition and multiplication, object will perform multiplication.

You can see here the beauty of lambda in a single method.

You can provide any number of behaviors that you want and you pass them those behaviors whenever you

try to invoke the abstract method that you want to execute.

So obviously the method name will be same, but I'm trying to pass a different behavior using this object

references when I call addition that calculate and print.

It will add these two numbers and print, whereas this one will multiply and print the value.

So let's try to debug this program by putting a break point and I'm running.

Let me clear the previous console.

So now I'm just executing line by line.

We have created two lambda expression.

So this will print seven as the output and the next one will print 10 as the output.

So with this, I'm assuming you guys are super clear about this lambda expression, how to write the

existing methods into a lambda expression with the help of functional interface in the next lecture.

Let's try to look at the method which has some return type.

So all these videos that we discussed not have any return type.

We discussed about the methods which have widely.

But let's try to understand how the written statement are written.

Keever also can be avoided inside lambda expressions.

Thank you and see you in the next lecture by.




### 39. Lambda Expressions Deep Dive.md

In all the previous sections, we discussed a lot about how to write a lamda representation of an existing

method or how to write a new lambda expression based upon it given functional interface.

Now let's try to understand more about lambda expression, especially the special scenarios that we

may have.

So firstly, I just wanted to highlight lambda expressions are used heavily in their collections and

streams.

Library from Javaid Against Shrem is a new feature that got introduced in Java eight, which will discuss

a lot about in the coming sections.

But please be aware like this lambda expression is used heavily in collections and streams epper.

So it is very important to understand how lambda expressions work and how to read them.

So inside your method loggi like where you write your body of the method, whether it's in the lambda

added in the normal method, nothing is going to change.

Like the way that you catch the exceptions, the way you draw the exceptions.

Nothing is going to change like we do with the normal methods.

We follow the same standards with our same approach, with lambda expressions as well.

So since we have discussed enough details about lambda expressions, I would recommend you to do some

practice by taking a few scenarios, building functional interface and writing corresponding lambda

expressions for them.

So as you know, the lambda expression is whatever I looked at here, you don't have to provide method,

name, access type return by all those things.

You don't have to mention you straightaway.

Start with your brackets where you mention whatever input parameters.

If you don't have input parameters, you just keep it as empty.

And if you have only one parameter, even these brackets are optional.

Both that this Addo representation is very important to indicate that this is a lambda expression followed

by you will write a calibrates inside that you write on all your business logic inside your body.

And we also discussed if your body has only a single statement, then calibrates or else optional,

even written Keever also optional in the scenario where you have a single statement inside your method

body.

As we discuss with the help of Lambda Expressions, you can reduce the length of the code because you

can avoid a lot of boilerplate code.

Readability will be improved and also the complexity of anonymous in our classes can be avoided.

Using lambda expressions, I will cover how anonymous in that class are related to lambda expression

in the next lecture.

So please bear with me around this point for now.

And we also saw a lambda expressions can be passed in the place of object, our method of argument,

which will allow us to parse the behavior as an input like we saw in the previous examples.

We just create an object reference of an interface, but it is as to define everything.

The behavior and the behavior can change based upon whatever we define from object to object and at

last innoculate lambda expression or code.

We need definitely a function interfaces.

But don't worry, you don't have to write a lot of interface inside your code.

We have many inbuilt function interfaces provided by Java team, which can handle most of the scenarios

that you have inside your real time projects.

Next, I want to highlight a few points related to the scope of the variables.

OK, the first one is lambda expressions can use variables defined in an outer scope.

So when I say otoscope, the variables which are declared outside this lambda expressions like inside

or class inside your matter.

Like you can see here, we have written a lambda expression outside that we have in variable called

Tamsen.

So this is outside this lambda expression and we also have at the class level, which is some.

So these are all the variables.

You can still have access to those variables, but there are some restrictions or constraints on how

you should handle them.

The very first one is if you are using a local variable of a method inside a lambda blocks, you should

never change its value.

Instead, you can only leverage that because usually all this method related information are maintained

on the stack, but not on the heap.

Since it is going to be maintained on the stack.

Think of a scenario.

If we are allowing to change this value of some inside the lambda expression, then definitely you'll

get a concurrent pictures.

Since using same lambda expression, you can execute multiple parallel or concurrent execution's.

So if one lambda expression changes that value to some other value, then definitely.

It is going to create some real condition issues inside other lambda expressions, so that's why if

we have a local variable inside your meter, you can't change it inside or lambda expression to whatever

variable that you are going to use inside.

Lambda expression, it is going to be effective final.

That means you can no more change.

It are updated, but there might be static variables inside your classes.

There might be some instance variables or member variables inside the class so those variables can be

updated, are accessed because all these variables usually maintained on the heap memory, because for

every object the instance variable is going to be maintained in a separate heap memory.

And the compiler can guarantee you that Lambda will have access to these latest values always.

And one more point, but you have to remember is about that this statement.

So inside lambda expression, whenever you use this statement that will always refer to the outer class,

like in this scenario, the class is anonymous versus lambda, if you are calling this Daxam.

So this is going to refer to this variable present at the line 14, whereas you can also have the same

name inside your lambda expression also.

But whenever you use this, that sum, the lambda expression, always point to the whatever is present

in the outside of the lambda code.

So I know this is might be confusing or might be still not clear.

Let's try to go to a program and understand this in detail.

So as you can see here, I have the same program where we have an automatic operation function interface

and it has a single abstract method called perform operation.

And it has two variables A, B and return types.

And so I created a lambda expression for it with Recalibrates where I can create some variable, just

like how we have in the outside of the lambda expression.

It's not going to create any problem because whatever I declare here is applicable to this lambda expression

only.

And if I want to access this variable, then definitely since I am going to use this so there is no

confusion to that compiler.

So initially we declare it as some is equal to zero and here we are trying to bring the same value,

which will bring zero.

But when I am returning and returning this, that some variable which is assigned using A plus B.

So when I return, I'll be returning the value of the sum of two input parameters.

And when I try to print it, definitely it is going to print 10 plus 20, which is 30.

So this way the compiler can easily differentiate and you also should differentiate the local variable

inside the lambda expression and the variable with the same name, outside the lambda expression using

this keyword.

So this way it's always it is very clear to compiler by using this this statement, because whenever

it sees this statement, it novacare this variable is belongs to outside of the lambda expression.

And if someone is not using this, if the variable name is present with the same name in the lambda

expression, then there is no confusion, because when the developer is not using this, that means

it is belongs to the inside, this lambda expression.

So similarly, as I said, there is only one restriction, like if we have a method local variable like

we have here, and some if you want to change it to different value, then definitely you will get a

compilation error saying that this has to be effect final.

The reason is all matter.

Local variables we store in the bag, whereas class instance variables and whereas object instance variables

and static variables, we store them inside the heap and whenever we have data inside, keep the compiler.

We make sure that always this lambda expressions has led us to value.

So let's try to run this program.

You should get an output ten plus twenty, which is thirty but not this zero.

The reason is we are returning this Daxam and inside the lambda expression with also printing the value

of the sum which is specific to this inner circle.

So let me try to run this program.

As you can see, first printing zero followed by thirty.

So with this, I'm assuming you're very clear about it.

Just remember about the scope of the variables and whether you're referring this keyword insert lambda

expression that refers to the whatever you have outside the lambda expression, especially the instance

variables and static variables.

Thank you.

And in the next lecture, we will discuss about.

What is anonymous in a class and how it is related to Lambeck special, thank you and see you in the

next lecture by.



### 40. Anonymous Class Vs Lambda Expressions.md
Welcome back.

Now, in this lecture, let's try to understand what are anonymous in their classes and how they are

related to lambda expression, because a few developers, they consider lambda expression is almost

same as anonymous in their classes.

But that's not going to be true.

I'll be telling what the difference between an anonymous donor class and the lambda expression.

So firstly, we have an interface called automatic operation, and it's a function interface because

I have written only a single abstract method inside it, even if you're not keeping this annotation.

This is still going to be treated as one interface as long as it has a single abstract matter.

So this annotation only will help you to let others know.

Don't write one more abstract interface and it will throw a compilation at it.

But still, if someone want, they can delete this and they can add another abstract method.

But that will result in compilation error in all the places where we have written lambda programming

using this interface, because there is an ambiguity for the compiler to consider which method.

Otherwise, it's not going to work because whatever we have written inside the lambda expression, that

is completely anonymous matter.

Now we have an interface.

Let's try to go to the implementation that we have written.

So here in this implementation, I have written two implementations, one using in our class, which

is anonymous in a class another way using lambda.

So firstly you can see here, this is the anonymous donor class that we can see that we can see.

So I'm able to create an object of an interface using new operator because I'm parsing the behavior

without initializing a class.

That means I have not created a class with the class name.

So instead I am trying to create and execute anonymously by passing the code, whatever I have now,

as you can see here.

So this is the common behavior between Anonymous in our classes and the lambda expressions that might

be confusing to a few developers because you can pass the behavior while creating the object itself.

But there is a clear separation or difference between anonymous donor class and lambda expression will

come to that in some time.

So now I have an object without creating a class with a class name inside it so I can directly invoke

this single method that I have by calling that and what logic I have written here that will be executer.

So plus six, you can expect the output can be 16, whereas for lambda expression, in order to create

an object for that particular interface Artomatic operation, you can pass a behavior like I was showing

here, since it has two parameters.

Maybe you don't have to mention this intent and you don't have to mention all this value.

And at the same time, since it's going to be a single statement written also optional, you can see

with three lines, I have built three different behaviors.

One is some multiplication and the subtraction.

If you want to add to the same with the anonymous inner class, you will ended up writing at least 15

lines of code.

So that's a major difference.

And one more thing, anonymous in the class, didn't expect you to provide all the details like method

name.

What is a written to what is the access to everything which is again, boilerplate code that lambda

expression is trying to avoid.

But one advantage that we have with Anonymous in our class is it will work even if the interface has

more than one abstract method.

Like I can define one more abstract method here and remove this function interface and I can create

an anonymous inner class and I can define the one more method with the same method name that I have

created there and provide the business logic so I can provide any number of whatever methods inside

my anonymous inner class.

And since as long as I'm implementing the logic of them, my anonymous inner class will not complain.

But lambda expression has a limitation.

You should definitely have only a single abstract method inside your function interface at a normal

interface then only it can do all this magic of passing the behavior without the need of mentioning

this method.

Name all of those things.

So I hope this makes sense to you.

Let me try to run this program by putting a break point.

As you can expect.

You can get the output, which is sixteen then plus six.

Next, we have declared three behavior, some multiplication and subtraction.

So the same will get as an output in the console.

So don't get confused with amendments in a class and lambda expression.

The only similarity between them is you can pass the behavior while creating the object of them anonymously,

like an.

Anonymous donor class.

You don't have to create the class name, similarly, when we are dealing with the lambda expressions,

you don't have to create a method and you don't have to provide any method names or all other details

to it.

So now we have to understand what is the difference between an anonymous donor class and lambda expression.

Let's try to recap the differences between them one more time.

The very first differences, as we know, that's an anonymous donor class.

So a class without a name, whereas lambda expression is a matter, it's an anonymous method without

meaning.

So there is a clear difference.

And anonymous class is specific to a class.

Lambda expression is specific to a matter.

And one more difference that we discussed is an anonymous class can implement the interface with any

number of abstract methods inside them.

So as long as you overwrite them inside the behavior logic that you're passing, the anonymous class

will not complain that will and it will still work.

Whereas with the lambda expression, definitely your function interface should have only one abstract

matter with two abstract meant there are three lambda expression is not going to work because there

we have it.

Anonymous method concept and next one is anonymous.

Classes can be instantiated and can extend abstract and concrete classes.

You can create instantiation of it using anonymous classes by providing behavior for all the abstract

methods and similarly for concrete class.

Also, you can provide by writing your own logic, whereas lambda expressions can't be instantiated

and can't extend abstract and concrete classes.

The reason is there might be a problem that as long as you have more than one abstract method inside

these abstract and concrete classes, then definitely it is going to create a confusion to compiler.

That's why it is not alone.

And inside anonymous classes we can create instance variables.

And this inside always refers to the current inner class.

Like we discussed in the lambda expressions inside the lambda expressions, this keyword always refers

to the outer enclosing class, whereas inside anonymous classes, this keyword always refers to the

current inner class itself.

And since anonymous classes is going to create separate, separate objects.

So definitely you can create instance variables, whereas inside lambda expressions you can create only

local variables can be created because Lambda is something method that will store inside a stack, whereas

anonymous is something which deals with the objects and store inside.

Keep memory inside.

He will be allocated on demand whenever we create an object for it in the case of an anonymous class,

whereas lambda expressions, since they are related to methods they are assigned, are allocated in

the place of metro area, which is again a permanent memory.

So please do remember when you are trying to attempt an interview.

So this might be a very hot topic to discuss.

What's the difference between anonymous class and lambda expressions?

So with this we closed all the discussion about lambda expressions.

I'm pretty sure that you are clear right now.

Don't worry, if you still have some doubts, these doubts will be cleared more when we are discussing

about functional interface in deep and streams collections.

As we passan in these lectures, definitely we are going to discuss more and more about lambda expressions

by leveraging them wherever possible.

And we also discussed all the possible coding exercises inside these lectures.

So you already have that core inside the GitHub repositories, which I'll be sharing in the summary

section of.

So please go ahead and look at them, understand them, try to do some changes on your wall based upon

your current project scenarios, which can help you in standing about lambda expression in detail.

So with this we are done with lambda expressions.

I am very happy that I shared all the knowledge that I have with you guys.

And you guys are ready right now to understand and read the lambda expressions that anyone.

Right.

And you are also capable of writing lambda expressions right now inside your code.

So next section, we are going to start to debate about the French interface.

Thank you.

And see you in the next lecture by.




### Quiz 4: Java 8 Lambda expressions quiz