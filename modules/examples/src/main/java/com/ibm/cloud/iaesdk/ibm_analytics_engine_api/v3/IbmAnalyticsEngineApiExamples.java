/*
 * (C) Copyright IBM Corp. 2023.
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

import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.Application;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.ApplicationGetResponse;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.ApplicationGetStateResponse;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.ApplicationRequestApplicationDetails;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.ApplicationResponse;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.ApplicationsPager;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.ConfigurePlatformLoggingOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.CreateApplicationOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.CurrentResourceConsumptionResponse;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.DeleteApplicationOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.GetApplicationOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.GetApplicationStateOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.GetCurrentResourceConsumptionOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.GetInstanceDefaultConfigsOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.GetInstanceDefaultRuntimeOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.GetInstanceOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.GetInstanceStateOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.GetLogForwardingConfigOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.GetLoggingConfigurationOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.GetResourceConsumptionLimitsOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.GetSparkHistoryServerOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.Instance;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.InstanceGetStateResponse;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.InstanceHomeResponse;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.ListApplicationsOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.LogForwardingConfigResponse;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.LoggingConfigurationResponse;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.ReplaceInstanceDefaultConfigsOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.ReplaceInstanceDefaultRuntimeOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.ReplaceLogForwardingConfigOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.ResourceConsumptionLimitsResponse;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.Runtime;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.SetInstanceHomeOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.SparkHistoryServerResponse;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.StartSparkHistoryServerOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.StopSparkHistoryServerOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.UpdateInstanceDefaultConfigsOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.UpdateInstanceHomeCredentialsOptions;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.util.CredentialUtils;
import com.ibm.cloud.sdk.core.util.GsonSingleton;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class contains examples of how to use the IBM Analytics Engine API service.
 *
 * The following configuration properties are assumed to be defined:
 * IBM_ANALYTICS_ENGINE_API_URL=&lt;service base url&gt;
 * IBM_ANALYTICS_ENGINE_API_AUTH_TYPE=iam
 * IBM_ANALYTICS_ENGINE_API_APIKEY=&lt;IAM apikey&gt;
 * IBM_ANALYTICS_ENGINE_API_AUTH_URL=&lt;IAM token service base URL - omit this if using the production environment&gt;
 *
 * These configuration properties can be exported as environment variables, or stored
 * in a configuration file and then:
 * export IBM_CREDENTIALS_FILE=&lt;name of configuration file&gt;
 */
public class IbmAnalyticsEngineApiExamples {
  private static final Logger logger = LoggerFactory.getLogger(IbmAnalyticsEngineApiExamples.class);
  protected IbmAnalyticsEngineApiExamples() { }

  static {
    System.setProperty("IBM_CREDENTIALS_FILE", "../../ibm_analytics_engine_api_v3.env");
  }

  /**
   * The main() function invokes operations of the IBM Analytics Engine API service.
   * @param args command-line arguments
   * @throws Exception an error occurred
   */
  @SuppressWarnings("checkstyle:methodlength")
  public static void main(String[] args) throws Exception {
    IbmAnalyticsEngineApi ibmAnalyticsEngineApiService = IbmAnalyticsEngineApi.newInstance();

    // Load up our test-specific config properties.
    Map<String, String> testConfigProperties = CredentialUtils.getServiceProperties(IbmAnalyticsEngineApi.DEFAULT_SERVICE_NAME);

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
      System.out.println("updateInstanceHomeCredentials() result:");
      // begin-update_instance_home_credentials
      UpdateInstanceHomeCredentialsOptions updateInstanceHomeCredentialsOptions = new UpdateInstanceHomeCredentialsOptions.Builder()
        .instanceId("e64c907a-e82f-46fd-addc-ccfafbd28b09")
        .hmacAccessKey("b9****************************4b")
        .hmacSecretKey("fa********************************************8a")
        .build();

      Response<InstanceHomeResponse> response = ibmAnalyticsEngineApiService.updateInstanceHomeCredentials(updateInstanceHomeCredentialsOptions).execute();
      InstanceHomeResponse instanceHomeResponse = response.getResult();

      System.out.println(instanceHomeResponse);
      // end-update_instance_home_credentials
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("getInstanceDefaultConfigs() result:");
      // begin-get_instance_default_configs
      GetInstanceDefaultConfigsOptions getInstanceDefaultConfigsOptions = new GetInstanceDefaultConfigsOptions.Builder()
        .instanceId("e64c907a-e82f-46fd-addc-ccfafbd28b09")
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
      ReplaceInstanceDefaultConfigsOptions replaceInstanceDefaultConfigsOptions = new ReplaceInstanceDefaultConfigsOptions.Builder()
        .instanceId("e64c907a-e82f-46fd-addc-ccfafbd28b09")
        .body(java.util.Collections.singletonMap("foo", "testString"))
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
      UpdateInstanceDefaultConfigsOptions updateInstanceDefaultConfigsOptions = new UpdateInstanceDefaultConfigsOptions.Builder()
        .instanceId("e64c907a-e82f-46fd-addc-ccfafbd28b09")
        .body(new java.util.HashMap<String, Object>())
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
      System.out.println("getInstanceDefaultRuntime() result:");
      // begin-get_instance_default_runtime
      GetInstanceDefaultRuntimeOptions getInstanceDefaultRuntimeOptions = new GetInstanceDefaultRuntimeOptions.Builder()
        .instanceId("e64c907a-e82f-46fd-addc-ccfafbd28b09")
        .build();

      Response<Runtime> response = ibmAnalyticsEngineApiService.getInstanceDefaultRuntime(getInstanceDefaultRuntimeOptions).execute();
      Runtime runtime = response.getResult();

      System.out.println(runtime);
      // end-get_instance_default_runtime
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("replaceInstanceDefaultRuntime() result:");
      // begin-replace_instance_default_runtime
      ReplaceInstanceDefaultRuntimeOptions replaceInstanceDefaultRuntimeOptions = new ReplaceInstanceDefaultRuntimeOptions.Builder()
        .instanceId("e64c907a-e82f-46fd-addc-ccfafbd28b09")
        .sparkVersion("3.3")
        .build();

      Response<Runtime> response = ibmAnalyticsEngineApiService.replaceInstanceDefaultRuntime(replaceInstanceDefaultRuntimeOptions).execute();
      Runtime runtime = response.getResult();

      System.out.println(runtime);
      // end-replace_instance_default_runtime
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("createApplication() result:");
      // begin-create_application
      Runtime runtimeModel = new Runtime.Builder()
        .sparkVersion("3.3")
        .build();
      ApplicationRequestApplicationDetails applicationRequestApplicationDetailsModel = new ApplicationRequestApplicationDetails.Builder()
        .application("/opt/ibm/spark/examples/src/main/python/wordcount.py")
        .runtime(runtimeModel)
        .arguments(java.util.Arrays.asList("/opt/ibm/spark/examples/src/main/resources/people.txt"))
        .build();
      CreateApplicationOptions createApplicationOptions = new CreateApplicationOptions.Builder()
        .instanceId("e64c907a-e82f-46fd-addc-ccfafbd28b09")
        .applicationDetails(applicationRequestApplicationDetailsModel)
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
        .addState("accepted")
        .addState("running")
        .addState("finished")
        .addState("failed")
        .limit(Long.valueOf("10"))
        .build();

      ApplicationsPager pager = new ApplicationsPager(ibmAnalyticsEngineApiService, listApplicationsOptions);
      List<Application> allResults = new ArrayList<>();
      while (pager.hasNext()) {
        List<Application> nextPage = pager.getNext();
        allResults.addAll(nextPage);
      }

      System.out.println(GsonSingleton.getGson().toJson(allResults));
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
      System.out.println("getCurrentResourceConsumption() result:");
      // begin-get_current_resource_consumption
      GetCurrentResourceConsumptionOptions getCurrentResourceConsumptionOptions = new GetCurrentResourceConsumptionOptions.Builder()
        .instanceId("e64c907a-e82f-46fd-addc-ccfafbd28b09")
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
      System.out.println("getResourceConsumptionLimits() result:");
      // begin-get_resource_consumption_limits
      GetResourceConsumptionLimitsOptions getResourceConsumptionLimitsOptions = new GetResourceConsumptionLimitsOptions.Builder()
        .instanceId("e64c907a-e82f-46fd-addc-ccfafbd28b09")
        .build();

      Response<ResourceConsumptionLimitsResponse> response = ibmAnalyticsEngineApiService.getResourceConsumptionLimits(getResourceConsumptionLimitsOptions).execute();
      ResourceConsumptionLimitsResponse resourceConsumptionLimitsResponse = response.getResult();

      System.out.println(resourceConsumptionLimitsResponse);
      // end-get_resource_consumption_limits
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("replaceLogForwardingConfig() result:");
      // begin-replace_log_forwarding_config
      ReplaceLogForwardingConfigOptions replaceLogForwardingConfigOptions = new ReplaceLogForwardingConfigOptions.Builder()
        .instanceId("e64c907a-e82f-46fd-addc-ccfafbd28b09")
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
        .instanceId("e64c907a-e82f-46fd-addc-ccfafbd28b09")
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
        .instanceGuid("e64c907a-e82f-46fd-addc-ccfafbd28b09")
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

      Response<SparkHistoryServerResponse> response = ibmAnalyticsEngineApiService.startSparkHistoryServer(startSparkHistoryServerOptions).execute();
      SparkHistoryServerResponse sparkHistoryServerResponse = response.getResult();

      System.out.println(sparkHistoryServerResponse);
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
  }
}
