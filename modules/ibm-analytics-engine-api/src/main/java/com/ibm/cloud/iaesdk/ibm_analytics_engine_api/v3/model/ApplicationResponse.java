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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Application response details.
 */
public class ApplicationResponse extends GenericModel {

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

  /**
   * Gets the id.
   *
   * Identifier of the application that was submitted.
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
}

