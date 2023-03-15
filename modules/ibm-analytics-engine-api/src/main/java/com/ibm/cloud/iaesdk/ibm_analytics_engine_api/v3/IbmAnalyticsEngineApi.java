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

/*
 * IBM OpenAPI SDK Code Generator Version: 3.66.0-d6c2d7e0-20230215-221247
 */

package com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3;

import com.google.gson.JsonObject;
import com.ibm.cloud.iaesdk.common.SdkCommon;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.ApplicationCollection;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.ApplicationGetResponse;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.ApplicationGetStateResponse;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.ApplicationResponse;
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
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.InstanceGetStateResponse;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.InstanceHomeResponse;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.ListApplicationsOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.LogForwardingConfigResponse;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.LoggingConfigurationResponse;
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
import com.ibm.cloud.sdk.core.http.RequestBuilder;
import com.ibm.cloud.sdk.core.http.ResponseConverter;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.ConfigBasedAuthenticatorFactory;
import com.ibm.cloud.sdk.core.service.BaseService;
import com.ibm.cloud.sdk.core.util.RequestUtils;
import com.ibm.cloud.sdk.core.util.ResponseConverterUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Logger;

/**
 * Manage serverless Spark instances and run applications.
 *
 * API Version: 3.0.0
 */
public class IbmAnalyticsEngineApi extends BaseService {
  private static final Logger LOGGER = Logger.getLogger(IbmAnalyticsEngineApi.class.getName());

  /**
   * Default service name used when configuring the `IbmAnalyticsEngineApi` client.
   */
  public static final String DEFAULT_SERVICE_NAME = "ibm_analytics_engine_api";

  /**
   * Default service endpoint URL.
   */
  public static final String DEFAULT_SERVICE_URL = "https://api.us-south.ae.cloud.ibm.com";

  private static final Map<String, String> _regionalEndpoints;
  static {
    Map<String, String> m = new HashMap<>();
    m.put("us-south", "https://api.us-south.ae.cloud.ibm.com");

    m.put("eu-de", "https://api.eu-de.ae.cloud.ibm.com");
    _regionalEndpoints = Collections.unmodifiableMap(m);
  }

  /**
   * Returns the service URL associated with the specified region.
   * @param region a string representing the region
   * @return the service URL associated with the specified region or null
   * if no mapping for the region exists
   */
  public static String getServiceUrlForRegion(String region) {
    return _regionalEndpoints.get(region);
  }

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
	  System.out.println("==========newInstance serviceName=========="+serviceName);
    Authenticator authenticator = ConfigBasedAuthenticatorFactory.getAuthenticator(serviceName);
    System.out.println("==========newInstance serviceName=========="+authenticator);
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
   * Find Analytics Engine by id.
   *
   * Retrieve the details of a single Analytics Engine instance.
   *
   * @param getInstanceOptions the {@link GetInstanceOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Instance}
   */
  public ServiceCall<Instance> getInstance(GetInstanceOptions getInstanceOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getInstanceOptions,
      "getInstanceOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", getInstanceOptions.instanceId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v3/analytics_engines/{instance_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_analytics_engine_api", "v3", "getInstance");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<Instance> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Instance>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Find Analytics Engine state by id.
   *
   * Retrieve the state of a single Analytics Engine instance.
   *
   * @param getInstanceStateOptions the {@link GetInstanceStateOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link InstanceGetStateResponse}
   */
  public ServiceCall<InstanceGetStateResponse> getInstanceState(GetInstanceStateOptions getInstanceStateOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getInstanceStateOptions,
      "getInstanceStateOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", getInstanceStateOptions.instanceId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v3/analytics_engines/{instance_id}/state", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_analytics_engine_api", "v3", "getInstanceState");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<InstanceGetStateResponse> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<InstanceGetStateResponse>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Set instance home.
   *
   * Provide the details of the Cloud Object Storage instance to associate with the Analytics Engine instance and use as
   * 'instance home' if 'instance home' has not already been set.
   *
   * **Note**: You can set 'instance home' again if the instance is in 'instance_home_creation_failure' state.
   *
   * @param setInstanceHomeOptions the {@link SetInstanceHomeOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link InstanceHomeResponse}
   */
  public ServiceCall<InstanceHomeResponse> setInstanceHome(SetInstanceHomeOptions setInstanceHomeOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(setInstanceHomeOptions,
      "setInstanceHomeOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", setInstanceHomeOptions.instanceId());
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v3/analytics_engines/{instance_id}/instance_home", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_analytics_engine_api", "v3", "setInstanceHome");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    if (setInstanceHomeOptions.newInstanceId() != null) {
      contentJson.addProperty("instance_id", setInstanceHomeOptions.newInstanceId());
    }
    if (setInstanceHomeOptions.newProvider() != null) {
      contentJson.addProperty("provider", setInstanceHomeOptions.newProvider());
    }
    if (setInstanceHomeOptions.newType() != null) {
      contentJson.addProperty("type", setInstanceHomeOptions.newType());
    }
    if (setInstanceHomeOptions.newRegion() != null) {
      contentJson.addProperty("region", setInstanceHomeOptions.newRegion());
    }
    if (setInstanceHomeOptions.newEndpoint() != null) {
      contentJson.addProperty("endpoint", setInstanceHomeOptions.newEndpoint());
    }
    if (setInstanceHomeOptions.newHmacAccessKey() != null) {
      contentJson.addProperty("hmac_access_key", setInstanceHomeOptions.newHmacAccessKey());
    }
    if (setInstanceHomeOptions.newHmacSecretKey() != null) {
      contentJson.addProperty("hmac_secret_key", setInstanceHomeOptions.newHmacSecretKey());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<InstanceHomeResponse> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<InstanceHomeResponse>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update instance home credentials.
   *
   * Update the HMAC credentials used to access the instance home, if the instance home was set earlier. Credentials
   * must have write access to the object storage used as instance home.
   *
   * **Note**: Your running applications and the Spark history server would continue to use the old credentials after
   * updating the HMAC credentials. Before revoking the old credentials, you must either wait for them to finish running
   * or stop them.
   *
   * @param updateInstanceHomeCredentialsOptions the {@link UpdateInstanceHomeCredentialsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link InstanceHomeResponse}
   */
  public ServiceCall<InstanceHomeResponse> updateInstanceHomeCredentials(UpdateInstanceHomeCredentialsOptions updateInstanceHomeCredentialsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(updateInstanceHomeCredentialsOptions,
      "updateInstanceHomeCredentialsOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", updateInstanceHomeCredentialsOptions.instanceId());
    RequestBuilder builder = RequestBuilder.patch(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v3/analytics_engines/{instance_id}/instance_home", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_analytics_engine_api", "v3", "updateInstanceHomeCredentials");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("hmac_access_key", updateInstanceHomeCredentialsOptions.hmacAccessKey());
    contentJson.addProperty("hmac_secret_key", updateInstanceHomeCredentialsOptions.hmacSecretKey());
    builder.bodyJson(contentJson);
    ResponseConverter<InstanceHomeResponse> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<InstanceHomeResponse>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get instance default Spark configurations.
   *
   * Get the default Spark configuration properties that will be applied to all applications of the instance.
   *
   * @param getInstanceDefaultConfigsOptions the {@link GetInstanceDefaultConfigsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Map}
   */
  public ServiceCall<Map<String, String>> getInstanceDefaultConfigs(GetInstanceDefaultConfigsOptions getInstanceDefaultConfigsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getInstanceDefaultConfigsOptions,
      "getInstanceDefaultConfigsOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", getInstanceDefaultConfigsOptions.instanceId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v3/analytics_engines/{instance_id}/default_configs", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_analytics_engine_api", "v3", "getInstanceDefaultConfigs");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<Map<String, String>> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Map<String, String>>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Replace instance default Spark configurations.
   *
   * Replace the default Spark configuration properties that will be applied to all applications of the instance.
   *
   * @param replaceInstanceDefaultConfigsOptions the {@link ReplaceInstanceDefaultConfigsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Map}
   */
  public ServiceCall<Map<String, String>> replaceInstanceDefaultConfigs(ReplaceInstanceDefaultConfigsOptions replaceInstanceDefaultConfigsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(replaceInstanceDefaultConfigsOptions,
      "replaceInstanceDefaultConfigsOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", replaceInstanceDefaultConfigsOptions.instanceId());
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v3/analytics_engines/{instance_id}/default_configs", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_analytics_engine_api", "v3", "replaceInstanceDefaultConfigs");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.bodyContent(com.ibm.cloud.sdk.core.util.GsonSingleton.getGsonWithoutPrettyPrinting().toJson(replaceInstanceDefaultConfigsOptions.body()), "application/json");
    ResponseConverter<Map<String, String>> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Map<String, String>>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update instance default Spark configurations.
   *
   * Update the default Spark configuration properties that will be applied to all applications of the instance.
   *
   * @param updateInstanceDefaultConfigsOptions the {@link UpdateInstanceDefaultConfigsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Map}
   */
  public ServiceCall<Map<String, String>> updateInstanceDefaultConfigs(UpdateInstanceDefaultConfigsOptions updateInstanceDefaultConfigsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(updateInstanceDefaultConfigsOptions,
      "updateInstanceDefaultConfigsOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", updateInstanceDefaultConfigsOptions.instanceId());
    RequestBuilder builder = RequestBuilder.patch(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v3/analytics_engines/{instance_id}/default_configs", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_analytics_engine_api", "v3", "updateInstanceDefaultConfigs");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.bodyContent(com.ibm.cloud.sdk.core.util.GsonSingleton.getGsonWithoutPrettyPrinting().toJson(updateInstanceDefaultConfigsOptions.body()), "application/merge-patch+json");
    ResponseConverter<Map<String, String>> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Map<String, String>>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get instance default runtime.
   *
   * Get the default runtime environment on which all workloads of the instance will run.
   *
   * @param getInstanceDefaultRuntimeOptions the {@link GetInstanceDefaultRuntimeOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Runtime}
   */
  public ServiceCall<Runtime> getInstanceDefaultRuntime(GetInstanceDefaultRuntimeOptions getInstanceDefaultRuntimeOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getInstanceDefaultRuntimeOptions,
      "getInstanceDefaultRuntimeOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", getInstanceDefaultRuntimeOptions.instanceId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v3/analytics_engines/{instance_id}/default_runtime", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_analytics_engine_api", "v3", "getInstanceDefaultRuntime");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<Runtime> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Runtime>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Replace instance default runtime.
   *
   * Replace the default runtime environment on which all workloads of the instance will run.
   *
   * @param replaceInstanceDefaultRuntimeOptions the {@link ReplaceInstanceDefaultRuntimeOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Runtime}
   */
  public ServiceCall<Runtime> replaceInstanceDefaultRuntime(ReplaceInstanceDefaultRuntimeOptions replaceInstanceDefaultRuntimeOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(replaceInstanceDefaultRuntimeOptions,
      "replaceInstanceDefaultRuntimeOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", replaceInstanceDefaultRuntimeOptions.instanceId());
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v3/analytics_engines/{instance_id}/default_runtime", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_analytics_engine_api", "v3", "replaceInstanceDefaultRuntime");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    if (replaceInstanceDefaultRuntimeOptions.sparkVersion() != null) {
      contentJson.addProperty("spark_version", replaceInstanceDefaultRuntimeOptions.sparkVersion());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Runtime> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Runtime>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Deploy a Spark application.
   *
   * Deploys a Spark application on a given serverless Spark instance.
   *
   * @param createApplicationOptions the {@link CreateApplicationOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ApplicationResponse}
   */
  public ServiceCall<ApplicationResponse> createApplication(CreateApplicationOptions createApplicationOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createApplicationOptions,
      "createApplicationOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", createApplicationOptions.instanceId());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v3/analytics_engines/{instance_id}/spark_applications", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_analytics_engine_api", "v3", "createApplication");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    if (createApplicationOptions.applicationDetails() != null) {
      contentJson.add("application_details", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createApplicationOptions.applicationDetails()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<ApplicationResponse> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ApplicationResponse>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List all Spark applications.
   *
   * Returns a list of all Spark applications submitted to the specified Analytics Engine instance. The result can be
   * filtered by specifying query parameters.
   *
   * @param listApplicationsOptions the {@link ListApplicationsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ApplicationCollection}
   */
  public ServiceCall<ApplicationCollection> listApplications(ListApplicationsOptions listApplicationsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(listApplicationsOptions,
      "listApplicationsOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", listApplicationsOptions.instanceId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v3/analytics_engines/{instance_id}/spark_applications", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_analytics_engine_api", "v3", "listApplications");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listApplicationsOptions.state() != null) {
      builder.query("state", RequestUtils.join(listApplicationsOptions.state(), ","));
    }
    ResponseConverter<ApplicationCollection> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ApplicationCollection>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieve the details of a given Spark application.
   *
   * Gets the details of a given Spark application.
   *
   * @param getApplicationOptions the {@link GetApplicationOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ApplicationGetResponse}
   */
  public ServiceCall<ApplicationGetResponse> getApplication(GetApplicationOptions getApplicationOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getApplicationOptions,
      "getApplicationOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", getApplicationOptions.instanceId());
    pathParamsMap.put("application_id", getApplicationOptions.applicationId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v3/analytics_engines/{instance_id}/spark_applications/{application_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_analytics_engine_api", "v3", "getApplication");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<ApplicationGetResponse> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ApplicationGetResponse>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Stop application.
   *
   * Stops a running application identified by the app_id identifier. This is an idempotent operation. Performs no
   * action if the requested application is already stopped or completed.
   *
   * @param deleteApplicationOptions the {@link DeleteApplicationOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteApplication(DeleteApplicationOptions deleteApplicationOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteApplicationOptions,
      "deleteApplicationOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", deleteApplicationOptions.instanceId());
    pathParamsMap.put("application_id", deleteApplicationOptions.applicationId());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v3/analytics_engines/{instance_id}/spark_applications/{application_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_analytics_engine_api", "v3", "deleteApplication");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get the status of the application.
   *
   * Returns the status of the given Spark application.
   *
   * @param getApplicationStateOptions the {@link GetApplicationStateOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ApplicationGetStateResponse}
   */
  public ServiceCall<ApplicationGetStateResponse> getApplicationState(GetApplicationStateOptions getApplicationStateOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getApplicationStateOptions,
      "getApplicationStateOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", getApplicationStateOptions.instanceId());
    pathParamsMap.put("application_id", getApplicationStateOptions.applicationId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v3/analytics_engines/{instance_id}/spark_applications/{application_id}/state", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_analytics_engine_api", "v3", "getApplicationState");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<ApplicationGetStateResponse> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ApplicationGetStateResponse>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get current resource consumption.
   *
   * Gives the total memory and virtual processor cores allotted to all the applications running in the service instance
   * at this point in time. When auto-scaled applications are running, the resources allotted will change over time,
   * based on the applications's demands. Note: The consumption is not an indication of actual resource consumption by
   * Spark processes. It is the sum of resources allocated to the currently running applications at the time of
   * application submission.
   *
   * @param getCurrentResourceConsumptionOptions the {@link GetCurrentResourceConsumptionOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link CurrentResourceConsumptionResponse}
   */
  public ServiceCall<CurrentResourceConsumptionResponse> getCurrentResourceConsumption(GetCurrentResourceConsumptionOptions getCurrentResourceConsumptionOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getCurrentResourceConsumptionOptions,
      "getCurrentResourceConsumptionOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", getCurrentResourceConsumptionOptions.instanceId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v3/analytics_engines/{instance_id}/current_resource_consumption", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_analytics_engine_api", "v3", "getCurrentResourceConsumption");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<CurrentResourceConsumptionResponse> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<CurrentResourceConsumptionResponse>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get resource consumption limits.
   *
   * Returns the maximum total memory and virtual processor cores that can be allotted across all the applications
   * running in the service instance at any point in time.
   *
   * @param getResourceConsumptionLimitsOptions the {@link GetResourceConsumptionLimitsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ResourceConsumptionLimitsResponse}
   */
  public ServiceCall<ResourceConsumptionLimitsResponse> getResourceConsumptionLimits(GetResourceConsumptionLimitsOptions getResourceConsumptionLimitsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getResourceConsumptionLimitsOptions,
      "getResourceConsumptionLimitsOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", getResourceConsumptionLimitsOptions.instanceId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v3/analytics_engines/{instance_id}/resource_consumption_limits", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_analytics_engine_api", "v3", "getResourceConsumptionLimits");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<ResourceConsumptionLimitsResponse> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ResourceConsumptionLimitsResponse>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Replace log forwarding configuration.
   *
   * Modify the configuration for forwarding logs from the Analytics Engine instance to IBM Log Analysis server. Use
   * this endpoint to enable or disable log forwarding.
   *
   * @param replaceLogForwardingConfigOptions the {@link ReplaceLogForwardingConfigOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link LogForwardingConfigResponse}
   */
  public ServiceCall<LogForwardingConfigResponse> replaceLogForwardingConfig(ReplaceLogForwardingConfigOptions replaceLogForwardingConfigOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(replaceLogForwardingConfigOptions,
      "replaceLogForwardingConfigOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", replaceLogForwardingConfigOptions.instanceId());
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v3/analytics_engines/{instance_id}/log_forwarding_config", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_analytics_engine_api", "v3", "replaceLogForwardingConfig");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    if (replaceLogForwardingConfigOptions.enabled() != null) {
      contentJson.addProperty("enabled", replaceLogForwardingConfigOptions.enabled());
    }
    if (replaceLogForwardingConfigOptions.sources() != null) {
      contentJson.add("sources", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceLogForwardingConfigOptions.sources()));
    }
    if (replaceLogForwardingConfigOptions.tags() != null) {
      contentJson.add("tags", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceLogForwardingConfigOptions.tags()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<LogForwardingConfigResponse> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<LogForwardingConfigResponse>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get log forwarding configuration.
   *
   * Retrieve the log forwarding configuration of the Analytics Engine instance.
   *
   * @param getLogForwardingConfigOptions the {@link GetLogForwardingConfigOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link LogForwardingConfigResponse}
   */
  public ServiceCall<LogForwardingConfigResponse> getLogForwardingConfig(GetLogForwardingConfigOptions getLogForwardingConfigOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getLogForwardingConfigOptions,
      "getLogForwardingConfigOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", getLogForwardingConfigOptions.instanceId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v3/analytics_engines/{instance_id}/log_forwarding_config", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_analytics_engine_api", "v3", "getLogForwardingConfig");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<LogForwardingConfigResponse> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<LogForwardingConfigResponse>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Enable or disable log forwarding.
   *
   * Enable or disable log forwarding from IBM Analytics Engine to IBM Log Analysis server.
   * *Note:* Deprecated. Use the log forwarding config api instead.
   *
   * @param configurePlatformLoggingOptions the {@link ConfigurePlatformLoggingOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link LoggingConfigurationResponse}
   * @deprecated this method is deprecated and may be removed in a future release
   */
   @Deprecated
  public ServiceCall<LoggingConfigurationResponse> configurePlatformLogging(ConfigurePlatformLoggingOptions configurePlatformLoggingOptions) {
    LOGGER.warning("A deprecated operation has been invoked: configurePlatformLogging");
    com.ibm.cloud.sdk.core.util.Validator.notNull(configurePlatformLoggingOptions,
      "configurePlatformLoggingOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_guid", configurePlatformLoggingOptions.instanceGuid());
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v3/analytics_engines/{instance_guid}/logging", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_analytics_engine_api", "v3", "configurePlatformLogging");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    if (configurePlatformLoggingOptions.enable() != null) {
      contentJson.addProperty("enable", configurePlatformLoggingOptions.enable());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<LoggingConfigurationResponse> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<LoggingConfigurationResponse>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieve the logging configuration for a given instance id.
   *
   * Retrieve the logging configuration of a given Analytics Engine instance.
   * *Note:* Deprecated. Use the log forwarding config api instead.
   *
   * @param getLoggingConfigurationOptions the {@link GetLoggingConfigurationOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link LoggingConfigurationResponse}
   * @deprecated this method is deprecated and may be removed in a future release
   */
   @Deprecated
  public ServiceCall<LoggingConfigurationResponse> getLoggingConfiguration(GetLoggingConfigurationOptions getLoggingConfigurationOptions) {
    LOGGER.warning("A deprecated operation has been invoked: getLoggingConfiguration");
    com.ibm.cloud.sdk.core.util.Validator.notNull(getLoggingConfigurationOptions,
      "getLoggingConfigurationOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_guid", getLoggingConfigurationOptions.instanceGuid());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v3/analytics_engines/{instance_guid}/logging", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_analytics_engine_api", "v3", "getLoggingConfiguration");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<LoggingConfigurationResponse> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<LoggingConfigurationResponse>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Start Spark history server.
   *
   * Start the Spark history server for the given Analytics Engine instance.
   *
   * @param startSparkHistoryServerOptions the {@link StartSparkHistoryServerOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link SparkHistoryServerResponse}
   */
  public ServiceCall<SparkHistoryServerResponse> startSparkHistoryServer(StartSparkHistoryServerOptions startSparkHistoryServerOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(startSparkHistoryServerOptions,
      "startSparkHistoryServerOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", startSparkHistoryServerOptions.instanceId());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v3/analytics_engines/{instance_id}/spark_history_server", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_analytics_engine_api", "v3", "startSparkHistoryServer");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<SparkHistoryServerResponse> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<SparkHistoryServerResponse>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get Spark history server details.
   *
   * Get the details of the Spark history server of the given Analytics Engine instance.
   *
   * @param getSparkHistoryServerOptions the {@link GetSparkHistoryServerOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link SparkHistoryServerResponse}
   */
  public ServiceCall<SparkHistoryServerResponse> getSparkHistoryServer(GetSparkHistoryServerOptions getSparkHistoryServerOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getSparkHistoryServerOptions,
      "getSparkHistoryServerOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", getSparkHistoryServerOptions.instanceId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v3/analytics_engines/{instance_id}/spark_history_server", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_analytics_engine_api", "v3", "getSparkHistoryServer");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<SparkHistoryServerResponse> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<SparkHistoryServerResponse>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Stop Spark history server.
   *
   * Stop the Spark history server of the given Analytics Engine instance.
   *
   * @param stopSparkHistoryServerOptions the {@link StopSparkHistoryServerOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> stopSparkHistoryServer(StopSparkHistoryServerOptions stopSparkHistoryServerOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(stopSparkHistoryServerOptions,
      "stopSparkHistoryServerOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_id", stopSparkHistoryServerOptions.instanceId());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v3/analytics_engines/{instance_id}/spark_history_server", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_analytics_engine_api", "v3", "stopSparkHistoryServer");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

}
