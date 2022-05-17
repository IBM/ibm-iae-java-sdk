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
import com.ibm.cloud.iaesdk.test.SdkIntegrationTestBase;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.CredentialUtils;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
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
// !!!! Start of custom content to be copied !!! 
// Declaration of configuration variables
  public String instanceGuid = null;
  public String instanceGuidInstanceHome = null;
  public String hmacAccessKey = null;
  public String hmacSecretKey = null;
  public String applicationId = null;
// !!! End of custom content to be copied !!!	
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

  // !!!! Start of custom content to be copied !!! 
  // Assignment of configuration variables from environment
    instanceGuid=System.getenv("IBM_ANALYTICS_ENGINE_INSTANCE_GUID");
    instanceGuidInstanceHome=System.getenv("IBM_ANALYTICS_ENGINE_INSTANCE_GUID_INSTANCE_HOME");
    hmacAccessKey=System.getenv("IBM_ANALYTICS_ENGINE_HMAC_ACCESS_KEY");
    hmacSecretKey=System.getenv("IBM_ANALYTICS_ENGINE_HMAC_SECRET_KEY");
  // !!! End of custom content to be copied !!!	  
  //service.enableRetries(4, 30);


    System.out.println("Setup complete.");
  }

  @Test
  public void testGetInstance() throws Exception {
    try {
      GetInstanceOptions getInstanceOptions = new GetInstanceOptions.Builder()
      .instanceId(instanceGuid)
      .build();

      // Invoke operation
      Response<Instance> response = service.getInstance(getInstanceOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      Instance instanceResult = response.getResult();
      System.out.println("testGetInstance");
      System.out.println(instanceResult);
      assertNotNull(instanceResult);

      //
      // The following status codes aren't covered by tests.
      // Please provide integration tests for these too.
      //
      // 401
      // 403
      // 404
      // 500
      //
      //

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(timeOut = 200000)
  public void testGetInstanceState() throws Exception {
    try {
      GetInstanceStateOptions getInstanceStateOptions = new GetInstanceStateOptions.Builder()
      .instanceId(instanceGuid)
      .build();

      // Invoke operation
      Response<InstanceGetStateResponse> response = service.getInstanceState(getInstanceStateOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      InstanceGetStateResponse instanceGetStateResponseResult = response.getResult();
      System.out.println("testGetInstanceState");
      System.out.println(instanceGetStateResponseResult);
      assertNotNull(instanceGetStateResponseResult);

      //
      // The following status codes aren't covered by tests.
      // Please provide integration tests for these too.
      //
      // 401
      // 403
      // 404
      // 500
      //
      //

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(timeOut = 200000)
  public void testSetInstanceHome() throws Exception {
    try {
      SetInstanceHomeOptions setInstanceHomeOptions = new SetInstanceHomeOptions.Builder()
      .instanceId(instanceGuidInstanceHome)
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
      System.out.println("testSetInstanceHome");
      System.out.println(instanceHomeResponseResult);
      assertNotNull(instanceHomeResponseResult);

      //
      // The following status codes aren't covered by tests.
      // Please provide integration tests for these too.
      //
      // 400
      // 401
      // 403
      // 404
      // 409
      // 500
      //
      //

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(timeOut = 200000)
  public void testCreateApplication() throws Exception {
    try {
      ApplicationRequestApplicationDetails applicationRequestApplicationDetailsModel = new ApplicationRequestApplicationDetails.Builder()
      .application("/opt/ibm/spark/examples/src/main/python/wordcount.py")
      //.jars("cos://cloud-object-storage/jars/tests.jar")
      //.packages("testString")
      //.repositories("testString")
      //.files("testString")
      //.archives("testString")
      //.name("spark-app")
      //.xClass("com.company.path.ClassName")
      .arguments(new java.util.ArrayList<String>(java.util.Arrays.asList("/opt/ibm/spark/examples/src/main/resources/people.txt")))
      //.conf(new java.util.HashMap<String, Object>() { { put("foo", "testString"); } })
      //.env(new java.util.HashMap<String, Object>() { { put("foo", "testString"); } })
      .build();

      CreateApplicationOptions createApplicationOptions = new CreateApplicationOptions.Builder()
      .instanceId(instanceGuid)
      .applicationDetails(applicationRequestApplicationDetailsModel)
      .build();

      // Invoke operation
      Response<ApplicationResponse> response = service.createApplication(createApplicationOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 202);

      ApplicationResponse applicationResponseResult = response.getResult();
      System.out.println("testCreateApplication");
      System.out.println(applicationResponseResult);
      assertNotNull(applicationResponseResult);
      
   // !!!! Start of custom content to be copied !!! 
      String jsonString = String.valueOf(response.getResult());
      JSONObject jsonObject = (JSONObject) JSONValue.parse(jsonString);
      applicationId = jsonObject.get("id").toString();
   // !!! End of custom content to be copied !!!	 
      
      //
      // The following status codes aren't covered by tests.
      // Please provide integration tests for these too.
      //
      // 400
      // 401
      // 403
      // 404
      // 500
      //
      //

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(timeOut = 200000)
  public void testListApplications() throws Exception {
    try {
      ListApplicationsOptions listApplicationsOptions = new ListApplicationsOptions.Builder()
      .instanceId(instanceGuid)
      .build();

      // Invoke operation
      Response<ApplicationCollection> response = service.listApplications(listApplicationsOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ApplicationCollection applicationCollectionResult = response.getResult();
      System.out.println("testListApplications");
      System.out.println(applicationCollectionResult);
      assertNotNull(applicationCollectionResult);

      //
      // The following status codes aren't covered by tests.
      // Please provide integration tests for these too.
      //
      // 401
      // 403
      // 404
      // 500
      //
      //

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(timeOut = 200000, dependsOnMethods={"testCreateApplication"})
  public void testGetApplication() throws Exception {
    try {
      GetApplicationOptions getApplicationOptions = new GetApplicationOptions.Builder()
      .instanceId(instanceGuid)
      .applicationId(applicationId)
      .build();

      // Invoke operation
      Response<ApplicationGetResponse> response = service.getApplication(getApplicationOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ApplicationGetResponse applicationGetResponseResult = response.getResult();
      System.out.println("testGetApplication");
      System.out.println(applicationGetResponseResult);
      assertNotNull(applicationGetResponseResult);

      //
      // The following status codes aren't covered by tests.
      // Please provide integration tests for these too.
      //
      // 401
      // 403
      // 404
      // 500
      //
      //

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(timeOut = 200000, dependsOnMethods={"testCreateApplication"})
  public void testGetApplicationState() throws Exception {
    try {
      GetApplicationStateOptions getApplicationStateOptions = new GetApplicationStateOptions.Builder()
      .instanceId(instanceGuid)
      .applicationId(applicationId)
      .build();

      // Invoke operation
      Response<ApplicationGetStateResponse> response = service.getApplicationState(getApplicationStateOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ApplicationGetStateResponse applicationGetStateResponseResult = response.getResult();
      System.out.println("testGetApplicationState");
      System.out.println(applicationGetStateResponseResult);
      assertNotNull(applicationGetStateResponseResult);

      //
      // The following status codes aren't covered by tests.
      // Please provide integration tests for these too.
      //
      // 401
      // 403
      // 404
      // 500
      //
      //

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(timeOut = 200000)
  public void testConfigurePlatformLogging() throws Exception {
    try {
      ConfigurePlatformLoggingOptions configurePlatformLoggingOptions = new ConfigurePlatformLoggingOptions.Builder()
      .instanceGuid(instanceGuid)
      .enable(true)
      .build();

      // Invoke operation
      Response<LoggingConfigurationResponse> response = service.configurePlatformLogging(configurePlatformLoggingOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 201);

      LoggingConfigurationResponse loggingConfigurationResponseResult = response.getResult();
      System.out.println("testConfigurePlatformLogging");
      System.out.println(loggingConfigurationResponseResult);
      assertNotNull(loggingConfigurationResponseResult);

      //
      // The following status codes aren't covered by tests.
      // Please provide integration tests for these too.
      //
      // 400
      // 401
      // 403
      // 404
      // 500
      //
      //

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods={"testConfigurePlatformLogging"})
  public void testGetLoggingConfiguration() throws Exception {
    try {
      GetLoggingConfigurationOptions getLoggingConfigurationOptions = new GetLoggingConfigurationOptions.Builder()
      .instanceGuid(instanceGuid)
      .build();

      // Invoke operation
      Response<LoggingConfigurationResponse> response = service.getLoggingConfiguration(getLoggingConfigurationOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      LoggingConfigurationResponse loggingConfigurationResponseResult = response.getResult();
      System.out.println("testGetLoggingConfiguration");
      System.out.println(loggingConfigurationResponseResult);
      assertNotNull(loggingConfigurationResponseResult);

      //
      // The following status codes aren't covered by tests.
      // Please provide integration tests for these too.
      //
      // 401
      // 403
      // 404
      // 500
      //
      //

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(timeOut = 200000)
  public void testStartSparkHistoryServer() throws Exception {
    try {
      StartSparkHistoryServerOptions startSparkHistoryServerOptions = new StartSparkHistoryServerOptions.Builder()
      .instanceId(instanceGuid)
      .build();

      // Invoke operation
      Response<SparkHistoryServerStartResponse> response = service.startSparkHistoryServer(startSparkHistoryServerOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 201);

      SparkHistoryServerStartResponse sparkHistoryServerStartResponseResult = response.getResult();
      System.out.println("testStartSparkHistoryServer");
      System.out.println(sparkHistoryServerStartResponseResult);
      assertNotNull(sparkHistoryServerStartResponseResult);

      //
      // The following status codes aren't covered by tests.
      // Please provide integration tests for these too.
      //
      // 400
      // 401
      // 403
      // 404
      // 500
      //
      //

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(timeOut = 200000)
  public void testGetSparkHistoryServer() throws Exception {
    try {
      GetSparkHistoryServerOptions getSparkHistoryServerOptions = new GetSparkHistoryServerOptions.Builder()
      .instanceId(instanceGuid)
      .build();

      // Invoke operation
      Response<SparkHistoryServerResponse> response = service.getSparkHistoryServer(getSparkHistoryServerOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      SparkHistoryServerResponse sparkHistoryServerResponseResult = response.getResult();
      System.out.println("testGetSparkHistoryServer");
      System.out.println(sparkHistoryServerResponseResult);
      assertNotNull(sparkHistoryServerResponseResult);

      //
      // The following status codes aren't covered by tests.
      // Please provide integration tests for these too.
      //
      // 400
      // 401
      // 403
      // 404
      // 500
      //
      //

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(timeOut = 200000, dependsOnMethods={"testStartSparkHistoryServer"})
  public void testStopSparkHistoryServer() throws Exception {
    try {
      StopSparkHistoryServerOptions stopSparkHistoryServerOptions = new StopSparkHistoryServerOptions.Builder()
      .instanceId(instanceGuid)
      .build();

      // Invoke operation
      Response<Void> response = service.stopSparkHistoryServer(stopSparkHistoryServerOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 204);

      //
      // The following status codes aren't covered by tests.
      // Please provide integration tests for these too.
      //
      // 400
      // 401
      // 403
      // 404
      // 500
      //
      //

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods={"testCreateApplication"})
  public void testDeleteApplication() throws Exception {
    try {
      DeleteApplicationOptions deleteApplicationOptions = new DeleteApplicationOptions.Builder()
      .instanceId(instanceGuid)
      .applicationId(applicationId)
      .build();

      // Invoke operation
      Response<Void> response = service.deleteApplication(deleteApplicationOptions).execute();
      // Validate response
      System.out.println("testDeleteApplication");
      System.out.println(response.getStatusCode());
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 204);

      //
      // The following status codes aren't covered by tests.
      // Please provide integration tests for these too.
      //
      // 400
      // 401
      // 403
      // 404
      // 500
      //
      //

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
