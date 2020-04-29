/*
 * (C) Copyright IBM Corp. 2020.
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
package com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v2.model;

import java.util.Date;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Cluster node details.
 */
public class AnalyticsEngineClusterNode extends GenericModel {

  protected Double id;
  protected String fqdn;
  protected String type;
  protected String state;
  @SerializedName("public_ip")
  protected String publicIp;
  @SerializedName("private_ip")
  protected String privateIp;
  @SerializedName("state_change_time")
  protected Date stateChangeTime;
  @SerializedName("commission_time")
  protected Date commissionTime;

  /**
   * Gets the id.
   *
   * Node ID.
   *
   * @return the id
   */
  public Double getId() {
    return id;
  }

  /**
   * Gets the fqdn.
   *
   * Fully qualified domain name.
   *
   * @return the fqdn
   */
  public String getFqdn() {
    return fqdn;
  }

  /**
   * Gets the type.
   *
   * Node type.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * Gets the state.
   *
   * State of node.
   *
   * @return the state
   */
  public String getState() {
    return state;
  }

  /**
   * Gets the publicIp.
   *
   * Public IP address.
   *
   * @return the publicIp
   */
  public String getPublicIp() {
    return publicIp;
  }

  /**
   * Gets the privateIp.
   *
   * Private IP address.
   *
   * @return the privateIp
   */
  public String getPrivateIp() {
    return privateIp;
  }

  /**
   * Gets the stateChangeTime.
   *
   * State change time.
   *
   * @return the stateChangeTime
   */
  public Date getStateChangeTime() {
    return stateChangeTime;
  }

  /**
   * Gets the commissionTime.
   *
   * Commission time.
   *
   * @return the commissionTime
   */
  public Date getCommissionTime() {
    return commissionTime;
  }
}

