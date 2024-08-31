package projects.wsn2.nodes.nodeImplementations;

import projects.wsn2.nodes.messages.DataMessage;
import projects.wsn2.nodes.messages.RouteMessage;
import sinalgo.nodes.Node;
import sinalgo.nodes.edges.Edge;
import sinalgo.nodes.messages.Inbox;
import sinalgo.nodes.messages.Message;
import sinalgo.nodes.timers.Timer;

public class NoSensor extends Node {

    private Node nextHopToSink = null;

    @Override
    public void handleMessages(Inbox inbox) {
        while (inbox.hasNext()) {
            Message msg = inbox.next();
            if (msg instanceof RouteMessage) {
                nextHopToSink = inbox.getSender();
                System.out.println("Sensor " + this.ID + " recebeu rota de " + nextHopToSink.ID);
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
    	new SensorDataTimer().startRelative(1, this);
    }

    @Override
    public void postStep() {
		// TODO Auto-generated method stub    
    	}

    @Override
    public void neighborhoodChange() {
		// TODO Auto-generated method stub
    }

    @Override
    public void checkRequirements() {
		// TODO Auto-generated method stub
    }

    private class SensorDataTimer extends Timer {
        @Override
        public void fire() {
            if (nextHopToSink != null) {

                DataMessage dMsg = new DataMessage("Dados do Sensor " + ID);
                send(dMsg, nextHopToSink);
            }

            this.startRelative(1, NoSensor.this);
        }
    }
}