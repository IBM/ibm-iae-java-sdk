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
 * ResizeClusterRequestAnalyticsEngineResizeClusterByTaskNodesRequest.
 */
public class ResizeClusterRequestAnalyticsEngineResizeClusterByTaskNodesRequest extends ResizeClusterRequest {


  /**
   * Builder.
   */
  public static class Builder {
    private Long taskNodesCount;

    public Builder(ResizeClusterRequest resizeClusterRequestAnalyticsEngineResizeClusterByTaskNodesRequest) {
      this.taskNodesCount = resizeClusterRequestAnalyticsEngineResizeClusterByTaskNodesRequest.taskNodesCount;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a ResizeClusterRequestAnalyticsEngineResizeClusterByTaskNodesRequest.
     *
     * @return the new ResizeClusterRequestAnalyticsEngineResizeClusterByTaskNodesRequest instance
     */
    public ResizeClusterRequestAnalyticsEngineResizeClusterByTaskNodesRequest build() {
      return new ResizeClusterRequestAnalyticsEngineResizeClusterByTaskNodesRequest(this);
    }

    /**
     * Set the taskNodesCount.
     *
     * @param taskNodesCount the taskNodesCount
     * @return the ResizeClusterRequestAnalyticsEngineResizeClusterByTaskNodesRequest builder
     */
    public Builder taskNodesCount(long taskNodesCount) {
      this.taskNodesCount = taskNodesCount;
      return this;
    }
  }

  protected ResizeClusterRequestAnalyticsEngineResizeClusterByTaskNodesRequest(Builder builder) {
    taskNodesCount = builder.taskNodesCount;
  }

  /**
   * New builder.
   *
   * @return a ResizeClusterRequestAnalyticsEngineResizeClusterByTaskNodesRequest builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}

