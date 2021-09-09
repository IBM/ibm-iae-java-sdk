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
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.Application;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.ApplicationCollection;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.ApplicationDetails;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.ApplicationGetResponse;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.ApplicationGetStateResponse;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.ApplicationRequestApplicationDetails;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.ApplicationResponse;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.CreateApplicationOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.DeleteApplicationOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.GetApplicationOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.GetApplicationStateOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.GetInstanceOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.Instance;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.InstanceDefaultConfig;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.InstanceDefaultRuntime;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.InstanceHome;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.ListApplicationsOptions;
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
  public void testGetInstanceWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"href\": \"href\", \"state\": \"created\", \"state_change_time\": \"2021-01-30T08:30:00.000Z\", \"default_runtime\": {\"spark_version\": \"sparkVersion\"}, \"instance_home\": {\"id\": \"id\", \"provider\": \"provider\", \"type\": \"type\", \"region\": \"region\", \"endpoint\": \"endpoint\", \"bucket\": \"bucket\", \"hmac_access_key\": \"hmacAccessKey\", \"hmac_secret_key\": \"hmacSecretKey\"}, \"default_config\": {\"key\": \"key\"}}";
    String getInstancePath = "/v3/analytics_engines/e64c907a-e82f-46fd-addc-ccfafbd28b09";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetInstanceOptions model
    GetInstanceOptions getInstanceOptionsModel = new GetInstanceOptions.Builder()
    .instanceId("e64c907a-e82f-46fd-addc-ccfafbd28b09")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Instance> response = ibmAnalyticsEngineApiService.getInstance(getInstanceOptionsModel).execute();
    assertNotNull(response);
    Instance responseObj = response.getResult();
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
    assertEquals(parsedPath, getInstancePath);
  }

  // Test the getInstance operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetInstanceNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    ibmAnalyticsEngineApiService.getInstance(null).execute();
  }

  @Test
  public void testCreateApplicationWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"state\": \"accepted\"}";
    String createApplicationPath = "/v3/analytics_engines/e64c907a-e82f-46fd-addc-ccfafbd28b09/spark_applications";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(202)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ApplicationRequestApplicationDetails model
    ApplicationRequestApplicationDetails applicationRequestApplicationDetailsModel = new ApplicationRequestApplicationDetails.Builder()
    .application("cos://bucket_name.my_cos/my_spark_app.py")
    .xClass("com.company.path.ClassName")
    .arguments(new java.util.ArrayList<String>(java.util.Arrays.asList("[arg1, arg2, arg3]")))
    .conf(new java.util.HashMap<String, Object>() { { put("foo", "testString"); } })
    .env(new java.util.HashMap<String, Object>() { { put("foo", "testString"); } })
    .build();

    // Construct an instance of the CreateApplicationOptions model
    CreateApplicationOptions createApplicationOptionsModel = new CreateApplicationOptions.Builder()
    .instanceId("e64c907a-e82f-46fd-addc-ccfafbd28b09")
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
  public void testListApplicationsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"applications\": [{\"id\": \"id\", \"href\": \"href\", \"spark_application_id\": \"sparkApplicationId\", \"state\": \"state\", \"start_time\": \"startTime\", \"finish_time\": \"finishTime\"}]}";
    String listApplicationsPath = "/v3/analytics_engines/e64c907a-e82f-46fd-addc-ccfafbd28b09/spark_applications";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListApplicationsOptions model
    ListApplicationsOptions listApplicationsOptionsModel = new ListApplicationsOptions.Builder()
    .instanceId("e64c907a-e82f-46fd-addc-ccfafbd28b09")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ApplicationCollection> response = ibmAnalyticsEngineApiService.listApplications(listApplicationsOptionsModel).execute();
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
    assertEquals(parsedPath, listApplicationsPath);
  }

  // Test the listApplications operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListApplicationsNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    ibmAnalyticsEngineApiService.listApplications(null).execute();
  }

  @Test
  public void testGetApplicationWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"application_details\": {\"application\": \"cos://bucket_name.my_cos/my_spark_app.py\", \"class\": \"com.company.path.ClassName\", \"arguments\": [\"[arg1, arg2, arg3]\"], \"conf\": {\"mapKey\": \"anyValue\"}, \"env\": {\"mapKey\": \"anyValue\"}}, \"id\": \"2b83d31c-397b-48ad-ad76-b83347c982db\", \"state\": \"accepted\", \"start_time\": \"2021-01-30T08:30:00.000Z\", \"finish_time\": \"2021-01-30T08:30:00.000Z\"}";
    String getApplicationPath = "/v3/analytics_engines/e64c907a-e82f-46fd-addc-ccfafbd28b09/spark_applications/ff48cc19-0e7e-4627-aac6-0b4ad080397b";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetApplicationOptions model
    GetApplicationOptions getApplicationOptionsModel = new GetApplicationOptions.Builder()
    .instanceId("e64c907a-e82f-46fd-addc-ccfafbd28b09")
    .applicationId("ff48cc19-0e7e-4627-aac6-0b4ad080397b")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ApplicationGetResponse> response = ibmAnalyticsEngineApiService.getApplication(getApplicationOptionsModel).execute();
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
    assertEquals(parsedPath, getApplicationPath);
  }

  // Test the getApplication operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetApplicationNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    ibmAnalyticsEngineApiService.getApplication(null).execute();
  }

  @Test
  public void testDeleteApplicationWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String deleteApplicationPath = "/v3/analytics_engines/e64c907a-e82f-46fd-addc-ccfafbd28b09/spark_applications/ff48cc19-0e7e-4627-aac6-0b4ad080397b";

    server.enqueue(new MockResponse()
    .setResponseCode(204)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteApplicationOptions model
    DeleteApplicationOptions deleteApplicationOptionsModel = new DeleteApplicationOptions.Builder()
    .instanceId("e64c907a-e82f-46fd-addc-ccfafbd28b09")
    .applicationId("ff48cc19-0e7e-4627-aac6-0b4ad080397b")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = ibmAnalyticsEngineApiService.deleteApplication(deleteApplicationOptionsModel).execute();
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
    assertEquals(parsedPath, deleteApplicationPath);
  }

  // Test the deleteApplication operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteApplicationNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    ibmAnalyticsEngineApiService.deleteApplication(null).execute();
  }

  @Test
  public void testGetApplicationStateWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"state\": \"state\", \"start_time\": \"startTime\", \"finish_time\": \"finishTime\"}";
    String getApplicationStatePath = "/v3/analytics_engines/e64c907a-e82f-46fd-addc-ccfafbd28b09/spark_applications/ff48cc19-0e7e-4627-aac6-0b4ad080397b/state";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetApplicationStateOptions model
    GetApplicationStateOptions getApplicationStateOptionsModel = new GetApplicationStateOptions.Builder()
    .instanceId("e64c907a-e82f-46fd-addc-ccfafbd28b09")
    .applicationId("ff48cc19-0e7e-4627-aac6-0b4ad080397b")
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