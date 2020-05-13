package com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;
import static org.testng.AssertJUnit.assertNotNull;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

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
import com.ibm.cloud.iaesdk.test.SdkIntegrationTestBase;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.NoAuthAuthenticator;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;

import java.io.IOException;
import java.io.InputStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.*;

/**
 * This class contains integration tests for example service.
 *
 * Notes:
 * 1. By providing the name of our config file ("example-service.env") via the
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
 *    to start up an instance of the Example Service prior to running the integraton test.
 *
 * 6. Before running this test, rename example-service.env.hide to example-service.env.
 */
public class IbmAnalyticsEngineApiIT extends SdkIntegrationTestBase {

    // Example service v1 integration
    public IbmAnalyticsEngineApi service = null;
    public String instanceGuid = null;

    /**
     * This method provides our config filename to the base class.
     */
    public String getConfigFilename() {
        return "../../ibmanalyticsengine-service.env";
    }

    /**
     * This method is invoked before any of the @Test-annotated methods, and is responsible for
     * creating the instance of the service that will be used by the rest of the test methods,
     * as well as any other required initialization.
     */
    @BeforeClass
    public void constructService() {
        // Ask super if we should skip the tests.
        if (skipTests()) {
            return;
        }

        /**
         * Construct our service client instance via external config (see the example-service.env file for details).
         * The newInstance() method will load up our config file and look for properties that start with
         * "EXAMPLE_SERVICE_" (the default service name associated with the Example Service, as specified by the
         * IbmAnalyticsEngineApi.DEFAULT_SERVICE_NAME constant).
         * Specifically, newInstance() will construct an authenticator based on the value of the
         * EXAMPLE_SERVICE_AUTH_TYPE property.   After constructing the appropriate authenticator, it will construct
         * an instance of the service and then set the URL to the value specified by the EXAMPLE_SERVICE_URL property.
         */
        service = IbmAnalyticsEngineApi.newInstance();
        assertNotNull(service);
        assertNotNull(service.getServiceUrl());
        instanceGuid = System.getenv("IBM_ANALYTICS_ENGINE_INSTANCE_GUID");
    }

    /**
     * Each of the @Test-annotated methods below will be skipped if the config file (example-service.env)
     * does not exist.
     */

    // @Test
    // public void testGetAnalyticsEngineByIdWOptions() throws Throwable {
    //     assertNotNull(service);

    //     // Construct an instance of the GetAnalyticsEngineByIdOptions model
    //     GetAnalyticsEngineByIdOptions getAnalyticsEngineByIdOptionsModel = new GetAnalyticsEngineByIdOptions.Builder()
    //     .instanceGuid(instanceGuid)
    //     .build();

    //     // Invoke operation with valid options model (positive test)
    //     Response<AnalyticsEngine> response = service.getAnalyticsEngineById(getAnalyticsEngineByIdOptionsModel).execute();
    //     assertNotNull(response);
    //     assertEquals(response.getStatusCode(), 200);
    //     AnalyticsEngine responseObj = response.getResult();
    //     assertNotNull(responseObj);
    //     // To print results
    //     // System.out.println(Integer.toString(response.getStatusCode()));
    //     // System.out.println(response.getStatusMessage());
    //     // System.out.println(String.valueOf(response.getResult()));
    // }

    // @Test
    // public void testGetAnalyticsEngineStateByIdWOptions() throws Throwable {
    //     assertNotNull(service);

    //     // Construct an instance of the GetAnalyticsEngineStateByIdOptions model
    //     GetAnalyticsEngineStateByIdOptions getAnalyticsEngineStateByIdOptionsModel = new GetAnalyticsEngineStateByIdOptions.Builder()
    //     .instanceGuid(instanceGuid)
    //     .build();

    //     Response<AnalyticsEngineState> response = service.getAnalyticsEngineStateById(getAnalyticsEngineStateByIdOptionsModel).execute();
    //     assertNotNull(response);
    //     assertEquals(response.getStatusCode(), 200);
    //     AnalyticsEngineState responseObj = response.getResult();
    //     assertNotNull(responseObj);
    // }

    // @Test
    // public void testCreateCustomizationRequestWOptions() throws Throwable {
    //     assertNotNull(service);

    //     // Construct an instance of the AnalyticsEngineCustomActionScript model
    //     AnalyticsEngineCustomActionScript analyticsEngineCustomActionScriptModel = new AnalyticsEngineCustomActionScript.Builder()
    //     .sourceType("http")
    //     .scriptPath("testString")
    //     .sourceProps(new java.util.HashMap<String,Object>(){{put("foo", "testString"); }})
    //     .build();

    //     // Construct an instance of the AnalyticsEngineCustomAction model
    //     AnalyticsEngineCustomAction analyticsEngineCustomActionModel = new AnalyticsEngineCustomAction.Builder()
    //     .name("testString")
    //     .type("bootstrap")
    //     .script(analyticsEngineCustomActionScriptModel)
    //     .scriptParams(new ArrayList<String>(Arrays.asList("testString")))
    //     .build();

    //     // Construct an instance of the CreateCustomizationRequestOptions model
    //     CreateCustomizationRequestOptions createCustomizationRequestOptionsModel = new CreateCustomizationRequestOptions.Builder()
    //     .instanceGuid(instanceGuid)
    //     .target("all")
    //     .customActions(new ArrayList<AnalyticsEngineCustomAction>(Arrays.asList(analyticsEngineCustomActionModel)))
    //     .build();

    //     // Invoke operation with valid options model (positive test)
    //     Response<AnalyticsEngineCreateCustomizationResponse> response = service.createCustomizationRequest(createCustomizationRequestOptionsModel).execute();
    //     assertNotNull(response);
    //     assertEquals(response.getStatusCode(), 200);
    //     AnalyticsEngineCreateCustomizationResponse responseObj = response.getResult();
    //     assertNotNull(responseObj);

    //     System.out.println(Integer.toString(response.getStatusCode()));
    //     System.out.println(response.getStatusMessage());
    //     System.out.println(String.valueOf(response.getResult()));
    // }

    // @Test
    // public void testGetAllCustomizationRequestsWOptions() throws Throwable {
    //     assertNotNull(service);

    //     // Construct an instance of the GetAllCustomizationRequestsOptions model
    //     GetAllCustomizationRequestsOptions getAllCustomizationRequestsOptionsModel = new GetAllCustomizationRequestsOptions.Builder()
    //     .instanceGuid(instanceGuid)
    //     .build();

    //     // Invoke operation with valid options model (positive test)
    //     Response<List<AnalyticsEngineCustomizationRequestCollectionItem>> response = service.getAllCustomizationRequests(getAllCustomizationRequestsOptionsModel).execute();
    //     assertNotNull(response);
    //     assertEquals(response.getStatusCode(), 200);
    //     List<AnalyticsEngineCustomizationRequestCollectionItem> responseObj = response.getResult();
    //     assertNotNull(responseObj);
    // }

    // @Test
    // public void testGetCustomizationRequestByIdWOptions() throws Throwable {
    //     assertNotNull(service);

    //     // Construct an instance of the GetAllCustomizationRequestsOptions model
    //     GetAllCustomizationRequestsOptions getAllCustomizationRequestsOptionsModel = new GetAllCustomizationRequestsOptions.Builder()
    //     .instanceGuid(instanceGuid)
    //     .build();

    //     // Invoke operation with valid options model (positive test)
    //     Response<List<AnalyticsEngineCustomizationRequestCollectionItem>> responseId = service.getAllCustomizationRequests(getAllCustomizationRequestsOptionsModel).execute();
    //     List<AnalyticsEngineCustomizationRequestCollectionItem> responseObjId = responseId.getResult();
    //     assertNotNull(responseObjId);
    //     String requestId = responseObjId.get(0).getId();
    //     System.out.println(requestId);

    //     // Construct an instance of the GetCustomizationRequestByIdOptions model
    //     GetCustomizationRequestByIdOptions getCustomizationRequestByIdOptionsModel = new GetCustomizationRequestByIdOptions.Builder()
    //     .instanceGuid(instanceGuid)
    //     .requestId(requestId)
    //     .build();

    //     // Invoke operation with valid options model (positive test)
    //     Response<AnalyticsEngineCustomizationRunDetails> response = service.getCustomizationRequestById(getCustomizationRequestByIdOptionsModel).execute();
    //     assertNotNull(response);
    //     assertEquals(response.getStatusCode(), 200);
    //     AnalyticsEngineCustomizationRunDetails responseObj = response.getResult();
    //     assertNotNull(responseObj);
    // }

    // @Test
    // public void testResizeClusterWOptions() throws Throwable {
    //     assertNotNull(service);

    //     // Construct an instance of the ResizeClusterOptions model
    //     ResizeClusterOptions resizeClusterOptionsModel = new ResizeClusterOptions.Builder()
    //     .instanceGuid(instanceGuid)
    //     .computeNodesCount(Long.valueOf("2"))
    //     .build();

    //     // Invoke operation with valid options model (positive test)
    //     Response<AnalyticsEngineResizeClusterResponse> response = service.resizeCluster(resizeClusterOptionsModel).execute();
    //     assertNotNull(response);
    //     assertEquals(response.getStatusCode(), 200);
    //     AnalyticsEngineResizeClusterResponse responseObj = response.getResult();
    //     assertNotNull(responseObj);
    // }

    // @Test
    // public void testResetClusterPasswordWOptions() throws Throwable {
    //     assertNotNull(service);

    //     // Construct an instance of the ResetClusterPasswordOptions model
    //     ResetClusterPasswordOptions resetClusterPasswordOptionsModel = new ResetClusterPasswordOptions.Builder()
    //     .instanceGuid(instanceGuid)
    //     .build();

    //     // Invoke operation with valid options model (positive test)
    //     Response<AnalyticsEngineResetClusterPasswordResponse> response = service.resetClusterPassword(resetClusterPasswordOptionsModel).execute();
    //     assertNotNull(response);
    //     assertEquals(response.getStatusCode(), 200);
    //     AnalyticsEngineResetClusterPasswordResponse responseObj = response.getResult();
    //     assertNotNull(responseObj);
    // }

    // @Test
    // public void testConfigureLoggingWOptions() throws Throwable {
    //     assertNotNull(service);

    //     // Construct an instance of the AnalyticsEngineLoggingServer model
    //     AnalyticsEngineLoggingServer analyticsEngineLoggingServerModel = new AnalyticsEngineLoggingServer.Builder()
    //     .type("logdna")
    //     .credential("testString")
    //     .apiHost("testString")
    //     .logHost("testString")
    //     .owner("testString")
    //     .build();

    //     // Construct an instance of the AnalyticsEngineLoggingNodeSpec model
    //     AnalyticsEngineLoggingNodeSpec analyticsEngineLoggingNodeSpecModel = new AnalyticsEngineLoggingNodeSpec.Builder()
    //     .nodeType("management")
    //     .components(new ArrayList<String>(Arrays.asList("ambari-server")))
    //     .build();

    //     // Construct an instance of the ConfigureLoggingOptions model
    //     ConfigureLoggingOptions configureLoggingOptionsModel = new ConfigureLoggingOptions.Builder()
    //     .instanceGuid(instanceGuid)
    //     .logSpecs(new ArrayList<AnalyticsEngineLoggingNodeSpec>(Arrays.asList(analyticsEngineLoggingNodeSpecModel)))
    //     .logServer(analyticsEngineLoggingServerModel)
    //     .build();

    //     // Invoke operation with valid options model (positive test)
    //     Response<Void> response = service.configureLogging(configureLoggingOptionsModel).execute();
    //     assertNotNull(response);
    //     assertEquals(response.getStatusCode(), 202);
    //     Void responseObj = response.getResult();
    //     // Response does not have a return type. Check that the result is null.
    //     assertNull(responseObj);
    // }

    // @Test
    // public void testGetLoggingConfigWOptions() throws Throwable {
    //     assertNotNull(service);

    //     // Construct an instance of the GetLoggingConfigOptions model
    //     GetLoggingConfigOptions getLoggingConfigOptionsModel = new GetLoggingConfigOptions.Builder()
    //     .instanceGuid(instanceGuid)
    //     .build();

    //     // Invoke operation with valid options model (positive test)
    //     Response<AnalyticsEngineLoggingConfigDetails> response = service.getLoggingConfig(getLoggingConfigOptionsModel).execute();
    //     assertNotNull(response);
    //     assertEquals(response.getStatusCode(), 200);
    //     AnalyticsEngineLoggingConfigDetails responseObj = response.getResult();
    //     assertNotNull(responseObj);
    // }

    // @Test
    // public void testDeleteLoggingConfigWOptions() throws Throwable {
    //     assertNotNull(service);

    //     // Construct an instance of the DeleteLoggingConfigOptions model
    //     DeleteLoggingConfigOptions deleteLoggingConfigOptionsModel = new DeleteLoggingConfigOptions.Builder()
    //     .instanceGuid(instanceGuid)
    //     .build();

    //     // Invoke operation with valid options model (positive test)
    //     Response<Void> response = service.deleteLoggingConfig(deleteLoggingConfigOptionsModel).execute();
    //     assertNotNull(response);
    //     assertEquals(response.getStatusCode(), 202);
    //     Void responseObj = response.getResult();
    //     // Response does not have a return type. Check that the result is null.
    //     assertNull(responseObj);
    // }
}