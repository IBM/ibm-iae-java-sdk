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

package com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2;

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
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2.model.AnalyticsEngineWhitelistResponse;
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
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2.model.ResizeClusterRequest;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2.model.ResizeClusterRequestAnalyticsEngineResizeClusterByComputeNodesRequest;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2.model.ResizeClusterRequestAnalyticsEngineResizeClusterByTaskNodesRequest;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2.model.ServiceEndpoints;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2.model.UpdatePrivateEndpointWhitelistOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2.utils.TestUtilities;
import com.ibm.cloud.iaesdk.test.SdkIntegrationTestBase;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.CredentialUtils;
import com.ibm.cloud.sdk.core.util.DateUtils;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * This class contains integration tests for IbmAnalyticsEngineV2Api service.
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
  public String instanceGuid = null;
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
    instanceGuid = System.getenv("IBM_ANALYTICS_ENGINE_INSTANCE_GUID");
    System.out.println("Setup complete.");
  }

  @Test
  public void testGetAllAnalyticsEngines() throws Exception {
    try {
      GetAllAnalyticsEnginesOptions getAllAnalyticsEnginesOptions = new GetAllAnalyticsEnginesOptions();

      // Invoke operation
      Response<Void> response = service.getAllAnalyticsEngines(getAllAnalyticsEnginesOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testGetAnalyticsEngineById() throws Exception {
    try {
      GetAnalyticsEngineByIdOptions getAnalyticsEngineByIdOptions = new GetAnalyticsEngineByIdOptions.Builder()
      .instanceGuid(instanceGuid)
      .build();

      // Invoke operation
      Response<AnalyticsEngine> response = service.getAnalyticsEngineById(getAnalyticsEngineByIdOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      AnalyticsEngine analyticsEngineResult = response.getResult();

      assertNotNull(analyticsEngineResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testGetAnalyticsEngineStateById() throws Exception {
    try {
      GetAnalyticsEngineStateByIdOptions getAnalyticsEngineStateByIdOptions = new GetAnalyticsEngineStateByIdOptions.Builder()
      .instanceGuid(instanceGuid)
      .build();

      // Invoke operation
      Response<AnalyticsEngineState> response = service.getAnalyticsEngineStateById(getAnalyticsEngineStateByIdOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      AnalyticsEngineState analyticsEngineStateResult = response.getResult();

      assertNotNull(analyticsEngineStateResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testCreateCustomizationRequest() throws Exception {
    try {
      AnalyticsEngineCustomActionScript analyticsEngineCustomActionScriptModel = new AnalyticsEngineCustomActionScript.Builder()
      .sourceType("http")
      .scriptPath("testString")
      .sourceProps(new java.util.HashMap<String, Object>() { { put("foo", "testString"); } })
      .build();

      AnalyticsEngineCustomAction analyticsEngineCustomActionModel = new AnalyticsEngineCustomAction.Builder()
      .name("testString")
      .type("bootstrap")
      .script(analyticsEngineCustomActionScriptModel)
      .scriptParams(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
      .build();

      CreateCustomizationRequestOptions createCustomizationRequestOptions = new CreateCustomizationRequestOptions.Builder()
      .instanceGuid(instanceGuid)
      .target("all")
      .customActions(new java.util.ArrayList<AnalyticsEngineCustomAction>(java.util.Arrays.asList(analyticsEngineCustomActionModel)))
      .build();

      // Invoke operation
      Response<AnalyticsEngineCreateCustomizationResponse> response = service.createCustomizationRequest(createCustomizationRequestOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      AnalyticsEngineCreateCustomizationResponse analyticsEngineCreateCustomizationResponseResult = response.getResult();

      assertNotNull(analyticsEngineCreateCustomizationResponseResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testGetAllCustomizationRequests() throws Exception {
    try {
      GetAllCustomizationRequestsOptions getAllCustomizationRequestsOptions = new GetAllCustomizationRequestsOptions.Builder()
      .instanceGuid(instanceGuid)
      .build();

      // Invoke operation
      Response<List<AnalyticsEngineCustomizationRequestCollectionItem>> response = service.getAllCustomizationRequests(getAllCustomizationRequestsOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      List<AnalyticsEngineCustomizationRequestCollectionItem> listAnalyticsEngineCustomizationRequestCollectionItemResult = response.getResult();

      assertNotNull(listAnalyticsEngineCustomizationRequestCollectionItemResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testGetCustomizationRequestById() throws Exception {
    try {
    GetAllCustomizationRequestsOptions getAllCustomizationRequestsOptions = new GetAllCustomizationRequestsOptions.Builder()
  		      .instanceGuid(instanceGuid)
  		      .build();
  	
	  // Invoke operation with valid options model (positive test)
    Response<List<AnalyticsEngineCustomizationRequestCollectionItem>> responseId = service.getAllCustomizationRequests(getAllCustomizationRequestsOptions).execute();
	  List<AnalyticsEngineCustomizationRequestCollectionItem> responseObjId = responseId.getResult();
	  assertNotNull(responseObjId);
	  String requestId = responseObjId.get(0).getId();
	  System.out.println(requestId);
  	
  	
    GetCustomizationRequestByIdOptions getCustomizationRequestByIdOptions = new GetCustomizationRequestByIdOptions.Builder()
    .instanceGuid(instanceGuid)
    .requestId(requestId)
    .build();

      // Invoke operation
      Response<AnalyticsEngineCustomizationRunDetails> response = service.getCustomizationRequestById(getCustomizationRequestByIdOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      AnalyticsEngineCustomizationRunDetails analyticsEngineCustomizationRunDetailsResult = response.getResult();

      assertNotNull(analyticsEngineCustomizationRunDetailsResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testResizeCluster() throws Exception {
    try {
      ResizeClusterRequestAnalyticsEngineResizeClusterByComputeNodesRequest resizeClusterRequestModel = new ResizeClusterRequestAnalyticsEngineResizeClusterByComputeNodesRequest.Builder()
      .computeNodesCount(Long.valueOf("26"))
      .build();

      ResizeClusterOptions resizeClusterOptions = new ResizeClusterOptions.Builder()
      .instanceGuid(instanceGuid)
      .body(resizeClusterRequestModel)
      .build();

      // Invoke operation
      Response<AnalyticsEngineResizeClusterResponse> response = service.resizeCluster(resizeClusterOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      AnalyticsEngineResizeClusterResponse analyticsEngineResizeClusterResponseResult = response.getResult();

      assertNotNull(analyticsEngineResizeClusterResponseResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testResetClusterPassword() throws Exception {
    try {
      ResetClusterPasswordOptions resetClusterPasswordOptions = new ResetClusterPasswordOptions.Builder()
      .instanceGuid(instanceGuid)
      .build();

      // Invoke operation
      Response<AnalyticsEngineResetClusterPasswordResponse> response = service.resetClusterPassword(resetClusterPasswordOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      AnalyticsEngineResetClusterPasswordResponse analyticsEngineResetClusterPasswordResponseResult = response.getResult();

      assertNotNull(analyticsEngineResetClusterPasswordResponseResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testConfigureLogging() throws Exception {
    try {
      AnalyticsEngineLoggingNodeSpec analyticsEngineLoggingNodeSpecModel = new AnalyticsEngineLoggingNodeSpec.Builder()
      .nodeType("management")
      .components(new java.util.ArrayList<String>(java.util.Arrays.asList("ambari-server")))
      .build();

      AnalyticsEngineLoggingServer analyticsEngineLoggingServerModel = new AnalyticsEngineLoggingServer.Builder()
      .type("logdna")
      .credential("testString")
      .apiHost("testString")
      .logHost("testString")
      .owner("testString")
      .build();

      ConfigureLoggingOptions configureLoggingOptions = new ConfigureLoggingOptions.Builder()
      .instanceGuid(instanceGuid)
      .logSpecs(new java.util.ArrayList<AnalyticsEngineLoggingNodeSpec>(java.util.Arrays.asList(analyticsEngineLoggingNodeSpecModel)))
      .logServer(analyticsEngineLoggingServerModel)
      .build();

      // Invoke operation
      Response<Void> response = service.configureLogging(configureLoggingOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 202);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testGetLoggingConfig() throws Exception {
    try {
      GetLoggingConfigOptions getLoggingConfigOptions = new GetLoggingConfigOptions.Builder()
      .instanceGuid(instanceGuid)
      .build();

      // Invoke operation
      Response<AnalyticsEngineLoggingConfigDetails> response = service.getLoggingConfig(getLoggingConfigOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      AnalyticsEngineLoggingConfigDetails analyticsEngineLoggingConfigDetailsResult = response.getResult();

      assertNotNull(analyticsEngineLoggingConfigDetailsResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testUpdatePrivateEndpointWhitelist() throws Exception {
    try {
      UpdatePrivateEndpointWhitelistOptions updatePrivateEndpointWhitelistOptions = new UpdatePrivateEndpointWhitelistOptions.Builder()
      .instanceGuid(instanceGuid)
      .ipRanges(new java.util.ArrayList<String>(java.util.Arrays.asList("10.20.5.9/32")))
      .action("add")
      .build();

      // Invoke operation
      Response<AnalyticsEngineWhitelistResponse> response = service.updatePrivateEndpointWhitelist(updatePrivateEndpointWhitelistOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      AnalyticsEngineWhitelistResponse analyticsEngineWhitelistResponseResult = response.getResult();

      assertNotNull(analyticsEngineWhitelistResponseResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testDeleteLoggingConfig() throws Exception {
    try {
      DeleteLoggingConfigOptions deleteLoggingConfigOptions = new DeleteLoggingConfigOptions.Builder()
      .instanceGuid(instanceGuid)
      .build();

      // Invoke operation
      Response<Void> response = service.deleteLoggingConfig(deleteLoggingConfigOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 202);
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
