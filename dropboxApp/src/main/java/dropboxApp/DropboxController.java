package dropboxApp;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.apache.commons.io.IOUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@Transactional
public class DropboxController {
	
	@Value("${app.key}")
	private String appKey;
	
	@Value("${app.secret}")
	private String appSecret;
	
	@Value("${redirect.uri}")
	private String redirectURI;
	
	@Autowired
	private EntityManager entityManager; 
	
	@Autowired
	private UserTokenDAO userTokenDAO;
	
	@Autowired
	private UserDAO userDao;
	
	@RequestMapping(value =  "/connect/user/{userId}", method = RequestMethod.GET)
	public void redirect(HttpServletResponse response, @PathVariable("userId") Long userId) {		
		//String url = "https://www.dropbox.com/1/oauth2/authorize?client_id=<app key>&response_type=code&redirect_uri=<redirect URI>&state=<CSRF token>";
		UserToken userToken =  new UserToken();
		userToken.setUserId(userId); 
		entityManager.persist(userToken); 
		
		StringBuilder builder = new StringBuilder();
		builder.append("https://www.dropbox.com/oauth2/authorize")
				.append("?")
				.append("client_id")
				.append("=")
				.append(this.appKey)
				.append("&")
				.append("response_type=code")
				.append("&")
				.append("redirect_uri")
				.append("=")
				.append(this.redirectURI)
				.append("&")
				.append("state")
				.append("=")
				.append(userToken.getId());
		
		response.setHeader("Location", builder.toString());
		response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY); 
	}
	
	@RequestMapping(value = "/connect/complete", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public String connectComplete(@RequestParam("state") String state, @RequestParam("code") String code) 
			throws IOException {
		
		/*HttpHost target = new HttpHost("api.dropbox.com", 443, Protocol.getProtocol("https"));
        CredentialsProvider credsProvider = new BasicCredentialsProvider();
        credsProvider.setCredentials(new AuthScope(target.getHostName(), target.getPort()),
                					new UsernamePasswordCredentials(this.appKey, this.appSecret));*/
        CloseableHttpClient httpclient = HttpClients.createDefault();
        
        HttpPost httpPostRequest = new HttpPost("https://api.dropboxapi.com/oauth2/token");
        
        httpPostRequest.addHeader("Authorization", "Basic " + buildBasicAuthCredentials());
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("code", code));
        params.add(new BasicNameValuePair("grant_type", "authorization_code"));
        params.add(new BasicNameValuePair("redirect_uri", this.redirectURI));
        httpPostRequest.setEntity(new UrlEncodedFormEntity(params));
        
        CloseableHttpResponse response = httpclient.execute(httpPostRequest);  
        String responseString = IOUtils.toString(response.getEntity().getContent());
        
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> responseMap = mapper.readValue(responseString, Map.class);
        
        String token = responseMap.get("access_token");
        UserToken userToken = entityManager.find(UserToken.class, Long.parseLong(state), LockModeType.PESSIMISTIC_WRITE);
        userToken.setToken(token);
        entityManager.flush();
        
        System.out.println(responseString);
        httpclient.close();
        
        String template = IOUtils.toString(this.getClass().getClassLoader().getResourceAsStream("public/success.html"));
        User user = userDao.getUserById(userToken.getUserId());
        return template.replaceAll("%USER%", user.getLogin()).replaceAll("%USER_ID%", user.getId().toString()); 
	}
	
	@RequestMapping(value = "/folders/user/{userId}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String getDropboxAllFolders(@PathVariable("userId")Long userId) throws ClientProtocolException, IOException {
		UserToken userToken = userTokenDAO.findUserTokenByUserId(userId).get();
		System.out.println(userToken.getId()); 
		
		HttpPost httpPost = new HttpPost("https://api.dropbox.com/2/files/list_folder");
		httpPost.setHeader("Authorization", "Bearer " + userToken.getToken());
		
	    String json = "{\r\n" + 
	    		"    \"path\": \"\",\r\n" + 
	    		"    \"recursive\": false,\r\n" + 
	    		"    \"include_media_info\": false,\r\n" + 
	    		"    \"include_deleted\": false,\r\n" + 
	    		"    \"include_has_explicit_shared_members\": false,\r\n" + 
	    		"    \"include_mounted_folders\": true\r\n" +  
	    		"}";
	    StringEntity entity = new StringEntity(json);
	    httpPost.setEntity(entity);
	    //httpPost.setHeader("Accept", "application/json");
	    httpPost.setHeader("Content-type", "application/json");
	    
	    CloseableHttpResponse response = HttpClients.createDefault().execute(httpPost); 
	    return IOUtils.toString(response.getEntity().getContent());
	}

	private String buildBasicAuthCredentials() {
		byte[] base64Based = (this.appKey + ":" + this.appSecret).getBytes(Charset.forName("UTF-8"));
        String userPasswordBase64 = Base64.getEncoder().encodeToString(base64Based);
		return userPasswordBase64;
	}
}
