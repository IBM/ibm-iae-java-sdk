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
package com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model;

import java.util.Date;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Application response details.
 */
public class ApplicationResponse extends GenericModel {

  /**
   * Application state.
   */
  public interface State {
    /** accepted. */
    String ACCEPTED = "accepted";
    /** finished. */
    String FINISHED = "finished";
    /** killed. */
    String KILLED = "killed";
    /** failed. */
    String FAILED = "failed";
    /** error. */
    String ERROR = "error";
    /** running. */
    String RUNNING = "running";
    /** submitted. */
    String SUBMITTED = "submitted";
    /** stopped. */
    String STOPPED = "stopped";
    /** waiting. */
    String WAITING = "waiting";
  }

  @SerializedName("application_id")
  protected String applicationId;
  protected String state;
  @SerializedName("start_time")
  protected Date startTime;

  /**
   * Gets the applicationId.
   *
   * Application ID.
   *
   * @return the applicationId
   */
  public String getApplicationId() {
    return applicationId;
  }

  /**
   * Gets the state.
   *
   * Application state.
   *
   * @return the state
   */
  public String getState() {
    return state;
  }

  /**
   * Gets the startTime.
   *
   * Application start time.
   *
   * @return the startTime
   */
  public Date getStartTime() {
    return startTime;
  }
}

