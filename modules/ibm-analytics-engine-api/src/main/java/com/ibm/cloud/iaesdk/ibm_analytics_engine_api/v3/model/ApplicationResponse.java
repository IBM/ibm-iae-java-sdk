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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Application response details.
 */
public class ApplicationResponse extends GenericModel {

  /**
   * State of the submitted application.
   */
  public interface State {
    /** accepted. */
    String ACCEPTED = "accepted";
    /** failed. */
    String FAILED = "failed";
    /** error. */
    String ERROR = "error";
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
   * State of the submitted application.
   *
   * @return the state
   */
  public String getState() {
    return state;
  }
}

