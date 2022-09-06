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

import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.Application;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.ApplicationCollection;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.ApplicationDetails;
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
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.InstanceDefaultConfig;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.InstanceDefaultRuntime;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.InstanceGetStateResponse;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.InstanceHome;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.InstanceHomeResponse;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.ListApplicationsOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.LogForwardingConfigResponse;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.LogForwardingConfigResponseLogServer;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.LoggingConfigurationResponse;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.LoggingConfigurationResponseLogServer;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.ReplaceInstanceDefaultConfigsOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.ReplaceLogForwardingConfigOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.SetInstanceHomeOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.UpdateInstanceDefaultConfigsOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.utils.TestUtilities;
import com.ibm.cloud.iaesdk.test.SdkIntegrationTestBase;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.CredentialUtils;
import java.io.InputStream;
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

    service.enableRetries(4, 30);

    System.out.println("Setup complete.");
  }

  @Test
  public void testGetInstance() throws Exception {
    try {
      GetInstanceOptions getInstanceOptions = new GetInstanceOptions.Builder()
        .instanceId("e64c907a-e82f-46fd-addc-ccfafbd28b09")
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

  @Test
  public void testGetInstanceState() throws Exception {
    try {
      GetInstanceStateOptions getInstanceStateOptions = new GetInstanceStateOptions.Builder()
        .instanceId("e64c907a-e82f-46fd-addc-ccfafbd28b09")
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

  @Test
  public void testSetInstanceHome() throws Exception {
    try {
      SetInstanceHomeOptions setInstanceHomeOptions = new SetInstanceHomeOptions.Builder()
        .instanceId("e64c907a-e82f-46fd-addc-ccfafbd28b09")
        .newInstanceId("testString")
        .newProvider("ibm-cos")
        .newType("objectstore")
        .newRegion("us-south")
        .newEndpoint("s3.direct.us-south.cloud-object-storage.appdomain.cloud")
        .newHmacAccessKey("821**********0ae")
        .newHmacSecretKey("03e****************4fc3")
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

  @Test
  public void testGetInstanceDefaultConfigs() throws Exception {
    try {
      GetInstanceDefaultConfigsOptions getInstanceDefaultConfigsOptions = new GetInstanceDefaultConfigsOptions.Builder()
        .instanceId("e64c907a-e82f-46fd-addc-ccfafbd28b09")
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

  @Test
  public void testReplaceInstanceDefaultConfigs() throws Exception {
    try {
      ReplaceInstanceDefaultConfigsOptions replaceInstanceDefaultConfigsOptions = new ReplaceInstanceDefaultConfigsOptions.Builder()
        .instanceId("e64c907a-e82f-46fd-addc-ccfafbd28b09")
        .body(new java.util.HashMap<String, String>() { { put("foo", "testString"); } })
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

  @Test
  public void testUpdateInstanceDefaultConfigs() throws Exception {
    try {
      UpdateInstanceDefaultConfigsOptions updateInstanceDefaultConfigsOptions = new UpdateInstanceDefaultConfigsOptions.Builder()
        .instanceId("e64c907a-e82f-46fd-addc-ccfafbd28b09")
        .body(new java.util.HashMap<String, Object>() { { put("foo", "bar"); } })
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

  @Test
  public void testCreateApplication() throws Exception {
    try {
      ApplicationRequestApplicationDetails applicationRequestApplicationDetailsModel = new ApplicationRequestApplicationDetails.Builder()
        .application("cos://bucket_name.my_cos/my_spark_app.py")
        .jars("cos://cloud-object-storage/jars/tests.jar")
        .packages("testString")
        .repositories("testString")
        .files("testString")
        .archives("testString")
        .name("spark-app")
        .xClass("com.company.path.ClassName")
        .arguments(java.util.Arrays.asList("[arg1, arg2, arg3]"))
        .conf(new java.util.HashMap<String, Object>() { { put("foo", "testString"); } })
        .env(new java.util.HashMap<String, Object>() { { put("foo", "testString"); } })
        .build();

      CreateApplicationOptions createApplicationOptions = new CreateApplicationOptions.Builder()
        .instanceId("e64c907a-e82f-46fd-addc-ccfafbd28b09")
        .applicationDetails(applicationRequestApplicationDetailsModel)
        .build();

      // Invoke operation
      Response<ApplicationResponse> response = service.createApplication(createApplicationOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 202);

      ApplicationResponse applicationResponseResult = response.getResult();

      assertNotNull(applicationResponseResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testListApplications() throws Exception {
    try {
      ListApplicationsOptions listApplicationsOptions = new ListApplicationsOptions.Builder()
        .instanceId("e64c907a-e82f-46fd-addc-ccfafbd28b09")
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

  @Test
  public void testGetApplication() throws Exception {
    try {
      GetApplicationOptions getApplicationOptions = new GetApplicationOptions.Builder()
        .instanceId("e64c907a-e82f-46fd-addc-ccfafbd28b09")
        .applicationId("ff48cc19-0e7e-4627-aac6-0b4ad080397b")
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

  @Test
  public void testGetApplicationState() throws Exception {
    try {
      GetApplicationStateOptions getApplicationStateOptions = new GetApplicationStateOptions.Builder()
        .instanceId("e64c907a-e82f-46fd-addc-ccfafbd28b09")
        .applicationId("ff48cc19-0e7e-4627-aac6-0b4ad080397b")
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

  @Test
  public void testGetCurrentResourceConsumption() throws Exception {
    try {
      GetCurrentResourceConsumptionOptions getCurrentResourceConsumptionOptions = new GetCurrentResourceConsumptionOptions.Builder()
        .instanceId("e64c907a-e82f-46fd-addc-ccfafbd28b09")
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

  @Test
  public void testReplaceLogForwardingConfig() throws Exception {
    try {
      ReplaceLogForwardingConfigOptions replaceLogForwardingConfigOptions = new ReplaceLogForwardingConfigOptions.Builder()
        .instanceId("e64c907a-e82f-46fd-addc-ccfafbd28b09")
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

  @Test
  public void testGetLogForwardingConfig() throws Exception {
    try {
      GetLogForwardingConfigOptions getLogForwardingConfigOptions = new GetLogForwardingConfigOptions.Builder()
        .instanceId("e64c907a-e82f-46fd-addc-ccfafbd28b09")
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

  @Test
  public void testConfigurePlatformLogging() throws Exception {
    try {
      ConfigurePlatformLoggingOptions configurePlatformLoggingOptions = new ConfigurePlatformLoggingOptions.Builder()
        .instanceGuid("e64c907a-e82f-46fd-addc-ccfafbd28b09")
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

  @Test
  public void testGetLoggingConfiguration() throws Exception {
    try {
      GetLoggingConfigurationOptions getLoggingConfigurationOptions = new GetLoggingConfigurationOptions.Builder()
        .instanceGuid("e64c907a-e82f-46fd-addc-ccfafbd28b09")
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

  @Test
  public void testDeleteApplication() throws Exception {
    try {
      DeleteApplicationOptions deleteApplicationOptions = new DeleteApplicationOptions.Builder()
        .instanceId("e64c907a-e82f-46fd-addc-ccfafbd28b09")
        .applicationId("ff48cc19-0e7e-4627-aac6-0b4ad080397b")
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

  @AfterClass
  public void tearDown() {
    // Add any clean up logic here
    System.out.println("Clean up complete.");
  }
 }
