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
 * The setInstanceHome options.
 */
public class SetInstanceHomeOptions extends GenericModel {

  protected String instanceId;
  protected String newInstanceId;
  protected String newProvider;
  protected String newType;
  protected String newRegion;
  protected String newEndpoint;
  protected String newHmacAccessKey;
  protected String newHmacSecretKey;

  /**
   * Builder.
   */
  public static class Builder {
    private String instanceId;
    private String newInstanceId;
    private String newProvider;
    private String newType;
    private String newRegion;
    private String newEndpoint;
    private String newHmacAccessKey;
    private String newHmacSecretKey;

    private Builder(SetInstanceHomeOptions setInstanceHomeOptions) {
      this.instanceId = setInstanceHomeOptions.instanceId;
      this.newInstanceId = setInstanceHomeOptions.newInstanceId;
      this.newProvider = setInstanceHomeOptions.newProvider;
      this.newType = setInstanceHomeOptions.newType;
      this.newRegion = setInstanceHomeOptions.newRegion;
      this.newEndpoint = setInstanceHomeOptions.newEndpoint;
      this.newHmacAccessKey = setInstanceHomeOptions.newHmacAccessKey;
      this.newHmacSecretKey = setInstanceHomeOptions.newHmacSecretKey;
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
     */
    public Builder(String instanceId) {
      this.instanceId = instanceId;
    }

    /**
     * Builds a SetInstanceHomeOptions.
     *
     * @return the new SetInstanceHomeOptions instance
     */
    public SetInstanceHomeOptions build() {
      return new SetInstanceHomeOptions(this);
    }

    /**
     * Set the instanceId.
     *
     * @param instanceId the instanceId
     * @return the SetInstanceHomeOptions builder
     */
    public Builder instanceId(String instanceId) {
      this.instanceId = instanceId;
      return this;
    }

    /**
     * Set the newInstanceId.
     *
     * @param newInstanceId the newInstanceId
     * @return the SetInstanceHomeOptions builder
     */
    public Builder newInstanceId(String newInstanceId) {
      this.newInstanceId = newInstanceId;
      return this;
    }

    /**
     * Set the newProvider.
     *
     * @param newProvider the newProvider
     * @return the SetInstanceHomeOptions builder
     */
    public Builder newProvider(String newProvider) {
      this.newProvider = newProvider;
      return this;
    }

    /**
     * Set the newType.
     *
     * @param newType the newType
     * @return the SetInstanceHomeOptions builder
     */
    public Builder newType(String newType) {
      this.newType = newType;
      return this;
    }

    /**
     * Set the newRegion.
     *
     * @param newRegion the newRegion
     * @return the SetInstanceHomeOptions builder
     */
    public Builder newRegion(String newRegion) {
      this.newRegion = newRegion;
      return this;
    }

    /**
     * Set the newEndpoint.
     *
     * @param newEndpoint the newEndpoint
     * @return the SetInstanceHomeOptions builder
     */
    public Builder newEndpoint(String newEndpoint) {
      this.newEndpoint = newEndpoint;
      return this;
    }

    /**
     * Set the newHmacAccessKey.
     *
     * @param newHmacAccessKey the newHmacAccessKey
     * @return the SetInstanceHomeOptions builder
     */
    public Builder newHmacAccessKey(String newHmacAccessKey) {
      this.newHmacAccessKey = newHmacAccessKey;
      return this;
    }

    /**
     * Set the newHmacSecretKey.
     *
     * @param newHmacSecretKey the newHmacSecretKey
     * @return the SetInstanceHomeOptions builder
     */
    public Builder newHmacSecretKey(String newHmacSecretKey) {
      this.newHmacSecretKey = newHmacSecretKey;
      return this;
    }
  }

  protected SetInstanceHomeOptions() { }

  protected SetInstanceHomeOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.instanceId,
      "instanceId cannot be empty");
    instanceId = builder.instanceId;
    newInstanceId = builder.newInstanceId;
    newProvider = builder.newProvider;
    newType = builder.newType;
    newRegion = builder.newRegion;
    newEndpoint = builder.newEndpoint;
    newHmacAccessKey = builder.newHmacAccessKey;
    newHmacSecretKey = builder.newHmacSecretKey;
  }

  /**
   * New builder.
   *
   * @return a SetInstanceHomeOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the instanceId.
   *
   * The ID of the Analytics Engine instance for which 'instance home' is to be set.
   *
   * @return the instanceId
   */
  public String instanceId() {
    return instanceId;
  }

  /**
   * Gets the newInstanceId.
   *
   * UUID of the instance home storage instance.
   *
   * @return the newInstanceId
   */
  public String newInstanceId() {
    return newInstanceId;
  }

  /**
   * Gets the newProvider.
   *
   * Currently only ibm-cos (IBM Cloud Object Storage) is supported.
   *
   * @return the newProvider
   */
  public String newProvider() {
    return newProvider;
  }

  /**
   * Gets the newType.
   *
   * Type of the instance home storage. Currently, only objectstore (Cloud Object Storage) is supported.
   *
   * @return the newType
   */
  public String newType() {
    return newType;
  }

  /**
   * Gets the newRegion.
   *
   * Region of the Cloud Object Storage instance.
   *
   * @return the newRegion
   */
  public String newRegion() {
    return newRegion;
  }

  /**
   * Gets the newEndpoint.
   *
   * Endpoint to access the Cloud Object Storage instance.
   *
   * @return the newEndpoint
   */
  public String newEndpoint() {
    return newEndpoint;
  }

  /**
   * Gets the newHmacAccessKey.
   *
   * Cloud Object Storage access key.
   *
   * @return the newHmacAccessKey
   */
  public String newHmacAccessKey() {
    return newHmacAccessKey;
  }

  /**
   * Gets the newHmacSecretKey.
   *
   * Cloud Object Storage secret key.
   *
   * @return the newHmacSecretKey
   */
  public String newHmacSecretKey() {
    return newHmacSecretKey;
  }
}

