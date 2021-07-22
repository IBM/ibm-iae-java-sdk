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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Response of the Application Get API.
 */
public class ApplicationGetResponse extends GenericModel {

  @SerializedName("application_details")
  protected ApplicationRequest applicationDetails;
  protected String mode;
  @SerializedName("application_id")
  protected String applicationId;
  protected String state;
  @SerializedName("start_time")
  protected String startTime;
  @SerializedName("finish_time")
  protected String finishTime;

  /**
   * Gets the applicationDetails.
   *
   * Application request details.
   *
   * @return the applicationDetails
   */
  public ApplicationRequest getApplicationDetails() {
    return applicationDetails;
  }

  /**
   * Gets the mode.
   *
   * Application mode.
   *
   * @return the mode
   */
  public String getMode() {
    return mode;
  }

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
  public String getStartTime() {
    return startTime;
  }

  /**
   * Gets the finishTime.
   *
   * Application end time.
   *
   * @return the finishTime
   */
  public String getFinishTime() {
    return finishTime;
  }
}

