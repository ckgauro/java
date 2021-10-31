import akka.actor.typed.ActorSystem;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starts-------");
        ActorSystem<String> actorSystem=ActorSystem.create(FirstSimpleBehavior.create(),"FirstActorsSystem");
        actorSystem.tell("Hello are you there?");
        actorSystem.tell("This is the second message.");
        System.out.println("Ends-------");
    }
}
