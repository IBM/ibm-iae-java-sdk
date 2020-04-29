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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The resizeCluster options.
 */
public class ResizeClusterOptions extends GenericModel {

  protected String instanceGuid;
  protected Long computeNodesCount;

  /**
   * Builder.
   */
  public static class Builder {
    private String instanceGuid;
    private Long computeNodesCount;

    private Builder(ResizeClusterOptions resizeClusterOptions) {
      this.instanceGuid = resizeClusterOptions.instanceGuid;
      this.computeNodesCount = resizeClusterOptions.computeNodesCount;
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
     * Set the computeNodesCount.
     *
     * @param computeNodesCount the computeNodesCount
     * @return the ResizeClusterOptions builder
     */
    public Builder computeNodesCount(long computeNodesCount) {
      this.computeNodesCount = computeNodesCount;
      return this;
    }
  }

  protected ResizeClusterOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.instanceGuid,
      "instanceGuid cannot be empty");
    instanceGuid = builder.instanceGuid;
    computeNodesCount = builder.computeNodesCount;
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
   * Gets the computeNodesCount.
   *
   * Expected number of nodes in the cluster after the resize operation.
   *
   * @return the computeNodesCount
   */
  public Long computeNodesCount() {
    return computeNodesCount;
  }
}

