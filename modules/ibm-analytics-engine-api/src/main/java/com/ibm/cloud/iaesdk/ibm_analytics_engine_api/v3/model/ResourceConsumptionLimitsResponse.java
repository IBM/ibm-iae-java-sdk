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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Resource consumption limits for the instance.
 */
public class ResourceConsumptionLimitsResponse extends GenericModel {

  @SerializedName("max_cores")
  protected String maxCores;
  @SerializedName("max_memory")
  protected String maxMemory;

  protected ResourceConsumptionLimitsResponse() { }

  /**
   * Gets the maxCores.
   *
   * Maximum number of virtual processor cores that be used in the instance.
   *
   * @return the maxCores
   */
  public String getMaxCores() {
    return maxCores;
  }

  /**
   * Gets the maxMemory.
   *
   * Maximum memory that can be used in the instance.
   *
   * @return the maxMemory
   */
  public String getMaxMemory() {
    return maxMemory;
  }
}

