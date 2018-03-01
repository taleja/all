package main.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "channel_pool")
public class ChannelPool implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "channel_pool_id")
	private long channelPool_Id;
	@Column(name = "name")
	private String name;	
	@OneToMany
	@JoinTable(name = "recording_channelPool", joinColumns = @JoinColumn(name = "channel_pool_id"), inverseJoinColumns = @JoinColumn(name = "recording_id"))
	private List<Recording> recordings;
	@OneToMany(mappedBy = "channelPool")
	private List<Channel> channels;

	public long getChannelPool_Id() {
		return channelPool_Id;
	}

	public void setChannelPool_Id(long channelPool_Id) {
		this.channelPool_Id = channelPool_Id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Recording> getRecordings() {
		return recordings;
	}

	public void setRecordings(List<Recording> recordings) {
		this.recordings = recordings;
	}	
}
