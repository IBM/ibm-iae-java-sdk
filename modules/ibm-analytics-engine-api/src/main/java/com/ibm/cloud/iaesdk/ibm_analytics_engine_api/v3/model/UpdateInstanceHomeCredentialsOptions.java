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
package com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The updateInstanceHomeCredentials options.
 */
public class UpdateInstanceHomeCredentialsOptions extends GenericModel {

  protected String instanceId;
  protected String hmacAccessKey;
  protected String hmacSecretKey;

  /**
   * Builder.
   */
  public static class Builder {
    private String instanceId;
    private String hmacAccessKey;
    private String hmacSecretKey;

    /**
     * Instantiates a new Builder from an existing UpdateInstanceHomeCredentialsOptions instance.
     *
     * @param updateInstanceHomeCredentialsOptions the instance to initialize the Builder with
     */
    private Builder(UpdateInstanceHomeCredentialsOptions updateInstanceHomeCredentialsOptions) {
      this.instanceId = updateInstanceHomeCredentialsOptions.instanceId;
      this.hmacAccessKey = updateInstanceHomeCredentialsOptions.hmacAccessKey;
      this.hmacSecretKey = updateInstanceHomeCredentialsOptions.hmacSecretKey;
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
     * @param hmacAccessKey the hmacAccessKey
     * @param hmacSecretKey the hmacSecretKey
     */
    public Builder(String instanceId, String hmacAccessKey, String hmacSecretKey) {
      this.instanceId = instanceId;
      this.hmacAccessKey = hmacAccessKey;
      this.hmacSecretKey = hmacSecretKey;
    }

    /**
     * Builds a UpdateInstanceHomeCredentialsOptions.
     *
     * @return the new UpdateInstanceHomeCredentialsOptions instance
     */
    public UpdateInstanceHomeCredentialsOptions build() {
      return new UpdateInstanceHomeCredentialsOptions(this);
    }

    /**
     * Set the instanceId.
     *
     * @param instanceId the instanceId
     * @return the UpdateInstanceHomeCredentialsOptions builder
     */
    public Builder instanceId(String instanceId) {
      this.instanceId = instanceId;
      return this;
    }

    /**
     * Set the hmacAccessKey.
     *
     * @param hmacAccessKey the hmacAccessKey
     * @return the UpdateInstanceHomeCredentialsOptions builder
     */
    public Builder hmacAccessKey(String hmacAccessKey) {
      this.hmacAccessKey = hmacAccessKey;
      return this;
    }

    /**
     * Set the hmacSecretKey.
     *
     * @param hmacSecretKey the hmacSecretKey
     * @return the UpdateInstanceHomeCredentialsOptions builder
     */
    public Builder hmacSecretKey(String hmacSecretKey) {
      this.hmacSecretKey = hmacSecretKey;
      return this;
    }
  }

  protected UpdateInstanceHomeCredentialsOptions() { }

  protected UpdateInstanceHomeCredentialsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.instanceId,
      "instanceId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.hmacAccessKey,
      "hmacAccessKey cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.hmacSecretKey,
      "hmacSecretKey cannot be null");
    instanceId = builder.instanceId;
    hmacAccessKey = builder.hmacAccessKey;
    hmacSecretKey = builder.hmacSecretKey;
  }

  /**
   * New builder.
   *
   * @return a UpdateInstanceHomeCredentialsOptions builder
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
   * Gets the hmacAccessKey.
   *
   * Cloud Object Storage access key.
   *
   * @return the hmacAccessKey
   */
  public String hmacAccessKey() {
    return hmacAccessKey;
  }

  /**
   * Gets the hmacSecretKey.
   *
   * Cloud Object Storage secret key.
   *
   * @return the hmacSecretKey
   */
  public String hmacSecretKey() {
    return hmacSecretKey;
  }
}

