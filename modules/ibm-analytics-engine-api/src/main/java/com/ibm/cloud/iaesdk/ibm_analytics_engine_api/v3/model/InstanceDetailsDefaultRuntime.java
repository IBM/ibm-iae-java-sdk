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

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Specifies the default runtime to use for all workloads that run in this instance.
 */
public class InstanceDetailsDefaultRuntime extends GenericModel {

  @SerializedName("spark_version")
  protected String sparkVersion;
  @SerializedName("additional_packages")
  protected List<String> additionalPackages;

  /**
   * Gets the sparkVersion.
   *
   * Version of Spark runtime to use. Currently, only 3.0 is supported.
   *
   * @return the sparkVersion
   */
  public String getSparkVersion() {
    return sparkVersion;
  }

  /**
   * Gets the additionalPackages.
   *
   * Add-on packages.
   *
   * @return the additionalPackages
   */
  public List<String> getAdditionalPackages() {
    return additionalPackages;
  }
}

