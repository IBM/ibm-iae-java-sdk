/*
 * (C) Copyright IBM Corp. 2020.
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

import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2.IbmAnalyticsEngineApi;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2.model.AnalyticsEngine;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2.model.AnalyticsEngineClusterNode;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2.model.AnalyticsEngineCreateCustomizationResponse;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2.model.AnalyticsEngineCustomAction;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2.model.AnalyticsEngineCustomActionScript;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2.model.AnalyticsEngineCustomizationRequestCollectionItem;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2.model.AnalyticsEngineCustomizationRunDetails;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2.model.AnalyticsEngineCustomizationRunDetailsRunDetails;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2.model.AnalyticsEngineLoggingConfigDetails;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2.model.AnalyticsEngineLoggingConfigStatus;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2.model.AnalyticsEngineLoggingNodeSpec;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2.model.AnalyticsEngineLoggingServer;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2.model.AnalyticsEngineNodeLevelCustomizationRunDetails;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2.model.AnalyticsEngineResetClusterPasswordResponse;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2.model.AnalyticsEngineResetClusterPasswordResponseUserCredentials;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2.model.AnalyticsEngineResizeClusterResponse;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2.model.AnalyticsEngineState;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2.model.AnalyticsEngineUserCredentials;
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
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2.model.ServiceEndpoints;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.NoAuthAuthenticator;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;

import com.ibm.cloud.sdk.core.util.EnvironmentUtils;

import java.io.IOException;
import java.io.InputStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;

import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.testng.PowerMockTestCase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the IbmAnalyticsEngineApi service.
 */
@PrepareForTest({ EnvironmentUtils.class })
@PowerMockIgnore("javax.net.ssl.*")
public class IbmAnalyticsEngineApiTest extends PowerMockTestCase {

  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();
  
  protected MockWebServer server;
  protected IbmAnalyticsEngineApi testService;

  // Creates a mock set of environment variables that are returned by EnvironmentUtils.getenv().
  private Map<String, String> getTestProcessEnvironment() {
    Map<String, String> env = new HashMap<>();
    env.put("TESTSERVICE_AUTH_TYPE", "noAuth");
    return env;
  }

  public void constructClientService() throws Throwable {
    PowerMockito.spy(EnvironmentUtils.class);
    PowerMockito.when(EnvironmentUtils.getenv()).thenReturn(getTestProcessEnvironment());
    final String serviceName = "testService";

    testService = IbmAnalyticsEngineApi.newInstance(serviceName);
    String url = server.url("/").toString();
    testService.setServiceUrl(url);
  }

  /**
  * Negative Test - construct the service with a null authenticator.
  */
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testConstructorWithNullAuthenticator() throws Throwable {
    final String serviceName = "testService";

    new IbmAnalyticsEngineApi(serviceName, null);
  }

  @Test
  public void testGetAllAnalyticsEnginesWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String getAllAnalyticsEnginesPath = "/v2/analytics_engines";

    server.enqueue(new MockResponse()
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetAllAnalyticsEnginesOptions model
    GetAllAnalyticsEnginesOptions getAllAnalyticsEnginesOptionsModel = new GetAllAnalyticsEnginesOptions();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = testService.getAllAnalyticsEngines(getAllAnalyticsEnginesOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getAllAnalyticsEnginesPath);
  }

  @Test
  public void testGetAnalyticsEngineByIdWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"name\": \"name\", \"service_plan\": \"servicePlan\", \"hardware_size\": \"hardwareSize\", \"software_package\": \"softwarePackage\", \"domain\": \"domain\", \"creation_time\": \"2019-01-01T12:00:00\", \"commision_time\": \"2019-01-01T12:00:00\", \"decommision_time\": \"2019-01-01T12:00:00\", \"deletion_time\": \"2019-01-01T12:00:00\", \"state_change_time\": \"2019-01-01T12:00:00\", \"state\": \"state\", \"nodes\": [{\"id\": 2, \"fqdn\": \"fqdn\", \"type\": \"type\", \"state\": \"state\", \"public_ip\": \"publicIp\", \"private_ip\": \"privateIp\", \"state_change_time\": \"2019-01-01T12:00:00\", \"commission_time\": \"2019-01-01T12:00:00\"}], \"user_credentials\": {\"user\": \"user\"}, \"service_endpoints\": {\"phoenix_jdbc\": \"phoenixJdbc\", \"ambari_console\": \"ambariConsole\", \"livy\": \"livy\", \"spark_history_server\": \"sparkHistoryServer\", \"oozie_rest\": \"oozieRest\", \"hive_jdbc\": \"hiveJdbc\", \"notebook_gateway_websocket\": \"notebookGatewayWebsocket\", \"notebook_gateway\": \"notebookGateway\", \"webhdfs\": \"webhdfs\", \"ssh\": \"ssh\", \"spark_sql\": \"sparkSql\"}, \"service_endpoints_ip\": {\"phoenix_jdbc\": \"phoenixJdbc\", \"ambari_console\": \"ambariConsole\", \"livy\": \"livy\", \"spark_history_server\": \"sparkHistoryServer\", \"oozie_rest\": \"oozieRest\", \"hive_jdbc\": \"hiveJdbc\", \"notebook_gateway_websocket\": \"notebookGatewayWebsocket\", \"notebook_gateway\": \"notebookGateway\", \"webhdfs\": \"webhdfs\", \"ssh\": \"ssh\", \"spark_sql\": \"sparkSql\"}}";
    String getAnalyticsEngineByIdPath = "/v2/analytics_engines/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetAnalyticsEngineByIdOptions model
    GetAnalyticsEngineByIdOptions getAnalyticsEngineByIdOptionsModel = new GetAnalyticsEngineByIdOptions.Builder()
    .instanceGuid("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<AnalyticsEngine> response = testService.getAnalyticsEngineById(getAnalyticsEngineByIdOptionsModel).execute();
    assertNotNull(response);
    AnalyticsEngine responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getAnalyticsEngineByIdPath);
  }

  // Test the getAnalyticsEngineById operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetAnalyticsEngineByIdNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.getAnalyticsEngineById(null).execute();
  }

  @Test
  public void testGetAnalyticsEngineStateByIdWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"state\": \"state\"}";
    String getAnalyticsEngineStateByIdPath = "/v2/analytics_engines/testString/state";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetAnalyticsEngineStateByIdOptions model
    GetAnalyticsEngineStateByIdOptions getAnalyticsEngineStateByIdOptionsModel = new GetAnalyticsEngineStateByIdOptions.Builder()
    .instanceGuid("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<AnalyticsEngineState> response = testService.getAnalyticsEngineStateById(getAnalyticsEngineStateByIdOptionsModel).execute();
    assertNotNull(response);
    AnalyticsEngineState responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getAnalyticsEngineStateByIdPath);
  }

  // Test the getAnalyticsEngineStateById operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetAnalyticsEngineStateByIdNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.getAnalyticsEngineStateById(null).execute();
  }

  @Test
  public void testCreateCustomizationRequestWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"request_id\": 9}";
    String createCustomizationRequestPath = "/v2/analytics_engines/testString/customization_requests";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the AnalyticsEngineCustomActionScript model
    AnalyticsEngineCustomActionScript analyticsEngineCustomActionScriptModel = new AnalyticsEngineCustomActionScript.Builder()
    .sourceType("http")
    .scriptPath("testString")
    .sourceProps(new java.util.HashMap<String,Object>(){{put("foo", "testString"); }})
    .build();

    // Construct an instance of the AnalyticsEngineCustomAction model
    AnalyticsEngineCustomAction analyticsEngineCustomActionModel = new AnalyticsEngineCustomAction.Builder()
    .name("testString")
    .type("bootstrap")
    .script(analyticsEngineCustomActionScriptModel)
    .scriptParams(new ArrayList<String>(Arrays.asList("testString")))
    .build();

    // Construct an instance of the CreateCustomizationRequestOptions model
    CreateCustomizationRequestOptions createCustomizationRequestOptionsModel = new CreateCustomizationRequestOptions.Builder()
    .instanceGuid("testString")
    .target("all")
    .customActions(new ArrayList<AnalyticsEngineCustomAction>(Arrays.asList(analyticsEngineCustomActionModel)))
    .build();

    // Invoke operation with valid options model (positive test)
    Response<AnalyticsEngineCreateCustomizationResponse> response = testService.createCustomizationRequest(createCustomizationRequestOptionsModel).execute();
    assertNotNull(response);
    AnalyticsEngineCreateCustomizationResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createCustomizationRequestPath);
  }

  // Test the createCustomizationRequest operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateCustomizationRequestNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.createCustomizationRequest(null).execute();
  }

  @Test
  public void testGetAllCustomizationRequestsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "[{\"id\": \"id\"}]";
    String getAllCustomizationRequestsPath = "/v2/analytics_engines/testString/customization_requests";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetAllCustomizationRequestsOptions model
    GetAllCustomizationRequestsOptions getAllCustomizationRequestsOptionsModel = new GetAllCustomizationRequestsOptions.Builder()
    .instanceGuid("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<List<AnalyticsEngineCustomizationRequestCollectionItem>> response = testService.getAllCustomizationRequests(getAllCustomizationRequestsOptionsModel).execute();
    assertNotNull(response);
    List<AnalyticsEngineCustomizationRequestCollectionItem> responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getAllCustomizationRequestsPath);
  }

  // Test the getAllCustomizationRequests operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetAllCustomizationRequestsNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.getAllCustomizationRequests(null).execute();
  }

  @Test
  public void testGetCustomizationRequestByIdWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"run_status\": \"runStatus\", \"run_details\": {\"overall_status\": \"overallStatus\", \"details\": [{\"node_name\": \"nodeName\", \"node_type\": \"nodeType\", \"start_time\": \"startTime\", \"end_time\": \"endTime\", \"time_taken\": \"timeTaken\", \"status\": \"status\", \"log_file\": \"logFile\"}]}}";
    String getCustomizationRequestByIdPath = "/v2/analytics_engines/testString/customization_requests/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetCustomizationRequestByIdOptions model
    GetCustomizationRequestByIdOptions getCustomizationRequestByIdOptionsModel = new GetCustomizationRequestByIdOptions.Builder()
    .instanceGuid("testString")
    .requestId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<AnalyticsEngineCustomizationRunDetails> response = testService.getCustomizationRequestById(getCustomizationRequestByIdOptionsModel).execute();
    assertNotNull(response);
    AnalyticsEngineCustomizationRunDetails responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getCustomizationRequestByIdPath);
  }

  // Test the getCustomizationRequestById operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetCustomizationRequestByIdNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.getCustomizationRequestById(null).execute();
  }

  @Test
  public void testResizeClusterWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"request_id\": \"requestId\"}";
    String resizeClusterPath = "/v2/analytics_engines/testString/resize";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ResizeClusterOptions model
    ResizeClusterOptions resizeClusterOptionsModel = new ResizeClusterOptions.Builder()
    .instanceGuid("testString")
    .computeNodesCount(Long.valueOf("26"))
    .build();

    // Invoke operation with valid options model (positive test)
    Response<AnalyticsEngineResizeClusterResponse> response = testService.resizeCluster(resizeClusterOptionsModel).execute();
    assertNotNull(response);
    AnalyticsEngineResizeClusterResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, resizeClusterPath);
  }

  // Test the resizeCluster operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testResizeClusterNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.resizeCluster(null).execute();
  }

  @Test
  public void testResetClusterPasswordWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"user_credentials\": {\"user\": \"user\", \"password\": \"password\"}}";
    String resetClusterPasswordPath = "/v2/analytics_engines/testString/reset_password";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ResetClusterPasswordOptions model
    ResetClusterPasswordOptions resetClusterPasswordOptionsModel = new ResetClusterPasswordOptions.Builder()
    .instanceGuid("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<AnalyticsEngineResetClusterPasswordResponse> response = testService.resetClusterPassword(resetClusterPasswordOptionsModel).execute();
    assertNotNull(response);
    AnalyticsEngineResetClusterPasswordResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, resetClusterPasswordPath);
  }

  // Test the resetClusterPassword operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testResetClusterPasswordNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.resetClusterPassword(null).execute();
  }

  @Test
  public void testConfigureLoggingWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String configureLoggingPath = "/v2/analytics_engines/testString/log_config";

    server.enqueue(new MockResponse()
    .setResponseCode(202)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the AnalyticsEngineLoggingNodeSpec model
    AnalyticsEngineLoggingNodeSpec analyticsEngineLoggingNodeSpecModel = new AnalyticsEngineLoggingNodeSpec.Builder()
    .nodeType("management")
    .components(new ArrayList<String>(Arrays.asList("ambari-server")))
    .build();

    // Construct an instance of the AnalyticsEngineLoggingServer model
    AnalyticsEngineLoggingServer analyticsEngineLoggingServerModel = new AnalyticsEngineLoggingServer.Builder()
    .type("logdna")
    .credential("testString")
    .apiHost("testString")
    .logHost("testString")
    .owner("testString")
    .build();

    // Construct an instance of the ConfigureLoggingOptions model
    ConfigureLoggingOptions configureLoggingOptionsModel = new ConfigureLoggingOptions.Builder()
    .instanceGuid("testString")
    .logSpecs(new ArrayList<AnalyticsEngineLoggingNodeSpec>(Arrays.asList(analyticsEngineLoggingNodeSpecModel)))
    .logServer(analyticsEngineLoggingServerModel)
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = testService.configureLogging(configureLoggingOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, configureLoggingPath);
  }

  // Test the configureLogging operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testConfigureLoggingNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.configureLogging(null).execute();
  }

  @Test
  public void testGetLoggingConfigWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"log_specs\": [{\"node_type\": \"management\", \"components\": [\"ambari-server\"]}], \"log_server\": {\"type\": \"logdna\", \"credential\": \"credential\", \"api_host\": \"apiHost\", \"log_host\": \"logHost\", \"owner\": \"owner\"}, \"log_config_status\": [{\"node_type\": \"management\", \"node_id\": \"nodeId\", \"action\": \"action\", \"status\": \"status\"}]}";
    String getLoggingConfigPath = "/v2/analytics_engines/testString/log_config";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetLoggingConfigOptions model
    GetLoggingConfigOptions getLoggingConfigOptionsModel = new GetLoggingConfigOptions.Builder()
    .instanceGuid("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<AnalyticsEngineLoggingConfigDetails> response = testService.getLoggingConfig(getLoggingConfigOptionsModel).execute();
    assertNotNull(response);
    AnalyticsEngineLoggingConfigDetails responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getLoggingConfigPath);
  }

  // Test the getLoggingConfig operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetLoggingConfigNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.getLoggingConfig(null).execute();
  }

  @Test
  public void testDeleteLoggingConfigWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String deleteLoggingConfigPath = "/v2/analytics_engines/testString/log_config";

    server.enqueue(new MockResponse()
    .setResponseCode(202)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteLoggingConfigOptions model
    DeleteLoggingConfigOptions deleteLoggingConfigOptionsModel = new DeleteLoggingConfigOptions.Builder()
    .instanceGuid("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = testService.deleteLoggingConfig(deleteLoggingConfigOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteLoggingConfigPath);
  }

  // Test the deleteLoggingConfig operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteLoggingConfigNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.deleteLoggingConfig(null).execute();
  }

  /** Initialize the server */
  @BeforeMethod
  public void setUpMockServer() {
    try {
        server = new MockWebServer();
        // register handler
        server.start();
        }
    catch (IOException err) {
        fail("Failed to instantiate mock web server");
    }
  }

  @AfterMethod
  public void tearDownMockServer() throws IOException {
    server.shutdown();
    testService = null;
  }
}