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

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Log forwarding configuration details.
 */
public class LogForwardingConfigResponse extends GenericModel {

  protected List<String> sources;
  protected List<String> tags;
  @SerializedName("log_server")
  protected LogForwardingConfigResponseLogServer logServer;
  protected Boolean enabled;

  /**
   * Gets the sources.
   *
   * List of sources of logs that are being forwarded.
   *
   * @return the sources
   */
  public List<String> getSources() {
    return sources;
  }

  /**
   * Gets the tags.
   *
   * List of tags that are applied to the logs being forwarded.
   *
   * @return the tags
   */
  public List<String> getTags() {
    return tags;
  }

  /**
   * Gets the logServer.
   *
   * Log server properties.
   *
   * @return the logServer
   */
  public LogForwardingConfigResponseLogServer getLogServer() {
    return logServer;
  }

  /**
   * Gets the enabled.
   *
   * Indicates whether log forwarding is enabled or not.
   *
   * @return the enabled
   */
  public Boolean isEnabled() {
    return enabled;
  }
}

