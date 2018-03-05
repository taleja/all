package main.service;

import java.util.List;

import main.entities.Recording;

public interface IRecordingService {

	Recording getRecordingById(long id);

	List<Recording> getRecordings();

	boolean addRecording(Recording recording);

	void updateRecording(Recording recording);

	void deleteRecording(Recording recording);

}
