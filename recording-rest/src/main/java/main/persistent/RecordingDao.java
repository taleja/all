package main.persistent;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import main.entities.Recording;

@Repository
@Transactional
public class RecordingDao implements IRecordingDao{

	@PersistenceContext
	EntityManager entityManager;
	
	public Recording getRecordingById(long id) {
		return entityManager.find(Recording.class, id, LockModeType.PESSIMISTIC_WRITE);
	}

	@SuppressWarnings("unchecked")
	public List<Recording> getRecordings() {
		String hql = "From Recording as rec Order By rec.recording_id";
		return (List<Recording>) entityManager.createQuery(hql).getResultList();
	}

	public void addRecording(Recording recording) { 
		entityManager.persist(recording);
	}

	public void updateRecording(Recording recording) { 
		Recording recordingFromDB = getRecordingById(recording.getRecording_id());
		recordingFromDB.setName(recording.getName());
		recordingFromDB.setChannelPools(recording.getChannelPools());
		recordingFromDB.setSource(recording.getSource()); 
		entityManager.merge(recordingFromDB); 
	}

	public void delete(Recording recording) { 
		entityManager.remove(recording);
	}
	
	public boolean isExist(Recording recording) {
		String hql = "From Recording as rec WHERE rec.recording_id = ?";
		int count = entityManager.createQuery(hql).setParameter(1, recording.getRecording_id()).getResultList().size();
		return count > 0 ? true : false;
	}
}
