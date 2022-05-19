/*
 * (C) Copyright IBM Corp. 2022.
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

package com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3;

import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.ApplicationCollection;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.ApplicationGetResponse;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.ApplicationGetStateResponse;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.ApplicationResponse;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.ConfigurePlatformLoggingOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.CreateApplicationOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.DeleteApplicationOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.GetApplicationOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.GetApplicationStateOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.GetInstanceOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.GetInstanceStateOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.GetLoggingConfigurationOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.GetSparkHistoryServerOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.Instance;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.InstanceGetStateResponse;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.InstanceHomeResponse;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.ListApplicationsOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.LoggingConfigurationResponse;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.SetInstanceHomeOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.SparkHistoryServerResponse;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.SparkHistoryServerStartResponse;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.StartSparkHistoryServerOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.StopSparkHistoryServerOptions;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.util.CredentialUtils;
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

  static {
    System.setProperty("IBM_CREDENTIALS_FILE", "../../ibm_analytics_engine_api_v3.env");
  }

  @SuppressWarnings("checkstyle:methodlength")
  public static void main(String[] args) throws Exception {
    IbmAnalyticsEngineApi ibmAnalyticsEngineApiService = IbmAnalyticsEngineApi.newInstance();

    // Load up our test-specific config properties.
    Map<String, String> config = CredentialUtils.getServiceProperties(IbmAnalyticsEngineApi.DEFAULT_SERVICE_NAME);

    try {
      System.out.println("getInstance() result:");
      // begin-get_instance
      GetInstanceOptions getInstanceOptions = new GetInstanceOptions.Builder()
        .instanceId("e64c907a-e82f-46fd-addc-ccfafbd28b09")
        .build();

      Response<Instance> response = ibmAnalyticsEngineApiService.getInstance(getInstanceOptions).execute();
      Instance instance = response.getResult();

      System.out.println(instance);
      // end-get_instance
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("getInstanceState() result:");
      // begin-get_instance_state
      GetInstanceStateOptions getInstanceStateOptions = new GetInstanceStateOptions.Builder()
        .instanceId("e64c907a-e82f-46fd-addc-ccfafbd28b09")
        .build();

      Response<InstanceGetStateResponse> response = ibmAnalyticsEngineApiService.getInstanceState(getInstanceStateOptions).execute();
      InstanceGetStateResponse instanceGetStateResponse = response.getResult();

      System.out.println(instanceGetStateResponse);
      // end-get_instance_state
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("setInstanceHome() result:");
      // begin-set_instance_home
      SetInstanceHomeOptions setInstanceHomeOptions = new SetInstanceHomeOptions.Builder()
        .instanceId("e64c907a-e82f-46fd-addc-ccfafbd28b09")
        .build();

      Response<InstanceHomeResponse> response = ibmAnalyticsEngineApiService.setInstanceHome(setInstanceHomeOptions).execute();
      InstanceHomeResponse instanceHomeResponse = response.getResult();

      System.out.println(instanceHomeResponse);
      // end-set_instance_home
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("createApplication() result:");
      // begin-create_application
      CreateApplicationOptions createApplicationOptions = new CreateApplicationOptions.Builder()
        .instanceId("e64c907a-e82f-46fd-addc-ccfafbd28b09")
        .build();

      Response<ApplicationResponse> response = ibmAnalyticsEngineApiService.createApplication(createApplicationOptions).execute();
      ApplicationResponse applicationResponse = response.getResult();

      System.out.println(applicationResponse);
      // end-create_application
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("listApplications() result:");
      // begin-list_applications
      ListApplicationsOptions listApplicationsOptions = new ListApplicationsOptions.Builder()
        .instanceId("e64c907a-e82f-46fd-addc-ccfafbd28b09")
        .build();

      Response<ApplicationCollection> response = ibmAnalyticsEngineApiService.listApplications(listApplicationsOptions).execute();
      ApplicationCollection applicationCollection = response.getResult();

      System.out.println(applicationCollection);
      // end-list_applications
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("getApplication() result:");
      // begin-get_application
      GetApplicationOptions getApplicationOptions = new GetApplicationOptions.Builder()
        .instanceId("e64c907a-e82f-46fd-addc-ccfafbd28b09")
        .applicationId("ff48cc19-0e7e-4627-aac6-0b4ad080397b")
        .build();

      Response<ApplicationGetResponse> response = ibmAnalyticsEngineApiService.getApplication(getApplicationOptions).execute();
      ApplicationGetResponse applicationGetResponse = response.getResult();

      System.out.println(applicationGetResponse);
      // end-get_application
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("getApplicationState() result:");
      // begin-get_application_state
      GetApplicationStateOptions getApplicationStateOptions = new GetApplicationStateOptions.Builder()
        .instanceId("e64c907a-e82f-46fd-addc-ccfafbd28b09")
        .applicationId("ff48cc19-0e7e-4627-aac6-0b4ad080397b")
        .build();

      Response<ApplicationGetStateResponse> response = ibmAnalyticsEngineApiService.getApplicationState(getApplicationStateOptions).execute();
      ApplicationGetStateResponse applicationGetStateResponse = response.getResult();

      System.out.println(applicationGetStateResponse);
      // end-get_application_state
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("configurePlatformLogging() result:");
      // begin-configure_platform_logging
      ConfigurePlatformLoggingOptions configurePlatformLoggingOptions = new ConfigurePlatformLoggingOptions.Builder()
        .instanceGuid("e64c907a-e82f-46fd-addc-ccfafbd28b09")
        .build();

      Response<LoggingConfigurationResponse> response = ibmAnalyticsEngineApiService.configurePlatformLogging(configurePlatformLoggingOptions).execute();
      LoggingConfigurationResponse loggingConfigurationResponse = response.getResult();

      System.out.println(loggingConfigurationResponse);
      // end-configure_platform_logging
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("getLoggingConfiguration() result:");
      // begin-get_logging_configuration
      GetLoggingConfigurationOptions getLoggingConfigurationOptions = new GetLoggingConfigurationOptions.Builder()
        .instanceGuid("e64c907a-e82f-46fd-addc-ccfafbd28b09")
        .build();

      Response<LoggingConfigurationResponse> response = ibmAnalyticsEngineApiService.getLoggingConfiguration(getLoggingConfigurationOptions).execute();
      LoggingConfigurationResponse loggingConfigurationResponse = response.getResult();

      System.out.println(loggingConfigurationResponse);
      // end-get_logging_configuration
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("startSparkHistoryServer() result:");
      // begin-start_spark_history_server
      StartSparkHistoryServerOptions startSparkHistoryServerOptions = new StartSparkHistoryServerOptions.Builder()
        .instanceId("e64c907a-e82f-46fd-addc-ccfafbd28b09")
        .build();

      Response<SparkHistoryServerStartResponse> response = ibmAnalyticsEngineApiService.startSparkHistoryServer(startSparkHistoryServerOptions).execute();
      SparkHistoryServerStartResponse sparkHistoryServerStartResponse = response.getResult();

      System.out.println(sparkHistoryServerStartResponse);
      // end-start_spark_history_server
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("getSparkHistoryServer() result:");
      // begin-get_spark_history_server
      GetSparkHistoryServerOptions getSparkHistoryServerOptions = new GetSparkHistoryServerOptions.Builder()
        .instanceId("e64c907a-e82f-46fd-addc-ccfafbd28b09")
        .build();

      Response<SparkHistoryServerResponse> response = ibmAnalyticsEngineApiService.getSparkHistoryServer(getSparkHistoryServerOptions).execute();
      SparkHistoryServerResponse sparkHistoryServerResponse = response.getResult();

      System.out.println(sparkHistoryServerResponse);
      // end-get_spark_history_server
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-stop_spark_history_server
      StopSparkHistoryServerOptions stopSparkHistoryServerOptions = new StopSparkHistoryServerOptions.Builder()
        .instanceId("e64c907a-e82f-46fd-addc-ccfafbd28b09")
        .build();

      Response<Void> response = ibmAnalyticsEngineApiService.stopSparkHistoryServer(stopSparkHistoryServerOptions).execute();
      // end-stop_spark_history_server
      System.out.printf("stopSparkHistoryServer() response status code: %d%n", response.getStatusCode());
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-delete_application
      DeleteApplicationOptions deleteApplicationOptions = new DeleteApplicationOptions.Builder()
        .instanceId("e64c907a-e82f-46fd-addc-ccfafbd28b09")
        .applicationId("ff48cc19-0e7e-4627-aac6-0b4ad080397b")
        .build();

      Response<Void> response = ibmAnalyticsEngineApiService.deleteApplication(deleteApplicationOptions).execute();
      // end-delete_application
      System.out.printf("deleteApplication() response status code: %d%n", response.getStatusCode());
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

  }
}
