package main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.entities.Recording;
import main.persistent.RecordingDao;

@Service
public class RecordingService implements IRecordingService {

	@Autowired
	private RecordingDao recordingDAO;

	public Recording getRecordingById(long id) {
		Recording recording = recordingDAO.getRecordingById(id);
		return recording;
	}

	public List<Recording> getRecordings() {
		return recordingDAO.getRecordings();
	}

	public boolean addRecording(Recording recording) {
		if (!recordingDAO.isExist(recording)) {
			recordingDAO.addRecording(recording);
			return true;
		}
		return false;
	}

	public void updateRecording(Recording recording) {
		recordingDAO.updateRecording(recording);
	}

	public void deleteRecording(Recording recording) {
		recordingDAO.delete(recording);
	}
}
