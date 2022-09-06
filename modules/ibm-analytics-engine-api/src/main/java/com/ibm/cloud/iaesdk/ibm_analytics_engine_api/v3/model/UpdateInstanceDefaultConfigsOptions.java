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
 * The updateInstanceDefaultConfigs options.
 */
public class UpdateInstanceDefaultConfigsOptions extends GenericModel {

  protected String instanceId;
  protected Map<String, Object> body;

  /**
   * Builder.
   */
  public static class Builder {
    private String instanceId;
    private Map<String, Object> body;

    private Builder(UpdateInstanceDefaultConfigsOptions updateInstanceDefaultConfigsOptions) {
      this.instanceId = updateInstanceDefaultConfigsOptions.instanceId;
      this.body = updateInstanceDefaultConfigsOptions.body;
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
    public Builder(String instanceId, Map<String, Object> body) {
      this.instanceId = instanceId;
      this.body = body;
    }

    /**
     * Builds a UpdateInstanceDefaultConfigsOptions.
     *
     * @return the new UpdateInstanceDefaultConfigsOptions instance
     */
    public UpdateInstanceDefaultConfigsOptions build() {
      return new UpdateInstanceDefaultConfigsOptions(this);
    }

    /**
     * Set the instanceId.
     *
     * @param instanceId the instanceId
     * @return the UpdateInstanceDefaultConfigsOptions builder
     */
    public Builder instanceId(String instanceId) {
      this.instanceId = instanceId;
      return this;
    }

    /**
     * Set the body.
     *
     * @param body the body
     * @return the UpdateInstanceDefaultConfigsOptions builder
     */
    public Builder body(Map<String, Object> body) {
      this.body = body;
      return this;
    }
  }

  protected UpdateInstanceDefaultConfigsOptions() { }

  protected UpdateInstanceDefaultConfigsOptions(Builder builder) {
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
   * @return a UpdateInstanceDefaultConfigsOptions builder
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
   * Spark configuration properties to be updated. Properties will be merged with existing configuration properties. Set
   * a property value to `null` in order to unset it.
   *
   * @return the body
   */
  public Map<String, Object> body() {
    return body;
  }
}

