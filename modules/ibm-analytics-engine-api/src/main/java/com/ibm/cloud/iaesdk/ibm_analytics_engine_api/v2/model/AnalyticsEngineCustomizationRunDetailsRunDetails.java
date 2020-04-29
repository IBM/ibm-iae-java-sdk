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

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Customization run details.
 */
public class AnalyticsEngineCustomizationRunDetailsRunDetails extends GenericModel {

  @SerializedName("overall_status")
  protected String overallStatus;
  protected List<AnalyticsEngineNodeLevelCustomizationRunDetails> details;

  /**
   * Gets the overallStatus.
   *
   * Customization run overall status.
   *
   * @return the overallStatus
   */
  public String getOverallStatus() {
    return overallStatus;
  }

  /**
   * Gets the details.
   *
   * Customization run details for each node.
   *
   * @return the details
   */
  public List<AnalyticsEngineNodeLevelCustomizationRunDetails> getDetails() {
    return details;
  }
}

