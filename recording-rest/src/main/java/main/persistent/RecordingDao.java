package main.persistent;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import main.entities.Recording;

@Repository
@Transactional
public class RecordingDao implements IRecordingDao{

	public Recording getRecordingById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Recording> getRecordings() {
		// TODO Auto-generated method stub
		return null;
	}

	public void addRecording(Recording recording) { 
		// TODO Auto-generated method stub
		
	}

	public boolean isExist(Recording recording) {
		// TODO Auto-generated method stub 
		return false;
	}

	public void updateRecording(Recording recording) { 
		// TODO Auto-generated method stub
		
	}

	public void delete(long recordingId) {
		// TODO Auto-generated method stub 
		
	}
}
