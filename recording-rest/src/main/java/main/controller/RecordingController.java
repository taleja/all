package main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import main.entities.Recording;
import main.service.RecordingService;

@Controller
@RequestMapping("recording-rest")
public class RecordingController {
	
	@Autowired
	private RecordingService recordingService;
	
	@GetMapping("recordingByID/{id}")
	public ResponseEntity<Recording> getRecordingById(@PathVariable("id") long id){
		Recording recording = recordingService.getRecordingById(id);
		return new ResponseEntity<>(recording, HttpStatus.OK); 
	}
	
	@GetMapping("getRecordings")
	public ResponseEntity<List<Recording>> getRecordings(){
		List<Recording> recordings = recordingService.getRecordings();
		return new ResponseEntity<List<Recording>>(recordings, HttpStatus.OK); 
	}
	
	@PostMapping("recording")
	public ResponseEntity<Void> setRecording(@RequestBody Recording recording, UriComponentsBuilder builder){
		boolean isExist = recordingService.addRecording(recording);
		if(!isExist) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("recordingByID/{id}").buildAndExpand(recording.getRecording_id()).toUri());  
		return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
	}
	
	@PutMapping("recording")
	public ResponseEntity<Recording> updateRecording(@RequestBody Recording recording){
		recordingService.updateRecording(recording);
		return new ResponseEntity<Recording>(recording, HttpStatus.OK); 
	}
	
	@DeleteMapping("recording/{id}")
	public ResponseEntity<Void> deleteRecording(@PathVariable("id") long id){
		recordingService.deleteRecording(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	

}
