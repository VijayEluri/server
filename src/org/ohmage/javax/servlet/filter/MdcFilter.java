/*******************************************************************************
 * Copyright 2012 The Regents of the University of California
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package org.ohmage.javax.servlet.filter;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.MDC;

/**
 * Filter that creates a unique id for all requests and pushes that id onto
 * a Logger's stack. This way we have a way to track individual requests
 * in our logs.
 * 
 * @author Joshua Selsky
 */
public class MdcFilter implements Filter {
	/**
	 * The attribute key for the request ID.
	 */
    public static final String MDC_CONTEXT_REQUEST_ID = "request_id";

	/**
	 * Default no-arg constructor.
	 */
	public MdcFilter() {
		
	}
	
	/**
	 * Does nothing.
	 */
	public void destroy() {
		
	}
	
	/**
	 * Does nothing.
	 */
	public void init(FilterConfig config) throws ServletException {
		
	}
	
	/**
	 * Pushes a UUID into the Log4J NDC for request tracking and debugging.
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
		throws ServletException, IOException {	
		
		String requestId = UUID.randomUUID().toString();

		MDC.put(MDC_CONTEXT_REQUEST_ID, requestId);
		
		// Execute the rest of the filters in the chain and then whatever Servlet is bound to the current request URI
		chain.doFilter(request, response);
		
		// cleanup -- remove the NDC for the current thread
		MDC.remove(MDC_CONTEXT_REQUEST_ID);
	}
}
