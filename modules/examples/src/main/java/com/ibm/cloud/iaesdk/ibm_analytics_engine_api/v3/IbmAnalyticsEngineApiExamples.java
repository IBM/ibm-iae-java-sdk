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
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.ApplicationRequestApplicationDetails;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.ApplicationResponse;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.ConfigurePlatformLoggingOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.CreateApplicationOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.CurrentResourceConsumptionResponse;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.DeleteApplicationOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.GetApplicationOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.GetApplicationStateOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.GetCurrentResourceConsumptionOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.GetInstanceDefaultConfigsOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.GetInstanceOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.GetInstanceStateOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.GetLogForwardingConfigOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.GetLoggingConfigurationOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.Instance;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.InstanceGetStateResponse;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.InstanceHomeResponse;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.ListApplicationsOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.LogForwardingConfigResponse;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.LoggingConfigurationResponse;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.ReplaceInstanceDefaultConfigsOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.ReplaceLogForwardingConfigOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.SetInstanceHomeOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.UpdateInstanceDefaultConfigsOptions;
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
    Map<String, String> testConfigProperties = CredentialUtils.getServiceProperties(IbmAnalyticsEngineApi.DEFAULT_SERVICE_NAME);

    try {
      System.out.println("getInstance() result:");
      // begin-get_instance
      GetInstanceOptions getInstanceOptions = new GetInstanceOptions.Builder()
        .instanceId("dc0e9889-eab2-4t9e-9441-566209499546")
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
        .instanceId("dc0e9889-eab2-4t9e-9441-566209499546")
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
        .instanceId("dc0e9889-eab2-4t9e-9441-566209499546")
        .newHmacAccessKey("b9****************************4b")
        .newHmacSecretKey("fa********************************************8a")
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
      System.out.println("getInstanceDefaultConfigs() result:");
      // begin-get_instance_default_configs
      GetInstanceDefaultConfigsOptions getInstanceDefaultConfigsOptions = new GetInstanceDefaultConfigsOptions.Builder()
        .instanceId("dc0e9889-eab2-4t9e-9441-566209499546")
        .build();

      Response<Map<String, String>> response = ibmAnalyticsEngineApiService.getInstanceDefaultConfigs(getInstanceDefaultConfigsOptions).execute();
      Map<String, String> instanceDefaultConfigs = response.getResult();

      System.out.println(instanceDefaultConfigs);
      // end-get_instance_default_configs
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("replaceInstanceDefaultConfigs() result:");
      // begin-replace_instance_default_configs

      Map<String, String> newDefaultConfigs = new java.util.HashMap<String, String>();
      newDefaultConfigs.put("spark.driver.memory", "8G");
      newDefaultConfigs.put("spark.driver.cores", "2");

      ReplaceInstanceDefaultConfigsOptions replaceInstanceDefaultConfigsOptions = new ReplaceInstanceDefaultConfigsOptions.Builder()
        .instanceId("dc0e9889-eab2-4t9e-9441-566209499546")
        .body(newDefaultConfigs)
        .build();

      Response<Map<String, String>> response = ibmAnalyticsEngineApiService.replaceInstanceDefaultConfigs(replaceInstanceDefaultConfigsOptions).execute();
      Map<String, String> instanceDefaultConfigs = response.getResult();

      System.out.println(instanceDefaultConfigs);
      // end-replace_instance_default_configs
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("updateInstanceDefaultConfigs() result:");
      // begin-update_instance_default_configs

      Map<String, Object> defaultConfigsUpdate = new java.util.HashMap<String, Object>();
      defaultConfigsUpdate.put("ae.spark.history-server.cores", "1");
      defaultConfigsUpdate.put("ae.spark.history-server.memory", "4G");

      UpdateInstanceDefaultConfigsOptions updateInstanceDefaultConfigsOptions = new UpdateInstanceDefaultConfigsOptions.Builder()
        .instanceId("dc0e9889-eab2-4t9e-9441-566209499546")
        .body(defaultConfigsUpdate)
        .build();

      Response<Map<String, String>> response = ibmAnalyticsEngineApiService.updateInstanceDefaultConfigs(updateInstanceDefaultConfigsOptions).execute();
      Map<String, String> instanceDefaultConfigs = response.getResult();

      System.out.println(instanceDefaultConfigs);
      // end-update_instance_default_configs
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("createApplication() result:");
      // begin-create_application
      CreateApplicationOptions createApplicationOptions = new CreateApplicationOptions.Builder()
        .instanceId("dc0e9889-eab2-4t9e-9441-566209499546")
        .applicationDetails(new ApplicationRequestApplicationDetails.Builder()
          .application("/opt/ibm/spark/examples/src/main/python/wordcount.py")
          .addArguments("/opt/ibm/spark/examples/src/main/resources/people.txt")
          .build())
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
        .instanceId("dc0e9889-eab2-4t9e-9441-566209499546")
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
        .instanceId("dc0e9889-eab2-4t9e-9441-566209499546")
        .applicationId("db933645-0b68-4dcb-80d8-7b71a6c8e542")
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
        .instanceId("dc0e9889-eab2-4t9e-9441-566209499546")
        .applicationId("db933645-0b68-4dcb-80d8-7b71a6c8e542")
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
      System.out.println("getCurrentResourceConsumption() result:");
      // begin-get_current_resource_consumption
      GetCurrentResourceConsumptionOptions getCurrentResourceConsumptionOptions = new GetCurrentResourceConsumptionOptions.Builder()
        .instanceId("dc0e9889-eab2-4t9e-9441-566209499546")
        .build();

      Response<CurrentResourceConsumptionResponse> response = ibmAnalyticsEngineApiService.getCurrentResourceConsumption(getCurrentResourceConsumptionOptions).execute();
      CurrentResourceConsumptionResponse currentResourceConsumptionResponse = response.getResult();

      System.out.println(currentResourceConsumptionResponse);
      // end-get_current_resource_consumption
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("replaceLogForwardingConfig() result:");
      // begin-replace_log_forwarding_config
      ReplaceLogForwardingConfigOptions replaceLogForwardingConfigOptions = new ReplaceLogForwardingConfigOptions.Builder()
        .instanceId("dc0e9889-eab2-4t9e-9441-566209499546")
        .enabled(true)
        .build();

      Response<LogForwardingConfigResponse> response = ibmAnalyticsEngineApiService.replaceLogForwardingConfig(replaceLogForwardingConfigOptions).execute();
      LogForwardingConfigResponse logForwardingConfigResponse = response.getResult();

      System.out.println(logForwardingConfigResponse);
      // end-replace_log_forwarding_config
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("getLogForwardingConfig() result:");
      // begin-get_log_forwarding_config
      GetLogForwardingConfigOptions getLogForwardingConfigOptions = new GetLogForwardingConfigOptions.Builder()
        .instanceId("dc0e9889-eab2-4t9e-9441-566209499546")
        .build();

      Response<LogForwardingConfigResponse> response = ibmAnalyticsEngineApiService.getLogForwardingConfig(getLogForwardingConfigOptions).execute();
      LogForwardingConfigResponse logForwardingConfigResponse = response.getResult();

      System.out.println(logForwardingConfigResponse);
      // end-get_log_forwarding_config
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("configurePlatformLogging() result:");
      // begin-configure_platform_logging
      ConfigurePlatformLoggingOptions configurePlatformLoggingOptions = new ConfigurePlatformLoggingOptions.Builder()
        .instanceGuid("dc0e9889-eab2-4t9e-9441-566209499546")
        .enable(true)
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
        .instanceGuid("dc0e9889-eab2-4t9e-9441-566209499546")
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
      // begin-delete_application
      DeleteApplicationOptions deleteApplicationOptions = new DeleteApplicationOptions.Builder()
        .instanceId("dc0e9889-eab2-4t9e-9441-566209499546")
        .applicationId("db933645-0b68-4dcb-80d8-7b71a6c8e542")
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
