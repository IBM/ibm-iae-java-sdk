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
 * Details of Analytics Engine instance.
 */
public class Instance extends GenericModel {

  /**
   * State of the Analytics Engine instance.
   */
  public interface State {
    /** creation_accepted. */
    String CREATION_ACCEPTED = "creation_accepted";
    /** initialized. */
    String INITIALIZED = "initialized";
    /** preparing. */
    String PREPARING = "preparing";
    /** active. */
    String ACTIVE = "active";
    /** deleted. */
    String DELETED = "deleted";
    /** disabled. */
    String DISABLED = "disabled";
    /** creation_failed. */
    String CREATION_FAILED = "creation_failed";
  }

  protected String id;
  protected String href;
  protected String state;
  @SerializedName("state_change_time")
  protected Date stateChangeTime;
  @SerializedName("default_runtime")
  protected Runtime defaultRuntime;
  @SerializedName("instance_home")
  protected InstanceHome instanceHome;
  @SerializedName("default_config")
  protected InstanceDefaultConfig defaultConfig;

  protected Instance() { }

  /**
   * Gets the id.
   *
   * GUID of the Analytics Engine instance.
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
   * Gets the state.
   *
   * State of the Analytics Engine instance.
   *
   * @return the state
   */
  public String getState() {
    return state;
  }

  /**
   * Gets the stateChangeTime.
   *
   * Timestamp when the state of the instance was changed, in the format YYYY-MM-DDTHH:mm:ssZ.
   *
   * @return the stateChangeTime
   */
  public Date getStateChangeTime() {
    return stateChangeTime;
  }

  /**
   * Gets the defaultRuntime.
   *
   * Runtime enviroment for applications and other workloads.
   *
   * @return the defaultRuntime
   */
  public Runtime getDefaultRuntime() {
    return defaultRuntime;
  }

  /**
   * Gets the instanceHome.
   *
   * Object storage instance that acts as the home for custom libraries and Spark events.
   *
   * @return the instanceHome
   */
  public InstanceHome getInstanceHome() {
    return instanceHome;
  }

  /**
   * Gets the defaultConfig.
   *
   * Instance level default configuration for Spark workloads.
   *
   * @return the defaultConfig
   */
  public InstanceDefaultConfig getDefaultConfig() {
    return defaultConfig;
  }
}

