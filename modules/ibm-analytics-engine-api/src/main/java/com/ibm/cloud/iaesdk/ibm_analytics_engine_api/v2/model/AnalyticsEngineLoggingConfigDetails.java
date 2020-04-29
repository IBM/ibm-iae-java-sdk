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

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Logging configuration.
 */
public class AnalyticsEngineLoggingConfigDetails extends GenericModel {

  @SerializedName("log_specs")
  protected List<AnalyticsEngineLoggingNodeSpec> logSpecs;
  @SerializedName("log_server")
  protected AnalyticsEngineLoggingServer logServer;
  @SerializedName("log_config_status")
  protected List<AnalyticsEngineLoggingConfigStatus> logConfigStatus;

  /**
   * Gets the logSpecs.
   *
   * Log specifications for nodes.
   *
   * @return the logSpecs
   */
  public List<AnalyticsEngineLoggingNodeSpec> getLogSpecs() {
    return logSpecs;
  }

  /**
   * Gets the logServer.
   *
   * Logging server configuration.
   *
   * @return the logServer
   */
  public AnalyticsEngineLoggingServer getLogServer() {
    return logServer;
  }

  /**
   * Gets the logConfigStatus.
   *
   * Log configuration status.
   *
   * @return the logConfigStatus
   */
  public List<AnalyticsEngineLoggingConfigStatus> getLogConfigStatus() {
    return logConfigStatus;
  }
}

