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

import java.util.Date;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Status of the Spark history server.
 */
public class SparkHistoryServerResponse extends GenericModel {

  /**
   * State of the Spark history server.
   */
  public interface State {
    /** started. */
    String STARTED = "started";
    /** stopped. */
    String STOPPED = "stopped";
  }

  protected String state;
  protected String cores;
  protected String memory;
  @SerializedName("start_time")
  protected Date startTime;
  @SerializedName("stop_time")
  protected Date stopTime;
  @SerializedName("auto_termination_time")
  protected Date autoTerminationTime;

  protected SparkHistoryServerResponse() { }

  /**
   * Gets the state.
   *
   * State of the Spark history server.
   *
   * @return the state
   */
  public String getState() {
    return state;
  }

  /**
   * Gets the cores.
   *
   * Number of cpu cores used by the Spark history server.
   *
   * @return the cores
   */
  public String getCores() {
    return cores;
  }

  /**
   * Gets the memory.
   *
   * Amount of memory used by the Spark history server.
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
  public Date getStartTime() {
    return startTime;
  }

  /**
   * Gets the stopTime.
   *
   * Time when the Spark history server was stopped.
   *
   * @return the stopTime
   */
  public Date getStopTime() {
    return stopTime;
  }

  /**
   * Gets the autoTerminationTime.
   *
   * Time when the Spark history server will be stopped automatically.
   *
   * @return the autoTerminationTime
   */
  public Date getAutoTerminationTime() {
    return autoTerminationTime;
  }
}

