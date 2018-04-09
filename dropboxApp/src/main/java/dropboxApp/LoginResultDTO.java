package dropboxApp;

public class LoginResultDTO {
	
	private LoginStatus status;
	private Long userId;
	private Boolean isDropboxConnected;
	
	public LoginResultDTO(LoginStatus status, Long userId, Boolean isDropboxConnected) {
		this.status = status;
		this.userId = userId;
		this.isDropboxConnected = isDropboxConnected;
	}
	
	public LoginStatus getStatus() {
		return status;
	}
	public void setStatus(LoginStatus status) {
		this.status = status;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public boolean isDropboxConnected() {
		return isDropboxConnected;
	}

	public void setDropboxConnected(boolean isDropboxConnected) {
		this.isDropboxConnected = isDropboxConnected;
	}
		
}
