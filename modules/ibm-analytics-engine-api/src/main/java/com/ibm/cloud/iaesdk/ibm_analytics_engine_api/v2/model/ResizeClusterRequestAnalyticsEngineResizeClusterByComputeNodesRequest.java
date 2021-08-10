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

/**
 * Resize cluster request.
 */
public class ResizeClusterRequestAnalyticsEngineResizeClusterByComputeNodesRequest extends ResizeClusterRequest {


  /**
   * Builder.
   */
  public static class Builder {
    private Long computeNodesCount;

    public Builder(ResizeClusterRequest resizeClusterRequestAnalyticsEngineResizeClusterByComputeNodesRequest) {
      this.computeNodesCount = resizeClusterRequestAnalyticsEngineResizeClusterByComputeNodesRequest.computeNodesCount;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a ResizeClusterRequestAnalyticsEngineResizeClusterByComputeNodesRequest.
     *
     * @return the new ResizeClusterRequestAnalyticsEngineResizeClusterByComputeNodesRequest instance
     */
    public ResizeClusterRequestAnalyticsEngineResizeClusterByComputeNodesRequest build() {
      return new ResizeClusterRequestAnalyticsEngineResizeClusterByComputeNodesRequest(this);
    }

    /**
     * Set the computeNodesCount.
     *
     * @param computeNodesCount the computeNodesCount
     * @return the ResizeClusterRequestAnalyticsEngineResizeClusterByComputeNodesRequest builder
     */
    public Builder computeNodesCount(long computeNodesCount) {
      this.computeNodesCount = computeNodesCount;
      return this;
    }
  }

  protected ResizeClusterRequestAnalyticsEngineResizeClusterByComputeNodesRequest(Builder builder) {
    computeNodesCount = builder.computeNodesCount;
  }

  /**
   * New builder.
   *
   * @return a ResizeClusterRequestAnalyticsEngineResizeClusterByComputeNodesRequest builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}

