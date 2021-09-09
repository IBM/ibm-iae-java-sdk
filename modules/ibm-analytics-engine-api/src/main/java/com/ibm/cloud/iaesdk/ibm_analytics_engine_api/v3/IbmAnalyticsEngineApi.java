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

/*
 * IBM OpenAPI SDK Code Generator Version: 3.38.0-07189efd-20210827-205025
 */

package com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3;

import com.google.gson.JsonObject;
import com.ibm.cloud.iaesdk.common.SdkCommon;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.ApplicationCollection;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.ApplicationGetResponse;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.ApplicationGetStateResponse;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.ApplicationResponse;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.CreateApplicationOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.DeleteApplicationOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.GetApplicationOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.GetApplicationStateOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.GetInstanceOptions;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.Instance;
import com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model.ListApplicationsOptions;
import com.ibm.cloud.sdk.core.http.RequestBuilder;
import com.ibm.cloud.sdk.core.http.ResponseConverter;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.ConfigBasedAuthenticatorFactory;
import com.ibm.cloud.sdk.core.service.BaseService;
import com.ibm.cloud.sdk.core.util.ResponseConverterUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Manage serverless Spark instances and run applications.
 *
 * API Version: 3.0.0
 */
public class IbmAnalyticsEngineApi extends BaseService {

  public static final String DEFAULT_SERVICE_NAME = "ibm_analytics_engine_api";

  public static final String DEFAULT_SERVICE_URL = "https://api.us-south.ae.cloud.ibm.com";

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
   * Retrieve all Spark applications.
   *
   * Gets all applications submitted in an instance with a specified instance-id.
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
    ResponseConverter<ApplicationCollection> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ApplicationCollection>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieve the details of a given Spark application.
   *
   * Gets the details of the given Spark application.
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

}
