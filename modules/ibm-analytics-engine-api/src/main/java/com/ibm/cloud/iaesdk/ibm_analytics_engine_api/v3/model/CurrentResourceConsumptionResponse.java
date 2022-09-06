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
 * Current resource consumption of the instance.
 */
public class CurrentResourceConsumptionResponse extends GenericModel {

  protected String cores;
  protected String memory;

  /**
   * Gets the cores.
   *
   * Number of virtual processor cores used.
   *
   * @return the cores
   */
  public String getCores() {
    return cores;
  }

  /**
   * Gets the memory.
   *
   * Amount of memory used.
   *
   * @return the memory
   */
  public String getMemory() {
    return memory;
  }
}

