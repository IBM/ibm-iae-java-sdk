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
 * Customization run details for the node.
 */
public class AnalyticsEngineNodeLevelCustomizationRunDetails extends GenericModel {

  @SerializedName("node_name")
  protected String nodeName;
  @SerializedName("node_type")
  protected String nodeType;
  @SerializedName("start_time")
  protected String startTime;
  @SerializedName("end_time")
  protected String endTime;
  @SerializedName("time_taken")
  protected String timeTaken;
  protected String status;
  @SerializedName("log_file")
  protected String logFile;

  /**
   * Gets the nodeName.
   *
   * Node name.
   *
   * @return the nodeName
   */
  public String getNodeName() {
    return nodeName;
  }

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
   * Gets the startTime.
   *
   * Customization request start time.
   *
   * @return the startTime
   */
  public String getStartTime() {
    return startTime;
  }

  /**
   * Gets the endTime.
   *
   * Customization request end time.
   *
   * @return the endTime
   */
  public String getEndTime() {
    return endTime;
  }

  /**
   * Gets the timeTaken.
   *
   * Total time taken for customization request.
   *
   * @return the timeTaken
   */
  public String getTimeTaken() {
    return timeTaken;
  }

  /**
   * Gets the status.
   *
   * Status of customization request.
   *
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * Gets the logFile.
   *
   * Log file to track for customization run information.
   *
   * @return the logFile
   */
  public String getLogFile() {
    return logFile;
  }
}

