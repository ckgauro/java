import akka.actor.typed.ActorRef;
import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.AbstractBehavior;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.Behaviors;
import akka.actor.typed.javadsl.Receive;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class ManagerBehavior extends AbstractBehavior<ManagerBehavior.Command> {
    private SortedSet<BigInteger> primes=new TreeSet<>();
    public interface Command  extends Serializable { }


    public static class InstructionCommand implements Command{
        public static final long serialVersionId=1L;
        private String message;

        public InstructionCommand(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
    public static class ResultCommand implements Command{
        public  static final long serialVersionUID=1l;
        private BigInteger prime;

        public ResultCommand(BigInteger prime) {
            this.prime = prime;
        }

        public BigInteger getPrime() {
            return prime;
        }
    }
    public ManagerBehavior(ActorContext<Command> context) {
        super(context);
    }

    public static Behavior<Command> create() {
        return Behaviors.setup(ManagerBehavior::new);
    }

    @Override
    public Receive<Command> createReceive() {
        return newReceiveBuilder()
                .onMessage(InstructionCommand.class, command->{
                    if(command.getMessage().equals("start")){
                        IntStream.rangeClosed(0,19).forEach(i->{
                            ActorRef<WorkerBehavior.Command> worker= getContext().spawn(WorkerBehavior.create(),"worker"+i);
                            worker.tell(new WorkerBehavior.Command("start", getContext().getSelf()));
                            worker.tell(new WorkerBehavior.Command("start", getContext().getSelf()));

                        });
                    }
                    return  this;
                })
                .onMessage(ResultCommand.class, command->{
                    primes.add(command.getPrime());
                    System.out.println("I have received :"+primes.size()+ " prime numbers ");
                    if(primes.size()==20){
                        primes.forEach(System.out::println);
                    }
                    return this;
                })
                .build();
    }


}
