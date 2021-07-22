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
package com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3;

import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.IbmAnalyticsEngineApi;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.ApplicationCollection;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.ApplicationDetails;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.ApplicationGetResponse;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.ApplicationGetStateResponse;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.ApplicationRequest;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.ApplicationRequestApplicationDetails;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.ApplicationResponse;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.CreateApplicationOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.DeleteApplicationByIdOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.GetApplicationByIdOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.GetApplicationStateOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.GetApplicationsOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.GetInstanceByIdOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.InstanceDetails;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.InstanceDetailsDefaultConfig;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.InstanceDetailsDefaultRuntime;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.InstanceDetailsInstanceHome;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.utils.TestUtilities;
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
@PowerMockIgnore({"javax.net.ssl.*", "org.mockito.*"})
public class IbmAnalyticsEngineApiTest extends PowerMockTestCase {

  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  protected MockWebServer server;
  protected IbmAnalyticsEngineApi ibmAnalyticsEngineApiService;

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

    ibmAnalyticsEngineApiService = IbmAnalyticsEngineApi.newInstance(serviceName);
    String url = server.url("/").toString();
    ibmAnalyticsEngineApiService.setServiceUrl(url);
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
  public void testGetInstanceByIdWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"instance_id\": \"instanceId\", \"state\": \"created\", \"state_change_time\": \"2019-01-01T12:00:00.000Z\", \"default_runtime\": {\"spark_version\": \"sparkVersion\", \"additional_packages\": [\"additionalPackages\"]}, \"instance_home\": {\"guid\": \"guid\", \"provider\": \"provider\", \"type\": \"type\", \"region\": \"region\", \"endpoint\": \"endpoint\", \"bucket\": \"bucket\", \"hmac_access_key\": \"hmacAccessKey\", \"hmac_secret_key\": \"hmacSecretKey\"}, \"default_config\": {\"key\": \"key\"}}";
    String getInstanceByIdPath = "/v3/analytics_engines/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetInstanceByIdOptions model
    GetInstanceByIdOptions getInstanceByIdOptionsModel = new GetInstanceByIdOptions.Builder()
    .instanceId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<InstanceDetails> response = ibmAnalyticsEngineApiService.getInstanceById(getInstanceByIdOptionsModel).execute();
    assertNotNull(response);
    InstanceDetails responseObj = response.getResult();
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
    assertEquals(parsedPath, getInstanceByIdPath);
  }

  // Test the getInstanceById operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetInstanceByIdNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    ibmAnalyticsEngineApiService.getInstanceById(null).execute();
  }

  @Test
  public void testCreateApplicationWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"application_id\": \"applicationId\", \"state\": \"accepted\", \"start_time\": \"2019-01-01T12:00:00.000Z\"}";
    String createApplicationPath = "/v3/analytics_engines/testString/spark/applications";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(201)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ApplicationRequestApplicationDetails model
    ApplicationRequestApplicationDetails applicationRequestApplicationDetailsModel = new ApplicationRequestApplicationDetails.Builder()
    .application("testString")
    .xClass("testString")
    .applicationArguments(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .conf(new java.util.HashMap<String, Object>() { { put("foo", "testString"); } })
    .env(new java.util.HashMap<String, Object>() { { put("foo", "testString"); } })
    .build();

    // Construct an instance of the CreateApplicationOptions model
    CreateApplicationOptions createApplicationOptionsModel = new CreateApplicationOptions.Builder()
    .instanceId("testString")
    .applicationDetails(applicationRequestApplicationDetailsModel)
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ApplicationResponse> response = ibmAnalyticsEngineApiService.createApplication(createApplicationOptionsModel).execute();
    assertNotNull(response);
    ApplicationResponse responseObj = response.getResult();
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
    assertEquals(parsedPath, createApplicationPath);
  }

  // Test the createApplication operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateApplicationNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    ibmAnalyticsEngineApiService.createApplication(null).execute();
  }

  @Test
  public void testGetApplicationsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"applications\": [{\"application_id\": \"applicationId\", \"spark_application_id\": \"sparkApplicationId\", \"state\": \"state\", \"start_time\": \"startTime\", \"finish_time\": \"finishTime\"}]}";
    String getApplicationsPath = "/v3/analytics_engines/testString/spark/applications";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetApplicationsOptions model
    GetApplicationsOptions getApplicationsOptionsModel = new GetApplicationsOptions.Builder()
    .instanceId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ApplicationCollection> response = ibmAnalyticsEngineApiService.getApplications(getApplicationsOptionsModel).execute();
    assertNotNull(response);
    ApplicationCollection responseObj = response.getResult();
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
    assertEquals(parsedPath, getApplicationsPath);
  }

  // Test the getApplications operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetApplicationsNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    ibmAnalyticsEngineApiService.getApplications(null).execute();
  }

  @Test
  public void testGetApplicationByIdWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"application_details\": {\"application_details\": {\"application\": \"application\", \"class\": \"xClass\", \"application_arguments\": [\"applicationArguments\"], \"conf\": {\"mapKey\": \"anyValue\"}, \"env\": {\"mapKey\": \"anyValue\"}}}, \"mode\": \"mode\", \"application_id\": \"applicationId\", \"state\": \"state\", \"start_time\": \"startTime\", \"finish_time\": \"finishTime\"}";
    String getApplicationByIdPath = "/v3/analytics_engines/testString/spark/applications/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetApplicationByIdOptions model
    GetApplicationByIdOptions getApplicationByIdOptionsModel = new GetApplicationByIdOptions.Builder()
    .instanceId("testString")
    .applicationId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ApplicationGetResponse> response = ibmAnalyticsEngineApiService.getApplicationById(getApplicationByIdOptionsModel).execute();
    assertNotNull(response);
    ApplicationGetResponse responseObj = response.getResult();
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
    assertEquals(parsedPath, getApplicationByIdPath);
  }

  // Test the getApplicationById operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetApplicationByIdNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    ibmAnalyticsEngineApiService.getApplicationById(null).execute();
  }

  @Test
  public void testDeleteApplicationByIdWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String deleteApplicationByIdPath = "/v3/analytics_engines/testString/spark/applications/testString";

    server.enqueue(new MockResponse()
    .setResponseCode(204)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteApplicationByIdOptions model
    DeleteApplicationByIdOptions deleteApplicationByIdOptionsModel = new DeleteApplicationByIdOptions.Builder()
    .instanceId("testString")
    .applicationId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = ibmAnalyticsEngineApiService.deleteApplicationById(deleteApplicationByIdOptionsModel).execute();
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
    assertEquals(parsedPath, deleteApplicationByIdPath);
  }

  // Test the deleteApplicationById operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteApplicationByIdNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    ibmAnalyticsEngineApiService.deleteApplicationById(null).execute();
  }

  @Test
  public void testGetApplicationStateWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"application_id\": \"applicationId\", \"state\": \"state\", \"start_time\": \"startTime\", \"finish_time\": \"finishTime\"}";
    String getApplicationStatePath = "/v3/analytics_engines/testString/spark/applications/testString/state";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetApplicationStateOptions model
    GetApplicationStateOptions getApplicationStateOptionsModel = new GetApplicationStateOptions.Builder()
    .instanceId("testString")
    .applicationId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ApplicationGetStateResponse> response = ibmAnalyticsEngineApiService.getApplicationState(getApplicationStateOptionsModel).execute();
    assertNotNull(response);
    ApplicationGetStateResponse responseObj = response.getResult();
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
    assertEquals(parsedPath, getApplicationStatePath);
  }

  // Test the getApplicationState operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetApplicationStateNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    ibmAnalyticsEngineApiService.getApplicationState(null).execute();
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
    ibmAnalyticsEngineApiService = null;
  }
}