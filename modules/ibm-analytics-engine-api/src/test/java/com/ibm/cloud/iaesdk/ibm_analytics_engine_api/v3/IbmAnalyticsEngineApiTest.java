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

import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.IbmAnalyticsEngineApi;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.Application;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.ApplicationCollection;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.ApplicationDetails;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.ApplicationGetResponse;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.ApplicationGetStateResponse;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.ApplicationRequestApplicationDetails;
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
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.InstanceDefaultConfig;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.InstanceDefaultRuntime;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.InstanceGetStateResponse;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.InstanceHome;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.InstanceHomeResponse;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.ListApplicationsOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.LoggingConfigurationResponse;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.LoggingConfigurationResponseLogServer;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.SetInstanceHomeOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.SparkHistoryServerResponse;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.SparkHistoryServerStartResponse;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.StartSparkHistoryServerOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.StopSparkHistoryServerOptions;
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
    String mockResponseBody = "{\"id\": \"id\", \"href\": \"href\", \"state\": \"created\", \"state_change_time\": \"2021-01-30T08:30:00.000Z\", \"default_runtime\": {\"spark_version\": \"sparkVersion\"}, \"instance_home\": {\"id\": \"id\", \"provider\": \"provider\", \"type\": \"type\", \"region\": \"region\", \"endpoint\": \"endpoint\", \"bucket\": \"bucket\", \"hmac_access_key\": \"hmacAccessKey\", \"hmac_secret_key\": \"hmacSecretKey\"}, \"default_config\": {\"key\": \"key\"}}";
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
//    ibmAnalyticsEngineApiService.enableRetries(4, 30);
    testGetInstanceWOptions();

//    ibmAnalyticsEngineApiService.disableRetries();
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
    String mockResponseBody = "{\"id\": \"id\", \"state\": \"created\"}";
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
//    ibmAnalyticsEngineApiService.enableRetries(4, 30);
    testGetInstanceStateWOptions();

//    ibmAnalyticsEngineApiService.disableRetries();
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
      .newHmacAccessKey("821**********0ae")
      .newHmacSecretKey("03e****************4fc3")
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
//    ibmAnalyticsEngineApiService.enableRetries(4, 30);
    testSetInstanceHomeWOptions();

//    ibmAnalyticsEngineApiService.disableRetries();
    testSetInstanceHomeWOptions();
  }

  // Test the setInstanceHome operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testSetInstanceHomeNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    ibmAnalyticsEngineApiService.setInstanceHome(null).execute();
  }

  // Test the createApplication operation with a valid options model parameter
  @Test
  public void testCreateApplicationWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"state\": \"accepted\"}";
    String createApplicationPath = "/v3/analytics_engines/e64c907a-e82f-46fd-addc-ccfafbd28b09/spark_applications";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(202)
      .setBody(mockResponseBody));

    // Construct an instance of the ApplicationRequestApplicationDetails model
    ApplicationRequestApplicationDetails applicationRequestApplicationDetailsModel = new ApplicationRequestApplicationDetails.Builder()
      .application("cos://bucket_name.my_cos/my_spark_app.py")
      .jars("cos://cloud-object-storage/jars/tests.jar")
      .packages("testString")
      .repositories("testString")
      .files("testString")
      .archives("testString")
      .name("spark-app")
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
//    ibmAnalyticsEngineApiService.enableRetries(4, 30);
    testCreateApplicationWOptions();

//    ibmAnalyticsEngineApiService.disableRetries();
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
    String mockResponseBody = "{\"applications\": [{\"id\": \"id\", \"href\": \"href\", \"spark_application_id\": \"sparkApplicationId\", \"state\": \"state\", \"start_time\": \"startTime\", \"finish_time\": \"finishTime\"}]}";
    String listApplicationsPath = "/v3/analytics_engines/e64c907a-e82f-46fd-addc-ccfafbd28b09/spark_applications";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ListApplicationsOptions model
    ListApplicationsOptions listApplicationsOptionsModel = new ListApplicationsOptions.Builder()
      .instanceId("e64c907a-e82f-46fd-addc-ccfafbd28b09")
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
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the listApplications operation with and without retries enabled
  @Test
  public void testListApplicationsWRetries() throws Throwable {
//    ibmAnalyticsEngineApiService.enableRetries(4, 30);
    testListApplicationsWOptions();

//    ibmAnalyticsEngineApiService.disableRetries();
    testListApplicationsWOptions();
  }

  // Test the listApplications operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListApplicationsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    ibmAnalyticsEngineApiService.listApplications(null).execute();
  }

  // Test the getApplication operation with a valid options model parameter
  @Test
  public void testGetApplicationWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"application_details\": {\"application\": \"cos://bucket_name.my_cos/my_spark_app.py\", \"jars\": \"cos://cloud-object-storage/jars/tests.jar\", \"packages\": \"packages\", \"repositories\": \"repositories\", \"files\": \"files\", \"archives\": \"archives\", \"name\": \"spark-app\", \"class\": \"com.company.path.ClassName\", \"arguments\": [\"[arg1, arg2, arg3]\"], \"conf\": {\"mapKey\": \"anyValue\"}, \"env\": {\"mapKey\": \"anyValue\"}}, \"id\": \"2b83d31c-397b-48ad-ad76-b83347c982db\", \"state\": \"accepted\", \"start_time\": \"2021-01-30T08:30:00.000Z\", \"finish_time\": \"2021-01-30T08:30:00.000Z\"}";
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
//    ibmAnalyticsEngineApiService.enableRetries(4, 30);
    testGetApplicationWOptions();

//    ibmAnalyticsEngineApiService.disableRetries();
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
//    ibmAnalyticsEngineApiService.enableRetries(4, 30);
    testDeleteApplicationWOptions();

//    ibmAnalyticsEngineApiService.disableRetries();
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
    String mockResponseBody = "{\"id\": \"id\", \"state\": \"state\", \"start_time\": \"startTime\", \"finish_time\": \"finishTime\"}";
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
//    ibmAnalyticsEngineApiService.enableRetries(4, 30);
    testGetApplicationStateWOptions();

//    ibmAnalyticsEngineApiService.disableRetries();
    testGetApplicationStateWOptions();
  }

  // Test the getApplicationState operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetApplicationStateNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    ibmAnalyticsEngineApiService.getApplicationState(null).execute();
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
//    ibmAnalyticsEngineApiService.enableRetries(4, 30);
    testConfigurePlatformLoggingWOptions();

//    ibmAnalyticsEngineApiService.disableRetries();
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
//    ibmAnalyticsEngineApiService.enableRetries(4, 30);
    testGetLoggingConfigurationWOptions();

//    ibmAnalyticsEngineApiService.disableRetries();
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
    String mockResponseBody = "{\"state\": \"state\", \"cores\": \"cores\", \"memory\": \"memory\", \"start_time\": \"startTime\"}";
    String startSparkHistoryServerPath = "/v3/analytics_engines/e64c907a-e82f-46fd-addc-ccfafbd28b09/spark_history_server";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(201)
      .setBody(mockResponseBody));

    // Construct an instance of the StartSparkHistoryServerOptions model
    StartSparkHistoryServerOptions startSparkHistoryServerOptionsModel = new StartSparkHistoryServerOptions.Builder()
      .instanceId("e64c907a-e82f-46fd-addc-ccfafbd28b09")
      .build();

    // Invoke startSparkHistoryServer() with a valid options model and verify the result
    Response<SparkHistoryServerStartResponse> response = ibmAnalyticsEngineApiService.startSparkHistoryServer(startSparkHistoryServerOptionsModel).execute();
    assertNotNull(response);
    SparkHistoryServerStartResponse responseObj = response.getResult();
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
//    ibmAnalyticsEngineApiService.enableRetries(4, 30);
    testStartSparkHistoryServerWOptions();

//    ibmAnalyticsEngineApiService.disableRetries();
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
    String mockResponseBody = "{\"state\": \"state\", \"cores\": \"cores\", \"memory\": \"memory\", \"start_time\": \"startTime\", \"stop_time\": \"stopTime\"}";
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
//    ibmAnalyticsEngineApiService.enableRetries(4, 30);
    testGetSparkHistoryServerWOptions();

//    ibmAnalyticsEngineApiService.disableRetries();
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
//    ibmAnalyticsEngineApiService.enableRetries(4, 30);
    testStopSparkHistoryServerWOptions();

//    ibmAnalyticsEngineApiService.disableRetries();
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

  // Creates a mock set of environment variables that are returned by EnvironmentUtils.getenv()
  private Map<String, String> getTestProcessEnvironment() {
    Map<String, String> env = new HashMap<>();
    env.put("TESTSERVICE_AUTH_TYPE", "noAuth");
    return env;
  }

  // Constructs an instance of the service to be used by the tests
  public void constructClientService() {
    PowerMockito.spy(EnvironmentUtils.class);
    PowerMockito.when(EnvironmentUtils.getenv()).thenReturn(getTestProcessEnvironment());
    final String serviceName = "testService";

    ibmAnalyticsEngineApiService = IbmAnalyticsEngineApi.newInstance(serviceName);
    String url = server.url("/").toString();
    ibmAnalyticsEngineApiService.setServiceUrl(url);
  }
}