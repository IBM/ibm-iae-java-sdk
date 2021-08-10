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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * ResizeClusterRequest.
 *
 * Classes which extend this class:
 * - ResizeClusterRequestAnalyticsEngineResizeClusterByComputeNodesRequest
 * - ResizeClusterRequestAnalyticsEngineResizeClusterByTaskNodesRequest
 */
public class ResizeClusterRequest extends GenericModel {

  @SerializedName("compute_nodes_count")
  protected Long computeNodesCount;
  @SerializedName("task_nodes_count")
  protected Long taskNodesCount;

  protected ResizeClusterRequest() {
  }

  /**
   * Gets the computeNodesCount.
   *
   * Expected number of compute nodes in the cluster after the resize operation.
   *
   * @return the computeNodesCount
   */
  public Long computeNodesCount() {
    return computeNodesCount;
  }

  /**
   * Gets the taskNodesCount.
   *
   * Expected number of task nodes in the cluster after the resize operation.
   *
   * @return the taskNodesCount
   */
  public Long taskNodesCount() {
    return taskNodesCount;
  }
}

