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
 * The stopSparkHistoryServer options.
 */
public class StopSparkHistoryServerOptions extends GenericModel {

  protected String instanceId;

  /**
   * Builder.
   */
  public static class Builder {
    private String instanceId;

    private Builder(StopSparkHistoryServerOptions stopSparkHistoryServerOptions) {
      this.instanceId = stopSparkHistoryServerOptions.instanceId;
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
     * Builds a StopSparkHistoryServerOptions.
     *
     * @return the new StopSparkHistoryServerOptions instance
     */
    public StopSparkHistoryServerOptions build() {
      return new StopSparkHistoryServerOptions(this);
    }

    /**
     * Set the instanceId.
     *
     * @param instanceId the instanceId
     * @return the StopSparkHistoryServerOptions builder
     */
    public Builder instanceId(String instanceId) {
      this.instanceId = instanceId;
      return this;
    }
  }

  protected StopSparkHistoryServerOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.instanceId,
      "instanceId cannot be empty");
    instanceId = builder.instanceId;
  }

  /**
   * New builder.
   *
   * @return a StopSparkHistoryServerOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the instanceId.
   *
   * The identifier of the instance for which the Spark history server is stopped.
   *
   * @return the instanceId
   */
  public String instanceId() {
    return instanceId;
  }
}

