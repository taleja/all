package main.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "destination")
public class Destination implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name  = "destination_id")
	private long destination_Id;
	@Column(name = "name")
	private String name;
	@Column(name =  "index")
	private int index;	
	@OneToMany(mappedBy = "destination")
	private List<Channel> channels;
	@ManyToOne
	private Device device;

	public long getDestination_Id() {
		return destination_Id;
	}

	public void setDestination_Id(long destination_Id) {
		this.destination_Id = destination_Id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public List<Channel> getChannels() {
		return channels;
	}

	public void setChannels(List<Channel> channels) {
		this.channels = channels;
	}
}
