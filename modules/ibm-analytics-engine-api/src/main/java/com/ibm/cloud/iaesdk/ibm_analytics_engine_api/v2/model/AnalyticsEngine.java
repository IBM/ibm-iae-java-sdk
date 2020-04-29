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
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Analytics Engine cluster details.
 */
public class AnalyticsEngine extends GenericModel {

  protected String id;
  protected String name;
  @SerializedName("service_plan")
  protected String servicePlan;
  @SerializedName("hardware_size")
  protected String hardwareSize;
  @SerializedName("software_package")
  protected String softwarePackage;
  protected String domain;
  @SerializedName("creation_time")
  protected Date creationTime;
  @SerializedName("commision_time")
  protected Date commisionTime;
  @SerializedName("decommision_time")
  protected Date decommisionTime;
  @SerializedName("deletion_time")
  protected Date deletionTime;
  @SerializedName("state_change_time")
  protected Date stateChangeTime;
  protected String state;
  protected List<AnalyticsEngineClusterNode> nodes;
  @SerializedName("user_credentials")
  protected AnalyticsEngineUserCredentials userCredentials;
  @SerializedName("service_endpoints")
  protected ServiceEndpoints serviceEndpoints;
  @SerializedName("service_endpoints_ip")
  protected ServiceEndpoints serviceEndpointsIp;

  /**
   * Gets the id.
   *
   * Instance GUID.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the name.
   *
   * Analytics Engine.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the servicePlan.
   *
   * ID of Analytics Engine service plan.
   *
   * @return the servicePlan
   */
  public String getServicePlan() {
    return servicePlan;
  }

  /**
   * Gets the hardwareSize.
   *
   * Hardware size.
   *
   * @return the hardwareSize
   */
  public String getHardwareSize() {
    return hardwareSize;
  }

  /**
   * Gets the softwarePackage.
   *
   * Software package.
   *
   * @return the softwarePackage
   */
  public String getSoftwarePackage() {
    return softwarePackage;
  }

  /**
   * Gets the domain.
   *
   * Domain.
   *
   * @return the domain
   */
  public String getDomain() {
    return domain;
  }

  /**
   * Gets the creationTime.
   *
   * Cluster creation time.
   *
   * @return the creationTime
   */
  public Date getCreationTime() {
    return creationTime;
  }

  /**
   * Gets the commisionTime.
   *
   * Cluster commision time.
   *
   * @return the commisionTime
   */
  public Date getCommisionTime() {
    return commisionTime;
  }

  /**
   * Gets the decommisionTime.
   *
   * Cluster decommision time.
   *
   * @return the decommisionTime
   */
  public Date getDecommisionTime() {
    return decommisionTime;
  }

  /**
   * Gets the deletionTime.
   *
   * Cluster deletion time.
   *
   * @return the deletionTime
   */
  public Date getDeletionTime() {
    return deletionTime;
  }

  /**
   * Gets the stateChangeTime.
   *
   * Cluster state change time.
   *
   * @return the stateChangeTime
   */
  public Date getStateChangeTime() {
    return stateChangeTime;
  }

  /**
   * Gets the state.
   *
   * Cluster state.
   *
   * @return the state
   */
  public String getState() {
    return state;
  }

  /**
   * Gets the nodes.
   *
   * List of nodes in the cluster.
   *
   * @return the nodes
   */
  public List<AnalyticsEngineClusterNode> getNodes() {
    return nodes;
  }

  /**
   * Gets the userCredentials.
   *
   * User credentials.
   *
   * @return the userCredentials
   */
  public AnalyticsEngineUserCredentials getUserCredentials() {
    return userCredentials;
  }

  /**
   * Gets the serviceEndpoints.
   *
   * Service endpoint URLs with host names. Endpoints will vary based on software package chosen for the cluster.
   *
   * @return the serviceEndpoints
   */
  public ServiceEndpoints getServiceEndpoints() {
    return serviceEndpoints;
  }

  /**
   * Gets the serviceEndpointsIp.
   *
   * Service endpoint URLs with host IPS. Endpoints will vary based on software package chosen for the cluster.
   *
   * @return the serviceEndpointsIp
   */
  public ServiceEndpoints getServiceEndpointsIp() {
    return serviceEndpointsIp;
  }
}

