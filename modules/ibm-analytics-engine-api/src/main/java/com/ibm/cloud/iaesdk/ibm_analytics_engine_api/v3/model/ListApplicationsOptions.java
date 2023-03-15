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

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The listApplications options.
 */
public class ListApplicationsOptions extends GenericModel {

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

  protected String instanceId;
  protected List<String> state;

  /**
   * Builder.
   */
  public static class Builder {
    private String instanceId;
    private List<String> state;

    /**
     * Instantiates a new Builder from an existing ListApplicationsOptions instance.
     *
     * @param listApplicationsOptions the instance to initialize the Builder with
     */
    private Builder(ListApplicationsOptions listApplicationsOptions) {
      this.instanceId = listApplicationsOptions.instanceId;
      this.state = listApplicationsOptions.state;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param instanceId the instanceId
     */
    public Builder(String instanceId) {
      this.instanceId = instanceId;
    }

    /**
     * Builds a ListApplicationsOptions.
     *
     * @return the new ListApplicationsOptions instance
     */
    public ListApplicationsOptions build() {
      return new ListApplicationsOptions(this);
    }

    /**
     * Adds an state to state.
     *
     * @param state the new state
     * @return the ListApplicationsOptions builder
     */
    public Builder addState(String state) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(state,
        "state cannot be null");
      if (this.state == null) {
        this.state = new ArrayList<String>();
      }
      this.state.add(state);
      return this;
    }

    /**
     * Set the instanceId.
     *
     * @param instanceId the instanceId
     * @return the ListApplicationsOptions builder
     */
    public Builder instanceId(String instanceId) {
      this.instanceId = instanceId;
      return this;
    }

    /**
     * Set the state.
     * Existing state will be replaced.
     *
     * @param state the state
     * @return the ListApplicationsOptions builder
     */
    public Builder state(List<String> state) {
      this.state = state;
      return this;
    }
  }

  protected ListApplicationsOptions() { }

  protected ListApplicationsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.instanceId,
      "instanceId cannot be empty");
    instanceId = builder.instanceId;
    state = builder.state;
  }

  /**
   * New builder.
   *
   * @return a ListApplicationsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the instanceId.
   *
   * The identifier of the Analytics Engine instance associated with the Spark application(s).
   *
   * @return the instanceId
   */
  public String instanceId() {
    return instanceId;
  }

  /**
   * Gets the state.
   *
   * List of Spark application states that will be used to filter the response.
   *
   * @return the state
   */
  public List<String> state() {
    return state;
  }
}

