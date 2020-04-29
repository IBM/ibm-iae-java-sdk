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

import com.google.gson.JsonObject;
import com.ibm.cloud.iaesdk.common.SdkCommon;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2.model.AnalyticsEngine;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2.model.AnalyticsEngineCreateCustomizationResponse;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2.model.AnalyticsEngineCustomizationRunDetails;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2.model.AnalyticsEngineLoggingConfigDetails;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2.model.AnalyticsEngineResetClusterPasswordResponse;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2.model.AnalyticsEngineResizeClusterResponse;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2.model.AnalyticsEngineState;
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
import com.ibm.cloud.sdk.core.http.RequestBuilder;
import com.ibm.cloud.sdk.core.http.ResponseConverter;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.ConfigBasedAuthenticatorFactory;
import com.ibm.cloud.sdk.core.service.BaseService;
import com.ibm.cloud.sdk.core.util.ResponseConverterUtils;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * With IBM Analytics Engine you can create Apache Spark and Apache Hadoop clusters and customize these clusters by
 * using scripts. You can work with data in IBM Cloud Object Storage, as well as integrate other Watson Data Platform
 * services like IBM Watson Studio and Machine Learning.
 *
 * @version v2
 */
public class IbmAnalyticsEngineApi extends BaseService {

  public static final String DEFAULT_SERVICE_NAME = "ibm_analytics_engine_api";

  public static final String DEFAULT_SERVICE_URL = "https://ibm-analytics-engine-api.cloud.ibm.com/";

 /**
   * Class method which constructs an instance of the `IbmAnalyticsEngineApi` client.
   * The default service name is used to configure the client instance.
   *
   * @return an instance of the `IbmAnalyticsEngineApi` client using external configuration
   */
  public static IbmAnalyticsEngineApi newInstance() {
    return newInstance(DEFAULT_SERVICE_NAME);
  }

  /**
   * Class method which constructs an instance of the `IbmAnalyticsEngineApi` client.
   * The specified service name is used to configure the client instance.
   *
   * @param serviceName the service name to be used when configuring the client instance
   * @return an instance of the `IbmAnalyticsEngineApi` client using external configuration
   */
  public static IbmAnalyticsEngineApi newInstance(String serviceName) {
    Authenticator authenticator = ConfigBasedAuthenticatorFactory.getAuthenticator(serviceName);
    IbmAnalyticsEngineApi service = new IbmAnalyticsEngineApi(serviceName, authenticator);
    service.configureService(serviceName);
    return service;
  }

  /**
   * Constructs an instance of the `IbmAnalyticsEngineApi` client.
   * The specified service name and authenticator are used to configure the client instance.
   *
   * @param serviceName the service name to be used when configuring the client instance
   * @param authenticator the {@link Authenticator} instance to be configured for this client
   */
  public IbmAnalyticsEngineApi(String serviceName, Authenticator authenticator) {
    super(serviceName, authenticator);
    setServiceUrl(DEFAULT_SERVICE_URL);
  }

  /**
   * List all Analytics Engines.
   *
   * Currently, you cannot fetch the list of all IBM Analytics Engine service instances through this REST API. You
   * should use the IBM Cloud CLI instead.  For example, ```ibmcloud resource service-instances --service-name
   * ibmanalyticsengine```.
   *
   * @param getAllAnalyticsEnginesOptions the {@link GetAllAnalyticsEnginesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> getAllAnalyticsEngines(GetAllAnalyticsEnginesOptions getAllAnalyticsEnginesOptions) {
    String[] pathSegments = { "v2/analytics_engines" };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_analytics_engine_api", "v2", "getAllAnalyticsEngines");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List all Analytics Engines.
   *
   * Currently, you cannot fetch the list of all IBM Analytics Engine service instances through this REST API. You
   * should use the IBM Cloud CLI instead.  For example, ```ibmcloud resource service-instances --service-name
   * ibmanalyticsengine```.
   *
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> getAllAnalyticsEngines() {
    return getAllAnalyticsEngines(null);
  }

  /**
   * Get details of Analytics Engine.
   *
   * Retrieves the following details of the IBM Analytics Engine service instance:
   * * Hardware size and software package
   *  * Timestamps at which the cluster was created, deleted or updated
   *  * Service endpoint URLs
   *
   *  **NOTE:** No credentials are returned. You can get the IBM Analytics Engine service instance credentials by
   * invoking the reset_password REST API.
   *
   * @param getAnalyticsEngineByIdOptions the {@link GetAnalyticsEngineByIdOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link AnalyticsEngine}
   */
  public ServiceCall<AnalyticsEngine> getAnalyticsEngineById(GetAnalyticsEngineByIdOptions getAnalyticsEngineByIdOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getAnalyticsEngineByIdOptions,
      "getAnalyticsEngineByIdOptions cannot be null");
    String[] pathSegments = { "v2/analytics_engines" };
    String[] pathParameters = { getAnalyticsEngineByIdOptions.instanceGuid() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_analytics_engine_api", "v2", "getAnalyticsEngineById");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");

    ResponseConverter<AnalyticsEngine> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<AnalyticsEngine>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get state of Analytics Engine.
   *
   * Returns the state of the Analytics Engine cluster. The following states exist:
   * * Preparing : A cluster is being created.
   * * Active : The cluster is created and running.
   * * Deleted : The cluster was deleted.
   * * Failed : A cluster couldn't be created.
   * * Expired : The service instance has expired. The cluster has been deleted.
   * * ResizeFailed : The cluster couldn't be resized. The cluster will be reactivated based on the old settings.
   *
   * @param getAnalyticsEngineStateByIdOptions the {@link GetAnalyticsEngineStateByIdOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link AnalyticsEngineState}
   */
  public ServiceCall<AnalyticsEngineState> getAnalyticsEngineStateById(GetAnalyticsEngineStateByIdOptions getAnalyticsEngineStateByIdOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getAnalyticsEngineStateByIdOptions,
      "getAnalyticsEngineStateByIdOptions cannot be null");
    String[] pathSegments = { "v2/analytics_engines", "state" };
    String[] pathParameters = { getAnalyticsEngineStateByIdOptions.instanceGuid() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_analytics_engine_api", "v2", "getAnalyticsEngineStateById");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");

    ResponseConverter<AnalyticsEngineState> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<AnalyticsEngineState>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create an adhoc customization request.
   *
   * Creates a new adhoc customization request. Adhoc customization scripts can be run only once. They are not persisted
   * with the cluster and are not run automatically when more nodes are added to the cluster.
   *
   * @param createCustomizationRequestOptions the {@link CreateCustomizationRequestOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link AnalyticsEngineCreateCustomizationResponse}
   */
  public ServiceCall<AnalyticsEngineCreateCustomizationResponse> createCustomizationRequest(CreateCustomizationRequestOptions createCustomizationRequestOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createCustomizationRequestOptions,
      "createCustomizationRequestOptions cannot be null");
    String[] pathSegments = { "v2/analytics_engines", "customization_requests" };
    String[] pathParameters = { createCustomizationRequestOptions.instanceGuid() };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_analytics_engine_api", "v2", "createCustomizationRequest");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("target", createCustomizationRequestOptions.target());
    contentJson.add("custom_actions", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createCustomizationRequestOptions.customActions()));
    builder.bodyJson(contentJson);
    ResponseConverter<AnalyticsEngineCreateCustomizationResponse> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<AnalyticsEngineCreateCustomizationResponse>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get all customization requests run on an Analytics Engine cluster.
   *
   * Retrieves the request_id of all customization requests submitted to the specified Analytics Engine cluster.
   *
   * @param getAllCustomizationRequestsOptions the {@link GetAllCustomizationRequestsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link List}
   */
  public ServiceCall<List<AnalyticsEngineCreateCustomizationResponse>> getAllCustomizationRequests(GetAllCustomizationRequestsOptions getAllCustomizationRequestsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getAllCustomizationRequestsOptions,
      "getAllCustomizationRequestsOptions cannot be null");
    String[] pathSegments = { "v2/analytics_engines", "customization_requests" };
    String[] pathParameters = { getAllCustomizationRequestsOptions.instanceGuid() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_analytics_engine_api", "v2", "getAllCustomizationRequests");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");

    ResponseConverter<List<AnalyticsEngineCreateCustomizationResponse>> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<List<AnalyticsEngineCreateCustomizationResponse>>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieve details of specified customization request ID.
   *
   * Retrieves the status of the specified customization request, along with pointers to log files generated during the
   * run.
   *
   * @param getCustomizationRequestByIdOptions the {@link GetCustomizationRequestByIdOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link AnalyticsEngineCustomizationRunDetails}
   */
  public ServiceCall<AnalyticsEngineCustomizationRunDetails> getCustomizationRequestById(GetCustomizationRequestByIdOptions getCustomizationRequestByIdOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getCustomizationRequestByIdOptions,
      "getCustomizationRequestByIdOptions cannot be null");
    String[] pathSegments = { "v2/analytics_engines", "customization_requests" };
    String[] pathParameters = { getCustomizationRequestByIdOptions.instanceGuid(), getCustomizationRequestByIdOptions.requestId() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_analytics_engine_api", "v2", "getCustomizationRequestById");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");

    ResponseConverter<AnalyticsEngineCustomizationRunDetails> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<AnalyticsEngineCustomizationRunDetails>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Add nodes to the cluster.
   *
   * Resizes the cluster by adding compute nodes.
   *
   * **Note:** You can't resize the cluster if the software package on the cluster is deprecated or if the software
   * package doesn't permit cluster resizing. See
   * [here](https://cloud.ibm.com/docs/AnalyticsEngine?topic=AnalyticsEngine-unsupported-operations).
   *
   * @param resizeClusterOptions the {@link ResizeClusterOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link AnalyticsEngineResizeClusterResponse}
   */
  public ServiceCall<AnalyticsEngineResizeClusterResponse> resizeCluster(ResizeClusterOptions resizeClusterOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(resizeClusterOptions,
      "resizeClusterOptions cannot be null");
    String[] pathSegments = { "v2/analytics_engines", "resize" };
    String[] pathParameters = { resizeClusterOptions.instanceGuid() };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_analytics_engine_api", "v2", "resizeCluster");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    if (resizeClusterOptions.computeNodesCount() != null) {
      contentJson.addProperty("compute_nodes_count", resizeClusterOptions.computeNodesCount());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<AnalyticsEngineResizeClusterResponse> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<AnalyticsEngineResizeClusterResponse>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Reset cluster password.
   *
   * Resets the cluster's password to a new system-generated crytographically strong value.  The new password is
   * included in the response and you should make a note of it.  This password is displayed only once here and cannot be
   * retrieved later.
   *
   * @param resetClusterPasswordOptions the {@link ResetClusterPasswordOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link AnalyticsEngineResetClusterPasswordResponse}
   */
  public ServiceCall<AnalyticsEngineResetClusterPasswordResponse> resetClusterPassword(ResetClusterPasswordOptions resetClusterPasswordOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(resetClusterPasswordOptions,
      "resetClusterPasswordOptions cannot be null");
    String[] pathSegments = { "v2/analytics_engines", "reset_password" };
    String[] pathParameters = { resetClusterPasswordOptions.instanceGuid() };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_analytics_engine_api", "v2", "resetClusterPassword");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");

    ResponseConverter<AnalyticsEngineResetClusterPasswordResponse> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<AnalyticsEngineResetClusterPasswordResponse>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Configure log aggregation.
   *
   * Collects the logs for the following components in an IBM Analytics Engine cluster:
   * * IBM Analytics Engine daemon logs, for example those for Spark, Hive, Yarn, and Knox on the management and data
   * nodes
   * * Yarn application job logs.
   *
   * @param configureLoggingOptions the {@link ConfigureLoggingOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> configureLogging(ConfigureLoggingOptions configureLoggingOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(configureLoggingOptions,
      "configureLoggingOptions cannot be null");
    String[] pathSegments = { "v2/analytics_engines", "log_config" };
    String[] pathParameters = { configureLoggingOptions.instanceGuid() };
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_analytics_engine_api", "v2", "configureLogging");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    final JsonObject contentJson = new JsonObject();
    contentJson.add("log_specs", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(configureLoggingOptions.logSpecs()));
    contentJson.add("log_server", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(configureLoggingOptions.logServer()));
    builder.bodyJson(contentJson);
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieve the status of log configuration.
   *
   * Retrieves the status and details of the log configuration for your cluster.
   *
   * @param getLoggingConfigOptions the {@link GetLoggingConfigOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link AnalyticsEngineLoggingConfigDetails}
   */
  public ServiceCall<AnalyticsEngineLoggingConfigDetails> getLoggingConfig(GetLoggingConfigOptions getLoggingConfigOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getLoggingConfigOptions,
      "getLoggingConfigOptions cannot be null");
    String[] pathSegments = { "v2/analytics_engines", "log_config" };
    String[] pathParameters = { getLoggingConfigOptions.instanceGuid() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_analytics_engine_api", "v2", "getLoggingConfig");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");

    ResponseConverter<AnalyticsEngineLoggingConfigDetails> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<AnalyticsEngineLoggingConfigDetails>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete the log configuration.
   *
   * Deletes the log configuration. This operation stops sending logs to the centralized log server.
   *
   * @param deleteLoggingConfigOptions the {@link DeleteLoggingConfigOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteLoggingConfig(DeleteLoggingConfigOptions deleteLoggingConfigOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteLoggingConfigOptions,
      "deleteLoggingConfigOptions cannot be null");
    String[] pathSegments = { "v2/analytics_engines", "log_config" };
    String[] pathParameters = { deleteLoggingConfigOptions.instanceGuid() };
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_analytics_engine_api", "v2", "deleteLoggingConfig");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }

    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

}
