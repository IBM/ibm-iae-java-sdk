/*
 * (C) Copyright IBM Corp. 2023.
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
 * (deprecated) Response of logging API.
 */
public class LoggingConfigurationResponse extends GenericModel {

  protected List<String> components;
  @SerializedName("log_server")
  protected LoggingConfigurationResponseLogServer logServer;
  protected Boolean enable;

  protected LoggingConfigurationResponse() { }

  /**
   * Gets the components.
   *
   * component array.
   *
   * @return the components
   */
  public List<String> getComponents() {
    return components;
  }

  /**
   * Gets the logServer.
   *
   * log server properties.
   *
   * @return the logServer
   */
  public LoggingConfigurationResponseLogServer getLogServer() {
    return logServer;
  }

  /**
   * Gets the enable.
   *
   * enable.
   *
   * @return the enable
   */
  public Boolean isEnable() {
    return enable;
  }
}

