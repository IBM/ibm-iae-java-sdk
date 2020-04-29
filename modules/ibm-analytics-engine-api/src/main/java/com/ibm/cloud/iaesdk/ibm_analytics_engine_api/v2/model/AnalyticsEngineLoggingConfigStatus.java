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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Log configuration status.
 */
public class AnalyticsEngineLoggingConfigStatus extends GenericModel {

  /**
   * Node type.
   */
  public interface NodeType {
    /** management. */
    String MANAGEMENT = "management";
    /** data. */
    String DATA = "data";
  }

  @SerializedName("node_type")
  protected String nodeType;
  @SerializedName("node_id")
  protected String nodeId;
  protected String action;
  protected String status;

  /**
   * Gets the nodeType.
   *
   * Node type.
   *
   * @return the nodeType
   */
  public String getNodeType() {
    return nodeType;
  }

  /**
   * Gets the nodeId.
   *
   * Node ID.
   *
   * @return the nodeId
   */
  public String getNodeId() {
    return nodeId;
  }

  /**
   * Gets the action.
   *
   * Action.
   *
   * @return the action
   */
  public String getAction() {
    return action;
  }

  /**
   * Gets the status.
   *
   * Log configuration status.
   *
   * @return the status
   */
  public String getStatus() {
    return status;
  }
}

