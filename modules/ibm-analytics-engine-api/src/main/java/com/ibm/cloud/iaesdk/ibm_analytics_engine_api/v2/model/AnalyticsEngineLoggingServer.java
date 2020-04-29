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
package com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Logging server configuration.
 */
public class AnalyticsEngineLoggingServer extends GenericModel {

  /**
   * Logging server type.
   */
  public interface Type {
    /** logdna. */
    String LOGDNA = "logdna";
  }

  protected String type;
  protected String credential;
  @SerializedName("api_host")
  protected String apiHost;
  @SerializedName("log_host")
  protected String logHost;
  protected String owner;

  /**
   * Builder.
   */
  public static class Builder {
    private String type;
    private String credential;
    private String apiHost;
    private String logHost;
    private String owner;

    private Builder(AnalyticsEngineLoggingServer analyticsEngineLoggingServer) {
      this.type = analyticsEngineLoggingServer.type;
      this.credential = analyticsEngineLoggingServer.credential;
      this.apiHost = analyticsEngineLoggingServer.apiHost;
      this.logHost = analyticsEngineLoggingServer.logHost;
      this.owner = analyticsEngineLoggingServer.owner;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param type the type
     * @param credential the credential
     * @param apiHost the apiHost
     * @param logHost the logHost
     */
    public Builder(String type, String credential, String apiHost, String logHost) {
      this.type = type;
      this.credential = credential;
      this.apiHost = apiHost;
      this.logHost = logHost;
    }

    /**
     * Builds a AnalyticsEngineLoggingServer.
     *
     * @return the new AnalyticsEngineLoggingServer instance
     */
    public AnalyticsEngineLoggingServer build() {
      return new AnalyticsEngineLoggingServer(this);
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the AnalyticsEngineLoggingServer builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Set the credential.
     *
     * @param credential the credential
     * @return the AnalyticsEngineLoggingServer builder
     */
    public Builder credential(String credential) {
      this.credential = credential;
      return this;
    }

    /**
     * Set the apiHost.
     *
     * @param apiHost the apiHost
     * @return the AnalyticsEngineLoggingServer builder
     */
    public Builder apiHost(String apiHost) {
      this.apiHost = apiHost;
      return this;
    }

    /**
     * Set the logHost.
     *
     * @param logHost the logHost
     * @return the AnalyticsEngineLoggingServer builder
     */
    public Builder logHost(String logHost) {
      this.logHost = logHost;
      return this;
    }

    /**
     * Set the owner.
     *
     * @param owner the owner
     * @return the AnalyticsEngineLoggingServer builder
     */
    public Builder owner(String owner) {
      this.owner = owner;
      return this;
    }
  }

  protected AnalyticsEngineLoggingServer(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.type,
      "type cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.credential,
      "credential cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.apiHost,
      "apiHost cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.logHost,
      "logHost cannot be null");
    type = builder.type;
    credential = builder.credential;
    apiHost = builder.apiHost;
    logHost = builder.logHost;
    owner = builder.owner;
  }

  /**
   * New builder.
   *
   * @return a AnalyticsEngineLoggingServer builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the type.
   *
   * Logging server type.
   *
   * @return the type
   */
  public String type() {
    return type;
  }

  /**
   * Gets the credential.
   *
   * Logging server credential.
   *
   * @return the credential
   */
  public String credential() {
    return credential;
  }

  /**
   * Gets the apiHost.
   *
   * Logging server API host.
   *
   * @return the apiHost
   */
  public String apiHost() {
    return apiHost;
  }

  /**
   * Gets the logHost.
   *
   * Logging server host.
   *
   * @return the logHost
   */
  public String logHost() {
    return logHost;
  }

  /**
   * Gets the owner.
   *
   * Logging server owner.
   *
   * @return the owner
   */
  public String owner() {
    return owner;
  }
}

