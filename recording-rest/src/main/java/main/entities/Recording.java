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
@Table(name = "recording")
public class Recording implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "recording_id")
	private long recording_id;
	@Column(name = "name")
	private String name;

	@OneToMany
	@JoinTable(name = "recording_source", joinColumns = @JoinColumn(name = "recording_id"), inverseJoinColumns = @JoinColumn(name = "source_id"))
	private List<Source> source;
	@OneToMany
	@JoinTable(name = "recording_channelPool", joinColumns = @JoinColumn(name = "recording_id"), inverseJoinColumns = @JoinColumn(name = "channel_pool_id"))
	private List<ChannelPool> channelPools;


	public long getRecording_id() {
		return recording_id;
	}

	public void setRecording_id(long recording_id) {
		this.recording_id = recording_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Source> getSource() {
		return source;
	}

	public void setSource(List<Source> source) {
		this.source = source;
	}

	public List<ChannelPool> getChannelPools() {
		return channelPools;
	}

	public void setChannelPools(List<ChannelPool> channelPools) {
		this.channelPools = channelPools;
	}	
}
