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
package com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The configurePlatformLogging options.
 */
public class ConfigurePlatformLoggingOptions extends GenericModel {

  protected String instanceGuid;
  protected Boolean enable;

  /**
   * Builder.
   */
  public static class Builder {
    private String instanceGuid;
    private Boolean enable;

    private Builder(ConfigurePlatformLoggingOptions configurePlatformLoggingOptions) {
      this.instanceGuid = configurePlatformLoggingOptions.instanceGuid;
      this.enable = configurePlatformLoggingOptions.enable;
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
     */
    public Builder(String instanceGuid) {
      this.instanceGuid = instanceGuid;
    }

    /**
     * Builds a ConfigurePlatformLoggingOptions.
     *
     * @return the new ConfigurePlatformLoggingOptions instance
     */
    public ConfigurePlatformLoggingOptions build() {
      return new ConfigurePlatformLoggingOptions(this);
    }

    /**
     * Set the instanceGuid.
     *
     * @param instanceGuid the instanceGuid
     * @return the ConfigurePlatformLoggingOptions builder
     */
    public Builder instanceGuid(String instanceGuid) {
      this.instanceGuid = instanceGuid;
      return this;
    }

    /**
     * Set the enable.
     *
     * @param enable the enable
     * @return the ConfigurePlatformLoggingOptions builder
     */
    public Builder enable(Boolean enable) {
      this.enable = enable;
      return this;
    }
  }

  protected ConfigurePlatformLoggingOptions() { }

  protected ConfigurePlatformLoggingOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.instanceGuid,
      "instanceGuid cannot be empty");
    instanceGuid = builder.instanceGuid;
    enable = builder.enable;
  }

  /**
   * New builder.
   *
   * @return a ConfigurePlatformLoggingOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the instanceGuid.
   *
   * GUID of the instance details for which log forwarding is to be configured.
   *
   * @return the instanceGuid
   */
  public String instanceGuid() {
    return instanceGuid;
  }

  /**
   * Gets the enable.
   *
   * Enable or disable log forwarding.
   *
   * @return the enable
   */
  public Boolean enable() {
    return enable;
  }
}

