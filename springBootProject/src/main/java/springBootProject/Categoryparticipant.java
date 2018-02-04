package springBootProject;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "categoryparticipant")
@NamedQueries({
		@NamedQuery(name = "Categoryparticipant.getCategoriesOfParticipant", query = "SELECT cp.category from Categoryparticipant cp where cp.participant.participantid= :participantid") })
public class Categoryparticipant implements Serializable {
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	protected CategoryparticipantPK categoryparticipantPK;
	@Basic(optional = false)
	@Column(name = "CreationDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;
	@JoinColumn(name = "ParticipantId", referencedColumnName = "ParticipantId", insertable = false, updatable = false)
	@ManyToOne(optional = false)
	private Participant participant;
	@JoinColumn(name = "CategoryId", referencedColumnName = "CategoryId", insertable = false, updatable = false)
	@ManyToOne(optional = false)
	private Category category;

	public Categoryparticipant() {
	}

	public Categoryparticipant(CategoryparticipantPK categoryparticipantPK) {
		this.categoryparticipantPK = categoryparticipantPK;
	}

	public Categoryparticipant(CategoryparticipantPK categoryparticipantPK, Date creationDate) {
		this.categoryparticipantPK = categoryparticipantPK;
		this.creationDate = creationDate;
	}

	public Categoryparticipant(int categoryId, int participantId) {
		this.categoryparticipantPK = new CategoryparticipantPK(categoryId, participantId);
	}

	public CategoryparticipantPK getCategoryparticipantPK() {
		return categoryparticipantPK;
	}

	public void setCategoryparticipantPK(CategoryparticipantPK categoryparticipantPK) {
		this.categoryparticipantPK = categoryparticipantPK;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Participant getParticipant() {
		return participant;
	}

	public void setParticipant(Participant participant) {
		this.participant = participant;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (categoryparticipantPK != null ? categoryparticipantPK.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Categoryparticipant)) {
			return false;
		}
		Categoryparticipant other = (Categoryparticipant) object;
		if ((this.categoryparticipantPK == null && other.categoryparticipantPK != null)
				|| (this.categoryparticipantPK != null
						&& !this.categoryparticipantPK.equals(other.categoryparticipantPK))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.xchanging.entity.jpa.Categoryparticipant[categoryparticipantPK=" + categoryparticipantPK + "]";
	}
}