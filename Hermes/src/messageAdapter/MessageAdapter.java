package messageAdapter;

import controler.MainController;

public class MessageAdapter 
{
	private MessageReceiver messageReceiver;
	private MessageSender messageSender;
	
	public MessageAdapter(MainController controller)
	{
		messageReceiver = new MessageReceiver(controller);
		messageSender = new MessageSender();
	}

	public MessageReceiver getMessageReceiver() {
		return messageReceiver;
	}

	public void setMessageReceiver(MessageReceiver messageReceiver) {
		this.messageReceiver = messageReceiver;
	}

	public MessageSender getMessageSender() {
		return messageSender;
	}

	public void setMessageSender(MessageSender messageSender) {
		this.messageSender = messageSender;
	}
}
