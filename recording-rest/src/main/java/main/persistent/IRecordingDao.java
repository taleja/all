package main.persistent;

import java.util.List;

import main.entities.Recording;

public interface IRecordingDao {

	Recording getRecordingById(long id);

	List<Recording> getRecordings();

	void addRecording(Recording recording);

	boolean isExist(Recording recording);

	void updateRecording(Recording recording);

	void delete(long recordingId);

}
