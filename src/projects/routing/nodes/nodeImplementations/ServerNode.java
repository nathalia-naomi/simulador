package projects.routing.nodes.nodeImplementations;

import projects.routing.nodes.messages.WsnMessage;
import sinalgo.nodes.Node;
import sinalgo.nodes.messages.Inbox;

public class ServerNode extends Node {

    private Node sinkNode;

    @Override
    public void handleMessages(Inbox inbox) {
        while (inbox.hasNext()) {
            WsnMessage msg = (WsnMessage) inbox.next();

            if (msg.type == WsnMessage.Type.ROUTE) {
                sinkNode = inbox.getSender();
            }
        }
    }

    @Override
    public void preStep() {
        if (sinkNode != null) {
            WsnMessage dataMsg = new WsnMessage();
            dataMsg.type = WsnMessage.Type.DATA;
            send(dataMsg, sinkNode);
        }
    }

    @Override
    public void init() {}

    @Override
    public void postStep() {}

    @Override
    public void neighborhoodChange() {}

    @Override
    public void checkRequirements() {}

}
