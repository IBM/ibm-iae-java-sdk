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

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The configureLogging options.
 */
public class ConfigureLoggingOptions extends GenericModel {

  protected String instanceGuid;
  protected List<AnalyticsEngineLoggingNodeSpec> logSpecs;
  protected AnalyticsEngineLoggingServer logServer;

  /**
   * Builder.
   */
  public static class Builder {
    private String instanceGuid;
    private List<AnalyticsEngineLoggingNodeSpec> logSpecs;
    private AnalyticsEngineLoggingServer logServer;

    private Builder(ConfigureLoggingOptions configureLoggingOptions) {
      this.instanceGuid = configureLoggingOptions.instanceGuid;
      this.logSpecs = configureLoggingOptions.logSpecs;
      this.logServer = configureLoggingOptions.logServer;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param instanceGuid the instanceGuid
     * @param logSpecs the logSpecs
     * @param logServer the logServer
     */
    public Builder(String instanceGuid, List<AnalyticsEngineLoggingNodeSpec> logSpecs, AnalyticsEngineLoggingServer logServer) {
      this.instanceGuid = instanceGuid;
      this.logSpecs = logSpecs;
      this.logServer = logServer;
    }

    /**
     * Builds a ConfigureLoggingOptions.
     *
     * @return the new ConfigureLoggingOptions instance
     */
    public ConfigureLoggingOptions build() {
      return new ConfigureLoggingOptions(this);
    }

    /**
     * Adds an logSpecs to logSpecs.
     *
     * @param logSpecs the new logSpecs
     * @return the ConfigureLoggingOptions builder
     */
    public Builder addLogSpecs(AnalyticsEngineLoggingNodeSpec logSpecs) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(logSpecs,
        "logSpecs cannot be null");
      if (this.logSpecs == null) {
        this.logSpecs = new ArrayList<AnalyticsEngineLoggingNodeSpec>();
      }
      this.logSpecs.add(logSpecs);
      return this;
    }

    /**
     * Set the instanceGuid.
     *
     * @param instanceGuid the instanceGuid
     * @return the ConfigureLoggingOptions builder
     */
    public Builder instanceGuid(String instanceGuid) {
      this.instanceGuid = instanceGuid;
      return this;
    }

    /**
     * Set the logSpecs.
     * Existing logSpecs will be replaced.
     *
     * @param logSpecs the logSpecs
     * @return the ConfigureLoggingOptions builder
     */
    public Builder logSpecs(List<AnalyticsEngineLoggingNodeSpec> logSpecs) {
      this.logSpecs = logSpecs;
      return this;
    }

    /**
     * Set the logServer.
     *
     * @param logServer the logServer
     * @return the ConfigureLoggingOptions builder
     */
    public Builder logServer(AnalyticsEngineLoggingServer logServer) {
      this.logServer = logServer;
      return this;
    }
  }

  protected ConfigureLoggingOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.instanceGuid,
      "instanceGuid cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.logSpecs,
      "logSpecs cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.logServer,
      "logServer cannot be null");
    instanceGuid = builder.instanceGuid;
    logSpecs = builder.logSpecs;
    logServer = builder.logServer;
  }

  /**
   * New builder.
   *
   * @return a ConfigureLoggingOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the instanceGuid.
   *
   * GUID of the service instance.
   *
   * @return the instanceGuid
   */
  public String instanceGuid() {
    return instanceGuid;
  }

  /**
   * Gets the logSpecs.
   *
   * Logging specifications on each node.
   *
   * @return the logSpecs
   */
  public List<AnalyticsEngineLoggingNodeSpec> logSpecs() {
    return logSpecs;
  }

  /**
   * Gets the logServer.
   *
   * Logging server configuration.
   *
   * @return the logServer
   */
  public AnalyticsEngineLoggingServer logServer() {
    return logServer;
  }
}

