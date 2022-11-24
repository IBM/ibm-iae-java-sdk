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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Runtime enviroment for applications and other workloads.
 */
public class Runtime extends GenericModel {

  @SerializedName("spark_version")
  protected String sparkVersion;

  /**
   * Builder.
   */
  public static class Builder {
    private String sparkVersion;

    private Builder(Runtime runtime) {
      this.sparkVersion = runtime.sparkVersion;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a Runtime.
     *
     * @return the new Runtime instance
     */
    public Runtime build() {
      return new Runtime(this);
    }

    /**
     * Set the sparkVersion.
     *
     * @param sparkVersion the sparkVersion
     * @return the Runtime builder
     */
    public Builder sparkVersion(String sparkVersion) {
      this.sparkVersion = sparkVersion;
      return this;
    }
  }

  protected Runtime() { }

  protected Runtime(Builder builder) {
    sparkVersion = builder.sparkVersion;
  }

  /**
   * New builder.
   *
   * @return a Runtime builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the sparkVersion.
   *
   * Spark version of the runtime environment.
   *
   * @return the sparkVersion
   */
  public String sparkVersion() {
    return sparkVersion;
  }
}

