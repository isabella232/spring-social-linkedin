/*
 * Copyright 2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.security.oauth.client.oauth2;

import org.springframework.security.oauth.client.ProtectedResourceRequest;

/**
 * A service interface for the OAuth2 flow.
 * This interface allows you to conduct the "OAuth dance" with a service provider on behalf of a user. 
 * @author Keith Donald
 */
public interface OAuth2Operations {

	/**
	 * Construct the URL to redirect the user to for connection authorization.
	 * @param redirectUri the authorization callback url; this value must match the redirectUri registered with the provider
	 */ 
	String buildAuthorizeUrl(String redirectUri, String scope);

	/**
	 * Exchange the authorization grant for access.
	 * @param authorizationGrant the authorization code returned by the provider upon user authorization
	 * @param redirectUri the authorization callback url; this value must match the redirectUri registered with the provider
	 */
	AccessCredentials exchangeForAccess(String authorizationGrant, String redirectUri);

	/**
	 * Sign the client http request with OAuth credentials.
	 * To be called before the request is executed.
	 * @param request the client http request
	 * @param accessToken the access token value
	 */
	void sign(ProtectedResourceRequest request, String accessToken);

}
