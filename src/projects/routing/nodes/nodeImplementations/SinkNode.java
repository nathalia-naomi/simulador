package projects.routing.nodes.nodeImplementations;

import projects.routing.nodes.messages.WsnMessage;
import projects.routing.nodes.timers.WsnTimer;
import sinalgo.configuration.WrongConfigurationException;
import sinalgo.nodes.Node;
import sinalgo.nodes.messages.Inbox;
import sinalgo.nodes.messages.Message;

public class SinkNode extends Node {

    private Node nextNodeToBase;
    private Integer sequenceNumber = 0;

    @Override
    public void handleMessages(Inbox inbox) {
        while (inbox.hasNext()) {
            Message msg = inbox.next();
            if (msg instanceof WsnMessage) {
                Boolean forward = Boolean.TRUE;
                WsnMessage message = (WsnMessage) msg;
                if (this.equals(message.forwardingHop)) forward = Boolean.FALSE;
                else if (message.type == WsnMessage.Type.ROUTE) {
                    if (nextNodeToBase == null) {
                        nextNodeToBase = inbox.getSender();
                        sequenceNumber = message.sequenceID;
                    } else if (sequenceNumber < message.sequenceID) {
                        sequenceNumber = message.sequenceID;
                    } else forward = Boolean.FALSE;
                } else if (message.type == WsnMessage.Type.DATA) {

                }

                if (forward) {
                    System.out.println(this.ID + " received data from " + message.origin.ID);
                    message.forwardingHop = this;
                    broadcast(message);
                }
            }
        }
    }

    @NodePopupMethod(menuText = "Build Routing Tree")
    public void buildRouting() {
        this.nextNodeToBase = this;
        WsnMessage wsnMessage = new WsnMessage(1, this, null, this, WsnMessage.Type.ROUTE);
        WsnTimer timer = new WsnTimer(wsnMessage);
        timer.startRelative(1, this);
    }

    @Override
    public void preStep() {}

    @Override
    public void init() {}

    @Override
    public void neighborhoodChange() {}

    @Override
    public void postStep() {}

    @Override
    public void checkRequirements() throws WrongConfigurationException {}
}
