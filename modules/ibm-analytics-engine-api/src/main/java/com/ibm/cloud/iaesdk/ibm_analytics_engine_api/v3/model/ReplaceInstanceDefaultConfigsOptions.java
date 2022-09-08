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

import java.util.Map;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The replaceInstanceDefaultConfigs options.
 */
public class ReplaceInstanceDefaultConfigsOptions extends GenericModel {

  protected String instanceId;
  protected Map<String, String> body;

  /**
   * Builder.
   */
  public static class Builder {
    private String instanceId;
    private Map<String, String> body;

    private Builder(ReplaceInstanceDefaultConfigsOptions replaceInstanceDefaultConfigsOptions) {
      this.instanceId = replaceInstanceDefaultConfigsOptions.instanceId;
      this.body = replaceInstanceDefaultConfigsOptions.body;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param instanceId the instanceId
     * @param body the body
     */
    public Builder(String instanceId, Map<String, String> body) {
      this.instanceId = instanceId;
      this.body = body;
    }

    /**
     * Builds a ReplaceInstanceDefaultConfigsOptions.
     *
     * @return the new ReplaceInstanceDefaultConfigsOptions instance
     */
    public ReplaceInstanceDefaultConfigsOptions build() {
      return new ReplaceInstanceDefaultConfigsOptions(this);
    }

    /**
     * Set the instanceId.
     *
     * @param instanceId the instanceId
     * @return the ReplaceInstanceDefaultConfigsOptions builder
     */
    public Builder instanceId(String instanceId) {
      this.instanceId = instanceId;
      return this;
    }

    /**
     * Set the body.
     *
     * @param body the body
     * @return the ReplaceInstanceDefaultConfigsOptions builder
     */
    public Builder body(Map<String, String> body) {
      this.body = body;
      return this;
    }
  }

  protected ReplaceInstanceDefaultConfigsOptions() { }

  protected ReplaceInstanceDefaultConfigsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.instanceId,
      "instanceId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.body,
      "body cannot be null");
    instanceId = builder.instanceId;
    body = builder.body;
  }

  /**
   * New builder.
   *
   * @return a ReplaceInstanceDefaultConfigsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the instanceId.
   *
   * The ID of the Analytics Engine instance.
   *
   * @return the instanceId
   */
  public String instanceId() {
    return instanceId;
  }

  /**
   * Gets the body.
   *
   * Spark configuration properties to replace existing instance default Spark configurations.
   *
   * @return the body
   */
  public Map<String, String> body() {
    return body;
  }
}

