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
 * Details of a Spark application.
 */
public class Application extends GenericModel {

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

  protected String id;
  protected String href;
  protected Runtime runtime;
  @SerializedName("spark_application_id")
  protected String sparkApplicationId;
  @SerializedName("spark_application_name")
  protected String sparkApplicationName;
  protected String state;
  @SerializedName("start_time")
  protected String startTime;
  @SerializedName("end_time")
  protected String endTime;
  @SerializedName("finish_time")
  protected String finishTime;

  /**
   * Gets the id.
   *
   * Identifier provided by Analytics Engine service for the Spark application.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the href.
   *
   * Full URL of the resource.
   *
   * @return the href
   */
  public String getHref() {
    return href;
  }

  /**
   * Gets the runtime.
   *
   * Runtime enviroment for applications and other workloads.
   *
   * @return the runtime
   */
  public Runtime getRuntime() {
    return runtime;
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
   * Gets the startTime.
   *
   * Time when the application was started.
   *
   * @return the startTime
   */
  public String getStartTime() {
    return startTime;
  }

  /**
   * Gets the endTime.
   *
   * Time when the application run ended in success, failure or was stopped.
   *
   * @return the endTime
   */
  public String getEndTime() {
    return endTime;
  }

  /**
   * Gets the finishTime.
   *
   * Time when the application was completed.
   *
   * @return the finishTime
   */
  public String getFinishTime() {
    return finishTime;
  }
}

