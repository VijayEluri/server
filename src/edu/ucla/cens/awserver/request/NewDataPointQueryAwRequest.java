package edu.ucla.cens.awserver.request;

import java.util.List;

import edu.ucla.cens.awserver.domain.Configuration;

/**
 * State for "new" data point API queries.
 * 
 * @author selsky
 */
public class NewDataPointQueryAwRequest extends ResultListAwRequest {
	private String _startDate;
	private String _endDate;
	private String _currentUser;
	private String _client;
	private String _campaignName;
	private String _campaignVersion;
	
	private String _userListString;
	private List<String> _userList;
	
	private String _promptIdListString;
	private List<String> _promptIdList;
	
	private String _surveyIdListString;
	private List<String> _surveyIdList;
	
	private String _columnListString;
	private List<String> _columnList;

	private Configuration _configuration;
	
	// private String _authToken; see userToken in parent class

	public Configuration getConfiguration() {
		return _configuration;
	}

	public void setConfiguration(Configuration configuration) {
		_configuration = configuration;
	}
	
	public String getCurrentUser() {
		return _currentUser;
	}
	
	public void setCurrentUser(String currentUser) {
		_currentUser = currentUser;
	}
	
	public String getStartDate() {
		return _startDate;
	}
	
	public void setStartDate(String startDate) {
		_startDate = startDate;
	}
	
	public String getEndDate() {
		return _endDate;
	}
	
	public void setEndDate(String endDate) {
		_endDate = endDate;
	}
	
	public String getClient() {
		return _client;
	}

	public void setClient(String client) {
		_client = client;
	}

	public String getCampaignName() {
		return _campaignName;
	}

	public void setCampaignName(String campaignName) {
		_campaignName = campaignName;
	}

	public String getCampaignVersion() {
		return _campaignVersion;
	}

	public void setCampaignVersion(String campaignVersion) {
		_campaignVersion = campaignVersion;
	}
	
	public String getUserListString() {
		return _userListString;
	}

	public void setUserListString(String userListString) {
		_userListString = userListString;
	}

	public List<String> getUserList() {
		return _userList;
	}

	public void setUserList(List<String> userList) {
		_userList = userList;
	}

	public String getPromptIdListString() {
		return _promptIdListString;
	}

	public void setPromptIdListString(String promptIdListString) {
		_promptIdListString = promptIdListString;
	}

	public List<String> getPromptIdList() {
		return _promptIdList;
	}

	public void setPromptIdList(List<String> promptIdList) {
		_promptIdList = promptIdList;
	}

	public String getSurveyIdListString() {
		return _surveyIdListString;
	}

	public void setSurveyIdListString(String surveyIdListString) {
		_surveyIdListString = surveyIdListString;
	}

	public List<String> getSurveyIdList() {
		return _surveyIdList;
	}

	public void setSurveyIdList(List<String> surveyIdList) {
		_surveyIdList = surveyIdList;
	}

	public String getColumnListString() {
		return _columnListString;
	}

	public void setColumnListString(String columnListString) {
		_columnListString = columnListString;
	}

	public List<String> getColumnList() {
		return _columnList;
	}

	public void setColumnList(List<String> columnList) {
		_columnList = columnList;
	}
}