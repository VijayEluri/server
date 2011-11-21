package org.ohmage.query;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.ohmage.domain.campaign.Campaign;
import org.ohmage.domain.campaign.SurveyResponse;
import org.ohmage.exception.DataAccessException;

public interface ISurveyResponseQueries {

	/**
	 * Retrieves the survey response ID for all of the survey responses made in
	 * a given campaign.
	 * 
	 * @param campaignId The campaign's unique identifier.
	 * 
	 * @return A, possibly empty but never null, list of survey response unique
	 * 		   identifiers.
	 * 
	 * @throws DataAccessException Thrown if there is an error.
	 */
	List<Long> retrieveSurveyResponseIdsFromCampaign(final String campaignId)
			throws DataAccessException;

	/**
	 * Retrieves the survey response ID for all of the survey responses made by
	 * a given user in a given campaign.
	 * 
	 * @param campaignId The campaign's unique identifier.
	 * 
	 * @param username The user's username.
	 * 
	 * @return A, possibly empty but never null, list of survey response unique
	 * 		   identifiers.
	 * 
	 * @throws DataAccessException Thrown if there is an error.
	 */
	List<Long> retrieveSurveyResponseIdsFromUser(final String campaignId,
			final String username) throws DataAccessException;

	/**
	 * Retrieves the survey response ID for all of the survey responses made by
	 * a given client in a given campaign.
	 * 
	 * @param campaignId The campaign's unique identifier.
	 * 
	 * @param client The client value.
	 * 
	 * @return A, possibly empty but never null, list of survey response unique
	 * 		   identifiers.
	 * 
	 * @throws DataAccessException Thrown if there is an error.
	 */
	List<Long> retrieveSurveyResponseIdsWithClient(final String campaignId,
			final String client) throws DataAccessException;

	/**
	 * Retrieves the survey response ID for all of the survey responses made on
	 * or after a given date in a given campaign.
	 * 
	 * @param campaignId The campaign's unique identifier.
	 * 
	 * @param startDate The date.
	 * 
	 * @return A, possibly empty but never null, list of survey response unique
	 * 		   identifiers.
	 * 
	 * @throws DataAccessException Thrown if there is an error.
	 */
	List<Long> retrieveSurveyResponseIdsAfterDate(final String campaignId,
			final Date startDate) throws DataAccessException;

	/**
	 * Retrieves the survey response ID for all of the survey responses made on
	 * or before a given date in a given campaign.
	 * 
	 * @param campaignId The campaign's unique identifier.
	 * 
	 * @param endDate The date.
	 * 
	 * @return A, possibly empty but never null, list of survey response unique
	 * 		   identifiers.
	 * 
	 * @throws DataAccessException Thrown if there is an error.
	 */
	List<Long> retrieveSurveyResponseIdsBeforeDate(final String campaignId,
			final Date endDate) throws DataAccessException;

	/**
	 * Retrieves the survey response ID for all of the survey responses with a
	 * given privacy state in a given campaign.
	 * 
	 * @param campaignId The campaign's unique identifier.
	 * 
	 * @param privacyState The privacy state.
	 * 
	 * @return A, possibly empty but never null, list of survey response unique
	 * 		   identifiers.
	 * 
	 * @throws DataAccessException Thrown if there is an error.
	 */
	List<Long> retrieveSurveyResponseIdsWithPrivacyState(
			final String campaignId,
			final SurveyResponse.PrivacyState privacyState)
			throws DataAccessException;

	/**
	 * Retrieves the survey response ID for all of the survey responses with a
	 * given survey ID in a given campaign.
	 * 
	 * @param campaignId The campaign's unique identifier.
	 * 
	 * @param surveyId The survey's unique identifier.
	 * 
	 * @return A, possibly empty but never null, list of survey response unique
	 * 		   identifiers.
	 * 
	 * @throws DataAccessException Thrown if there is an error.
	 */
	List<Long> retrieveSurveyResponseIdsWithSurveyId(final String campaignId,
			final String surveyId) throws DataAccessException;

	/**
	 * Retrieves the survey response ID for all of the survey responses with a
	 * given prompt ID in a given campaign.
	 * 
	 * @param campaignId The campaign's unique identifier.
	 * 
	 * @param promptId The prompt's unique identifier.
	 * 
	 * @return A, possibly empty but never null, list of survey response unique
	 * 		   identifiers.
	 * 
	 * @throws DataAccessException Thrown if there is an error.
	 */
	List<Long> retrieveSurveyResponseIdsWithPromptId(final String campaignId,
			final String promptId) throws DataAccessException;

	/**
	 * Retrieves the survey response ID for all of the survey responses with a
	 * given prompt type in a given campaign.
	 * 
	 * @param campaignId The campaign's unique identifier.
	 * 
	 * @param promptType The prompt's type.
	 * 
	 * @return A, possibly empty but never null, list of survey response unique
	 * 		   identifiers.
	 * 
	 * @throws DataAccessException Thrown if there is an error.
	 */
	List<Long> retrieveSurveyResponseIdsWithPromptType(final String campaignId,
			final String promptType) throws DataAccessException;

	/**
	 * Retrieves the information about a survey response including all of the
	 * individual prompt responses.
	 * 
	 * @param campaign The campaign that contains all of the surveys.
	 * 
	 * @param surveyResponseId The survey response's unique identifier.
	 * 
	 * @return A SurveyResponseInformation object.
	 * 
	 * @throws DataAccessException Thrown if there is an error. This may be due
	 * 							   to a problem with the database or an issue
	 * 							   with the content in the database not being
	 * 							   understood by the SurveyResponseInformation
	 * 							   constructor.
	 */
	SurveyResponse retrieveSurveyResponseFromId(final Campaign campaign,
			final Long surveyResponseId) throws DataAccessException;

	/**
	 * Retrieves the information about a list of survey responses including all
	 * of their individual prompt responses.
	 * 
	 * @param campaign The campaign that contains all of the surveys.
	 * 
	 * @param surveyResponseIds A collection of unique identifiers for survey
	 * 							responses whose information is being queried.
	 * 
	 * @return A list of SurveyResponseInformation objects each relating to a
	 * 		   survey response ID.
	 * 
	 * @throws DataAccessException Thrown if there is an error.
	 */
	List<SurveyResponse> retrieveSurveyResponseFromIds(final Campaign campaign,
			final Collection<Long> surveyResponseIds)
			throws DataAccessException;

	/**
	 * Updates the privacy state on a survey response.
	 * 
	 * @param surveyResponseId The survey response's unique identifier.
	 * @param privacyState The survey's new privacy state
	 * 
	 * @throws DataAccessException Thrown if there is an error.
	 */
	void updateSurveyResponsePrivacyState(Long surveyResponseId,
			SurveyResponse.PrivacyState newPrivacyState)
			throws DataAccessException;

	/**
	 * Deletes a survey response.
	 * 
	 * @param surveyResponseId The survey response's unique identifier.
	 * 
	 * @throws DataAccessException Thrown if there is an error.
	 */
	void deleteSurveyResponse(Long surveyResponseId) throws DataAccessException;

}