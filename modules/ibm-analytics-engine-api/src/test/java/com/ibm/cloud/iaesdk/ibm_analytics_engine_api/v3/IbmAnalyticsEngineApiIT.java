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
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * This class contains integration tests for IbmAnalyticsEngineV3Api service.
 *
 * Notes:
 * 1. By providing the name of our config file (ibmanalyticsengine-service.env.hide") via the
 *    getConfigFilename() method below, the base class (SdkIntegrationTestBase) will be able to
 *    mock up the getenv() method to cause the Java core's CredentialUtils class to "see" the
 *    config file via the mocked value of the IBM_CREDENTIALS_FILE env var.
 *
 * 2. The base class will automatically set the "skipTests" flag to true if it can't find the config file.
 *
 * 3. The base class contains a "before method" function that will automatically skip each test method if
 *    the "skipTests" flag is true.   This means that this subclass doesn't need to concern
 *    itself with skipping tests in the event that the config file is not available.
 *
 * 4. This example testcase uses the "dependsOnMethods" attribute of the @Test annotation to ensure that the test
 *    methods are executed in the the order they appear in this file.  Without this, there's no guaranteed ordering
 *    imposed by TestNG.
 *
 * 5. Be sure to following the instructions here:
 *    https://github.ibm.com/CloudEngineering/java-sdk-template/blob/master/README_FIRST.md#integration-tests
 *    to start up an instance of the IbmAnalyticsEngineV2Api Service prior to running the integraton test.
 *
 * 6. Before running this test, rename example-service.env.hide to example-service.env.
 */
public class IbmAnalyticsEngineApiIT extends SdkIntegrationTestBase {
  public IbmAnalyticsEngineApi service = null;
  public static Map<String, String> config = null;
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();
  public String instanceGuid = null;
  public String applicationId = null;
  /**
   * This method provides our config filename to the base class.
   */

  public String getConfigFilename() {
    return "../../ibmanalyticsengine-service.env";
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
    instanceGuid = System.getenv("IBM_ANALYTICS_ENGINE_INSTANCE_GUID");
    System.out.println("Setup complete.");
  }

  @Test
  public void testGetInstanceById() throws Exception {
    try {
      GetInstanceByIdOptions getInstanceByIdOptions = new GetInstanceByIdOptions.Builder()
      .instanceId(instanceGuid)
      .build();

      // Invoke operation
      Response<InstanceDetails> response = service.getInstanceById(getInstanceByIdOptions).execute();
      // Validate response
      assertNotNull(response);
      System.out.println("Status code "+Integer.toString(response.getStatusCode()));
      System.out.println("Response String "+String.valueOf(response.getResult()));
      assertEquals(response.getStatusCode(), 200);

      InstanceDetails instanceDetailsResult = response.getResult();

      assertNotNull(instanceDetailsResult);
      
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testCreateApplication() throws Exception {
    try {
      ApplicationRequestApplicationDetails applicationRequestApplicationDetailsModel = new ApplicationRequestApplicationDetails.Builder()
      .application("/opt/ibm/spark/examples/src/main/python/wordcount.py")
      //.xClass("testString")
      .applicationArguments(new java.util.ArrayList<String>(java.util.Arrays.asList("/opt/ibm/spark/examples/src/main/resources/people.txt")))
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
      System.out.println("Status code "+Integer.toString(response.getStatusCode()));
      System.out.println("Response String "+String.valueOf(response.getResult()));
      assertEquals(response.getStatusCode(), 202);

      ApplicationResponse applicationResponseResult = response.getResult();

      assertNotNull(applicationResponseResult);
      String jsonString = String.valueOf(response.getResult());
      JSONObject jsonObject = (JSONObject) JSONValue.parse(jsonString);
      applicationId = jsonObject.get("application_id").toString();
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testGetApplications() throws Exception {
    try {
      GetApplicationsOptions getApplicationsOptions = new GetApplicationsOptions.Builder()
      .instanceId(instanceGuid)
      .build();

      // Invoke operation
      Response<ApplicationCollection> response = service.getApplications(getApplicationsOptions).execute();
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
  public void testGetApplicationById() throws Exception {
    try {
      GetApplicationByIdOptions getApplicationByIdOptions = new GetApplicationByIdOptions.Builder()
      .instanceId(instanceGuid)
      .applicationId(applicationId)
      .build();

      // Invoke operation
      Response<ApplicationGetResponse> response = service.getApplicationById(getApplicationByIdOptions).execute();
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
      .instanceId(instanceGuid)
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

  @Test
  public void testDeleteApplicationById() throws Exception {
    try {
      DeleteApplicationByIdOptions deleteApplicationByIdOptions = new DeleteApplicationByIdOptions.Builder()
      .instanceId(instanceGuid)
      .applicationId(applicationId)
      .build();

      // Invoke operation
      Response<Void> response = service.deleteApplicationById(deleteApplicationByIdOptions).execute();
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
