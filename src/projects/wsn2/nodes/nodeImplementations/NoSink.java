package projects.wsn2.nodes.nodeImplementations;

import projects.wsn2.nodes.messages.DataMessage;
import projects.wsn2.nodes.messages.RouteMessage;
import sinalgo.configuration.WrongConfigurationException;
import sinalgo.nodes.Node;
import sinalgo.nodes.edges.Edge;
import sinalgo.nodes.messages.Inbox;
import sinalgo.nodes.messages.Message;
import sinalgo.nodes.timers.Timer;

public class NoSink extends Node {


	@Override
	public void handleMessages(Inbox inbox) {
		// TODO Auto-generated method stub
		while (inbox.hasNext()) {
            Message msg = inbox.next();
            if (msg instanceof DataMessage) {
                DataMessage dMsg = (DataMessage) msg;
                System.out.println("Sink recebeu dado de " + inbox.getSender().ID + ": " + dMsg.getData());
            }
        }
		
	}

	@Override
	public void preStep() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		 RouteMessage rMsg = new RouteMessage();
	     broadcast(rMsg);
		
	}

	@Override
	public void neighborhoodChange() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postStep() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checkRequirements() throws WrongConfigurationException {
		// TODO Auto-generated method stub
		
	}
}
