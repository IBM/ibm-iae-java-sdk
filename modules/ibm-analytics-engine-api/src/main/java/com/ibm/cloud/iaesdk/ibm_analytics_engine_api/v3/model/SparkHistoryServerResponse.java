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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * State of Spark history server.
 */
public class SparkHistoryServerResponse extends GenericModel {

  protected String state;
  protected String cores;
  protected String memory;
  @SerializedName("start_time")
  protected String startTime;
  @SerializedName("stop_time")
  protected String stopTime;

  /**
   * Gets the state.
   *
   * State of Spark history server.
   *
   * @return the state
   */
  public String getState() {
    return state;
  }

  /**
   * Gets the cores.
   *
   * Number of cores used for the Spark history server.
   *
   * @return the cores
   */
  public String getCores() {
    return cores;
  }

  /**
   * Gets the memory.
   *
   * Memory used for the Spark history server.
   *
   * @return the memory
   */
  public String getMemory() {
    return memory;
  }

  /**
   * Gets the startTime.
   *
   * Time when the Spark history server was started.
   *
   * @return the startTime
   */
  public String getStartTime() {
    return startTime;
  }

  /**
   * Gets the stopTime.
   *
   * Time when the Spark history server was stopped.
   *
   * @return the stopTime
   */
  public String getStopTime() {
    return stopTime;
  }
}

