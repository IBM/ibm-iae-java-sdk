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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The getInstanceState options.
 */
public class GetInstanceStateOptions extends GenericModel {

  protected String instanceId;

  /**
   * Builder.
   */
  public static class Builder {
    private String instanceId;

    /**
     * Instantiates a new Builder from an existing GetInstanceStateOptions instance.
     *
     * @param getInstanceStateOptions the instance to initialize the Builder with
     */
    private Builder(GetInstanceStateOptions getInstanceStateOptions) {
      this.instanceId = getInstanceStateOptions.instanceId;
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
     * Builds a GetInstanceStateOptions.
     *
     * @return the new GetInstanceStateOptions instance
     */
    public GetInstanceStateOptions build() {
      return new GetInstanceStateOptions(this);
    }

    /**
     * Set the instanceId.
     *
     * @param instanceId the instanceId
     * @return the GetInstanceStateOptions builder
     */
    public Builder instanceId(String instanceId) {
      this.instanceId = instanceId;
      return this;
    }
  }

  protected GetInstanceStateOptions() { }

  protected GetInstanceStateOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.instanceId,
      "instanceId cannot be empty");
    instanceId = builder.instanceId;
  }

  /**
   * New builder.
   *
   * @return a GetInstanceStateOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the instanceId.
   *
   * GUID of the Analytics Engine service instance to retrieve state.
   *
   * @return the instanceId
   */
  public String instanceId() {
    return instanceId;
  }
}

