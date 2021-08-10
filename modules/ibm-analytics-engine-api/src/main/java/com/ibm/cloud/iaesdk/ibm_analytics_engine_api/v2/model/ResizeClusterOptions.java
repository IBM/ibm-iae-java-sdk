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
package com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The resizeCluster options.
 */
public class ResizeClusterOptions extends GenericModel {

  protected String instanceGuid;
  protected ResizeClusterRequest body;

  /**
   * Builder.
   */
  public static class Builder {
    private String instanceGuid;
    private ResizeClusterRequest body;

    private Builder(ResizeClusterOptions resizeClusterOptions) {
      this.instanceGuid = resizeClusterOptions.instanceGuid;
      this.body = resizeClusterOptions.body;
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
     * @param body the body
     */
    public Builder(String instanceGuid, ResizeClusterRequest body) {
      this.instanceGuid = instanceGuid;
      this.body = body;
    }

    /**
     * Builds a ResizeClusterOptions.
     *
     * @return the new ResizeClusterOptions instance
     */
    public ResizeClusterOptions build() {
      return new ResizeClusterOptions(this);
    }

    /**
     * Set the instanceGuid.
     *
     * @param instanceGuid the instanceGuid
     * @return the ResizeClusterOptions builder
     */
    public Builder instanceGuid(String instanceGuid) {
      this.instanceGuid = instanceGuid;
      return this;
    }

    /**
     * Set the body.
     *
     * @param body the body
     * @return the ResizeClusterOptions builder
     */
    public Builder body(ResizeClusterRequest body) {
      this.body = body;
      return this;
    }
  }

  protected ResizeClusterOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.instanceGuid,
      "instanceGuid cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.body,
      "body cannot be null");
    instanceGuid = builder.instanceGuid;
    body = builder.body;
  }

  /**
   * New builder.
   *
   * @return a ResizeClusterOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the instanceGuid.
   *
   * Service instance GUID.
   *
   * @return the instanceGuid
   */
  public String instanceGuid() {
    return instanceGuid;
  }

  /**
   * Gets the body.
   *
   * Expected size of the cluster after the resize operation. If the number of nodes in the cluster is 5 and you want to
   * add 2 nodes, specify 7.
   *
   * @return the body
   */
  public ResizeClusterRequest body() {
    return body;
  }
}

