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

import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.IbmAnalyticsEngineApi;
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
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.NoAuthAuthenticator;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.DateUtils;
import com.ibm.cloud.sdk.core.util.RequestUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the IbmAnalyticsEngineApi service.
 */
public class IbmAnalyticsEngineApiTest {

  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  protected MockWebServer server;
  protected IbmAnalyticsEngineApi ibmAnalyticsEngineApiService;

  // Construct the service with a null authenticator (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testConstructorWithNullAuthenticator() throws Throwable {
    final String serviceName = "testService";
    new IbmAnalyticsEngineApi(serviceName, null);
  }

  // Test the getServiceUrlForRegion() method
  @Test
  public void testGetServiceUrlForRegion() throws Throwable {
    assertNull(IbmAnalyticsEngineApi.getServiceUrlForRegion("INVALID_REGION"));
    assertEquals(IbmAnalyticsEngineApi.getServiceUrlForRegion("us-south"), "https://api.us-south.ae.cloud.ibm.com");
    assertEquals(IbmAnalyticsEngineApi.getServiceUrlForRegion("eu-de"), "https://api.eu-de.ae.cloud.ibm.com");
  }

  // Test the getInstance operation with a valid options model parameter
  @Test
  public void testGetInstanceWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"href\": \"href\", \"state\": \"creation_accepted\", \"state_change_time\": \"2021-01-30T08:30:00.000Z\", \"default_runtime\": {\"spark_version\": \"3.1\"}, \"instance_home\": {\"id\": \"id\", \"provider\": \"provider\", \"type\": \"type\", \"region\": \"region\", \"endpoint\": \"endpoint\", \"bucket\": \"bucket\", \"hmac_access_key\": \"hmacAccessKey\", \"hmac_secret_key\": \"hmacSecretKey\"}, \"default_config\": {\"key\": \"key\"}}";
    String getInstancePath = "/v3/analytics_engines/e64c907a-e82f-46fd-addc-ccfafbd28b09";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetInstanceOptions model
    GetInstanceOptions getInstanceOptionsModel = new GetInstanceOptions.Builder()
      .instanceId("e64c907a-e82f-46fd-addc-ccfafbd28b09")
      .build();

    // Invoke getInstance() with a valid options model and verify the result
    Response<Instance> response = ibmAnalyticsEngineApiService.getInstance(getInstanceOptionsModel).execute();
    assertNotNull(response);
    Instance responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getInstancePath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getInstance operation with and without retries enabled
  @Test
  public void testGetInstanceWRetries() throws Throwable {
    ibmAnalyticsEngineApiService.enableRetries(4, 30);
    testGetInstanceWOptions();

    ibmAnalyticsEngineApiService.disableRetries();
    testGetInstanceWOptions();
  }

  // Test the getInstance operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetInstanceNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    ibmAnalyticsEngineApiService.getInstance(null).execute();
  }

  // Test the getInstanceState operation with a valid options model parameter
  @Test
  public void testGetInstanceStateWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"state\": \"creation_accepted\"}";
    String getInstanceStatePath = "/v3/analytics_engines/e64c907a-e82f-46fd-addc-ccfafbd28b09/state";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetInstanceStateOptions model
    GetInstanceStateOptions getInstanceStateOptionsModel = new GetInstanceStateOptions.Builder()
      .instanceId("e64c907a-e82f-46fd-addc-ccfafbd28b09")
      .build();

    // Invoke getInstanceState() with a valid options model and verify the result
    Response<InstanceGetStateResponse> response = ibmAnalyticsEngineApiService.getInstanceState(getInstanceStateOptionsModel).execute();
    assertNotNull(response);
    InstanceGetStateResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getInstanceStatePath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getInstanceState operation with and without retries enabled
  @Test
  public void testGetInstanceStateWRetries() throws Throwable {
    ibmAnalyticsEngineApiService.enableRetries(4, 30);
    testGetInstanceStateWOptions();

    ibmAnalyticsEngineApiService.disableRetries();
    testGetInstanceStateWOptions();
  }

  // Test the getInstanceState operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetInstanceStateNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    ibmAnalyticsEngineApiService.getInstanceState(null).execute();
  }

  // Test the setInstanceHome operation with a valid options model parameter
  @Test
  public void testSetInstanceHomeWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"instance_id\": \"instanceId\", \"provider\": \"provider\", \"type\": \"type\", \"region\": \"region\", \"endpoint\": \"endpoint\", \"hmac_access_key\": \"hmacAccessKey\", \"hmac_secret_key\": \"hmacSecretKey\"}";
    String setInstanceHomePath = "/v3/analytics_engines/e64c907a-e82f-46fd-addc-ccfafbd28b09/instance_home";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the SetInstanceHomeOptions model
    SetInstanceHomeOptions setInstanceHomeOptionsModel = new SetInstanceHomeOptions.Builder()
      .instanceId("e64c907a-e82f-46fd-addc-ccfafbd28b09")
      .newInstanceId("testString")
      .newProvider("ibm-cos")
      .newType("objectstore")
      .newRegion("us-south")
      .newEndpoint("s3.direct.us-south.cloud-object-storage.appdomain.cloud")
      .newHmacAccessKey("b9****************************4b")
      .newHmacSecretKey("fa********************************************8a")
      .build();

    // Invoke setInstanceHome() with a valid options model and verify the result
    Response<InstanceHomeResponse> response = ibmAnalyticsEngineApiService.setInstanceHome(setInstanceHomeOptionsModel).execute();
    assertNotNull(response);
    InstanceHomeResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, setInstanceHomePath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the setInstanceHome operation with and without retries enabled
  @Test
  public void testSetInstanceHomeWRetries() throws Throwable {
    ibmAnalyticsEngineApiService.enableRetries(4, 30);
    testSetInstanceHomeWOptions();

    ibmAnalyticsEngineApiService.disableRetries();
    testSetInstanceHomeWOptions();
  }

  // Test the setInstanceHome operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testSetInstanceHomeNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    ibmAnalyticsEngineApiService.setInstanceHome(null).execute();
  }

  // Test the updateInstanceHomeCredentials operation with a valid options model parameter
  @Test
  public void testUpdateInstanceHomeCredentialsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"instance_id\": \"instanceId\", \"provider\": \"provider\", \"type\": \"type\", \"region\": \"region\", \"endpoint\": \"endpoint\", \"hmac_access_key\": \"hmacAccessKey\", \"hmac_secret_key\": \"hmacSecretKey\"}";
    String updateInstanceHomeCredentialsPath = "/v3/analytics_engines/e64c907a-e82f-46fd-addc-ccfafbd28b09/instance_home";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the UpdateInstanceHomeCredentialsOptions model
    UpdateInstanceHomeCredentialsOptions updateInstanceHomeCredentialsOptionsModel = new UpdateInstanceHomeCredentialsOptions.Builder()
      .instanceId("e64c907a-e82f-46fd-addc-ccfafbd28b09")
      .hmacAccessKey("b9****************************4b")
      .hmacSecretKey("fa********************************************8a")
      .build();

    // Invoke updateInstanceHomeCredentials() with a valid options model and verify the result
    Response<InstanceHomeResponse> response = ibmAnalyticsEngineApiService.updateInstanceHomeCredentials(updateInstanceHomeCredentialsOptionsModel).execute();
    assertNotNull(response);
    InstanceHomeResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PATCH");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateInstanceHomeCredentialsPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the updateInstanceHomeCredentials operation with and without retries enabled
  @Test
  public void testUpdateInstanceHomeCredentialsWRetries() throws Throwable {
    ibmAnalyticsEngineApiService.enableRetries(4, 30);
    testUpdateInstanceHomeCredentialsWOptions();

    ibmAnalyticsEngineApiService.disableRetries();
    testUpdateInstanceHomeCredentialsWOptions();
  }

  // Test the updateInstanceHomeCredentials operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateInstanceHomeCredentialsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    ibmAnalyticsEngineApiService.updateInstanceHomeCredentials(null).execute();
  }

  // Test the getInstanceDefaultConfigs operation with a valid options model parameter
  @Test
  public void testGetInstanceDefaultConfigsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"mapKey\": \"inner\"}";
    String getInstanceDefaultConfigsPath = "/v3/analytics_engines/e64c907a-e82f-46fd-addc-ccfafbd28b09/default_configs";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetInstanceDefaultConfigsOptions model
    GetInstanceDefaultConfigsOptions getInstanceDefaultConfigsOptionsModel = new GetInstanceDefaultConfigsOptions.Builder()
      .instanceId("e64c907a-e82f-46fd-addc-ccfafbd28b09")
      .build();

    // Invoke getInstanceDefaultConfigs() with a valid options model and verify the result
    Response<Map<String, String>> response = ibmAnalyticsEngineApiService.getInstanceDefaultConfigs(getInstanceDefaultConfigsOptionsModel).execute();
    assertNotNull(response);
    Map<String, String> responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getInstanceDefaultConfigsPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getInstanceDefaultConfigs operation with and without retries enabled
  @Test
  public void testGetInstanceDefaultConfigsWRetries() throws Throwable {
    ibmAnalyticsEngineApiService.enableRetries(4, 30);
    testGetInstanceDefaultConfigsWOptions();

    ibmAnalyticsEngineApiService.disableRetries();
    testGetInstanceDefaultConfigsWOptions();
  }

  // Test the getInstanceDefaultConfigs operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetInstanceDefaultConfigsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    ibmAnalyticsEngineApiService.getInstanceDefaultConfigs(null).execute();
  }

  // Test the replaceInstanceDefaultConfigs operation with a valid options model parameter
  @Test
  public void testReplaceInstanceDefaultConfigsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"mapKey\": \"inner\"}";
    String replaceInstanceDefaultConfigsPath = "/v3/analytics_engines/e64c907a-e82f-46fd-addc-ccfafbd28b09/default_configs";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ReplaceInstanceDefaultConfigsOptions model
    ReplaceInstanceDefaultConfigsOptions replaceInstanceDefaultConfigsOptionsModel = new ReplaceInstanceDefaultConfigsOptions.Builder()
      .instanceId("e64c907a-e82f-46fd-addc-ccfafbd28b09")
      .body(java.util.Collections.singletonMap("foo", "testString"))
      .build();

    // Invoke replaceInstanceDefaultConfigs() with a valid options model and verify the result
    Response<Map<String, String>> response = ibmAnalyticsEngineApiService.replaceInstanceDefaultConfigs(replaceInstanceDefaultConfigsOptionsModel).execute();
    assertNotNull(response);
    Map<String, String> responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, replaceInstanceDefaultConfigsPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the replaceInstanceDefaultConfigs operation with and without retries enabled
  @Test
  public void testReplaceInstanceDefaultConfigsWRetries() throws Throwable {
    ibmAnalyticsEngineApiService.enableRetries(4, 30);
    testReplaceInstanceDefaultConfigsWOptions();

    ibmAnalyticsEngineApiService.disableRetries();
    testReplaceInstanceDefaultConfigsWOptions();
  }

  // Test the replaceInstanceDefaultConfigs operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testReplaceInstanceDefaultConfigsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    ibmAnalyticsEngineApiService.replaceInstanceDefaultConfigs(null).execute();
  }

  // Test the updateInstanceDefaultConfigs operation with a valid options model parameter
  @Test
  public void testUpdateInstanceDefaultConfigsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"mapKey\": \"inner\"}";
    String updateInstanceDefaultConfigsPath = "/v3/analytics_engines/e64c907a-e82f-46fd-addc-ccfafbd28b09/default_configs";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the UpdateInstanceDefaultConfigsOptions model
    UpdateInstanceDefaultConfigsOptions updateInstanceDefaultConfigsOptionsModel = new UpdateInstanceDefaultConfigsOptions.Builder()
      .instanceId("e64c907a-e82f-46fd-addc-ccfafbd28b09")
      .body(java.util.Collections.singletonMap("anyKey", "anyValue"))
      .build();

    // Invoke updateInstanceDefaultConfigs() with a valid options model and verify the result
    Response<Map<String, String>> response = ibmAnalyticsEngineApiService.updateInstanceDefaultConfigs(updateInstanceDefaultConfigsOptionsModel).execute();
    assertNotNull(response);
    Map<String, String> responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PATCH");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateInstanceDefaultConfigsPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the updateInstanceDefaultConfigs operation with and without retries enabled
  @Test
  public void testUpdateInstanceDefaultConfigsWRetries() throws Throwable {
    ibmAnalyticsEngineApiService.enableRetries(4, 30);
    testUpdateInstanceDefaultConfigsWOptions();

    ibmAnalyticsEngineApiService.disableRetries();
    testUpdateInstanceDefaultConfigsWOptions();
  }

  // Test the updateInstanceDefaultConfigs operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateInstanceDefaultConfigsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    ibmAnalyticsEngineApiService.updateInstanceDefaultConfigs(null).execute();
  }

  // Test the getInstanceDefaultRuntime operation with a valid options model parameter
  @Test
  public void testGetInstanceDefaultRuntimeWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"spark_version\": \"3.1\"}";
    String getInstanceDefaultRuntimePath = "/v3/analytics_engines/e64c907a-e82f-46fd-addc-ccfafbd28b09/default_runtime";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetInstanceDefaultRuntimeOptions model
    GetInstanceDefaultRuntimeOptions getInstanceDefaultRuntimeOptionsModel = new GetInstanceDefaultRuntimeOptions.Builder()
      .instanceId("e64c907a-e82f-46fd-addc-ccfafbd28b09")
      .build();

    // Invoke getInstanceDefaultRuntime() with a valid options model and verify the result
    Response<Runtime> response = ibmAnalyticsEngineApiService.getInstanceDefaultRuntime(getInstanceDefaultRuntimeOptionsModel).execute();
    assertNotNull(response);
    Runtime responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getInstanceDefaultRuntimePath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getInstanceDefaultRuntime operation with and without retries enabled
  @Test
  public void testGetInstanceDefaultRuntimeWRetries() throws Throwable {
    ibmAnalyticsEngineApiService.enableRetries(4, 30);
    testGetInstanceDefaultRuntimeWOptions();

    ibmAnalyticsEngineApiService.disableRetries();
    testGetInstanceDefaultRuntimeWOptions();
  }

  // Test the getInstanceDefaultRuntime operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetInstanceDefaultRuntimeNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    ibmAnalyticsEngineApiService.getInstanceDefaultRuntime(null).execute();
  }

  // Test the replaceInstanceDefaultRuntime operation with a valid options model parameter
  @Test
  public void testReplaceInstanceDefaultRuntimeWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"spark_version\": \"3.1\"}";
    String replaceInstanceDefaultRuntimePath = "/v3/analytics_engines/e64c907a-e82f-46fd-addc-ccfafbd28b09/default_runtime";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ReplaceInstanceDefaultRuntimeOptions model
    ReplaceInstanceDefaultRuntimeOptions replaceInstanceDefaultRuntimeOptionsModel = new ReplaceInstanceDefaultRuntimeOptions.Builder()
      .instanceId("e64c907a-e82f-46fd-addc-ccfafbd28b09")
      .sparkVersion("3.1")
      .build();

    // Invoke replaceInstanceDefaultRuntime() with a valid options model and verify the result
    Response<Runtime> response = ibmAnalyticsEngineApiService.replaceInstanceDefaultRuntime(replaceInstanceDefaultRuntimeOptionsModel).execute();
    assertNotNull(response);
    Runtime responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, replaceInstanceDefaultRuntimePath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the replaceInstanceDefaultRuntime operation with and without retries enabled
  @Test
  public void testReplaceInstanceDefaultRuntimeWRetries() throws Throwable {
    ibmAnalyticsEngineApiService.enableRetries(4, 30);
    testReplaceInstanceDefaultRuntimeWOptions();

    ibmAnalyticsEngineApiService.disableRetries();
    testReplaceInstanceDefaultRuntimeWOptions();
  }

  // Test the replaceInstanceDefaultRuntime operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testReplaceInstanceDefaultRuntimeNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    ibmAnalyticsEngineApiService.replaceInstanceDefaultRuntime(null).execute();
  }

  // Test the createApplication operation with a valid options model parameter
  @Test
  public void testCreateApplicationWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"state\": \"finished\"}";
    String createApplicationPath = "/v3/analytics_engines/e64c907a-e82f-46fd-addc-ccfafbd28b09/spark_applications";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(202)
      .setBody(mockResponseBody));

    // Construct an instance of the Runtime model
    Runtime runtimeModel = new Runtime.Builder()
      .sparkVersion("3.3")
      .build();

    // Construct an instance of the ApplicationRequestApplicationDetails model
    ApplicationRequestApplicationDetails applicationRequestApplicationDetailsModel = new ApplicationRequestApplicationDetails.Builder()
      .application("/opt/ibm/spark/examples/src/main/python/wordcount.py")
      .runtime(runtimeModel)
      .jars("cos://cloud-object-storage/jars/tests.jar")
      .packages("testString")
      .repositories("testString")
      .files("testString")
      .archives("testString")
      .name("spark-app")
      .xClass("com.company.path.ClassName")
      .arguments(java.util.Arrays.asList("/opt/ibm/spark/examples/src/main/resources/people.txt"))
      .conf(java.util.Collections.singletonMap("anyKey", "anyValue"))
      .env(java.util.Collections.singletonMap("anyKey", "anyValue"))
      .build();

    // Construct an instance of the CreateApplicationOptions model
    CreateApplicationOptions createApplicationOptionsModel = new CreateApplicationOptions.Builder()
      .instanceId("e64c907a-e82f-46fd-addc-ccfafbd28b09")
      .applicationDetails(applicationRequestApplicationDetailsModel)
      .build();

    // Invoke createApplication() with a valid options model and verify the result
    Response<ApplicationResponse> response = ibmAnalyticsEngineApiService.createApplication(createApplicationOptionsModel).execute();
    assertNotNull(response);
    ApplicationResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createApplicationPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the createApplication operation with and without retries enabled
  @Test
  public void testCreateApplicationWRetries() throws Throwable {
    ibmAnalyticsEngineApiService.enableRetries(4, 30);
    testCreateApplicationWOptions();

    ibmAnalyticsEngineApiService.disableRetries();
    testCreateApplicationWOptions();
  }

  // Test the createApplication operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateApplicationNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    ibmAnalyticsEngineApiService.createApplication(null).execute();
  }

  // Test the listApplications operation with a valid options model parameter
  @Test
  public void testListApplicationsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"applications\": [{\"id\": \"id\", \"href\": \"href\", \"runtime\": {\"spark_version\": \"3.1\"}, \"spark_application_id\": \"sparkApplicationId\", \"spark_application_name\": \"sparkApplicationName\", \"state\": \"finished\", \"spark_ui\": \"sparkUi\", \"submission_time\": \"2021-01-30T08:30:00.000Z\", \"start_time\": \"2021-01-30T08:30:00.000Z\", \"end_time\": \"2021-01-30T08:30:00.000Z\", \"finish_time\": \"2021-01-30T08:30:00.000Z\", \"auto_termination_time\": \"2021-01-30T08:30:00.000Z\"}], \"first\": {\"href\": \"href\", \"start\": \"start\"}, \"next\": {\"href\": \"href\", \"start\": \"start\"}, \"previous\": {\"href\": \"href\", \"start\": \"start\"}, \"limit\": 1}";
    String listApplicationsPath = "/v3/analytics_engines/e64c907a-e82f-46fd-addc-ccfafbd28b09/spark_applications";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ListApplicationsOptions model
    ListApplicationsOptions listApplicationsOptionsModel = new ListApplicationsOptions.Builder()
      .instanceId("e64c907a-e82f-46fd-addc-ccfafbd28b09")
      .state(java.util.Arrays.asList("finished"))
      .limit(Long.valueOf("10"))
      .start("testString")
      .build();

    // Invoke listApplications() with a valid options model and verify the result
    Response<ApplicationCollection> response = ibmAnalyticsEngineApiService.listApplications(listApplicationsOptionsModel).execute();
    assertNotNull(response);
    ApplicationCollection responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listApplicationsPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("state"), RequestUtils.join(java.util.Arrays.asList("finished"), ","));
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("10"));
    assertEquals(query.get("start"), "testString");
  }

  // Test the listApplications operation with and without retries enabled
  @Test
  public void testListApplicationsWRetries() throws Throwable {
    ibmAnalyticsEngineApiService.enableRetries(4, 30);
    testListApplicationsWOptions();

    ibmAnalyticsEngineApiService.disableRetries();
    testListApplicationsWOptions();
  }

  // Test the listApplications operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListApplicationsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    ibmAnalyticsEngineApiService.listApplications(null).execute();
  }

  // Test the listApplications operation using the ApplicationsPager.getNext() method
  @Test
  public void testListApplicationsWithPagerGetNext() throws Throwable {
    // Set up the two-page mock response.
    String mockResponsePage1 = "{\"next\":{\"start\":\"1\"},\"total_count\":2,\"limit\":1,\"applications\":[{\"id\":\"id\",\"href\":\"href\",\"runtime\":{\"spark_version\":\"3.1\"},\"spark_application_id\":\"sparkApplicationId\",\"spark_application_name\":\"sparkApplicationName\",\"state\":\"finished\",\"spark_ui\":\"sparkUi\",\"submission_time\":\"2021-01-30T08:30:00.000Z\",\"start_time\":\"2021-01-30T08:30:00.000Z\",\"end_time\":\"2021-01-30T08:30:00.000Z\",\"finish_time\":\"2021-01-30T08:30:00.000Z\",\"auto_termination_time\":\"2021-01-30T08:30:00.000Z\"}]}";
    String mockResponsePage2 = "{\"total_count\":2,\"limit\":1,\"applications\":[{\"id\":\"id\",\"href\":\"href\",\"runtime\":{\"spark_version\":\"3.1\"},\"spark_application_id\":\"sparkApplicationId\",\"spark_application_name\":\"sparkApplicationName\",\"state\":\"finished\",\"spark_ui\":\"sparkUi\",\"submission_time\":\"2021-01-30T08:30:00.000Z\",\"start_time\":\"2021-01-30T08:30:00.000Z\",\"end_time\":\"2021-01-30T08:30:00.000Z\",\"finish_time\":\"2021-01-30T08:30:00.000Z\",\"auto_termination_time\":\"2021-01-30T08:30:00.000Z\"}]}";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage1));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage2));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(400)
      .setBody("{\"message\": \"No more results available!\"}"));

    ListApplicationsOptions listApplicationsOptions = new ListApplicationsOptions.Builder()
      .instanceId("e64c907a-e82f-46fd-addc-ccfafbd28b09")
      .state(java.util.Arrays.asList("finished"))
      .limit(Long.valueOf("10"))
      .build();

    List<Application> allResults = new ArrayList<>();
    ApplicationsPager pager = new ApplicationsPager(ibmAnalyticsEngineApiService, listApplicationsOptions);
    while (pager.hasNext()) {
      List<Application> nextPage = pager.getNext();
      assertNotNull(nextPage);
      allResults.addAll(nextPage);
    }
    assertEquals(allResults.size(), 2);
  }
  
  // Test the listApplications operation using the ApplicationsPager.getAll() method
  @Test
  public void testListApplicationsWithPagerGetAll() throws Throwable {
    // Set up the two-page mock response.
    String mockResponsePage1 = "{\"next\":{\"start\":\"1\"},\"total_count\":2,\"limit\":1,\"applications\":[{\"id\":\"id\",\"href\":\"href\",\"runtime\":{\"spark_version\":\"3.1\"},\"spark_application_id\":\"sparkApplicationId\",\"spark_application_name\":\"sparkApplicationName\",\"state\":\"finished\",\"spark_ui\":\"sparkUi\",\"submission_time\":\"2021-01-30T08:30:00.000Z\",\"start_time\":\"2021-01-30T08:30:00.000Z\",\"end_time\":\"2021-01-30T08:30:00.000Z\",\"finish_time\":\"2021-01-30T08:30:00.000Z\",\"auto_termination_time\":\"2021-01-30T08:30:00.000Z\"}]}";
    String mockResponsePage2 = "{\"total_count\":2,\"limit\":1,\"applications\":[{\"id\":\"id\",\"href\":\"href\",\"runtime\":{\"spark_version\":\"3.1\"},\"spark_application_id\":\"sparkApplicationId\",\"spark_application_name\":\"sparkApplicationName\",\"state\":\"finished\",\"spark_ui\":\"sparkUi\",\"submission_time\":\"2021-01-30T08:30:00.000Z\",\"start_time\":\"2021-01-30T08:30:00.000Z\",\"end_time\":\"2021-01-30T08:30:00.000Z\",\"finish_time\":\"2021-01-30T08:30:00.000Z\",\"auto_termination_time\":\"2021-01-30T08:30:00.000Z\"}]}";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage1));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage2));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(400)
      .setBody("{\"message\": \"No more results available!\"}"));

    ListApplicationsOptions listApplicationsOptions = new ListApplicationsOptions.Builder()
      .instanceId("e64c907a-e82f-46fd-addc-ccfafbd28b09")
      .state(java.util.Arrays.asList("finished"))
      .limit(Long.valueOf("10"))
      .build();

    ApplicationsPager pager = new ApplicationsPager(ibmAnalyticsEngineApiService, listApplicationsOptions);
    List<Application> allResults = pager.getAll();
    assertNotNull(allResults);
    assertEquals(allResults.size(), 2);
  }
  
  // Test the getApplication operation with a valid options model parameter
  @Test
  public void testGetApplicationWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"application_details\": {\"application\": \"cos://bucket_name.my_cos/my_spark_app.py\", \"runtime\": {\"spark_version\": \"3.1\"}, \"jars\": \"cos://cloud-object-storage/jars/tests.jar\", \"packages\": \"packages\", \"repositories\": \"repositories\", \"files\": \"files\", \"archives\": \"archives\", \"name\": \"spark-app\", \"class\": \"com.company.path.ClassName\", \"arguments\": [\"[arg1, arg2, arg3]\"], \"conf\": {\"mapKey\": \"anyValue\"}, \"env\": {\"mapKey\": \"anyValue\"}}, \"id\": \"2b83d31c-397b-48ad-ad76-b83347c982db\", \"spark_application_id\": \"sparkApplicationId\", \"spark_application_name\": \"sparkApplicationName\", \"state\": \"finished\", \"spark_ui\": \"sparkUi\", \"state_details\": [{\"type\": \"server_error\", \"code\": \"server_error\", \"message\": \"message\"}], \"submission_time\": \"2021-01-30T08:30:00.000Z\", \"start_time\": \"2021-01-30T08:30:00.000Z\", \"end_time\": \"2021-01-30T08:30:00.000Z\", \"finish_time\": \"2021-01-30T08:30:00.000Z\", \"auto_termination_time\": \"2021-01-30T08:30:00.000Z\"}";
    String getApplicationPath = "/v3/analytics_engines/e64c907a-e82f-46fd-addc-ccfafbd28b09/spark_applications/ff48cc19-0e7e-4627-aac6-0b4ad080397b";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetApplicationOptions model
    GetApplicationOptions getApplicationOptionsModel = new GetApplicationOptions.Builder()
      .instanceId("e64c907a-e82f-46fd-addc-ccfafbd28b09")
      .applicationId("ff48cc19-0e7e-4627-aac6-0b4ad080397b")
      .build();

    // Invoke getApplication() with a valid options model and verify the result
    Response<ApplicationGetResponse> response = ibmAnalyticsEngineApiService.getApplication(getApplicationOptionsModel).execute();
    assertNotNull(response);
    ApplicationGetResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getApplicationPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getApplication operation with and without retries enabled
  @Test
  public void testGetApplicationWRetries() throws Throwable {
    ibmAnalyticsEngineApiService.enableRetries(4, 30);
    testGetApplicationWOptions();

    ibmAnalyticsEngineApiService.disableRetries();
    testGetApplicationWOptions();
  }

  // Test the getApplication operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetApplicationNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    ibmAnalyticsEngineApiService.getApplication(null).execute();
  }

  // Test the deleteApplication operation with a valid options model parameter
  @Test
  public void testDeleteApplicationWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteApplicationPath = "/v3/analytics_engines/e64c907a-e82f-46fd-addc-ccfafbd28b09/spark_applications/ff48cc19-0e7e-4627-aac6-0b4ad080397b";
    server.enqueue(new MockResponse()
      .setResponseCode(204)
      .setBody(mockResponseBody));

    // Construct an instance of the DeleteApplicationOptions model
    DeleteApplicationOptions deleteApplicationOptionsModel = new DeleteApplicationOptions.Builder()
      .instanceId("e64c907a-e82f-46fd-addc-ccfafbd28b09")
      .applicationId("ff48cc19-0e7e-4627-aac6-0b4ad080397b")
      .build();

    // Invoke deleteApplication() with a valid options model and verify the result
    Response<Void> response = ibmAnalyticsEngineApiService.deleteApplication(deleteApplicationOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteApplicationPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the deleteApplication operation with and without retries enabled
  @Test
  public void testDeleteApplicationWRetries() throws Throwable {
    ibmAnalyticsEngineApiService.enableRetries(4, 30);
    testDeleteApplicationWOptions();

    ibmAnalyticsEngineApiService.disableRetries();
    testDeleteApplicationWOptions();
  }

  // Test the deleteApplication operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteApplicationNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    ibmAnalyticsEngineApiService.deleteApplication(null).execute();
  }

  // Test the getApplicationState operation with a valid options model parameter
  @Test
  public void testGetApplicationStateWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"state\": \"finished\", \"start_time\": \"2021-01-30T08:30:00.000Z\", \"end_time\": \"2021-01-30T08:30:00.000Z\", \"finish_time\": \"2021-01-30T08:30:00.000Z\", \"auto_termination_time\": \"2021-01-30T08:30:00.000Z\"}";
    String getApplicationStatePath = "/v3/analytics_engines/e64c907a-e82f-46fd-addc-ccfafbd28b09/spark_applications/ff48cc19-0e7e-4627-aac6-0b4ad080397b/state";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetApplicationStateOptions model
    GetApplicationStateOptions getApplicationStateOptionsModel = new GetApplicationStateOptions.Builder()
      .instanceId("e64c907a-e82f-46fd-addc-ccfafbd28b09")
      .applicationId("ff48cc19-0e7e-4627-aac6-0b4ad080397b")
      .build();

    // Invoke getApplicationState() with a valid options model and verify the result
    Response<ApplicationGetStateResponse> response = ibmAnalyticsEngineApiService.getApplicationState(getApplicationStateOptionsModel).execute();
    assertNotNull(response);
    ApplicationGetStateResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getApplicationStatePath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getApplicationState operation with and without retries enabled
  @Test
  public void testGetApplicationStateWRetries() throws Throwable {
    ibmAnalyticsEngineApiService.enableRetries(4, 30);
    testGetApplicationStateWOptions();

    ibmAnalyticsEngineApiService.disableRetries();
    testGetApplicationStateWOptions();
  }

  // Test the getApplicationState operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetApplicationStateNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    ibmAnalyticsEngineApiService.getApplicationState(null).execute();
  }

  // Test the getCurrentResourceConsumption operation with a valid options model parameter
  @Test
  public void testGetCurrentResourceConsumptionWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"cores\": \"cores\", \"memory\": \"memory\"}";
    String getCurrentResourceConsumptionPath = "/v3/analytics_engines/e64c907a-e82f-46fd-addc-ccfafbd28b09/current_resource_consumption";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetCurrentResourceConsumptionOptions model
    GetCurrentResourceConsumptionOptions getCurrentResourceConsumptionOptionsModel = new GetCurrentResourceConsumptionOptions.Builder()
      .instanceId("e64c907a-e82f-46fd-addc-ccfafbd28b09")
      .build();

    // Invoke getCurrentResourceConsumption() with a valid options model and verify the result
    Response<CurrentResourceConsumptionResponse> response = ibmAnalyticsEngineApiService.getCurrentResourceConsumption(getCurrentResourceConsumptionOptionsModel).execute();
    assertNotNull(response);
    CurrentResourceConsumptionResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getCurrentResourceConsumptionPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getCurrentResourceConsumption operation with and without retries enabled
  @Test
  public void testGetCurrentResourceConsumptionWRetries() throws Throwable {
    ibmAnalyticsEngineApiService.enableRetries(4, 30);
    testGetCurrentResourceConsumptionWOptions();

    ibmAnalyticsEngineApiService.disableRetries();
    testGetCurrentResourceConsumptionWOptions();
  }

  // Test the getCurrentResourceConsumption operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetCurrentResourceConsumptionNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    ibmAnalyticsEngineApiService.getCurrentResourceConsumption(null).execute();
  }

  // Test the getResourceConsumptionLimits operation with a valid options model parameter
  @Test
  public void testGetResourceConsumptionLimitsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"max_cores\": \"maxCores\", \"max_memory\": \"maxMemory\"}";
    String getResourceConsumptionLimitsPath = "/v3/analytics_engines/e64c907a-e82f-46fd-addc-ccfafbd28b09/resource_consumption_limits";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetResourceConsumptionLimitsOptions model
    GetResourceConsumptionLimitsOptions getResourceConsumptionLimitsOptionsModel = new GetResourceConsumptionLimitsOptions.Builder()
      .instanceId("e64c907a-e82f-46fd-addc-ccfafbd28b09")
      .build();

    // Invoke getResourceConsumptionLimits() with a valid options model and verify the result
    Response<ResourceConsumptionLimitsResponse> response = ibmAnalyticsEngineApiService.getResourceConsumptionLimits(getResourceConsumptionLimitsOptionsModel).execute();
    assertNotNull(response);
    ResourceConsumptionLimitsResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getResourceConsumptionLimitsPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getResourceConsumptionLimits operation with and without retries enabled
  @Test
  public void testGetResourceConsumptionLimitsWRetries() throws Throwable {
    ibmAnalyticsEngineApiService.enableRetries(4, 30);
    testGetResourceConsumptionLimitsWOptions();

    ibmAnalyticsEngineApiService.disableRetries();
    testGetResourceConsumptionLimitsWOptions();
  }

  // Test the getResourceConsumptionLimits operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetResourceConsumptionLimitsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    ibmAnalyticsEngineApiService.getResourceConsumptionLimits(null).execute();
  }

  // Test the replaceLogForwardingConfig operation with a valid options model parameter
  @Test
  public void testReplaceLogForwardingConfigWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"sources\": [\"sources\"], \"tags\": [\"tags\"], \"log_server\": {\"type\": \"ibm-log-analysis\"}, \"enabled\": true}";
    String replaceLogForwardingConfigPath = "/v3/analytics_engines/e64c907a-e82f-46fd-addc-ccfafbd28b09/log_forwarding_config";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ReplaceLogForwardingConfigOptions model
    ReplaceLogForwardingConfigOptions replaceLogForwardingConfigOptionsModel = new ReplaceLogForwardingConfigOptions.Builder()
      .instanceId("e64c907a-e82f-46fd-addc-ccfafbd28b09")
      .enabled(true)
      .sources(java.util.Arrays.asList("spark-driver", "spark-executor"))
      .tags(java.util.Arrays.asList("<tag_1>", "<tag_2>", "<tag_n"))
      .build();

    // Invoke replaceLogForwardingConfig() with a valid options model and verify the result
    Response<LogForwardingConfigResponse> response = ibmAnalyticsEngineApiService.replaceLogForwardingConfig(replaceLogForwardingConfigOptionsModel).execute();
    assertNotNull(response);
    LogForwardingConfigResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, replaceLogForwardingConfigPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the replaceLogForwardingConfig operation with and without retries enabled
  @Test
  public void testReplaceLogForwardingConfigWRetries() throws Throwable {
    ibmAnalyticsEngineApiService.enableRetries(4, 30);
    testReplaceLogForwardingConfigWOptions();

    ibmAnalyticsEngineApiService.disableRetries();
    testReplaceLogForwardingConfigWOptions();
  }

  // Test the replaceLogForwardingConfig operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testReplaceLogForwardingConfigNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    ibmAnalyticsEngineApiService.replaceLogForwardingConfig(null).execute();
  }

  // Test the getLogForwardingConfig operation with a valid options model parameter
  @Test
  public void testGetLogForwardingConfigWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"sources\": [\"sources\"], \"tags\": [\"tags\"], \"log_server\": {\"type\": \"ibm-log-analysis\"}, \"enabled\": true}";
    String getLogForwardingConfigPath = "/v3/analytics_engines/e64c907a-e82f-46fd-addc-ccfafbd28b09/log_forwarding_config";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetLogForwardingConfigOptions model
    GetLogForwardingConfigOptions getLogForwardingConfigOptionsModel = new GetLogForwardingConfigOptions.Builder()
      .instanceId("e64c907a-e82f-46fd-addc-ccfafbd28b09")
      .build();

    // Invoke getLogForwardingConfig() with a valid options model and verify the result
    Response<LogForwardingConfigResponse> response = ibmAnalyticsEngineApiService.getLogForwardingConfig(getLogForwardingConfigOptionsModel).execute();
    assertNotNull(response);
    LogForwardingConfigResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getLogForwardingConfigPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getLogForwardingConfig operation with and without retries enabled
  @Test
  public void testGetLogForwardingConfigWRetries() throws Throwable {
    ibmAnalyticsEngineApiService.enableRetries(4, 30);
    testGetLogForwardingConfigWOptions();

    ibmAnalyticsEngineApiService.disableRetries();
    testGetLogForwardingConfigWOptions();
  }

  // Test the getLogForwardingConfig operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetLogForwardingConfigNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    ibmAnalyticsEngineApiService.getLogForwardingConfig(null).execute();
  }

  // Test the configurePlatformLogging operation with a valid options model parameter
  @Test
  public void testConfigurePlatformLoggingWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"components\": [\"components\"], \"log_server\": {\"type\": \"ibm-log-analysis\"}, \"enable\": true}";
    String configurePlatformLoggingPath = "/v3/analytics_engines/e64c907a-e82f-46fd-addc-ccfafbd28b09/logging";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(201)
      .setBody(mockResponseBody));

    // Construct an instance of the ConfigurePlatformLoggingOptions model
    ConfigurePlatformLoggingOptions configurePlatformLoggingOptionsModel = new ConfigurePlatformLoggingOptions.Builder()
      .instanceGuid("e64c907a-e82f-46fd-addc-ccfafbd28b09")
      .enable(true)
      .build();

    // Invoke configurePlatformLogging() with a valid options model and verify the result
    Response<LoggingConfigurationResponse> response = ibmAnalyticsEngineApiService.configurePlatformLogging(configurePlatformLoggingOptionsModel).execute();
    assertNotNull(response);
    LoggingConfigurationResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, configurePlatformLoggingPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the configurePlatformLogging operation with and without retries enabled
  @Test
  public void testConfigurePlatformLoggingWRetries() throws Throwable {
    ibmAnalyticsEngineApiService.enableRetries(4, 30);
    testConfigurePlatformLoggingWOptions();

    ibmAnalyticsEngineApiService.disableRetries();
    testConfigurePlatformLoggingWOptions();
  }

  // Test the configurePlatformLogging operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testConfigurePlatformLoggingNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    ibmAnalyticsEngineApiService.configurePlatformLogging(null).execute();
  }

  // Test the getLoggingConfiguration operation with a valid options model parameter
  @Test
  public void testGetLoggingConfigurationWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"components\": [\"components\"], \"log_server\": {\"type\": \"ibm-log-analysis\"}, \"enable\": true}";
    String getLoggingConfigurationPath = "/v3/analytics_engines/e64c907a-e82f-46fd-addc-ccfafbd28b09/logging";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetLoggingConfigurationOptions model
    GetLoggingConfigurationOptions getLoggingConfigurationOptionsModel = new GetLoggingConfigurationOptions.Builder()
      .instanceGuid("e64c907a-e82f-46fd-addc-ccfafbd28b09")
      .build();

    // Invoke getLoggingConfiguration() with a valid options model and verify the result
    Response<LoggingConfigurationResponse> response = ibmAnalyticsEngineApiService.getLoggingConfiguration(getLoggingConfigurationOptionsModel).execute();
    assertNotNull(response);
    LoggingConfigurationResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getLoggingConfigurationPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getLoggingConfiguration operation with and without retries enabled
  @Test
  public void testGetLoggingConfigurationWRetries() throws Throwable {
    ibmAnalyticsEngineApiService.enableRetries(4, 30);
    testGetLoggingConfigurationWOptions();

    ibmAnalyticsEngineApiService.disableRetries();
    testGetLoggingConfigurationWOptions();
  }

  // Test the getLoggingConfiguration operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetLoggingConfigurationNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    ibmAnalyticsEngineApiService.getLoggingConfiguration(null).execute();
  }

  // Test the startSparkHistoryServer operation with a valid options model parameter
  @Test
  public void testStartSparkHistoryServerWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"state\": \"started\", \"cores\": \"1\", \"memory\": \"4G\", \"start_time\": \"2022-12-02T08:30:00.000Z\", \"stop_time\": \"2022-12-02T10:30:00.000Z\", \"auto_termination_time\": \"2022-12-05T08:30:00.000Z\"}";
    String startSparkHistoryServerPath = "/v3/analytics_engines/e64c907a-e82f-46fd-addc-ccfafbd28b09/spark_history_server";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(202)
      .setBody(mockResponseBody));

    // Construct an instance of the StartSparkHistoryServerOptions model
    StartSparkHistoryServerOptions startSparkHistoryServerOptionsModel = new StartSparkHistoryServerOptions.Builder()
      .instanceId("e64c907a-e82f-46fd-addc-ccfafbd28b09")
      .build();

    // Invoke startSparkHistoryServer() with a valid options model and verify the result
    Response<SparkHistoryServerResponse> response = ibmAnalyticsEngineApiService.startSparkHistoryServer(startSparkHistoryServerOptionsModel).execute();
    assertNotNull(response);
    SparkHistoryServerResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, startSparkHistoryServerPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the startSparkHistoryServer operation with and without retries enabled
  @Test
  public void testStartSparkHistoryServerWRetries() throws Throwable {
    ibmAnalyticsEngineApiService.enableRetries(4, 30);
    testStartSparkHistoryServerWOptions();

    ibmAnalyticsEngineApiService.disableRetries();
    testStartSparkHistoryServerWOptions();
  }

  // Test the startSparkHistoryServer operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testStartSparkHistoryServerNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    ibmAnalyticsEngineApiService.startSparkHistoryServer(null).execute();
  }

  // Test the getSparkHistoryServer operation with a valid options model parameter
  @Test
  public void testGetSparkHistoryServerWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"state\": \"started\", \"cores\": \"1\", \"memory\": \"4G\", \"start_time\": \"2022-12-02T08:30:00.000Z\", \"stop_time\": \"2022-12-02T10:30:00.000Z\", \"auto_termination_time\": \"2022-12-05T08:30:00.000Z\"}";
    String getSparkHistoryServerPath = "/v3/analytics_engines/e64c907a-e82f-46fd-addc-ccfafbd28b09/spark_history_server";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetSparkHistoryServerOptions model
    GetSparkHistoryServerOptions getSparkHistoryServerOptionsModel = new GetSparkHistoryServerOptions.Builder()
      .instanceId("e64c907a-e82f-46fd-addc-ccfafbd28b09")
      .build();

    // Invoke getSparkHistoryServer() with a valid options model and verify the result
    Response<SparkHistoryServerResponse> response = ibmAnalyticsEngineApiService.getSparkHistoryServer(getSparkHistoryServerOptionsModel).execute();
    assertNotNull(response);
    SparkHistoryServerResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getSparkHistoryServerPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getSparkHistoryServer operation with and without retries enabled
  @Test
  public void testGetSparkHistoryServerWRetries() throws Throwable {
    ibmAnalyticsEngineApiService.enableRetries(4, 30);
    testGetSparkHistoryServerWOptions();

    ibmAnalyticsEngineApiService.disableRetries();
    testGetSparkHistoryServerWOptions();
  }

  // Test the getSparkHistoryServer operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetSparkHistoryServerNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    ibmAnalyticsEngineApiService.getSparkHistoryServer(null).execute();
  }

  // Test the stopSparkHistoryServer operation with a valid options model parameter
  @Test
  public void testStopSparkHistoryServerWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String stopSparkHistoryServerPath = "/v3/analytics_engines/e64c907a-e82f-46fd-addc-ccfafbd28b09/spark_history_server";
    server.enqueue(new MockResponse()
      .setResponseCode(204)
      .setBody(mockResponseBody));

    // Construct an instance of the StopSparkHistoryServerOptions model
    StopSparkHistoryServerOptions stopSparkHistoryServerOptionsModel = new StopSparkHistoryServerOptions.Builder()
      .instanceId("e64c907a-e82f-46fd-addc-ccfafbd28b09")
      .build();

    // Invoke stopSparkHistoryServer() with a valid options model and verify the result
    Response<Void> response = ibmAnalyticsEngineApiService.stopSparkHistoryServer(stopSparkHistoryServerOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, stopSparkHistoryServerPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the stopSparkHistoryServer operation with and without retries enabled
  @Test
  public void testStopSparkHistoryServerWRetries() throws Throwable {
    ibmAnalyticsEngineApiService.enableRetries(4, 30);
    testStopSparkHistoryServerWOptions();

    ibmAnalyticsEngineApiService.disableRetries();
    testStopSparkHistoryServerWOptions();
  }

  // Test the stopSparkHistoryServer operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testStopSparkHistoryServerNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    ibmAnalyticsEngineApiService.stopSparkHistoryServer(null).execute();
  }

  // Perform setup needed before each test method
  @BeforeMethod
  public void beforeEachTest() {
    // Start the mock server.
    try {
      server = new MockWebServer();
      server.start();
    } catch (IOException err) {
      fail("Failed to instantiate mock web server");
    }

    // Construct an instance of the service
    constructClientService();
  }

  // Perform tear down after each test method
  @AfterMethod
  public void afterEachTest() throws IOException {
    server.shutdown();
    ibmAnalyticsEngineApiService = null;
  }

  // Constructs an instance of the service to be used by the tests
  public void constructClientService() {
    System.setProperty("TESTSERVICE_AUTH_TYPE", "noAuth");
    final String serviceName = "testService";

    ibmAnalyticsEngineApiService = IbmAnalyticsEngineApi.newInstance(serviceName);
    String url = server.url("/").toString();
    ibmAnalyticsEngineApiService.setServiceUrl(url);
  }
}