package gov.ncbi.maloneyc.weather.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("rss")
public class Rss {
	Double version;
	Channel channel;
	
	public Channel getChannel() {
		return channel;
	}

	public String toString(){
		return channel.title+"\n"+channel.description;
	}
}
