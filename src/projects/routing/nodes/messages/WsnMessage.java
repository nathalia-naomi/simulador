package projects.routing.nodes.messages;

import sinalgo.nodes.Node;
import sinalgo.nodes.messages.Message;

public class WsnMessage extends Message {

    public enum Type {
        ROUTE, DATA
    }

    public Integer sequenceID;
    public Node origin;
    public Node destiny;
    public Node forwardingHop;
    public Type type;
    public Integer ttl;
    public Integer hopsUntilDestiny;

    public WsnMessage() {}

    public WsnMessage(Integer sequenceID, Node origin, Node destiny, Node forwardingHop, Type type) {
        this.sequenceID = sequenceID;
        this.origin = origin;
        this.destiny = destiny;
        this.forwardingHop = forwardingHop;
        this.type = type;
    }

    @Override
    public Message clone() {
        WsnMessage message = new WsnMessage(sequenceID, origin, destiny, forwardingHop, type);
        message.ttl = ttl;
        message.hopsUntilDestiny = hopsUntilDestiny;
        return message;
    }
}
