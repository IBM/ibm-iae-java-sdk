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
 * The replaceInstanceDefaultRuntime options.
 */
public class ReplaceInstanceDefaultRuntimeOptions extends GenericModel {

  protected String instanceId;
  protected String sparkVersion;

  /**
   * Builder.
   */
  public static class Builder {
    private String instanceId;
    private String sparkVersion;

    private Builder(ReplaceInstanceDefaultRuntimeOptions replaceInstanceDefaultRuntimeOptions) {
      this.instanceId = replaceInstanceDefaultRuntimeOptions.instanceId;
      this.sparkVersion = replaceInstanceDefaultRuntimeOptions.sparkVersion;
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
     * Builds a ReplaceInstanceDefaultRuntimeOptions.
     *
     * @return the new ReplaceInstanceDefaultRuntimeOptions instance
     */
    public ReplaceInstanceDefaultRuntimeOptions build() {
      return new ReplaceInstanceDefaultRuntimeOptions(this);
    }

    /**
     * Set the instanceId.
     *
     * @param instanceId the instanceId
     * @return the ReplaceInstanceDefaultRuntimeOptions builder
     */
    public Builder instanceId(String instanceId) {
      this.instanceId = instanceId;
      return this;
    }

    /**
     * Set the sparkVersion.
     *
     * @param sparkVersion the sparkVersion
     * @return the ReplaceInstanceDefaultRuntimeOptions builder
     */
    public Builder sparkVersion(String sparkVersion) {
      this.sparkVersion = sparkVersion;
      return this;
    }

    /**
     * Set the runtime.
     *
     * @param runtime the runtime
     * @return the ReplaceInstanceDefaultRuntimeOptions builder
     */
    public Builder runtime(Runtime runtime) {
      this.sparkVersion = runtime.sparkVersion();
      return this;
    }
  }

  protected ReplaceInstanceDefaultRuntimeOptions() { }

  protected ReplaceInstanceDefaultRuntimeOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.instanceId,
      "instanceId cannot be empty");
    instanceId = builder.instanceId;
    sparkVersion = builder.sparkVersion;
  }

  /**
   * New builder.
   *
   * @return a ReplaceInstanceDefaultRuntimeOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the instanceId.
   *
   * The ID of the Analytics Engine instance.
   *
   * @return the instanceId
   */
  public String instanceId() {
    return instanceId;
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

