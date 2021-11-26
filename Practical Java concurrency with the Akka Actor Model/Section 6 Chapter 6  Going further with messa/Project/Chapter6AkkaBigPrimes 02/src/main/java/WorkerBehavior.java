import akka.actor.typed.ActorRef;
import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.AbstractBehavior;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.Behaviors;
import akka.actor.typed.javadsl.Receive;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Random;

public class WorkerBehavior  extends AbstractBehavior<WorkerBehavior.Command> {
    private BigInteger prime;
    public static class Command implements Serializable {
        private static final long serialVersionId =1L;
        private String message;
        private ActorRef<ManagerBehavior.Command> sender;

        public Command(String message, ActorRef<ManagerBehavior.Command> sender) {
            this.message = message;
            this.sender = sender;
        }

        public String getMessage() {
            return message;
        }

        public ActorRef<ManagerBehavior.Command> getSender() {
            return sender;
        }
    }
    private WorkerBehavior(ActorContext<Command> context) {
        super(context);
    }

    public static Behavior<Command> create(){
        return Behaviors.setup(WorkerBehavior::new);
    }

    @Override
    public Receive<Command> createReceive() {
        return newReceiveBuilder()
                .onAnyMessage(command->{
                    if(command.getMessage().equals("start")){
                        BigInteger bigInteger=new BigInteger(2000, new Random());

                        //command.getSender().tell(bigInteger.toString());
                        prime=bigInteger.nextProbablePrime();
                        Thread.sleep(2000);
                       // System.out.println(prime);
                        command.getSender().tell(new ManagerBehavior.ResultCommand(prime) {
                        });
                    }
                    return this;
                })

                .build();
    }


}
