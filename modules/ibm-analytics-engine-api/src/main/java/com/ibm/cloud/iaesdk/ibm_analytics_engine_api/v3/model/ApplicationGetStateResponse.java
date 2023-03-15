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
 * State of a given application.
 */
public class ApplicationGetStateResponse extends GenericModel {

  /**
   * State of the Spark application.
   */
  public interface State {
    /** finished. */
    String FINISHED = "finished";
    /** running. */
    String RUNNING = "running";
    /** failed. */
    String FAILED = "failed";
    /** accepted. */
    String ACCEPTED = "accepted";
    /** stopped. */
    String STOPPED = "stopped";
    /** auto_terminated. */
    String AUTO_TERMINATED = "auto_terminated";
    /** ops_terminated. */
    String OPS_TERMINATED = "ops_terminated";
  }

  protected String id;
  protected String state;
  @SerializedName("start_time")
  protected Date startTime;
  @SerializedName("end_time")
  protected Date endTime;
  @SerializedName("finish_time")
  protected Date finishTime;
  @SerializedName("auto_termination_time")
  protected Date autoTerminationTime;

  protected ApplicationGetStateResponse() { }

  /**
   * Gets the id.
   *
   * Identifier of the application.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the state.
   *
   * State of the Spark application.
   *
   * @return the state
   */
  public String getState() {
    return state;
  }

  /**
   * Gets the startTime.
   *
   * Time when the application was started.
   *
   * @return the startTime
   */
  public Date getStartTime() {
    return startTime;
  }

  /**
   * Gets the endTime.
   *
   * Time when the application run ended in success, failure or was stopped.
   *
   * @return the endTime
   */
  public Date getEndTime() {
    return endTime;
  }

  /**
   * Gets the finishTime.
   *
   * (deprecated) Time when the application was completed.
   *
   * @return the finishTime
   * @deprecated this method is deprecated and may be removed in a future release
   */
  @Deprecated
  public Date getFinishTime() {
    return finishTime;
  }

  /**
   * Gets the autoTerminationTime.
   *
   * Time when the application will be automatically stopped by the service.
   *
   * @return the autoTerminationTime
   */
  public Date getAutoTerminationTime() {
    return autoTerminationTime;
  }
}

