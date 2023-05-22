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
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.ApplicationCollection;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.ApplicationDetails;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.ApplicationGetResponse;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.ApplicationGetResponseStateDetailsItem;
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
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.InstanceDefaultConfig;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.InstanceGetStateResponse;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.InstanceHome;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.InstanceHomeResponse;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.ListApplicationsOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.LogForwardingConfigResponse;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.LogForwardingConfigResponseLogServer;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.LoggingConfigurationResponse;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.LoggingConfigurationResponseLogServer;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.PageLink;
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
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.utils.TestUtilities;
import com.ibm.cloud.iaesdk.test.SdkIntegrationTestBase;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.CredentialUtils;
import com.ibm.cloud.sdk.core.util.DateUtils;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Integration test class for the IbmAnalyticsEngineApi service.
 */
public class IbmAnalyticsEngineApiIT extends SdkIntegrationTestBase {
  public IbmAnalyticsEngineApi service = null;
  public static Map<String, String> config = null;
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  public String instanceId = null;
  public String instanceIdWithoutInstanceHome = null;
  public String hmacAccessKey = null;
  public String hmacSecretKey = null;
  public String applicationId = null;
  public String alternateHmacAccessKey = null;
  public String alternateHmacSecretKey = null;

  /**
   * This method provides our config filename to the base class.
   */

  public String getConfigFilename() {
    return "../../ibm_analytics_engine_api_v3.env";
  }

  @BeforeClass
  public void constructService() {
    // Ask super if we should skip the tests.
    if (skipTests()) {
      return;
    }

    service = IbmAnalyticsEngineApi.newInstance();
    assertNotNull(service);
    assertNotNull(service.getServiceUrl());

    // Load up our test-specific config properties.
    config = CredentialUtils.getServiceProperties(IbmAnalyticsEngineApi.DEFAULT_SERVICE_NAME);
    assertNotNull(config);
    assertFalse(config.isEmpty());
    assertEquals(service.getServiceUrl(), config.get("URL"));
    instanceId = config.get("INSTANCE_GUID");
    instanceIdWithoutInstanceHome = config.get("INSTANCE_GUID_WO_INSTANCE_HOME");
    hmacAccessKey = config.get("HMAC_ACCESS_KEY");
    hmacSecretKey = config.get("HMAC_SECRET_KEY");
    service.enableRetries(4, 30);
    alternateHmacAccessKey = config.get("ALTERNATE_HMAC_ACCESS_KEY");
    alternateHmacSecretKey = config.get("ALTERNATE_HMAC_SECRET_KEY");
    System.out.println("Setup complete.");
  }

  @Test
  public void testGetInstance() throws Exception {
    try {
      GetInstanceOptions getInstanceOptions = new GetInstanceOptions.Builder()
        .instanceId(instanceId)
        .build();

      // Invoke operation
      Response<Instance> response = service.getInstance(getInstanceOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      Instance instanceResult = response.getResult();

      assertNotNull(instanceResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetInstance" })
  public void testGetInstanceState() throws Exception {
    try {
      GetInstanceStateOptions getInstanceStateOptions = new GetInstanceStateOptions.Builder()
        .instanceId(instanceId)
        .build();

      // Invoke operation
      Response<InstanceGetStateResponse> response = service.getInstanceState(getInstanceStateOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      InstanceGetStateResponse instanceGetStateResponseResult = response.getResult();

      assertNotNull(instanceGetStateResponseResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetInstanceState" })
  public void testSetInstanceHome() throws Exception {
    try {
      SetInstanceHomeOptions setInstanceHomeOptions = new SetInstanceHomeOptions.Builder()
        .instanceId(instanceIdWithoutInstanceHome)
        .newInstanceId("testString")
        .newProvider("ibm-cos")
        .newType("objectstore")
        .newRegion("us-south")
        .newEndpoint("s3.direct.us-south.cloud-object-storage.appdomain.cloud")
        .newHmacAccessKey(hmacAccessKey)
        .newHmacSecretKey(hmacSecretKey)
        .build();

      // Invoke operation
      Response<InstanceHomeResponse> response = service.setInstanceHome(setInstanceHomeOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      InstanceHomeResponse instanceHomeResponseResult = response.getResult();

      assertNotNull(instanceHomeResponseResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testSetInstanceHome" })
  public void testUpdateInstanceHomeCredentials() throws Exception {
    try {
      UpdateInstanceHomeCredentialsOptions updateInstanceHomeCredentialsOptions = new UpdateInstanceHomeCredentialsOptions.Builder()
        .instanceId(instanceId)
        .hmacAccessKey(alternateHmacAccessKey)
        .hmacSecretKey(alternateHmacSecretKey)
        .build();

      // Invoke operation
      Response<InstanceHomeResponse> response = service.updateInstanceHomeCredentials(updateInstanceHomeCredentialsOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      InstanceHomeResponse instanceHomeResponseResult = response.getResult();

      assertNotNull(instanceHomeResponseResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testUpdateInstanceHomeCredentials" })
  public void testGetInstanceDefaultConfigs() throws Exception {
    try {
      GetInstanceDefaultConfigsOptions getInstanceDefaultConfigsOptions = new GetInstanceDefaultConfigsOptions.Builder()
        .instanceId(instanceId)
        .build();

      // Invoke operation
      Response<Map<String, String>> response = service.getInstanceDefaultConfigs(getInstanceDefaultConfigsOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      Map<String, String> resultResult = response.getResult();

      assertNotNull(resultResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetInstanceDefaultConfigs" })
  public void testReplaceInstanceDefaultConfigs() throws Exception {
    try {
      Map<String, String> newDefaultConfigs = new HashMap<String, String>();
      newDefaultConfigs.put("spark.driver.memory", "8G");
      newDefaultConfigs.put("spark.driver.cores", "2");

      ReplaceInstanceDefaultConfigsOptions replaceInstanceDefaultConfigsOptions = new ReplaceInstanceDefaultConfigsOptions.Builder()
        .instanceId(instanceId)
        .body(newDefaultConfigs)
        .build();

      // Invoke operation
      Response<Map<String, String>> response = service.replaceInstanceDefaultConfigs(replaceInstanceDefaultConfigsOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      Map<String, String> resultResult = response.getResult();

      assertNotNull(resultResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testReplaceInstanceDefaultConfigs" })
  public void testUpdateInstanceDefaultConfigs() throws Exception {
    try {
      Map<String, Object> updatedDefaultConfigs = new HashMap<String, Object>();
      updatedDefaultConfigs.put("ae.spark.history-server.cores", "1");
      updatedDefaultConfigs.put("ae.spark.history-server.memory", "4G");

      UpdateInstanceDefaultConfigsOptions updateInstanceDefaultConfigsOptions = new UpdateInstanceDefaultConfigsOptions.Builder()
        .instanceId(instanceId)
        .body(updatedDefaultConfigs)
        .build();

      // Invoke operation
      Response<Map<String, String>> response = service.updateInstanceDefaultConfigs(updateInstanceDefaultConfigsOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      Map<String, String> resultResult = response.getResult();

      assertNotNull(resultResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testUpdateInstanceDefaultConfigs" })
  public void testGetInstanceDefaultRuntime() throws Exception {
    try {
      GetInstanceDefaultRuntimeOptions getInstanceDefaultRuntimeOptions = new GetInstanceDefaultRuntimeOptions.Builder()
        .instanceId(instanceId)
        .build();

      // Invoke operation
      Response<Runtime> response = service.getInstanceDefaultRuntime(getInstanceDefaultRuntimeOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      Runtime runtimeResult = response.getResult();

      assertNotNull(runtimeResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetInstanceDefaultRuntime" })
  public void testReplaceInstanceDefaultRuntime() throws Exception {
    try {
      ReplaceInstanceDefaultRuntimeOptions replaceInstanceDefaultRuntimeOptions = new ReplaceInstanceDefaultRuntimeOptions.Builder()
        .instanceId(instanceId)
        .sparkVersion("3.1")
        .build();

      // Invoke operation
      Response<Runtime> response = service.replaceInstanceDefaultRuntime(replaceInstanceDefaultRuntimeOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      Runtime runtimeResult = response.getResult();

      assertNotNull(runtimeResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testReplaceInstanceDefaultRuntime" })
  public void testCreateApplication() throws Exception {
    try {
      Runtime runtimeModel = new Runtime.Builder()
        .sparkVersion("3.3")
        .build();

      ApplicationRequestApplicationDetails applicationRequestApplicationDetailsModel = new ApplicationRequestApplicationDetails.Builder()
        .application("/opt/ibm/spark/examples/src/main/python/wordcount.py")
        .arguments(java.util.Arrays.asList("/opt/ibm/spark/examples/src/main/resources/people.txt"))
        .runtime(runtimeModel)
        .build();

      CreateApplicationOptions createApplicationOptions = new CreateApplicationOptions.Builder()
        .instanceId(instanceId)
        .applicationDetails(applicationRequestApplicationDetailsModel)
        .build();

      // Invoke operation
      Response<ApplicationResponse> response = service.createApplication(createApplicationOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 202);

      ApplicationResponse applicationResponseResult = response.getResult();

      assertNotNull(applicationResponseResult);

      applicationId = applicationResponseResult.getId();
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testCreateApplication" })
  public void testListApplications() throws Exception {
    try {
      ListApplicationsOptions listApplicationsOptions = new ListApplicationsOptions.Builder()
        .instanceId(instanceId)
        .state(java.util.Arrays.asList("accepted", "running", "finished", "stopped", "failed"))
        .limit(Long.valueOf("10"))
        .build();

      // Invoke operation
      Response<ApplicationCollection> response = service.listApplications(listApplicationsOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ApplicationCollection applicationCollectionResult = response.getResult();

      assertNotNull(applicationCollectionResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testListApplications" })
  public void testListApplicationsWithPager() throws Exception {
    try {
      ListApplicationsOptions options = new ListApplicationsOptions.Builder()
        .instanceId(instanceId)
        .state(java.util.Arrays.asList("accepted", "running", "finished", "stopped", "failed"))
        .limit(Long.valueOf("10"))
        .build();

      // Test getNext().
      List<Application> allResults = new ArrayList<>();
      ApplicationsPager pager = new ApplicationsPager(service, options);
      while (pager.hasNext()) {
        System.out.println("");
        List<Application> nextPage = pager.getNext();
        assertNotNull(nextPage);
        allResults.addAll(nextPage);
      }
      assertFalse(allResults.isEmpty());

      // Test getAll();
      pager = new ApplicationsPager(service, options);
      List<Application> allItems = pager.getAll();
      assertNotNull(allItems);
      assertFalse(allItems.isEmpty());

      assertEquals(allItems.size(), allResults.size());
      System.out.println(String.format("Retrieved a total of %d item(s) with pagination.", allResults.size()));
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testListApplications" })
  public void testGetApplication() throws Exception {
    try {
      GetApplicationOptions getApplicationOptions = new GetApplicationOptions.Builder()
        .instanceId(instanceId)
        .applicationId(applicationId)
        .build();

      // Invoke operation
      Response<ApplicationGetResponse> response = service.getApplication(getApplicationOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ApplicationGetResponse applicationGetResponseResult = response.getResult();

      assertNotNull(applicationGetResponseResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetApplication" })
  public void testGetApplicationState() throws Exception {
    try {
      GetApplicationStateOptions getApplicationStateOptions = new GetApplicationStateOptions.Builder()
        .instanceId(instanceId)
        .applicationId(applicationId)
        .build();

      // Invoke operation
      Response<ApplicationGetStateResponse> response = service.getApplicationState(getApplicationStateOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ApplicationGetStateResponse applicationGetStateResponseResult = response.getResult();

      assertNotNull(applicationGetStateResponseResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetApplicationState" })
  public void testGetCurrentResourceConsumption() throws Exception {
    try {
      GetCurrentResourceConsumptionOptions getCurrentResourceConsumptionOptions = new GetCurrentResourceConsumptionOptions.Builder()
        .instanceId(instanceId)
        .build();

      // Invoke operation
      Response<CurrentResourceConsumptionResponse> response = service.getCurrentResourceConsumption(getCurrentResourceConsumptionOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      CurrentResourceConsumptionResponse currentResourceConsumptionResponseResult = response.getResult();

      assertNotNull(currentResourceConsumptionResponseResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetCurrentResourceConsumption" })
  public void testGetResourceConsumptionLimits() throws Exception {
    try {
      GetResourceConsumptionLimitsOptions getResourceConsumptionLimitsOptions = new GetResourceConsumptionLimitsOptions.Builder()
        .instanceId(instanceId)
        .build();

      // Invoke operation
      Response<ResourceConsumptionLimitsResponse> response = service.getResourceConsumptionLimits(getResourceConsumptionLimitsOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ResourceConsumptionLimitsResponse resourceConsumptionLimitsResponseResult = response.getResult();

      assertNotNull(resourceConsumptionLimitsResponseResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetResourceConsumptionLimits" })
  public void testReplaceLogForwardingConfig() throws Exception {
    try {
      ReplaceLogForwardingConfigOptions replaceLogForwardingConfigOptions = new ReplaceLogForwardingConfigOptions.Builder()
        .instanceId(instanceId)
        .enabled(true)
        .sources(java.util.Arrays.asList("spark-driver", "spark-executor"))
        .tags(java.util.Arrays.asList("<tag_1>", "<tag_2>", "<tag_n"))
        .build();

      // Invoke operation
      Response<LogForwardingConfigResponse> response = service.replaceLogForwardingConfig(replaceLogForwardingConfigOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      LogForwardingConfigResponse logForwardingConfigResponseResult = response.getResult();

      assertNotNull(logForwardingConfigResponseResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testReplaceLogForwardingConfig" })
  public void testGetLogForwardingConfig() throws Exception {
    try {
      GetLogForwardingConfigOptions getLogForwardingConfigOptions = new GetLogForwardingConfigOptions.Builder()
        .instanceId(instanceId)
        .build();

      // Invoke operation
      Response<LogForwardingConfigResponse> response = service.getLogForwardingConfig(getLogForwardingConfigOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      LogForwardingConfigResponse logForwardingConfigResponseResult = response.getResult();

      assertNotNull(logForwardingConfigResponseResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetLogForwardingConfig" })
  public void testConfigurePlatformLogging() throws Exception {
    try {
      ConfigurePlatformLoggingOptions configurePlatformLoggingOptions = new ConfigurePlatformLoggingOptions.Builder()
        .instanceGuid(instanceId)
        .enable(true)
        .build();

      // Invoke operation
      Response<LoggingConfigurationResponse> response = service.configurePlatformLogging(configurePlatformLoggingOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 201);

      LoggingConfigurationResponse loggingConfigurationResponseResult = response.getResult();

      assertNotNull(loggingConfigurationResponseResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testConfigurePlatformLogging" })
  public void testGetLoggingConfiguration() throws Exception {
    try {
      GetLoggingConfigurationOptions getLoggingConfigurationOptions = new GetLoggingConfigurationOptions.Builder()
        .instanceGuid(instanceId)
        .build();

      // Invoke operation
      Response<LoggingConfigurationResponse> response = service.getLoggingConfiguration(getLoggingConfigurationOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      LoggingConfigurationResponse loggingConfigurationResponseResult = response.getResult();

      assertNotNull(loggingConfigurationResponseResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetLoggingConfiguration" })
  public void testStartSparkHistoryServer() throws Exception {
    try {
      StartSparkHistoryServerOptions startSparkHistoryServerOptions = new StartSparkHistoryServerOptions.Builder()
        .instanceId(instanceId)
        .build();

      // Invoke operation
      Response<SparkHistoryServerResponse> response = service.startSparkHistoryServer(startSparkHistoryServerOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 202);

      SparkHistoryServerResponse sparkHistoryServerResponseResult = response.getResult();

      assertNotNull(sparkHistoryServerResponseResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testStartSparkHistoryServer" })
  public void testGetSparkHistoryServer() throws Exception {
    try {
      GetSparkHistoryServerOptions getSparkHistoryServerOptions = new GetSparkHistoryServerOptions.Builder()
        .instanceId(instanceId)
        .build();

      // Invoke operation
      Response<SparkHistoryServerResponse> response = service.getSparkHistoryServer(getSparkHistoryServerOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      SparkHistoryServerResponse sparkHistoryServerResponseResult = response.getResult();

      assertNotNull(sparkHistoryServerResponseResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetSparkHistoryServer" })
  public void testDeleteApplication() throws Exception {
    try {
      DeleteApplicationOptions deleteApplicationOptions = new DeleteApplicationOptions.Builder()
        .instanceId(instanceId)
        .applicationId(applicationId)
        .build();

      // Invoke operation
      Response<Void> response = service.deleteApplication(deleteApplicationOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 204);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testDeleteApplication" })
  public void testStopSparkHistoryServer() throws Exception {
    try {
      StopSparkHistoryServerOptions stopSparkHistoryServerOptions = new StopSparkHistoryServerOptions.Builder()
        .instanceId(instanceId)
        .build();

      // Invoke operation
      Response<Void> response = service.stopSparkHistoryServer(stopSparkHistoryServerOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 204);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @AfterClass
  public void tearDown() {
    // Add any clean up logic here
    System.out.println("Clean up complete.");
  }
 }
