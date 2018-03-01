package main.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "channel")
public class Channel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	@Column(name = "channel_id")
	private long channel_id;
	@Column(name = "name")
	private String name;
	@ManyToOne
	private ChannelPool channelPool;
	@ManyToOne
	private Destination destination;

	public long getChannel_id() {
		return channel_id;
	}

	public void setChannel_id(long channel_id) {
		this.channel_id = channel_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ChannelPool getChannelPool() {
		return channelPool;
	}

	public void setChannelPool(ChannelPool channelPool) {
		this.channelPool = channelPool;
	}
}
