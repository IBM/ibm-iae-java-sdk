/*
 * (C) Copyright IBM Corp. 2021.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package com.ibm.cloud.iaesdk.ibm_analytics_engine_v3_api.v3;

import com.ibm.cloud.iaesdk.ibm_analytics_engine_v3_api.v3.model.ApplicationCollection;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_v3_api.v3.model.ApplicationGetResponse;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_v3_api.v3.model.ApplicationGetStateResponse;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_v3_api.v3.model.ApplicationResponse;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_v3_api.v3.model.CreateApplicationOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_v3_api.v3.model.DeleteApplicationByIdOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_v3_api.v3.model.GetApplicationByIdOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_v3_api.v3.model.GetApplicationStateOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_v3_api.v3.model.GetApplicationsOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_v3_api.v3.model.GetInstanceByIdOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_v3_api.v3.model.InstanceDetails;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.util.CredentialUtils;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//
// This file provides an example of how to use the IBM Analytics Engine v3 API service.
//
// The following configuration properties are assumed to be defined:
// IBM_ANALYTICS_ENGINE_V3_API_URL=<service base url>
// IBM_ANALYTICS_ENGINE_V3_API_AUTH_TYPE=iam
// IBM_ANALYTICS_ENGINE_V3_API_APIKEY=<IAM apikey>
// IBM_ANALYTICS_ENGINE_V3_API_AUTH_URL=<IAM token service base URL - omit this if using the production environment>
//
// These configuration properties can be exported as environment variables, or stored
// in a configuration file and then:
// export IBM_CREDENTIALS_FILE=<name of configuration file>
//
public class IbmAnalyticsEngineV3ApiExamples {
  private static final Logger logger = LoggerFactory.getLogger(IbmAnalyticsEngineV3ApiExamples.class);
  protected IbmAnalyticsEngineV3ApiExamples() { }

  @SuppressWarnings("checkstyle:methodlength")
  public static void main(String[] args) throws Exception {
    IbmAnalyticsEngineV3Api ibmAnalyticsEngineV3ApiService = IbmAnalyticsEngineV3Api.newInstance();

    // Load up our test-specific config properties.
    Map<String, String> config = CredentialUtils.getServiceProperties(IbmAnalyticsEngineV3Api.DEFAULT_SERVICE_NAME);

    try {
      System.out.println("getInstanceById() result:");
      // begin-get_instance_by_id
      GetInstanceByIdOptions getInstanceByIdOptions = new GetInstanceByIdOptions.Builder()
        .instanceId("testString")
        .build();

      Response<InstanceDetails> response = ibmAnalyticsEngineV3ApiService.getInstanceById(getInstanceByIdOptions).execute();
      InstanceDetails instanceDetails = response.getResult();

      System.out.println(instanceDetails);
      // end-get_instance_by_id
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("createApplication() result:");
      // begin-create_application
      CreateApplicationOptions createApplicationOptions = new CreateApplicationOptions.Builder()
        .instanceId("testString")
        .build();

      Response<ApplicationResponse> response = ibmAnalyticsEngineV3ApiService.createApplication(createApplicationOptions).execute();
      ApplicationResponse applicationResponse = response.getResult();

      System.out.println(applicationResponse);
      // end-create_application
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("getApplications() result:");
      // begin-get_applications
      GetApplicationsOptions getApplicationsOptions = new GetApplicationsOptions.Builder()
        .instanceId("testString")
        .build();

      Response<ApplicationCollection> response = ibmAnalyticsEngineV3ApiService.getApplications(getApplicationsOptions).execute();
      ApplicationCollection applicationCollection = response.getResult();

      System.out.println(applicationCollection);
      // end-get_applications
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("getApplicationById() result:");
      // begin-get_application_by_id
      GetApplicationByIdOptions getApplicationByIdOptions = new GetApplicationByIdOptions.Builder()
        .instanceId("testString")
        .applicationId("testString")
        .build();

      Response<ApplicationGetResponse> response = ibmAnalyticsEngineV3ApiService.getApplicationById(getApplicationByIdOptions).execute();
      ApplicationGetResponse applicationGetResponse = response.getResult();

      System.out.println(applicationGetResponse);
      // end-get_application_by_id
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("getApplicationState() result:");
      // begin-get_application_state
      GetApplicationStateOptions getApplicationStateOptions = new GetApplicationStateOptions.Builder()
        .instanceId("testString")
        .applicationId("testString")
        .build();

      Response<ApplicationGetStateResponse> response = ibmAnalyticsEngineV3ApiService.getApplicationState(getApplicationStateOptions).execute();
      ApplicationGetStateResponse applicationGetStateResponse = response.getResult();

      System.out.println(applicationGetStateResponse);
      // end-get_application_state
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-delete_application_by_id
      DeleteApplicationByIdOptions deleteApplicationByIdOptions = new DeleteApplicationByIdOptions.Builder()
        .instanceId("testString")
        .applicationId("testString")
        .build();

      Response<Void> response = ibmAnalyticsEngineV3ApiService.deleteApplicationById(deleteApplicationByIdOptions).execute();
      // end-delete_application_by_id
      System.out.printf("deleteApplicationById() response status code: %d%n", response.getStatusCode());
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

  }
}
