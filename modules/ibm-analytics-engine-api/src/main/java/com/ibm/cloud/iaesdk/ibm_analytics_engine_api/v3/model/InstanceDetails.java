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
 * Instance details.
 */
public class InstanceDetails extends GenericModel {

  /**
   * Instance state.
   */
  public interface State {
    /** created. */
    String CREATED = "created";
    /** deleted. */
    String DELETED = "deleted";
    /** failed. */
    String FAILED = "failed";
  }

  @SerializedName("instance_id")
  protected String instanceId;
  protected String state;
  @SerializedName("state_change_time")
  protected Date stateChangeTime;
  @SerializedName("default_runtime")
  protected InstanceDetailsDefaultRuntime defaultRuntime;
  @SerializedName("instance_home")
  protected InstanceDetailsInstanceHome instanceHome;
  @SerializedName("default_config")
  protected InstanceDetailsDefaultConfig defaultConfig;

  /**
   * Gets the instanceId.
   *
   * Instance id.
   *
   * @return the instanceId
   */
  public String getInstanceId() {
    return instanceId;
  }

  /**
   * Gets the state.
   *
   * Instance state.
   *
   * @return the state
   */
  public String getState() {
    return state;
  }

  /**
   * Gets the stateChangeTime.
   *
   * Timestamp when the state of the instance was changed.
   *
   * @return the stateChangeTime
   */
  public Date getStateChangeTime() {
    return stateChangeTime;
  }

  /**
   * Gets the defaultRuntime.
   *
   * Specifies the default runtime to use for all workloads that run in this instance.
   *
   * @return the defaultRuntime
   */
  public InstanceDetailsDefaultRuntime getDefaultRuntime() {
    return defaultRuntime;
  }

  /**
   * Gets the instanceHome.
   *
   * Instance home storage associated with the instance.
   *
   * @return the instanceHome
   */
  public InstanceDetailsInstanceHome getInstanceHome() {
    return instanceHome;
  }

  /**
   * Gets the defaultConfig.
   *
   * Instance level default configuration for Spark workloads.
   *
   * @return the defaultConfig
   */
  public InstanceDetailsDefaultConfig getDefaultConfig() {
    return defaultConfig;
  }
}

