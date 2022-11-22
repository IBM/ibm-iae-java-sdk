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

import java.util.Date;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Response of the Application Get API.
 */
public class ApplicationGetResponse extends GenericModel {

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
    /** error. */
    String ERROR = "error";
    /** accepted. */
    String ACCEPTED = "accepted";
    /** submitted. */
    String SUBMITTED = "submitted";
    /** waiting. */
    String WAITING = "waiting";
    /** unknown. */
    String UNKNOWN = "unknown";
    /** stopped. */
    String STOPPED = "stopped";
    /** auto_terminated. */
    String AUTO_TERMINATED = "auto_terminated";
    /** ops_terminated. */
    String OPS_TERMINATED = "ops_terminated";
  }

  @SerializedName("application_details")
  protected ApplicationDetails applicationDetails;
  protected String id;
  @SerializedName("spark_application_id")
  protected String sparkApplicationId;
  @SerializedName("spark_application_name")
  protected String sparkApplicationName;
  protected String state;
  @SerializedName("state_details")
  protected List<ApplicationGetResponseStateDetailsItem> stateDetails;
  @SerializedName("start_time")
  protected Date startTime;
  @SerializedName("end_time")
  protected Date endTime;
  @SerializedName("finish_time")
  protected Date finishTime;

  /**
   * Gets the applicationDetails.
   *
   * Application details.
   *
   * @return the applicationDetails
   */
  public ApplicationDetails getApplicationDetails() {
    return applicationDetails;
  }

  /**
   * Gets the id.
   *
   * Application ID.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the sparkApplicationId.
   *
   * Identifier provided by Apache Spark for the application.
   *
   * @return the sparkApplicationId
   */
  public String getSparkApplicationId() {
    return sparkApplicationId;
  }

  /**
   * Gets the sparkApplicationName.
   *
   * Name of the Spark application.
   *
   * @return the sparkApplicationName
   */
  public String getSparkApplicationName() {
    return sparkApplicationName;
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
   * Gets the stateDetails.
   *
   * List of additional information messages on the current state of the application.
   *
   * @return the stateDetails
   */
  public List<ApplicationGetResponseStateDetailsItem> getStateDetails() {
    return stateDetails;
  }

  /**
   * Gets the startTime.
   *
   * Application start time in the format YYYY-MM-DDTHH:mm:ssZ.
   *
   * @return the startTime
   */
  public Date getStartTime() {
    return startTime;
  }

  /**
   * Gets the endTime.
   *
   * Application end time in the format YYYY-MM-DDTHH:mm:ssZ.
   *
   * @return the endTime
   */
  public Date getEndTime() {
    return endTime;
  }

  /**
   * Gets the finishTime.
   *
   * Application finish time in the format YYYY-MM-DDTHH:mm:ssZ.
   *
   * @return the finishTime
   */
  public Date getFinishTime() {
    return finishTime;
  }
}

