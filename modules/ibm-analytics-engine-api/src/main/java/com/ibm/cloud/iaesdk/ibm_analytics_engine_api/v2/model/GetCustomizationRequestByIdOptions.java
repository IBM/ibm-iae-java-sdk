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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The getCustomizationRequestById options.
 */
public class GetCustomizationRequestByIdOptions extends GenericModel {

  protected String instanceGuid;
  protected String requestId;

  /**
   * Builder.
   */
  public static class Builder {
    private String instanceGuid;
    private String requestId;

    private Builder(GetCustomizationRequestByIdOptions getCustomizationRequestByIdOptions) {
      this.instanceGuid = getCustomizationRequestByIdOptions.instanceGuid;
      this.requestId = getCustomizationRequestByIdOptions.requestId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param instanceGuid the instanceGuid
     * @param requestId the requestId
     */
    public Builder(String instanceGuid, String requestId) {
      this.instanceGuid = instanceGuid;
      this.requestId = requestId;
    }

    /**
     * Builds a GetCustomizationRequestByIdOptions.
     *
     * @return the new GetCustomizationRequestByIdOptions instance
     */
    public GetCustomizationRequestByIdOptions build() {
      return new GetCustomizationRequestByIdOptions(this);
    }

    /**
     * Set the instanceGuid.
     *
     * @param instanceGuid the instanceGuid
     * @return the GetCustomizationRequestByIdOptions builder
     */
    public Builder instanceGuid(String instanceGuid) {
      this.instanceGuid = instanceGuid;
      return this;
    }

    /**
     * Set the requestId.
     *
     * @param requestId the requestId
     * @return the GetCustomizationRequestByIdOptions builder
     */
    public Builder requestId(String requestId) {
      this.requestId = requestId;
      return this;
    }
  }

  protected GetCustomizationRequestByIdOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.instanceGuid,
      "instanceGuid cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.requestId,
      "requestId cannot be empty");
    instanceGuid = builder.instanceGuid;
    requestId = builder.requestId;
  }

  /**
   * New builder.
   *
   * @return a GetCustomizationRequestByIdOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the instanceGuid.
   *
   * Service instance GUID.
   *
   * @return the instanceGuid
   */
  public String instanceGuid() {
    return instanceGuid;
  }

  /**
   * Gets the requestId.
   *
   * customization request ID.
   *
   * @return the requestId
   */
  public String requestId() {
    return requestId;
  }
}

