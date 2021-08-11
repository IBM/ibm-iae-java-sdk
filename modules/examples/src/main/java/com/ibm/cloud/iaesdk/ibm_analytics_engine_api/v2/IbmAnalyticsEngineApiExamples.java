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

package com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2;

import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2.model.AnalyticsEngine;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2.model.AnalyticsEngineCreateCustomizationResponse;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2.model.AnalyticsEngineCustomAction;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2.model.AnalyticsEngineCustomizationRequestCollectionItem;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2.model.AnalyticsEngineCustomizationRunDetails;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2.model.AnalyticsEngineLoggingConfigDetails;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2.model.AnalyticsEngineLoggingNodeSpec;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2.model.AnalyticsEngineLoggingServer;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2.model.AnalyticsEngineResetClusterPasswordResponse;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2.model.AnalyticsEngineResizeClusterResponse;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2.model.AnalyticsEngineState;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2.model.AnalyticsEngineWhitelistResponse;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2.model.ConfigureLoggingOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2.model.CreateCustomizationRequestOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2.model.DeleteLoggingConfigOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2.model.GetAllAnalyticsEnginesOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2.model.GetAllCustomizationRequestsOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2.model.GetAnalyticsEngineByIdOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2.model.GetAnalyticsEngineStateByIdOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2.model.GetCustomizationRequestByIdOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2.model.GetLoggingConfigOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2.model.ResetClusterPasswordOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2.model.ResizeClusterOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2.model.ResizeClusterRequestAnalyticsEngineResizeClusterByComputeNodesRequest;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2.model.UpdatePrivateEndpointWhitelistOptions;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.util.CredentialUtils;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//
// This file provides an example of how to use the IBM Analytics Engine API service.
//
// The following configuration properties are assumed to be defined:
// IBM_ANALYTICS_ENGINE_API_URL=<service base url>
// IBM_ANALYTICS_ENGINE_API_AUTH_TYPE=iam
// IBM_ANALYTICS_ENGINE_API_APIKEY=<IAM apikey>
// IBM_ANALYTICS_ENGINE_API_AUTH_URL=<IAM token service base URL - omit this if using the production environment>
//
// These configuration properties can be exported as environment variables, or stored
// in a configuration file and then:
// export IBM_CREDENTIALS_FILE=<name of configuration file>
//
public class IbmAnalyticsEngineApiExamples {
  private static final Logger logger = LoggerFactory.getLogger(IbmAnalyticsEngineApiExamples.class);
  protected IbmAnalyticsEngineApiExamples() { }

  @SuppressWarnings("checkstyle:methodlength")
  public static void main(String[] args) throws Exception {
    IbmAnalyticsEngineApi ibmAnalyticsEngineApiService = IbmAnalyticsEngineApi.newInstance();

    // Load up our test-specific config properties.
    Map<String, String> config = CredentialUtils.getServiceProperties(IbmAnalyticsEngineApi.DEFAULT_SERVICE_NAME);

    try {
      // begin-getAllAnalyticsEngines
      GetAllAnalyticsEnginesOptions getAllAnalyticsEnginesOptions = new GetAllAnalyticsEnginesOptions();

      Response<Void> response = ibmAnalyticsEngineApiService.getAllAnalyticsEngines(getAllAnalyticsEnginesOptions).execute();
      // end-getAllAnalyticsEngines
      System.out.printf("getAllAnalyticsEngines() response status code: %d%n", response.getStatusCode());
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("getAnalyticsEngineById() result:");
      // begin-getAnalyticsEngineById
      GetAnalyticsEngineByIdOptions getAnalyticsEngineByIdOptions = new GetAnalyticsEngineByIdOptions.Builder()
        .instanceGuid("testString")
        .build();

      Response<AnalyticsEngine> response = ibmAnalyticsEngineApiService.getAnalyticsEngineById(getAnalyticsEngineByIdOptions).execute();
      AnalyticsEngine analyticsEngine = response.getResult();

      System.out.println(analyticsEngine);
      // end-getAnalyticsEngineById
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("getAnalyticsEngineStateById() result:");
      // begin-getAnalyticsEngineStateById
      GetAnalyticsEngineStateByIdOptions getAnalyticsEngineStateByIdOptions = new GetAnalyticsEngineStateByIdOptions.Builder()
        .instanceGuid("testString")
        .build();

      Response<AnalyticsEngineState> response = ibmAnalyticsEngineApiService.getAnalyticsEngineStateById(getAnalyticsEngineStateByIdOptions).execute();
      AnalyticsEngineState analyticsEngineState = response.getResult();

      System.out.println(analyticsEngineState);
      // end-getAnalyticsEngineStateById
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("createCustomizationRequest() result:");
      // begin-createCustomizationRequest
      AnalyticsEngineCustomAction analyticsEngineCustomActionModel = new AnalyticsEngineCustomAction.Builder()
        .name("testString")
        .build();
      CreateCustomizationRequestOptions createCustomizationRequestOptions = new CreateCustomizationRequestOptions.Builder()
        .instanceGuid("testString")
        .target("all")
        .customActions(new java.util.ArrayList<AnalyticsEngineCustomAction>(java.util.Arrays.asList(analyticsEngineCustomActionModel)))
        .build();

      Response<AnalyticsEngineCreateCustomizationResponse> response = ibmAnalyticsEngineApiService.createCustomizationRequest(createCustomizationRequestOptions).execute();
      AnalyticsEngineCreateCustomizationResponse analyticsEngineCreateCustomizationResponse = response.getResult();

      System.out.println(analyticsEngineCreateCustomizationResponse);
      // end-createCustomizationRequest
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("getAllCustomizationRequests() result:");
      // begin-getAllCustomizationRequests
      GetAllCustomizationRequestsOptions getAllCustomizationRequestsOptions = new GetAllCustomizationRequestsOptions.Builder()
        .instanceGuid("testString")
        .build();

      Response<List<AnalyticsEngineCustomizationRequestCollectionItem>> response = ibmAnalyticsEngineApiService.getAllCustomizationRequests(getAllCustomizationRequestsOptions).execute();
      List<AnalyticsEngineCustomizationRequestCollectionItem> listAnalyticsEngineCustomizationRequestCollectionItem = response.getResult();

      System.out.println(listAnalyticsEngineCustomizationRequestCollectionItem);
      // end-getAllCustomizationRequests
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }
    try {
      System.out.println("resizeCluster() result:");
      // begin-resizeCluster
      ResizeClusterRequestAnalyticsEngineResizeClusterByComputeNodesRequest resizeClusterRequestModel = new ResizeClusterRequestAnalyticsEngineResizeClusterByComputeNodesRequest.Builder()
        .build();
      ResizeClusterOptions resizeClusterOptions = new ResizeClusterOptions.Builder()
        .instanceGuid("testString")
        .body(resizeClusterRequestModel)
        .build();

      Response<AnalyticsEngineResizeClusterResponse> response = ibmAnalyticsEngineApiService.resizeCluster(resizeClusterOptions).execute();
      AnalyticsEngineResizeClusterResponse analyticsEngineResizeClusterResponse = response.getResult();

      System.out.println(analyticsEngineResizeClusterResponse);
      // end-resizeCluster
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("resetClusterPassword() result:");
      // begin-resetClusterPassword
      ResetClusterPasswordOptions resetClusterPasswordOptions = new ResetClusterPasswordOptions.Builder()
        .instanceGuid("testString")
        .build();

      Response<AnalyticsEngineResetClusterPasswordResponse> response = ibmAnalyticsEngineApiService.resetClusterPassword(resetClusterPasswordOptions).execute();
      AnalyticsEngineResetClusterPasswordResponse analyticsEngineResetClusterPasswordResponse = response.getResult();

      System.out.println(analyticsEngineResetClusterPasswordResponse);
      // end-resetClusterPassword
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-configureLogging
      AnalyticsEngineLoggingNodeSpec analyticsEngineLoggingNodeSpecModel = new AnalyticsEngineLoggingNodeSpec.Builder()
        .nodeType("management")
        .components(new java.util.ArrayList<String>(java.util.Arrays.asList("ambari-server")))
        .build();
      AnalyticsEngineLoggingServer analyticsEngineLoggingServerModel = new AnalyticsEngineLoggingServer.Builder()
        .type("logdna")
        .credential("testString")
        .apiHost("testString")
        .logHost("testString")
        .build();
      ConfigureLoggingOptions configureLoggingOptions = new ConfigureLoggingOptions.Builder()
        .instanceGuid("testString")
        .logSpecs(new java.util.ArrayList<AnalyticsEngineLoggingNodeSpec>(java.util.Arrays.asList(analyticsEngineLoggingNodeSpecModel)))
        .logServer(analyticsEngineLoggingServerModel)
        .build();

      Response<Void> response = ibmAnalyticsEngineApiService.configureLogging(configureLoggingOptions).execute();
      // end-configureLogging
      System.out.printf("configureLogging() response status code: %d%n", response.getStatusCode());
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("getLoggingConfig() result:");
      // begin-getLoggingConfig
      GetLoggingConfigOptions getLoggingConfigOptions = new GetLoggingConfigOptions.Builder()
        .instanceGuid("testString")
        .build();

      Response<AnalyticsEngineLoggingConfigDetails> response = ibmAnalyticsEngineApiService.getLoggingConfig(getLoggingConfigOptions).execute();
      AnalyticsEngineLoggingConfigDetails analyticsEngineLoggingConfigDetails = response.getResult();

      System.out.println(analyticsEngineLoggingConfigDetails);
      // end-getLoggingConfig
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("updatePrivateEndpointWhitelist() result:");
      // begin-updatePrivateEndpointWhitelist
      UpdatePrivateEndpointWhitelistOptions updatePrivateEndpointWhitelistOptions = new UpdatePrivateEndpointWhitelistOptions.Builder()
        .instanceGuid("testString")
        .ipRanges(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
        .action("add")
        .build();

      Response<AnalyticsEngineWhitelistResponse> response = ibmAnalyticsEngineApiService.updatePrivateEndpointWhitelist(updatePrivateEndpointWhitelistOptions).execute();
      AnalyticsEngineWhitelistResponse analyticsEngineWhitelistResponse = response.getResult();

      System.out.println(analyticsEngineWhitelistResponse);
      // end-updatePrivateEndpointWhitelist
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-deleteLoggingConfig
      DeleteLoggingConfigOptions deleteLoggingConfigOptions = new DeleteLoggingConfigOptions.Builder()
        .instanceGuid("testString")
        .build();

      Response<Void> response = ibmAnalyticsEngineApiService.deleteLoggingConfig(deleteLoggingConfigOptions).execute();
      // end-deleteLoggingConfig
      System.out.printf("deleteLoggingConfig() response status code: %d%n", response.getStatusCode());
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

  }
}
